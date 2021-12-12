package tyrannus.chocolate.data.client.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SlimeOuterLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tyrannus.chocolate.Chocolate;
import tyrannus.chocolate.init.entities.EntityChocolateSlime;

@OnlyIn(Dist.CLIENT)
public class ChocolateSlimeRenderer extends MobRenderer<EntityChocolateSlime, SlimeModel<EntityChocolateSlime>>{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Chocolate.MODID, "textures/entity/chocolate_slime.png");

    public ChocolateSlimeRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new SlimeModel<>(renderManagerIn.bakeLayer(ModelLayers.SLIME)), 0.25F);
        this.addLayer(new SlimeOuterLayer<>(this, renderManagerIn.getModelSet()));
    }


    @Override
    public void render(EntityChocolateSlime entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        this.shadowRadius = 0.25F * (float) entityIn.getSlimeSize();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityChocolateSlime entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(EntityChocolateSlime entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        float f = 0.999F;
        matrixStackIn.scale(0.999F, 0.999F, 0.999F);
        matrixStackIn.translate(0.0D, (double) 0.001F, 0.0D);
        float f1 = (float) entitylivingbaseIn.getSlimeSize();
        float f2 = Mth.lerp(partialTickTime, entitylivingbaseIn.prevSquishFactor, entitylivingbaseIn.squishFactor) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        matrixStackIn.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }
}