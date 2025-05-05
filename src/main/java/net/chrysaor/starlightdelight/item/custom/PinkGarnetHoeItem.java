package net.chrysaor.starlightdelight.item.custom;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public class PinkGarnetHoeItem extends HoeItem {
    public PinkGarnetHoeItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    public Text getName(ItemStack stack) {
        Text var3 = super.getName(stack);
        if (var3 instanceof MutableText mutableText) {
            return mutableText.withColor(16745983);
        } else {
            return super.getName(stack);
        }
    }
}
