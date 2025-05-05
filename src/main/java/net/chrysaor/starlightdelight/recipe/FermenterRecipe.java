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

public record FermenterRecipe(Ingredient inputItem, ItemStack output) implements Recipe<FermenterRecipeInput> {

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }




    @Override
    public boolean matches(FermenterRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(FermenterRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
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
        return ModRecipes.FERMENTER_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.FERMENTER_TYPE;
    }


    public static class Serializer implements RecipeSerializer<FermenterRecipe> {
        public static final MapCodec<FermenterRecipe> CODEC = RecordCodecBuilder.mapCodec(fermenterRecipeInstance -> fermenterRecipeInstance.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(FermenterRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(FermenterRecipe::output)
        ).apply(fermenterRecipeInstance, FermenterRecipe::new));
        public static final PacketCodec<RegistryByteBuf, FermenterRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, FermenterRecipe::inputItem,
                        ItemStack.PACKET_CODEC, FermenterRecipe::output,
                        FermenterRecipe::new);

        @Override
        public MapCodec<FermenterRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, FermenterRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
