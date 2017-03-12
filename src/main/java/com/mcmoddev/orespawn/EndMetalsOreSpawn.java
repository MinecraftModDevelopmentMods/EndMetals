package com.mcmoddev.orespawn;

import com.google.common.base.Function;
import com.mcmoddev.lib.init.Materials;

import mmd.orespawn.api.OreSpawnAPI;
import mmd.orespawn.api.SpawnLogic;
import net.minecraftforge.fml.common.Loader;

public class EndMetalsOreSpawn implements Function<OreSpawnAPI, SpawnLogic> {

	@Override
	public SpawnLogic apply(OreSpawnAPI api) {

		SpawnLogic logic = api.createSpawnLogic();

		// Vanilla
		logic.getDimension(1)
		.addOre(Materials.getMaterialByName("coal").oreEnd.getDefaultState(), 10, 8,  12, 0,  200)
		.addOre(Materials.getMaterialByName("diamond").oreEnd.getDefaultState(), 2, 8,  12, 0,  200)
		.addOre(Materials.getMaterialByName("emerald").oreEnd.getDefaultState(), 4, 8,  12, 0,  200)
		.addOre(Materials.getMaterialByName("gold").oreEnd.getDefaultState(), 5, 8,  12, 0,  200)
		.addOre(Materials.getMaterialByName("iron").oreEnd.getDefaultState(), 10, 8,  12, 0,  200)
		.addOre(Materials.getMaterialByName("lapis").oreEnd.getDefaultState(), 8, 8,  12, 0,  96)
		.addOre(Materials.getMaterialByName("redstone").oreEnd.getDefaultState(), 8, 8,  12, 0,  96);

		//Base Metals
		if (Loader.isModLoaded("basemetals")) {
			if( com.mcmoddev.basemetals.util.Config.Options.enableAntimony ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("antimony").oreEnd.getDefaultState(), 8, 4, 10, 0,  200);
			}

			if( com.mcmoddev.basemetals.util.Config.Options.enableBismuth ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("bismuth").oreEnd.getDefaultState(), 8, 4,  10, 0,  200);
			}

			if( com.mcmoddev.basemetals.util.Config.Options.enableCopper ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("copper").oreEnd.getDefaultState(), 10, 12,  20, 0,  200);
			}

			if( com.mcmoddev.basemetals.util.Config.Options.enableLead ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("lead").oreEnd.getDefaultState(), 8, 12,  20, 0,  200);
			}

			if( com.mcmoddev.basemetals.util.Config.Options.enableMercury ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("mercury").oreEnd.getDefaultState(), 4, 4,  10, 0,  200);
			}

			if( com.mcmoddev.basemetals.util.Config.Options.enableNickel ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("nickel").oreEnd.getDefaultState(), 6, 4,  10, 0,  200);
			}

			if( com.mcmoddev.basemetals.util.Config.Options.enablePlatinum ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("platinum").oreEnd.getDefaultState(), 2, 4,  10, 0,  200);
			}

			if( com.mcmoddev.basemetals.util.Config.Options.enableSilver ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("silver").oreEnd.getDefaultState(), 8, 8,  10, 0,  200);
			}

			if( com.mcmoddev.basemetals.util.Config.Options.enableTin ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("tin").oreEnd.getDefaultState(), 10, 12,  20, 0,  200);
			}

			if( com.mcmoddev.basemetals.util.Config.Options.enableZinc ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("zinc").oreEnd.getDefaultState(), 6, 8,  12, 0,  200);
			}
		}

		//Modern Metals
		if (Loader.isModLoaded("modernmetals")) {
			if( com.mcmoddev.modernmetals.util.Config.Options.enableAluminum ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("aluminum").oreEnd.getDefaultState(), 10, 8,  10, 0,  200);
			}

			if( com.mcmoddev.modernmetals.util.Config.Options.enableCadmium ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("cadmium").oreEnd.getDefaultState(), 4, 8,  10, 0,  200);
			}

			if( com.mcmoddev.modernmetals.util.Config.Options.enableChromium ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("chromium").oreEnd.getDefaultState(), 4, 8,  10, 0,  200);
			}

			if( com.mcmoddev.modernmetals.util.Config.Options.enableIridium ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("iridium").oreEnd.getDefaultState(), 6, 8,  10, 0,  200);
			}

			if( com.mcmoddev.modernmetals.util.Config.Options.enableMagnesium ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("magnesium").oreEnd.getDefaultState(), 6, 8,  10, 0,  200);
			}

			if( com.mcmoddev.modernmetals.util.Config.Options.enableManganese ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("manganese").oreEnd.getDefaultState(), 6, 8,  10, 0,  200);
			}

			if( com.mcmoddev.modernmetals.util.Config.Options.enableOsmium ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("osmium").oreEnd.getDefaultState(), 10, 8,  10, 0,  200);
			}

			if( com.mcmoddev.modernmetals.util.Config.Options.enablePlutonium ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("plutonium").oreEnd.getDefaultState(), 4, 4,  10, 0,  200);
			}

			if( com.mcmoddev.modernmetals.util.Config.Options.enableRutile ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("rutile").oreEnd.getDefaultState(), 8, 8,  10, 0,  200);
			}

			if( com.mcmoddev.modernmetals.util.Config.Options.enableTantalum ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("tantalum").oreEnd.getDefaultState(), 8, 8,  10, 0,  200);
			}

			if( com.mcmoddev.modernmetals.util.Config.Options.enableTitanium ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("titanium").oreEnd.getDefaultState(), 4, 4,  10, 0,  200);
			}

			if( com.mcmoddev.modernmetals.util.Config.Options.enableTungsten ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("tungsten").oreEnd.getDefaultState(), 8, 8,  10, 0,  200);
			}

			if( com.mcmoddev.modernmetals.util.Config.Options.enableUranium ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("uranium").oreEnd.getDefaultState(), 2, 4,  10, 0,  200);
			}

			if( com.mcmoddev.modernmetals.util.Config.Options.enableZirconium ) {
				logic.getDimension(1).addOre(Materials.getMaterialByName("zirconium").oreEnd.getDefaultState(), 8, 8,  10, 0,  200);;
			}
		}

		return logic;
	}
}
