package net.chrysaor.starlightdelight.world.tree;

import net.chrysaor.starlightdelight.StarlightDelight;
import net.chrysaor.starlightdelight.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator CINNAMON = new SaplingGenerator(StarlightDelight.MOD_ID + ":cinnamon",
            Optional.empty(), Optional.of(ModConfiguredFeatures.CINNAMON_KEY), Optional.empty());
}
