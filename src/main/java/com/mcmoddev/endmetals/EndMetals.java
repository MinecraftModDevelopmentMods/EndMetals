package com.mcmoddev.endmetals;

import com.mcmoddev.endmetals.proxy.CommonProxy;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * This is the entry point for this Mod.
 *
 * @author Jasmine Iwanek
 *
 */
@Mod(modid = EndMetals.MODID, name = EndMetals.NAME, version = EndMetals.VERSION, dependencies = "required-after:Forge@[12.18.3.2185,);after:basemetals;after:baseminerals;after:modernmetals", acceptedMinecraftVersions = "[1.10.2,)", updateJSON = "https://raw.githubusercontent.com/MinecraftModDevelopment/EndMetals/master/update.json")
public class EndMetals {

	@Instance
	public static EndMetals instance;

	/** ID of this Mod */
	public static final String MODID = "endmetals";

	/** Display name of this Mod */
	public static final String NAME = "End Metals";

	/**
	 * Version number, in Major.Minor.Build format. The minor number is
	 * increased whenever a change is made that has the potential to break
	 * compatibility with other mods that depend on this one.
	 */
	public static final String VERSION = "1.2.0-beta1";

	@SidedProxy(clientSide="com.mcmoddev.endmetals.proxy.ClientProxy", serverSide="com.mcmoddev.endmetals.proxy.ServerProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		EndMetals.proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		EndMetals.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		EndMetals.proxy.postInit(event);
	}
	
    public static boolean hasMMDLib() {
        return Loader.isModLoaded("mmdlib");
    }
        
    public static boolean hasOreSpawn() {
        return Loader.isModLoaded("orespawn");
    }
    public static boolean hasTinkers() {
        return Loader.isModLoaded("tinkersconstruct");
    }
    public static boolean hasModernMetals() {
        return Loader.isModLoaded("modernmetals");
    }
    public static boolean hasBaseMetals() {
        return Loader.isModLoaded("basemetals");
    }
}
