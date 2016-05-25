package endmetals.blocks;

import endmetals.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {

	public static Block endcoalOre;
	public static Block enddiamondOre;
	public static Block endemeraldOre;
	public static Block endgoldOre;
	public static Block endironOre;
	public static Block endlapisOre;
	public static Block endredstoneOre;

	public static Block endantimonyOre;
	public static Block endbismuthOre;
	public static Block endcopperOre;
	public static Block endleadOre;
	public static Block endmercuryOre;
	public static Block endnickelOre;
	public static Block endplatinumOre;
	public static Block endsilverOre;
	public static Block endtinOre;
	public static Block endzincOre;

	public static Block endaluminumOre;
	public static Block endcadmiumOre;
	public static Block endchromiumOre;
	public static Block endiridiumOre;
	public static Block endmagnesiumOre;
	public static Block endmanganeseOre;
	public static Block endosmiumOre;
	public static Block endplutoniumOre;
	public static Block endrutileOre;
	public static Block endtantalumOre;
	public static Block endtitaniumOre;
	public static Block endtungstenOre;
	public static Block enduraniumOre;
	public static Block endzirconiumOre;

	public static void createBlocks() {

		// Vanilla
		GameRegistry.registerBlock(endcoalOre = new ModBlockOre("end_coal_ore", Material.ROCK, ModBlocks.endcoalOre, 1, 1), "end_coal_ore");
		GameRegistry.registerBlock(enddiamondOre = new ModBlockOre3("end_diamond_ore", Material.ROCK, ModBlocks.enddiamondOre, 1, 1), "end_diamond_ore");
		GameRegistry.registerBlock(endemeraldOre = new ModBlockOre("end_emerald_ore", Material.ROCK, ModBlocks.endemeraldOre, 1, 1), "end_emerald_ore");
		GameRegistry.registerBlock(endgoldOre = new ModBlockOre2("end_gold_ore", Material.ROCK, ModBlocks.endgoldOre, 1, 1), "end_gold_ore");
		GameRegistry.registerBlock(endironOre = new ModBlockOre("end_iron_ore", Material.ROCK, ModBlocks.endironOre, 1, 1), "end_iron_ore");
		GameRegistry.registerBlock(endlapisOre = new ModBlockOre("end_lapis_ore", Material.ROCK, ModBlocks.endlapisOre, 1, 1), "end_lapis_ore");
		GameRegistry.registerBlock(endredstoneOre = new ModBlockOre("end_redstone_ore", Material.ROCK, ModBlocks.endredstoneOre, 1, 1), "end_redstone_ore");

		// Base Metals
		GameRegistry.registerBlock(endantimonyOre = new ModBlockOre("end_antimony_ore", Material.ROCK, ModBlocks.endantimonyOre, 1, 1), "end_antimony_ore");
		GameRegistry.registerBlock(endbismuthOre = new ModBlockOre("end_bismuth_ore", Material.ROCK, ModBlocks.endbismuthOre, 1, 1), "end_bismuth_ore");
		GameRegistry.registerBlock(endcopperOre = new ModBlockOre("end_copper_ore", Material.ROCK, ModBlocks.endcopperOre, 1, 1), "end_copper_ore");
		GameRegistry.registerBlock(endleadOre = new ModBlockOre("end_lead_ore", Material.ROCK, ModBlocks.endleadOre, 1, 1), "end_lead_ore");
		GameRegistry.registerBlock(endmercuryOre = new ModBlockOre("end_mercury_ore", Material.ROCK, ModBlocks.endmercuryOre, 1, 1), "end_mercury_ore");
		GameRegistry.registerBlock(endnickelOre = new ModBlockOre("end_nickel_ore", Material.ROCK, ModBlocks.endnickelOre, 1, 1), "end_nickel_ore");
		GameRegistry.registerBlock(endplatinumOre = new ModBlockOre("end_platinum_ore", Material.ROCK, ModBlocks.endplatinumOre, 1, 1), "end_platinum_ore");
		GameRegistry.registerBlock(endsilverOre = new ModBlockOre2("end_silver_ore", Material.ROCK, ModBlocks.endsilverOre, 1, 1), "end_silver_ore");
		GameRegistry.registerBlock(endtinOre = new ModBlockOre("end_tin_ore", Material.ROCK, ModBlocks.endtinOre, 1, 1), "end_tin_ore");
		GameRegistry.registerBlock(endzincOre = new ModBlockOre("end_zinc_ore", Material.ROCK, ModBlocks.endzincOre, 1, 1), "end_zinc_ore");

		// Modern Metals
		GameRegistry.registerBlock(endaluminumOre = new ModBlockOre("end_aluminum_ore", Material.ROCK, ModBlocks.endaluminumOre, 1, 1), "end_aluminum_ore");
		GameRegistry.registerBlock(endcadmiumOre = new ModBlockOre("end_cadmium_ore", Material.ROCK, ModBlocks.endcadmiumOre, 1, 1), "end_cadmium_ore");
		GameRegistry.registerBlock(endchromiumOre = new ModBlockOre("end_chromium_ore", Material.ROCK, ModBlocks.endchromiumOre, 1, 1), "end_chromium_ore");
		GameRegistry.registerBlock(endiridiumOre = new ModBlockOre("end_iridium_ore", Material.ROCK, ModBlocks.endiridiumOre, 1, 1), "end_iridium_ore");
		GameRegistry.registerBlock(endmagnesiumOre = new ModBlockOre("end_magnesium_ore", Material.ROCK, ModBlocks.endmagnesiumOre, 1, 1), "end_magnesium_ore");
		GameRegistry.registerBlock(endmanganeseOre = new ModBlockOre("end_manganese_ore", Material.ROCK, ModBlocks.endmanganeseOre, 1, 1), "end_manganese_ore");
		GameRegistry.registerBlock(endosmiumOre = new ModBlockOre("end_osmium_ore", Material.ROCK, ModBlocks.endosmiumOre, 1, 1), "end_osmium_ore");
		GameRegistry.registerBlock(endplutoniumOre = new ModBlockOre("end_plutonium_ore", Material.ROCK, ModBlocks.endplutoniumOre, 1, 1), "end_plutonium_ore");
		GameRegistry.registerBlock(endrutileOre = new ModBlockOre("end_rutile_ore", Material.ROCK, ModBlocks.endrutileOre, 1, 1), "end_rutile_ore");
		GameRegistry.registerBlock(endtantalumOre = new ModBlockOre("end_tantalum_ore", Material.ROCK, ModBlocks.endtantalumOre, 1, 1), "end_tantalum_ore");
		GameRegistry.registerBlock(endtitaniumOre = new ModBlockOre("end_titanium_ore", Material.ROCK, ModBlocks.endtitaniumOre, 1, 1), "end_titanium_ore");
		GameRegistry.registerBlock(endtungstenOre = new ModBlockOre("end_tungsten_ore", Material.ROCK, ModBlocks.endtungstenOre, 1, 1), "end_tungsten_ore");
		GameRegistry.registerBlock(enduraniumOre = new ModBlockOre("end_uranium_ore", Material.ROCK, ModBlocks.enduraniumOre, 1, 1), "end_uranium_ore");
		GameRegistry.registerBlock(endzirconiumOre = new ModBlockOre("end_zirconium_ore", Material.ROCK, ModBlocks.endzirconiumOre, 1, 1), "end_zirconium_ore");
	}
}
