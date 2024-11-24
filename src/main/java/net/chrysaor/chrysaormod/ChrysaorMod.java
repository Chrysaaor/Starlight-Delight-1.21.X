package net.chrysaor.chrysaormod;

import net.chrysaor.chrysaormod.block.ModBlocks;
import net.chrysaor.chrysaormod.component.ModDataComponentTypes;
import net.chrysaor.chrysaormod.item.ModRegistries;
import net.chrysaor.chrysaormod.item.ModItemGroups;
import net.chrysaor.chrysaormod.item.ModItems;
import net.chrysaor.chrysaormod.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChrysaorMod implements ModInitializer {
	public static final String MOD_ID = "chrysaormod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();

		ModRegistries.registerModFuels();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}