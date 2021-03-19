package tyrannus.chocolate.setup;

import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tyrannus.chocolate.chocolate;
import tyrannus.chocolate.init.entities.EntityChocolateSlime;
import tyrannus.chocolate.init.special.ModSpawnEggItem;
import tyrannus.chocolate.init.world.customitem.ChocolateChipsItem;
import tyrannus.chocolate.init.special.ChocolateItemGroup;
import tyrannus.chocolate.init.special.ModMathHelper;

import java.util.function.Supplier;

import static tyrannus.chocolate.setup.ModBlocks.*;

public class ModItems{
    //Deferred register calls the item
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, chocolate.MODID);

    //Attaches the deferred register to the event bus
    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    //Registering Items

    //special Items (Have Subtext)
    public static RegistryObject<Item> CHOCOLATE_CHIPS = ITEMS.register("chocolate_chips", ChocolateChipsItem::new);

    //blockitems
    public static RegistryObject<BlockItem> CHOCOLATE_ORE_ITEM = ITEMS.register("chocolate_ore",()->
            new BlockItem(
                    CHOCOLATE_ORE.get(),
                    new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
            )
    );
    public static RegistryObject<BlockItem> CHOCOLATE_BLOCK_ITEM = ITEMS.register("chocolate_block",()->
            new BlockItem(
                    CHOCOLATE_BLOCK.get(),
                    new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
            )
    );
    public static RegistryObject<BlockItem> MILK_CHOCOLATE_BLOCK_ITEM = ITEMS.register("milk_chocolate_block",()->
            new BlockItem(
                    MILK_CHOCOLATE_BLOCK.get(),
                    new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
            )
    );
    public static RegistryObject<BlockItem> DARK_CHOCOLATE_BLOCK_ITEM = ITEMS.register("dark_chocolate_block",()->
            new BlockItem(
                    DARK_CHOCOLATE_BLOCK.get(),
                    new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
            )
    );
    public static RegistryObject<BlockItem> CHOCOLATE_DIRT_ITEM = ITEMS.register("chocolate_dirt",()->
            new BlockItem(
                    CHOCOLATE_DIRT.get(),
                    new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
            )
    );
    public static RegistryObject<BlockItem> CHOCOLATE_GRASS_ITEM = ITEMS.register("chocolate_grass",()->
            new BlockItem(
                    CHOCOLATE_GRASS.get(),
                    new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
            )
    );


    //actual items
    public static RegistryObject<Item> CHOCOLATE = register("chocolate",
            new Item(
                    new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP).food(ModFoods.CHOCOLATE)

            )
    );
    public static RegistryObject<Item> MILK_CHOCOLATE = register("milk_chocolate",
            new Item(
                    new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP).food(ModFoods.MILK_CHOCOLATE)
            )
    );
    public static RegistryObject<Item> CHOCOLATE_BALL = register("chocolate_ball",
            new Item(
                    new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP).food(ModFoods.CHOCOLATE_BALL)
            )
    );

    public static RegistryObject<Item> DARK_CHOCOLATE = register("dark_chocolate",
            new Item(
                    new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP).food(ModFoods.DARK_CHOCOLATE)
            )
    );



    //Door and Trapdoor items
    public static final RegistryObject<BlockItem> CHOCOLATE_DOOR = ITEMS.register("chocolate_door",()->
            new TallBlockItem(ModBlocks.CHOCOLATE_DOOR.get(),
                    new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));
    public static final RegistryObject<BlockItem> MILK_CHOCOLATE_DOOR = ITEMS.register("milk_chocolate_door",()->
            new TallBlockItem(ModBlocks.MILK_CHOCOLATE_DOOR.get(),
                    new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));
    public static final RegistryObject<BlockItem> DARK_CHOCOLATE_DOOR = ITEMS.register("dark_chocolate_door",()->
            new TallBlockItem(ModBlocks.DARK_CHOCOLATE_DOOR.get(),
                    new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));

    //Trapdoor items
    public static final RegistryObject<BlockItem> CHOCOLATE_TRAPDOOR = ITEMS.register("chocolate_trapdoor", ()->
            new BlockItem(ModBlocks.CHOCOLATE_TRAPDOOR.get(),
                    new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));
    public static final RegistryObject<BlockItem> MILK_CHOCOLATE_TRAPDOOR = ITEMS.register("milk_chocolate_trapdoor",()->
            new BlockItem(ModBlocks.MILK_CHOCOLATE_TRAPDOOR.get(),
                    new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));
    public static final RegistryObject<BlockItem> DARK_CHOCOLATE_TRAPDOOR = ITEMS.register("dark_chocolate_trapdoor",()->
            new BlockItem(ModBlocks.DARK_CHOCOLATE_TRAPDOOR.get(),
                    new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));

    //Bucket Items
    public static RegistryObject<Item> CHOCOLATE_BUCKET = register("chocolate_bucket",
            new Item( new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
                    .maxStackSize(1).containerItem(Items.BUCKET)
            )
    );
    public static RegistryObject<Item> MILK_CHOCOLATE_BUCKET = register("milk_chocolate_bucket",
            new Item( new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
                    .maxStackSize(1).containerItem(Items.BUCKET)
            )
    );
    public static RegistryObject<Item> DARK_CHOCOLATE_BUCKET = register("dark_chocolate_bucket",
            new Item( new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
                    .maxStackSize(1).containerItem(Items.BUCKET)
            )
    );
    //fluid container buckets
    public static final RegistryObject<BucketItem> MELTED_MILK_CHOCOLATE_BUCKET = register("melted_milk_chocolate_bucket", new BucketItem(ModFluids.MILKMELTEDCHOCOLATE, (new Item.Properties())
            .containerItem(Items.BUCKET).maxStackSize(1).group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));
    public static final RegistryObject<BucketItem> MELTED_CHOCOLATE_BUCKET = register("melted_chocolate_bucket", new BucketItem(ModFluids.MELTEDCHOCOLATE, (new Item.Properties())
            .containerItem(Items.BUCKET).maxStackSize(1).group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));
    public static final RegistryObject<BucketItem> MELTED_DARK_CHOCOLATE_BUCKET = register("melted_dark_chocolate_bucket", new BucketItem(ModFluids.MELTEDDARKCHOCOLATE, (new Item.Properties())
            .containerItem(Items.BUCKET).maxStackSize(1).group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));

    //SpawnEgg Items
    public static final RegistryObject<ModSpawnEggItem> CHOCOLATE_SPAWN_EGG = ITEMS.register("spawn_egg_chocolate_slime",
            () -> new ModSpawnEggItem(ModEntities.CHOCOLATE_SLIME::get, ModMathHelper.getColor(32, 42, 176),
                    ModMathHelper.getColor(115, 225, 249), new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));



    // public ModSpawnEggItem(Supplier<EntityType<?>> typeIn, int primaryColorIn, int secondaryColorIn,
    //                           Properties builder) {



    //register methods
    private static <T extends Item> RegistryObject<T> register(String id, T item)
    {
        return ModItems.ITEMS.register(id,() -> item);
    }
}