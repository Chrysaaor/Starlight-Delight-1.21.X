package net.chrysaor.chrysaormod.block;

import net.chrysaor.chrysaormod.ChrysaorMod;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class ModBlockRenderLayerMap {

    public static void registerModBlockRenderLayerMap() {
        ChrysaorMod.LOGGER.info("Registering Mod Block Render Layer Map for " + ChrysaorMod.MOD_ID);
        BlockRenderLayerMap registry = BlockRenderLayerMap.INSTANCE;

        registry.putBlock(ModBlocks.CAULIFLOWER_CROP, RenderLayer.getCutout());

        registry.putBlock(ModBlocks.PINK_GARNET_DOOR, RenderLayer.getCutout());
        registry.putBlock(ModBlocks.PINK_GARNET_TRAPDOOR, RenderLayer.getCutout());
    }
}
