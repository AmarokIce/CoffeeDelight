package club.someoneice.cofe_delight.common.gem;

import club.someoneice.cofe_delight.CoffeeDelight;
import club.someoneice.cofe_delight.init.BlockInit;
import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.registry.ModBiomeFeatures;
import vectorwing.farmersdelight.common.world.WildCropGeneration;

public class WildCoffee {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> FEATURES = DeferredRegister.create(BuiltinRegistries.CONFIGURED_FEATURE.key(), CoffeeDelight.MODID);
    public static final DeferredRegister<PlacedFeature> PATCHES = DeferredRegister.create(BuiltinRegistries.PLACED_FEATURE.key(), CoffeeDelight.MODID);

    public static RegistryObject<ConfiguredFeature<?, ?>> FEATURE_PATCH_WILD_COFFEE = FEATURES.register("wild_coffee_bush", WildCoffee::wildCropFeature);

    public static RegistryObject<PlacedFeature> PATCH_WILD_COFFEE = PATCHES.register("wild_coffee_bush", () -> wildCropPatch(FEATURE_PATCH_WILD_COFFEE, RarityFilter.onAverageOnceEvery(40), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));


    private static ConfiguredFeature<?, ?> wildCropFeature() {
        return new ConfiguredFeature<>((Feature) ModBiomeFeatures.WILD_CROP.get(), WildCropGeneration.wildCropConfig(BlockInit.COFFEE_BUSH.get(), Blocks.DEAD_BUSH, BlockPredicate.matchesBlock(Blocks.SAND, new BlockPos(0, -1, 0))));
    }

    private static PlacedFeature wildCropPatch(RegistryObject<ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
        return new PlacedFeature(feature.getHolder().get(), Lists.newArrayList(modifiers));
    }

}
