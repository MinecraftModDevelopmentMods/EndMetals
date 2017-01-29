package com.mcmoddev.endmetals.proxy;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import com.mcmoddev.endmetals.ConfigHandler;
import com.mcmoddev.endmetals.EndMetals;
import com.mcmoddev.endmetals.blocks.ModBlocks;
import com.mcmoddev.endmetals.crafting.ModCrafting;
import com.mcmoddev.endmetals.data.DataConstants;
import com.mcmoddev.endmetals.world.WorldGen;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		// vanilla config loader
		ConfigHandler.startConfig(event);

		// load config
		final Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		final Path oreSpawnFolder = Paths.get(event.getSuggestedConfigurationFile().toPath().getParent().toString(), "orespawn");
		if (ConfigHandler.requireOreSpawn) {
			// Base Metals
			if (Loader.isModLoaded("basemetals")) {
				final Path bmoreSpawnFile = Paths.get(oreSpawnFolder.toString(), EndMetals.MODID + "-bmores" + ".json");
				if (!Files.exists(bmoreSpawnFile)) {
					try {
						Files.createDirectories(bmoreSpawnFile.getParent());
						Files.write(bmoreSpawnFile, Arrays.asList(DataConstants.BM_ORESPAWN_JSON.split("\n")), Charset.forName("UTF-8"));
					} catch (IOException e) {
						FMLLog.severe(EndMetals.MODID + ": Error: Failed to write file " + bmoreSpawnFile);
					}
				}
			}

			// Modern Metals
			if (Loader.isModLoaded("modernmetals")) {
				final Path mmoreSpawnFile = Paths.get(oreSpawnFolder.toString(), EndMetals.MODID + "-mmores" + ".json");
				if (!Files.exists(mmoreSpawnFile)) {
					try {
						Files.createDirectories(mmoreSpawnFile.getParent());
						Files.write(mmoreSpawnFile, Arrays.asList(DataConstants.MM_ORESPAWN_JSON.split("\n")), Charset.forName("UTF-8"));
					} catch (IOException e) {
						FMLLog.severe(EndMetals.MODID + ": Error: Failed to write file " + mmoreSpawnFile);
					}
				}
			}
		}

		config.save();

		FMLInterModComms.sendFunctionMessage("orespawn", "api", "com.mcmoddev.orespawn.EndMetalsOreSpawn");

		ModBlocks.createBlocks();
	}

	public void init(FMLInitializationEvent event) {
		ModCrafting.initCrafting();
		GameRegistry.registerWorldGenerator(new WorldGen(), 0);
	}

	public void postInit(FMLPostInitializationEvent event) {
		//
	}
/*
	public void info(String s) {
		logger.info(s);
	}

	public void error(String s) {
		logger.error(s);
	}
	*/
}
