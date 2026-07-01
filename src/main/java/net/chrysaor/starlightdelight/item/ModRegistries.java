package net.chrysaor.starlightdelight.item;

import net.chrysaor.starlightdelight.StarlightDelight;
import net.chrysaor.starlightdelight.block.ModBlocks;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModRegistries {

    public static void registerModFuels() {
        StarlightDelight.LOGGER.info("Registering Mod Fuels for " + StarlightDelight.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.STARLIGHT_ASHES, 3200);
        registry.add(ModItems.STARLIGHT_SHARD, 18000);
        registry.add(ModItems.STARLIGHT_FRAGMENT, 72000);

        registry.add(ModItems.CINNAMON_BARK, 300);
        registry.add(ModItems.CINNAMON, 800);
    }

    public static void registerModCropCompostable() {
        StarlightDelight.LOGGER.info("Registering Compostable Mod Crops for " + StarlightDelight.MOD_ID);
        CompostingChanceRegistry registry = CompostingChanceRegistry.INSTANCE;

        registry.add(ModItems.CAULIFLOWER_SEEDS, 0.2f);
        registry.add(ModItems.CAULIFLOWER, 0.5f);
        registry.add(ModItems.GRAPES, 0.35f);
    }

    public static void registerModFlammableBlock() {
        StarlightDelight.LOGGER.info("Registering Flammable Mod Blocks for " + StarlightDelight.MOD_ID);
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.CINNAMON_LOG, 5, 5);
        registry.add(ModBlocks.CINNAMON_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_CINNAMON_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_CINNAMON_WOOD, 5, 5);
        registry.add(ModBlocks.CINNAMON_LEAVES, 30, 60);
        registry.add(ModBlocks.CINNAMON_PLANKS, 5, 20);
    }

    public static void registerModStrippableBlock() {
        StarlightDelight.LOGGER.info("Registering Strippable Mod Blocks for " + StarlightDelight.MOD_ID);
        StrippableBlockRegistry.register(ModBlocks.CINNAMON_LOG, ModBlocks.STRIPPED_CINNAMON_LOG);
        StrippableBlockRegistry.register(ModBlocks.CINNAMON_WOOD, ModBlocks.STRIPPED_CINNAMON_WOOD);
    }
}