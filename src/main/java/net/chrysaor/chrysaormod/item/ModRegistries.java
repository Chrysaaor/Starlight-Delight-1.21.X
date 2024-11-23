package net.chrysaor.chrysaormod.item;

import net.chrysaor.chrysaormod.ChrysaorMod;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {

    public static void registerModFuels() {
        ChrysaorMod.LOGGER.info("Registering Mod Fuels for " + ChrysaorMod.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.STARLIGHT_ASHES, 3200);
    }
}
