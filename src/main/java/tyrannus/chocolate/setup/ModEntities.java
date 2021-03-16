package tyrannus.chocolate.setup;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.MagmaCubeEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tyrannus.chocolate.chocolate;
import tyrannus.chocolate.init.chocolatefluids.MeltedDarkChocolate;
import tyrannus.chocolate.init.entities.EntityChocolateSlime;
import tyrannus.chocolate.init.entities.EntityNames;
import tyrannus.chocolate.init.special.ChocolateItemGroup;

import static net.minecraftforge.forgespi.Environment.build;

public class ModEntities{

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, chocolate.MODID);

    //Attaches the deferred register to the event bus
    public static void init() {
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }


    public static final EntityType<EntityChocolateSlime> CHOCOLATE_SLIME = make(EntityNames.CHOCOLATE_SLIME, EntityChocolateSlime::new,
            EntityClassification.MONSTER, 2.04F, 2.04F);



    @SuppressWarnings("unchecked")
    private static <E extends Entity> EntityType<E> build(ResourceLocation id, EntityType.Builder<E> builder) {
        boolean cache = SharedConstants.useDatafixers;
        SharedConstants.useDatafixers = false;
        EntityType<E> ret = (EntityType<E>) builder.build(id.toString()).setRegistryName(id);
        SharedConstants.useDatafixers = cache;
        return ret;
    }

    private static <E extends Entity> EntityType<E> make(ResourceLocation id, EntityType.IFactory<E> factory, EntityClassification classification, float width, float height) {
        return build(id, makeBuilder(factory, classification).size(width, height));
    }

    private static <E extends Entity> EntityType<E> make(ResourceLocation id, EntityType.IFactory<E> factory, EntityClassification classification) {
        return make(id, factory, classification, 0.6F, 1.8F);
    }

    private static <E extends Entity> EntityType.Builder<E> makeBuilder(EntityType.IFactory<E> factory, EntityClassification classification) {
        return EntityType.Builder.create(factory, classification).
                size(0.6F, 1.8F).
                setTrackingRange(80).
                setUpdateInterval(3).
                setShouldReceiveVelocityUpdates(true);
    }


}
