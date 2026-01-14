package net.chrysaor.starlightdelight.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record PreparationTableRecipe(Ingredient inputItem, ItemStack output) implements Recipe<PreparationTableRecipeInput> {

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    @Override
    public boolean matches(PreparationTableRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(PreparationTableRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.PREPARATION_TABLE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.PREPARATION_TABLE_TYPE;
    }


    public static class Serializer implements RecipeSerializer<PreparationTableRecipe> {
        public static final MapCodec<PreparationTableRecipe> CODEC = RecordCodecBuilder.mapCodec(preparationTableRecipeInstance -> preparationTableRecipeInstance.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(PreparationTableRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(PreparationTableRecipe::output)
        ).apply(preparationTableRecipeInstance, PreparationTableRecipe::new));
        public static final PacketCodec<RegistryByteBuf, PreparationTableRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, PreparationTableRecipe::inputItem,
                        ItemStack.PACKET_CODEC, PreparationTableRecipe::output,
                        PreparationTableRecipe::new);

        @Override
        public MapCodec<PreparationTableRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, PreparationTableRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}