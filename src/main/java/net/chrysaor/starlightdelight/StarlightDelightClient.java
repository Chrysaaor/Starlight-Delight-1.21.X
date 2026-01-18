package net.chrysaor.starlightdelight;

import net.chrysaor.starlightdelight.block.ModBlockRenderLayerMap;
import net.chrysaor.starlightdelight.block.entity.ModBlockEntities;
import net.chrysaor.starlightdelight.block.entity.renderer.PedestalBlockEntityRenderer;
import net.chrysaor.starlightdelight.client.BerserkerHudOverlay;
import net.chrysaor.starlightdelight.entity.ModEntities;
import net.chrysaor.starlightdelight.entity.client.*;
import net.chrysaor.starlightdelight.particle.ModParticles;
import net.chrysaor.starlightdelight.particle.custom.CustomSweepParticle;
import net.chrysaor.starlightdelight.screen.ModScreenHandlers;
import net.chrysaor.starlightdelight.screen.custom.FermenterScreen;
import net.chrysaor.starlightdelight.screen.custom.PreparationTableScreen;
import net.chrysaor.starlightdelight.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class StarlightDelightClient implements ClientModInitializer {

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

        BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BE, PedestalBlockEntityRenderer::new);

        HandledScreens.register(ModScreenHandlers.FERMENTER_SCREEN_HANDLER, FermenterScreen::new);

        HandledScreens.register(ModScreenHandlers.PREPARATION_TABLE_SCREEN_HANDLER, PreparationTableScreen::new);




        ParticleFactoryRegistry.getInstance()
                .register(ModParticles.HOELY_BEHEADER_SWEEP_ATTACK_PARTICLE, CustomSweepParticle.Factory::new);
    }
}