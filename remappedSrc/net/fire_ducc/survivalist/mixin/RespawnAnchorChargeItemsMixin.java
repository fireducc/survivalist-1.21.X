package net.fire_ducc.survivalist.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(RespawnAnchorBlock.class)
public class RespawnAnchorChargeItemsMixin {
    @ModifyReturnValue(method = "isChargeItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"), remap = false)
    private static boolean isChargeItem(ItemStack stack){
        return stack.isOf(Items.REDSTONE_BLOCK);
    }
}
