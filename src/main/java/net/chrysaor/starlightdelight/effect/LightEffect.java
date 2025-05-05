package net.chrysaor.starlightdelight.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;

public class LightEffect extends StatusEffect {
    public LightEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.horizontalCollision && entity.isSneaking()) {
            Vec3d intialVec = entity.getVelocity();
            Vec3d climbVec = new Vec3d(intialVec.x, 0.2D, intialVec.z);
            entity.setVelocity(climbVec.multiply(0.96D));
            return true;
        }
        return super.applyUpdateEffect(entity, amplifier);
    }


    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}