package net.chrysaor.starlightdelight.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;import net.chrysaor.starlightdelight.effect.ModEffects;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(HungerManager.class)
public class HungerDrainWithSatiatedEffectMixin {

    @Definition(id = "PEACEFUL", field = "Lnet/minecraft/world/Difficulty;PEACEFUL:Lnet/minecraft/world/Difficulty;")
    @Definition(id = "difficulty", local = @Local(type = Difficulty.class))
    @Expression("difficulty != PEACEFUL")
    @ModifyExpressionValue(
            method = "update",
            at = @At("MIXINEXTRAS:EXPRESSION")
    )
    private boolean starlightdelight$hungerDrainWithSatiatedEffect(boolean original, @Local PlayerEntity player) {
        return  original && !player.hasStatusEffect(ModEffects.SATIATED);
    }
}