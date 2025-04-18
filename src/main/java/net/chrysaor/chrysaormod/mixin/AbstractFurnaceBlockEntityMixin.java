package net.chrysaor.chrysaormod.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LockableContainerBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeInputProvider;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.recipe.RecipeUnlocker;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AbstractFurnaceBlockEntity.class)
public class AbstractFurnaceBlockEntityMixin extends LockableContainerBlockEntity implements SidedInventory, RecipeUnlocker, RecipeInputProvider {

    @Shadow protected DefaultedList<ItemStack> inventory;
    @Shadow protected static final int INPUT_SLOT_INDEX = 0;

    protected AbstractFurnaceBlockEntityMixin(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
    }

    @Override
    public Text getContainerName() {
        return null;
    }

    @Override
    public DefaultedList<ItemStack> getHeldStacks() {
        return null;
    }

    @Override
    public void setHeldStacks(DefaultedList<ItemStack> inventory) {

    }

    @Override
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return null;
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        return new int[0];
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return false;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void provideRecipeInputs(RecipeMatcher finder) {

    }

    @Override
    public void setLastRecipe(@Nullable RecipeEntry<?> recipe) {

    }

    @Override
    public @Nullable RecipeEntry<?> getLastRecipe() {
        return null;
    }


    @WrapOperation(
            method = "craftRecipe",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;decrement(I)V")
    )
    private static void craftRecipeHandler(ItemStack instance, int amount, Operation<Void> original) {

        if (instance.isOf(Items.MILK_BUCKET)) {
            (0, new ItemStack(Items.BUCKET));
        }
    }
}