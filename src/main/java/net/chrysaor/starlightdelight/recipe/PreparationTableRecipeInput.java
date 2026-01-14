package net.chrysaor.starlightdelight.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record PreparationTableRecipeInput(ItemStack input) implements RecipeInput {

    @Override
    public ItemStack getStackInSlot(int slot) {
        return input;
    }

    @Override
    public int getSize() {
        return 1;
    }
}