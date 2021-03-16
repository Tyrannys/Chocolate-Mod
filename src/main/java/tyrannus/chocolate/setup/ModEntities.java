package tyrannus.chocolate.setup;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedConstants;
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

   public static RegistryObject<EntityType<EntityChocolateSlime>> CHOCOLATE_SLIME = ENTITIES.register("chocolate_slime",
           () -> EntityType.Builder.<EntityChocolateSlime>create(EntityChocolateSlime::new, EntityClassification.MONSTER)
                   .build(new ResourceLocation(chocolate.MODID, "chocolate_slime").toString()));


    // public static final EntityType<CatEntity> CAT =
    // register("cat", EntityType.Builder.<CatEntity>create(CatEntity::new,
    // EntityClassification.CREATURE).size(0.6F, 0.7F).trackingRange(8));

}