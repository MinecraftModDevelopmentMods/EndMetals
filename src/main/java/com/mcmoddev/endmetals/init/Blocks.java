package com.mcmoddev.endmetals.init;

import com.mcmoddev.endmetals.EndMetals;
import com.mcmoddev.endmetals.util.Config.Options;
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

//		ItemGroups.init();

		createEndOreWrapper("coal");
		createEndOreWrapper("diamond");
		createEndOreWrapper("emerald");
		createEndOreWrapper("gold");
		createEndOreWrapper("iron");
		createEndOreWrapper("lapis");
		createEndOreWrapper("redstone");

		createEndOreWrapper("antimony");
		createEndOreWrapper("bismuth");
		createEndOreWrapper("copper");
		createEndOreWrapper("lead");
		createEndOreWrapper("mercury");
		createEndOreWrapper("nickel");
		createEndOreWrapper("platinum");
		createEndOreWrapper("silver");
		createEndOreWrapper("tin");
		createEndOreWrapper("zinc");

		createEndOreWrapper("aluminum");
		createEndOreWrapper("cadmium");
		createEndOreWrapper("chromium");
		createEndOreWrapper("iridium");
		createEndOreWrapper("magnesium");
		createEndOreWrapper("manganese");
		createEndOreWrapper("osmium");
		createEndOreWrapper("plutonium");
		createEndOreWrapper("rutile");
		createEndOreWrapper("tantalum");
		createEndOreWrapper("titanium");
		createEndOreWrapper("tungsten");
		createEndOreWrapper("uranium");
		createEndOreWrapper("zirconium");

		initDone = true;
	}

	private static void createEndOreWrapper(String materialName) {
		if (Materials.hasMaterial(materialName)) {
//			create(Names.ENDORE, Materials.getMaterialByName(materialName));
			create(Names.ENDORE, materialName);
		}
	}
}
