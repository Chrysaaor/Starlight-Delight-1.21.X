package net.chrysaor.chrysaormod;

import net.chrysaor.chrysaormod.block.ModBlockRenderLayerMap;
import net.chrysaor.chrysaormod.particle.ModParticles;
import net.chrysaor.chrysaormod.particle.custom.HoelyBeheaderSweepParticle;
import net.chrysaor.chrysaormod.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

public class ChrysaorModClient implements ClientModInitializer {





    @Override
    public void onInitializeClient() {
        ModBlockRenderLayerMap.registerModBlockRenderLayerMap();

        ModModelPredicates.registerModelPredicates();

        ParticleFactoryRegistry.getInstance()
                .register(ModParticles.HOELY_BEHEADER_SWEEP_ATTACK_PARTICLE, HoelyBeheaderSweepParticle.Factory::new);
    }
}