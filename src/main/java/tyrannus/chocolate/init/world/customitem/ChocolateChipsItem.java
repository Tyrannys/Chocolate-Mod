package tyrannus.chocolate.init.world.customitem;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import tyrannus.chocolate.init.special.ChocolateItemGroup;
import tyrannus.chocolate.init.special.KeyboardUtil;
import tyrannus.chocolate.setup.ModFoods;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class ChocolateChipsItem extends Item {

    public ChocolateChipsItem() {
        super(new Item.Properties().group(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
                .food(ModFoods.CHOCOLATE_CHIPS));
    }

    @Override
    public void addInformation(@Nullable ItemStack stack, @Nullable World worldIn,@Nullable List<ITextComponent> tooltip,@Nullable ITooltipFlag flagIn) {

        if(KeyboardUtil.isHoldingShift()) {
            Objects.requireNonNull(tooltip).add(new StringTextComponent("\u00A7e"+"Seems a bit rocky" + "\u00A7e"));

        } else {
            Objects.requireNonNull(tooltip).add(new StringTextComponent("\u00A77"+"Hold "+"\u00A7e"+"shift "+"\u00A77"+"for more info" + "\u00A77"));

        }
    }
}
