package net.chrysaor.starlightdelight.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.chrysaor.starlightdelight.StarlightDelight;
import net.chrysaor.starlightdelight.recipe.CookingTableRecipe;
import net.chrysaor.starlightdelight.recipe.FermenterRecipe;
import net.chrysaor.starlightdelight.recipe.ModRecipes;
import net.chrysaor.starlightdelight.screen.custom.CookingTableScreen;
import net.chrysaor.starlightdelight.screen.custom.FermenterScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@JeiPlugin
public class JEIStarlightDelightPlugin implements IModPlugin {


    @Override
    public @NotNull Identifier getPluginUid() {
        return Identifier.of(StarlightDelight.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new FermenterRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new CookingTableRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        assert MinecraftClient.getInstance().world != null;
        RecipeManager recipeManager = MinecraftClient.getInstance().world.getRecipeManager();

        List<FermenterRecipe> fermenterRecipes = recipeManager
                .listAllOfType(ModRecipes.FERMENTER_TYPE).stream().map(RecipeEntry::value).toList();
        registration.addRecipes(FermenterRecipeCategory.FERMENTER_RECIPE_RECIPE_TYPE, fermenterRecipes);

        List<CookingTableRecipe> cookingTableRecipes = recipeManager.listAllOfType(ModRecipes.COOKING_TABLE_TYPE).stream().map(RecipeEntry::value).toList();
        registration.addRecipes(CookingTableRecipeCategory.COOKING_TABLE_RECIPE_RECIPE_TYPE, cookingTableRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(FermenterScreen.class, 74, 30, 22, 20,
                FermenterRecipeCategory.FERMENTER_RECIPE_RECIPE_TYPE);

        registration.addRecipeClickArea(CookingTableScreen.class, 90, 30, 22, 20,
                CookingTableRecipeCategory.COOKING_TABLE_RECIPE_RECIPE_TYPE);
    }
}