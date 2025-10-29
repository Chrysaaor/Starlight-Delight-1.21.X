package net.chrysaor.starlightdelight.world;

import net.chrysaor.starlightdelight.StarlightDelight;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
     public static final RegistryKey<PlacedFeature> PINK_GARNET_ORE_PLACED_KEY = registerKey("pink_garnet_ore_placed");
     public static final RegistryKey<PlacedFeature> STARLIGHT_ORE_PLACED_KEY = registerKey("starlight_ore_placed");

     public static final RegistryKey<PlacedFeature> GRAPE_BUSH_PLACED_KEY = registerKey("grape_bush_placed");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, PINK_GARNET_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PINK_GARNET_ORE_KEY),
                ModOrePlacement.modifiersWithCount(4, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

        register(context, STARLIGHT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STARLIGHT_ORE_KEY),
                ModOrePlacement.modifiersWithCount(1,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-60), YOffset.fixed(10))));

        register(context, GRAPE_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GRAPE_BUSH_KEY),
                RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(StarlightDelight.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}