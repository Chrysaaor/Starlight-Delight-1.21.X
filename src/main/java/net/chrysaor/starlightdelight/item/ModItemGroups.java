package net.chrysaor.starlightdelight.item;

import net.chrysaor.starlightdelight.StarlightDelight;
import net.chrysaor.starlightdelight.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CHRYSAOR_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(StarlightDelight.MOD_ID, "starlightdelight_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.STARLIGHT_FRAGMENT))
                    .displayName(Text.translatable("itemgroup.starlightdelight.chrysaor_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.STARLIGHT_ASHES);
                        entries.add(ModItems.STARLIGHT_SHARD);
                        entries.add(ModItems.STARLIGHT_FRAGMENT);

                        entries.add(ModItems.STARLIGHT_HELMET);
                        entries.add(ModItems.STARLIGHT_CHESTPLATE);
                        entries.add(ModItems.STARLIGHT_LEGGINGS);
                        entries.add(ModItems.STARLIGHT_BOOTS);

                        entries.add(ModItems.STARLIGHT_SWORD);

                        entries.add(ModItems.STARLIGHT_BOW);

                        entries.add(ModItems.STARLIGHT_PICKAXE);
                        entries.add(ModItems.STARLIGHT_AXE);
                        entries.add(ModItems.STARLIGHT_SHOVEL);
                        entries.add(ModItems.STARLIGHT_HOE);

                        entries.add(ModItems.STARLIGHT_HAMMER);

                        entries.add(ModItems.STARLIGHT_UPGRADE_SMITHING_TEMPLATE);

                        entries.add(ModItems.IRON_TOMAHAWK);
                        entries.add(ModItems.GOLD_TOMAHAWK);
                        entries.add(ModItems.PINK_GARNET_TOMAHAWK);
                        entries.add(ModItems.DIAMOND_TOMAHAWK);

                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.RAW_PINK_GARNET);

                        entries.add(ModItems.PINK_GARNET_HELMET);
                        entries.add(ModItems.PINK_GARNET_CHESTPLATE);
                        entries.add(ModItems.PINK_GARNET_LEGGINGS);
                        entries.add(ModItems.PINK_GARNET_BOOTS);

                        entries.add(ModItems.PINK_GARNET_HORSE_ARMOR);

                        entries.add(ModItems.PINK_GARNET_SWORD);
                        entries.add(ModItems.PINK_GARNET_PICKAXE);
                        entries.add(ModItems.PINK_GARNET_AXE);
                        entries.add(ModItems.PINK_GARNET_SHOVEL);
                        entries.add(ModItems.PINK_GARNET_HOE);

                        entries.add(ModItems.PINK_GARNET_HAMMER);
                        entries.add(ModItems.DIAMOND_HAMMER);
                        entries.add(ModItems.NETHERITE_HAMMER);

                        entries.add(ModItems.HOELY_BEHEADER);

                        entries.add(ModItems.MANTIS_SPAWN_EGG);

                        entries.add(ModItems.SWEET_BERRIES_PIE);
                        entries.add(ModItems.CHEESE);
                        entries.add(ModItems.CAULIFLOWER);
                        entries.add(ModItems.CAULIFLOWER_SEEDS);
                        entries.add(ModItems.GRAPES);
                        entries.add(ModItems.RED_WINE);
                    }).build());

    public static final ItemGroup CHRYSAOR_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(StarlightDelight.MOD_ID, "starlightdelight_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
                    .displayName(Text.translatable("itemgroup.starlightdelight.chrysaor_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);

                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

                        entries.add(ModBlocks.STARLIGHT_ORE);
                        entries.add(ModBlocks.STARLIGHT_DEEPSLATE_ORE);

                        entries.add(ModBlocks.PINK_GARNET_STAIRS);
                        entries.add(ModBlocks.PINK_GARNET_SLABS);

                        entries.add(ModBlocks.PINK_GARNET_BUTTON);
                        entries.add(ModBlocks.PINK_GARNET_PRESSURE_PLATE);

                        entries.add(ModBlocks.PINK_GARNET_FENCE);
                        entries.add(ModBlocks.PINK_GARNET_FENCE_GATE);
                        entries.add(ModBlocks.PINK_GARNET_WALL);

                        entries.add(ModBlocks.PINK_GARNET_DOOR);
                        entries.add(ModBlocks.PINK_GARNET_TRAPDOOR);

                        entries.add(ModBlocks.PINK_GARNET_LAMP);

                        entries.add(ModBlocks.PEDESTAL);

                        entries.add(ModBlocks.FERMENTER);
                    }).build());


    public static void registerItemGroups() {
        StarlightDelight.LOGGER.info("Registering Item Groups for " + StarlightDelight.MOD_ID);
    }
}
