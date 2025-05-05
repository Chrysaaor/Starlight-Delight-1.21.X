package net.chrysaor.starlightdelight.item.custom;


import net.chrysaor.starlightdelight.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
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
        if (!user.hasStatusEffect(ModEffects.BERSERKER)) {
            user.addStatusEffect(new StatusEffectInstance(ModEffects.BERSERKER, -1, 0, false, true));
            user.getItemCooldownManager().set(this, 60);
        }
        else {
            user.removeStatusEffect(ModEffects.BERSERKER);
            user.getItemCooldownManager().set(this, 60);
            user.heal(10f);
        }
        return super.use(world, user, hand);
    }
}
