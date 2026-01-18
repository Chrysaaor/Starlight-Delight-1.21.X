package net.chrysaor.starlightdelight.screen.custom;

import net.chrysaor.starlightdelight.recipe.PreparationTableRecipe;
import net.chrysaor.starlightdelight.recipe.PreparationTableRecipeInput;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.CraftingResultSlot;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.Optional;

public class PreparationTableScreenHandler  extends AbstractRecipeScreenHandler<PreparationTableRecipeInput, PreparationTableRecipe> {
    public static final int RESULT_ID = 0;
    private static final int INPUT_START = 1;
    private static final int INPUT_END = 4;
    private static final int INVENTORY_START = 4;
    private static final int INVENTORY_END = 31;
    private static final int HOTBAR_START = 31;
    private static final int HOTBAR_END = 40;
    private final RecipeInputInventory input;
    private final CraftingResultInventory result;
    private final ScreenHandlerContext context;
    private final PlayerEntity player;
    private boolean filling;


    public PreparationTableScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public PreparationTableScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(ScreenHandlerType.CRAFTING, syncId);
        this.input = new CraftingInventory(this, 3, 1);
        this.result = new CraftingResultInventory();
        this.context = context;
        this.player = playerInventory.player;
        this.addSlot(new CraftingResultSlot(playerInventory.player, this.input, this.result, 0, 124, 35));

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 1; ++j) {
                this.addSlot(new Slot(this.input, j + i * 3, 30, 17 + i * 18));
            }
        }

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }

    }

    protected static void updateResult(ScreenHandler handler, World world, PlayerEntity player, RecipeInputInventory craftingInventory, CraftingResultInventory resultInventory, RecipeEntry<PreparationTableRecipe> recipe) {
        if (!world.isClient) {
            CraftingRecipeInput craftingRecipeInput = craftingInventory.createRecipeInput();
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)player;
            ItemStack itemStack = ItemStack.EMPTY;
            Optional<RecipeEntry<CraftingRecipe>> optional = Objects.requireNonNull(world.getServer()).getRecipeManager().getFirstMatch(RecipeType.CRAFTING, craftingRecipeInput, world, recipe.id());
            if (optional.isPresent()) {
                RecipeEntry<CraftingRecipe> recipeEntry = optional.get();
                CraftingRecipe craftingRecipe = recipeEntry.value();
                if (resultInventory.shouldCraftRecipe(world, serverPlayerEntity, recipeEntry)) {
                    ItemStack itemStack2 = craftingRecipe.craft(craftingRecipeInput, world.getRegistryManager());
                    if (itemStack2.isItemEnabled(world.getEnabledFeatures())) {
                        itemStack = itemStack2;
                    }
                }
            }

            resultInventory.setStack(0, itemStack);
            handler.setPreviousTrackedSlot(0, itemStack);
            serverPlayerEntity.networkHandler.sendPacket(new ScreenHandlerSlotUpdateS2CPacket(handler.syncId, handler.nextRevision(), 0, itemStack));
        }
    }

    public void onContentChanged(Inventory inventory) {
        if (!this.filling) {
            this.context.run((world, pos) -> updateResult(this, world, this.player, this.input, this.result, null));
        }

    }

    public void onInputSlotFillStart() {
        this.filling = true;
    }

    public void onInputSlotFillFinish(RecipeEntry<PreparationTableRecipe> recipe) {
        this.filling = false;
        this.context.run((world, pos) -> updateResult(this, world, this.player, this.input, this.result, recipe));
    }

    public void populateRecipeFinder(RecipeMatcher finder) {
        this.input.provideRecipeInputs(finder);
    }

    public void clearCraftingSlots() {
        this.input.clear();
        this.result.clear();
    }

    @Override
    public boolean matches(RecipeEntry<PreparationTableRecipe> recipe) {
        return true;
    }

    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.context.run((world, pos) -> this.dropInventory(player, this.input));
    }

    public boolean canUse(PlayerEntity player) {
        return canUse(this.context, player, Blocks.CRAFTING_TABLE);
    }

    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = this.slots.get(slot);
        if (slot2.hasStack()) {
            ItemStack itemStack2 = slot2.getStack();
            itemStack = itemStack2.copy();
            if (slot == 0) {
                this.context.run((world, pos) -> itemStack2.getItem().onCraftByPlayer(itemStack2, world, player));
                if (!this.insertItem(itemStack2, 4, 40, true)) {
                    return ItemStack.EMPTY;
                }

                slot2.onQuickTransfer(itemStack2, itemStack);
            } else if (slot >= 4 && slot < 40) {
                if (!this.insertItem(itemStack2, 1, 4, false)) {
                    if (slot < 31) {
                        if (!this.insertItem(itemStack2, 31, 40, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if (!this.insertItem(itemStack2, 4, 31, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.insertItem(itemStack2, 4, 40, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot2.setStack(ItemStack.EMPTY);
            } else {
                slot2.markDirty();
            }

            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot2.onTakeItem(player, itemStack2);
            if (slot == 0) {
                player.dropItem(itemStack2, false);
            }
        }

        return itemStack;
    }

    public boolean canInsertIntoSlot(ItemStack stack, Slot slot) {
        return slot.inventory != this.result && super.canInsertIntoSlot(stack, slot);
    }

    public int getCraftingResultSlotIndex() {
        return 0;
    }

    public int getCraftingWidth() {
        return this.input.getWidth();
    }

    public int getCraftingHeight() {
        return this.input.getHeight();
    }

    public int getCraftingSlotCount() {
        return 4;
    }

    public RecipeBookCategory getCategory() {
        return RecipeBookCategory.CRAFTING;
    }

    public boolean canInsertIntoSlot(int index) {
        return index != this.getCraftingResultSlotIndex();
    }
}