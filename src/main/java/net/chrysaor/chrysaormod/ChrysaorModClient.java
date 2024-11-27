package net.chrysaor.chrysaormod;

import net.chrysaor.chrysaormod.block.ModBlockRenderLayerMap;
import net.chrysaor.chrysaormod.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;

public class ChrysaorModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModBlockRenderLayerMap.registerModBlockRenderLayerMap();

        ModModelPredicates.registerModelPredicates();
    }
}
