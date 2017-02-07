package com.mcmoddev.endmetals;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {

	private static Configuration configuration;

	private static final String COMMENTS = EndMetals.NAME + " Config\n For " + EndMetals.NAME + " \n"
			+ " For " + EndMetals.NAME + " " + EndMetals.VERSION;

	private static final String ORE_SPAWN_PROB_COMMENT = "Spawn Probability\nSet to zero to disable ore spawning of this type";

	public static boolean requireOreSpawn = true;

	private static int ironOreSpawnProb = 0;
	private static int diamondOreSpawnProb = 0;
	private static int redstoneOreSpawnProb = 0;
	private static int goldOreSpawnProb = 0;
	private static int emeraldOreSpawnProb = 0;
	private static int coalOreSpawnProb = 0;
	private static int lapisOreSpawnProb = 0;

	public static void startConfig(FMLPreInitializationEvent event) {
		configuration = new Configuration(event.getSuggestedConfigurationFile());
		configuration.load(); // only need to load config once during pre initializeSoundEvents
		updateConfigInfo();
	}

	public static void updateConfigInfo() {
		try {
			configuration.addCustomCategoryComment(Configuration.CATEGORY_GENERAL, COMMENTS);

			requireOreSpawn = configuration.getBoolean("using_orespawn", "options", requireOreSpawn,
					"If false, then Base Metals will not require DrCyano's Ore Spawn mod. \n" +
					"Set to false if using another mod to manually handle ore generation.");

			ironOreSpawnProb = configuration.get(Configuration.CATEGORY_GENERAL,     "EndIronOreSpawnProb",     14, ORE_SPAWN_PROB_COMMENT).getInt();
			diamondOreSpawnProb = configuration.get(Configuration.CATEGORY_GENERAL,  "EndDiamondOreSpawnProb",   5, ORE_SPAWN_PROB_COMMENT).getInt();
			redstoneOreSpawnProb = configuration.get(Configuration.CATEGORY_GENERAL, "EndRedstoneOreSpawnProb", 12, ORE_SPAWN_PROB_COMMENT).getInt();
			lapisOreSpawnProb = configuration.get(Configuration.CATEGORY_GENERAL,    "EndLapisOreSpawnProb",     8, ORE_SPAWN_PROB_COMMENT).getInt();
			emeraldOreSpawnProb = configuration.get(Configuration.CATEGORY_GENERAL,  "EndEmeraldOreSpawnProb",   5, ORE_SPAWN_PROB_COMMENT).getInt();
			goldOreSpawnProb = configuration.get(Configuration.CATEGORY_GENERAL,     "EndGoldOreSpawnProb",      8, ORE_SPAWN_PROB_COMMENT).getInt();
			coalOreSpawnProb = configuration.get(Configuration.CATEGORY_GENERAL,     "EndCoalOreSpawnProb",     16, ORE_SPAWN_PROB_COMMENT).getInt();
		} catch (Exception e) {
			FMLLog.info("failed to load or read the config file");
		} finally {
			if (configuration.hasChanged()) {
				configuration.save();
			}
		}
	}

	public static int getIronOreSpawnProb() {
		return ironOreSpawnProb;
	}

	public static int getDiamondOreSpawnProb() {
		return diamondOreSpawnProb;
	}

	public static int getGoldOreSpawnProb() {
		return goldOreSpawnProb;
	}

	public static int getCoalOreSpawnProb() {
		return coalOreSpawnProb;
	}

	public static int getEmeraldOreSpawnProb() {
		return emeraldOreSpawnProb;
	}

	public static int getRedstoneOreSpawnProb() {
		return redstoneOreSpawnProb;
	}

	public static int getLapisOreSpawnProb() {
		return lapisOreSpawnProb;
	}
}
