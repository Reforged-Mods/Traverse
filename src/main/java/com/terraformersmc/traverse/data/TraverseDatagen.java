package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.Traverse;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.BlockTagProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Traverse.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TraverseDatagen {
	public static void onInitializeDataGenerator(DataGenerator dataGenerator, ExistingFileHelper helper) {
		dataGenerator.addProvider(new TraverseBiomeTagProvider(dataGenerator, helper));
		dataGenerator.addProvider(new TraverseLootTableProvider(dataGenerator));
		BlockTagProvider provider = new TraverseBlockTagProvider(dataGenerator, helper);
		dataGenerator.addProvider(provider);
		dataGenerator.addProvider(new TraverseItemTagProvider(dataGenerator, provider, helper));
		dataGenerator.addProvider(new TraverseRecipeProvider(dataGenerator));
	}

	@SubscribeEvent
	public static void onGatherDataEvent(GatherDataEvent event){
		onInitializeDataGenerator(event.getGenerator(), event.getExistingFileHelper());
	}
}
