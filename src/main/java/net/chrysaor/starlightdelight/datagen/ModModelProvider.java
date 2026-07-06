package net.chrysaor.starlightdelight.datagen;

import com.google.common.collect.ImmutableMap;
import net.chrysaor.starlightdelight.block.ModBlocks;
import net.chrysaor.starlightdelight.block.custom.CauliflowerCropBlock;
import net.chrysaor.starlightdelight.block.custom.GrapeBushBlock;
import net.chrysaor.starlightdelight.block.custom.PinkGarnetLampBlock;
import net.chrysaor.starlightdelight.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    private final Map<Block, TexturedModel> uniqueModels = ImmutableMap.<Block, TexturedModel>builder()
            .build();

    public static BlockFamily CINNAMON_BLOCK_FAMILY = BlockFamilies.register(ModBlocks.CINNAMON_PLANKS)
            .button(ModBlocks.CINNAMON_BUTTON)
            .fence(ModBlocks.CINNAMON_FENCE)
            .fenceGate(ModBlocks.CINNAMON_FENCE_GATE)
            .pressurePlate(ModBlocks.CINNAMON_PRESSURE_PLATE)
            .sign(ModBlocks.CINNAMON_SIGN, ModBlocks.CINNAMON_WALL_SIGN)
            .slab(ModBlocks.CINNAMON_SLAB)
            .stairs(ModBlocks.CINNAMON_STAIRS)
            .door(ModBlocks.CINNAMON_DOOR)
            .trapdoor(ModBlocks.CINNAMON_TRAPDOOR)
            .group("wooden")
            .unlockCriterionName("has_planks")
            .build();

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool pinkGarnetPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PINK_GARNET_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STARLIGHT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STARLIGHT_DEEPSLATE_ORE);


        pinkGarnetPool.stairs(ModBlocks.PINK_GARNET_STAIRS);
        pinkGarnetPool.slab(ModBlocks.PINK_GARNET_SLABS);

        pinkGarnetPool.button(ModBlocks.PINK_GARNET_BUTTON);
        pinkGarnetPool.pressurePlate(ModBlocks.PINK_GARNET_PRESSURE_PLATE);

        pinkGarnetPool.fence(ModBlocks.PINK_GARNET_FENCE);
        pinkGarnetPool.fenceGate(ModBlocks.PINK_GARNET_FENCE_GATE);
        pinkGarnetPool.wall(ModBlocks.PINK_GARNET_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.PINK_GARNET_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PINK_GARNET_TRAPDOOR);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.PINK_GARNET_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.PINK_GARNET_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.PINK_GARNET_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(PinkGarnetLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));

        blockStateModelGenerator.registerCrop(ModBlocks.CAULIFLOWER_CROP, CauliflowerCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.GRAPE_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED,
                GrapeBushBlock.AGE, 0, 1, 2, 3);


        this.registerFamily(blockStateModelGenerator, CINNAMON_BLOCK_FAMILY);
        blockStateModelGenerator.registerLog(ModBlocks.CINNAMON_LOG).log(ModBlocks.CINNAMON_LOG).wood(ModBlocks.CINNAMON_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_CINNAMON_LOG).log(ModBlocks.STRIPPED_CINNAMON_LOG).wood(ModBlocks.STRIPPED_CINNAMON_WOOD);
        blockStateModelGenerator.registerSingleton(ModBlocks.CINNAMON_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_CINNAMON_LOG, ModBlocks.CINNAMON_HANGING_SIGN, ModBlocks.CINNAMON_WALL_HANGING_SIGN);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CINNAMON_SAPLING, ModBlocks.POTTED_CINNAMON_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);

        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SWEET_BERRIES_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_RACLETTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RACLETTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.KOUIGN_AMANN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CINNAMON_ROLL, Models.GENERATED);
        itemModelGenerator.register(ModItems.RED_WINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CINNAMON, Models.GENERATED);
        itemModelGenerator.register(ModItems.CINNAMON_BARK, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLOUR, Models.GENERATED);
        itemModelGenerator.register(ModItems.QUICHE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BUTTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUGH, Models.GENERATED);
        itemModelGenerator.register(ModItems.CREAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.APPLE_CRUMBLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENERGY_BEVERAGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARROT_CAKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTATO_FRIES, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_POTATO_FRIES, Models.GENERATED);
        itemModelGenerator.register(ModItems.HASHBROWNS, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRIED_CHICKEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.PASTEL_DE_NATA, Models.GENERATED);

        itemModelGenerator.register(ModItems.DRAKON_EGG, Models.GENERATED);

        itemModelGenerator.register(ModItems.HOELY_BEHEADER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARLIGHT_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARLIGHT_FRAGMENT, Models.GENERATED);

        itemModelGenerator.register(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.STARLIGHT_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STARLIGHT_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STARLIGHT_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STARLIGHT_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STARLIGHT_SWORD, Models.HANDHELD);

        itemModelGenerator.register(ModItems.PINK_GARNET_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.PINK_GARNET_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STARLIGHT_HAMMER, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STARLIGHT_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STARLIGHT_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STARLIGHT_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STARLIGHT_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CLIMBER_BANDANNA));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STARLIGHT_GLASSES));

        itemModelGenerator.register(ModItems.PINK_GARNET_HORSE_ARMOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.MANTIS_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

    }

    private void registerFamily(BlockStateModelGenerator generator, BlockFamily family) {
        TexturedModel texturedModel = this.uniqueModels.getOrDefault(family.getBaseBlock(), TexturedModel.CUBE_ALL.get(family.getBaseBlock()));
        generator.new BlockTexturePool(texturedModel.getTextures()).base(family.getBaseBlock(), texturedModel.getModel()).family(family);
    }
}