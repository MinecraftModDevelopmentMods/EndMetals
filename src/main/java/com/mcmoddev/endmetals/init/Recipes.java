package com.mcmoddev.endmetals.init;

import com.mcmoddev.basemetals.data.MaterialNames;
import com.mcmoddev.endmetals.EndMetals;
import com.mcmoddev.lib.util.ConfigBase.Options;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.registry.CrusherRecipeRegistry;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Recipes {

	private Recipes() {
		throw new IllegalAccessError("Not a instantiable class");
	}

	public static void init() {
		Materials.init();
		Blocks.init(); // make sure our blocks are initialized
		// Vanilla
		recipeWrapper(true, MaterialNames.COAL);
		recipeWrapper(true, MaterialNames.DIAMOND);
		recipeWrapper(true, MaterialNames.EMERALD);
		recipeWrapper(true, MaterialNames.GOLD);
		recipeWrapper(true, MaterialNames.IRON);
		recipeWrapper(true, MaterialNames.LAPIS);
		recipeWrapper(true, MaterialNames.REDSTONE);

		// Base Metals
		if (Loader.isModLoaded("basemetals")) {
			recipeWrapper(true, "antimony");
			recipeWrapper(true, "bismuth");
			recipeWrapper(true, "copper");
			recipeWrapper(true, "lead");
			recipeWrapper(true, "mercury");
			recipeWrapper(true, "nickel");
			recipeWrapper(true, "platinum");
			recipeWrapper(true, "silver");
			recipeWrapper(true, "tin");
			recipeWrapper(true, "zinc");
		}

		// Modern Metals
		if (Loader.isModLoaded("modernmetals")) {
			recipeWrapper(true, "aluminum");
			recipeWrapper(true, "cadmium");
			recipeWrapper(true, "chromium");
			recipeWrapper(true, "iridium");
			recipeWrapper(true, "magnesium");
			recipeWrapper(true, "manganese");
			recipeWrapper(true, "osmium");
			recipeWrapper(true, "plutonium");
			recipeWrapper(true, "rutile");
			recipeWrapper(true, "tantalum");
			recipeWrapper(true, "titanium");
			recipeWrapper(true, "tungsten");
			recipeWrapper(true, "uranium");
			recipeWrapper(true, "zirconium");
		}
	}

	private static void recipeWrapper(boolean enabled, String materialName ) {
		if (enabled && Materials.hasMaterial(materialName)) {
			MMDMaterial material = Materials.getMaterialByName(materialName);
			if (material.getBlock(Names.ENDORE) != null) {
				boolean makeDusts = Options.isThingEnabled("makeDusts");
				boolean smeltToIngots = Options.isThingEnabled("smeltToIngots");
				if (Options.isThingEnabled("enableFurnaceSmelting")) {
					if (smeltToIngots) {
						if (material.getItem(Names.INGOT) != null) {
							GameRegistry.addSmelting(material.getBlock(Names.ENDORE), new ItemStack(material.getItem(Names.INGOT), 2), 1.0f);
						} else {
							EndMetals.logger.error("ingot was null for material " + material.getName());
						}
					} else {
						if (material.getBlock(Names.ORE) != null) {
							GameRegistry.addSmelting(material.getBlock(Names.ENDORE), new ItemStack(material.getBlock(Names.ORE), 2), 1.0f);
						} else {
							EndMetals.logger.error("ore was null for material " + material.getName());
						}
					}
				}
				if (makeDusts) {
					if (material.getItem(Names.POWDER) != null) {
						CrusherRecipeRegistry.addNewCrusherRecipe(material.getBlock(Names.ENDORE), new ItemStack(material.getItem(Names.POWDER), 4));
					} else {
						EndMetals.logger.error("powder was null for material " + material.getName());
					}
				} else {
					if (material.getBlock(Names.ORE) != null) {
						CrusherRecipeRegistry.addNewCrusherRecipe(material.getBlock(Names.ENDORE), new ItemStack(material.getBlock(Names.ORE), 2));
					} else {
						EndMetals.logger.error("ore was null" + material.getName());
					}
				}
			} else {
				EndMetals.logger.error("oreEnd was null");
			}
		}
	}
}
