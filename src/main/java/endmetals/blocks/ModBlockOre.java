package endmetals.blocks;

import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;

public class ModBlockOre extends BlockOre {

	protected ModBlockOre(float Hardness, float Resistance) {
		super();

		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(4.0f);
		this.setResistance(15.0f);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
}
