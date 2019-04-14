package com.mcmoddev.endmetals.util;

import com.mcmoddev.lib.data.SharedStrings;
import com.mcmoddev.lib.events.MMDLibRegisterBlocks;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.util.Oredicts;
import com.mcmoddev.endmetals.EndMetals;
import com.mcmoddev.endmetals.init.EndBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(value = { Side.CLIENT, Side.SERVER }, modid = EndMetals.MODID)
public final class EventHandler {

	private EventHandler() {
		throw new IllegalAccessError(SharedStrings.NOT_INSTANTIABLE);
	}

	@SubscribeEvent
	public static void mmdlibRegisterBlocks(final MMDLibRegisterBlocks event) {
		EndBlocks.init();
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public static void onRemapBlock(final RegistryEvent.MissingMappings<Block> event) {
		for (final RegistryEvent.MissingMappings.Mapping<Block> mapping : event.getAllMappings()) {
			if (mapping.key.getNamespace().equals(EndMetals.MODID)) {
				// dummy
			}
		}
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public static void onRemapItem(final RegistryEvent.MissingMappings<Item> event) {
		for (final RegistryEvent.MissingMappings.Mapping<Item> mapping : event.getAllMappings()) {
			if (mapping.key.getNamespace().equals(EndMetals.MODID)) {
				// dummy
			}
		}
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		Materials.getAllMaterials().stream()
		.forEach(mat ->
			mat.getItems().stream()
			.map(itemStack -> itemStack.getItem())
			.filter(EventHandler::itemFilterFunc)
			.forEach(event.getRegistry()::register)
		);

		Oredicts.registerItemOreDictionaryEntries();
		Oredicts.registerBlockOreDictionaryEntries();
	}

	private static boolean itemFilterFunc(final Item item) {
		return matchModId(item.getRegistryName());
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		Materials.getAllMaterials().stream()
		.forEach(mat ->
			mat.getBlocks().stream()
			.filter(EventHandler::blockFilterFunc)
			.forEach(event.getRegistry()::register)
		);
	}

	private static boolean blockFilterFunc(final Block block) {
		return matchModId(block.getRegistryName());
	}

	private static boolean matchModId(final ResourceLocation resourceLocation) {
		return resourceLocation.getNamespace().equals(EndMetals.MODID);
	}
}
