package com.terraformersmc.traverse.client;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Traverse.MOD_ID + "_client")
public class TraverseClient {

	public TraverseClient(){
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		registerEntityRenderers();
	}

	private void clientSetup(FMLClientSetupEvent event){
		onInitializeClient();
	}

	public void onInitializeClient() {
		registerRenderLayers();
		registerTextures();
	}

	private static void registerEntityRenderers() {
		TerraformBoatClientHelper.registerModelLayers(new Identifier(Traverse.MOD_ID, "fir"));
	}

	private static void registerRenderLayers() {
		RenderLayer cutout = RenderLayer.getCutout();
		addArrayToLayer(cutout, TraverseBlocks.FIR_SAPLING, TraverseBlocks.FIR_DOOR, TraverseBlocks.FIR_TRAPDOOR);
		addArrayToLayer(cutout, TraverseBlocks.RED_AUTUMNAL_SAPLING, TraverseBlocks.BROWN_AUTUMNAL_SAPLING, TraverseBlocks.ORANGE_AUTUMNAL_SAPLING, TraverseBlocks.YELLOW_AUTUMNAL_SAPLING);
		addArrayToLayer(cutout, TraverseBlocks.POTTED_RED_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_BROWN_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_ORANGE_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_YELLOW_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_FIR_SAPLING);
	}

	private static void registerTextures() {
		Identifier texture = TraverseBlocks.FIR_SIGN.getTexture();
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, texture));
	}

	public static void addArrayToLayer(RenderLayer layer, Block... blocks){
		for (Block block : blocks) {
			RenderLayers.setRenderLayer(block, layer);
		}
	}
}
