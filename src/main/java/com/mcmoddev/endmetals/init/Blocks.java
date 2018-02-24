package com.mcmoddev.endmetals.init;

import com.mcmoddev.lib.block.*;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.data.SharedStrings;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.util.Oredicts;

import net.minecraft.block.Block;

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

		createVanillaEndOreWrapper("coal");
		createVanillaEndOreWrapper("diamond");
		createVanillaEndOreWrapper("emerald");
		createVanillaEndOreWrapper("gold");
		createVanillaEndOreWrapper("iron");
		createVanillaEndOreWrapper("lapis");
		createVanillaEndOreWrapper("redstone");

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

	private static void createVanillaEndOreWrapper(String materialName) {
		final MMDMaterial material = Materials.getMaterialByName(materialName);
			material.addNewBlock(Names.ENDORE, addBlock(new BlockMMDEndOre(material), Names.ENDORE.toString(), material, ItemGroups.getTab(SharedStrings.TAB_BLOCKS)));
			final Block b = material.getBlock(Names.ENDORE);
			final String oredict = getOredictFromName(Names.ENDORE);
			if ((oredict != null) && (b != null)) {
				Oredicts.registerOre(oredict + material.getCapitalizedName(), b);
			}
	}

	private static void createEndOreWrapper(String materialName) {
		if (Materials.hasMaterial(materialName)) {
			create(Names.ENDORE, materialName);
		}
	}
}
