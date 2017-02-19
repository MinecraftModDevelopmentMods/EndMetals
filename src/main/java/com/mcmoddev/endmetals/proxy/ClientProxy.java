package com.mcmoddev.endmetals.proxy;

import com.mcmoddev.endmetals.EndMetals;
import com.mcmoddev.lib.init.*;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.block.*;

public class ClientProxy extends CommonProxy {

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);

		for (final String name : Blocks.getBlockRegistry().keySet()) {
			registerRenderOuter(Blocks.getBlockByName(name));
		}
	}

	public void registerRenderOuter(Block block) {
		if ((block instanceof BlockDoor) || (block instanceof BlockSlab))
			return; // do not add door blocks or slabs

		if (block != null) {
			registerRender(Item.getItemFromBlock(block), Blocks.getNameOfBlock(block));
		}
	}

	public void registerRender(Item item, String name) {
		final ItemModelMesher itemModelMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		if (!item.getRegistryName().getResourceDomain().equals(EndMetals.MODID))
			return;
		itemModelMesher.register(item, 0, new ModelResourceLocation(new ResourceLocation(item.getRegistryName().getResourceDomain(), name), "inventory"));
	}
}
