package com.mcmoddev.endmetals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mcmoddev.endmetals.proxy.CommonProxy;
import com.mcmoddev.endmetals.util.EMeConfig;
import com.mcmoddev.lib.data.SharedStrings;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * This is the entry point for this Mod.
 *
 * @author Jasmine Iwanek
 *
 */
@Mod(
		modid = EndMetals.MODID,
		name = EndMetals.NAME,
		version = EndMetals.VERSION,
		dependencies = "required-after:forge@[14.21.0.2327,);after:basemetals;after:baseminerals;after:modernmetals",
		acceptedMinecraftVersions = "[1.12,)",
		certificateFingerprint = "@FINGERPRINT@",
		updateJSON = SharedStrings.UPDATE_JSON_URL + "EndMetals/master/update.json")
public final class EndMetals {

	@Instance(value = EndMetals.MODID)
	public static EndMetals instance;

	/** ID of this Mod. */
	public static final String MODID = "endmetals";

	/** Display name of this Mod. */
	public static final String NAME = "End Metals";

	/**
	 * Version number, in Major.Minor.Build format. The minor number is
	 * increased whenever a change is made that has the potential to break
	 * compatibility with other mods that depend on this one.
	 */
	public static final String VERSION = "1.2.0-beta5";

	public static final Logger LOGGER = LogManager.getFormatterLogger(EndMetals.MODID);

	private static final String PROXY_BASE = SharedStrings.MMD_PROXY_GROUP + MODID + SharedStrings.DOT_PROXY_DOT;

	@SidedProxy(clientSide = PROXY_BASE + SharedStrings.CLIENTPROXY, serverSide = PROXY_BASE
			+ SharedStrings.SERVERPROXY)
	public static CommonProxy proxy;

	@EventHandler
	public void onFingerprintViolation(final FMLFingerprintViolationEvent event) {
		LOGGER.warn(SharedStrings.INVALID_FINGERPRINT);
	}

	@EventHandler
	public void constructing(final FMLConstructionEvent event) {
		EMeConfig.init();
	}

	@EventHandler
	public void preInit(final FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void init(final FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(final FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
