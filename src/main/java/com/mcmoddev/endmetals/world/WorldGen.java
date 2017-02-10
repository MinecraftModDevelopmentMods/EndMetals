package com.mcmoddev.endmetals.world;

import java.util.Random;

import com.mcmoddev.endmetals.ConfigHandler;
import com.mcmoddev.endmetals.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator {

	private WorldGenerator genCoalOre;		// Generates Coal Ore
	private WorldGenerator genDiamondOre;		// Generates Diamond Ore
	private WorldGenerator genEmeraldOre;		// Generates Emerald Ore
	private WorldGenerator genGoldOre;		// Generates Gold Ore
	private WorldGenerator genIronOre;		// Generates Iron Ore
	private WorldGenerator genLapisOre;		// Generates Lapis Ore
	private WorldGenerator genRedstoneOre;	// Generates Redstone Ore

	public WorldGen() {

		final Block matchBlock = Blocks.END_STONE;
		// Vanilla
		this.genCoalOre = new WorldGenMinable(ModBlocks.coalOre.getDefaultState(),         ConfigHandler.getCoalOreSpawnProb(),     BlockMatcher.forBlock(matchBlock));
		this.genDiamondOre = new WorldGenMinable(ModBlocks.diamondOre.getDefaultState(),   ConfigHandler.getDiamondOreSpawnProb(),  BlockMatcher.forBlock(matchBlock));
		this.genEmeraldOre = new WorldGenMinable(ModBlocks.emeraldOre.getDefaultState(),   ConfigHandler.getEmeraldOreSpawnProb(),  BlockMatcher.forBlock(matchBlock));
		this.genGoldOre = new WorldGenMinable(ModBlocks.goldOre.getDefaultState(),         ConfigHandler.getGoldOreSpawnProb(),     BlockMatcher.forBlock(matchBlock));
		this.genIronOre = new WorldGenMinable(ModBlocks.ironOre.getDefaultState(),         ConfigHandler.getIronOreSpawnProb(),     BlockMatcher.forBlock(matchBlock));
		this.genLapisOre = new WorldGenMinable(ModBlocks.lapisOre.getDefaultState(),       ConfigHandler.getLapisOreSpawnProb(),    BlockMatcher.forBlock(matchBlock));
		this.genRedstoneOre = new WorldGenMinable(ModBlocks.redstoneOre.getDefaultState(), ConfigHandler.getRedstoneOreSpawnProb(), BlockMatcher.forBlock(matchBlock));
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimension()) {
			case 0: // Overworld
				break;
			case -1: // Nether
				break;
			case 1: // End
				// Vanilla
				this.runGenerator(this.genCoalOre,     world, random, chunkX, chunkZ, 5, 0, 200);
				this.runGenerator(this.genDiamondOre,  world, random, chunkX, chunkZ, 5, 0, 200);
				this.runGenerator(this.genEmeraldOre,  world, random, chunkX, chunkZ, 5, 0, 200);
				this.runGenerator(this.genGoldOre,     world, random, chunkX, chunkZ, 5, 0, 200);
				this.runGenerator(this.genIronOre,     world, random, chunkX, chunkZ, 5, 0, 200);
				this.runGenerator(this.genLapisOre,    world, random, chunkX, chunkZ, 5, 0, 200);
				this.runGenerator(this.genRedstoneOre, world, random, chunkX, chunkZ, 5, 0, 200);
				break;
		}
	}

	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunkX, int chunkZ, int chancesToSpawn, int minHeight, int maxHeight) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
}
