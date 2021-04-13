package tyrannus.chocolate.data.data;

import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import tyrannus.chocolate.chocolate;
import tyrannus.chocolate.setup.ModBlocks;
import tyrannus.chocolate.setup.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {

        //Crafting Recipes
        //Block Recipes
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CHOCOLATE_BLOCK_ITEM.get(), 1)
                .addIngredient(Ingredient.fromItems(ModItems.CHOCOLATE.get()), 9)
                .addCriterion("has_chocolate", hasItem(ModItems.CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "chocolate_block"));

        ShapelessRecipeBuilder.shapelessRecipe(ModItems.MILK_CHOCOLATE_BLOCK_ITEM.get(), 1)
                .addIngredient(Ingredient.fromItems(ModItems.MILK_CHOCOLATE.get()), 9)
                .addCriterion("has_milk_chocolate", hasItem(ModItems.MILK_CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "milk_chocolate_block"));

        ShapelessRecipeBuilder.shapelessRecipe(ModItems.DARK_CHOCOLATE_BLOCK_ITEM.get(), 1)
                .addIngredient(Ingredient.fromItems(ModItems.DARK_CHOCOLATE.get()), 9)
                .addCriterion("has_milk_chocolate", hasItem(ModItems.DARK_CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "dark_chocolate_block"));
        //from Block Recipes
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.DARK_CHOCOLATE.get(), 9)
                .addIngredient(Ingredient.fromItems(ModItems.DARK_CHOCOLATE_BLOCK_ITEM.get()), 1)
                .addCriterion("has_item", hasItem(ModItems.DARK_CHOCOLATE_BLOCK_ITEM.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "dark_chocolate_from_block"));

        ShapelessRecipeBuilder.shapelessRecipe(ModItems.MILK_CHOCOLATE.get(), 9)
                .addIngredient(Ingredient.fromItems(ModItems.MILK_CHOCOLATE_BLOCK_ITEM.get()), 1)
                .addCriterion("has_item", hasItem(ModItems.MILK_CHOCOLATE_BLOCK_ITEM.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "milk_chocolate_from_block"));

        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CHOCOLATE.get(), 9)
                .addIngredient(Ingredient.fromItems(ModItems.CHOCOLATE_BLOCK_ITEM.get()), 1)
                .addCriterion("has_item", hasItem(ModItems.CHOCOLATE_BLOCK_ITEM.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "chocolate_from_block"));

        //Bucket Recipes
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CHOCOLATE_BUCKET.get(), 1)
                .addIngredient(Ingredient.fromItems(ModItems.CHOCOLATE.get()), 1)
                .addIngredient(Ingredient.fromItems(Items.BUCKET), 1)
                .addCriterion("has_chocolate", hasItem(ModItems.CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "chocolate_bucket"));

        ShapelessRecipeBuilder.shapelessRecipe(ModItems.MILK_CHOCOLATE_BUCKET.get(), 1)
                .addIngredient(Ingredient.fromItems(ModItems.CHOCOLATE.get()), 1)
                .addIngredient(Ingredient.fromItems(Items.MILK_BUCKET), 1)
                .addCriterion("has_chocolate", hasItem(ModItems.CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "milk_chocolate_bucket"));

        ShapelessRecipeBuilder.shapelessRecipe(ModItems.MILK_CHOCOLATE_BUCKET.get(), 1)
                .addIngredient(Ingredient.fromItems(ModItems.MILK_CHOCOLATE.get()), 1)
                .addIngredient(Ingredient.fromItems(Items.BUCKET), 1)
                .addCriterion("has_chocolate", hasItem(ModItems.MILK_CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "milk_chocolate_bucket_2"));

        ShapelessRecipeBuilder.shapelessRecipe(ModItems.DARK_CHOCOLATE_BUCKET.get(), 1)
                .addIngredient(Ingredient.fromItems(ModItems.DARK_CHOCOLATE.get()), 1)
                .addIngredient(Ingredient.fromItems(Items.BUCKET), 1)
                .addCriterion("has_dark_chocolate", hasItem(ModItems.DARK_CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "dark_chocolate_bucket"));

        //Item Recipes
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CHOCOLATE.get(), 1)
                .addIngredient(Ingredient.fromItems(ModItems.CHOCOLATE_CHIPS.get()), 3)
                .addCriterion("has_item", hasItem(ModItems.CHOCOLATE_CHIPS.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "chocolate"));

        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CHOCOLATE.get(), 1)
                .addIngredient(Ingredient.fromItems(Items.COCOA_BEANS), 2)
                .addIngredient(Ingredient.fromItems(Items.SUGAR))
                .addCriterion("has_cocoa_beans", hasItem(Items.COCOA_BEANS))
                .addCriterion("has_sugar", hasItem(Items.SUGAR))
                .build(consumer, new ResourceLocation(chocolate.MODID, "chocolate2"));

        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CHOCOLATE_CHIPS.get(), 3)
                .addIngredient(Ingredient.fromItems(ModItems.CHOCOLATE.get()), 1)
                .addCriterion("has_item", hasItem(ModItems.CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "chocolate_chips"));

        //Furnace, Blasting, and Cooking Recipes
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModItems.CHOCOLATE_BUCKET.get()),
                ModItems.MELTED_CHOCOLATE_BUCKET.get(), (int).5, 200)
                    .addCriterion("has_item", hasItem(ModItems.CHOCOLATE_BUCKET.get()))
                    .build(consumer, new ResourceLocation(chocolate.MODID, "melted_chocolate_bucket"));

        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModItems.MILK_CHOCOLATE_BUCKET.get()),
                ModItems.MELTED_MILK_CHOCOLATE_BUCKET.get(), (int).5, 200)
                .addCriterion("has_item", hasItem(ModItems.MILK_CHOCOLATE_BUCKET.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "melted_milk_chocolate_bucket"));

        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModItems.DARK_CHOCOLATE_BUCKET.get()),
                ModItems.MELTED_DARK_CHOCOLATE_BUCKET.get(), (int).5, 200)
                .addCriterion("has_item", hasItem(ModItems.DARK_CHOCOLATE_BUCKET.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "melted_dark_chocolate_bucket"));


        //shaped recipes
        //Trapdoor recipes = pain
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.CHOCOLATE_TRAPDOOR.get(), 2)
                .patternLine("   ")
                .patternLine("XXX")
                .patternLine("XXX")
                .key('X', ModItems.CHOCOLATE.get())
                .addCriterion("has_item", hasItem(ModItems.CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "chocolate_trapdoor"));
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.CHOCOLATE_TRAPDOOR.get(), 2)
                .patternLine("XXX")
                .patternLine("XXX")
                .patternLine("   ")
                .key('X', ModItems.CHOCOLATE.get())
                .addCriterion("has_item", hasItem(ModItems.CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "chocolate_trapdoor2"));
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.MILK_CHOCOLATE_TRAPDOOR.get(), 2)
                .patternLine("   ")
                .patternLine("XXX")
                .patternLine("XXX")
                .key('X', ModItems.MILK_CHOCOLATE.get())
                .addCriterion("has_item", hasItem(ModItems.MILK_CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "milk_chocolate_trapdoor"));
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.MILK_CHOCOLATE_TRAPDOOR.get(), 2)
                .patternLine("XXX")
                .patternLine("XXX")
                .patternLine("   ")
                .key('X', ModItems.MILK_CHOCOLATE.get())
                .addCriterion("has_item", hasItem(ModItems.MILK_CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "milk_chocolate_trapdoor2"));
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.DARK_CHOCOLATE_TRAPDOOR.get(), 2)
                .patternLine("   ")
                .patternLine("XXX")
                .patternLine("XXX")
                .key('X', ModItems.DARK_CHOCOLATE.get())
                .addCriterion("has_item", hasItem(ModItems.DARK_CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "dark_chocolate_trapdoor"));
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.DARK_CHOCOLATE_TRAPDOOR.get(), 2)
                .patternLine("XXX")
                .patternLine("XXX")
                .patternLine("   ")
                .key('X', ModItems.DARK_CHOCOLATE.get())
                .addCriterion("has_item", hasItem(ModItems.DARK_CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "dark_chocolate_trapdoor2"));
        //Doors recipes = more pain
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.CHOCOLATE_DOOR.get(), 3)
                .patternLine(" XX")
                .patternLine(" XX")
                .patternLine(" XX")
                .key('X', ModItems.CHOCOLATE.get())
                .addCriterion("has_item", hasItem(ModItems.CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "chocolate_door"));
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.CHOCOLATE_DOOR.get(), 3)
                .patternLine("XX ")
                .patternLine("XX ")
                .patternLine("XX ")
                .key('X', ModItems.CHOCOLATE.get())
                .addCriterion("has_item", hasItem(ModItems.CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "chocolate_door2"));
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.MILK_CHOCOLATE_DOOR.get(), 3)
                .patternLine(" XX")
                .patternLine(" XX")
                .patternLine(" XX")
                .key('X', ModItems.MILK_CHOCOLATE.get())
                .addCriterion("has_item", hasItem(ModItems.MILK_CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "milk_chocolate_door"));
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.MILK_CHOCOLATE_DOOR.get(), 3)
                .patternLine("XX ")
                .patternLine("XX ")
                .patternLine("XX ")
                .key('X', ModItems.MILK_CHOCOLATE.get())
                .addCriterion("has_item", hasItem(ModItems.MILK_CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "milk_chocolate_door2"));
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.DARK_CHOCOLATE_DOOR.get(), 3)
                .patternLine(" XX")
                .patternLine(" XX")
                .patternLine(" XX")
                .key('X', ModItems.DARK_CHOCOLATE.get())
                .addCriterion("has_item", hasItem(ModItems.DARK_CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "dark_chocolate_door"));
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.DARK_CHOCOLATE_DOOR.get(), 3)
                .patternLine("XX ")
                .patternLine("XX ")
                .patternLine("XX ")
                .key('X', ModItems.DARK_CHOCOLATE.get())
                .addCriterion("has_item", hasItem(ModItems.DARK_CHOCOLATE.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "dark_chocolate_door2"));
    }

}




