package net.chrysaor.chrysaormod.datagen;

import net.chrysaor.chrysaormod.ChrysaorMod;
import net.chrysaor.chrysaormod.block.ModBlocks;
import net.chrysaor.chrysaormod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    //Recipe templates for every Tool + Armor pieces
    public static CraftingRecipeJsonBuilder createPickaxeRecipe(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output, 1).input('#', input).input('S', Items.STICK)
                .pattern("###").pattern(" S ").pattern(" S ");
    }
    public static CraftingRecipeJsonBuilder createSwordRecipe(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, 1).input('#', input).input('S', Items.STICK)
                .pattern("#").pattern("#").pattern("S");
    }
    public static CraftingRecipeJsonBuilder createShovelRecipe(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output, 1).input('#', input).input('S', Items.STICK)
                .pattern("#").pattern("S").pattern("S");
    }
    public static CraftingRecipeJsonBuilder createAxeRecipe(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, 1).input('#', input).input('S', Items.STICK)
                .pattern("##").pattern("#S").pattern(" S");
    }
    public static CraftingRecipeJsonBuilder createHoeRecipe(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output, 1).input('#', input).input('S', Items.STICK)
                .pattern("##").pattern(" S").pattern(" S");
    }
    public static CraftingRecipeJsonBuilder createHammerRecipe(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output, 1).input('#', input).input('S', Items.STICK)
                .pattern("###").pattern("#S#").pattern(" S ");
    }
    public static CraftingRecipeJsonBuilder createTomahawkRecipe(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, 4).input('#', input).input('S', Items.STICK)
                .pattern("#  ").pattern("#S ").pattern(" S ");
    }

    public static CraftingRecipeJsonBuilder createHelmetRecipe(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, 1).input('#', input)
                .pattern("###").pattern("# #");
    }
    public static CraftingRecipeJsonBuilder createChestplateRecipe(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, 1).input('#', input)
                .pattern("# #").pattern("###").pattern("###");
    }
    public static CraftingRecipeJsonBuilder createLeggingsRecipe(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, 1).input('#', input)
                .pattern("###").pattern("# #").pattern("# #");
    }
    public static CraftingRecipeJsonBuilder createBootsRecipe(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, 1).input('#', input)
                .pattern("# #").pattern("# #");
    }
    public static void offerSmoking(RecipeExporter exporter, List<ItemConvertible> inputs, RecipeCategory category, ItemConvertible output, float experience, int cookingTime, String group) {
        offerMultipleOptions(exporter, RecipeSerializer.SMOKING, SmokingRecipe::new, inputs, category, output, experience, cookingTime, group, "_from_smoking");
    }


    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE,
                ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

        offerSmelting(recipeExporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");
        offerBlasting(recipeExporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 100, "pink_garnet");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHEESE)
                .input(Ingredient.ofItems(Items.MILK_BUCKET))
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "cheese"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SWEET_BERRIES_PIE)
                .input(Ingredient.ofItems(Items.SWEET_BERRIES))
                .input(Ingredient.ofItems(Items.SUGAR))
                .input(Ingredient.ofItems(Items.EGG))
                .criterion(hasItem(Items.SWEET_BERRIES), conditionsFromItem(Items.SWEET_BERRIES))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "sweet_berries_pie"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_PINK_GARNET)
                .criterion(hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.RAW_PINK_GARNET))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "raw_pink_garnet_block_from_raw_pink_garnet"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.PINK_GARNET_LAMP)
                .pattern(" R ")
                .pattern("RGR")
                .pattern(" R ")
                .input('R', ModItems.PINK_GARNET)
                .input('G', Items.GLOWSTONE)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "pink_garnet_lamp"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STARLIGHT_FRAGMENT)
                .pattern(" A ")
                .pattern("ANA")
                .pattern(" A ")
                .input('A', ModItems.STARLIGHT_ASHES)
                .input('N', Items.NETHER_STAR)
                .criterion(hasItem(ModItems.STARLIGHT_ASHES), conditionsFromItem(ModItems.STARLIGHT_ASHES))
                .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "starlight_fragment"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE, 2)
                .pattern("ASA")
                .pattern("ANA")
                .pattern("AAA")
                .input('A', ModItems.STARLIGHT_ASHES)
                .input('N', Items.NETHERITE_INGOT)
                .input('S', ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE)
                .criterion(hasItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "starlight_upgrade_smithing_template"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.NETHERITE_HELMET), Ingredient.ofItems(ModItems.STARLIGHT_FRAGMENT), RecipeCategory.COMBAT, ModItems.STARLIGHT_HELMET)
                .criterion(hasItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "starlight_helmet_smithing"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.NETHERITE_CHESTPLATE), Ingredient.ofItems(ModItems.STARLIGHT_FRAGMENT), RecipeCategory.COMBAT, ModItems.STARLIGHT_CHESTPLATE)
                .criterion(hasItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "starlight_chestplate_smithing"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.NETHERITE_LEGGINGS), Ingredient.ofItems(ModItems.STARLIGHT_FRAGMENT), RecipeCategory.COMBAT, ModItems.STARLIGHT_LEGGINGS)
                .criterion(hasItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "starlight_leggings_smithing"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.NETHERITE_BOOTS), Ingredient.ofItems(ModItems.STARLIGHT_FRAGMENT), RecipeCategory.COMBAT, ModItems.STARLIGHT_BOOTS)
                .criterion(hasItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "starlight_boots_smithing"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.NETHERITE_PICKAXE), Ingredient.ofItems(ModItems.STARLIGHT_FRAGMENT), RecipeCategory.TOOLS, ModItems.STARLIGHT_PICKAXE)
                .criterion(hasItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "starlight_pickaxe_smithing"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.NETHERITE_AXE), Ingredient.ofItems(ModItems.STARLIGHT_FRAGMENT), RecipeCategory.TOOLS, ModItems.STARLIGHT_AXE)
                .criterion(hasItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "starlight_axe_smithing"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.NETHERITE_SHOVEL), Ingredient.ofItems(ModItems.STARLIGHT_FRAGMENT), RecipeCategory.TOOLS, ModItems.STARLIGHT_SHOVEL)
                .criterion(hasItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "starlight_shovel_smithing"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.NETHERITE_SWORD), Ingredient.ofItems(ModItems.STARLIGHT_FRAGMENT), RecipeCategory.COMBAT, ModItems.STARLIGHT_SWORD)
                .criterion(hasItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "starlight_sword_smithing"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.BOW), Ingredient.ofItems(ModItems.STARLIGHT_FRAGMENT), RecipeCategory.COMBAT, ModItems.STARLIGHT_BOW)
                .criterion(hasItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "starlight_bow_smithing"));



        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.NETHERITE_HAMMER), Ingredient.ofItems(ModItems.STARLIGHT_FRAGMENT), RecipeCategory.TOOLS, ModItems.STARLIGHT_HAMMER)
                .criterion(hasItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "starlight_hammer_smithing"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.DIAMOND_HAMMER), Ingredient.ofItems(Items.NETHERITE_INGOT), RecipeCategory.TOOLS, ModItems.NETHERITE_HAMMER)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "netherite_hammer_smithing"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HOELY_BEHEADER)
                .pattern("GAG")
                .pattern("NHN")
                .pattern("GAG")
                .input('G', ModItems.STARLIGHT_ASHES)
                .input('H', Items.NETHERITE_HOE)
                .input('A', Items.AMETHYST_SHARD)
                .input('N', Items.NETHERITE_INGOT)
                .criterion(hasItem(Items.NETHERITE_HOE), conditionsFromItem(Items.NETHERITE_HOE))
                .offerTo(recipeExporter, Identifier.of(ChrysaorMod.MOD_ID, "hoely_beheader"));

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

        createPickaxeRecipe(ModItems.PINK_GARNET_PICKAXE, Ingredient.ofItems(ModItems.PINK_GARNET))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        createSwordRecipe(ModItems.PINK_GARNET_SWORD, Ingredient.ofItems(ModItems.PINK_GARNET))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        createAxeRecipe(ModItems.PINK_GARNET_AXE, Ingredient.ofItems(ModItems.PINK_GARNET))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        createShovelRecipe(ModItems.PINK_GARNET_SHOVEL, Ingredient.ofItems(ModItems.PINK_GARNET))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        createHoeRecipe(ModItems.PINK_GARNET_HOE, Ingredient.ofItems(ModItems.PINK_GARNET))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        createHammerRecipe(ModItems.PINK_GARNET_HAMMER, Ingredient.ofItems(ModItems.PINK_GARNET))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        createHammerRecipe(ModItems.DIAMOND_HAMMER, Ingredient.ofItems(Items.DIAMOND))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(recipeExporter);

        createTomahawkRecipe(ModItems.IRON_TOMAHAWK, Ingredient.ofItems(Items.IRON_INGOT))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(recipeExporter);
        createTomahawkRecipe(ModItems.GOLD_TOMAHAWK, Ingredient.ofItems(Items.GOLD_INGOT))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(recipeExporter);
        createTomahawkRecipe(ModItems.PINK_GARNET_TOMAHAWK, Ingredient.ofItems(ModItems.PINK_GARNET))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        createTomahawkRecipe(ModItems.DIAMOND_TOMAHAWK, Ingredient.ofItems(Items.DIAMOND))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(recipeExporter);

        createHelmetRecipe(ModItems.PINK_GARNET_HELMET, Ingredient.ofItems(ModItems.PINK_GARNET))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        createChestplateRecipe(ModItems.PINK_GARNET_CHESTPLATE, Ingredient.ofItems(ModItems.PINK_GARNET))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        createLeggingsRecipe(ModItems.PINK_GARNET_LEGGINGS, Ingredient.ofItems(ModItems.PINK_GARNET))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        createBootsRecipe(ModItems.PINK_GARNET_BOOTS, Ingredient.ofItems(ModItems.PINK_GARNET))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
    }
}
