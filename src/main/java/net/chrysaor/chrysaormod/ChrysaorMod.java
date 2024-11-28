package net.chrysaor.chrysaormod;

import net.chrysaor.chrysaormod.block.ModBlocks;
import net.chrysaor.chrysaormod.component.ModDataComponentTypes;
import net.chrysaor.chrysaormod.enchantment.ModEnchantmentEffects;
import net.chrysaor.chrysaormod.item.ModRegistries;
import net.chrysaor.chrysaormod.item.ModItemGroups;
import net.chrysaor.chrysaormod.item.ModItems;
import net.chrysaor.chrysaormod.sound.ModSounds;
import net.chrysaor.chrysaormod.util.HammerUsageEvent;
import net.chrysaor.chrysaormod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChrysaorMod implements ModInitializer {
	public static final String MOD_ID = "chrysaormod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModSounds.registerSounds();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();

		ModEnchantmentEffects.registerEnchantmentEffects();

		ModWorldGeneration.generateModWorldGen();

		ModRegistries.registerModFuels();
		ModRegistries.registerModCropCompostable();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

	}
}