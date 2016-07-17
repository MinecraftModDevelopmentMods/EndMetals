package endmetals;

import endmetals.blocks.ModBlocks;
import endmetals.crafting.ModCrafting;
import endmetals.utils.JSONHandler;
import endmetals.world.WorldGen;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * 
 * @author Jasmine Iwanek
 * @author Knoxhack
 *
 */
public class CommonProxy {

	/**
	 * 
	 * @param event event
	 */
	public void preInit(FMLPreInitializationEvent event) {
		ModBlocks.createBlocks();
	}

	/**
	 * 
	 * @param event event
	 */
	public void init(FMLInitializationEvent event) {
		JSONHandler.init();
		ModCrafting.init();
		GameRegistry.registerWorldGenerator(new WorldGen(), 0);
	}

	/**
	 * 
	 * @param event event
	 */
	public void postInit(FMLPostInitializationEvent event) {

	}
}
