package net.chrysaor.starlightdelight.world.gen;

import net.chrysaor.starlightdelight.entity.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawns {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.CHERRY_GROVE,
                BiomeKeys.JUNGLE, BiomeKeys.BAMBOO_JUNGLE, BiomeKeys.SPARSE_JUNGLE, BiomeKeys.SAVANNA),
                SpawnGroup.CREATURE, ModEntities.MANTIS, 10, 1, 2);

        SpawnRestriction.register(ModEntities.MANTIS, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
                BiomeKeys.OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.LUKEWARM_OCEAN,
                BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.WARM_OCEAN),
                SpawnGroup.WATER_AMBIENT, ModEntities.SHRIMP, 10, 3, 7);

        SpawnRestriction.register(ModEntities.SHRIMP, SpawnLocationTypes.IN_WATER,
                Heightmap.Type.OCEAN_FLOOR, WaterCreatureEntity::canSpawn);
    }
}