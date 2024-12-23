package net.chrysaor.chrysaormod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder().nutrition(4).saturationModifier(0.7f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 400), 0.15f).build();
}