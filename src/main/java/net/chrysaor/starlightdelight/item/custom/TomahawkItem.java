package net.chrysaor.starlightdelight.item.custom;

import net.chrysaor.starlightdelight.entity.custom.DiamondTomahawkProjectileEntity;
import net.chrysaor.starlightdelight.entity.custom.GoldTomahawkProjectileEntity;
import net.chrysaor.starlightdelight.entity.custom.IronTomahawkProjectileEntity;
import net.chrysaor.starlightdelight.entity.custom.PinkGarnetTomahawkProjectileEntity;
import net.chrysaor.starlightdelight.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TomahawkItem extends Item {
    public TomahawkItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        if (!world.isClient && user.getStackInHand(hand).getItem() == ModItems.IRON_TOMAHAWK) {
            IronTomahawkProjectileEntity tomahawk = new IronTomahawkProjectileEntity(world, user);
            tomahawk.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.5f, 0f);
            world.spawnEntity(tomahawk);
        }
        if (!world.isClient && user.getStackInHand(hand).getItem() == ModItems.GOLD_TOMAHAWK) {
            GoldTomahawkProjectileEntity tomahawk = new GoldTomahawkProjectileEntity(world, user);
            tomahawk.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 2.0f, 0f);
            world.spawnEntity(tomahawk);
        }
        if (!world.isClient && user.getStackInHand(hand).getItem() == ModItems.PINK_GARNET_TOMAHAWK) {
            PinkGarnetTomahawkProjectileEntity tomahawk = new PinkGarnetTomahawkProjectileEntity(world, user);
            tomahawk.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.5f, 0f);
            world.spawnEntity(tomahawk);
        }
        if (!world.isClient && user.getStackInHand(hand).getItem() == ModItems.DIAMOND_TOMAHAWK) {
            DiamondTomahawkProjectileEntity tomahawk = new DiamondTomahawkProjectileEntity(world, user);
            tomahawk.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.25f, 0f);
            world.spawnEntity(tomahawk);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}