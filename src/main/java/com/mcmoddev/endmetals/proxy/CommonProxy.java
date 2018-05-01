package com.mcmoddev.endmetals.proxy;

import com.mcmoddev.basemetals.data.MaterialNames;
import com.mcmoddev.endmetals.init.ItemGroups;
import com.mcmoddev.endmetals.init.Recipes;
import com.mcmoddev.endmetals.util.Config;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		ItemGroups.init();
	}

	public void init(FMLInitializationEvent event) {
		Recipes.init();

		ItemGroups.setupIcons(MaterialNames.LAPIS);
	}

	public void postInit(FMLPostInitializationEvent event) {
		Config.postInit();
	}
}
