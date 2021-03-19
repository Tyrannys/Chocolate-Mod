package tyrannus.chocolate.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import tyrannus.chocolate.chocolate;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, chocolate.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //blocks
        withExistingParent("chocolate_ore", modLoc("block/chocolate_ore"));
        withExistingParent("chocolate_block", modLoc("block/chocolate_block"));
        withExistingParent("dark_chocolate_block", modLoc("block/dark_chocolate_block"));
        withExistingParent("milk_chocolate_block", modLoc("block/milk_chocolate_block"));
        withExistingParent("chocolate_trapdoor", modLoc("block/chocolate_trapdoor_bottom"));
        withExistingParent("milk_chocolate_trapdoor", modLoc("block/milk_chocolate_trapdoor_bottom"));
        withExistingParent("dark_chocolate_trapdoor", modLoc("block/dark_chocolate_trapdoor_bottom"));
        //Spawn Egg .json files
        withExistingParent("spawn_egg_chocolate_slime", mcLoc("item/template_spawn_egg"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        //Items generated .json files
        builder(itemGenerated, "chocolate");
        builder(itemGenerated, "chocolate_chips");
        builder(itemGenerated, "milk_chocolate");
        builder(itemGenerated, "dark_chocolate");
        builder(itemGenerated, "milk_chocolate_bucket");
        builder(itemGenerated, "chocolate_bucket");
        builder(itemGenerated, "chocolate_ball");
        builder(itemGenerated, "melted_chocolate_bucket");
        builder(itemGenerated, "melted_milk_chocolate_bucket");
        builder(itemGenerated, "melted_dark_chocolate_bucket");
        builder(itemGenerated, "dark_chocolate_bucket");
        builder(itemGenerated, "chocolate_door");
        builder(itemGenerated, "milk_chocolate_door");
        builder(itemGenerated, "dark_chocolate_door");

    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }

}
