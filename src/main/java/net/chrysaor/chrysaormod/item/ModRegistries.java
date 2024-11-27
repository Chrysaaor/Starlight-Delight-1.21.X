package net.chrysaor.chrysaormod.item;

import net.chrysaor.chrysaormod.ChrysaorMod;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {

    public static void registerModFuels() {
        ChrysaorMod.LOGGER.info("Registering Mod Fuels for " + ChrysaorMod.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.STARLIGHT_ASHES, 3200);
    }

    public static void registerModCropCompostable() {
        ChrysaorMod.LOGGER.info("Registering Compostable Mod Crops for " + ChrysaorMod.MOD_ID);
        CompostingChanceRegistry registry = CompostingChanceRegistry.INSTANCE;

        registry.add(ModItems.CAULIFLOWER_SEEDS, 0.25f);
        registry.add(ModItems.CAULIFLOWER, 0.5f);
    }
}
