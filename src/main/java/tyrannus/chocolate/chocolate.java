package tyrannus.chocolate;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tyrannus.chocolate.data.client.entity.render.ChocolateSlimeRenderer;
import tyrannus.chocolate.init.world.FluidGeneration;
import tyrannus.chocolate.init.world.OreGeneration;
import tyrannus.chocolate.setup.ModBlocks;
import tyrannus.chocolate.setup.ModEntities;
import tyrannus.chocolate.setup.ModFluids;
import tyrannus.chocolate.setup.ModItems;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(chocolate.MODID)
public class chocolate {


    // Directly reference a log4j logger.
    LogManager logManager;
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "chocolate";

    public chocolate() {

        ModFluids.init();
        ModBlocks.init();
        ModEntities.init();
        ModItems.init();
       // MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);
       // MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, FluidGeneration::generateFluids);
        System.out.println("Registered RenderTNTLargePrimed from preint function");


        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);


    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("The Pre-Choco-inator");
        LOGGER.info("DIRT BLOCK >> {}", Tags.Blocks.DIRT.isDefaulted());
        event.enqueueWork(() -> {
          //  registerAdditionalEntityInformation();

        });

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        /*LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
        RenderTypeLookup(ModBlocks.MILK_CHOCOLATE_DOOR.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.MILK_CHOCOLATE_TRAPDOOR.get(), RenderType.cutout());
        
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.CHOCOLATE_SLIME.get(), ChocolateSlimeRenderer::new);
        */
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("chocolate", "helloworld", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }
    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {

        DataGenerator gen = event.getGenerator();
    }
    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m -> m.messageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from the server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");

        }

    }

}
