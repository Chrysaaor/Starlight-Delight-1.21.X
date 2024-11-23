package net.chrysaor.chrysaormod.datagen;

import net.chrysaor.chrysaormod.ChrysaorMod;
import net.chrysaor.chrysaormod.block.ModBlocks;
import net.chrysaor.chrysaormod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE,
                ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

        offerSmelting(recipeExporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");
        offerBlasting(recipeExporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 100, "pink_garnet");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_PINK_GARNET)
                .criterion(hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.RAW_PINK_GARNET))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "raw_pink_garnet_block_from_raw_pink_garnet"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 9)
                .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "raw_pink_garnet_from_raw_pink_garnet_block"));

        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_SLABS, ModBlocks.PINK_GARNET_BLOCK);

        createDoorRecipe(ModBlocks.PINK_GARNET_DOOR, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);
        createTrapdoorRecipe(ModBlocks.PINK_GARNET_TRAPDOOR, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.PINK_GARNET_BUTTON, 1)
                .input(ModBlocks.PINK_GARNET_BLOCK)
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);
        offerPressurePlateRecipe(recipeExporter, ModBlocks.PINK_GARNET_PRESSURE_PLATE, ModBlocks.PINK_GARNET_BLOCK);

        offerWallRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_WALL, ModBlocks.PINK_GARNET_BLOCK);
        createFenceRecipe(ModBlocks.PINK_GARNET_FENCE, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);
        createFenceGateRecipe(ModBlocks.PINK_GARNET_FENCE_GATE, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);

        createStairsRecipe(ModBlocks.PINK_GARNET_STAIRS, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_STAIRS, ModBlocks.PINK_GARNET_BLOCK);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_SLABS, ModBlocks.PINK_GARNET_BLOCK, 2);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_DOOR, ModBlocks.PINK_GARNET_BLOCK);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_TRAPDOOR, ModBlocks.PINK_GARNET_BLOCK, 4);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.REDSTONE, ModBlocks.PINK_GARNET_BUTTON, ModBlocks.PINK_GARNET_BLOCK);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.REDSTONE, ModBlocks.PINK_GARNET_PRESSURE_PLATE, ModBlocks.PINK_GARNET_BLOCK);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_FENCE, ModBlocks.PINK_GARNET_BLOCK);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_FENCE_GATE, ModBlocks.PINK_GARNET_BLOCK);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_WALL, ModBlocks.PINK_GARNET_BLOCK);
    }
}
