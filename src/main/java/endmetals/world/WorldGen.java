package endmetals.world;

import java.util.Random;

import endmetals.ConfigHandler;
import endmetals.blocks.ModBlocks;

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

	private WorldGenerator gen_end_coal_ore;		// Generates Coal Ore (used in End)
	private WorldGenerator gen_end_diamond_ore;		// Generates Diamond Ore (used in End)
	private WorldGenerator gen_end_emerald_ore;		// Generates Emerald Ore (used in End)
	private WorldGenerator gen_end_gold_ore;		// Generates Gold Ore (used in End)
	private WorldGenerator gen_end_iron_ore;		// Generates Iron Ore (used in End)
	private WorldGenerator gen_end_lapis_ore;		// Generates Lapis Ore (used in End)
	private WorldGenerator gen_end_redstone_ore;	// Generates Redstone Ore (used in End)

	public WorldGen() {

		// Vanilla
		this.gen_end_coal_ore = new WorldGenMinable(ModBlocks.endcoalOre.getDefaultState(), ConfigHandler.getEndCoalOreSpawnProb(), BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_diamond_ore = new WorldGenMinable(ModBlocks.enddiamondOre.getDefaultState(), ConfigHandler.getEndDiamondOreSpawnProb(), BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_emerald_ore = new WorldGenMinable(ModBlocks.endemeraldOre.getDefaultState(), ConfigHandler.getEndEmeraldOreSpawnProb(), BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_gold_ore = new WorldGenMinable(ModBlocks.endgoldOre.getDefaultState(), ConfigHandler.getEndGoldOreSpawnProb(), BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_iron_ore = new WorldGenMinable(ModBlocks.endironOre.getDefaultState(), ConfigHandler.getEndIronOreSpawnProb(), BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_lapis_ore = new WorldGenMinable(ModBlocks.endlapisOre.getDefaultState(), ConfigHandler.getEndLapisOreSpawnProb(), BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_redstone_ore = new WorldGenMinable(ModBlocks.endredstoneOre.getDefaultState(), ConfigHandler.getEndRedstoneOreSpawnProb(), BlockMatcher.forBlock(Blocks.END_STONE));
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		switch (world.provider.getDimension()) {
		case 0: // Overworld
			break;
		case -1: // Nether
			break;
		case 1: // End
			// Vanilla
			this.runGenerator(this.gen_end_coal_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_diamond_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_emerald_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_gold_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_iron_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_lapis_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_redstone_ore, world, random, chunkX, chunkZ, 5, 0, 200);
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
