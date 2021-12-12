package tyrannus.chocolate.setup;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tyrannus.chocolate.Chocolate;


public class ModFluids {

    //Deferred register calls the block
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Chocolate.MODID);


    //Attaches the deferred register to the event bus
    public static void init() {
        FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }


    // public static final IForgeRegistry<Fluid> CHOCOLATE_FLUID = RegistryManager.ACTIVE.getRegistry(Fluid.class);

    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");


    public static final RegistryObject<FlowingFluid> MILKMELTEDCHOCOLATE =
            FLUIDS.register("milk_melted_chocolate", ()-> new ForgeFlowingFluid.Source(ModFluids.MILK_MELTED_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWINGMILKMELTEDCHOCOLATE =
            FLUIDS.register("milk_melted_flowing_chocolate", ()-> new ForgeFlowingFluid.Flowing(ModFluids.MILK_MELTED_PROPERTIES));

    public static final RegistryObject<FlowingFluid> MELTEDCHOCOLATE =
          FLUIDS.register("melted_chocolate", ()-> new ForgeFlowingFluid.Source(ModFluids.CHOCOLATE_MELTED_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWINGMELTEDCHOCOLATE =
            FLUIDS.register("melted_flowing_chocolate", ()-> new ForgeFlowingFluid.Flowing(ModFluids.CHOCOLATE_MELTED_PROPERTIES));

    public static final RegistryObject<FlowingFluid> MELTEDDARKCHOCOLATE =
            FLUIDS.register("melted_dark_chocolate", ()-> new ForgeFlowingFluid.Source(ModFluids.DARK_MELTED_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWINGDARKMELTEDCHOCOLATE =
            FLUIDS.register("melted_dark_flowing_chocolate", ()-> new ForgeFlowingFluid.Flowing(ModFluids.DARK_MELTED_PROPERTIES));

    public static final ForgeFlowingFluid.Properties MILK_MELTED_PROPERTIES = new ForgeFlowingFluid.Properties(
            ()-> MILKMELTEDCHOCOLATE.get(), ()-> FLOWINGMILKMELTEDCHOCOLATE.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .density(5).color(13529145).luminosity(2).viscosity(1).sound(SoundEvents.HONEY_BLOCK_STEP).overlay(WATER_OVERLAY_RL)).slopeFindDistance(4).levelDecreasePerBlock(3)
            .block(()-> ModBlocks.MILK_MELTED_CHOCOLATE.get()).bucket(()-> ModItems.MELTED_MILK_CHOCOLATE_BUCKET.get()
            );
    public static final ForgeFlowingFluid.Properties DARK_MELTED_PROPERTIES = new ForgeFlowingFluid.Properties(
            ()-> MELTEDDARKCHOCOLATE.get(), ()-> FLOWINGDARKMELTEDCHOCOLATE.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .density(5).color(4465939).luminosity(2).viscosity(1).sound(SoundEvents.HONEY_BLOCK_STEP).overlay(WATER_OVERLAY_RL)).slopeFindDistance(4).levelDecreasePerBlock(3)
            .block(()-> ModBlocks.MELTED_DARK_CHOCOLATE.get()).bucket(()-> ModItems.MELTED_DARK_CHOCOLATE_BUCKET.get()
            );
    public static final ForgeFlowingFluid.Properties CHOCOLATE_MELTED_PROPERTIES = new ForgeFlowingFluid.Properties(
            ()-> MELTEDCHOCOLATE.get(), ()-> FLOWINGMELTEDCHOCOLATE.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .density(5).color(9325863).luminosity(2).viscosity(1).sound(SoundEvents.HONEY_BLOCK_STEP).overlay(WATER_OVERLAY_RL)).slopeFindDistance(4).levelDecreasePerBlock(3)
            .block(()-> ModBlocks.MELTED_CHOCOLATE.get()).bucket(()-> ModItems.MELTED_CHOCOLATE_BUCKET.get()
            );
}


