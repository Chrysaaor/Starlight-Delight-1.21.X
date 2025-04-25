package net.chrysaor.chrysaormod.screen;

import net.chrysaor.chrysaormod.ChrysaorMod;
import net.chrysaor.chrysaormod.screen.custom.FermenterScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<FermenterScreenHandler> FERMENTER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(ChrysaorMod.MOD_ID, "fermenter_screen_handler"),
                    new ExtendedScreenHandlerType<>(FermenterScreenHandler::new, BlockPos.PACKET_CODEC));



    public static void registerScreenHandlers() {
        ChrysaorMod.LOGGER.info("Registering Screen Handlers for " + ChrysaorMod.MOD_ID);
    }
}
