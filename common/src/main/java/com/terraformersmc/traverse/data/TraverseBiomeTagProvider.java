package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.biome.TraverseBiomes;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.BiomeTagProvider;
import net.minecraft.tag.BiomeTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TraverseBiomeTagProvider extends BiomeTagProvider {
	public TraverseBiomeTagProvider(DataGenerator dataGenerator, ExistingFileHelper helper) {
		super(dataGenerator, Traverse.MOD_ID, helper);
	}

	@Override
	protected void configure() {
		/*
		 * Vanilla biome categories
		 */
		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.IS_FOREST.id()))
			.add(TraverseBiomes.AUTUMNAL_WOODS)
			.add(TraverseBiomes.CONIFEROUS_FOREST)
			.add(TraverseBiomes.WOODLANDS);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.IS_TAIGA.id()))
			.add(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);


		/*
		 * Conventional biome categories
		 */
		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), new Identifier("forge", "is_temperate")))
			.add(TraverseBiomes.AUTUMNAL_WOODS)
			.add(TraverseBiomes.CONIFEROUS_FOREST)
			.add(TraverseBiomes.FLATLANDS)
			.add(TraverseBiomes.LUSH_SWAMP)
			.add(TraverseBiomes.WOODLANDS);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), Tags.Biomes.IS_SANDY.id()))
			.add(TraverseBiomes.DESERT_SHRUBLAND);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), Tags.Biomes.IS_PLAINS.id()))
			.add(TraverseBiomes.FLATLANDS);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), Tags.Biomes.IS_OVERWORLD.id()))
			.add(TraverseBiomes.AUTUMNAL_WOODS)
			.add(TraverseBiomes.CONIFEROUS_FOREST)
			.add(TraverseBiomes.DESERT_SHRUBLAND)
			.add(TraverseBiomes.FLATLANDS)
			.add(TraverseBiomes.LUSH_SWAMP)
			.add(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.add(TraverseBiomes.WOODLANDS);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), Tags.Biomes.IS_SWAMP.id()))
			.add(TraverseBiomes.LUSH_SWAMP);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), Tags.Biomes.IS_CONIFEROUS.id()))
			.add(TraverseBiomes.CONIFEROUS_FOREST);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), new Identifier("forge", "is_deciduous")))
			.add(TraverseBiomes.AUTUMNAL_WOODS)
			.add(TraverseBiomes.LUSH_SWAMP)
			.add(TraverseBiomes.WOODLANDS);


		/*
		 * Biome structure generation tags
		 */
		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.IGLOO_HAS_STRUCTURE.id()))
			.add(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.MINESHAFT_HAS_STRUCTURE.id()))
			.add(TraverseBiomes.DESERT_SHRUBLAND)
			.add(TraverseBiomes.FLATLANDS)
			.add(TraverseBiomes.LUSH_SWAMP);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.PILLAGER_OUTPOST_HAS_STRUCTURE.id()))
			.add(TraverseBiomes.CONIFEROUS_FOREST)
			.add(TraverseBiomes.DESERT_SHRUBLAND)
			.add(TraverseBiomes.FLATLANDS)
			.add(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.add(TraverseBiomes.WOODLANDS);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.RUINED_PORTAL_DESERT_HAS_STRUCTURE.id()))
			.add(TraverseBiomes.DESERT_SHRUBLAND);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.RUINED_PORTAL_STANDARD_HAS_STRUCTURE.id()))
			.add(TraverseBiomes.CONIFEROUS_FOREST)
			.add(TraverseBiomes.FLATLANDS)
			.add(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.add(TraverseBiomes.WOODLANDS);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.RUINED_PORTAL_SWAMP_HAS_STRUCTURE.id()))
			.add(TraverseBiomes.LUSH_SWAMP);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.STRONGHOLD_HAS_STRUCTURE.id()))
			.add(TraverseBiomes.AUTUMNAL_WOODS)
			.add(TraverseBiomes.CONIFEROUS_FOREST)
			.add(TraverseBiomes.DESERT_SHRUBLAND)
			.add(TraverseBiomes.FLATLANDS)
			.add(TraverseBiomes.LUSH_SWAMP)
			.add(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.add(TraverseBiomes.WOODLANDS);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.SWAMP_HUT_HAS_STRUCTURE.id()))
			.add(TraverseBiomes.LUSH_SWAMP);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE.id()))
			.add(TraverseBiomes.DESERT_SHRUBLAND);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.VILLAGE_PLAINS_HAS_STRUCTURE.id()))
			.add(TraverseBiomes.FLATLANDS)
			.add(TraverseBiomes.WOODLANDS);
	}
}
