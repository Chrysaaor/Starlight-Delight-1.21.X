package net.chrysaor.chrysaormod.util;

import net.chrysaor.chrysaormod.ChrysaorMod;
import net.chrysaor.chrysaormod.component.ModDataComponentTypes;
import net.chrysaor.chrysaormod.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.CHISEL, Identifier.of(ChrysaorMod.MOD_ID, "used"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null ? 1f : 0f);
    }
}
