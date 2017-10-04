package com.mcmoddev.endmetals.init;

import com.mcmoddev.basemetals.data.MaterialNames;
import com.mcmoddev.endmetals.EndMetals;
import com.mcmoddev.lib.util.ConfigBase.Options;

import net.minecraftforge.fml.common.Loader;

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
		
		createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.COAL), Materials.getMaterialByName(MaterialNames.COAL));
		createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.DIAMOND), Materials.getMaterialByName(MaterialNames.DIAMOND));
		createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.EMERALD), Materials.getMaterialByName(MaterialNames.EMERALD));
		createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.GOLD), Materials.getMaterialByName(MaterialNames.GOLD));
		createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.IRON), Materials.getMaterialByName(MaterialNames.IRON));
		createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.LAPIS), Materials.getMaterialByName(MaterialNames.LAPIS));
		createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.REDSTONE), Materials.getMaterialByName(MaterialNames.REDSTONE));

		if( Loader.isModLoaded("basemetals") ) {
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.ANTIMONY), Materials.getMaterialByName(MaterialNames.ANTIMONY));
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.BISMUTH), Materials.getMaterialByName(MaterialNames.BISMUTH));
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.COPPER), Materials.getMaterialByName(MaterialNames.COPPER));
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.LEAD), Materials.getMaterialByName(MaterialNames.LEAD));
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.MERCURY), Materials.getMaterialByName(MaterialNames.MERCURY));
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.NICKEL), Materials.getMaterialByName(MaterialNames.NICKEL));
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.PLATINUM), Materials.getMaterialByName(MaterialNames.PLATINUM));
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.SILVER), Materials.getMaterialByName(MaterialNames.SILVER));
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.TIN), Materials.getMaterialByName(MaterialNames.TIN));
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.ZINC), Materials.getMaterialByName(MaterialNames.ZINC));
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.ZINC), Materials.getMaterialByName(MaterialNames.ZINC));
		}

		if( Loader.isModLoaded("modernmetals") ) {
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.ALUMINUM), Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.ALUMINUM));
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.CADMIUM), Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.CADMIUM));
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.CHROMIUM), Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.CHROMIUM));
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.IRIDIUM), Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.IRIDIUM));
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.MAGNESIUM), Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.MAGNESIUM));
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.MANGANESE), Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.MANGANESE));
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.OSMIUM), Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.OSMIUM));
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.PLUTONIUM), Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.PLUTONIUM));
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.RUTILE), Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.RUTILE));
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.TANTALUM), Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.TANTALUM));
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.TITANIUM), Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.TITANIUM));
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.TUNGSTEN), Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.TUNGSTEN));
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.URANIUM), Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.URANIUM));
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.ZIRCONIUM), Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.ZIRCONIUM));
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.ZIRCONIUM), Materials.getMaterialByName(com.mcmoddev.modernmetals.data.MaterialNames.ZIRCONIUM));
		}

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
