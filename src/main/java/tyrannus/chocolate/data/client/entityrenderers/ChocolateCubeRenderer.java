package tyrannus.chocolate.data.client.entityrenderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.MagmaCubeModel;
import net.minecraft.entity.monster.MagmaCubeEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tyrannus.chocolate.data.client.entitymodels.ChocolateCubeModel;
import tyrannus.chocolate.init.entities.EntityChocolateSlime;

@OnlyIn(Dist.CLIENT)
public class ChocolateCubeRenderer extends MobRenderer<EntityChocolateSlime, ChocolateCubeModel<EntityChocolateSlime>> {
    private static final ResourceLocation CHOCOLATE_CUBE_TEXTURES = new ResourceLocation("textures/entity/slime/chocolate_cube.png");

    public ChocolateCubeRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ChocolateCubeModel<>(), 0.25F);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityChocolateSlime entity) {
        return CHOCOLATE_CUBE_TEXTURES;
    }

    protected void preRenderCallback(EntityChocolateSlime entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        int i = entitylivingbaseIn.getSlimeSize();
        float f = MathHelper.lerp(partialTickTime, entitylivingbaseIn.prevSquishFactor, entitylivingbaseIn.squishFactor) / ((float)i * 0.5F + 1.0F);
        float f1 = 1.0F / (f + 1.0F);
        matrixStackIn.scale(f1 * (float)i, 1.0F / f1 * (float)i, f1 * (float)i);
    }
}
