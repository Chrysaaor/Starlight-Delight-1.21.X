package net.chrysaor.chrysaormod.mixin;

import net.chrysaor.chrysaormod.ChrysaorMod;
import net.chrysaor.chrysaormod.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useItem(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices,
                              VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(ModItems.HOELY_BEHEADER) && renderMode != ModelTransformationMode.GUI && renderMode != ModelTransformationMode.GROUND) {
            return ((ItemRendererAccessor) this).item$getModels().getModelManager().getModel(new ModelIdentifier(ChrysaorMod.identifier(), "item_3d"));
        }

        return value;
    }
}