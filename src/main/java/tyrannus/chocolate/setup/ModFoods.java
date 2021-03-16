package tyrannus.chocolate.setup;

import net.minecraft.item.Food;
import net.minecraft.potion.Potion;

public class ModFoods {
    public static final Food CHOCOLATE;
    public static final Food MILK_CHOCOLATE;
    public static final Food CHOCOLATE_CHIPS;
    public static final Food DARK_CHOCOLATE;
    public static final Food CHOCOLATE_BALL;
    public static Potion MELTED_CHOCOLATE_BUCKET;
    public static Potion MELTED_MILK_CHOCOLATE_BUCKET;

    static {
        CHOCOLATE = (new Food.Builder()).hunger(2).saturation(1F).fastToEat().build();
        MILK_CHOCOLATE = (new Food.Builder()).hunger(1).saturation(1F).fastToEat().build();
        CHOCOLATE_CHIPS = (new Food.Builder()).hunger((int) .5).saturation(0.2F).fastToEat().build();
        CHOCOLATE_BALL = (new Food.Builder()).hunger((int) .5).saturation(1F).build();
        DARK_CHOCOLATE = (new Food.Builder()).hunger(3).saturation(4F).build();
    }
    static {
        MELTED_CHOCOLATE_BUCKET = (new Potion());
        MELTED_MILK_CHOCOLATE_BUCKET = (new Potion());
    }

}
