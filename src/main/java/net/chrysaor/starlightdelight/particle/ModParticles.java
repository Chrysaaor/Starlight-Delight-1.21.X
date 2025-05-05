package net.chrysaor.starlightdelight.particle;

import net.chrysaor.starlightdelight.StarlightDelight;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles extends ParticleTypes {
    public static final SimpleParticleType HOELY_BEHEADER_SWEEP_ATTACK_PARTICLE = FabricParticleTypes.simple(true);


    public static void registerParticle() {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(StarlightDelight.MOD_ID, "hoely_beheader_sweep_particle"),
                HOELY_BEHEADER_SWEEP_ATTACK_PARTICLE);
    }
}