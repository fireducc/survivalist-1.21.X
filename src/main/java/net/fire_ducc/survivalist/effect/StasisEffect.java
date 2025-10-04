package net.fire_ducc.survivalist.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameMode;

import static net.minecraft.world.GameMode.ADVENTURE;

public class StasisEffect extends StatusEffect {
    public StasisEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }


    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof ServerPlayerEntity player) {
            player.changeGameMode(ADVENTURE);
        }
    }


    public boolean canApplyUpdateEffect(LivingEntity entity, int amplifier) {
        return true;
//        if (entity instanceof ServerPlayerEntity player) {
//            if (player.interactionManager.getGameMode() != ADVENTURE) {
//                return false;
//            }
//        }
//        return true;
    }
}
