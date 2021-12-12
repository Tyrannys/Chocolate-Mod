package tyrannus.chocolate.setup;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.alchemy.Potion;

public class ModFoods {
    public static final FoodProperties CHOCOLATE;
    public static final FoodProperties MILK_CHOCOLATE;
    public static final FoodProperties CHOCOLATE_CHIPS;
    public static final FoodProperties DARK_CHOCOLATE;
    public static final FoodProperties CHOCOLATE_BALL;
    public static final Potion MELTED_CHOCOLATE_BUCKET;
    public static final Potion MELTED_MILK_CHOCOLATE_BUCKET;

    static {
        CHOCOLATE = (new FoodProperties.Builder()).nutrition(2).saturationMod(1F).build();
        MILK_CHOCOLATE = (new FoodProperties.Builder()).nutrition((int) 1.5).saturationMod(1F).fast().build();
        CHOCOLATE_CHIPS = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).fast().build();
        CHOCOLATE_BALL = (new FoodProperties.Builder()).nutrition(1).saturationMod(1F).build();
        DARK_CHOCOLATE = (new FoodProperties.Builder()).nutrition(3).saturationMod(4F).build();
    }
    static {
        MELTED_CHOCOLATE_BUCKET = (new Potion());
        MELTED_MILK_CHOCOLATE_BUCKET = (new Potion());
    }

}
