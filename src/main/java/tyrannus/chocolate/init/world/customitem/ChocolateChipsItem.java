package tyrannus.chocolate.init.world.customitem;

import net.minecraft.world.item.Item;
import tyrannus.chocolate.init.special.ChocolateItemGroup;
import tyrannus.chocolate.setup.ModFoods;

public class ChocolateChipsItem extends Item {

    //placeholder code for an item I may put flavor text on

    public ChocolateChipsItem() {
        super(new Item.Properties().tab(ChocolateItemGroup.CHOCOLATE_ITEM_GROUP)
                .food(ModFoods.CHOCOLATE_CHIPS));
    }
/*
    @Override
    public void addInformation(@Nullable ItemStack stack, @Nullable World worldIn,@Nullable List<ITextComponent> tooltip,@Nullable ITooltipFlag flagIn) {

        if(KeyboardUtil.isHoldingShift()) {
            Objects.requireNonNull(tooltip).add(new StringTextComponent("\u00A7e"+"Seems a bit rocky" + "\u00A7e"));

        } else {
            Objects.requireNonNull(tooltip).add(new StringTextComponent("\u00A77"+"Hold "+"\u00A7e"+"shift "+"\u00A77"+"for more info" + "\u00A77"));

        }
    }*/
}
