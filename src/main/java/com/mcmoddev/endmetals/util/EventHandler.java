package com.mcmoddev.endmetals.util;

import com.mcmoddev.lib.events.MMDLibRegisterBlocks;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.util.Oredicts;
import com.mcmoddev.endmetals.EndMetals;
import com.mcmoddev.endmetals.init.Blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class EventHandler {
	@SubscribeEvent
	public static void mmdlibRegisterBlocks(MMDLibRegisterBlocks ev) {
		ev.setActive(EndMetals.MODID);
		Blocks.init();
	}

	@SubscribeEvent
	public static void onRemapBlock(RegistryEvent.MissingMappings<Block> event) {
		for (final RegistryEvent.MissingMappings.Mapping<Block> mapping : event.getAllMappings()) {
			if (mapping.key.getResourceDomain().equals(EndMetals.MODID)) {
				// dummy
			}
		}
	}

	@SubscribeEvent
	public static void onRemapItem(RegistryEvent.MissingMappings<Item> event) {
		for (final RegistryEvent.MissingMappings.Mapping<Item> mapping : event.getAllMappings()) {
			if (mapping.key.getResourceDomain().equals(EndMetals.MODID)) {
				// dummy
			}
		}
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		Materials.getAllMaterials().stream()
		.forEach( mat -> {
			mat.getItems().stream()
			.map(itemStack -> itemStack.getItem())
			.filter(EventHandler::itemFilterFunc)
			.forEach(event.getRegistry()::register);
		});

		Oredicts.registerItemOreDictionaryEntries();
		Oredicts.registerBlockOreDictionaryEntries();
	}
	
	private static boolean itemFilterFunc(Item item) {
		return matchModId(item.getRegistryName());
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		Materials.getAllMaterials().stream()
		.forEach( mat -> {
			mat.getBlocks().stream()
			.filter(EventHandler::blockFilterFunc)
			.forEach(event.getRegistry()::register);
		});
	}

	private static boolean blockFilterFunc(Block block) {
		return matchModId(block.getRegistryName());
	}
	
	private static boolean matchModId(ResourceLocation rl) {
		return rl.getResourceDomain().equals(EndMetals.MODID);
	}
}
