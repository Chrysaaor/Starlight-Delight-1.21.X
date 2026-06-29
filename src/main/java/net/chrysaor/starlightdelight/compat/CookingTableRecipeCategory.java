package net.chrysaor.starlightdelight.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.chrysaor.starlightdelight.StarlightDelight;
import net.chrysaor.starlightdelight.block.ModBlocks;
import net.chrysaor.starlightdelight.recipe.CookingTableRecipe;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CookingTableRecipeCategory implements IRecipeCategory<CookingTableRecipe> {
    public static final Identifier UID = Identifier.of(StarlightDelight.MOD_ID, "cooking_table");
    public static final Identifier TEXTURE = Identifier.of(StarlightDelight.MOD_ID, "textures/gui/jei/cooking_table_jei_gui.png");

    public static final RecipeType<CookingTableRecipe> COOKING_TABLE_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, CookingTableRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public CookingTableRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createDrawable(TEXTURE, 0, 0, 176, 45);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.COOKING_TABLE));
    }


    @Override
    public @NotNull RecipeType<CookingTableRecipe> getRecipeType() {
        return COOKING_TABLE_RECIPE_RECIPE_TYPE;
    }

    @Override
    public @NotNull Text getTitle() {
        return Text.translatable("block.starlightdelight.cooking_table");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CookingTableRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 11, 13).addIngredients(recipe.getInput1());
        builder.addSlot(RecipeIngredientRole.INPUT, 38, 13).addIngredients(recipe.getInput2());
        builder.addSlot(RecipeIngredientRole.INPUT, 65, 13).addIngredients(recipe.getInput3());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 120, 13).addItemStack(recipe.getOutput());
    }

    @Override
    public int getWidth() {
        return 146;
    }

    @Override
    public int getHeight() {
        return 42;
    }

    @Override
    public void draw(CookingTableRecipe recipe, IRecipeSlotsView recipeSlotsView, DrawContext guiGraphics, double mouseX, double mouseY) {
        IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
        background.draw(guiGraphics);
    }
}