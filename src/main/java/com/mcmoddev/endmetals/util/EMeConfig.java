package com.mcmoddev.endmetals.util;

import java.io.File;

import com.mcmoddev.endmetals.EndMetals;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @author Jasmine Iwanek
 *
 */
public final class EMeConfig extends com.mcmoddev.lib.util.Config {

	private static Configuration configuration;
	private static final String CONFIG_FILE = "config/EndMetals.cfg";
	private static final String ENDORE = "End Ores";
	private static final String GENERAL = "General";

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public void onConfigChange(final ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(EndMetals.MODID)) {
			init();
		}
	}

	/**
	 *
	 */
	public static void init() {
		if (configuration == null) {
			configuration = new Configuration(new File(CONFIG_FILE));
			MinecraftForge.EVENT_BUS.register(new EMeConfig());
		}

		// General
		Options.thingEnabled("enableFurnaceSmelting", configuration.getBoolean("enableFurnaceSmelting", GENERAL, true, "Enable Furnace Smelting"));
		Options.thingEnabled("smeltToIngots", configuration.getBoolean("smeltToIngots", GENERAL, false, "By default nether ores smelt to 2 standard ores - with this option you get 2 ingots"));
		Options.thingEnabled("makeDusts", configuration.getBoolean("makeDusts", GENERAL, false, "Normally hitting a Nether Ore with a Crackhammer gives you 2 normal ores. With this option you get 4 dusts"));

		// End Ores
		Options.materialEnabled("enableCoalEndOre", configuration.getBoolean("enableCoalEndOre", ENDORE, true, "Enable Coal End Ore"));
		Options.materialEnabled("enableDiamondEndOre", configuration.getBoolean("enableDiamondEndOre", ENDORE, true, "Enable Diamond End Ore"));
		Options.materialEnabled("enableEmeraldEndOre", configuration.getBoolean("enableEmeraldEndOre", ENDORE, true, "Enable Emerald End Ore"));
		Options.materialEnabled("enableGoldEndOre", configuration.getBoolean("enableGoldEndOre", ENDORE, true, "Enable Gold End Ore"));
		Options.materialEnabled("enableIronEndOre", configuration.getBoolean("enableIronEndOre", ENDORE, true, "Enable Iron End Ore"));
		Options.materialEnabled("enableLapisEndOre", configuration.getBoolean("enableLapisEndOre", ENDORE, true, "Enable Lapis End Ore"));
		Options.materialEnabled("enableRedstoneEndOre", configuration.getBoolean("enableRedstoneEndOre", ENDORE, true, "Enable Redstone End Ore"));

		Options.materialEnabled("enableAntimonyEndOre", configuration.getBoolean("enableAntimonyEndOre", ENDORE, true, "Enable Antimony End Ore"));
		Options.materialEnabled("enableBismuthEndOre", configuration.getBoolean("enableBismuthEndOre", ENDORE, true, "Enable Bismuth End Ore"));
		Options.materialEnabled("enableCopperEndOre", configuration.getBoolean("enableCopperEndOre", ENDORE, true, "Enable Copper End Ore"));
		Options.materialEnabled("enableLeadEndOre", configuration.getBoolean("enableLeadEndOre", ENDORE, true, "Enable Lead End Ore"));
		Options.materialEnabled("enableMercuryEndOre", configuration.getBoolean("enableMercuryEndOre", ENDORE, true, "Enable Mercury End Ore"));
		Options.materialEnabled("enableNickelEndOre", configuration.getBoolean("enableNickelEndOre", ENDORE, true, "Enable Nickel End Ore"));
		Options.materialEnabled("enablePlatinumEndOre", configuration.getBoolean("enablePlatinumEndOre", ENDORE, true, "Enable Platinum End Ore"));
		Options.materialEnabled("enableSilverEndOre", configuration.getBoolean("enableSilverEndOre", ENDORE, true, "Enable Silver End Ore"));
		Options.materialEnabled("enableTinEndOre", configuration.getBoolean("enableTinEndOre", ENDORE, true, "Enable Tin End Ore"));
		Options.materialEnabled("enableZincEndOre", configuration.getBoolean("enableZincEndOre", ENDORE, true, "Enable Zinc End Ore"));
		Options.materialEnabled("enableAluminumEndOre", configuration.getBoolean("enableAluminumEndOre", ENDORE, true, "Enable Aluminum End Ore"));
		Options.materialEnabled("enableCadmiumEndOre", configuration.getBoolean("enableCadmiumEndOre", ENDORE, true, "Enable Cadmium End Ore"));
		Options.materialEnabled("enableChromiumEndOre", configuration.getBoolean("enableChromiumEndOre", ENDORE, true, "Enable Chromium End Ore"));
		Options.materialEnabled("enableIridiumEndOre", configuration.getBoolean("enableIridiumEndOre", ENDORE, true, "Enable Iridium End Ore"));
		Options.materialEnabled("enableMagnesiumEndOre", configuration.getBoolean("enableMagnesiumEndOre", ENDORE, true, "Enable Magnesium End Ore"));
		Options.materialEnabled("enableManganeseEndOre", configuration.getBoolean("enableManganeseEndOre", ENDORE, true, "Enable Manganese End Ore"));
		Options.materialEnabled("enableOsmiumEndOre", configuration.getBoolean("enableOsmiumEndOre", ENDORE, true, "Enable Osmium End Ore"));
		Options.materialEnabled("enablePlutoniumEndOre", configuration.getBoolean("enablePlutoniumEndOre", ENDORE, true, "Enable Plutonium End Ore"));
		Options.materialEnabled("enableRutileEndOre", configuration.getBoolean("enableRutileEndOre", ENDORE, true, "Enable Rutile End Ore"));
		Options.materialEnabled("enableTantalumEndOre", configuration.getBoolean("enableTantalumEndOre", ENDORE, true, "Enable Tantalum End Ore"));
		Options.materialEnabled("enableTitaniumEndOre", configuration.getBoolean("enableTitaniumEndOre", ENDORE, true, "Enable Titanium End Ore"));
		Options.materialEnabled("enableTungstenEndOre", configuration.getBoolean("enableTungstenEndOre", ENDORE, true, "Enable Tungsten End Ore"));
		Options.materialEnabled("enableUraniumEndOre", configuration.getBoolean("enableUraniumEndOre", ENDORE, true, "Enable Uranium End Ore"));
		Options.materialEnabled("enableZirconiumEndOre", configuration.getBoolean("enableZirconiumEndOre", ENDORE, true, "Enable Zirconium End Ore"));

		if (configuration.hasChanged()) {
			configuration.save();
		}
	}
}
