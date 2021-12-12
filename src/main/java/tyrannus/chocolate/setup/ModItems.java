package tyrannus.chocolate.setup;

import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tyrannus.chocolate.Chocolate;
import tyrannus.chocolate.init.special.ChocolateItemGroup;


public class ModItems {
    //Deferred register calls the item
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Chocolate.MODID);

    //Attaches the deferred register to the event bus
    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    //Registering Items

    //special Items (Have Subtext) // nothing yet, but I may use it // placeholder code so I remember how to register it
    // public static RegistryObject<Item> CHOCOLATE_CHIPS = ITEMS.register("chocolate_chips", ChocolateChipsItem::new);

    //blockitems
    public static RegistryObject<BlockItem> CHOCOLATE_ORE_ITEM = ITEMS.register("chocolate_ore", () ->
            new BlockItem(
                    ModBlocks.CHOCOLATE_ORE.get(),
                    new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
            )
    );
    public static RegistryObject<BlockItem> CHOCOLATE_BLOCK_ITEM = ITEMS.register("chocolate_block", () ->
            new BlockItem(
                    ModBlocks.CHOCOLATE_BLOCK.get(),
                    new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
            )
    );
    public static RegistryObject<BlockItem> MILK_CHOCOLATE_BLOCK_ITEM = ITEMS.register("milk_chocolate_block", () ->
            new BlockItem(
                    ModBlocks.MILK_CHOCOLATE_BLOCK.get(),
                    new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
            )
    );
    public static RegistryObject<BlockItem> DARK_CHOCOLATE_BLOCK_ITEM = ITEMS.register("dark_chocolate_block", () ->
            new BlockItem(
                    ModBlocks.DARK_CHOCOLATE_BLOCK.get(),
                    new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
            )
    );
    public static RegistryObject<BlockItem> CHOCOLATE_DIRT_ITEM = ITEMS.register("chocolate_dirt", () ->
            new BlockItem(
                    ModBlocks.CHOCOLATE_DIRT.get(),
                    new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
            )
    );
    public static RegistryObject<BlockItem> CHOCOLATE_GRASS_ITEM = ITEMS.register("chocolate_grass", () ->
            new BlockItem(
                    ModBlocks.CHOCOLATE_GRASS.get(),
                    new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
            )
    );


    //actual items
    public static RegistryObject<Item> CHOCOLATE_CHIPS = ITEMS.register("chocolate_chips", () ->
            new Item(
                    new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP).food(ModFoods.CHOCOLATE_CHIPS)
            )
    );


    public static RegistryObject<Item> CHOCOLATE = ITEMS.register("chocolate", () ->
            new Item(
                    new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP).food(ModFoods.CHOCOLATE)

            )
    );
    public static RegistryObject<Item> MILK_CHOCOLATE = ITEMS.register("milk_chocolate", () ->
            new Item(
                    new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP).food(ModFoods.MILK_CHOCOLATE)
            )
    );
    public static RegistryObject<Item> CHOCOLATE_BALL = ITEMS.register("chocolate_ball", () ->
            new Item(
                    new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP).food(ModFoods.CHOCOLATE_BALL)
            )
    );

    public static RegistryObject<Item> DARK_CHOCOLATE = ITEMS.register("dark_chocolate", () ->
            new Item(
                    new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP).food(ModFoods.DARK_CHOCOLATE)
            )
    );


    //Door and Trapdoor items
    public static final RegistryObject<BlockItem> CHOCOLATE_DOOR = ITEMS.register("chocolate_door", () ->
            new DoubleHighBlockItem(ModBlocks.CHOCOLATE_DOOR.get(),
                    new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));
    public static final RegistryObject<BlockItem> MILK_CHOCOLATE_DOOR = ITEMS.register("milk_chocolate_door", () ->
            new DoubleHighBlockItem(ModBlocks.MILK_CHOCOLATE_DOOR.get(),
                    new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));
    public static final RegistryObject<BlockItem> DARK_CHOCOLATE_DOOR = ITEMS.register("dark_chocolate_door", () ->
            new DoubleHighBlockItem(ModBlocks.DARK_CHOCOLATE_DOOR.get(),
                    new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));

    //Trapdoor items
    public static final RegistryObject<BlockItem> CHOCOLATE_TRAPDOOR = ITEMS.register("chocolate_trapdoor", () ->
            new BlockItem(ModBlocks.CHOCOLATE_TRAPDOOR.get(),
                    new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));
    public static final RegistryObject<BlockItem> MILK_CHOCOLATE_TRAPDOOR = ITEMS.register("milk_chocolate_trapdoor", () ->
            new BlockItem(ModBlocks.MILK_CHOCOLATE_TRAPDOOR.get(),
                    new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));
    public static final RegistryObject<BlockItem> DARK_CHOCOLATE_TRAPDOOR = ITEMS.register("dark_chocolate_trapdoor", () ->
            new BlockItem(ModBlocks.DARK_CHOCOLATE_TRAPDOOR.get(),
                    new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));

    //Bucket Items
    public static RegistryObject<Item> CHOCOLATE_BUCKET = ITEMS.register("chocolate_bucket", () ->
            new Item(new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
                    .stacksTo(1).craftRemainder(Items.BUCKET)
            )
    );
    public static RegistryObject<Item> MILK_CHOCOLATE_BUCKET = ITEMS.register("milk_chocolate_bucket", () ->
            new Item(new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
                    .stacksTo(1).craftRemainder(Items.BUCKET)
            )
    );
    public static RegistryObject<Item> DARK_CHOCOLATE_BUCKET = ITEMS.register("dark_chocolate_bucket", () ->
            new Item(new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
                    .stacksTo(1).craftRemainder(Items.BUCKET)
            )
    );
    //fluid container buckets
    public static final RegistryObject<BucketItem> MELTED_MILK_CHOCOLATE_BUCKET = ITEMS.register("melted_milk_chocolate_bucket", () ->
            new BucketItem(()-> ModFluids.MILKMELTEDCHOCOLATE.get(), (new Item.Properties())
            .craftRemainder(Items.BUCKET).stacksTo(1).tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));
    public static final RegistryObject<BucketItem> MELTED_CHOCOLATE_BUCKET = ITEMS.register("melted_chocolate_bucket", () ->
            new BucketItem(()->ModFluids.MELTEDCHOCOLATE.get(), (new Item.Properties())
            .craftRemainder(Items.BUCKET).stacksTo(1).tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));
    public static final RegistryObject<BucketItem> MELTED_DARK_CHOCOLATE_BUCKET = ITEMS.register("melted_dark_chocolate_bucket", () ->
            new BucketItem(()->ModFluids.MELTEDDARKCHOCOLATE.get(), (new Item.Properties())
            .craftRemainder(Items.BUCKET).stacksTo(1).tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));

    //SpawnEgg Items
    //public static final RegistryObject<SpawnEggItem> CHOCOLATE_SPAWN_EGG = ITEMS.register("spawn_egg_chocolate_slime",
    //        () -> new ForgeSpawnEggItem(ModEntities.CHOCOLATE_SLIME, 11141120, 8077056, new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));
}