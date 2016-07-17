package endmetals;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * 
 * @author Jasmine Iwanek
 * @author Knoxhack
 *
 */
public class ConfigHandler {

	private static Configuration config;

	private static final String COMMENTS = Main.MODNAME + " Config\n For Version " + Main.VERSION;
	
	private static final String COAL_ORE_SPAWN_PROB_COMMENT =     "Spawn Probability of Coal Ore \nSet to zero to disable";
	private static final String DIAMOND_ORE_SPAWN_PROB_COMMENT =  "Spawn Probability of Diamond Ore\nSet to zero to disable";
	private static final String EMERALD_ORE_SPAWN_PROB_COMMENT =  "Spawn Probability of Emerald Ore\nSet to zero to disable";
	private static final String GOLD_ORE_SPAWN_PROB_COMMENT =     "Spawn Probability of Gold Ore\nSet to zero to disable";
	private static final String IRON_ORE_SPAWN_PROB_COMMENT =     "Spawn Probability of Iron Ore\nSet to zero to disable";
	private static final String LAPIS_ORE_SPAWN_PROB_COMMENT =    "Spawn Probability of Lapis Ore\nSet to zero to disable";
	private static final String REDSTONE_ORE_SPAWN_PROB_COMMENT = "Spawn Probability of Redstone Ore\nSet to zero to disable";

	private static int COAL_ORE_SPAWN_PROB = 0;
	private static int DIAMOND_ORE_SPAWN_PROB = 0;
	private static int EMERALD_ORE_SPAWN_PROB = 0;
	private static int GOLD_ORE_SPAWN_PROB = 0;
	private static int IRON_ORE_SPAWN_PROB = 0;
	private static int LAPIS_ORE_SPAWN_PROB = 0;
	private static int REDSTONE_ORE_SPAWN_PROB = 0;

	/**
	 * 
	 * @param event event
	 */
	public static void startConfig(FMLPreInitializationEvent event)
	{
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load(); // only need to load config once during pre initializeSoundEvents
		updateConfigInfo();
	}

	/**
	 * 
	 */
	public static void updateConfigInfo()
	{
		try {
			config.addCustomCategoryComment(Configuration.CATEGORY_GENERAL, COMMENTS);

			COAL_ORE_SPAWN_PROB =     config.get(Configuration.CATEGORY_GENERAL, "CoalOreSpawnProb",     16, COAL_ORE_SPAWN_PROB_COMMENT).getInt();
			DIAMOND_ORE_SPAWN_PROB =  config.get(Configuration.CATEGORY_GENERAL, "DiamondOreSpawnProb",   5, DIAMOND_ORE_SPAWN_PROB_COMMENT).getInt();
			EMERALD_ORE_SPAWN_PROB =  config.get(Configuration.CATEGORY_GENERAL, "EmeraldOreSpawnProb",   5, EMERALD_ORE_SPAWN_PROB_COMMENT).getInt();
			GOLD_ORE_SPAWN_PROB =     config.get(Configuration.CATEGORY_GENERAL, "GoldOreSpawnProb",      8, GOLD_ORE_SPAWN_PROB_COMMENT).getInt();
			IRON_ORE_SPAWN_PROB =     config.get(Configuration.CATEGORY_GENERAL, "IronOreSpawnProb",     14, IRON_ORE_SPAWN_PROB_COMMENT).getInt();
			LAPIS_ORE_SPAWN_PROB =    config.get(Configuration.CATEGORY_GENERAL, "LapisOreSpawnProb",     8, LAPIS_ORE_SPAWN_PROB_COMMENT).getInt();
			REDSTONE_ORE_SPAWN_PROB = config.get(Configuration.CATEGORY_GENERAL, "RedstoneOreSpawnProb", 12, REDSTONE_ORE_SPAWN_PROB_COMMENT).getInt();

			config.get(Configuration.CATEGORY_GENERAL, "CoalOreSpawnProb",     16, COAL_ORE_SPAWN_PROB_COMMENT).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "DiamondOreSpawnProb",   5, DIAMOND_ORE_SPAWN_PROB_COMMENT).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "EmeraldOreSpawnProb",   5, EMERALD_ORE_SPAWN_PROB_COMMENT).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "GoldOreSpawnProb",      8, GOLD_ORE_SPAWN_PROB_COMMENT).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "IronOreSpawnProb",     14, IRON_ORE_SPAWN_PROB_COMMENT).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "LapisOreSpawnProb",     8, LAPIS_ORE_SPAWN_PROB_COMMENT).getInt();
			config.get(Configuration.CATEGORY_GENERAL, "RedstoneOreSpawnProb", 12, REDSTONE_ORE_SPAWN_PROB_COMMENT).getInt();
		} catch (Exception e) {
			FMLLog.info(Main.MODID+": failed to load or read the config file");
		} finally {
			if (config.hasChanged()) {
				config.save();
			}
		}
	}

	public static int getCoalOreSpawnProb() {
		return COAL_ORE_SPAWN_PROB;
	}

	public static int getDiamondOreSpawnProb() {
		return DIAMOND_ORE_SPAWN_PROB;
	}

	public static int getEmeraldOreSpawnProb() {
		return EMERALD_ORE_SPAWN_PROB;
	}

	public static int getGoldOreSpawnProb() {
		return GOLD_ORE_SPAWN_PROB;
	}

	public static int getIronOreSpawnProb() {
		return IRON_ORE_SPAWN_PROB;
	}

	public static int getLapisOreSpawnProb() {
		return LAPIS_ORE_SPAWN_PROB;
	}

	public static int getRedstoneOreSpawnProb() {
		return REDSTONE_ORE_SPAWN_PROB;
	}
}
