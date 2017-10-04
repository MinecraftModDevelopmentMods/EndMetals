package com.mcmoddev.endmetals.init;

import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.init.MMDCreativeTab;
import com.mcmoddev.lib.init.Materials;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * This class initializes all item groups in End Metals.
 *
 * @author Jasmine Iwanek
 *
 */
public class ItemGroups extends com.mcmoddev.lib.init.ItemGroups {

	private static boolean initDone = false;
	private static final int blocksTabId  = addTab("blocks", true );
	public static final MMDCreativeTab blocksTab = getTab(blocksTabId);

	private ItemGroups() {
		throw new IllegalAccessError("Not a instantiable class");
	}

	/**
	 *
	 */
	public static void init() {
		if (initDone) {
			return;
		}

		initDone = true;
	}
	
	public static void setupIcons() {
		Item blocksTabIconItem = Item.getItemFromBlock(Materials.getMaterialByName(com.mcmoddev.basemetals.data.MaterialNames.LAPIS).getBlock(Names.ENDORE));

		blocksTab.setTabIconItem(new ItemStack(blocksTabIconItem));
	}

}
