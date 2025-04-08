package net.chrysaor.chrysaormod.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.chrysaor.chrysaormod.ChrysaorMod;
import net.chrysaor.chrysaormod.effect.ModEffects;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Identifier;

public class BerserkerHudOverlay implements HudRenderCallback {
    private static final Identifier BERSERKER_EFFECT = Identifier.of(ChrysaorMod.MOD_ID,
            "textures/overlays/berserker_overlay.png");

    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        if (MinecraftClient.getInstance().player.hasStatusEffect(ModEffects.BERSERKER)) {
            int i = drawContext.getScaledWindowWidth();
            int j = drawContext.getScaledWindowHeight();
            drawContext.getMatrices().push();
            drawContext.getMatrices().translate((float)i / 2.0F, (float)j / 2.0F, 0.0F);
            drawContext.getMatrices().translate((float)(-i) / 2.0F, (float)(-j) / 2.0F, 0.0F);
            RenderSystem.disableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.enableBlend();
            RenderSystem.blendFuncSeparate(GlStateManager.SrcFactor.ONE, GlStateManager.DstFactor.ONE, GlStateManager.SrcFactor.ONE, GlStateManager.DstFactor.ONE);
            drawContext.setShaderColor(1.5F, 0.0F, 0.0F, 1.0F);
            drawContext.drawTexture(BERSERKER_EFFECT, 0, 0, -90, 0.0F, 0.0F, i, j, i, j);
            drawContext.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            RenderSystem.depthMask(true);
            RenderSystem.enableDepthTest();
            drawContext.getMatrices().pop();
        }
    }
}