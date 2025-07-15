package net.fire_ducc.survivalist.mixin;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class WakeUpMixin {
    @Inject(method = "wakeUp", at = @At("TAIL"))
    private void onWakeUp(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity)(Object)this;

        // only apply the effect if player is on server side
        if (!player.getWorld().isClient) {
            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.INSTANT_HEALTH,
                    1, 0));
        }
    }
}