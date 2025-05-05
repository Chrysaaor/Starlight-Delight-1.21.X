package net.chrysaor.starlightdelight.mixin;

import net.chrysaor.starlightdelight.item.ModItems;
import net.chrysaor.starlightdelight.particle.ModParticles;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

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
        return getMainHandStack().isOf(ModItems.HOELY_BEHEADER) ? (T) ModParticles.HOELY_BEHEADER_SWEEP_ATTACK_PARTICLE : particle;
    }
}