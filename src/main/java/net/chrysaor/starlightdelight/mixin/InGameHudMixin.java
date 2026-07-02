package net.chrysaor.starlightdelight.mixin;

import net.chrysaor.starlightdelight.client.HUDOverlays;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = InGameHud.class, priority = 999) // Before AppleSkin
public class InGameHudMixin {
    @Unique
    private RenderTickCounter starlightdelight$renderTickCounter;

    @Inject(method = "renderHotbar", at = @At("HEAD"))
    private void starlightdelight$captureDeltaTracker(DrawContext guiGraphics, RenderTickCounter renderTickCounter, CallbackInfo ci) {
        starlightdelight$renderTickCounter = renderTickCounter;
    }

    @Inject(method = "renderHotbar", at = @At("TAIL"))
    private void starlightdelight$clearDeltaTracker(DrawContext guiGraphics, RenderTickCounter renderTickCounter, CallbackInfo ci) {
        starlightdelight$renderTickCounter = null;
    }

    @Inject(method = "renderFood", at = @At("TAIL"))
    private void starlightdelight$renderSatiated(DrawContext guiGraphics, PlayerEntity player, int y, int x, CallbackInfo ci) {
        HUDOverlays.SatiatedOverlay.INSTANCE.render(guiGraphics, starlightdelight$renderTickCounter);
    }
}
