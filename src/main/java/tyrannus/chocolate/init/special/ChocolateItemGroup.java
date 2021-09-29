package tyrannus.chocolate.init.special;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static tyrannus.chocolate.setup.ModItems.CHOCOLATE;

public class ChocolateItemGroup extends CreativeModeTab {

    private final ItemLike icon;

    public ChocolateItemGroup(String label, ItemLike icon) {
        super(label);
        this.icon = icon;
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public ItemStack makeIcon() {
        return new ItemStack(icon);
    }
    public static final ChocolateItemGroup CHOCOLATE_ITEM_GROUP = new ChocolateItemGroup("moditemgroup", ()->(CHOCOLATE.get()));
}
