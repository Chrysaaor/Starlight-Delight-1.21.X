package net.chrysaor.starlightdelight.recipe;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.CraftingRecipeCategory;

public interface PreparationTableRecipe extends Recipe<PreparationTableRecipeInput> {
    @Override
    default RecipeType<?> getType() {
        return ModRecipes.PREPARATION_TABLE_TYPE;
    }

    CraftingRecipeCategory getCategory();
}