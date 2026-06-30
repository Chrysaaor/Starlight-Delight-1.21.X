package net.chrysaor.starlightdelight.block;

import net.chrysaor.starlightdelight.StarlightDelight;
import net.chrysaor.starlightdelight.block.custom.*;
import net.chrysaor.starlightdelight.world.tree.ModSaplingGenerators;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool()));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));
    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock("pink_garnet_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block STARLIGHT_ORE = registerBlock("starlight_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));
    public static final Block STARLIGHT_DEEPSLATE_ORE = registerBlock("starlight_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 7),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block PINK_GARNET_STAIRS = registerBlock("pink_garnet_stairs",
            new StairsBlock(ModBlocks.PINK_GARNET_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(4f, 6f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block PINK_GARNET_SLABS = registerBlock("pink_garnet_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(4f, 6f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block PINK_GARNET_BUTTON = registerBlock("pink_garnet_button",
            new ButtonBlock(BlockSetType.IRON, 2, AbstractBlock.Settings.create().strength(2f, 6f).requiresTool().noCollision()));
    public static final Block PINK_GARNET_PRESSURE_PLATE = registerBlock("pink_garnet_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(4f, 6f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block PINK_GARNET_FENCE = registerBlock("pink_garnet_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block PINK_GARNET_FENCE_GATE = registerBlock("pink_garnet_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(4f, 6f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block PINK_GARNET_WALL = registerBlock("pink_garnet_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block PINK_GARNET_DOOR = registerBlock("pink_garnet_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(4f, 6f).requiresTool().nonOpaque().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block PINK_GARNET_TRAPDOOR = registerBlock("pink_garnet_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(4f, 6f).requiresTool().nonOpaque().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block PINK_GARNET_LAMP = registerBlock("pink_garnet_lamp",
            new PinkGarnetLampBlock(AbstractBlock.Settings.create()
                    .strength(1f).requiresTool().luminance(state -> state.get(PinkGarnetLampBlock.CLICKED) ? 15 : 0)));

    public static final Block CAULIFLOWER_CROP = registerBlockWithoutBlockItem("cauliflower_crop",
            new CauliflowerCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block GRAPE_BUSH = registerBlockWithoutBlockItem("grape_bush",
            new GrapeBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)));

    public static final Block PEDESTAL = registerBlock("pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().nonOpaque().sounds(BlockSoundGroup.STONE).strength(1.5F)));

    public static final Block FERMENTER = registerBlock("fermenter",
            new FermenterBlock(AbstractBlock.Settings.create().nonOpaque().sounds(BlockSoundGroup.WOOD).strength(2.5F)));

    public static final Block COOKING_TABLE = registerBlock("cooking_table",
            new CookingTableBlock(AbstractBlock.Settings.create().nonOpaque().sounds(BlockSoundGroup.WOOD).strength(2.5F)));

    public static final Block DRAKON_EGG = registerBlock("drakon_egg",
            new DrakonEggBlock(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_WHITE)
                    .strength(0.75f).sounds(BlockSoundGroup.METAL).nonOpaque()));


    //Cinnamon blocks
    public static final Block CINNAMON_LOG = registerBlock("cinnamon_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LOG)));
    public static final Block STRIPPED_CINNAMON_LOG = registerBlock("stripped_cinnamon_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_SPRUCE_LOG)));
    public static final Block CINNAMON_WOOD = registerBlock("cinnamon_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD)));
    public static final Block STRIPPED_CINNAMON_WOOD = registerBlock("stripped_cinnamon_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_SPRUCE_WOOD)));

    public static final Block CINNAMON_PLANKS = registerBlock("cinnamon_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));

//    public static final Block CINNAMON_STAIRS = registerBlock("cinnamon_stairs",
//            new StairsBlock(CINNAMON_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(CINNAMON_PLANKS)));
//
//    public static final Block CINNAMON_SLAB = registerBlock("cinnamon_slab",
//            new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.SPRUCE_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
//
//    public static final Block CINNAMON_TRAPDOOR = registerBlock("cinnamon_trapdoor",
//            new TrapdoorBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.create().mapColor(MapColor.SPRUCE_BROWN).instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable()));
//
//    public static final Block CINNAMON_DOOR = registerBlock("cinnamon_door",
//            new DoorBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.create().mapColor(MapColor.SPRUCE_BROWN).instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY)));
//
//    public static final Block CINNAMON_FENCE = registerBlock("cinnamon_fence",
//            new FenceBlock(AbstractBlock.Settings.create().mapColor(MapColor.SPRUCE_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).burnable().sounds(BlockSoundGroup.WOOD)));
//
//    public static final Block CINNAMON_FENCE_GATE = registerBlock("cinnamon_fence_gate",
//            new FenceGateBlock(WoodType.SPRUCE, AbstractBlock.Settings.create().mapColor(MapColor.SPRUCE_BROWN).solid().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).burnable()));
//
//    public static final Block CINNAMON_PRESSURE_PLATE = registerBlock("cinnamon_pressure_plate",
//            new PressurePlateBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.create().mapColor(MapColor.SPRUCE_BROWN).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY)));
//
//    public static final Block CINNAMON_BUTTON = registerBlock("cinnamon_button",
//            new ButtonBlock(BlockSetType.SPRUCE, 30, AbstractBlock.Settings.create().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY)));
//
//    public static final Block CINNAMON_SIGN = registerBlock("cinnamon_sign",
//            new SignBlock(WoodType.SPRUCE, AbstractBlock.Settings.create().mapColor(MapColor.SPRUCE_BROWN).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).burnable()));
//
//    public static final Block CINNAMON_WALL_SIGN = registerBlock("cinnamon_wall_sign",
//            new WallSignBlock(WoodType.SPRUCE, AbstractBlock.Settings.create().mapColor(MapColor.SPRUCE_BROWN).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).dropsLike(CINNAMON_SIGN).burnable()));
//
//    public static final Block CINNAMON_HANGING_SIGN = registerBlock("cinnamon_hanging_sign",
//            new HangingSignBlock(WoodType.SPRUCE, AbstractBlock.Settings.create().mapColor(MapColor.SPRUCE_BROWN).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).burnable()));
//
//    public static final Block CINNAMON_WALL_HANGING_SIGN = registerBlock("cinnamon_wall_hanging_sign",
//            new WallHangingSignBlock(WoodType.SPRUCE, AbstractBlock.Settings.create().mapColor(MapColor.SPRUCE_BROWN).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).dropsLike(CINNAMON_HANGING_SIGN).burnable()));

    public static final Block CINNAMON_SAPLING = registerBlock("cinnamon_sapling",
            new SaplingBlock(ModSaplingGenerators.CINNAMON, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));
    public static final Block POTTED_CINNAMON_SAPLING = registerBlock("potted_cinnamon_sapling",
            new FlowerPotBlock(CINNAMON_SAPLING, AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block CINNAMON_LEAVES = registerBlock("cinnamon_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(StarlightDelight.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(StarlightDelight.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(StarlightDelight.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        StarlightDelight.LOGGER.info("Registering Mod Blocks for " + StarlightDelight.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.PINK_GARNET_BLOCK);
            entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
        });
    }
}
