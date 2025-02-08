package lcyzsdh.coffee_delight.worldgen;

import lcyzsdh.coffee_delight.CoffeeDelight;
import lcyzsdh.coffee_delight.block.BlockCoffeeBush;
import lcyzsdh.coffee_delight.registry.BlockRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public class ModFeatures {
    public static final ResourceKey<ConfiguredFeature<?,?>> COFFEE_BUSH =ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(CoffeeDelight.MODID,"coffee_bush"));

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?,?>> pContext){
        FeatureUtils.register(pContext, COFFEE_BUSH, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(BlockRegistry.COFFEE_BUSH.get().defaultBlockState().setValue(BlockCoffeeBush.AGE,Integer.valueOf(3)))),
                        List.of(Blocks.SAND)));
    }
}
