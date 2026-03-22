package net.fire_ducc.survivalist.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public class CopperPickBlockerMixin {

        @Inject(method = "isSuitableFor", at = @At("HEAD"), cancellable = true)
        private void modifyCopperPickaxe(BlockState state, CallbackInfoReturnable<Boolean> cir) {
            ItemStack stack = (ItemStack)(Object)this;

            if (stack.getItem() == Items.COPPER_PICKAXE) {
                if (state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.DEEPSLATE_IRON_ORE) || state.isOf(Blocks.IRON_BLOCK) || state.isOf(Blocks.RAW_IRON_BLOCK)) {
                    cir.setReturnValue(false);
                }
            }
        }
}
