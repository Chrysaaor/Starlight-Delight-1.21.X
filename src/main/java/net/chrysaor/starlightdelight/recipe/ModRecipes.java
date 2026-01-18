package net.chrysaor.starlightdelight.recipe;

import net.chrysaor.starlightdelight.StarlightDelight;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<FermenterRecipe> FERMENTER_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(StarlightDelight.MOD_ID, "fermenter"),
                    new FermenterRecipe.Serializer());

    public static final RecipeType<FermenterRecipe> FERMENTER_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(StarlightDelight.MOD_ID, "fermenter"),
            new RecipeType<FermenterRecipe>() {
                @Override
                public String toString() {
                    return "fermenter";
                }});


    public static final RecipeType<PreparationTableRecipe> PREPARATION_TABLE_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(StarlightDelight.MOD_ID, "preparation_table"),
            new RecipeType<PreparationTableRecipe>() {@Override public String toString() {return "preparation_table";}});



    public static void registerRecipes() {
        StarlightDelight.LOGGER.info("Registering Recipes for " + StarlightDelight.MOD_ID);
    }
}