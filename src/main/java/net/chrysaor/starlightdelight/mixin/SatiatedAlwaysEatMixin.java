package net.chrysaor.starlightdelight.mixin;

import net.chrysaor.starlightdelight.effect.ModEffects;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class SatiatedAlwaysEatMixin {

    @Inject(
            method = "canConsume",
            at = @At("HEAD"),
            cancellable = true)
    private void alwaysEatUnderSatiatedEffect(boolean canAlwaysEat, CallbackInfoReturnable<Boolean> cir) {
        if (((PlayerEntity) (Object) this).hasStatusEffect(ModEffects.SATIATED)) {
            cir.setReturnValue(true);
        }
    }
}