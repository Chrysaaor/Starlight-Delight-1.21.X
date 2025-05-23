package net.chrysaor.starlightdelight.item;

import com.google.common.base.Suppliers;
import net.chrysaor.starlightdelight.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.Objects;
import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {

    PINK_GARNET(ModTags.Blocks.INCORRECT_FOR_PINK_GARNET_TOOL,
            1200, 5.0F, 3.0F, 18, () -> Ingredient.ofItems(new ItemConvertible[]{ModItems.PINK_GARNET})),

    STARLIGHT_FRAGMENT(ModTags.Blocks.INCORRECT_FOR_STARLIGHT_TOOL,
            2800, 40.0f, 5.0f, 20, () -> Ingredient.ofItems(new ItemConvertible[]{ModItems.STARLIGHT_FRAGMENT}));

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;


    ModToolMaterials(final TagKey<Block> inverseTag, final int itemDurability, final float miningSpeed, final float attackDamage, final int enchantability, final Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        Objects.requireNonNull(repairIngredient);
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
