package tyrannus.chocolate.setup;

import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tyrannus.chocolate.Chocolate;
import tyrannus.chocolate.init.world.biomes.ChocolateForest;

public class ModBiomes {
    //Deferred register calls the block
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Chocolate.MODID);

    //Attaches the deferred register to the event bus
    public static void init() { BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus()); }

  //  public static final RegistryObject<Biome> CHOCOLATE_FOREST = BIOMES.makeRegistry("chocolate_forest", ChocolateForest::new);
}
