package net.fire_ducc.survivalist.block;

import com.mojang.serialization.MapCodec;
import net.fire_ducc.survivalist.registry.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;

import java.util.function.Function;

import static net.minecraft.block.PropaguleBlock.HANGING;

public class RopeBlock extends Block implements Waterloggable {
    public static final MapCodec<RopeBlock> CODEC = createCodec(RopeBlock::new);
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    @Override
    public MapCodec<RopeBlock> getCodec() {
        return CODEC;
    }

    public RopeBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(WATERLOGGED, false));
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);

        // Make sure the player is holding a rope block
        if (!itemStack.isOf(Item.fromBlock(ModBlocks.ROPE))) {
            return ActionResult.PASS;
        }

        BlockPos.Mutable searchPos = new BlockPos.Mutable(pos.getX(), pos.getY() - 1, pos.getZ()); // ✅ Valid


        // Search downward until we hit a non-rope, non-replaceable block
        while (world.getBlockState(searchPos).isOf(ModBlocks.ROPE)) {
            searchPos.move(Direction.DOWN);
        }

        // Now search for the first replaceable block
        BlockState targetState = world.getBlockState(searchPos);
        if (targetState.canReplace(new ItemPlacementContext(player, hand, itemStack, hit))) {
            world.playSound(null, searchPos, SoundEvents.BLOCK_WOOL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.setBlockState(searchPos, ModBlocks.ROPE.getDefaultState());

            if (!player.getAbilities().creativeMode) {
                stack.decrement(1);
            }

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).isOf(Fluids.WATER));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state,
            WorldView world,
            ScheduledTickView tickView,
            BlockPos pos,
            Direction direction,
            BlockPos neighborPos,
            BlockState neighborState,
            Random random
    ) {
        return direction == Direction.UP && !this.canPlaceAt(state, world, pos)
                ? Blocks.AIR.getDefaultState()
                : super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.up();
        return Block.sideCoversSmallSquare(world, pos.offset(Direction.UP), Direction.UP);
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.4f, 0f, 0.4f, 0.6f, 1f, 0.6f);
    }
}
