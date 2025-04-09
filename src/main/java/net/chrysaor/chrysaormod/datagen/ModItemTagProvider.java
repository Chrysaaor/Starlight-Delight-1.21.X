package net.chrysaor.chrysaormod.datagen;


import net.chrysaor.chrysaormod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.PINK_GARNET_HAMMER)
                .add(ModItems.DIAMOND_HAMMER)
                .add(ModItems.NETHERITE_HAMMER)
                .add(ModItems.STARLIGHT_HAMMER);

        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.PINK_GARNET_HAMMER)
                .add(ModItems.DIAMOND_HAMMER)
                .add(ModItems.NETHERITE_HAMMER)
                .add(ModItems.STARLIGHT_HAMMER);


        //Tools
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.HOELY_BEHEADER)
                .add(ModItems.PINK_GARNET_SWORD);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.STARLIGHT_PICKAXE)
                .add(ModItems.PINK_GARNET_PICKAXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.PINK_GARNET_SHOVEL)
                .add(ModItems.STARLIGHT_SHOVEL);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.STARLIGHT_AXE)
                .add(ModItems.PINK_GARNET_AXE);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.PINK_GARNET_HOE);

        getOrCreateTagBuilder(ItemTags.BOW_ENCHANTABLE)
                .add(ModItems.STARLIGHT_BOW);


        //Armors
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.PINK_GARNET_HELMET)
                .add(ModItems.STARLIGHT_HELMET);

        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.PINK_GARNET_CHESTPLATE)
                .add(ModItems.STARLIGHT_CHESTPLATE);

        getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.PINK_GARNET_LEGGINGS)
                .add(ModItems.STARLIGHT_LEGGINGS);

        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.PINK_GARNET_BOOTS)
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
    }
}
