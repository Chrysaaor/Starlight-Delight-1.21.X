package net.chrysaor.chrysaormod.entity.custom;

import net.chrysaor.chrysaormod.entity.ModEntities;
import net.chrysaor.chrysaormod.item.ModItems;
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

public class IronTomahawkProjectileEntity extends PersistentProjectileEntity {
    private float rotation;
    public Vector2f groundedOffset;

    public IronTomahawkProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public IronTomahawkProjectileEntity(World world, PlayerEntity player) {
        super(ModEntities.IRON_TOMAHAWK, player, world, new ItemStack(ModItems.IRON_TOMAHAWK), null);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.IRON_TOMAHAWK);
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
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), 4);

        if (!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.discard();
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);

        if (blockHitResult.getSide() == Direction.SOUTH) {
            groundedOffset = new Vector2f(215f, 180f);
        }
        if (blockHitResult.getSide() == Direction.NORTH) {
            groundedOffset = new Vector2f(215f, 0f);
        }
        if (blockHitResult.getSide() == Direction.EAST) {
            groundedOffset = new Vector2f(215f, -90f);
        }
        if (blockHitResult.getSide() == Direction.WEST) {
            groundedOffset = new Vector2f(215f, 90f);
        }

        if (blockHitResult.getSide() == Direction.DOWN) {
            groundedOffset = new Vector2f(115f, 180f);
        }
        if (blockHitResult.getSide() == Direction.UP) {
            groundedOffset = new Vector2f(285f, 180f);
        }
    }
}