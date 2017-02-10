package com.mcmoddev.endmetals.blocks;

import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;

public class ModBlockOre extends BlockOre {

	protected ModBlockOre(float hardness, float resistance) {
		super();

		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
}
