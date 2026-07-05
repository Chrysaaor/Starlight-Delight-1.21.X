package net.chrysaor.starlightdelight.item;

import net.chrysaor.starlightdelight.effect.ModEffects;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder().nutrition(4).saturationModifier(0.4f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 400), 0.15f)
            .build();

    public static final FoodComponent SWEET_BERRIES_PIE = new FoodComponent.Builder().nutrition(7).saturationModifier(0.9f)
            .build();

    public static final FoodComponent CHEESE = new FoodComponent.Builder().nutrition(5).saturationModifier(0.8f)
            .build();

    public static final FoodComponent RAW_RACLETTE = new FoodComponent.Builder().nutrition(5).saturationModifier(0.8f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300), 0.85f)
            .build();

    public static final FoodComponent RACLETTE = new FoodComponent.Builder().nutrition(10).saturationModifier(1.4f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 600, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 2, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(ModEffects.SATIATED, 6000), 1.0f)
            .build();

    public static final FoodComponent QUICHE = new FoodComponent.Builder().nutrition(7).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(ModEffects.SATIATED, 6000), 1.0f)
            .build();

    public static final FoodComponent GRAPES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.25f)
            .snack().build();

    public static final FoodComponent RED_WINE = new FoodComponent.Builder().nutrition(0).saturationModifier(0.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), 0.25f).alwaysEdible().build();

    public static final FoodComponent ENERGY_BEVERAGE = new FoodComponent.Builder().nutrition(0).saturationModifier(0.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1200, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100), 0.2f).alwaysEdible().build();

    public static final FoodComponent KOUIGN_AMANN = new FoodComponent.Builder().nutrition(8).saturationModifier(2.2F)
            .statusEffect(new StatusEffectInstance(ModEffects.SATIATED, 3600), 1.0f)
            .build();

    public static final FoodComponent CINNAMON_ROLL = new FoodComponent.Builder().nutrition(6).saturationModifier(1.2f)
            .build();

    public static final FoodComponent APPLE_CRUMBLE = new FoodComponent.Builder().nutrition(6).saturationModifier(0.9f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 60), 1.0f).build();

    public static final FoodComponent CARROT_CAKE = new FoodComponent.Builder().nutrition(7).saturationModifier(0.9f)
            .statusEffect(new StatusEffectInstance(ModEffects.SATIATED, 1200), 1.0f)
            .build();

    public static final FoodComponent POTATO_FRIES = new FoodComponent.Builder().nutrition(5).saturationModifier(0.4f)
            .snack().build();

    public static final FoodComponent GOLDEN_POTATO_FRIES = new FoodComponent.Builder().nutrition(5).saturationModifier(0.6f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 4800, 2), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 4800, 0), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 2400), 1.0f)
            .snack().alwaysEdible().build();

    public static final FoodComponent HASHBROWNS = new FoodComponent.Builder().nutrition(6).saturationModifier(0.7f)
            .build();

    public static final FoodComponent FRIED_CHICKEN = new FoodComponent.Builder().nutrition(6).saturationModifier(0.6f)
            .snack().build();
}