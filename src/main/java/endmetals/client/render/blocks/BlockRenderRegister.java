package endmetals.client.render.blocks;

import endmetals.Main;
import endmetals.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class BlockRenderRegister {

	public static void registerBlockRenderer() {

		// Vanilla
		reg(ModBlocks.endcoalOre);
		reg(ModBlocks.enddiamondOre);
		reg(ModBlocks.endemeraldOre);
		reg(ModBlocks.endgoldOre);
		reg(ModBlocks.endironOre);
		reg(ModBlocks.endlapisOre);
		reg(ModBlocks.endredstoneOre);

		// Base Metals
		reg(ModBlocks.endantimonyOre);
		reg(ModBlocks.endbismuthOre);
		reg(ModBlocks.endcopperOre);
		reg(ModBlocks.endleadOre);
		reg(ModBlocks.endmercuryOre);
		reg(ModBlocks.endnickelOre);
		reg(ModBlocks.endplatinumOre);
		reg(ModBlocks.endsilverOre);
		reg(ModBlocks.endtinOre);
		reg(ModBlocks.endzincOre);

		// Modern Metals
		reg(ModBlocks.endaluminumOre);
		reg(ModBlocks.endcadmiumOre);
		reg(ModBlocks.endchromiumOre);
		reg(ModBlocks.endiridiumOre);
		reg(ModBlocks.endmagnesiumOre);
		reg(ModBlocks.endmanganeseOre);
		reg(ModBlocks.endosmiumOre);
		reg(ModBlocks.endplutoniumOre);
		reg(ModBlocks.endrutileOre);
		reg(ModBlocks.endtantalumOre);
		reg(ModBlocks.endtitaniumOre);
		reg(ModBlocks.endtungstenOre);
		reg(ModBlocks.enduraniumOre);
		reg(ModBlocks.endzirconiumOre);
	}

	public static String modid = Main.MODID;

	public static void reg(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(modid + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}
}
