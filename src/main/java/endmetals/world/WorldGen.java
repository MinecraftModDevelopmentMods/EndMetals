package endmetals.world;

import java.util.Random;

import endmetals.ConfigHandler;
import endmetals.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

/**
 * 
 * @author Jasmine Iwanek
 * @author Knoxhack
 *
 */
public class WorldGen implements IWorldGenerator {

	private final Block GEN_BASE_BLOCK = Blocks.end_stone; // End;

	private WorldGenerator GEN_COAL_ORE;		// Generates Coal Ore
	private WorldGenerator GEN_DIAMOND_ORE;		// Generates Diamond Ore
	private WorldGenerator GEN_EMERALD_ORE;		// Generates Emerald Ore
	private WorldGenerator GEN_GOLD_ORE;		// Generates Gold Ore
	private WorldGenerator GEN_IRON_ORE;		// Generates Iron Ore
	private WorldGenerator GEN_LAPIS_ORE;		// Generates Lapis Ore
	private WorldGenerator GEN_REDSTONE_ORE;	// Generates Redstone Ore

	/**
	 * 
	 */
	public WorldGen() {

		// Vanilla
		this.GEN_COAL_ORE = new WorldGenMinable(ModBlocks.coal_ore.getDefaultState(), ConfigHandler.getCoalOreSpawnProb(), BlockHelper.forBlock(this.GEN_BASE_BLOCK));
		this.GEN_DIAMOND_ORE = new WorldGenMinable(ModBlocks.diamond_ore.getDefaultState(), ConfigHandler.getDiamondOreSpawnProb(), BlockHelper.forBlock(this.GEN_BASE_BLOCK));
		this.GEN_EMERALD_ORE = new WorldGenMinable(ModBlocks.emerald_ore.getDefaultState(), ConfigHandler.getEmeraldOreSpawnProb(), BlockHelper.forBlock(this.GEN_BASE_BLOCK));
		this.GEN_GOLD_ORE = new WorldGenMinable(ModBlocks.gold_ore.getDefaultState(), ConfigHandler.getGoldOreSpawnProb(), BlockHelper.forBlock(this.GEN_BASE_BLOCK));
		this.GEN_IRON_ORE = new WorldGenMinable(ModBlocks.iron_ore.getDefaultState(), ConfigHandler.getIronOreSpawnProb(), BlockHelper.forBlock(this.GEN_BASE_BLOCK));
		this.GEN_LAPIS_ORE = new WorldGenMinable(ModBlocks.lapis_ore.getDefaultState(), ConfigHandler.getLapisOreSpawnProb(), BlockHelper.forBlock(this.GEN_BASE_BLOCK));
		this.GEN_REDSTONE_ORE = new WorldGenMinable(ModBlocks.redstone_ore.getDefaultState(), ConfigHandler.getRedstoneOreSpawnProb(), BlockHelper.forBlock(this.GEN_BASE_BLOCK));
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		switch (world.provider.getDimensionId()) {
		case 0: // Overworld
			break;
		case -1: // Nether
			break;
		case 1: // End
			// Vanilla
			this.runGenerator(this.GEN_COAL_ORE,     world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.GEN_DIAMOND_ORE,  world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.GEN_EMERALD_ORE,  world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.GEN_GOLD_ORE,     world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.GEN_IRON_ORE,     world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.GEN_LAPIS_ORE,    world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.GEN_REDSTONE_ORE, world, random, chunkX, chunkZ, 5, 0, 200);
			break;
		default:
			break;
		}
	}

	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i++) {
			int x = chunk_X * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunk_Z * 16 + rand.nextInt(16);
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
}
