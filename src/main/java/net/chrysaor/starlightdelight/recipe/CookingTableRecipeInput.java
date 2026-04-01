package net.chrysaor.starlightdelight.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record CookingTableRecipeInput(ItemStack input1, ItemStack input2, ItemStack input3) implements RecipeInput {

    @Override
    public ItemStack getStackInSlot(int slot) {
        ItemStack var10000;
        switch (slot) {
            case 0 -> var10000 = this.input1;
            case 1 -> var10000 = this.input2;
            case 2 -> var10000 = this.input3;
            default -> throw new IllegalArgumentException("Recipe does not contain slot " + slot);
        }

        return var10000;
    }

    @Override
    public int getSize() {
        return 3;
    }
}