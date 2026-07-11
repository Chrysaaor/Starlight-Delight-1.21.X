package net.chrysaor.starlightdelight.entity.client;

import net.chrysaor.starlightdelight.StarlightDelight;
import net.chrysaor.starlightdelight.entity.custom.ShrimpEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ShrimpEntityRenderer extends MobEntityRenderer<ShrimpEntity, ShrimpEntityModel<ShrimpEntity>> {

    public ShrimpEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ShrimpEntityModel<>(context.getPart(ShrimpEntityModel.SHRIMP)), 0.75f);
    }

    @Override
    protected float getShadowRadius(ShrimpEntity mobEntity) {
        return super.getShadowRadius(mobEntity) * 0.4f;
    }

    @Override
    public Identifier getTexture(ShrimpEntity entity) {
        return Identifier.of(StarlightDelight.MOD_ID, "textures/entity/shrimp/shrimp.png");
    }
}