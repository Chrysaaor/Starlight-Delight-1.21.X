package net.chrysaor.chrysaormod;

import net.chrysaor.chrysaormod.block.ModBlockRenderLayerMap;
import net.chrysaor.chrysaormod.entity.ModEntities;
import net.chrysaor.chrysaormod.entity.client.IronTomahawkProjectileModel;
import net.chrysaor.chrysaormod.entity.client.IronTomahawkProjectileRenderer;
import net.chrysaor.chrysaormod.entity.client.MantisModel;
import net.chrysaor.chrysaormod.entity.client.MantisRenderer;
import net.chrysaor.chrysaormod.particle.ModParticles;
import net.chrysaor.chrysaormod.particle.custom.HoelyBeheaderSweepParticle;
import net.chrysaor.chrysaormod.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class ChrysaorModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModBlockRenderLayerMap.registerModBlockRenderLayerMap();

        ModModelPredicates.registerModelPredicates();


        EntityModelLayerRegistry.registerModelLayer(MantisModel.MANTIS, MantisModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MANTIS, MantisRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(IronTomahawkProjectileModel.TOMAHAWK, IronTomahawkProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.IRON_TOMAHAWK, IronTomahawkProjectileRenderer::new);


        ParticleFactoryRegistry.getInstance()
                .register(ModParticles.HOELY_BEHEADER_SWEEP_ATTACK_PARTICLE, HoelyBeheaderSweepParticle.Factory::new);
    }
}