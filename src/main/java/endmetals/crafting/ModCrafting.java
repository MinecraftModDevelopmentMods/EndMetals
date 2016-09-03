package endmetals.crafting;

import cyano.basemetals.registry.CrusherRecipeRegistry;
import dank.modularity.framework.common.init.FrameworkContent;
import endmetals.blocks.ModBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModCrafting {

	public static void initCrafting() {

		// Vanilla
		GameRegistry.addSmelting(ModBlocks.endcoalOre, new ItemStack(Blocks.COAL_ORE, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.enddiamondOre, new ItemStack(Blocks.DIAMOND_ORE, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.endemeraldOre, new ItemStack(Blocks.EMERALD_ORE, 2), 1.0f); 
		GameRegistry.addSmelting(ModBlocks.endgoldOre, new ItemStack(Blocks.GOLD_ORE, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.endironOre, new ItemStack(Blocks.IRON_ORE, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.endlapisOre, new ItemStack(Blocks.LAPIS_ORE, 2), 1.0f);
		GameRegistry.addSmelting(ModBlocks.endredstoneOre, new ItemStack(Blocks.REDSTONE_ORE, 2), 1.0f);

		
		if(Loader.isModLoaded("modularity")) {
			GameRegistry.addSmelting(ModBlocks.endcopperOre, new ItemStack(FrameworkContent.resourceOre, 2 , 0), 1.0f);
			GameRegistry.addSmelting(ModBlocks.endleadOre, new ItemStack(FrameworkContent.resourceOre, 2 , 3), 1.0f);
			GameRegistry.addSmelting(ModBlocks.endsilverOre, new ItemStack(FrameworkContent.resourceOre, 2 , 2), 1.0f);
			GameRegistry.addSmelting(ModBlocks.endtinOre, new ItemStack(FrameworkContent.resourceOre, 2 , 1), 1.0f);

			}
		
		
		// Vanilla BM Hammer Compat
		if(Loader.isModLoaded("basemetals")) {
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endcoalOre, new ItemStack(Blocks.COAL_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.enddiamondOre, new ItemStack(Blocks.DIAMOND_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endemeraldOre, new ItemStack(Blocks.EMERALD_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endgoldOre, new ItemStack(Blocks.GOLD_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endironOre, new ItemStack(Blocks.IRON_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endlapisOre, new ItemStack(Blocks.LAPIS_ORE, 2));
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endredstoneOre, new ItemStack(Blocks.REDSTONE_ORE, 2));			
		}

		// Base Metals
		if(Loader.isModLoaded("basemetals")) {
//			GameRegistry.addSmelting(ModBlocks.endantimonyOre, new ItemStack(BmBlocks.antimony_ore, 2), 1.0f);				// Not supported in BM 2.2.2
//			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endantimonyOre, new ItemStack(BmBlocks.antimony_ore, 2));	// Not supported in BM 2.2.2
//			GameRegistry.addSmelting(ModBlocks.endbismuthOre, new ItemStack(BmBlocks.bismuth_ore, 2), 1.0f);				// Not supported in BM 2.2.2
//			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endbismuthOre, new ItemStack(BmBlocks.bismuth_ore, 2));		// Not supported in BM 2.2.2
			GameRegistry.addSmelting(ModBlocks.endcopperOre, new ItemStack(BmBlocks.copper_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endcopperOre, new ItemStack(BmBlocks.copper_ore, 2));
			GameRegistry.addSmelting(ModBlocks.endleadOre, new ItemStack(BmBlocks.lead_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endleadOre, new ItemStack(BmBlocks.lead_ore, 2));
			GameRegistry.addSmelting(ModBlocks.endmercuryOre, new ItemStack(BmBlocks.mercury_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endmercuryOre, new ItemStack(BmBlocks.mercury_ore, 2));
			GameRegistry.addSmelting(ModBlocks.endnickelOre, new ItemStack(BmBlocks.nickel_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endnickelOre, new ItemStack(BmBlocks.nickel_ore, 2));
			GameRegistry.addSmelting(ModBlocks.endplatinumOre, new ItemStack(BmBlocks.platinum_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endplatinumOre, new ItemStack(BmBlocks.platinum_ore, 2));
			GameRegistry.addSmelting(ModBlocks.endsilverOre, new ItemStack(BmBlocks.silver_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endsilverOre, new ItemStack(BmBlocks.silver_ore, 2));
			GameRegistry.addSmelting(ModBlocks.endtinOre, new ItemStack(BmBlocks.tin_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endtinOre, new ItemStack(BmBlocks.tin_ore, 2));
			GameRegistry.addSmelting(ModBlocks.endzincOre, new ItemStack(BmBlocks.zinc_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endzincOre, new ItemStack(BmBlocks.zinc_ore, 2));
		}

		// Modern Metals
		if(Loader.isModLoaded("modernmetals")) {
			GameRegistry.addSmelting(ModBlocks.endaluminumOre, new ItemStack(MmBlocks.aluminum_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endaluminumOre, new ItemStack(MmBlocks.aluminum_ore, 2));
			GameRegistry.addSmelting(ModBlocks.endcadmiumOre, new ItemStack(MmBlocks.cadmium_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endcadmiumOre, new ItemStack(MmBlocks.cadmium_ore, 2));
			GameRegistry.addSmelting(ModBlocks.endchromiumOre, new ItemStack(MmBlocks.chromium_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endchromiumOre, new ItemStack(MmBlocks.chromium_ore, 2));
			GameRegistry.addSmelting(ModBlocks.endiridiumOre, new ItemStack(MmBlocks.iridium_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endiridiumOre, new ItemStack(MmBlocks.iridium_ore, 2));
			GameRegistry.addSmelting(ModBlocks.endmagnesiumOre, new ItemStack(MmBlocks.magnesium_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endmagnesiumOre, new ItemStack(MmBlocks.magnesium_ore, 2));
			GameRegistry.addSmelting(ModBlocks.endmanganeseOre, new ItemStack(MmBlocks.manganese_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endmanganeseOre, new ItemStack(MmBlocks.manganese_ore, 2));
			GameRegistry.addSmelting(ModBlocks.endosmiumOre, new ItemStack(MmBlocks.osmium_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endosmiumOre, new ItemStack(MmBlocks.osmium_ore, 2));
			GameRegistry.addSmelting(ModBlocks.endplutoniumOre, new ItemStack(MmBlocks.plutonium_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endplutoniumOre, new ItemStack(MmBlocks.plutonium_ore, 2));
			GameRegistry.addSmelting(ModBlocks.endrutileOre, new ItemStack(MmBlocks.rutile_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endrutileOre, new ItemStack(MmBlocks.rutile_ore, 2));
			GameRegistry.addSmelting(ModBlocks.endtantalumOre, new ItemStack(MmBlocks.tantalum_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endtantalumOre, new ItemStack(MmBlocks.tantalum_ore, 2));
			GameRegistry.addSmelting(ModBlocks.endtitaniumOre, new ItemStack(MmBlocks.titanium_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endtitaniumOre, new ItemStack(MmBlocks.titanium_ore, 2));
			GameRegistry.addSmelting(ModBlocks.endtungstenOre, new ItemStack(MmBlocks.tungsten_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endtungstenOre, new ItemStack(MmBlocks.tungsten_ore, 2));
			GameRegistry.addSmelting(ModBlocks.enduraniumOre, new ItemStack(MmBlocks.uranium_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.enduraniumOre, new ItemStack(MmBlocks.uranium_ore, 2));
			GameRegistry.addSmelting(ModBlocks.endzirconiumOre, new ItemStack(MmBlocks.zirconium_ore, 2), 1.0f);
			CrusherRecipeRegistry.addNewCrusherRecipe(ModBlocks.endzirconiumOre, new ItemStack(MmBlocks.zirconium_ore, 2));
		}
	}
}
