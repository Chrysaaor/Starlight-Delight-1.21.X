package net.chrysaor.starlightdelight.item.custom;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public class StarlightAxeItem extends AxeItem {
    public StarlightAxeItem(ToolMaterial material, Settings settings) {
        super(material, settings);
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