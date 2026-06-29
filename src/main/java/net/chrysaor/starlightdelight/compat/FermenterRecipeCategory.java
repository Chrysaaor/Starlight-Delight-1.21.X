package net.chrysaor.starlightdelight.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.placement.HorizontalAlignment;
import mezz.jei.api.gui.placement.VerticalAlignment;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.chrysaor.starlightdelight.StarlightDelight;
import net.chrysaor.starlightdelight.block.ModBlocks;
import net.chrysaor.starlightdelight.recipe.FermenterRecipe;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FermenterRecipeCategory implements IRecipeCategory<FermenterRecipe> {
    public static final Identifier UID = Identifier.of(StarlightDelight.MOD_ID, "fermenter");
    public static final Identifier TEXTURE = Identifier.of(StarlightDelight.MOD_ID, "textures/gui/jei/fermenter_jei_gui.png");
    public final int cookingTime;
    protected final IDrawableAnimated arrow;

    public static final RecipeType<FermenterRecipe> FERMENTER_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, FermenterRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public FermenterRecipeCategory(int cookingTime, IGuiHelper guiHelper) {
        this.cookingTime = cookingTime;
        this.arrow = guiHelper.drawableBuilder(TEXTURE, 100, 0, 24, 16)
                .buildAnimated(600, IDrawableAnimated.StartDirection.LEFT, false);
        this.background = guiHelper.createDrawable(TEXTURE, 0, 0, 88, 45);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.FERMENTER));
    }


    @Override
    public @NotNull RecipeType<FermenterRecipe> getRecipeType() {
        return FERMENTER_RECIPE_RECIPE_TYPE;
    }

    @Override
    public @NotNull Text getTitle() {
        return Text.translatable("block.starlightdelight.fermenter");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public int getWidth() {
        return 88;
    }

    @Override
    public int getHeight() {
        return 40;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FermenterRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 11, 9).addIngredients(recipe.getIngredients().getFirst());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 9).addItemStack(recipe.getResult(null));
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, FermenterRecipe recipe, IFocusGroup focuses) {
        addCookTime(builder);
    }



    protected void addCookTime(IRecipeExtrasBuilder builder) {
        int cookTimeSeconds = cookingTime / 20;
        Text timeString = Text.translatable("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
        builder.addText(timeString, getWidth() - 20, 10)
                .setPosition(0, 0, getWidth(), getHeight(), HorizontalAlignment.RIGHT, VerticalAlignment.BOTTOM)
                .setTextAlignment(HorizontalAlignment.RIGHT)
                .setTextAlignment(VerticalAlignment.BOTTOM)
                .setColor(0xFF808080);
    }

    @Override
    public void draw(FermenterRecipe recipe, IRecipeSlotsView recipeSlotsView, DrawContext guiGraphics, double mouseX, double mouseY) {
        IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
        background.draw(guiGraphics);
        arrow.draw(guiGraphics, 29, 10);
    }
}