package tyrannus.chocolate.init.world;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import tyrannus.chocolate.setup.ModBlocks;

public class FluidGeneration {
    /*
    public static void generateFluids(final BiomeLoadingEvent event) {
        if (!(event.getCategory().equals(Biome.BiomeCategory.NETHER) || event.getCategory().equals(Biome.BiomeCategory.THEEND))) {
            GenerateFluid(event.getGeneration(), OreConfiguration.Predicates.NATURAL_STONE, ModBlocks.MELTED_CHOCOLATE.get()
                    .defaultBlockState(), 3, 30, 60, 5
            );
        }

        if (!(event.getCategory().equals(Biome.BiomeCategory.NETHER) || event.getCategory().equals(Biome.BiomeCategory.THEEND))) {
            GenerateFluid(event.getGeneration(), OreConfiguration.Predicates.NATURAL_STONE, ModBlocks.MILK_MELTED_CHOCOLATE.get()
                    .defaultBlockState(), 5, 50, 80, 10
            );

        }
    }



        private static void GenerateFluid (BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState
        state,
        int veinSize, int minHeight, int maxHeight, int perChunk){
            settings.getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES,
                    Feature.ORE.configured(new OreConfiguration(fillerType, state, veinSize))
                            .decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(50)))
                            .square().count(perChunk)
            );

        }*/
}
