package net.chrysaor.starlightdelight.effect;

import net.chrysaor.starlightdelight.StarlightDelight;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> LIGHT = registerStatusEffect("light",
            new LightEffect(StatusEffectCategory.BENEFICIAL, 11007966));

    public static final RegistryEntry<StatusEffect> BERSERKER = registerStatusEffect("berserker",
            new BerserkerEffect(StatusEffectCategory.NEUTRAL, 16711680)
                    .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                            Identifier.of(StarlightDelight.MOD_ID, "berserker_dmg"),
                            9.0F, EntityAttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH,
                            Identifier.of(StarlightDelight.MOD_ID, "berserker_health"),
                            -0.5f, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(EntityAttributes.PLAYER_SWEEPING_DAMAGE_RATIO,
                            Identifier.of(StarlightDelight.MOD_ID, "berserker_sweep"),
                            0.85f, EntityAttributeModifier.Operation.ADD_VALUE));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(StarlightDelight.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        StarlightDelight.LOGGER.info("Registering Mod Effects for " + StarlightDelight.MOD_ID);
    }
}
