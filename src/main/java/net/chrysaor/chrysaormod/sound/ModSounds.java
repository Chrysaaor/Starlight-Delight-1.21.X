package net.chrysaor.chrysaormod.sound;

import net.chrysaor.chrysaormod.ChrysaorMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {



    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(ChrysaorMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        ChrysaorMod.LOGGER.info("Registering Mod Sounds for " + ChrysaorMod.MOD_ID);
    }
}
