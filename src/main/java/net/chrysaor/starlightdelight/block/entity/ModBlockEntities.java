package net.chrysaor.starlightdelight.block.entity;

import net.chrysaor.starlightdelight.StarlightDelight;
import net.chrysaor.starlightdelight.block.ModBlocks;
import net.chrysaor.starlightdelight.block.entity.custom.FermenterBlockEntity;
import net.chrysaor.starlightdelight.block.entity.custom.PedestalBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(StarlightDelight.MOD_ID, "pedestal_be"),
                    BlockEntityType.Builder.create(PedestalBlockEntity::new, ModBlocks.PEDESTAL).build(null));

    public static final BlockEntityType<FermenterBlockEntity> FERMENTER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(StarlightDelight.MOD_ID, "fermenter_be"),
                    BlockEntityType.Builder.create(FermenterBlockEntity::new, ModBlocks.FERMENTER).build(null));


    public static void registerBlockEntities() {
        StarlightDelight.LOGGER.info("Registering Block Entities for " + StarlightDelight.MOD_ID);
    }
}