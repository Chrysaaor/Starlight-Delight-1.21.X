package net.chrysaor.chrysaormod.datagen;

import net.chrysaor.chrysaormod.block.ModBlocks;
import net.chrysaor.chrysaormod.item.ModItems;
import net.chrysaor.chrysaormod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.PINK_GARNET)
                .add(ModItems.STARLIGHT_ASHES)
                .add(Items.GOLD_BLOCK);

        getOrCreateTagBuilder(ItemTags.BOW_ENCHANTABLE)
                .add(ModItems.KAUPEN_BOW);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.HOELY_BEHEADER)
                .add(ModItems.PINK_GARNET_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.PINK_GARNET_HAMMER)
                .add(ModItems.STARLIGHT_PICKAXE)
                .add(ModItems.PINK_GARNET_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.PINK_GARNET_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.STARLIGHT_AXE)
                .add(ModItems.PINK_GARNET_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.PINK_GARNET_HOE);

        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.PINK_GARNET_HELMET)
                .add(ModItems.PINK_GARNET_CHESTPLATE)
                .add(ModItems.PINK_GARNET_LEGGINGS)
                .add(ModItems.PINK_GARNET_BOOTS)

                .add(ModItems.STARLIGHT_HELMET)
                .add(ModItems.STARLIGHT_CHESTPLATE)
                .add(ModItems.STARLIGHT_LEGGINGS)
                .add(ModItems.STARLIGHT_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.STARLIGHT_HELMET)
                .add(ModItems.STARLIGHT_CHESTPLATE)
                .add(ModItems.STARLIGHT_LEGGINGS)
                .add(ModItems.STARLIGHT_BOOTS)

                .add(ModItems.PINK_GARNET_HELMET)
                .add(ModItems.PINK_GARNET_CHESTPLATE)
                .add(ModItems.PINK_GARNET_LEGGINGS)
                .add(ModItems.PINK_GARNET_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE);

        getOrCreateTagBuilder(ModTags.Items.STARLIGHT_HEAD_ARMOR)
                .add(ModItems.STARLIGHT_HELMET);

        getOrCreateTagBuilder(ModTags.Items.STARLIGHT_CHEST_ARMOR)
                .add(ModItems.STARLIGHT_CHESTPLATE);

        getOrCreateTagBuilder(ModTags.Items.STARLIGHT_LEG_ARMOR)
                .add(ModItems.STARLIGHT_LEGGINGS);

        getOrCreateTagBuilder(ModTags.Items.STARLIGHT_FOOT_ARMOR)
                .add(ModItems.STARLIGHT_BOOTS);

        getOrCreateTagBuilder(ModTags.Items.STARLIGHT_PICKAXE)
                .add(ModItems.STARLIGHT_PICKAXE);

        getOrCreateTagBuilder(ModTags.Items.STARLIGHT_AXE)
                .add(ModItems.STARLIGHT_AXE);

    }
}
