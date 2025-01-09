package net.chrysaor.chrysaormod.entity;

import net.chrysaor.chrysaormod.ChrysaorMod;
import net.chrysaor.chrysaormod.entity.custom.IronTomahawkProjectileEntity;
import net.chrysaor.chrysaormod.entity.custom.MantisEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<MantisEntity> MANTIS = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ChrysaorMod.MOD_ID, "mantis"),
            EntityType.Builder.create(MantisEntity::new, SpawnGroup.CREATURE)
                    .dimensions(2, 2.5f).build());

    public static final EntityType<IronTomahawkProjectileEntity> IRON_TOMAHAWK = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ChrysaorMod.MOD_ID, "iron_tomahawk"),
            EntityType.Builder.<IronTomahawkProjectileEntity>create(IronTomahawkProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 1.15f).build());

    public static void registerModEntities() {
        ChrysaorMod.LOGGER.info("Registering Mod Entities for " + ChrysaorMod.MOD_ID);
    }
}
