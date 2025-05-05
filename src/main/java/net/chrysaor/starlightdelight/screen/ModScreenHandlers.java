package net.chrysaor.starlightdelight.screen;

import net.chrysaor.starlightdelight.StarlightDelight;
import net.chrysaor.starlightdelight.screen.custom.FermenterScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<FermenterScreenHandler> FERMENTER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(StarlightDelight.MOD_ID, "fermenter_screen_handler"),
                    new ExtendedScreenHandlerType<>(FermenterScreenHandler::new, BlockPos.PACKET_CODEC));



    public static void registerScreenHandlers() {
        StarlightDelight.LOGGER.info("Registering Screen Handlers for " + StarlightDelight.MOD_ID);
    }
}
