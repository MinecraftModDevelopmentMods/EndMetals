package com.mcmoddev.endmetals.proxy;

import com.mcmoddev.basemetals.init.ItemGroups;
import com.mcmoddev.endmetals.init.Blocks;
import com.mcmoddev.endmetals.init.Recipes;
import com.mcmoddev.endmetals.util.Config;
import com.mcmoddev.lib.integration.IntegrationManager;
import com.mcmoddev.lib.init.Materials;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		Config.init();
		Materials.init();
		ItemGroups.init();
		Blocks.init();

		IntegrationManager.INSTANCE.preInit(event);
	}

	public void init(FMLInitializationEvent event) {
		Recipes.init();

		ItemGroups.setupIcons("lapis");
	}

	public void postInit(FMLPostInitializationEvent event) {
		Config.postInit();
	}
}
