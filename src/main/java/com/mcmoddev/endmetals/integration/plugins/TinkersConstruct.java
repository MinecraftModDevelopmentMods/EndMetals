package com.mcmoddev.endmetals.integration.plugins;

import com.mcmoddev.endmetals.EndMetals;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.integration.IIntegration;
import com.mcmoddev.lib.integration.MMDPlugin;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.util.ConfigBase.Options;
import com.mcmoddev.lib.util.Oredicts;
import com.mcmoddev.lib.integration.plugins.TinkersConstructBase;

import net.minecraftforge.fluids.FluidRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.smeltery.MeltingRecipe;
import slimeknights.mantle.util.RecipeMatch;

/**
 *
 * @author Jasmine Iwanek
 *
 */
@MMDPlugin(addonId = EndMetals.MODID, 
pluginId = TinkersConstruct.PLUGIN_MODID, 
postInitCallback="registerExtraMelting")
public class TinkersConstruct extends TinkersConstructBase implements IIntegration {

	@Override
	public void init() {
		if (!Options.isModEnabled(TinkersConstruct.PLUGIN_MODID)) {
			return;
		}

	}
	
	private boolean registered = false;
	public void registerExtraMelting() {
		if (registered) return;
		registered = true;
		Materials.getAllMaterials().stream()
		.filter(this::isMaterialEmpty)
		.filter(this::hasEndOre)
		.filter(this::hasFluid)
		.forEach(mat -> {
			RecipeMatch input = RecipeMatch.of(Oredicts.ORE_END + mat.getCapitalizedName(), 576);
			MeltingRecipe rec = new MeltingRecipe(input, FluidRegistry.getFluid(mat.getName()));
			TinkerRegistry.registerMelting(rec);
		});
	}
	
	private boolean hasFluid(MMDMaterial mat) {
		return FluidRegistry.getFluid(mat.getName()) != null;
	}
	
	private boolean hasEndOre(MMDMaterial mat) {
		return mat.hasBlock(Names.ENDORE);
	}
	
	private boolean isMaterialEmpty(MMDMaterial mat) {
		return !mat.isEmpty();
	}	
}
