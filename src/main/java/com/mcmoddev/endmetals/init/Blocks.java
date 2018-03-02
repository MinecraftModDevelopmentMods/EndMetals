package com.mcmoddev.endmetals.init;

import java.util.Arrays;
import java.util.List;

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
		List<String> knownMaterials = Arrays.asList("coal", "diamond", "emerald", "gold", "iron", "lapis",
				"redstone", "antimony", "bismuth", "copper", "lead", "mercury", "nickel", "platinum",
				"silver", "tin", "zinc", "aluminum", "cadmium", "chromium", "iridium", "magnesium",
				"manganese", "osmium", "plutonium", "rutile", "tantalum", "titanium", "tungsten",
				"uranium", "zirconium");
		Materials.getAllMaterials().stream()
		.map(mat -> mat.getName())
		.filter(knownMaterials::contains)
		.forEach(Blocks::createEndOreWrapper);
	}

	private static void createEndOreWrapper(String materialName) {
		List<String> vanillaMats = Arrays.asList("coal", "diamond", "emerald", "gold", "iron", "lapis", "redstone");
		if (vanillaMats.contains(materialName))
			createVanillaEndOreWrapper(materialName);
		else
			createEndOreWrapperBasic(materialName);
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

	private static void createEndOreWrapperBasic(String materialName) {
		if (Materials.hasMaterial(materialName)) {
			create(Names.ENDORE, materialName);
		}
	}
}
