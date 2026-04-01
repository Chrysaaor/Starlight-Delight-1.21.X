package net.chrysaor.starlightdelight.recipe;

import net.chrysaor.starlightdelight.block.ModBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.CraftingRecipeCategory;

public interface CookingTableRecipe extends Recipe<CookingTableRecipeInput> {
    @Override
    default RecipeType<?> getType() {
        return ModRecipes.COOKING_TABLE_TYPE;
    }

    CraftingRecipeCategory getCategory();

    default boolean fits(int width, int height) {
        return width >= 3 && height >= 1;
    }

    default ItemStack createIcon() {
        return new ItemStack(ModBlocks.COOKING_TABLE);
    }

}
