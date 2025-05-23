package net.chrysaor.starlightdelight.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder().nutrition(4).saturationModifier(0.4f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 400), 0.15f).build();
    public static final FoodComponent SWEET_BERRIES_PIE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.7f)
            .build();
    public static final FoodComponent CHEESE = new FoodComponent.Builder().nutrition(5).saturationModifier(0.9f)
            .build();
}