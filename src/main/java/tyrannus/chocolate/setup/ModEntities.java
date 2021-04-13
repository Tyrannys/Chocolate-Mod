package tyrannus.chocolate.setup;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.graalvm.compiler.options.SuppressFBWarnings;
import tyrannus.chocolate.chocolate;
import tyrannus.chocolate.init.entities.EntityChocolateSlime;
import tyrannus.chocolate.init.special.ChocolateItemGroup;

import java.lang.reflect.Field;
import java.util.Map;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, chocolate.MODID);

    //Attaches the deferred register to the event bus
    public static void init() {
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<EntityType<EntityChocolateSlime>> CHOCOLATE_SLIME = ENTITIES.register("chocolate_slime",
            () -> EntityType.Builder.create(EntityChocolateSlime::new, EntityClassification.MONSTER)
                    .size(2.04F, 2.04F).trackingRange(10)
                    .build(new ResourceLocation(chocolate.MODID, "chocolate_slime").toString()));


    public static void registerEntityAttributes() {
        GlobalEntityTypeAttributes.put(ModEntities.CHOCOLATE_SLIME.get(), EntityChocolateSlime.getMutableAttributes().create());
    }
    public static void registerAdditionalEntityInformation() {
        registerEntityAttributes();
    }

}