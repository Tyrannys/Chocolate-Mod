package tyrannus.chocolate.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import tyrannus.chocolate.chocolate;
import tyrannus.chocolate.setup.ModFluids;
import tyrannus.chocolate.setup.ModTags;

import javax.annotation.Nullable;

public class ModFluidTagsProvider extends FluidTagsProvider {
    public ModFluidTagsProvider(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, chocolate.MODID, existingFileHelper);
    }

        protected void registerTags() {
            tag(ModTags.Fluids.CHOCOLATE)
                    .add(ModFluids.FLOWINGMELTEDCHOCOLATE.get()).add(ModFluids.MELTEDCHOCOLATE.get())
                    .add(ModFluids.FLOWINGMILKMELTEDCHOCOLATE.get()).add(ModFluids.MILKMELTEDCHOCOLATE.get())
                    .add(ModFluids.FLOWINGDARKMELTEDCHOCOLATE.get()).add(ModFluids.MELTEDDARKCHOCOLATE.get());

        }
}
