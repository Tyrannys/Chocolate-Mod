package tyrannus.chocolate.setup;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tyrannus.chocolate.chocolate;

import javax.annotation.Nullable;
import java.util.function.Function;

public class ModBlocks {

    //Deferred register calls the block
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, chocolate.MODID);

    //Attaches the deferred register to the event bus
        public static void init() { BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus()); }

        //Normal Blocks
    public static final RegistryObject<Block> CHOCOLATE_ORE = BLOCKS.register("chocolate_ore", () ->
            new Block(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F)
            .sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE))
        );
    public static final RegistryObject<Block> CHOCOLATE_BLOCK = BLOCKS.register("chocolate_block", () ->
            new Block(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F)
                    .sound(SoundType.HONEY_BLOCK).harvestLevel(1).harvestTool(ToolType.PICKAXE))
    );
    public static final RegistryObject<Block> MILK_CHOCOLATE_BLOCK = BLOCKS.register("milk_chocolate_block", () ->
            new Block(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F)
                    .sound(SoundType.HONEY_BLOCK).harvestLevel(1).harvestTool(ToolType.PICKAXE))
    );
    public static final RegistryObject<Block> DARK_CHOCOLATE_BLOCK = BLOCKS.register("dark_chocolate_block", () ->
            new Block(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F)
                    .sound(SoundType.HONEY_BLOCK).harvestLevel(1).harvestTool(ToolType.PICKAXE))
    );

    public static final RegistryObject<Block> CHOCOLATE_DIRT = BLOCKS.register("chocolate_dirt", () ->
            new Block(Block.Properties.of(Material.DIRT).strength(1.0F, 1.0F)
                    .sound(SoundType.SOUL_SOIL).harvestLevel(1).harvestTool(ToolType.SHOVEL))
    );
    public static final RegistryObject<Block> CHOCOLATE_GRASS = BLOCKS.register("chocolate_grass", () ->
            new Block(Block.Properties.of(Material.DIRT).strength(1.0F, 1.5F)
                    .sound(SoundType.GRASS).harvestLevel(1).harvestTool(ToolType.SHOVEL))
    );


    //Door Blocks and TrapDoor Blocks
    public static final RegistryObject<DoorBlock> CHOCOLATE_DOOR = BLOCKS.register("chocolate_door", ()->
            new DoorBlock(Block.Properties.copy(Blocks.OAK_DOOR)));
    public static final RegistryObject<DoorBlock> MILK_CHOCOLATE_DOOR = BLOCKS.register("milk_chocolate_door", ()->
            new DoorBlock(Block.Properties.copy(Blocks.OAK_DOOR)));
    public static final RegistryObject<DoorBlock> DARK_CHOCOLATE_DOOR = BLOCKS.register("dark_chocolate_door", ()->
            new DoorBlock(Block.Properties.copy(Blocks.OAK_DOOR)));

    //TrapDoors
    public static final RegistryObject<TrapDoorBlock> CHOCOLATE_TRAPDOOR = BLOCKS.register("chocolate_trapdoor", ()->
            new TrapDoorBlock(Block.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final RegistryObject<TrapDoorBlock> MILK_CHOCOLATE_TRAPDOOR = BLOCKS.register("milk_chocolate_trapdoor", ()->
            new TrapDoorBlock(Block.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final RegistryObject<TrapDoorBlock> DARK_CHOCOLATE_TRAPDOOR = BLOCKS.register("dark_chocolate_trapdoor", ()->
            new TrapDoorBlock(Block.Properties.copy(Blocks.OAK_TRAPDOOR)));



    //Fluid Blocks

    public static final RegistryObject<LiquidBlock> MILK_MELTED_CHOCOLATE = register("melted_milk_chocolate",
            new LiquidBlock(ModFluids.FLOWINGMILKMELTEDCHOCOLATE, Block.Properties.of(Material.WATER)
                    .strength(100.0F).noDrops()));
    public static final RegistryObject<LiquidBlock> MELTED_CHOCOLATE = register("melted_chocolate",
            new LiquidBlock(ModFluids.FLOWINGMELTEDCHOCOLATE, Block.Properties.of(Material.WATER)
                    .strength(100.0F).noDrops()));
    public static final RegistryObject<LiquidBlock> MELTED_DARK_CHOCOLATE = register("melted_dark_chocolate",
            new LiquidBlock(ModFluids.FLOWINGDARKMELTEDCHOCOLATE, Block.Properties.of(Material.WATER)
                    .strength(100.0F).noDrops()));



    private static <T extends LiquidBlock> RegistryObject<LiquidBlock> register(String id, T block)
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
