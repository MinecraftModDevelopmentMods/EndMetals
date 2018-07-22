package com.mcmoddev.endmetals.init;

import java.util.Arrays;
import java.util.List;

import com.mcmoddev.lib.block.BlockMMDEndOre;
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
public final class EndBlocks extends com.mcmoddev.lib.init.Blocks {

	/**
	 *
	 */
	public static void init() {
		final List<String> knownMaterials = Arrays.asList("coal", "diamond", "emerald", "gold", "iron", "lapis",
				"redstone", "antimony", "bismuth", "copper", "lead", "mercury", "nickel", "platinum",
				"silver", "tin", "zinc", "aluminum", "cadmium", "chromium", "iridium", "magnesium",
				"manganese", "osmium", "plutonium", "rutile", "tantalum", "titanium", "tungsten",
				"uranium", "zirconium");
		Materials.getAllMaterials().stream()
		.map(material -> material.getName())
		.filter(knownMaterials::contains)
		.filter(Materials::hasMaterial)
		.forEach(EndBlocks::createOreWrapper);
	}

	private static void createOreWrapper(final String materialName) {
		final List<String> vanillaMats = Arrays.asList("coal", "diamond", "emerald", "gold", "iron", "lapis", "redstone");

		if (vanillaMats.contains(materialName)) {
			createVanillaOreWrapper(materialName);
		} else {
			create(Names.ENDORE, materialName);
		}
	}

	private static void createVanillaOreWrapper(final String materialName) {
		final MMDMaterial material = Materials.getMaterialByName(materialName);
		material.addNewBlock(Names.ENDORE, addBlock(new BlockMMDEndOre(material), Names.ENDORE.toString(), material, ItemGroups.getTab(SharedStrings.TAB_BLOCKS)));
		final Block block = material.getBlock(Names.ENDORE);
		final String oredict = getOredictFromName(Names.ENDORE);
		if ((oredict != null) && (block != null)) {
			Oredicts.registerOre(oredict + material.getCapitalizedName(), block);
		}
	}
}
