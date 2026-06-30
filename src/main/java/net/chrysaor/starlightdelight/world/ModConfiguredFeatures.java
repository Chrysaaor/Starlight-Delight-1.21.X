package net.chrysaor.starlightdelight.world;

import net.chrysaor.starlightdelight.StarlightDelight;
import net.chrysaor.starlightdelight.block.ModBlocks;
import net.chrysaor.starlightdelight.block.custom.GrapeBushBlock;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINK_GARNET_ORE_KEY = registryKey("pink_garnet_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> STARLIGHT_ORE_KEY = registryKey("starlight_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> GRAPE_BUSH_KEY = registryKey("grape_bush");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CINNAMON_KEY = registryKey("cinnamon");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldPinkGarnetOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.PINK_GARNET_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.PINK_GARNET_DEEPSLATE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldStarlightOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.STARLIGHT_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.STARLIGHT_DEEPSLATE_ORE.getDefaultState()));

        register(context, PINK_GARNET_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldPinkGarnetOres, 8));
        register(context, STARLIGHT_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldStarlightOres, 5));

        register(context, GRAPE_BUSH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.GRAPE_BUSH
                                .getDefaultState().with(GrapeBushBlock.AGE, 3))),
                        List.of(Blocks.GRASS_BLOCK)));


        register(context, CINNAMON_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.CINNAMON_LOG),
                new LargeOakTrunkPlacer(3, 11, 0),

                BlockStateProvider.of(ModBlocks.CINNAMON_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4),

                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(StarlightDelight.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}