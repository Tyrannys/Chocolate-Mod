package tyrannus.chocolate.setup;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
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

    public static final RegistryObject<EntityType<EntityChocolateSlime>> CHOCOLATE_SLIME = ENTITIES.register("chocolate_slime",
            () -> EntityType.Builder.<EntityChocolateSlime>of(EntityChocolateSlime::new, MobCategory.MISC)
                    .sized(2.04F, 2.04F).setTrackingRange(10)
                    .build(new ResourceLocation(chocolate.MODID, "chocolate_slime").toString()));

    /*public static void registerEntityAttributes() {
        (ModEntities.CHOCOLATE_SLIME.get(), EntityChocolateSlime.getMutableAttributes());
    }
    public static void registerAdditionalEntityInformation() {
        registerEntityAttributes();
    }*/

}