package endmetals.crafting;

import cyano.basemetals.registry.CrusherRecipeRegistry;
import endmetals.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * 
 * @author Jasmine Iwanek
 * @author Knoxhack
 *
 */
public final class ModCrafting {
	
	/**
	 * 
	 */
	public static void init() {

		// Vanilla
		addVanillaRecipe(Blocks.coal_ore,     "coal",     1.0f);
		addVanillaRecipe(Blocks.diamond_ore,  "diamond",  1.0f);
		addVanillaRecipe(Blocks.emerald_ore,  "emerald",  1.0f);
		addVanillaRecipe(Blocks.gold_ore,     "gold",     1.0f);
		addVanillaRecipe(Blocks.iron_ore,     "iron",     1.0f);
		addVanillaRecipe(Blocks.lapis_ore,    "lapis",    1.0f);
		addVanillaRecipe(Blocks.redstone_ore, "redstone", 1.0f);

		// Base Metals
		if(Loader.isModLoaded("basemetals")) {

			addBMRecipe("antimony",  1.0f);
			addBMRecipe("bismuth",   1.0f);
			addBMRecipe("copper",    1.0f);
			addBMRecipe("lead",      1.0f);
			addBMRecipe("mercury",   1.0f);
			addBMRecipe("nickel",    1.0f);
			addBMRecipe("platinum",  1.0f);
			addBMRecipe("silver",    1.0f);
			addBMRecipe("tin",       1.0f);
			addBMRecipe("zinc",      1.0f);
		}

		// Modern Metals
		if(Loader.isModLoaded("modernmetals")) {

			addMMRecipe("aluminum",  1.0f);
			addMMRecipe("cadmium",   1.0f);
			addMMRecipe("chromium",  1.0f);
			addMMRecipe("iridium",   1.0f);
			addMMRecipe("magnesium", 1.0f);
			addMMRecipe("manganese", 1.0f);
			addMMRecipe("osmium",    1.0f);
			addMMRecipe("plutonium", 1.0f);
			addMMRecipe("rutile",    1.0f);
			addMMRecipe("tantalum",  1.0f);
			addMMRecipe("titanium",  1.0f);
			addMMRecipe("tungsten",  1.0f);
			addMMRecipe("uranium",   1.0f);
			addMMRecipe("zirconium", 1.0f);
		}
	}

	private static void addVanillaRecipe(Block output, String name, float xp) {
		if (ModBlocks.getBlockByName("end_"+name+"_ore") != null) {
			GameRegistry.addSmelting(ModBlocks.getBlockByName("end_"+name+"_ore"), new ItemStack(output, 2), xp);
			if(Loader.isModLoaded("basemetals")) CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.getBlockByName("end_"+name+"_ore"), new ItemStack(output, 2));
		}
	}

	private static void addBMRecipe(String name, float xp) {
		if((ModBlocks.getBlockByName("end_"+name+"_ore") != null) && (cyano.basemetals.init.Blocks.getBlockByName(name+"_ore") != null)) {
			GameRegistry.addSmelting(ModBlocks.getBlockByName("end_"+name+"_ore"), new ItemStack(cyano.basemetals.init.Blocks.getBlockByName(name+"_ore"), 2), xp);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.getBlockByName("end_"+name+"_ore"), new ItemStack(cyano.basemetals.init.Blocks.getBlockByName(name+"_ore"), 2));
		}
	}

	private static void addMMRecipe(String name, float xp) {
		if((ModBlocks.getBlockByName("end_"+name+"_ore") != null) && (modernmetals.init.Blocks.getBlockByName(name+"_ore") != null)) {
			GameRegistry.addSmelting(ModBlocks.getBlockByName("end_"+name+"_ore"), new ItemStack(modernmetals.init.Blocks.getBlockByName(name+"_ore"), 2), xp);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.getBlockByName("end_"+name+"_ore"), new ItemStack(modernmetals.init.Blocks.getBlockByName(name+"_ore"), 2));
		}
	}
}
