package net.chrysaor.starlightdelight.item;

import net.chrysaor.starlightdelight.StarlightDelight;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {

    public static void registerModFuels() {
        StarlightDelight.LOGGER.info("Registering Mod Fuels for " + StarlightDelight.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.STARLIGHT_ASHES, 3200);
        registry.add(ModItems.STARLIGHT_FRAGMENT, 16000);
    }

    public static void registerModCropCompostable() {
        StarlightDelight.LOGGER.info("Registering Compostable Mod Crops for " + StarlightDelight.MOD_ID);
        CompostingChanceRegistry registry = CompostingChanceRegistry.INSTANCE;

        registry.add(ModItems.CAULIFLOWER_SEEDS, 0.25f);
        registry.add(ModItems.CAULIFLOWER, 0.5f);
    }
}
