package endmetals.utils;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import endmetals.Main;
import endmetals.data.OreSpawnDimensionEntry;
import endmetals.data.OreSpawnEntry;
import endmetals.data.OreSpawnOreEntry;
import net.minecraftforge.fml.common.FMLLog;

public class JSONHandler {

	public static void init() {
		OreSpawnEntry obj = createObject();;

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonInString = gson.toJson(obj);
		FMLLog.severe(Main.MODID+": DEBUG: "+jsonInString);
	}

	private static OreSpawnEntry createObject() {

		OreSpawnEntry orespawnentry = new OreSpawnEntry();

		List<OreSpawnDimensionEntry> dimensions = new ArrayList<>();

		OreSpawnDimensionEntry orespawndimensionentry = new OreSpawnDimensionEntry();

		List<OreSpawnOreEntry> ores = new ArrayList<>();

		OreSpawnOreEntry orespawnoreentry = new OreSpawnOreEntry();

		orespawnoreentry.setBlockID("endmetals:end_antimony_ore");
		orespawnoreentry.setSize(8);
		orespawnoreentry.setVariation(4);
		orespawnoreentry.setFrequency(10);
		orespawnoreentry.setMinHeight(0);
		orespawnoreentry.setMaxHeight(32);

		ores.add(orespawnoreentry);

		orespawnoreentry.setBlockID("endmetals:end_bismuth_ore");
		orespawnoreentry.setSize(8);
		orespawnoreentry.setVariation(4);
		orespawnoreentry.setFrequency(10);
		orespawnoreentry.setMinHeight(0);
		orespawnoreentry.setMaxHeight(32);

		ores.add(orespawnoreentry);

		orespawnoreentry.setBlockID("endmetals:end_copper_ore");
		orespawnoreentry.setSize(8);
		orespawnoreentry.setVariation(12);
		orespawnoreentry.setFrequency(20);
		orespawnoreentry.setMinHeight(0);
		orespawnoreentry.setMaxHeight(96);

		ores.add(orespawnoreentry);

// ------------------------------------------------------------

        orespawnoreentry.setBlockID("endmetals:end_lead_ore");
        orespawnoreentry.setSize(8);
        orespawnoreentry.setVariation(12);
        orespawnoreentry.setFrequency(20);
        orespawnoreentry.setMinHeight(0);
        orespawnoreentry.setMaxHeight(96);

        ores.add(orespawnoreentry);

        orespawnoreentry.setBlockID("endmetals:end_mercury_ore");
        orespawnoreentry.setSize(8);
        orespawnoreentry.setVariation(4);
        orespawnoreentry.setFrequency(10);
        orespawnoreentry.setMinHeight(0);
        orespawnoreentry.setMaxHeight(32);

        ores.add(orespawnoreentry);

        orespawnoreentry.setBlockID("endmetals:end_nickel_ore");
        orespawnoreentry.setSize(8);
        orespawnoreentry.setVariation(4);
        orespawnoreentry.setFrequency(10);
        orespawnoreentry.setMinHeight(0);
        orespawnoreentry.setMaxHeight(96);

        ores.add(orespawnoreentry);

        orespawnoreentry.setBlockID("endmetals:end_platinum_ore");
        orespawnoreentry.setSize(8);
        orespawnoreentry.setVariation(4);
        orespawnoreentry.setFrequency(10);
        orespawnoreentry.setMinHeight(0);
        orespawnoreentry.setMaxHeight(32);

        ores.add(orespawnoreentry);

        orespawnoreentry.setBlockID("endmetals:end_silver_ore");
        orespawnoreentry.setSize(8);
        orespawnoreentry.setVariation(8);
        orespawnoreentry.setFrequency(10);
        orespawnoreentry.setMinHeight(0);
        orespawnoreentry.setMaxHeight(32);

        ores.add(orespawnoreentry);

        orespawnoreentry.setBlockID("endmetals:end_tin_ore");
        orespawnoreentry.setSize(8);
        orespawnoreentry.setVariation(12);
        orespawnoreentry.setFrequency(20);
        orespawnoreentry.setMinHeight(0);
        orespawnoreentry.setMaxHeight(96);

        ores.add(orespawnoreentry);

        orespawnoreentry.setBlockID("endmetals:end_zinc_ore");
        orespawnoreentry.setSize(8);
        orespawnoreentry.setVariation(8);
        orespawnoreentry.setFrequency(12);
        orespawnoreentry.setMinHeight(0);
        orespawnoreentry.setMaxHeight(96);

        ores.add(orespawnoreentry);

        orespawndimensionentry.setDimension(1);
        orespawndimensionentry.set__comment("dimension 0 for overworld, -1 for the nether, 1 for the end, other numbers for dimensions added by other mods, and + for any dimension not already described by this file.");
        orespawndimensionentry.setOres(ores);

        dimensions.add(orespawndimensionentry);
        
        orespawnentry.setDimensions(dimensions);
        
        return orespawnentry;
    }
}
