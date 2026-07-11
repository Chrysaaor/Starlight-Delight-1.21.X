package net.chrysaor.starlightdelight.entity.client;

import net.chrysaor.starlightdelight.StarlightDelight;
import net.chrysaor.starlightdelight.entity.custom.ShrimpEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ShrimpEntityModel<T extends ShrimpEntity> extends SinglePartEntityModel<T> {
	public static final EntityModelLayer SHRIMP = new EntityModelLayer(Identifier.of(StarlightDelight.MOD_ID, "shrimp"), "main");
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart legRight;
	private final ModelPart frontLegRight;
	private final ModelPart legLeft;
	private final ModelPart frontLegLeft;
	private final ModelPart body1;
	private final ModelPart body2;

	public ShrimpEntityModel(ModelPart root) {
		this.root = root.getChild("root");
		this.head = this.root.getChild("head");
		this.legRight = this.head.getChild("legRight");
		this.frontLegRight = this.head.getChild("frontLegRight");
		this.legLeft = this.head.getChild("legLeft");
		this.frontLegLeft = this.head.getChild("frontLegLeft");
		this.body1 = this.root.getChild("body1");
		this.body2 = this.body1.getChild("body2");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData head = root.addChild("head", ModelPartBuilder.create().uv(8, 10).cuboid(1.0F, -5.0F, -8.0F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F))
				.uv(4, 12).cuboid(1.0F, -5.0F, -6.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 12).cuboid(-1.0F, -5.0F, -8.0F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F))
				.uv(12, 10).cuboid(-1.0F, -5.0F, -6.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-1.0F, -2.0F, -6.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 2.5F));

		ModelPartData legRight = head.addChild("legRight", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 0.0F, -2.5F));

		ModelPartData legRight_r1 = legRight.addChild("legRight_r1", ModelPartBuilder.create().uv(16, 2).cuboid(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		ModelPartData frontLegRight = head.addChild("frontLegRight", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 0.0F, -4.5F));

		ModelPartData frontLegRight_r1 = frontLegRight.addChild("frontLegRight_r1", ModelPartBuilder.create().uv(16, 0).cuboid(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		ModelPartData legLeft = head.addChild("legLeft", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 0.0F, -2.5F));

		ModelPartData legLeft_r1 = legLeft.addChild("legLeft_r1", ModelPartBuilder.create().uv(4, 16).cuboid(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		ModelPartData frontLegLeft = head.addChild("frontLegLeft", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 0.0F, -4.5F));

		ModelPartData frontLegLeft_r1 = frontLegLeft.addChild("frontLegLeft_r1", ModelPartBuilder.create().uv(16, 4).cuboid(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		ModelPartData body1 = root.addChild("body1", ModelPartBuilder.create().uv(0, 8).cuboid(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 2.5F, 3.1416F, 0.0F, 0.0F));

		ModelPartData body2 = body1.addChild("body2", ModelPartBuilder.create().uv(12, 14).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(8, 8).cuboid(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.0F, -2.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(ShrimpEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		if (entity.isInsideWaterOrBubbleColumn()) {
			this.animateMovement(ShrimpEntityAnimations.ANIM_SHRIMP_SWIM, limbSwing, limbSwingAmount, 5f, 7.5f);
		} else if (!entity.isInsideWaterOrBubbleColumn()) {
			this.animateMovement(ShrimpEntityAnimations.ANIM_SHRIMP_WALK, limbSwing, limbSwingAmount, 5f, 7.5f);
		}
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
		root.render(matrices, vertices, light, overlay, color);
	}

	@Override
	public ModelPart getPart() {
		return root;
	}
}