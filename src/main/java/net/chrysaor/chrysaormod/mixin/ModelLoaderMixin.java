package net.chrysaor.chrysaormod.mixin;

import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import static net.chrysaor.chrysaormod.ChrysaorMod.MOD_ID;

@Mixin(ModelLoader.class)
public abstract class ModelLoaderMixin {
    @Shadow
    protected abstract void loadItemModel(ModelIdentifier id);
    @Inject(
            method = {"<init>"},
            at = {@At(
                    value = "INVOKE",
                    ordinal = 0,
                    target = "Lnet/minecraft/client/render/model/ModelLoader;loadItemModel(Lnet/minecraft/client/util/ModelIdentifier;)V"
            )}
    )
    private void addHoelyBeheader(CallbackInfo info) {
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(MOD_ID, "hoely_beheader_in_hand")));
    }
}