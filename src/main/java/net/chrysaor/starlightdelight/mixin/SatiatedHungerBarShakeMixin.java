package net.chrysaor.starlightdelight.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.chrysaor.starlightdelight.effect.ModEffects;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(InGameHud.class)
public class SatiatedHungerBarShakeMixin {

    @Definition(id = "getSaturationLevel", method = "Lnet/minecraft/entity/player/HungerManager;getSaturationLevel()F")
    @Expression("?.getSaturationLevel() <= 0.0")
    @ModifyExpressionValue(
            method = "renderFood",
            at = @At("MIXINEXTRAS:EXPRESSION")
    )
    private boolean starlightdelight$hungerDrainWithSatiatedEffect(boolean original, @Local PlayerEntity player) {
        return  original && !player.hasStatusEffect(ModEffects.SATIATED);
    }
}