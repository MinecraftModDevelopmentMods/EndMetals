package endmetals;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {

	public static Configuration config;

	private static final String comments = Main.MODNAME + " Config\n For End Metals \n"
			+ " For End Metals " + Main.VERSION;
	
	private static final String orespawnProbComment = "Spawn Probability\nSet to zero to disable ore spawning of this type";

	private static  int endironoreSpawnProb = 0;
	private static  int enddiamondoreSpawnProb = 0;
	private static  int endredstoneoreSpawnProb = 0;
	private static  int endgoldoreSpawnProb = 0;
	private static  int endemeraldoreSpawnProb = 0;
	private static  int endcoaloreSpawnProb = 0;
	private static  int endlapisoreSpawnProb = 0;

	public static void startConfig(FMLPreInitializationEvent event)
	{
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load(); // only need to load config once during pre initializeSoundEvents
		updateConfigInfo();
	}

	public static void updateConfigInfo()
	{
		try {
			config.addCustomCategoryComment(Configuration.CATEGORY_GENERAL, comments);

			endironoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "EndIronOreSpawnProb", 14, orespawnProbComment).getInt();
			enddiamondoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "EndDiamondOreSpawnProb", 5, orespawnProbComment).getInt();
			endredstoneoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "EndRedstoneOreSpawnProb", 12, orespawnProbComment).getInt();
			endlapisoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "EndLapisOreSpawnProb", 8, orespawnProbComment).getInt();
			endemeraldoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "EndEmeraldOreSpawnProb", 5, orespawnProbComment).getInt();
			endgoldoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "EndGoldOreSpawnProb", 8, orespawnProbComment).getInt();
			endcoaloreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "EndCoalOreSpawnProb", 16, orespawnProbComment).getInt();

			config.get(Configuration.CATEGORY_GENERAL, "EndIronOreSpawnProb", 14, orespawnProbComment).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "EndDiamondOreSpawnProb", 5, orespawnProbComment).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "EndRedstoneOreSpawnProb", 12, orespawnProbComment).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "EndEmeraldOreSpawnProb", 5, orespawnProbComment).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "EndGoldOreSpawnProb", 8, orespawnProbComment).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "EndLapisOreSpawnProb", 8, orespawnProbComment).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "EndCoalOreSpawnProb", 16, orespawnProbComment).getInt();
		} catch (Exception e) {
			Main.proxy.info("failed to load or read the config file");
		} finally {
			if (config.hasChanged()) {
				config.save();
			}
		}
	}

	public static int getEndIronOreSpawnProb() {
		return endironoreSpawnProb;
	}

	public static int getEndDiamondOreSpawnProb() {
		return enddiamondoreSpawnProb;
	}

	public static int getEndGoldOreSpawnProb() {
		return endgoldoreSpawnProb;
	}

	public static int getEndCoalOreSpawnProb() {
		return endcoaloreSpawnProb;
	}

	public static int getEndEmeraldOreSpawnProb() {
		return endemeraldoreSpawnProb;
	}

	public static int getEndRedstoneOreSpawnProb() {
		return endredstoneoreSpawnProb;
	}

	public static int getEndLapisOreSpawnProb() {
		return endlapisoreSpawnProb;
	}
}
