package net.chrysaor.chrysaormod.entity.custom;

import net.minecraft.block.Blocks;
import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ProjectileDeflection;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class StarlightSwordProjectileEntity extends ProjectileEntity {
    public static final float DAMAGE = 5.0F;
    public ItemStack weaponStack;
    public float pitchVel;
    public float yawVel;

    public StarlightSwordProjectileEntity(EntityType<? extends StarlightSwordProjectileEntity> entityType, World world) {
        super(entityType, world);
        this.weaponStack = ItemStack.EMPTY;
    }

    @Override
    protected void onEntityHit(@NotNull EntityHitResult entityHitResult) {
        World owner = this.getWorld();
        if (owner instanceof ServerWorld serverWorld) {
            Entity ownerEntity = this.getOwner();
            Entity target = entityHitResult.getEntity();
            DamageSource damageSource = this.getDamageSources().create(DamageTypes.MAGIC, this, (Entity) (ownerEntity != null ? ownerEntity : this));
            if (ownerEntity instanceof LivingEntity livingEntity) {
                livingEntity.onAttacking(target);
            }

            target.timeUntilRegen = 0;
            if (target.damage(damageSource, 5.0F)) {
                if (target.getType() == EntityType.ENDERMAN) {
                    return;
                }

                if (this.isOnFire()) {
                    target.setOnFireFor(5.0F);
                }

                if (target instanceof LivingEntity) {
                    LivingEntity livingTarget = (LivingEntity) target;
                    if (livingTarget != ownerEntity && livingTarget instanceof PlayerEntity && ownerEntity instanceof ServerPlayerEntity) {
                        ServerPlayerEntity serverOwner = (ServerPlayerEntity) ownerEntity;
                        if (!this.isSilent()) {
                            serverOwner.networkHandler.sendPacket(new GameStateChangeS2CPacket(GameStateChangeS2CPacket.PROJECTILE_HIT_PLAYER, 0.0F));
                        }
                    }
                }
                this.playSound(SoundEvents.BLOCK_AMETHYST_CLUSTER_BREAK, 0.8F, 0.9F + 0.6F * this.random.nextFloat());
                this.getWorld().sendEntityStatus(this, (byte)100);
                this.discard();
            } else {
                this.deflect(ProjectileDeflection.SIMPLE, target, this.getOwner(), false);
                this.setVelocity(this.getVelocity().multiply(0.6));
            }
        }
    }

    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if (!this.isRemoved()) {
            this.getWorld().playSound((PlayerEntity) null, this.getX(), this.getY(), this.getZ(), SoundEvents.BLOCK_AMETHYST_CLUSTER_BREAK, SoundCategory.PLAYERS, 0.5F, 0.9F + 0.6F * this.random.nextFloat());
            this.getWorld().sendEntityStatus(this, (byte)100);
            this.discard();
        }

    }

    public void setVelocity(double x, double y, double z, float speed, float divergence) {
        Vec3d vec3d = (new Vec3d(x, y, z)).normalize().add(this.random.nextTriangular((double)0.0F, 0.0172275 * (double)divergence), this.random.nextTriangular((double)0.0F, 0.0172275 * (double)divergence), this.random.nextTriangular((double)0.0F, 0.0172275 * (double)divergence)).multiply((double)speed);
        this.setVelocity(vec3d);
    }

    public void tick() {
        super.tick();
        if (this.age > 300) {
            this.discard();
        }

        Vec3d velocity = this.getVelocity();
        if (this.prevPitch == 0.0F && this.prevYaw == 0.0F) {
            double d = velocity.horizontalLength();
            this.setYaw((float)(MathHelper.atan2(velocity.x, velocity.z) * (double)180.0F / (double)(float)Math.PI));
            this.setPitch((float)(MathHelper.atan2(velocity.y, d) * (double)180.0F / (double)(float)Math.PI));
            this.prevYaw = this.getYaw();
            this.prevPitch = this.getPitch();
        }

        if (this.isTouchingWaterOrRain() || this.getWorld().getBlockState(this.getBlockPos()).isOf(Blocks.POWDER_SNOW)) {
            this.extinguish();
        }

        Vec3d pos = this.getPos();
        Vec3d next = pos.add(velocity);
        HitResult hit = this.getWorld().raycast(new RaycastContext(pos, next, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, this));
        if (hit.getType() != HitResult.Type.MISS) {
            next = hit.getPos();
        }

        EntityHitResult entityHit = ProjectileUtil.getEntityCollision(this.getWorld(), this, pos.subtract(velocity), next, this.getBoundingBox().stretch(this.getVelocity()).expand((double)1.0F), (x$0) -> this.canHit(x$0));
        if (entityHit != null) {
            hit = entityHit;
        }

        if (hit instanceof EntityHitResult entityHitResult) {
            Entity entity = entityHitResult.getEntity();
            Entity owner = this.getOwner();
            if (entity == owner) {
                hit = null;
            }

            if (entity instanceof PlayerEntity target) {
                if (owner instanceof PlayerEntity player) {
                    if (!player.shouldDamagePlayer(target)) {
                        hit = null;
                    }
                }
            }
        }

        if (hit != null) {
            this.hitOrDeflect(hit);
            this.velocityDirty = true;
        }

        if (this.isTouchingWater()) {
            for(int i = 0; i < 4; ++i) {
                this.getWorld().addParticle(ParticleTypes.BUBBLE, next.x - velocity.x * (double)0.25F, next.y - velocity.y * (double)0.25F, next.z - velocity.z * (double)0.25F, velocity.x, velocity.y, velocity.z);
            }
        }

        this.applyGravity();
        this.setPosition(next);
        Entity var14 = this.getOwner();
        if (var14 instanceof PlayerEntity player) {
            int distance = 50;
            HitResult raycast = ProjectileUtil.raycast(player, player.getEyePos(), player.getEyePos().add(player.getRotationVector().multiply((double)distance)), Box.of(player.getEyePos(), 0.1, 0.1, 0.1).expand((double)distance, (double)distance, (double)distance), (entity) -> !(entity instanceof ProjectileEntity), (double)(distance * distance));
            if (raycast == null) {
                raycast = player.raycast((double)50.0F, 1.0F, false);
            }

            this.lookAt(EntityAnchorArgumentType.EntityAnchor.EYES, raycast.getPos());
            if (ItemStack.areEqual(player.getMainHandStack(), this.weaponStack)) {
                if (this.getVelocity().equals(Vec3d.ZERO)) {
                    if (player.handSwingTicks == -1) {
                        this.playSound(SoundEvents.ENTITY_ALLAY_ITEM_THROWN, 1.0F, (float)((double)1.0F + this.random.nextGaussian() / (double)10.0F));
                        this.setVelocity(player, this.getPitch(), this.getYaw(), 0.0F, 1.0F, 0.0F);
                    }
                } else {
                    this.setVelocity(player, this.getPitch(), this.getYaw(), 0.0F, 1.0F, 0.0F);
                }
            }
        }

    }

    public boolean shouldRender(double distance) {
        double d = this.getBoundingBox().getAverageSideLength() * (double)4.0F;
        if (Double.isNaN(d)) {
            d = (double)4.0F;
        }

        d *= (double)64.0F;
        return distance < d * d;
    }

    public boolean canUsePortals(boolean allowVehicles) {
        return true;
    }

    protected double getGravity() {
        return (double)0.0F;
    }

    protected void initDataTracker(DataTracker.Builder builder) {
    }
}
