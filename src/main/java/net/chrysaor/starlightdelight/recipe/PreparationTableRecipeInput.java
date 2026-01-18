package net.chrysaor.starlightdelight.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.recipe.input.RecipeInput;

import java.util.ArrayList;
import java.util.List;

public class PreparationTableRecipeInput implements RecipeInput {
    public static final PreparationTableRecipeInput EMPTY = new PreparationTableRecipeInput(0, 0, List.of());
    private final int width;
    private final int height;
    private final List<ItemStack> stacks;
    private final RecipeMatcher matcher = new RecipeMatcher();
    private final int stackCount;

    private PreparationTableRecipeInput(int width, int height, List<ItemStack> stacks) {
        this.width = width;
        this.height = height;
        this.stacks = stacks;
        int i = 0;

        for(ItemStack itemStack : stacks) {
            if (!itemStack.isEmpty()) {
                ++i;
                this.matcher.addInput(itemStack, 1);
            }
        }

        this.stackCount = i;
    }

    public static PreparationTableRecipeInput create(int width, int height, List<ItemStack> stacks) {
        return createPositioned(width, height, stacks).input();
    }

    public static PreparationTableRecipeInput.Positioned createPositioned(int width, int height, List<ItemStack> stacks) {
        if (width != 0 && height != 0) {
            int i = width - 1;
            int j = 0;
            int k = height - 1;
            int l = 0;

            for(int m = 0; m < height; ++m) {
                boolean bl = true;

                for(int n = 0; n < width; ++n) {
                    ItemStack itemStack = stacks.get(n + m * width);
                    if (!itemStack.isEmpty()) {
                        i = Math.min(i, n);
                        j = Math.max(j, n);
                        bl = false;
                    }
                }

                if (!bl) {
                    k = Math.min(k, m);
                    l = Math.max(l, m);
                }
            }

            int m = j - i + 1;
            int o = l - k + 1;
            if (m > 0 && o > 0) {
                if (m == width && o == height) {
                    return new PreparationTableRecipeInput.Positioned(new PreparationTableRecipeInput(width, height, stacks), i, k);
                } else {
                    List<ItemStack> list = new ArrayList<>(m * o);

                    for(int p = 0; p < o; ++p) {
                        for(int q = 0; q < m; ++q) {
                            int r = q + i + (p + k) * width;
                            list.add(stacks.get(r));
                        }
                    }

                    return new PreparationTableRecipeInput.Positioned(new PreparationTableRecipeInput(m, o, list), i, k);
                }
            } else {
                return PreparationTableRecipeInput.Positioned.EMPTY;
            }
        } else {
            return PreparationTableRecipeInput.Positioned.EMPTY;
        }
    }

    public ItemStack getStackInSlot(int slot) {
        return this.stacks.get(slot);
    }

    public ItemStack getStackInSlot(int x, int y) {
        return this.stacks.get(x + y * this.width);
    }

    public int getSize() {
        return this.stacks.size();
    }

    public boolean isEmpty() {
        return this.stackCount == 0;
    }

    public RecipeMatcher getRecipeMatcher() {
        return this.matcher;
    }

    public List<ItemStack> getStacks() {
        return this.stacks;
    }

    public int getStackCount() {
        return this.stackCount;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PreparationTableRecipeInput)) {
            return false;
        } else {
            PreparationTableRecipeInput preparationTableRecipeInput = (PreparationTableRecipeInput) o;
            return this.width == preparationTableRecipeInput.width && this.height == preparationTableRecipeInput.height && this.stackCount == preparationTableRecipeInput.stackCount && ItemStack.stacksEqual(this.stacks, preparationTableRecipeInput.stacks);
        }
    }

    public int hashCode() {
        int i = ItemStack.listHashCode(this.stacks);
        i = 31 * i + this.width;
        i = 31 * i + this.height;
        return i;
    }

    public record Positioned(PreparationTableRecipeInput input, int left, int top) {
        public static final PreparationTableRecipeInput.Positioned EMPTY;

        static {
            EMPTY = new PreparationTableRecipeInput.Positioned(PreparationTableRecipeInput.EMPTY, 0, 0);
        }
    }
}