package tyrannus.chocolate.init.world;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraft.world.level.levelgen.feature.structures.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import tyrannus.chocolate.setup.ModBlocks;

public class OreGeneration {
/*
    public static void generateOres(final BiomeLoadingEvent event) {
        if(!(event.getCategory().equals(Biome.BiomeCategory.NETHER) || event.getCategory().equals(Biome.BiomeCategory.THEEND))) {
            generateOre(event.getGeneration(), OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, ModBlocks.CHOCOLATE_ORE.get()
                    .defaultBlockState(), 9, 30, 80, 30
            );
        }
    }



    private static void generateOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state,
                                    int veinSize, int minHeight, int maxHeight, int perChunk) {
        settings.getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(new OreConfiguration(fillerType, state, veinSize))
                        .decorated(JigsawPlacement.PieceFactory(new RangeDecoratorConfiguration(5))
                        .square().count(perChunk))
        );
    }*/


}