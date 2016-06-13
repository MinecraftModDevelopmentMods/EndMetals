package endmetals.blocks;

import java.util.HashMap;
import java.util.Map;

import endmetals.Main;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class ModBlocks {

	private static final Map<String,Block> allBlocks = new HashMap<>();

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
		endcoalOre = createOre("coal", 4.0f, 15.0f);
		enddiamondOre = createOre("diamond", 15.0f, 20.0f);
		endemeraldOre = createOre("emerald", 4.0f, 15.0f);
		endgoldOre = createOre("gold", 10.0f, 15.0f);
		endironOre = createOre("iron", 4.0f, 15.0f);
		endlapisOre = createOre("lapis", 4.0f, 15.0f);
		endredstoneOre = createOre("redstone", 4.0f, 15.0f);

		// Base Metals
		endantimonyOre = createOre("antimony", 4.0f, 15.0f);
		endbismuthOre = createOre("bismuth", 4.0f, 15.0f);
		endcopperOre = createOre("copper", 4.0f, 15.0f);
		endleadOre = createOre("lead", 4.0f, 15.0f);
		endmercuryOre = createOre("mercury", 4.0f, 15.0f);
		endnickelOre = createOre("nickel", 4.0f, 15.0f);
		endplatinumOre = createOre("platinum", 4.0f, 15.0f);
		endsilverOre = createOre("silver", 10.0f, 15.0f);
		endtinOre = createOre("tin", 4.0f, 15.0f);
		endzincOre = createOre("zinc", 4.0f, 15.0f);

		// Modern Metals
		endaluminumOre = createOre("aluminum", 4.0f, 15.0f);
		endcadmiumOre = createOre("cadmium", 4.0f, 15.0f);
		endchromiumOre = createOre("chromium", 4.0f, 15.0f);
		endiridiumOre = createOre("iridium", 4.0f, 15.0f);
		endmagnesiumOre = createOre("magnesium", 4.0f, 15.0f);
		endmanganeseOre = createOre("manganese", 4.0f, 15.0f);
		endosmiumOre = createOre("osmium", 4.0f, 15.0f);
		endplutoniumOre = createOre("plutonium", 4.0f, 15.0f);
		endrutileOre = createOre("rutile", 4.0f, 15.0f);
		endtantalumOre = createOre("tantalum", 4.0f, 15.0f);
		endtitaniumOre = createOre("titanium", 4.0f, 15.0f);
		endtungstenOre = createOre("tungsten", 4.0f, 15.0f);
		enduraniumOre = createOre("uranium", 4.0f, 15.0f);
		endzirconiumOre = createOre("zirconium", 4.0f, 15.0f);
	}

	private static Block addBlock(Block block, String name) {
		ResourceLocation location = new ResourceLocation(Main.MODID, name);
		block.setRegistryName(location);
		block.setUnlocalizedName(location.toString());
		GameRegistry.register(block);

		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(location);
		itemBlock.setUnlocalizedName(location.toString());
		GameRegistry.register(itemBlock);

		allBlocks.put(name, block);
		return block;
	}

	private static Block createOre(String name, float Hardness, float Resistance) {
		return addBlock(new ModBlockOre(Hardness, Resistance), "end_"+name+"_ore");
	}

	@SideOnly(Side.CLIENT)
	public static void registerItemRenders(FMLInitializationEvent event) {
		for(String name : allBlocks.keySet()){
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(net.minecraft.item.Item.getItemFromBlock(allBlocks.get(name)), 0, 
				new ModelResourceLocation(new ResourceLocation(Main.MODID, name), "inventory"));
		}
	}
}
