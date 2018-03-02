package com.mcmoddev.endmetals.proxy;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.mcmoddev.basemetals.data.MaterialNames;
import com.mcmoddev.endmetals.EndMetals;
import com.mcmoddev.endmetals.init.ItemGroups;
import com.mcmoddev.endmetals.init.Blocks;
import com.mcmoddev.endmetals.init.Recipes;
import com.mcmoddev.endmetals.util.Config;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.integration.IntegrationManager;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.util.Oredicts;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		Config.init();
		Materials.init();
		ItemGroups.init();
		Blocks.init();
		ItemGroups.setupIcons(MaterialNames.LAPIS);
		
		MinecraftForge.EVENT_BUS.register(this);
		IntegrationManager.INSTANCE.preInit(event);
		IntegrationManager.INSTANCE.runCallbacks("preInit");
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
		// EndMetals doesn't do any of its own materials, just its own blocks
		// so it actually needs this helper :)
		Materials.getAllMaterials().stream()
		.forEach( mat -> regMyItems(event.getRegistry(), mat.getItems()) );
		
		Oredicts.registerItemOreDictionaryEntries();
		Oredicts.registerBlockOreDictionaryEntries();
	}

	private void regMyItems(IForgeRegistry<Item> registry, List<ItemStack> items) {
		items.stream()
		.filter(this::itemFilterFunc)
		.map(itemStack -> itemStack.getItem())
		.forEach(registry::register);
	}
	
	private boolean itemFilterFunc( ItemStack itemStack ) {
		return itemStack.getItem().getRegistryName().getResourceDomain().toString().equals(EndMetals.MODID);
	}
	
	private boolean blockFilterFunc( Block block ) {
		return block.getRegistryName().getResourceDomain().toString().equals(EndMetals.MODID);
	}
	
	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		Materials.getAllMaterials().stream()
		.forEach(mat -> regMyBlocks(event.getRegistry(), mat.getBlocks()));
	}

	private void regMyBlocks(IForgeRegistry<Block> registry, ImmutableList<Block> blocks) {
		blocks.stream()
		.filter(this::blockFilterFunc)
		.forEach(registry::register);
	}
}
