package net.chrysaor.chrysaormod.item.custom;

import net.chrysaor.chrysaormod.entity.ModEntities;
import net.chrysaor.chrysaormod.entity.custom.StarlightSwordProjectileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class StarlightSwordItem extends SwordItem {
    public StarlightSwordItem(ToolMaterial material, Item.Settings settings) {
        super(material, settings);
    }

    public Text getName(ItemStack stack) {
        Text var3 = super.getName(stack);
        if (var3 instanceof MutableText mutableText) {
            return mutableText.withColor(6260173);
        } else {
            return super.getName(stack);
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        StarlightSwordProjectileEntity starlightSwordProjectileEntity = (StarlightSwordProjectileEntity) ModEntities.STARLIGHT_SWORD.create(world);
        starlightSwordProjectileEntity.setPosition(user.getPos().add((double)0.0F, (double)(user.getEyeHeight(user.getPose()) / 2.0F), (double)0.0F));
        starlightSwordProjectileEntity.setYaw(user.getYaw());
        starlightSwordProjectileEntity.setPitch(user.getPitch());
        starlightSwordProjectileEntity.setOwner(user);
        starlightSwordProjectileEntity.weaponStack = user.getStackInHand(hand);
        world.spawnEntity(starlightSwordProjectileEntity);
        user.playSound(SoundEvents.BLOCK_BEACON_POWER_SELECT, 1.0F, (float)((double)1.0F + user.getRandom().nextGaussian() / (double)10.0F));
        if (!user.isCreative()) {
            user.getItemCooldownManager().set(user.getStackInHand(hand).getItem(), 40);
        }

        return super.use(world, user, hand);
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
    }
}
