package tyrannus.chocolate.init.special;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

import static tyrannus.chocolate.setup.ModItems.CHOCOLATE;

public class ChocolateItemGroup extends ItemGroup {

    private final IItemProvider icon;

    public ChocolateItemGroup(String label, IItemProvider icon) {
        super(label);
        this.icon = icon;
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public ItemStack createIcon() {
        return new ItemStack(icon);
    }
    public static final ChocolateItemGroup CHOCOLATE_ITEM_GROUP = new ChocolateItemGroup("moditemgroup", ()->(CHOCOLATE.get()));
}
