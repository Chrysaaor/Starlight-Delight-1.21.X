package net.chrysaor.chrysaormod.item.custom;


import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class HoelyBeheaderItem extends SwordItem {
    public HoelyBeheaderItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!user.hasStatusEffect(StatusEffects.STRENGTH) && user.getMaxHealth() == 20f) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1, 2, false, false));
            user.getItemCooldownManager().set(this, 30);
            user.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(10f);
            user.getAttributeInstance(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO).setBaseValue(0.85f);
        }
        else {
            user.removeStatusEffect(StatusEffects.STRENGTH);
            user.getItemCooldownManager().set(this, 30);
            user.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(20f);
            user.heal(10f);
            user.getAttributeInstance(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO).setBaseValue(0f);
        }
        return super.use(world, user, hand);
    }
}
