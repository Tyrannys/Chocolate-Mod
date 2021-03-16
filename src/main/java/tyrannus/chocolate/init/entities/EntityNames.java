package tyrannus.chocolate.init.entities;

import net.minecraft.util.ResourceLocation;

import java.util.Locale;

import static tyrannus.chocolate.chocolate.MODID;

public class EntityNames {
    public static final ResourceLocation CHOCOLATE_SLIME = prefix("chocolate_slime");


    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MODID, name.toLowerCase(Locale.ROOT));
    }
}
