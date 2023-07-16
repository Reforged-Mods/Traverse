package com.terraformersmc.traverse.block;

import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import com.terraformersmc.terraform.utils.TerraformFuelRegistry;
import com.terraformersmc.terraform.utils.mixin.FireBlockAccessor;
import com.terraformersmc.terraform.wood.block.*;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.sapling.TraverseSaplingGenerator;
import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraftforge.registries.ForgeRegistries;

public class TraverseBlocks {
	public static final Block RED_AUTUMNAL_LEAVES = withItem("red_autumnal_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_RED).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)), ItemGroup.DECORATIONS);
	public static final Block RED_AUTUMNAL_SAPLING = withItem("red_autumnal_sapling", new SaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.RED_AUTUMNAL_TREE), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.TERRACOTTA_RED)), ItemGroup.DECORATIONS);
	public static final Block BROWN_AUTUMNAL_LEAVES = withItem("brown_autumnal_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_BROWN).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)), ItemGroup.DECORATIONS);
	public static final Block BROWN_AUTUMNAL_SAPLING = withItem("brown_autumnal_sapling", new SaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.BROWN_AUTUMNAL_TREE), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.TERRACOTTA_BROWN)), ItemGroup.DECORATIONS);
	public static final Block ORANGE_AUTUMNAL_LEAVES = withItem("orange_autumnal_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_ORANGE).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)), ItemGroup.DECORATIONS);
	public static final Block ORANGE_AUTUMNAL_SAPLING = withItem("orange_autumnal_sapling", new SaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.ORANGE_AUTUMNAL_TREE), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.TERRACOTTA_ORANGE)), ItemGroup.DECORATIONS);
	public static final Block YELLOW_AUTUMNAL_LEAVES = withItem("yellow_autumnal_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_YELLOW).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)), ItemGroup.DECORATIONS);
	public static final Block YELLOW_AUTUMNAL_SAPLING = withItem("yellow_autumnal_sapling", new SaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.YELLOW_AUTUMNAL_TREE), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.TERRACOTTA_YELLOW)), ItemGroup.DECORATIONS);

	private static final Map<Identifier, BlockItem> ITEMS = new HashMap<>();
	public static final Map<Identifier, Block> BLOCKS = new HashMap<>();

	public static final Block FIR_PLANKS = add("fir_planks", new Block(TerraformBlockSettings.copyOf(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
	public static final Block FIR_SAPLING = add("fir_sapling", new TerraformSaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.FIR_TREE)), ItemGroup.DECORATIONS);

	public static final Block STRIPPED_FIR_LOG = add("stripped_fir_log", createLog(MapColor.BROWN, MapColor.OAK_TAN), ItemGroup.BUILDING_BLOCKS);
	public static final Block STRIPPED_FIR_WOOD = add("stripped_fir_wood", createLog(MapColor.OAK_TAN, MapColor.OAK_TAN), ItemGroup.BUILDING_BLOCKS);
	public static final Block FIR_LOG = add("fir_log", new StrippableLogBlock(() -> STRIPPED_FIR_LOG, MapColor.BROWN, TerraformBlockSettings.copyOf(Blocks.DARK_OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
	public static final Block FIR_WOOD = add("fir_wood", new StrippableLogBlock(() -> STRIPPED_FIR_WOOD, MapColor.BROWN, TerraformBlockSettings.copyOf(Blocks.DARK_OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
	public static final Block FIR_LEAVES = add("fir_leaves", new LeavesBlock(TerraformBlockSettings.copyOf(Blocks.OAK_LEAVES).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)), ItemGroup.DECORATIONS);
	public static final Block FIR_SLAB = add("fir_slab", new SlabBlock(TerraformBlockSettings.copyOf(Blocks.OAK_SLAB)), ItemGroup.BUILDING_BLOCKS);
	public static final Block FIR_PRESSURE_PLATE = add("fir_pressure_plate", new TerraformPressurePlateBlock(TerraformBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE)), ItemGroup.REDSTONE);
	public static final Block FIR_FENCE = add("fir_fence", new FenceBlock(TerraformBlockSettings.copyOf(Blocks.OAK_FENCE)), ItemGroup.DECORATIONS);
	public static final Block FIR_TRAPDOOR = add("fir_trapdoor", new TerraformTrapdoorBlock(TerraformBlockSettings.copyOf(Blocks.OAK_TRAPDOOR)), ItemGroup.REDSTONE);
	public static final Block FIR_FENCE_GATE = add("fir_fence_gate", new FenceGateBlock(TerraformBlockSettings.copyOf(Blocks.OAK_FENCE_GATE)), ItemGroup.REDSTONE);
	public static final Block FIR_STAIRS = add("fir_stairs", new TerraformStairsBlock(FIR_PLANKS, TerraformBlockSettings.copyOf(Blocks.OAK_STAIRS)), ItemGroup.BUILDING_BLOCKS);
	public static final Block FIR_BUTTON = add("fir_button", new TerraformButtonBlock(TerraformBlockSettings.copyOf(Blocks.OAK_BUTTON)), ItemGroup.REDSTONE);
	public static final Block FIR_DOOR = add("fir_door", new TerraformDoorBlock(TerraformBlockSettings.copyOf(Blocks.OAK_DOOR)), ItemGroup.REDSTONE);
	private static final Identifier FIR_SIGN_TEXTURE = new Identifier(Traverse.MOD_ID, "entity/sign/fir");
	public static final TerraformSignBlock FIR_SIGN = add("fir_sign", new TerraformSignBlock(FIR_SIGN_TEXTURE, TerraformBlockSettings.copyOf(Blocks.OAK_SIGN)));
	public static final Block FIR_WALL_SIGN = add("fir_wall_sign", new TerraformWallSignBlock(FIR_SIGN_TEXTURE, TerraformBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)));
	public static final Item FIR_SIGN_ITEM = add("fir_sign", new SignItem(new Item.Settings().maxCount(16).group(ItemGroup.DECORATIONS), FIR_SIGN, FIR_WALL_SIGN));

	public static final Block POTTED_RED_AUTUMNAL_SAPLING = add("potted_red_autumnal_sapling", new FlowerPotBlock(RED_AUTUMNAL_SAPLING, TerraformBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
	public static final Block POTTED_BROWN_AUTUMNAL_SAPLING = add("potted_brown_autumnal_sapling", new FlowerPotBlock(BROWN_AUTUMNAL_SAPLING, TerraformBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
	public static final Block POTTED_ORANGE_AUTUMNAL_SAPLING = add("potted_orange_autumnal_sapling", new FlowerPotBlock(ORANGE_AUTUMNAL_SAPLING, TerraformBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
	public static final Block POTTED_YELLOW_AUTUMNAL_SAPLING = add("potted_yellow_autumnal_sapling", new FlowerPotBlock(YELLOW_AUTUMNAL_SAPLING, TerraformBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
	public static final Block POTTED_FIR_SAPLING = add("potted_fir_sapling", new FlowerPotBlock(FIR_SAPLING, TerraformBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));

	private static <B extends Block> B withItem(String name, B block, ItemGroup tab) {
		TraverseItems.add(name, new BlockItem(block, new Item.Settings().group(tab)));

		return add(name, block);
	}

	private static <B extends Block> B add(String name, B block) {
		Registry.register(Registry.BLOCK, Identifier.of(Traverse.MOD_ID, name), block);

		return block;
	}

	public static void register() {
		addCompostables();
		addFlammables();
		addFuels();
		addStrippables();
	}

	private static void addCompostables() {
		CompostingChanceRegistry compostingRegistry = CompostingChanceRegistry.INSTANCE;
		float LEAVES_CHANCE = compostingRegistry.get(Items.OAK_LEAVES);
		float SAPLING_CHANCE = compostingRegistry.get(Items.OAK_SAPLING);

		compostingRegistry.add(FIR_LEAVES, LEAVES_CHANCE);
		compostingRegistry.add(FIR_SAPLING, SAPLING_CHANCE);
		compostingRegistry.add(BROWN_AUTUMNAL_LEAVES, LEAVES_CHANCE);
		compostingRegistry.add(BROWN_AUTUMNAL_SAPLING, SAPLING_CHANCE);
		compostingRegistry.add(ORANGE_AUTUMNAL_LEAVES, LEAVES_CHANCE);
		compostingRegistry.add(ORANGE_AUTUMNAL_SAPLING, SAPLING_CHANCE);
		compostingRegistry.add(RED_AUTUMNAL_LEAVES, LEAVES_CHANCE);
		compostingRegistry.add(RED_AUTUMNAL_SAPLING, SAPLING_CHANCE);
		compostingRegistry.add(YELLOW_AUTUMNAL_LEAVES, LEAVES_CHANCE);
		compostingRegistry.add(YELLOW_AUTUMNAL_SAPLING, SAPLING_CHANCE);
	}

	private static void addFlammables() {
		FireBlockAccessor block = (FireBlockAccessor) Blocks.FIRE;
		block.invokeRegisterFlammableBlock(FIR_PLANKS, 5, 20);
		block.invokeRegisterFlammableBlock(FIR_SLAB, 5, 20);
		block.invokeRegisterFlammableBlock(FIR_FENCE_GATE, 5, 20);
		block.invokeRegisterFlammableBlock(FIR_FENCE, 5, 20);
		block.invokeRegisterFlammableBlock(FIR_STAIRS, 5, 20);
		block.invokeRegisterFlammableBlock(FIR_LOG, 5, 5);
		block.invokeRegisterFlammableBlock(STRIPPED_FIR_LOG, 5, 5);
		block.invokeRegisterFlammableBlock(STRIPPED_FIR_WOOD, 5, 5);
		block.invokeRegisterFlammableBlock(FIR_WOOD, 5, 5);
		block.invokeRegisterFlammableBlock(FIR_LEAVES, 30, 60);
		block.invokeRegisterFlammableBlock(RED_AUTUMNAL_LEAVES, 30, 60);
		block.invokeRegisterFlammableBlock(BROWN_AUTUMNAL_LEAVES, 30, 60);
		block.invokeRegisterFlammableBlock(ORANGE_AUTUMNAL_LEAVES, 30, 60);
		block.invokeRegisterFlammableBlock(YELLOW_AUTUMNAL_LEAVES, 30, 60);
	}

	private static void addFuels() {
		FuelRegistry fuelRegistry = FuelRegistry.INSTANCE;

		fuelRegistry.add(FIR_FENCE, 300);
		fuelRegistry.add(FIR_FENCE_GATE, 300);
	}

	private static void addStrippables() {
		StrippableBlockRegistry.register(FIR_LOG, STRIPPED_FIR_LOG);
		StrippableBlockRegistry.register(FIR_WOOD, STRIPPED_FIR_WOOD);
	}

	// Todo: fix when Fabric API supports `of(Material material, Function<BlockState, MapColor> mapColor)`
	private static PillarBlock createLog(MapColor topColor, MapColor sideColor) {
		return new PillarBlock(TerraformBlockSettings.copyOf(Blocks.OAK_LOG).strength(2.0F).sounds(BlockSoundGroup.WOOD));
	}

	public static boolean never(BlockState state, BlockView world, BlockPos pos) {
		return false;
	}

	public static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
		return type == EntityType.OCELOT || type == EntityType.PARROT;
	}
}
