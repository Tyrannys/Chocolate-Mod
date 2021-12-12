package tyrannus.chocolate.data.client.tags;

import com.google.common.collect.Lists;
import net.minecraft.core.Registry;
import net.minecraft.tags.StaticTagHelper;
import net.minecraft.tags.StaticTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.material.Fluid;

import java.util.List;

import static net.minecraft.tags.FluidTags.bind;

public class ModFluidTags{
    protected static final StaticTagHelper<Fluid> HELPER = StaticTags.create(Registry.FLUID_REGISTRY, "tags/fluids");
    private static final List<Tag<Fluid>> KNOWN_TAGS = Lists.newArrayList();

    public static final Tag.Named<Fluid> CHOCOLATE_FLUID = bind("chocolate_fluid");

    private ModFluidTags() {
    }

    public static Tag.Named<Fluid> bind(String p_13135_) {
        Tag.Named<Fluid> named = HELPER.bind(p_13135_);
        KNOWN_TAGS.add(named);
        return named;
    }

}
