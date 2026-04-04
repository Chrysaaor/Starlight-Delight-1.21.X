package net.chrysaor.starlightdelight.mixin;

import net.chrysaor.starlightdelight.effect.ModEffects;
import net.chrysaor.starlightdelight.item.ModItems;
import net.chrysaor.starlightdelight.particle.ModParticles;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @ModifyArg(
            method = "spawnSweepAttackParticles",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerWorld;spawnParticles(Lnet/minecraft/particle/ParticleEffect;DDDIDDDD)I"), index = 0
    )
    @SuppressWarnings("unchecked")
    private <T extends ParticleEffect> T modifySweepParticle(T particle) {
        if (getMainHandStack().isOf(ModItems.HOELY_BEHEADER)) {
            return getMainHandStack().isOf(ModItems.HOELY_BEHEADER) ? (T) ModParticles.HOELY_BEHEADER_SWEEP_ATTACK_PARTICLE : particle;
        } else if (getMainHandStack().isOf(ModItems.STARLIGHT_SWORD)) {
            return getMainHandStack().isOf(ModItems.STARLIGHT_SWORD) ? (T) ModParticles.HOELY_BEHEADER_SWEEP_ATTACK_PARTICLE : particle;
        }
        return particle;
    }

    @Inject(
            method= "updateTurtleHelmet",
            at = @At(value = "TAIL")
    )
    private void updateClimberBandanna(CallbackInfo ci) {
        ItemStack itemStack = this.getEquippedStack(EquipmentSlot.HEAD);
        if (itemStack.isOf(ModItems.CLIMBER_BANDANNA)) {
            this.addStatusEffect(new StatusEffectInstance(ModEffects.LIGHT, 1, 0, false, false, true));
        }
        if (itemStack.isOf(ModItems.STARLIGHT_GLASSES)) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1, 0, false, false, true));
        }
    }
}