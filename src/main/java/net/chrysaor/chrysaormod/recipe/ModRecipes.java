package net.chrysaor.chrysaormod.recipe;

import net.chrysaor.chrysaormod.ChrysaorMod;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<FermenterRecipe> FERMENTER_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(ChrysaorMod.MOD_ID, "fermenter"),
                    new FermenterRecipe.Serializer());

    public static final RecipeType<FermenterRecipe> FERMENTER_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(ChrysaorMod.MOD_ID, "fermenter"),
            new RecipeType<FermenterRecipe>() {
                @Override
                public String toString() {
                    return "fermenter";
                }});
    public static void registerRecipes() {
        ChrysaorMod.LOGGER.info("Registering Recipes for " + ChrysaorMod.MOD_ID);
    }

}