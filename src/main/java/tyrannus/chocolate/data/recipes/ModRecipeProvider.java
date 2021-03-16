package tyrannus.chocolate.data.recipes;

import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.item.crafting.ShapelessRecipe;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import tyrannus.chocolate.chocolate;
import tyrannus.chocolate.setup.ModBlocks;
import tyrannus.chocolate.setup.ModFluids;
import tyrannus.chocolate.setup.ModItems;
import tyrannus.chocolate.setup.ModTags;

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
                .addIngredient(Ingredient.fromItems(Items.COCOA_BEANS), 2)
                .addIngredient(Ingredient.fromItems(Items.SUGAR))
                .addCriterion("has_cocoa_beans", hasItem(Items.COCOA_BEANS))
                .build(consumer, new ResourceLocation(chocolate.MODID, "chocolate_two"));


        //Furnace, Blasting, and Cooking Recipes
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModItems.CHOCOLATE_BUCKET.get()),
                ModItems.MELTED_CHOCOLATE_BUCKET.get(), (int).5, 200)
                    .addCriterion("has_item", hasItem(ModItems.CHOCOLATE_BUCKET.get()))
                    .build(consumer, new ResourceLocation(chocolate.MODID, "melted_chocolate_bucket"));
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModItems.MILK_CHOCOLATE_BUCKET.get()),
                ModItems.MELTED_MILK_CHOCOLATE_BUCKET.get(), (int).5, 200)
                .addCriterion("has_item", hasItem(ModItems.MILK_CHOCOLATE_BUCKET.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "melted_milk_chocolate_bucket"));;
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModItems.DARK_CHOCOLATE_BUCKET.get()),
                ModItems.MELTED_DARK_CHOCOLATE_BUCKET.get(), (int).5, 200)
                .addCriterion("has_item", hasItem(ModItems.DARK_CHOCOLATE_BUCKET.get()))
                .build(consumer, new ResourceLocation(chocolate.MODID, "melted_dark_chocolate_bucket"));;

    }

}
      /*  ShapedRecipeBuilder.shapedRecipe(ModBlocks.CHOCOLATE_BLOCK.get(), 1)
                .patternLine("XXX")
                .patternLine("XXX")
                .patternLine("XXX")
                .key('X', ModItems.CHOCOLATE.get())
                .build(consumer, new ResourceLocation(chocolate.MODID, "Chocolate_block"));
*/


