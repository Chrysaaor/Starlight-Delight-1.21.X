package net.chrysaor.starlightdelight.entity.custom;

import net.chrysaor.starlightdelight.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.control.AquaticMoveControl;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class ShrimpEntity extends SchoolingFishEntity {
    public ShrimpEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new AquaticMoveControl(this, 85, 10, 0.02F, 0.1F, true);
    }

    public static DefaultAttributeContainer.Builder createShrimpAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 4)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5f);
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected SoundEvent getFlopSound() {
        return null;
    }

    @Override
    public ItemStack getBucketItem() {
        return new ItemStack(ModItems.SHRIMP_BUCKET);
    }

}