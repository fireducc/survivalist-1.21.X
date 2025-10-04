package net.fire_ducc.survivalist.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fire_ducc.survivalist.block.DepletedFarmland;
import net.fire_ducc.survivalist.block.DepletedSoilBlock;
import net.fire_ducc.survivalist.block.RopeBlock;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final Block DEPLETED_DIRT = register("depleted_dirt", DepletedSoilBlock::new, Block.Settings.create().mapColor(MapColor.GRAY).strength(0.5f).sounds(BlockSoundGroup.GRAVEL));
    public static final Block DEPLETED_FARMLAND = register("depleted_farmland", DepletedFarmland::new, AbstractBlock.Settings.create().mapColor(MapColor.GRAY).strength(0.5f).sounds(BlockSoundGroup.GRAVEL));
    public static final Block TIN_ORE = register("tin_ore", Block::new, Block.Settings.create().mapColor(MapColor.GRAY).strength(3.0f, 3.0f).sounds(BlockSoundGroup.STONE).requiresTool());
    public static final Block DEEPSLATE_TIN_ORE = register("deepslate_tin_ore", Block::new, Block.Settings.create().mapColor(MapColor.GRAY).strength(4.5f, 4.5f).sounds(BlockSoundGroup.DEEPSLATE).requiresTool());
    public static final Block SANDSTONE_BRICKS = register("sandstone_bricks", Block::new, Block.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(2.5f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool());
    public static final Block RED_SANDSTONE_BRICKS = register("red_sandstone_bricks", Block::new, Block.Settings.create().mapColor(MapColor.ORANGE).strength(2.5f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool());
    public static final Block SMALL_STONE_BRICKS = register("small_stone_bricks", Block::new, Block.Settings.create().mapColor(MapColor.GRAY).strength(2.5f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool());
    public static final Block SMALL_STONE_BRICK_SLAB = register("small_stone_brick_slab", SlabBlock::new, AbstractBlock.Settings.copyShallow(SMALL_STONE_BRICKS));
    public static final Block SMALL_STONE_BRICK_STAIRS = register("small_stone_brick_stairs", settings -> new StairsBlock(SMALL_STONE_BRICKS.getDefaultState(), settings), AbstractBlock.Settings.copyShallow(SMALL_STONE_BRICKS));
    public static final Block SMALL_STONE_BRICK_WALL = register("small_stone_brick_wall", WallBlock::new, AbstractBlock.Settings.copyShallow(SMALL_STONE_BRICKS).solid());
    public static final Block MOSSY_SMALL_STONE_BRICKS = register("mossy_small_stone_bricks", Block::new, Block.Settings.create().mapColor(MapColor.GRAY).strength(2.5f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool());
    public static final Block CRACKED_SMALL_STONE_BRICKS = register("cracked_small_stone_bricks", Block::new, Block.Settings.create().mapColor(MapColor.GRAY).strength(2.5f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool());
    public static final Block TIN_BLOCK = register("tin_block", Block::new, Block.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL).requiresTool());

    public static final Block ROPE = register("rope", RopeBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.BROWN).strength(0.5f).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.WOOL));

    public static final Block BRONZE_BLOCK = register("bronze_block", Block::new, Block.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(3.0f, 6.0f).sounds(BlockSoundGroup.METAL).requiresTool());

    //public static final Block BRONZE_BLOCK = register(
    // "bronze_block", settings -> new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED, settings), AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).requiresTool().strength(3.0F, 6.0F).sounds(BlockSoundGroup.METAL));
    public static final Block EXPOSED_BRONZE = register(
            "exposed_bronze",
            settings -> new OxidizableBlock(Oxidizable.OxidationLevel.EXPOSED, settings),
            AbstractBlock.Settings.copy(BRONZE_BLOCK).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
    );
    public static final Block WEATHERED_BRONZE = register(
            "weathered_bronze",
            settings -> new OxidizableBlock(Oxidizable.OxidationLevel.WEATHERED, settings),
            AbstractBlock.Settings.copy(BRONZE_BLOCK).mapColor(MapColor.DARK_AQUA)
    );
    public static final Block TARNISHED_BRONZE = register(
            "tarnished_bronze",
            settings -> new OxidizableBlock(Oxidizable.OxidationLevel.OXIDIZED, settings),
            AbstractBlock.Settings.copy(BRONZE_BLOCK).mapColor(MapColor.TEAL)
    );


    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of("survivalist", path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }


    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Items.FARMLAND, DEPLETED_DIRT, DEPLETED_FARMLAND);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Items.DEEPSLATE_COPPER_ORE, TIN_ORE, DEEPSLATE_TIN_ORE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.CHISELED_STONE_BRICKS, SMALL_STONE_BRICKS, SMALL_STONE_BRICK_STAIRS, SMALL_STONE_BRICK_SLAB, SMALL_STONE_BRICK_WALL, CRACKED_SMALL_STONE_BRICKS, MOSSY_SMALL_STONE_BRICKS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.IRON_CHAIN, ROPE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.CUT_SANDSTONE_SLAB, SANDSTONE_BRICKS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.CUT_RED_SANDSTONE, RED_SANDSTONE_BRICKS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
            content.addAfter(Items.IRON_CHAIN, ROPE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
        content.addAfter(Items.COAL_BLOCK, TIN_BLOCK, BRONZE_BLOCK);
        });
    }
}