package com.mcmoddev.endmetals.init;

import com.mcmoddev.endmetals.EndMetals;
import com.mcmoddev.endmetals.util.Config.Options;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.material.MMDMaterial;

/**
 * This class initializes all blocks in End Metals.
 *
 * @author Jasmine Iwanek
 *
 */
public class Blocks extends com.mcmoddev.lib.init.Blocks {

	private static boolean initDone = false;

	/**
	 *
	 */
	public static void init() {
		if (initDone) {
			return;
		}

		Materials.init();
//		ItemGroups.init();

		createEndOreWrapper(Options.enableCoalEndOre, Materials.getMaterialByName("coal"));
		createEndOreWrapper(Options.enableDiamondEndOre, Materials.getMaterialByName("diamond"));
		createEndOreWrapper(Options.enableEmeraldEndOre, Materials.getMaterialByName("emerald"));
		createEndOreWrapper(Options.enableGoldEndOre, Materials.getMaterialByName("gold"));
		createEndOreWrapper(Options.enableIronEndOre, Materials.getMaterialByName("iron"));
		createEndOreWrapper(Options.enableLapisEndOre, Materials.getMaterialByName("lapis"));
		createEndOreWrapper(Options.enableRedstoneEndOre, Materials.getMaterialByName("redstone"));

		createEndOreWrapper(Options.enableAntimonyEndOre, Materials.getMaterialByName("antimony"));
		createEndOreWrapper(Options.enableBismuthEndOre, Materials.getMaterialByName("bismuth"));
		createEndOreWrapper(Options.enableCopperEndOre, Materials.getMaterialByName("copper"));
		createEndOreWrapper(Options.enableLeadEndOre, Materials.getMaterialByName("lead"));
		createEndOreWrapper(Options.enableMercuryEndOre, Materials.getMaterialByName("mercury"));
		createEndOreWrapper(Options.enableNickelEndOre, Materials.getMaterialByName("nickel"));
		createEndOreWrapper(Options.enablePlatinumEndOre, Materials.getMaterialByName("platinum"));
		createEndOreWrapper(Options.enableSilverEndOre, Materials.getMaterialByName("silver"));
		createEndOreWrapper(Options.enableTinEndOre, Materials.getMaterialByName("tin"));
		createEndOreWrapper(Options.enableZincEndOre, Materials.getMaterialByName("zinc"));

		createEndOreWrapper(Options.enableAluminumEndOre, Materials.getMaterialByName("aluminum"));
		createEndOreWrapper(Options.enableCadmiumEndOre, Materials.getMaterialByName("cadmium"));
		createEndOreWrapper(Options.enableChromiumEndOre, Materials.getMaterialByName("chromium"));
		createEndOreWrapper(Options.enableIridiumEndOre, Materials.getMaterialByName("iridium"));
		createEndOreWrapper(Options.enableMagnesiumEndOre, Materials.getMaterialByName("magnesium"));
		createEndOreWrapper(Options.enableManganeseEndOre, Materials.getMaterialByName("manganese"));
		createEndOreWrapper(Options.enableOsmiumEndOre, Materials.getMaterialByName("osmium"));
		createEndOreWrapper(Options.enablePlutoniumEndOre, Materials.getMaterialByName("plutonium"));
		createEndOreWrapper(Options.enableRutileEndOre, Materials.getMaterialByName("rutile"));
		createEndOreWrapper(Options.enableTantalumEndOre, Materials.getMaterialByName("tantalum"));
		createEndOreWrapper(Options.enableTitaniumEndOre, Materials.getMaterialByName("titanium"));
		createEndOreWrapper(Options.enableTungstenEndOre, Materials.getMaterialByName("tungsten"));
		createEndOreWrapper(Options.enableUraniumEndOre, Materials.getMaterialByName("uranium"));
		createEndOreWrapper(Options.enableZirconiumEndOre, Materials.getMaterialByName("zirconium"));

		initDone = true;
	}

	private static void createEndOreWrapper(boolean enabled, MMDMaterial material) {
		if (enabled) {
			if (material != null) {
				createEndOre(material);				
			} else {
				EndMetals.logger.error("material was null!");
			}
		}
	}
}
