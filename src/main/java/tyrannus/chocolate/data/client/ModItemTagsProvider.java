package tyrannus.chocolate.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import tyrannus.chocolate.chocolate;
import tyrannus.chocolate.setup.ModItems;
import tyrannus.chocolate.setup.ModTags;

import javax.annotation.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, chocolate.MODID, existingFileHelper);
    }


    protected void registerTags() {
        copy(ModTags.Blocks.ORES_CHOCOLATE, ModTags.Items.ORES_CHOCOLATE);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(ModTags.Blocks.STORAGE_BLOCKS, ModTags.Items.STORAGE_BLOCKS);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        tag(ModTags.Items.INGOTS_CHOCOLATE).add(ModItems.CHOCOLATE.get());
        tag(Tags.Items.INGOTS).addTag(Tags.Items.INGOTS);

    }
}
