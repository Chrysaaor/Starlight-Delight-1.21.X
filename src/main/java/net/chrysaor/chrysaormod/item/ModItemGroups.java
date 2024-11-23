package net.chrysaor.chrysaormod.item;

import net.chrysaor.chrysaormod.ChrysaorMod;
import net.chrysaor.chrysaormod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CHRYSAOR_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ChrysaorMod.MOD_ID, "chrysaor_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.STARLIGHT_ASHES))
                    .displayName(Text.translatable("itemgroup.chrysaormod.chrysaor_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.RAW_PINK_GARNET);

                        entries.add(ModItems.CHISEL);

                        entries.add(ModItems.CAULIFLOWER);

                        entries.add(ModItems.STARLIGHT_ASHES);
                    }).build());

    public static final ItemGroup CHRYSAOR_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ChrysaorMod.MOD_ID, "chrysaor_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
                    .displayName(Text.translatable("itemgroup.chrysaormod.chrysaor_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);

                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

                        entries.add(ModBlocks.MAGIC_BLOCK);

                        entries.add(ModBlocks.PINK_GARNET_STAIRS);
                        entries.add(ModBlocks.PINK_GARNET_SLABS);

                        entries.add(ModBlocks.PINK_GARNET_BUTTON);
                        entries.add(ModBlocks.PINK_GARNET_PRESSURE_PLATE);

                        entries.add(ModBlocks.PINK_GARNET_FENCE);
                        entries.add(ModBlocks.PINK_GARNET_FENCE_GATE);
                        entries.add(ModBlocks.PINK_GARNET_WALL);

                        entries.add(ModBlocks.PINK_GARNET_DOOR);
                        entries.add(ModBlocks.PINK_GARNET_TRAPDOOR);
                    }).build());


    public static void registerItemGroups() {
        ChrysaorMod.LOGGER.info("Registering Item Groups for " + ChrysaorMod.MOD_ID);
    }
}
