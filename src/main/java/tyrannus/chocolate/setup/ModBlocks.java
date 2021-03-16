package tyrannus.chocolate.setup;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tyrannus.chocolate.chocolate;
import tyrannus.chocolate.init.special.ChocolateItemGroup;

import javax.annotation.Nullable;
import java.util.function.Function;

public class ModBlocks {

    //Deferred register calls the block
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, chocolate.MODID);

    //Attaches the deferred register to the event bus
        public static void init()
        {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }

        //Normal Blocks
    public static final RegistryObject<Block> CHOCOLATE_ORE = BLOCKS.register("chocolate_ore", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)
            .sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE))
        );
    public static final RegistryObject<Block> CHOCOLATE_BLOCK = BLOCKS.register("chocolate_block", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.HONEY).harvestLevel(1).harvestTool(ToolType.PICKAXE))
    );
    public static final RegistryObject<Block> MILK_CHOCOLATE_BLOCK = BLOCKS.register("milk_chocolate_block", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.HONEY).harvestLevel(1).harvestTool(ToolType.PICKAXE))
    );
    public static final RegistryObject<Block> DARK_CHOCOLATE_BLOCK = BLOCKS.register("dark_chocolate_block", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.HONEY).harvestLevel(1).harvestTool(ToolType.PICKAXE))
    );

    public static final RegistryObject<Block> CHOCOLATE_DIRT = BLOCKS.register("chocolate_dirt", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(1.0F, 1.0F)
                    .sound(SoundType.GROUND).harvestLevel(1).harvestTool(ToolType.SHOVEL))
    );
    public static final RegistryObject<Block> CHOCOLATE_GRASS = BLOCKS.register("chocolate_grass", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(1.0F, 1.5F)
                    .sound(SoundType.GROUND).harvestLevel(1).harvestTool(ToolType.SHOVEL))
    );


    //Door Blocks and TrapDoor Blocks
    public static final RegistryObject<DoorBlock> CHOCOLATE_DOOR = BLOCKS.register("chocolate_door", ()->
            new DoorBlock(AbstractBlock.Properties.from(Blocks.OAK_DOOR)));
    public static final RegistryObject<DoorBlock> MILK_CHOCOLATE_DOOR = BLOCKS.register("milk_chocolate_door", ()->
            new DoorBlock(AbstractBlock.Properties.from(Blocks.OAK_DOOR)));
    public static final RegistryObject<DoorBlock> DARK_CHOCOLATE_DOOR = BLOCKS.register("dark_chocolate_door", ()->
            new DoorBlock(AbstractBlock.Properties.from(Blocks.OAK_DOOR)));

    //TrapDoors
    public static final RegistryObject<TrapDoorBlock> CHOCOLATE_TRAPDOOR = BLOCKS.register("chocolate_trapdoor", ()->
            new TrapDoorBlock(AbstractBlock.Properties.from(Blocks.OAK_TRAPDOOR)));
    public static final RegistryObject<TrapDoorBlock> MILK_CHOCOLATE_TRAPDOOR = BLOCKS.register("milk_chocolate_trapdoor", ()->
            new TrapDoorBlock(AbstractBlock.Properties.from(Blocks.OAK_TRAPDOOR)));
    public static final RegistryObject<TrapDoorBlock> DARK_CHOCOLATE_TRAPDOOR = BLOCKS.register("dark_chocolate_trapdoor", ()->
            new TrapDoorBlock(AbstractBlock.Properties.from(Blocks.OAK_TRAPDOOR)));



    //Fluid Blocks

    public static final RegistryObject<FlowingFluidBlock> MILK_MELTED_CHOCOLATE = register("melted_milk_chocolate",
            new FlowingFluidBlock(ModFluids.FLOWINGMILKMELTEDCHOCOLATE, Block.Properties.create(Material.WATER)
                    .doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
    public static final RegistryObject<FlowingFluidBlock> MELTED_CHOCOLATE = register("melted_chocolate",
            new FlowingFluidBlock(ModFluids.FLOWINGMELTEDCHOCOLATE, Block.Properties.create(Material.WATER)
                    .doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
    public static final RegistryObject<FlowingFluidBlock> MELTED_DARK_CHOCOLATE = register("melted_dark_chocolate",
            new FlowingFluidBlock(ModFluids.FLOWINGDARKMELTEDCHOCOLATE, Block.Properties.create(Material.WATER)
                    .doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));


    private static <T extends Block> RegistryObject<T> register(String id, T block)
    {
        return register(id, block, block1 -> new BlockItem(block1, new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)));
    }

    private static <T extends FlowingFluidBlock> RegistryObject<FlowingFluidBlock> register(String id, T block)
    {
        return register(id, block, block1 -> new BlockItem(block1, new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> register(String id, T block, @Nullable Function<T, BlockItem> supplier)
    {
        if(supplier != null)
        {
            ModItems.ITEMS.register(id, () -> supplier.apply(block));
        }
        return ModBlocks.BLOCKS.register(id, () -> block);
    }
}
