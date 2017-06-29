package com.mcmoddev.endmetals.util;

import java.io.*;
import java.util.*;

import com.mcmoddev.endmetals.EndMetals;
import com.mcmoddev.lib.registry.CrusherRecipeRegistry;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.MissingModsException;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.versioning.ArtifactVersion;
import net.minecraftforge.fml.common.versioning.DefaultArtifactVersion;

/**
 * @author Jasmine Iwanek
 *
 */
public class Config {

	private static Configuration configuration;
	private static final String CONFIG_FILE = "config/EndMetals.cfg";
	private static final String ORESPAWN = "OreSpawn";
	private static final String ENDORE = "End Ores";
	private static final String COMPAT = "Mod Compat";
	private static final String GENERAL = "General";
	private static final String MMDLIB = "MMD Lib";

	@SubscribeEvent
	public void onConfigChange(ConfigChangedEvent.OnConfigChangedEvent e) {
		if (e.getModID().equals(EndMetals.MODID)) {
			init();
		}
	}

	public static void init() {
		if (configuration == null) {
			configuration = new Configuration(new File(CONFIG_FILE));
			MinecraftForge.EVENT_BUS.register(new Config());
		}

		//General
		Options.enableFurnaceSmelting = configuration.getBoolean("enableFurnaceSmelting", GENERAL, true, "EnableFurnaceSmelting");
		Options.smeltToIngots = configuration.getBoolean("smeltToIngots", GENERAL, false, "By default nether ores smelt to 2 standard ores - with this option you get 2 ingots");
		Options.makeDusts = configuration.getBoolean("makeDusts", GENERAL, false, "Normally hitting a Nether Ore with a Crackhammer gives you 2 normal ores. With this option you get 4 dusts");
/*
		Options.explosionChance = configuration.get("mean", "OreExplosionChance", 2, "Explosion Percentage Chance\nSet to 0 to not explode").getInt();
		Options.angerPigmenRange = configuration.get("mean", "PigmenAngerRange", 20, "Anger Pigmen Range\nRequires PigmenAnger").getInt();
*/

		//End Ores
		Options.enableCoalEndOre = configuration.getBoolean("enableCoalEndOre", ENDORE, true, "Enable Coal End Ore");
		Options.enableDiamondEndOre = configuration.getBoolean("enableDiamondEndOre", ENDORE, true, "Enable Diamond End Ore");
		Options.enableEmeraldEndOre = configuration.getBoolean("enableEmeraldEndOre", ENDORE, true, "Enable Emerald End Ore");
		Options.enableGoldEndOre = configuration.getBoolean("enableGoldEndOre", ENDORE, true, "Enable Gold End Ore");
		Options.enableIronEndOre = configuration.getBoolean("enableIronEndOre", ENDORE, true, "Enable Iron End Ore");
		Options.enableLapisEndOre = configuration.getBoolean("enableLapisEndOre", ENDORE, true, "Enable Lapis End Ore");
		Options.enableRedstoneEndOre = configuration.getBoolean("enableRedstoneEndOre", ENDORE, true, "Enable Redstone End Ore");

		Options.enableAntimonyEndOre = configuration.getBoolean("enableAntimonyEndOre", ENDORE, true, "Enable Antimony End Ore");
		Options.enableBismuthEndOre = configuration.getBoolean("enableBismuthEndOre", ENDORE, true, "Enable Bismuth End Ore");
		Options.enableCopperEndOre = configuration.getBoolean("enableCopperEndOre", ENDORE, true, "Enable Copper End Ore");
		Options.enableLeadEndOre = configuration.getBoolean("enableLeadEndOre", ENDORE, true, "Enable Lead End Ore");
		Options.enableMercuryEndOre = configuration.getBoolean("enableMercuryEndOre", ENDORE, true, "Enable Mercury End Ore");
		Options.enableNickelEndOre = configuration.getBoolean("enableNickelEndOre", ENDORE, true, "Enable Nickel End Ore");
		Options.enablePlatinumEndOre = configuration.getBoolean("enablePlatinumEndOre", ENDORE, true, "Enable Platinum End Ore");
		Options.enableSilverEndOre = configuration.getBoolean("enableSilverEndOre", ENDORE, true, "Enable Silver End Ore");
		Options.enableTinEndOre = configuration.getBoolean("enableTinEndOre", ENDORE, true, "Enable Tin End Ore");
		Options.enableZincEndOre = configuration.getBoolean("enableZincEndOre", ENDORE, true, "Enable Zinc End Ore");
		Options.enableAluminumEndOre = configuration.getBoolean("enableAluminumEndOre", ENDORE, true, "Enable Aluminum End Ore");
		Options.enableCadmiumEndOre = configuration.getBoolean("enableCadmiumEndOre", ENDORE, true, "Enable Cadmium End Ore");
		Options.enableChromiumEndOre = configuration.getBoolean("enableChromiumEndOre", ENDORE, true, "Enable Chromium End Ore");
		Options.enableIridiumEndOre = configuration.getBoolean("enableIridiumEndOre", ENDORE, true, "Enable Iridium End Ore");
		Options.enableMagnesiumEndOre = configuration.getBoolean("enableMagnesiumEndOre", ENDORE, true, "Enable Magnesium End Ore");
		Options.enableManganeseEndOre = configuration.getBoolean("enableManganeseEndOre", ENDORE, true, "Enable Manganese End Ore");
		Options.enableOsmiumEndOre = configuration.getBoolean("enableOsmiumEndOre", ENDORE, true, "Enable Osmium End Ore");
		Options.enablePlutoniumEndOre = configuration.getBoolean("enablePlutoniumEndOre", ENDORE, true, "Enable Plutonium End Ore");
		Options.enableRutileEndOre = configuration.getBoolean("enableRutileEndOre", ENDORE, true, "Enable Rutile End Ore");
		Options.enableTantalumEndOre = configuration.getBoolean("enableTantalumEndOre", ENDORE, true, "Enable Tantalum End Ore");
		Options.enableTitaniumEndOre = configuration.getBoolean("enableTitaniumEndOre", ENDORE, true, "Enable Titanium End Ore");
		Options.enableTungstenEndOre = configuration.getBoolean("enableTungstenEndOre", ENDORE, true, "Enable Tungsten End Ore");
		Options.enableUraniumEndOre = configuration.getBoolean("enableUraniumEndOre", ENDORE, true, "Enable Uranium End Ore");
		Options.enableZirconiumEndOre = configuration.getBoolean("enableZirconiumEndOre", ENDORE, true, "Enable Zirconium End Ore");

		//Mod Compat
		Options.requireMMDLib = configuration.getBoolean("requireMMDLib", MMDLIB, false, "Require MMD Lib");
		Options.requireMMDOreSpawn = configuration.getBoolean("requireMMDOreSpawn", ORESPAWN, true, "Require MMD OreSpawn");
		Options.enableVeinminer = configuration.getBoolean("enableVeinminer", COMPAT, true, "Enable Veinminer Support");
		Options.enableTinkersConstruct = configuration.getBoolean("enableTinkersConstruct", COMPAT, false, "Enable Tinkers Construct Support");

		if (configuration.hasChanged()) {
			configuration.save();
		}

		if (Options.requireMMDOreSpawn) {
			if (!Loader.isModLoaded("orespawn")) {
				final HashSet<ArtifactVersion> orespawnMod = new HashSet<>();
				orespawnMod.add(new DefaultArtifactVersion("3.0.0"));
				throw new MissingModsException(orespawnMod, "orespawn", "MMD Ore Spawn Mod");
			}
		}
	}

	public static class Options {

		public static boolean makeDusts;
		public static boolean smeltToIngots;
		public static boolean requireMMDLib = false;
		public static boolean requireMMDOreSpawn = true;
		public static boolean enableTinkersConstruct = false;
		public static boolean enableVeinminer = false;
/*
		public static int explosionChance = 0;
		public static int angerPigmenRange = 0;
		public static boolean angerPigmen = false;
*/
		public static boolean enableFurnaceSmelting = true;

		public static boolean enableCoalEndOre = true;
		public static boolean enableDiamondEndOre = true;
		public static boolean enableEmeraldEndOre = true;
		public static boolean enableGoldEndOre = true;
		public static boolean enableIronEndOre = true;
		public static boolean enableLapisEndOre = true;
		public static boolean enableRedstoneEndOre = true;

		public static boolean enableAntimonyEndOre = true;
		public static boolean enableBismuthEndOre = true;
		public static boolean enableCopperEndOre = true;
		public static boolean enableLeadEndOre = true;
		public static boolean enableMercuryEndOre = true;
		public static boolean enableNickelEndOre = true;
		public static boolean enablePlatinumEndOre = true;
		public static boolean enableSilverEndOre = true;
		public static boolean enableTinEndOre = true;
		public static boolean enableZincEndOre = true;
		
		public static boolean enableAluminumEndOre = true;
		public static boolean enableCadmiumEndOre = true;
		public static boolean enableChromiumEndOre = true;
		public static boolean enableIridiumEndOre = true;
		public static boolean enableMagnesiumEndOre = true;
		public static boolean enableManganeseEndOre = true;
		public static boolean enableOsmiumEndOre = true;
		public static boolean enablePlutoniumEndOre = true;
		public static boolean enableRutileEndOre = true;
		public static boolean enableTantalumEndOre = true;
		public static boolean enableTitaniumEndOre = true;
		public static boolean enableTungstenEndOre = true;
		public static boolean enableUraniumEndOre = true;
		public static boolean enableZirconiumEndOre = true;

		private Options() {
			throw new IllegalAccessError("Not a instantiable class");
		}
/*
		public static int getExplosionChance() {
			return explosionChance;
		}

		public static boolean isAngerPigmen() {
			return angerPigmen;
		}

		public static int getAngerPigmenRange() {
			return angerPigmenRange;
		}
*/
	}

	public static void postInit() {
		CrusherRecipeRegistry.getInstance().clearCache();
	}
}
