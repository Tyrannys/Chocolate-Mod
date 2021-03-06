package tyrannus.chocolate.init.chocolatefluids;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.common.Mod;
import tyrannus.chocolate.chocolate;
import tyrannus.chocolate.setup.ModBlocks;
import tyrannus.chocolate.setup.ModFluids;
import tyrannus.chocolate.setup.ModItems;

import java.util.Random;

public abstract class MeltedChocolate extends ForgeFlowingFluid
{
    public MeltedChocolate()
    {
        super(new Properties(() -> ModFluids.MELTEDCHOCOLATE.get(), () ->
                ModFluids.FLOWINGMELTEDCHOCOLATE.get(), FluidAttributes.builder(
                        new ResourceLocation(chocolate.MODID, "block/melted_chocolate_still"),
                        new ResourceLocation(chocolate.MODID, "block/melted_chocolate_flow")).overlay(new ResourceLocation("block/water_overlay"))
                        .sound(SoundEvents.ITEM_BUCKET_FILL, SoundEvents.ITEM_BUCKET_EMPTY).density(100)
                        .viscosity(30)).block(() -> ModBlocks.MELTED_CHOCOLATE.get()));
    }
    @OnlyIn(Dist.CLIENT)
    public void animateTick(World worldIn, BlockPos pos, FluidState state, Random random) {
        if (!state.isSource() && !state.get(FALLING)) {
            if (random.nextInt(64) == 0) {
                worldIn.playSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F, false);
            }
        }
    }
    public BlockState getBlockState(FluidState state) {
        return ModBlocks.MELTED_CHOCOLATE.get().getDefaultState().with(FlowingFluidBlock.LEVEL, Integer.valueOf(getLevelFromState(state)));
    }

    public int getSlopeFindDistance(IWorldReader worldIn) {
        return 3;
    }
    public int getTickRate(IWorldReader p_205569_1_) {
        return 35;
    }
    protected float getExplosionResistance() {
        return 100.0F;
    }


    @Override
    public Item getFilledBucket()
    {
        return ModItems.MELTED_CHOCOLATE_BUCKET.get();
    }

    public static class Source extends MeltedChocolate
    {
        @Override
        public boolean isSource(FluidState state)
        {
            return true;
        }

        @Override
        public int getLevel(FluidState state)
        {
            return 8;
        }
    }

    public static class Flowing extends MeltedChocolate
    {
        @Override
        protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> builder)
        {
            super.fillStateContainer(builder);
            builder.add(LEVEL_1_8);
        }

        @Override
        public int getLevel(FluidState state)
        {
            return state.get(LEVEL_1_8);
        }

        @Override
        public boolean isSource(FluidState state)
        {
            return false;
        }
    }

}