package net.chrysaor.starlightdelight.entity.custom;

import net.chrysaor.starlightdelight.entity.ModEntities;
import net.chrysaor.starlightdelight.item.ModItems;
import net.minecraft.client.util.math.Vector2f;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class PinkGarnetTomahawkProjectileEntity extends PersistentProjectileEntity {
    private float rotation;
    public Vector2f groundedOffset;

    public PinkGarnetTomahawkProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public PinkGarnetTomahawkProjectileEntity(World world, PlayerEntity player) {
        super(ModEntities.PINK_GARNET_TOMAHAWK, player, world, new ItemStack(ModItems.PINK_GARNET_TOMAHAWK), null);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.PINK_GARNET_TOMAHAWK);
    }

    public float getRenderingRotation() {
        rotation += 0.5f;
        if (rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    public boolean isGrounded() {return inGround;}

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), 5);

        if (!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.discard();
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);

        if (blockHitResult.getSide() == Direction.SOUTH) {
            groundedOffset = new Vector2f(215f, this.getYaw());
        }
        if (blockHitResult.getSide() == Direction.NORTH) {
            groundedOffset = new Vector2f(215f, this.getYaw());
        }
        if (blockHitResult.getSide() == Direction.EAST) {
            groundedOffset = new Vector2f(215f, this.getYaw());
        }
        if (blockHitResult.getSide() == Direction.WEST) {
            groundedOffset = new Vector2f(215f, this.getYaw());
        }

        if (blockHitResult.getSide() == Direction.DOWN) {
            groundedOffset = new Vector2f((this.getPitch() - 180.0F), this.getYaw());
        }
        if (blockHitResult.getSide() == Direction.UP) {
            groundedOffset = new Vector2f((this.getPitch() * -1.0F - 90.0F), this.getYaw());
        }
    }
}