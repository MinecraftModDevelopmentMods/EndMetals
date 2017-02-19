package com.mcmoddev.endmetals.util;

import com.mcmoddev.lib.init.Materials;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabEMe extends CreativeTabs {

	public CreativeTabEMe() {
		super("endmetals");
	}

	@Override
	public Item getTabIconItem () {
		return Item.getItemFromBlock(Materials.getMaterialByName("lead").oreEnd) ;
	}
}