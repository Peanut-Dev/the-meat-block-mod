package mrchumbucket.meatblock.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent RAW_MEAT_BLOCK = new FoodComponent.Builder().nutrition(10).saturationModifier(1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200), 1).build();
    public static final FoodComponent SPOILED_MEAT_BLOCK = new FoodComponent.Builder().nutrition(0).saturationModifier(0.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 200), 1).build();
    public static final FoodComponent COOKED_MEAT_BLOCK = new FoodComponent.Builder().nutrition(20).saturationModifier(15f).build();
}
