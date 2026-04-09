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

public record CookingTableRecipe(Ingredient input1, Ingredient input2, Ingredient input3, ItemStack result) implements Recipe<CookingTableRecipeInput> {

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.input1);
        list.add(this.input2);
        list.add(this.input3);
        return list;
    }

    public ItemStack getOutput() {
        return result;
    }

    public Ingredient getInput1() {
        return input1;
    }

    public Ingredient getInput2() {
        return input2;
    }

    public Ingredient getInput3() {
        return input3;
    }

    @Override
    public boolean matches(CookingTableRecipeInput input, World world) {
        return input1.test(input.getStackInSlot(0)) && input2.test(input.getStackInSlot(1)) && input3.test(input.getStackInSlot(2));
    }

    @Override
    public ItemStack craft(CookingTableRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return result.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return result;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.COOKING_TABLE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.COOKING_TABLE_TYPE;
    }

    public static class Serializer implements RecipeSerializer<CookingTableRecipe> {

        public static final MapCodec<CookingTableRecipe> CODEC = RecordCodecBuilder.mapCodec(cookingTableRecipeInstance -> cookingTableRecipeInstance.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("input1").forGetter(CookingTableRecipe::getInput1),
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("input2").forGetter(CookingTableRecipe::getInput2),
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("input3").forGetter(CookingTableRecipe::getInput3),
                ItemStack.CODEC.fieldOf("result").forGetter(CookingTableRecipe::getOutput)
        ).apply(cookingTableRecipeInstance, CookingTableRecipe::new));

        public static final PacketCodec<RegistryByteBuf, CookingTableRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, CookingTableRecipe::input1,
                        Ingredient.PACKET_CODEC, CookingTableRecipe::input2,
                        Ingredient.PACKET_CODEC, CookingTableRecipe::input3,
                        ItemStack.PACKET_CODEC, CookingTableRecipe::result,
                        CookingTableRecipe::new);

        @Override
        public MapCodec<CookingTableRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, CookingTableRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
