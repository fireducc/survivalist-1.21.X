package net.fire_ducc.survivalist.mixin;


import net.fire_ducc.survivalist.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.block.Block.pushEntitiesUpBeforeBlockChange;

@Mixin(FarmlandBlock.class)
public abstract class FarmlandNutrientMixin {

    @Unique
    int NutrientLevel = 1024;


    @Inject(at = @At("TAIL"), method = "randomTick")
    private void setToDDirt(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        BlockState blockAbove = world.getBlockState(pos.up());
            NutrientLevel -= 1;
            //Debug testing
//        if (world instanceof ServerWorld serverWorld){
//            ((ServerWorld)world).spawnParticles(
//                    ParticleTypes.HAPPY_VILLAGER,
//                    pos.getX() + 0.5,
//                    pos.getY() + 1.0,
//                    pos.getZ() + 0.5,
//                    5,
//                    0.2,
//                    0.2,
//                    0.2,
//                    0.1);
//        }
            if (this.NutrientLevel < 0) {
                BlockState blockState = pushEntitiesUpBeforeBlockChange(state, ModBlocks.DEPLETED_FARMLAND.getDefaultState(), world, pos);
                world.setBlockState(pos, blockState);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
            }
        }
    }
