package com.mcmoddev.orespawn;

import com.google.common.base.Function;
import com.mcmoddev.endmetals.blocks.ModBlocks;
import mmd.orespawn.api.OreSpawnAPI;
import mmd.orespawn.api.SpawnLogic;

public class EndMetalsOreSpawn implements Function<OreSpawnAPI, SpawnLogic> {

	@Override
	public SpawnLogic apply(OreSpawnAPI api) {
		SpawnLogic logic = api.createSpawnLogic();

		logic.getDimension(1)
		.addOre(ModBlocks.antimonyOre .getDefaultState(), 8, 4, 10, 0,  32)
		.addOre(ModBlocks.bismuthOre.getDefaultState(), 8, 4,  10, 0,  32)
		.addOre(ModBlocks.copperOre.getDefaultState(), 8, 12,  20, 0,  96)
		.addOre(ModBlocks.leadOre.getDefaultState(), 8, 12,  20, 0,  96)
		.addOre(ModBlocks.mercuryOre.getDefaultState(), 8, 4,  10, 0,  32)
		.addOre(ModBlocks.nickelOre.getDefaultState(), 8, 4,  10, 0,  96)
		.addOre(ModBlocks.platinumOre.getDefaultState(), 8, 4,  10, 0,  32)
		.addOre(ModBlocks.silverOre.getDefaultState(), 8, 8,  10, 0,  32)
		.addOre(ModBlocks.tinOre.getDefaultState(), 8, 12,  20, 0,  96)
		.addOre(ModBlocks.zincOre.getDefaultState(), 8, 8,  12, 0,  96)

		.addOre(ModBlocks.aluminumOre.getDefaultState(), 8, 8,  10, 0,  96)
		.addOre(ModBlocks.cadmiumOre.getDefaultState(), 8, 8,  10, 0,  96)
		.addOre(ModBlocks.chromiumOre.getDefaultState(), 8, 8,  10, 0,  96)
		.addOre(ModBlocks.iridiumOre.getDefaultState(), 8, 8,  10, 0,  96)
		.addOre(ModBlocks.magnesiumOre.getDefaultState(), 8, 8,  10, 0,  96)
		.addOre(ModBlocks.manganeseOre.getDefaultState(), 8, 8,  10, 0,  96)
		.addOre(ModBlocks.osmiumOre.getDefaultState(), 8, 8,  10, 0,  96)
		.addOre(ModBlocks.plutoniumOre.getDefaultState(), 8, 4,  10, 0,  96)
		.addOre(ModBlocks.rutileOre.getDefaultState(), 8, 8,  10, 0,  96)
		.addOre(ModBlocks.tantalumOre.getDefaultState(), 8, 8,  10, 0,  96)
		.addOre(ModBlocks.titaniumOre.getDefaultState(), 8, 4,  10, 0,  96)
		.addOre(ModBlocks.tungstenOre.getDefaultState(), 8, 8,  10, 0,  96)
		.addOre(ModBlocks.uraniumOre.getDefaultState(), 8, 4,  10, 0,  96)
		.addOre(ModBlocks.zirconiumOre.getDefaultState(), 8, 8,  10, 0,  96);

		return logic;
	}
}
