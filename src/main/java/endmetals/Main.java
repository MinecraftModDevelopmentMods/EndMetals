package endmetals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import endmetals.data.DataConstants;
import endmetals.ConfigHandler;

import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * 
 * @author Jasmine Iwanek
 * @author Knoxhack
 *
 */
@Mod(
		modid = Main.MODID,
		name = Main.MODNAME,
		version = Main.VERSION,
		dependencies = "required-after:Forge;after:basemetals;after:modernmetals",
		acceptedMinecraftVersions = "(,1.8.9]",
		updateJSON = "https://raw.githubusercontent.com/jriwanek/End-Metals/master/update.json")
public class Main {

	/**
	 * 
	 */
	@Instance(Main.MODID)
	public static Main INSTANCE = null;

	public static final String MODID = "endmetals";
	public static final String MODNAME = "End Metals";
	public static final String VERSION = "1.1.3";

	/** location of ore-spawn files */
	private static Path oreSpawnFolder = null;

	/**
	 * 
	 * @param event event
	 */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		INSTANCE = this;

		// vanilla config handler
        ConfigHandler.startConfig(event);

		oreSpawnFolder = Paths.get(event.getSuggestedConfigurationFile().toPath().getParent().toString(),"orespawn");
		// Base Metals
		if(Loader.isModLoaded("basemetals")) {
			Path bmoreSpawnFile = Paths.get(oreSpawnFolder.toString(),MODID+"-bmores"+".json");
			if(!(Files.exists(bmoreSpawnFile))) {
				try {
					Files.createDirectories(bmoreSpawnFile.getParent());
					Files.write(bmoreSpawnFile, Arrays.asList(DataConstants.bmOreSpawnJSON.split("\n")), Charset.forName("UTF-8"));
				} catch (IOException e) {
					FMLLog.severe(MODID+": Error: Failed to write file "+bmoreSpawnFile);
				}
			}
		}

		// Modern Metals
		if(Loader.isModLoaded("modernmetals")) {
			Path mmoreSpawnFile = Paths.get(oreSpawnFolder.toString(),MODID+"-mmores"+".json");
			if(!(Files.exists(mmoreSpawnFile))) {
				try {
					Files.createDirectories(mmoreSpawnFile.getParent());
					Files.write(mmoreSpawnFile, Arrays.asList(DataConstants.mmOreSpawnJSON.split("\n")), Charset.forName("UTF-8"));
				} catch (IOException e) {
					FMLLog.severe(MODID+": Error: Failed to write file "+mmoreSpawnFile);
				}
			}
		}

		Main.proxy.preInit(event);
	}

	/**
	 * 
	 * @param event event
	 */
	@EventHandler
	public void init(FMLInitializationEvent event) {
		Main.proxy.init(event);
	}

	/**
	 * 
	 * @param event event
	 */
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Main.proxy.postInit(event);
	}

	/**
	 * 
	 */
	@SidedProxy(clientSide="endmetals.ClientProxy", serverSide="endmetals.ServerProxy")
	public static CommonProxy proxy;
}
