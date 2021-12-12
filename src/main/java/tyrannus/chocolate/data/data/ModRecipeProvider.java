package tyrannus.chocolate.data.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import tyrannus.chocolate.Chocolate;
import tyrannus.chocolate.setup.ModBlocks;
import tyrannus.chocolate.setup.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        //Crafting Recipes
        //Block Recipes
        ShapelessRecipeBuilder.shapeless(ModItems.CHOCOLATE_BLOCK_ITEM.get(), 1)
                .requires(Ingredient.of(ModItems.CHOCOLATE.get()), 9)
                .unlockedBy("has_chocolate", has(ModItems.CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "chocolate_block"));

        ShapelessRecipeBuilder.shapeless(ModItems.MILK_CHOCOLATE_BLOCK_ITEM.get(), 1)
                .requires(Ingredient.of(ModItems.MILK_CHOCOLATE.get()), 9)
                .unlockedBy("has_milk_chocolate", has(ModItems.MILK_CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "milk_chocolate_block"));

        ShapelessRecipeBuilder.shapeless(ModItems.DARK_CHOCOLATE_BLOCK_ITEM.get(), 1)
                .requires(Ingredient.of(ModItems.DARK_CHOCOLATE.get()), 9)
                .unlockedBy("has_milk_chocolate", has(ModItems.DARK_CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "dark_chocolate_block"));
        //from Block Recipes
        ShapelessRecipeBuilder.shapeless(ModItems.DARK_CHOCOLATE.get(), 9)
                .requires(Ingredient.of(ModItems.DARK_CHOCOLATE_BLOCK_ITEM.get()), 1)
                .unlockedBy("has_item", has(ModItems.DARK_CHOCOLATE_BLOCK_ITEM.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "dark_chocolate_from_block"));

        ShapelessRecipeBuilder.shapeless(ModItems.MILK_CHOCOLATE.get(), 9)
                .requires(Ingredient.of(ModItems.MILK_CHOCOLATE_BLOCK_ITEM.get()), 1)
                .unlockedBy("has_item", has(ModItems.MILK_CHOCOLATE_BLOCK_ITEM.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "milk_chocolate_from_block"));

        ShapelessRecipeBuilder.shapeless(ModItems.CHOCOLATE.get(), 9)
                .requires(Ingredient.of(ModItems.CHOCOLATE_BLOCK_ITEM.get()), 1)
                .unlockedBy("has_item", has(ModItems.CHOCOLATE_BLOCK_ITEM.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "chocolate_from_block"));
        ShapelessRecipeBuilder.shapeless(ModItems.MILK_CHOCOLATE.get(), 4)
                .requires(Ingredient.of(ModItems.CHOCOLATE.get()), 2)
                .requires(Ingredient.of(Items.MILK_BUCKET), 1)
                .unlockedBy("has_item", has(ModItems.CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "milk_chocolate"));

        //Bucket Recipes
        ShapelessRecipeBuilder.shapeless(ModItems.CHOCOLATE_BUCKET.get(), 2)
                .requires(Ingredient.of(ModItems.CHOCOLATE.get()), 1)
                .requires(Ingredient.of(Items.BUCKET), 2)
                .unlockedBy("has_chocolate", has(ModItems.CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "chocolate_bucket"));

        ShapelessRecipeBuilder.shapeless(ModItems.MILK_CHOCOLATE_BUCKET.get(), 1)
                .requires(Ingredient.of(ModItems.CHOCOLATE.get()), 1)
                .requires(Ingredient.of(Items.MILK_BUCKET), 1)
                .unlockedBy("has_chocolate", has(ModItems.CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "milk_chocolate_bucket"));

        ShapelessRecipeBuilder.shapeless(ModItems.MILK_CHOCOLATE_BUCKET.get(), 1)
                .requires(Ingredient.of(ModItems.MILK_CHOCOLATE.get()), 1)
                .requires(Ingredient.of(Items.BUCKET), 1)
                .unlockedBy("has_chocolate", has(ModItems.MILK_CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "milk_chocolate_bucket_2"));

        ShapelessRecipeBuilder.shapeless(ModItems.DARK_CHOCOLATE_BUCKET.get(), 1)
                .requires(Ingredient.of(ModItems.DARK_CHOCOLATE.get()), 1)
                .requires(Ingredient.of(Items.BUCKET), 1)
                .unlockedBy("has_dark_chocolate", has(ModItems.DARK_CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "dark_chocolate_bucket"));

        //Item Recipes
        ShapelessRecipeBuilder.shapeless(ModItems.CHOCOLATE.get(), 1)
                .requires(Ingredient.of(ModItems.CHOCOLATE_CHIPS.get()), 3)
                .unlockedBy("has_item", has(ModItems.CHOCOLATE_CHIPS.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "chocolate"));

        ShapelessRecipeBuilder.shapeless(ModItems.CHOCOLATE.get(), 1)
                .requires(Ingredient.of(Items.COCOA_BEANS), 2)
                .requires(Ingredient.of(Items.SUGAR))
                .unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "chocolate2"));

        ShapelessRecipeBuilder.shapeless(ModItems.CHOCOLATE_CHIPS.get(), 3)
                .requires(Ingredient.of(ModItems.CHOCOLATE.get()), 1)
                .unlockedBy("has_item", has(ModItems.CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "chocolate_chips"));

        //Furnace, Blasting, and Cooking Recipes
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.CHOCOLATE_BUCKET.get()),
                ModItems.MELTED_CHOCOLATE_BUCKET.get(), (int).5, 200)
                    .unlockedBy("has_item", has(ModItems.CHOCOLATE_BUCKET.get()))
                    .save(consumer, new ResourceLocation(Chocolate.MODID, "melted_chocolate_bucket"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.MILK_CHOCOLATE_BUCKET.get()),
                ModItems.MELTED_MILK_CHOCOLATE_BUCKET.get(), (int).5, 200)
                .unlockedBy("has_item", has(ModItems.MILK_CHOCOLATE_BUCKET.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "melted_milk_chocolate_bucket"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.DARK_CHOCOLATE_BUCKET.get()),
                ModItems.MELTED_DARK_CHOCOLATE_BUCKET.get(), (int).5, 200)
                .unlockedBy("has_item", has(ModItems.DARK_CHOCOLATE_BUCKET.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "melted_dark_chocolate_bucket"));


        //shaped recipes
        //Trapdoor recipes = pain
        ShapedRecipeBuilder.shaped(ModBlocks.CHOCOLATE_TRAPDOOR.get(), 2)
                .pattern("   ")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.CHOCOLATE.get())
                .unlockedBy("has_item", has(ModItems.CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "chocolate_trapdoor"));
        ShapedRecipeBuilder.shaped(ModBlocks.CHOCOLATE_TRAPDOOR.get(), 2)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("   ")
                .define('X', ModItems.CHOCOLATE.get())
                .unlockedBy("has_item", has(ModItems.CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "chocolate_trapdoor2"));
        ShapedRecipeBuilder.shaped(ModBlocks.MILK_CHOCOLATE_TRAPDOOR.get(), 2)
                .pattern("   ")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.MILK_CHOCOLATE.get())
                .unlockedBy("has_item", has(ModItems.MILK_CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "milk_chocolate_trapdoor"));
        ShapedRecipeBuilder.shaped(ModBlocks.MILK_CHOCOLATE_TRAPDOOR.get(), 2)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("   ")
                .define('X', ModItems.MILK_CHOCOLATE.get())
                .unlockedBy("has_item", has(ModItems.MILK_CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "milk_chocolate_trapdoor2"));
        ShapedRecipeBuilder.shaped(ModBlocks.DARK_CHOCOLATE_TRAPDOOR.get(), 2)
                .pattern("   ")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.DARK_CHOCOLATE.get())
                .unlockedBy("has_item", has(ModItems.DARK_CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "dark_chocolate_trapdoor"));
        ShapedRecipeBuilder.shaped(ModBlocks.DARK_CHOCOLATE_TRAPDOOR.get(), 2)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("   ")
                .define('X', ModItems.DARK_CHOCOLATE.get())
                .unlockedBy("has_item", has(ModItems.DARK_CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "dark_chocolate_trapdoor2"));
        //Doors recipes = more pain
        ShapedRecipeBuilder.shaped(ModBlocks.CHOCOLATE_DOOR.get(), 3)
                .pattern(" XX")
                .pattern(" XX")
                .pattern(" XX")
                .define('X', ModItems.CHOCOLATE.get())
                .unlockedBy("has_item", has(ModItems.CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "chocolate_door"));
        ShapedRecipeBuilder.shaped(ModBlocks.CHOCOLATE_DOOR.get(), 3)
                .pattern("XX ")
                .pattern("XX ")
                .pattern("XX ")
                .define('X', ModItems.CHOCOLATE.get())
                .unlockedBy("has_item", has(ModItems.CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "chocolate_door2"));
        ShapedRecipeBuilder.shaped(ModBlocks.MILK_CHOCOLATE_DOOR.get(), 3)
                .pattern(" XX")
                .pattern(" XX")
                .pattern(" XX")
                .define('X', ModItems.MILK_CHOCOLATE.get())
                .unlockedBy("has_item", has(ModItems.MILK_CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "milk_chocolate_door"));
        ShapedRecipeBuilder.shaped(ModBlocks.MILK_CHOCOLATE_DOOR.get(), 3)
                .pattern("XX ")
                .pattern("XX ")
                .pattern("XX ")
                .define('X', ModItems.MILK_CHOCOLATE.get())
                .unlockedBy("has_item", has(ModItems.MILK_CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "milk_chocolate_door2"));
        ShapedRecipeBuilder.shaped(ModBlocks.DARK_CHOCOLATE_DOOR.get(), 3)
                .pattern(" XX")
                .pattern(" XX")
                .pattern(" XX")
                .define('X', ModItems.DARK_CHOCOLATE.get())
                .unlockedBy("has_item", has(ModItems.DARK_CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "dark_chocolate_door"));
        ShapedRecipeBuilder.shaped(ModBlocks.DARK_CHOCOLATE_DOOR.get(), 3)
                .pattern("XX ")
                .pattern("XX ")
                .pattern("XX ")
                .define('X', ModItems.DARK_CHOCOLATE.get())
                .unlockedBy("has_item", has(ModItems.DARK_CHOCOLATE.get()))
                .save(consumer, new ResourceLocation(Chocolate.MODID, "dark_chocolate_door2"));
    }

}




