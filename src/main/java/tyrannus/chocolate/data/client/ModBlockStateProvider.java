package tyrannus.chocolate.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import tyrannus.chocolate.Chocolate;
import tyrannus.chocolate.setup.ModBlocks;

import java.sql.ResultSet;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Chocolate.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.CHOCOLATE_DIRT.get());
        simpleBlock(ModBlocks.CHOCOLATE_ORE.get());
        //one texture

        //Trap door providers
        {
            ResourceLocation block = modLoc("block/chocolate_trapdoor");
            trapdoorBlock(ModBlocks.CHOCOLATE_TRAPDOOR.get(), block, true);
        }
        {
            ResourceLocation block = modLoc("block/milk_chocolate_trapdoor");
            trapdoorBlock(ModBlocks.MILK_CHOCOLATE_TRAPDOOR.get(), block, true);
        }
        {
            ResourceLocation block = modLoc("block/dark_chocolate_trapdoor");
            trapdoorBlock(ModBlocks.DARK_CHOCOLATE_TRAPDOOR.get(), block, true);
        }



        //Blocks with more than one texture
        //DoorBlock providers
        {
            ResourceLocation top = modLoc("block/chocolate_door_top");
            ResourceLocation bottom = modLoc("block/chocolate_door_bottom");
            doorBlock(ModBlocks.CHOCOLATE_DOOR.get(), top, bottom);
        }
        {
            ResourceLocation top = modLoc("block/milk_chocolate_door_top");
            ResourceLocation bottom = modLoc("block/milk_chocolate_door_bottom");
            doorBlock(ModBlocks.MILK_CHOCOLATE_DOOR.get(), top, bottom);
        }
        {
            ResourceLocation top = modLoc("block/dark_chocolate_door_bottom");
            ResourceLocation bottom = modLoc("block/dark_chocolate_door_top");
            doorBlock(ModBlocks.DARK_CHOCOLATE_DOOR.get(), top, bottom);
        }
        {
            ResourceLocation side = modLoc("block/chocolate_block_side");
            ResourceLocation top = modLoc("block/chocolate_block_top");
            simpleBlock(ModBlocks.CHOCOLATE_BLOCK.get(),
                    models().cube("chocolate_block", side, top, side, side, side, side)
                            .texture("particle", side));
        }
        {
            ResourceLocation side = modLoc("block/milk_chocolate_block_side");
            ResourceLocation top = modLoc("block/milk_chocolate_block_top");
            simpleBlock(ModBlocks.MILK_CHOCOLATE_BLOCK.get(),
                    models().cube("milk_chocolate_block", side, top, side, side, side, side)
                            .texture("particle", side));
        }
        {
            ResourceLocation side = modLoc("block/dark_chocolate_block_side");
            ResourceLocation top = modLoc("block/dark_chocolate_block_top");
            simpleBlock(ModBlocks.DARK_CHOCOLATE_BLOCK.get(),
                    models().cube("dark_chocolate_block", side, top, side, side, side, side)
                            .texture("particle", side));
        }
        {
            ResourceLocation bottom = modLoc("block/chocolate_dirt");
            ResourceLocation side = modLoc("block/chocolate_grass_side");
            ResourceLocation top = modLoc("block/chocolate_grass_top");
            simpleBlock(ModBlocks.CHOCOLATE_GRASS.get(),
                    models().cube("chocolate_grass", bottom, top, side, side, side, side)
                            .texture("particle", side));
        }


    }

}
