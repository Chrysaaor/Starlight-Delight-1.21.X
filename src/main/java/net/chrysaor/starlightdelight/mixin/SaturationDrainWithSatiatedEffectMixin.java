package net.chrysaor.starlightdelight.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.chrysaor.starlightdelight.effect.ModEffects;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({HungerManager.class})
public class SaturationDrainWithSatiatedEffectMixin {

    @Definition(id = "saturationLevel", field = "Lnet/minecraft/entity/player/HungerManager;saturationLevel:F")
    @Expression("this.saturationLevel > 0.0")
    @ModifyExpressionValue(
            method = "update",
            at = @At("MIXINEXTRAS:EXPRESSION")
    )
    private boolean starlightdelight$saturationDrainWithSatiatedEffect(boolean original, @Local PlayerEntity player) {
        return  (original && !player.hasStatusEffect(ModEffects.SATIATED)) || (original && player.hasStatusEffect(ModEffects.SATIATED) && player.canFoodHeal());
    }
}