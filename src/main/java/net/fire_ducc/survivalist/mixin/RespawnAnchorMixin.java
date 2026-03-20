package net.fire_ducc.survivalist.mixin;

import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(RespawnAnchorBlock.class)
public abstract class RespawnAnchorMixin {
    @Inject(
            method = "isUsable",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void allowAllDimensions(ServerWorld world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
}