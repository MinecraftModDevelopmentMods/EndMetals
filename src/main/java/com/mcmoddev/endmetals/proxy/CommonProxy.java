package com.mcmoddev.endmetals.proxy;

import com.mcmoddev.endmetals.init.ItemGroups;
import com.mcmoddev.endmetals.EndMetals;
import com.mcmoddev.endmetals.init.Blocks;
import com.mcmoddev.endmetals.init.Recipes;
import com.mcmoddev.endmetals.util.Config;
import com.mcmoddev.lib.integration.IntegrationManager;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.util.Oredicts;
import com.mcmoddev.lib.block.BlockMMDNetherOre;
import com.mcmoddev.lib.init.Materials;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		Config.init();
		Materials.init();
		ItemGroups.init();
		Blocks.init();
		ItemGroups.setupIcons();
		
		IntegrationManager.INSTANCE.preInit(event);

		MinecraftForge.EVENT_BUS.register(this);
	}

	public void init(FMLInitializationEvent event) {
		Recipes.init();
	}

	public void postInit(FMLPostInitializationEvent event) {
		Config.postInit();
	}
	
	// even though no items are directly created there are ItemBlock instances that need registered as well
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		// NetherMetals doesn't do any of its own materials, just its own blocks
		// so it actually needs this helper :)
		for( MMDMaterial mat : Materials.getAllMaterials()) {
			for( Item item : mat.getItems() ) {
				if( item.getRegistryName().getResourceDomain().equals(EndMetals.MODID) ) {
					event.getRegistry().register(item);
				}
			}
		}
		Oredicts.registerItemOreDictionaryEntries();
		Oredicts.registerBlockOreDictionaryEntries();
	}
	
	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		// NetherMetals doesn't do any of its own materials, just its own blocks
		// so it actually needs this helper :)
		for( MMDMaterial mat : Materials.getAllMaterials()) {
			for( Block block : mat.getBlocks() ) {
				if( block.getRegistryName().getResourceDomain().equals(EndMetals.MODID) ) {
					event.getRegistry().register(block);
				}
			}
		}
	}

}
