package club.someoneice.cofe_delight.common.gem;

import club.someoneice.cofe_delight.CoffeeDelight;
import club.someoneice.cofe_delight.init.BlockInit;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class WildCoffee {
    public static void register() {
        var configId = new Identifier(CoffeeDelight.MODID, "wild_coffee_bush_feature");
        var configuredFeature = Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, configId, new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeatureConfig()));
        RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, configId);
        Identifier featureId = new Identifier(CoffeeDelight.MODID, "wild_coffee_bush_path");
        Registry.register(BuiltinRegistries.PLACED_FEATURE, featureId,
                new PlacedFeature(RegistryEntry.of(configuredFeature), List.of(SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of())));
        var featureRegistryKey = RegistryKey.of(Registry.PLACED_FEATURE_KEY, featureId);

        BiomeModifications.addFeature(context -> context.getBiomeKey().equals(BiomeKeys.DESERT), GenerationStep.Feature.VEGETAL_DECORATION, featureRegistryKey);
    }

    private static RandomPatchFeatureConfig createRandomPatchFeatureConfig() {
        return new RandomPatchFeatureConfig(64, 6, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.COFFEE_BUSH))));
    }
}
