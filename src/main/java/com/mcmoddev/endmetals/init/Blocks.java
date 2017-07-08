package com.mcmoddev.endmetals.init;

import com.mcmoddev.basemetals.data.MaterialNames;
import com.mcmoddev.endmetals.EndMetals;
import com.mcmoddev.lib.util.ConfigBase.Options;
import com.mcmoddev.lib.data.Names;
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
		
		createEndOreWrapper(Options.isMaterialEnabled("enableCoalEndOre"), Materials.getMaterialByName(MaterialNames.COAL));
		createEndOreWrapper(Options.isMaterialEnabled("enableDiamondEndOre"), Materials.getMaterialByName(MaterialNames.DIAMOND));
		createEndOreWrapper(Options.isMaterialEnabled("enableEmeraldEndOre"), Materials.getMaterialByName(MaterialNames.EMERALD));
		createEndOreWrapper(Options.isMaterialEnabled("enableGoldEndOre"), Materials.getMaterialByName(MaterialNames.GOLD));
		createEndOreWrapper(Options.isMaterialEnabled("enableIronEndOre"), Materials.getMaterialByName(MaterialNames.IRON));
		createEndOreWrapper(Options.isMaterialEnabled("enableLapisEndOre"), Materials.getMaterialByName(MaterialNames.LAPIS));
		createEndOreWrapper(Options.isMaterialEnabled("enableRedstoneEndOre"), Materials.getMaterialByName(MaterialNames.REDSTONE));

		createEndOreWrapper(Options.isMaterialEnabled("enableAntimonyEndOre"), Materials.getMaterialByName("antimony"));
		createEndOreWrapper(Options.isMaterialEnabled("enableBismuthEndOre"), Materials.getMaterialByName("bismuth"));
		createEndOreWrapper(Options.isMaterialEnabled("enableCopperEndOre"), Materials.getMaterialByName("copper"));
		createEndOreWrapper(Options.isMaterialEnabled("enableLeadEndOre"), Materials.getMaterialByName("lead"));
		createEndOreWrapper(Options.isMaterialEnabled("enableMercuryEndOre"), Materials.getMaterialByName("mercury"));
		createEndOreWrapper(Options.isMaterialEnabled("enableNickelEndOre"), Materials.getMaterialByName("nickel"));
		createEndOreWrapper(Options.isMaterialEnabled("enablePlatinumEndOre"), Materials.getMaterialByName("platinum"));
		createEndOreWrapper(Options.isMaterialEnabled("enableSilverEndOre"), Materials.getMaterialByName("silver"));
		createEndOreWrapper(Options.isMaterialEnabled("enableTinEndOre"), Materials.getMaterialByName("tin"));
		createEndOreWrapper(Options.isMaterialEnabled("enableZincEndOre"), Materials.getMaterialByName("zinc"));

		createEndOreWrapper(Options.isMaterialEnabled("enableAluminumEndOre"), Materials.getMaterialByName("aluminum"));
		createEndOreWrapper(Options.isMaterialEnabled("enableCadmiumEndOre"), Materials.getMaterialByName("cadmium"));
		createEndOreWrapper(Options.isMaterialEnabled("enableChromiumEndOre"), Materials.getMaterialByName("chromium"));
		createEndOreWrapper(Options.isMaterialEnabled("enableIridiumEndOre"), Materials.getMaterialByName("iridium"));
		createEndOreWrapper(Options.isMaterialEnabled("enableMagnesiumEndOre"), Materials.getMaterialByName("magnesium"));
		createEndOreWrapper(Options.isMaterialEnabled("enableManganeseEndOre"), Materials.getMaterialByName("manganese"));
		createEndOreWrapper(Options.isMaterialEnabled("enableOsmiumEndOre"), Materials.getMaterialByName("osmium"));
		createEndOreWrapper(Options.isMaterialEnabled("enablePlutoniumEndOre"), Materials.getMaterialByName("plutonium"));
		createEndOreWrapper(Options.isMaterialEnabled("enableRutileEndOre"), Materials.getMaterialByName("rutile"));
		createEndOreWrapper(Options.isMaterialEnabled("enableTantalumEndOre"), Materials.getMaterialByName("tantalum"));
		createEndOreWrapper(Options.isMaterialEnabled("enableTitaniumEndOre"), Materials.getMaterialByName("titanium"));
		createEndOreWrapper(Options.isMaterialEnabled("enableTungstenEndOre"), Materials.getMaterialByName("tungsten"));
		createEndOreWrapper(Options.isMaterialEnabled("enableUraniumEndOre"), Materials.getMaterialByName("uranium"));
		createEndOreWrapper(Options.isMaterialEnabled("enableZirconiumEndOre"), Materials.getMaterialByName("zirconium"));

		initDone = true;
	}

	private static void createEndOreWrapper(boolean enabled, MMDMaterial material) {
		if (enabled) {
			if (material != null) {
				create(Names.ENDORE, material, ItemGroups.blocksTab);
			} else {
				EndMetals.logger.error("material was null!");
			}
		}
	}
}
