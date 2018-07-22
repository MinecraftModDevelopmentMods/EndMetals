package com.mcmoddev.endmetals.integration.plugins;

import com.mcmoddev.endmetals.EndMetals;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.integration.IIntegration;
import com.mcmoddev.lib.integration.MMDPlugin;
import com.mcmoddev.lib.integration.plugins.ThermalExpansionBase;
import com.mcmoddev.lib.util.ConfigBase.Options;
import com.mcmoddev.lib.init.Materials;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@MMDPlugin(addonId=EndMetals.MODID, pluginId=ThermalExpansion.PLUGIN_MODID)
public class ThermalExpansion extends ThermalExpansionBase implements IIntegration {
	@Override
	public void init() {
		if (!Options.isModEnabled(PLUGIN_MODID)) {
			return;
		}

		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void regCallback(final RegistryEvent.Register<IRecipe> event) {
		Materials.getAllMaterials().stream()
		.filter(material -> material.hasBlock(Names.ENDORE))
		.filter(material -> material.hasItem(Names.POWDER))
		.forEach(material -> {
			final ItemStack ore = material.getBlockItemStack(Names.ENDORE, 1);
			final ItemStack powder = material.getItemStack(Names.POWDER, 4);
			if (!((ore.isEmpty()) || (powder.isEmpty())))
				addPulverizerRecipe( 4000, ore, powder);
		});
	}
}
