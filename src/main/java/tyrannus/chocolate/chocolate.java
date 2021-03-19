package tyrannus.chocolate;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "chocolate";
    public static IItemProvider CHOCOLATE_CHIPS;
    public static IItemProvider CHOCOLATE;

    public chocolate() {

        ModFluids.init();
        ModBlocks.init();
        ModEntities.init();
        ModItems.init();
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, FluidGeneration::generateFluids);

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
    //    MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);



    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("The Pre-Chocoinator");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
        RenderTypeLookup.setRenderLayer(ModBlocks.MILK_CHOCOLATE_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.MILK_CHOCOLATE_TRAPDOOR.get(), RenderType.getCutout());
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
                map(m -> m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
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
