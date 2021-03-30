package tyrannus.chocolate.setup;

import net.minecraft.block.Block;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import tyrannus.chocolate.chocolate;

public class ModTags {
    public static final class Blocks {
        public static final ITag.INamedTag<Block> ORES_CHOCOLATE = forge("ores/chocolate");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS = forge("storage_blocks/chocolate");


        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Block> mod(String path) {
            return BlockTags.makeWrapperTag(new ResourceLocation(chocolate.MODID, path).toString());
        }
    }

    public static final class Items {
        public static final ITag.INamedTag<Item> ORES_CHOCOLATE = forge("ores/chocolate");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS = forge("storage_blocks/chocolate");

        public static final ITag.INamedTag<Item> INGOTS_CHOCOLATE = forge("ingots/chocolate");

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
        }
        private static ITag.INamedTag<Item> mod(String path) {
            return ItemTags.makeWrapperTag(new ResourceLocation(chocolate.MODID, path).toString());
        }
    }

    public static final class Fluids {
        public static final ITag.INamedTag<Fluid> CHOCOLATE = forge("fluids/chocolate");


        private static ITag.INamedTag<Fluid> forge(String path) {
            return FluidTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
        }
        private static ITag.INamedTag<Fluid> mod(String path) {
            return FluidTags.makeWrapperTag(new ResourceLocation(chocolate.MODID, path).toString());
        }
    }

}

