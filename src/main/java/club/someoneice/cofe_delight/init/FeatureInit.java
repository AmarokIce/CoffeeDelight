package club.someoneice.cofe_delight.init;

import club.someoneice.cofe_delight.CoffeeDelight;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class FeatureInit {
    public static RegistryKey<PlacedFeature> COFFEE_BUSH = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(CoffeeDelight.MODID, "coffee_bush"));

    public static void boot() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DESERT), GenerationStep.Feature.VEGETAL_DECORATION, COFFEE_BUSH);
    }
}
