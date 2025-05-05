package net.chrysaor.starlightdelight;

import net.chrysaor.starlightdelight.block.ModBlocks;
import net.chrysaor.starlightdelight.block.entity.ModBlockEntities;
import net.chrysaor.starlightdelight.component.ModDataComponentTypes;
import net.chrysaor.starlightdelight.effect.ModEffects;
import net.chrysaor.starlightdelight.enchantment.ModEnchantmentEffects;
import net.chrysaor.starlightdelight.entity.ModEntities;
import net.chrysaor.starlightdelight.entity.custom.MantisEntity;
import net.chrysaor.starlightdelight.item.ModRegistries;
import net.chrysaor.starlightdelight.item.ModItemGroups;
import net.chrysaor.starlightdelight.item.ModItems;
import net.chrysaor.starlightdelight.particle.ModParticles;
import net.chrysaor.starlightdelight.recipe.ModRecipes;
import net.chrysaor.starlightdelight.screen.ModScreenHandlers;
import net.chrysaor.starlightdelight.sound.ModSounds;
import net.chrysaor.starlightdelight.util.HammerUsageEvent;
import net.chrysaor.starlightdelight.util.ModLootTableModifiers;
import net.chrysaor.starlightdelight.util.StarlightHoeUsageEvent;
import net.chrysaor.starlightdelight.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StarlightDelight implements ModInitializer {
	public static final String MOD_ID = "starlightdelight";
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

		ModRecipes.registerRecipes();

		ModRegistries.registerModFuels();
		ModRegistries.registerModCropCompostable();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		PlayerBlockBreakEvents.BEFORE.register(new StarlightHoeUsageEvent());

		FabricDefaultAttributeRegistry.register(ModEntities.MANTIS, MantisEntity.createAttributes());
	}
}