package net.fire_ducc.survivalist.registry;

import net.fire_ducc.survivalist.effect.StasisEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import static net.fire_ducc.survivalist.Survivalist.MOD_ID;

public class ModEffects {
    public static RegistryEntry<StatusEffect> STASIS;

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MOD_ID, name), effect);
    }

    public static void register() {
        STASIS = registerStatusEffect(
                "stasis",
                new StasisEffect(StatusEffectCategory.NEUTRAL, 0xffffff)
        );
    }
}
