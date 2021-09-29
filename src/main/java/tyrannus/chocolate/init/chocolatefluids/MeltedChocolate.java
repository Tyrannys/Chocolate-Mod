package tyrannus.chocolate.init.chocolatefluids;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import tyrannus.chocolate.chocolate;
import tyrannus.chocolate.setup.ModBlocks;
import tyrannus.chocolate.setup.ModFluids;
import tyrannus.chocolate.setup.ModItems;

import java.util.Random;
import java.util.function.Supplier;

public abstract class MeltedChocolate extends ForgeFlowingFluid {
    public MeltedChocolate() {
        super(new Properties(ModFluids.MELTEDCHOCOLATE, ModFluids.FLOWINGMELTEDCHOCOLATE, FluidAttributes.builder(
                new ResourceLocation(chocolate.MODID, "block/melted_chocolate_still"),
                new ResourceLocation(chocolate.MODID, "block/melted_chocolate_flow")).overlay(new ResourceLocation("block/water_overlay"))
                .sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY).density(100)
                .viscosity(30)).block((Supplier<? extends LiquidBlock>) ModBlocks.MELTED_CHOCOLATE));
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(Level worldIn, BlockPos pos, FluidState state, Random random) {
        if (!state.isSource() && !state.hasProperty(FALLING)) {
            if (random.nextInt(64) == 0) {
                worldIn.playLocalSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.WATER_AMBIENT, SoundSource.BLOCKS, random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F, false);
            }
        }
    }

    public BlockState getBlockState(FluidState state) {
        return ModBlocks.MELTED_CHOCOLATE.get().defaultBlockState().setValue(FlowingFluid.LEVEL, getLegacyLevel(state));
    }

    public int getSlopeFindDistance(LevelReader worldIn) {
        return 3;
    }

    public int getTickDelay(LevelReader p_205569_1_) {
        return 35;
    }

    protected float getExplosionResistance() {
        return 100.0F;
    }


    @Override
    public Item getBucket() {
        return ModItems.MELTED_CHOCOLATE_BUCKET.get();
    }

    public static class Source extends MeltedChocolate {
        @Override
        public boolean isSource(FluidState state) {
            return true;
        }

        @Override
        public int getAmount(FluidState state) {
            return 8;
        }
    }

    public static class Flowing extends MeltedChocolate {
        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState state) {
            return false;
        }
    }


}
