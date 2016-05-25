package endmetals.world;

import java.util.Random;

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

	private WorldGenerator gen_end_coal_ore;			// Generates Coal Ore (used in Nether)
	private WorldGenerator gen_end_diamond_ore;		// Generates Diamond Ore (used in Nether)
	private WorldGenerator gen_end_emerald_ore;		// Generates Emerald Ore (used in Nether)
	private WorldGenerator gen_end_gold_ore;			// Generates Gold Ore (used in Nether)
	private WorldGenerator gen_end_iron_ore;			// Generates Iron Ore (used in Nether)
	private WorldGenerator gen_end_lapis_ore;		// Generates Lapis Ore (used in Nether)
	private WorldGenerator gen_end_redstone_ore;		// Generates Redstone Ore (used in Nether)

/*
	private WorldGenerator gen_end_antimony_ore;		// Generates Antimony Ore (used in Nether), Not supported in BM 2.2.2
	private WorldGenerator gen_end_bismuth_ore;		// Generates Bismuth Ore (used in Nether), Not supported in BM 2.2.2
	private WorldGenerator gen_end_copper_ore; 		// Generates Copper Ore (used in Nether)
	private WorldGenerator gen_end_lead_ore;			// Generates Lead Ore (used in Nether)
	private WorldGenerator gen_end_mercury_ore;		// Generates Mercury Ore (used in Nether)
	private WorldGenerator gen_end_nickel_ore;		// Generates Nickel Ore (used in Nether)
	private WorldGenerator gen_end_platinum_ore;		// Generates Platinum Ore (used in Nether)
	private WorldGenerator gen_end_silver_ore;		// Generates Silver Ore (used in Nether)
	private WorldGenerator gen_end_tin_ore;			// Generates Tin Ore (used in Nether)
	private WorldGenerator gen_end_zinc_ore;			// Generates Zinc Ore (used in Nether)

	private WorldGenerator gen_end_aluminum_ore;		// Generates Aluminum Ore (used in Nether)
	private WorldGenerator gen_end_cadmium_ore;		// Generates Cadmium Ore (used in Nether)
	private WorldGenerator gen_end_chromium_ore;		// Generates Chromium Ore (used in Nether)
	private WorldGenerator gen_end_iridium_ore;		// Generates Iridium Ore (used in Nether)
	private WorldGenerator gen_end_magnesium_ore;	// Generates Magnesium Ore (used in Nether)
	private WorldGenerator gen_end_manganese_ore;	// Generates Manganese Ore (used in Nether)
	private WorldGenerator gen_end_osmium_ore;		// Generates Osmium Ore (used in Nether)
	private WorldGenerator gen_end_plutonium_ore;	// Generates Plutonium Ore (used in Nether)
	private WorldGenerator gen_end_rutile_ore;		// Generates Rutile Ore (used in Nether)
	private WorldGenerator gen_end_tantalum_ore;		// Generates Tantalum Ore (used in Nether)
	private WorldGenerator gen_end_titanium_ore;		// Generates Titanium Ore (used in Nether)
	private WorldGenerator gen_end_tungsten_ore;		// Generates Tungsten Ore (used in Nether)
	private WorldGenerator gen_end_uranium_ore;		// Generates Uranium Ore (used in Nether)
	private WorldGenerator gen_end_zirconium_ore;	// Generates Zirconium Ore (used in Nether)
*/

	public WorldGen() {

		// Vanilla
		this.gen_end_coal_ore = new WorldGenMinable(ModBlocks.endcoalOre.getDefaultState(), 16, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_diamond_ore = new WorldGenMinable(ModBlocks.enddiamondOre.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_emerald_ore = new WorldGenMinable(ModBlocks.endemeraldOre.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_gold_ore = new WorldGenMinable(ModBlocks.endgoldOre.getDefaultState(), 8, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_iron_ore = new WorldGenMinable(ModBlocks.endironOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_lapis_ore = new WorldGenMinable(ModBlocks.endlapisOre.getDefaultState(), 8, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_redstone_ore = new WorldGenMinable(ModBlocks.endredstoneOre.getDefaultState(), 12, BlockMatcher.forBlock(Blocks.END_STONE));
	    
/*
		// Base Metals
		this.gen_end_antimony_ore = new WorldGenMinable(ModBlocks.netherantimonyOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));	// Not supported in BM 1.8.0
		this.gen_end_bismuth_ore = new WorldGenMinable(ModBlocks.netherbismuthOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));	// Not supported in BM 1.8.0
		this.gen_end_copper_ore = new WorldGenMinable(ModBlocks.nethercopperOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_lead_ore = new WorldGenMinable(ModBlocks.netherleadOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_mercury_ore = new WorldGenMinable(ModBlocks.nethermercuryOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_nickel_ore = new WorldGenMinable(ModBlocks.nethernickelOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_platinum_ore = new WorldGenMinable(ModBlocks.netherplatinumOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));	// Not supported in BM 1.8.0
		this.gen_end_silver_ore = new WorldGenMinable(ModBlocks.nethersilverOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_tin_ore = new WorldGenMinable(ModBlocks.nethertinOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_zinc_ore = new WorldGenMinable(ModBlocks.netherzincOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));

		// Modern Metals
		this.gen_end_aluminum_ore = new WorldGenMinable(ModBlocks.netheraluminumOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_cadmium_ore = new WorldGenMinable(ModBlocks.nethercadmiumOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_chromium_ore = new WorldGenMinable(ModBlocks.netherchromiumOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_iridium_ore = new WorldGenMinable(ModBlocks.netheriridiumOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_magnesium_ore = new WorldGenMinable(ModBlocks.nethermagnesiumOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_manganese_ore = new WorldGenMinable(ModBlocks.nethermanganeseOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_osmium_ore = new WorldGenMinable(ModBlocks.netherosmiumOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_plutonium_ore = new WorldGenMinable(ModBlocks.netherplutoniumOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_rutile_ore = new WorldGenMinable(ModBlocks.netherrutileOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_tantalum_ore = new WorldGenMinable(ModBlocks.nethertantalumOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_titanium_ore = new WorldGenMinable(ModBlocks.nethertitaniumOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_tungsten_ore = new WorldGenMinable(ModBlocks.nethertungstenOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_uranium_ore = new WorldGenMinable(ModBlocks.netheruraniumOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_end_zirconium_ore = new WorldGenMinable(ModBlocks.netherzirconiumOre.getDefaultState(), 14, BlockMatcher.forBlock(Blocks.END_STONE));
*/
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

/*
			// Base Metals
			this.runGenerator(this.gen_end_antimony_ore, world, random, chunkX, chunkZ, 5, 0, 200);	// Not supported in BM 1.8.0
			this.runGenerator(this.gen_end_bismuth_ore, world, random, chunkX, chunkZ, 5, 0, 200);	// Not supported in BM 1.8.0
			this.runGenerator(this.gen_end_copper_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_lead_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_mercury_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_nickel_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_platinum_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_silver_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_tin_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_zinc_ore, world, random, chunkX, chunkZ, 5, 0, 200);

			// Modern Metals
			this.runGenerator(this.gen_end_aluminum_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_cadmium_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_chromium_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_iridium_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_magnesium_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_manganese_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_osmium_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_plutonium_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_rutile_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_tantalum_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_titanium_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_tungsten_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_uranium_ore, world, random, chunkX, chunkZ, 5, 0, 200);
			this.runGenerator(this.gen_end_zirconium_ore, world, random, chunkX, chunkZ, 5, 0, 200);
*/
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
