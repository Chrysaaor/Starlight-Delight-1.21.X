package net.chrysaor.chrysaormod;

import net.chrysaor.chrysaormod.block.ModBlocks;
import net.chrysaor.chrysaormod.block.entity.ModBlockEntities;
import net.chrysaor.chrysaormod.component.ModDataComponentTypes;
import net.chrysaor.chrysaormod.effect.ModEffects;
import net.chrysaor.chrysaormod.enchantment.ModEnchantmentEffects;
import net.chrysaor.chrysaormod.entity.ModEntities;
import net.chrysaor.chrysaormod.entity.custom.MantisEntity;
import net.chrysaor.chrysaormod.item.ModRegistries;
import net.chrysaor.chrysaormod.item.ModItemGroups;
import net.chrysaor.chrysaormod.item.ModItems;
import net.chrysaor.chrysaormod.particle.ModParticles;
import net.chrysaor.chrysaormod.screen.ModScreenHandlers;
import net.chrysaor.chrysaormod.sound.ModSounds;
import net.chrysaor.chrysaormod.util.HammerUsageEvent;
import net.chrysaor.chrysaormod.util.ModLootTableModifiers;
import net.chrysaor.chrysaormod.util.StarlightHoeUsageEvent;
import net.chrysaor.chrysaormod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChrysaorMod implements ModInitializer {
	public static final String MOD_ID = "chrysaormod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier id(String value) {
		return Identifier.of(MOD_ID, value);
    }
	public static Identifier identifier() {
		return Identifier.of(MOD_ID);
	}

    @Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModSounds.registerSounds();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModBlockEntities.registerBlockEntities();

		ModParticles.registerParticle();

		ModEffects.registerEffects();

		ModDataComponentTypes.registerDataComponentTypes();

		ModEnchantmentEffects.registerEnchantmentEffects();

		ModLootTableModifiers.modifyLootTables();

		ModWorldGeneration.generateModWorldGen();

		ModEntities.registerModEntities();

		ModScreenHandlers.registerScreenHandlers();

		ModRegistries.registerModFuels();
		ModRegistries.registerModCropCompostable();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		PlayerBlockBreakEvents.BEFORE.register(new StarlightHoeUsageEvent());

		FabricDefaultAttributeRegistry.register(ModEntities.MANTIS, MantisEntity.createAttributes());
	}
}