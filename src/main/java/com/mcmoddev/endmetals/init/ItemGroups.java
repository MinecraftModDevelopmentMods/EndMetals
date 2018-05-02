package com.mcmoddev.endmetals.init;

import com.mcmoddev.endmetals.EndMetals;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.data.SharedStrings;
import com.mcmoddev.lib.init.MMDCreativeTab;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.init.Materials;

/**
 * This class initializes all item groups in End Metals.
 *
 * @author Jasmine Iwanek
 *
 */
public class ItemGroups extends com.mcmoddev.lib.init.ItemGroups {

	private static boolean initDone = false;

	private ItemGroups() {
		throw new IllegalAccessError("Not a instantiable class");
	}

	/**
	 *
	 */
	public static void init() {
		if (initDone) {
			return;
		}

		initDone = true;
	}

	public static void setupIcons(String materialName) {
		if (Materials.hasMaterial(materialName)) {
			final MMDMaterial material = Materials.getMaterialByName(materialName);

			if (material.hasBlock(Names.ENDORE)) {
				getTab(EndMetals.MODID,SharedStrings.TAB_BLOCKS).setTabIconItem(material.getBlock(Names.ENDORE));
			}
		}
	}
}
