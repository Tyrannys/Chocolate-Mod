package tyrannus.chocolate.setup;


import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tyrannus.chocolate.chocolate;
import tyrannus.chocolate.init.chocolatefluids.MeltedChocolate;
import tyrannus.chocolate.init.chocolatefluids.MeltedDarkChocolate;
import tyrannus.chocolate.init.chocolatefluids.MilkMeltedChocolate;


public class ModFluids {

    //Deferred register calls the block
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, chocolate.MODID);


    //Attaches the deferred register to the event bus
    public static void init() {
        FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }


    // public static final IForgeRegistry<Fluid> CHOCOLATE_FLUID = RegistryManager.ACTIVE.getRegistry(Fluid.class);

    public static final RegistryObject<FlowingFluid> MILKMELTEDCHOCOLATE =
            FLUIDS.register("milk_melted_chocolate", MilkMeltedChocolate.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWINGMILKMELTEDCHOCOLATE =
            FLUIDS.register("milk_melted_flowing_chocolate", MilkMeltedChocolate.Flowing::new);

    public static final RegistryObject<FlowingFluid> MELTEDCHOCOLATE =
          FLUIDS.register("melted_chocolate", MeltedChocolate.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWINGMELTEDCHOCOLATE =
            FLUIDS.register("melted_flowing_chocolate", MeltedChocolate.Flowing::new);

    public static final RegistryObject<FlowingFluid> MELTEDDARKCHOCOLATE =
            FLUIDS.register("melted_dark_chocolate", MeltedDarkChocolate.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWINGDARKMELTEDCHOCOLATE =
            FLUIDS.register("melted_dark_flowing_chocolate", MeltedDarkChocolate.Flowing::new);




}