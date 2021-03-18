package tyrannus.chocolate.setup;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedConstants;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tyrannus.chocolate.chocolate;
import tyrannus.chocolate.init.entities.EntityChocolateSlime;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, chocolate.MODID);

    //Attaches the deferred register to the event bus
    public static void init() {
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

  // public static RegistryObject<EntityType<EntityChocolateSlime>> CHOCOLATE_SLIME = ENTITIES.register("chocolate_slime",
          // () -> EntityType.Builder.create(EntityChocolateSlime::new, EntityClassification.MONSTER)
                //   .build("chocolate_slime"));

    public static final String CHOCOLATE_SLIME_NAME = "chocolate_slime";
    public static final RegistryObject<EntityType<EntityChocolateSlime>> CHOCOLATE_SLIME = ENTITIES.register(CHOCOLATE_SLIME_NAME, () ->
            EntityType.Builder.<EntityChocolateSlime>create(EntityChocolateSlime::new, EntityClassification.MONSTER)
                    .size(EntityType.SLIME.getWidth(), EntityType.SLIME.getHeight())
                    .build(new ResourceLocation(chocolate.MODID, CHOCOLATE_SLIME_NAME).toString())
    );



}