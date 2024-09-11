package com.terraformersmc.traverse.worldgen;


import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.biomegen.TraverseTerraBlenderGeneration;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

public class TraverseWorldgen {
	public TraverseWorldgen(){
		onInitialize();
	}

	public void onInitialize() {

		if (ModList.get().isLoaded("terrablender")) {
			Traverse.LOGGER.info("Enabling Traverse's TerraBlender worldgen module.");
			TraverseTerraBlenderGeneration.onTerraBlenderInitialized();
		} else {
			Traverse.LOGGER.warn("Traverse world generation disabled; TerraBlender is not present.");
		}
	}
}
