package net.fire_ducc.survivalist;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.fire_ducc.survivalist.effect.StasisEffect;
import net.fire_ducc.survivalist.registry.ModBlocks;
import net.fire_ducc.survivalist.registry.ModEffects;
import net.fire_ducc.survivalist.registry.ModItems;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.GlassBottleItem;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Survivalist implements ModInitializer {
	public static final String MOD_ID = "survivalist";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final RegistryKey<PlacedFeature> TIN_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("survivalist","ore_tin"));

	@Override
	public void onInitialize() {
		EntitySleepEvents.ALLOW_SETTING_SPAWN.register((player, sleepingPos) -> false);

		ModBlocks.initialize();
		ModItems.initialize();

		ModEffects.register();

		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, TIN_ORE_PLACED_KEY);

		LOGGER.info("Survivalist mod is installed");
	}
}