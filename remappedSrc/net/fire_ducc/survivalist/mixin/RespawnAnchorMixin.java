package net.fire_ducc.survivalist.mixin;

import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;


@Mixin(RespawnAnchorBlock.class)
public abstract class RespawnAnchorMixin {
    //credit to CoreBytee https://github.com/CoreBytee/overworld-anchors
    @Overwrite
    public static boolean isNether(World world) {
        return true;
    }
}
