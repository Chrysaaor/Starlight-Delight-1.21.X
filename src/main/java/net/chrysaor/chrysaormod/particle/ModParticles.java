package net.chrysaor.chrysaormod.particle;

import net.chrysaor.chrysaormod.ChrysaorMod;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.SweepAttackParticle;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final SimpleParticleType HOELY_BEHEADER_SWEEP_ATTACK_PARTICLE = FabricParticleTypes.simple(true);

    public static void registerParticle() {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(ChrysaorMod.MOD_ID, "hoely_beheader_sweep_particle"),
                HOELY_BEHEADER_SWEEP_ATTACK_PARTICLE);
    }
}