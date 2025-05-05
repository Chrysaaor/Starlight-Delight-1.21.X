package net.chrysaor.starlightdelight.sound;

import net.chrysaor.starlightdelight.StarlightDelight;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {





    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(StarlightDelight.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        StarlightDelight.LOGGER.info("Registering Mod Sounds for " + StarlightDelight.MOD_ID);
    }
}
