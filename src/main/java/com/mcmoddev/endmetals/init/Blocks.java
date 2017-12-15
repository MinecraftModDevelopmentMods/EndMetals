package com.mcmoddev.endmetals.init;

import com.mcmoddev.basemetals.data.MaterialNames;
import com.mcmoddev.lib.util.ConfigBase.Options;

import net.minecraftforge.fml.common.Loader;

import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.init.Materials;

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
		
		createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.COAL), MaterialNames.COAL);
		createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.DIAMOND), MaterialNames.DIAMOND);
		createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.EMERALD), MaterialNames.EMERALD);
		createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.GOLD), MaterialNames.GOLD);
		createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.IRON), MaterialNames.IRON);
		createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.LAPIS), MaterialNames.LAPIS);
		createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.REDSTONE), MaterialNames.REDSTONE);

		if( Loader.isModLoaded("basemetals") ) {
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.ANTIMONY), MaterialNames.ANTIMONY);
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.BISMUTH), MaterialNames.BISMUTH);
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.COPPER), MaterialNames.COPPER);
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.LEAD), MaterialNames.LEAD);
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.MERCURY), MaterialNames.MERCURY);
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.NICKEL), MaterialNames.NICKEL);
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.PLATINUM), MaterialNames.PLATINUM);
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.SILVER), MaterialNames.SILVER);
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.TIN), MaterialNames.TIN);
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.ZINC), MaterialNames.ZINC);
			createEndOreWrapper(Options.isMaterialEnabled(MaterialNames.ZINC), MaterialNames.ZINC);
		}

		if( Loader.isModLoaded("modernmetals") ) {
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.ALUMINUM), com.mcmoddev.modernmetals.data.MaterialNames.ALUMINUM);
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.CADMIUM), com.mcmoddev.modernmetals.data.MaterialNames.CADMIUM);
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.CHROMIUM), com.mcmoddev.modernmetals.data.MaterialNames.CHROMIUM);
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.IRIDIUM), com.mcmoddev.modernmetals.data.MaterialNames.IRIDIUM);
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.MAGNESIUM), com.mcmoddev.modernmetals.data.MaterialNames.MAGNESIUM);
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.MANGANESE), com.mcmoddev.modernmetals.data.MaterialNames.MANGANESE);
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.OSMIUM), com.mcmoddev.modernmetals.data.MaterialNames.OSMIUM);
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.PLUTONIUM), com.mcmoddev.modernmetals.data.MaterialNames.PLUTONIUM);
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.RUTILE), com.mcmoddev.modernmetals.data.MaterialNames.RUTILE);
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.TANTALUM), com.mcmoddev.modernmetals.data.MaterialNames.TANTALUM);
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.TITANIUM), com.mcmoddev.modernmetals.data.MaterialNames.TITANIUM);
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.TUNGSTEN), com.mcmoddev.modernmetals.data.MaterialNames.TUNGSTEN);
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.URANIUM), com.mcmoddev.modernmetals.data.MaterialNames.URANIUM);
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.ZIRCONIUM), com.mcmoddev.modernmetals.data.MaterialNames.ZIRCONIUM);
			createEndOreWrapper(Options.isMaterialEnabled(com.mcmoddev.modernmetals.data.MaterialNames.ZIRCONIUM), com.mcmoddev.modernmetals.data.MaterialNames.ZIRCONIUM);
		}

		initDone = true;
	}

	private static void createEndOreWrapper(boolean enabled, String materialName ) {
		if (enabled && Materials.hasMaterial(materialName)) {
			create(Names.ENDORE, Materials.getMaterialByName(materialName), ItemGroups.blocksTab);
		}
	}	
}
