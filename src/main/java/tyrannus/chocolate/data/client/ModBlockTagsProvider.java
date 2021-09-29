package tyrannus.chocolate.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import tyrannus.chocolate.chocolate;
import tyrannus.chocolate.setup.ModBlocks;
import tyrannus.chocolate.setup.ModTags;

import javax.annotation.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, chocolate.MODID, existingFileHelper);
    }


    protected void registerTags() {
        tag(ModTags.Blocks.ORES_CHOCOLATE).add(ModBlocks.CHOCOLATE_ORE.get());

        tag(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_CHOCOLATE);

        tag(ModTags.Blocks.STORAGE_BLOCKS).add(ModBlocks.CHOCOLATE_BLOCK.get())
                .add(ModBlocks.MILK_CHOCOLATE_BLOCK.get()).add(ModBlocks.DARK_CHOCOLATE_BLOCK.get());

        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS);
    }
}
