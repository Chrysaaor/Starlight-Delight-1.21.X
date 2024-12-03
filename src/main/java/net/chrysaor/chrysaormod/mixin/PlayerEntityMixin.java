package net.chrysaor.chrysaormod.mixin;


import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.chrysaor.chrysaormod.item.ModItems;
import net.chrysaor.chrysaormod.particle.ModParticles;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @ModifyExpressionValue(method = "spawnSweepAttackParticles", at=@At(value="FIELD", target="Lnet/minecraft/particle/ParticleTypes;SWEEP_ATTACK:Lnet/minecraft/particle/SimpleParticleType;"))
    private void spawnSweepAttackHoelyBeheader(void original) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        if (player.getMainHandStack().isOf(ModItems.HOELY_BEHEADER)) {
            double d = (double) (-MathHelper.sin(this.getYaw() * ((float) Math.PI / 180F)));
            double e = (double) MathHelper.cos(this.getYaw() * ((float) Math.PI / 180F));
            if (this.getWorld() instanceof ServerWorld) {
                ((ServerWorld) this.getWorld()).spawnParticles(ModParticles.HOELY_BEHEADER_SWEEP_ATTACK_PARTICLE,
                        this.getX() + d, this.getBodyY((double) 0.5F), this.getZ() + e, 0, d, (double) 0.0F, e, (double) 0.0F);
            }
            return original;
        }
    }
}