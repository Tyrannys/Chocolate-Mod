package tyrannus.chocolate.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import tyrannus.chocolate.Chocolate;
import tyrannus.chocolate.data.client.tags.ModFluidTags;
import tyrannus.chocolate.setup.ModFluids;

public class FluidTagsProvider extends net.minecraft.data.tags.FluidTagsProvider {
    public FluidTagsProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Chocolate.MODID, exFileHelper);
    }
    @Override
    protected void addTags() {
        this.tag(ModFluidTags.CHOCOLATE_FLUID).add(ModFluids.MELTEDCHOCOLATE.get(), ModFluids.FLOWINGMELTEDCHOCOLATE.get());
        this.tag(ModFluidTags.CHOCOLATE_FLUID).add(ModFluids.MELTEDDARKCHOCOLATE.get(), ModFluids.FLOWINGDARKMELTEDCHOCOLATE.get());
        this.tag(ModFluidTags.CHOCOLATE_FLUID).add(ModFluids.MILKMELTEDCHOCOLATE.get(), ModFluids.FLOWINGMILKMELTEDCHOCOLATE.get());
    }
    @Override
    public String getName() { return "Forge Fluid Tags"; }
}
