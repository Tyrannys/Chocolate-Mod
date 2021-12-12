package tyrannus.chocolate.data.client;

import com.mojang.serialization.Keyable;
import net.minecraft.core.IdMap;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;

public abstract class ModRegistry<T> implements Keyable, IdMap {

    public static final ResourceKey<Registry<Fluid>> FLUID_REGISTRY = createRegistryKey("fluid");

    private static <T> ResourceKey<Registry<T>> createRegistryKey(String p_122979_) {
        return ResourceKey.createRegistryKey(new ResourceLocation(p_122979_));
    }   

}
