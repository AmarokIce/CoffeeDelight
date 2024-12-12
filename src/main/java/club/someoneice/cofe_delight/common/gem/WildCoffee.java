package club.someoneice.cofe_delight.common.gem;

import club.someoneice.cofe_delight.CoffeeDelight;
import com.google.common.collect.Lists;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class WildCoffee {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> FEATURES = DeferredRegister.create(Registries.CONFIGURED_FEATURE, CoffeeDelight.MODID);
    public static final DeferredRegister<PlacedFeature> PATCHES = DeferredRegister.create(Registries.PLACED_FEATURE, CoffeeDelight.MODID);

    // public static RegistryObject<ConfiguredFeature<?, ?>> FEATURE_PATCH_WILD_COFFEE = FEATURES.register("wild_coffee_bush_feature", WildCoffee::wildCropFeature);

    // public static RegistryObject<PlacedFeature> PATCH_WILD_COFFEE = PATCHES.register("wild_coffee_bush_patch", () -> wildCropPatch(FEATURE_PATCH_WILD_COFFEE, RarityFilter.onAverageOnceEvery(40), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));


    // private static ConfiguredFeature<?, ?> wildCropFeature() {
    //     return new ConfiguredFeature<>((Feature) ModBiomeFeatures.WILD_CROP.get(), WildCropGeneration.wildCropConfig(BlockInit.COFFEE_BUSH.get(), Blocks.DEAD_BUSH, BlockPredicate.matchesBlocks(Blocks.SAND)));
    // }

    private static PlacedFeature wildCropPatch(RegistryObject<ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
        return new PlacedFeature(feature.getHolder().get(), Lists.newArrayList(modifiers));
    }

}
