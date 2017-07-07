package com.mcmoddev.endmetals.init;

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

		// Vanilla
		recipeWrapper(true, Materials.getMaterialByName("coal"));
		recipeWrapper(true, Materials.getMaterialByName("diamond"));
		recipeWrapper(true, Materials.getMaterialByName("emerald"));
		recipeWrapper(true, Materials.getMaterialByName("gold"));
		recipeWrapper(true, Materials.getMaterialByName("iron"));
		recipeWrapper(true, Materials.getMaterialByName("lapis"));
		recipeWrapper(true, Materials.getMaterialByName("redstone"));

		// Base Metals
		if (Loader.isModLoaded("basemetals")) {
			recipeWrapper(true, Materials.getMaterialByName("antimony"));
			recipeWrapper(true, Materials.getMaterialByName("bismuth"));
			recipeWrapper(true, Materials.getMaterialByName("copper"));
			recipeWrapper(true, Materials.getMaterialByName("lead"));
			recipeWrapper(true, Materials.getMaterialByName("mercury"));
			recipeWrapper(true, Materials.getMaterialByName("nickel"));
			recipeWrapper(true, Materials.getMaterialByName("platinum"));
			recipeWrapper(true, Materials.getMaterialByName("silver"));
			recipeWrapper(true, Materials.getMaterialByName("tin"));
			recipeWrapper(true, Materials.getMaterialByName("zinc"));
		}

		// Modern Metals
		if (Loader.isModLoaded("modernmetals")) {
			recipeWrapper(true, Materials.getMaterialByName("aluminum"));
			recipeWrapper(true, Materials.getMaterialByName("cadmium"));
			recipeWrapper(true, Materials.getMaterialByName("chromium"));
			recipeWrapper(true, Materials.getMaterialByName("iridium"));
			recipeWrapper(true, Materials.getMaterialByName("magnesium"));
			recipeWrapper(true, Materials.getMaterialByName("manganese"));
			recipeWrapper(true, Materials.getMaterialByName("osmium"));
			recipeWrapper(true, Materials.getMaterialByName("plutonium"));
			recipeWrapper(true, Materials.getMaterialByName("rutile"));
			recipeWrapper(true, Materials.getMaterialByName("tantalum"));
			recipeWrapper(true, Materials.getMaterialByName("titanium"));
			recipeWrapper(true, Materials.getMaterialByName("tungsten"));
			recipeWrapper(true, Materials.getMaterialByName("uranium"));
			recipeWrapper(true, Materials.getMaterialByName("zirconium"));
		}
	}

	private static void recipeWrapper(boolean enabled, MMDMaterial material) {
		if (enabled && material != null) {
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
