package net.chrysaor.chrysaormod;

import net.chrysaor.chrysaormod.block.ModBlockRenderLayerMap;
import net.chrysaor.chrysaormod.client.BerserkerHudOverlay;
import net.chrysaor.chrysaormod.entity.ModEntities;
import net.chrysaor.chrysaormod.entity.client.*;
import net.chrysaor.chrysaormod.particle.ModParticles;
import net.chrysaor.chrysaormod.particle.custom.HoelyBeheaderSweepParticle;
import net.chrysaor.chrysaormod.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class ChrysaorModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModBlockRenderLayerMap.registerModBlockRenderLayerMap();

        ModModelPredicates.registerModelPredicates();


        EntityModelLayerRegistry.registerModelLayer(MantisModel.MANTIS, MantisModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MANTIS, MantisRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(StarlightSwordProjectileModel.STARLIGHT_SWORD, StarlightSwordProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.STARLIGHT_SWORD, StarlightSwordProjectileRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(IronTomahawkProjectileModel.TOMAHAWK, IronTomahawkProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.IRON_TOMAHAWK, IronTomahawkProjectileRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(GoldTomahawkProjectileModel.TOMAHAWK, GoldTomahawkProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.GOLD_TOMAHAWK, GoldTomahawkProjectileRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(PinkGarnetTomahawkProjectileModel.TOMAHAWK, PinkGarnetTomahawkProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.PINK_GARNET_TOMAHAWK, PinkGarnetTomahawkProjectileRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(DiamondTomahawkProjectileModel.TOMAHAWK, DiamondTomahawkProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.DIAMOND_TOMAHAWK, DiamondTomahawkProjectileRenderer::new);


        HudRenderCallback.EVENT.register(new BerserkerHudOverlay());


        ParticleFactoryRegistry.getInstance()
                .register(ModParticles.HOELY_BEHEADER_SWEEP_ATTACK_PARTICLE, HoelyBeheaderSweepParticle.Factory::new);
    }
}