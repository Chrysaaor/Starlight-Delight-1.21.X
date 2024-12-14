package net.chrysaor.chrysaormod;

import net.chrysaor.chrysaormod.block.ModBlocks;
import net.chrysaor.chrysaormod.component.ModDataComponentTypes;
import net.chrysaor.chrysaormod.effect.ModEffects;
import net.chrysaor.chrysaormod.enchantment.ModEnchantmentEffects;
import net.chrysaor.chrysaormod.item.ModRegistries;
import net.chrysaor.chrysaormod.item.ModItemGroups;
import net.chrysaor.chrysaormod.item.ModItems;
import net.chrysaor.chrysaormod.particle.ModParticles;
import net.chrysaor.chrysaormod.sound.ModSounds;
import net.chrysaor.chrysaormod.util.HammerUsageEvent;
import net.chrysaor.chrysaormod.util.ModLootTableModifiers;
import net.chrysaor.chrysaormod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChrysaorMod implements ModInitializer {
	public static final String MOD_ID = "chrysaormod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier id(String value) {
		return Identifier.of(MOD_ID, value);
    }

    @Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModSounds.registerSounds();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModParticles.registerParticle();

		ModEffects.registerEffects();

		ModDataComponentTypes.registerDataComponentTypes();

		ModEnchantmentEffects.registerEnchantmentEffects();

		ModLootTableModifiers.modifyLootTables();

		ModWorldGeneration.generateModWorldGen();

		ModRegistries.registerModFuels();
		ModRegistries.registerModCropCompostable();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

	}
}