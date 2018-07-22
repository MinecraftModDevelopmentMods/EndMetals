package com.mcmoddev.orespawn;

import com.mcmoddev.endmetals.EndMetals;
import com.mcmoddev.orespawn.api.os3.*;
import com.mcmoddev.orespawn.api.plugin.IOreSpawnPlugin;
import com.mcmoddev.orespawn.api.plugin.OreSpawnPlugin;

@OreSpawnPlugin(modid = EndMetals.MODID, resourcePath = "orespawn")
public final class EndMetalsOreSpawn implements IOreSpawnPlugin {

	@Override
	public void register(final OS3API apiInterface) {
		// nothing for us to do - all of our ores are in the
		// jar and the code handles that
	}
}
