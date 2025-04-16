package net.chrysaor.chrysaormod.item.custom;

import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public class StarlightBowItem extends BowItem {
    public StarlightBowItem(Settings settings) {
        super(settings);
    }

    public Text getName(ItemStack stack) {
        Text var3 = super.getName(stack);
        if (var3 instanceof MutableText mutableText) {
            return mutableText.withColor(16762407);
        } else {
            return super.getName(stack);
        }
    }
}