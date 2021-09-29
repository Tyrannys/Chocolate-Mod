package tyrannus.chocolate.setup;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import tyrannus.chocolate.chocolate;

public class ModTags {
    public static final class Blocks {
        public static final Tag.Named<Block> ORES_CHOCOLATE = forge("ores/chocolate");
        public static final Tag.Named<Block> STORAGE_BLOCKS = forge("storage_blocks/chocolate");


        private static Tag.Named<Block> forge(String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static Tag.Named<Block> mod(String path) {
            return BlockTags.bind(new ResourceLocation(chocolate.MODID, path).toString());
        }
    }

    public static final class Items {
        public static final Tag.Named<Item> ORES_CHOCOLATE = forge("ores/chocolate");
        public static final Tag.Named<Item> STORAGE_BLOCKS = forge("storage_blocks/chocolate");

        public static final Tag.Named<Item> INGOTS_CHOCOLATE = forge("ingots/chocolate");

        private static Tag.Named<Item> forge(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }
        private static Tag.Named<Item> mod(String path) {
            return ItemTags.bind(new ResourceLocation(chocolate.MODID, path).toString());
        }
    }

    public static final class Fluids {
        public static final Tag.Named<Fluid> CHOCOLATE = forge("fluids/chocolate");


        private static Tag.Named<Fluid> forge(String path) {
            return FluidTags.bind(new ResourceLocation("forge", path).toString());
        }
        private static Tag.Named<Fluid> mod(String path) {
            return FluidTags.bind(new ResourceLocation(chocolate.MODID, path).toString());
        }
    }

}

