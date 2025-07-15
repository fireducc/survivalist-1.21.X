package net.fire_ducc.survivalist.mixin;

import net.minecraft.entity.player.HungerManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HungerManager.class)
public abstract class HealthMixin {

    @Shadow private int foodLevel;

    int regenTick = 0;

    @Inject(at = @At("TAIL"), method = "update")
    private void passiveRegeneration(ServerPlayerEntity player, CallbackInfo ci) {
        // based on code by AwwShot https://github.com/AwwShoot/saturation-fixer-quilt
        if (player.getWorld().getServer().getGameRules().getBoolean(GameRules.NATURAL_REGENERATION) && player.getHealth() < player.getMaxHealth() && player.getHealth() > player.getMaxHealth() / 1.665) {
            regenTick++;
            if (regenTick > (this.foodLevel > 10 ? 100 : 200)) {
                regenTick = 0;
                player.heal(1);
            }
        }
        if (player.getWorld().getServer().getGameRules().getBoolean(GameRules.NATURAL_REGENERATION) && player.getHealth() < player.getMaxHealth() && player.getHealth() < player.getMaxHealth() / 2.0) {
            regenTick++;
            if (regenTick > (this.foodLevel > 10 ? 100 : 200)) {
                regenTick = 0;
                player.heal(1);
            }
        }
    }
}
