package net.chrysaor.chrysaormod.block.entity;

import net.chrysaor.chrysaormod.ChrysaorMod;
import net.chrysaor.chrysaormod.block.ModBlocks;
import net.chrysaor.chrysaormod.block.entity.custom.PedestalBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(ChrysaorMod.MOD_ID, "pedestal_be"),
                    BlockEntityType.Builder.create(PedestalBlockEntity::new, ModBlocks.PEDESTAL).build(null));


    public static void registerBlockEntities() {
        ChrysaorMod.LOGGER.info("Registering Block Entities for " + ChrysaorMod.MOD_ID);
    }
}
