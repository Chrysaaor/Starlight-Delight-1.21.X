package net.chrysaor.starlightdelight.entity.client;

import net.chrysaor.starlightdelight.StarlightDelight;
import net.chrysaor.starlightdelight.entity.custom.StarlightSwordProjectileEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class StarlightSwordProjectileModel extends EntityModel<StarlightSwordProjectileEntity> {
    public static final EntityModelLayer STARLIGHT_SWORD = new EntityModelLayer(Identifier.of(StarlightDelight.MOD_ID, "light_sword"), "main");
    private final ModelPart lightSword;

    public StarlightSwordProjectileModel(ModelPart root){
        this.lightSword = root.getChild("lightSword");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData lightSword = modelPartData.addChild("lightSword", ModelPartBuilder.create().uv(10, 4).cuboid(4.0F, -4.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(8, 12).cuboid(3.0F, -5.0F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(12, 14).cuboid(3.0F, -4.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(14, 0).cuboid(2.0F, -6.0F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 15).cuboid(2.0F, -5.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 5).cuboid(1.0F, -9.0F, -0.5F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(14, 7).cuboid(3.0F, -10.0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(14, 11).cuboid(4.0F, -10.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(6, 0).cuboid(-1.0F, -6.0F, -0.5F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(6, 2).cuboid(-2.0F, -5.0F, -0.5F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(14, 2).cuboid(-2.0F, -4.0F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-1.0F, -10.0F, -0.5F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(6, 4).cuboid(-2.0F, -12.0F, -0.5F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F))
                .uv(4, 16).cuboid(-1.0F, -11.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 9).cuboid(-3.0F, -13.0F, -0.5F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F))
                .uv(4, 10).cuboid(-4.0F, -14.0F, -0.5F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F))
                .uv(10, 7).cuboid(-5.0F, -14.0F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(8, 14).cuboid(-6.0F, -14.0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 8.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }



    @Override
    public void setAngles(StarlightSwordProjectileEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        lightSword.render(matrices, vertices, light, overlay, color);
    }
}
