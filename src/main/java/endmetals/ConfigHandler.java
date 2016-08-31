package endmetals;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {

	public static Configuration config;

	private static final String comments = Main.MODNAME + " Config\n For End Metals \n"
			+ " For End Metals " + Main.VERSION;
	
	private static final String orespawnProbComment = "Spawn Probability\nSet to zero to disable ore spawning of this type";

	public static boolean requireOreSpawn = true;
	
	private static int ironoreSpawnProb = 0;
	private static int diamondoreSpawnProb = 0;
	private static int redstoneoreSpawnProb = 0;
	private static int goldoreSpawnProb = 0;
	private static int emeraldoreSpawnProb = 0;
	private static int coaloreSpawnProb = 0;
	private static int lapisoreSpawnProb = 0;

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

			requireOreSpawn = config.getBoolean("using_orespawn", "options", requireOreSpawn,
					"If false, then Base Metals will not require DrCyano's Ore Spawn mod. \n" +
					"Set to false if using another mod to manually handle ore generation.");
			
			ironoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "EndIronOreSpawnProb", 14, orespawnProbComment).getInt();
			diamondoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "EndDiamondOreSpawnProb", 5, orespawnProbComment).getInt();
			redstoneoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "EndRedstoneOreSpawnProb", 12, orespawnProbComment).getInt();
			lapisoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "EndLapisOreSpawnProb", 8, orespawnProbComment).getInt();
			emeraldoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "EndEmeraldOreSpawnProb", 5, orespawnProbComment).getInt();
			goldoreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "EndGoldOreSpawnProb", 8, orespawnProbComment).getInt();
			coaloreSpawnProb = config.get(Configuration.CATEGORY_GENERAL, "EndCoalOreSpawnProb", 16, orespawnProbComment).getInt();

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
		return ironoreSpawnProb;
	}

	public static int getEndDiamondOreSpawnProb() {
		return diamondoreSpawnProb;
	}

	public static int getEndGoldOreSpawnProb() {
		return goldoreSpawnProb;
	}

	public static int getEndCoalOreSpawnProb() {
		return coaloreSpawnProb;
	}

	public static int getEndEmeraldOreSpawnProb() {
		return emeraldoreSpawnProb;
	}

	public static int getEndRedstoneOreSpawnProb() {
		return redstoneoreSpawnProb;
	}

	public static int getEndLapisOreSpawnProb() {
		return lapisoreSpawnProb;
	}
}
