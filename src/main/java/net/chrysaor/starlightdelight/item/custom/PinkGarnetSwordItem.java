package net.chrysaor.starlightdelight.item.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public class PinkGarnetSwordItem extends SwordItem {
    public PinkGarnetSwordItem(ToolMaterial toolMaterial, Settings settings) {
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
