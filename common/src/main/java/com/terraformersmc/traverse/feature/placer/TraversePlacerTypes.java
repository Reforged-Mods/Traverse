package com.terraformersmc.traverse.feature.placer;

import com.mojang.serialization.Codec;
import com.terraformersmc.terraform.tree.placer.PlacerTypes;
import com.terraformersmc.traverse.Traverse;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.minecraftforge.registries.ForgeRegistries;

public class TraversePlacerTypes {
	public static final FoliagePlacerType<NoneFoliagePlacer> NONE_FOLIAGE_PLACER = register("none", NoneFoliagePlacer.CODEC);
	public static final TrunkPlacerType<FallenTrunkPlacer> FALLEN_TRUNK_PLACER = PlacerTypes.registerTrunkPlacer("traverse:fallen", FallenTrunkPlacer.CODEC);

	public static void register() {
	}

	private static <P extends FoliagePlacer> FoliagePlacerType<P> register(String name, Codec<P> codec) {
		FoliagePlacerType<P> type = new FoliagePlacerType<P>(codec);
		ForgeRegistries.FOLIAGE_PLACER_TYPES.register(new Identifier(Traverse.MOD_ID, name), type);
		return type;
	}
}
