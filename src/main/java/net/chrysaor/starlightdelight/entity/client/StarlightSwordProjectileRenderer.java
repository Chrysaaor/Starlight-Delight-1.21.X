package net.chrysaor.starlightdelight.entity.client;

import net.chrysaor.starlightdelight.StarlightDelight;
import net.chrysaor.starlightdelight.entity.custom.StarlightSwordProjectileEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

public class StarlightSwordProjectileRenderer extends EntityRenderer<StarlightSwordProjectileEntity> {
    protected StarlightSwordProjectileModel model;

    public StarlightSwordProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new StarlightSwordProjectileModel(ctx.getPart(StarlightSwordProjectileModel.STARLIGHT_SWORD));
    }

    @Override
    public void render(StarlightSwordProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        matrices.translate((double)0.0F, 0.5, (double)0.0F);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-entity.prevYaw + 90.0F));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(entity.prevPitch));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(entity.age * 5.0F));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-45.0F));

        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers,
                this.model.getLayer(Identifier.of(StarlightDelight.MOD_ID, "textures/entity/light_sword/light_sword.png")), false, false);
        this.model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV);

        matrices.pop();

        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }


    @Override
    public Identifier getTexture(StarlightSwordProjectileEntity entity) {
        return Identifier.of(StarlightDelight.MOD_ID, "textures/entity/light_sword/light_sword.png");
    }
}