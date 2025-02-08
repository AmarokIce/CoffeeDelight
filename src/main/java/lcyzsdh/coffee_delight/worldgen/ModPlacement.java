package lcyzsdh.coffee_delight.worldgen;

import lcyzsdh.coffee_delight.CoffeeDelight;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class ModPlacement {
    public static final ResourceKey<PlacedFeature> COFFEE_BUSH=ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(CoffeeDelight.MODID,"coffee_bush"));

    public static void bootstrap(BootstrapContext<PlacedFeature> pContext){
        HolderGetter<ConfiguredFeature<?,?>> holderGetter=pContext.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?,?>> coffee_bush_holder=holderGetter.getOrThrow(ModFeatures.COFFEE_BUSH);

        PlacementUtils.register(pContext,COFFEE_BUSH, coffee_bush_holder, RarityFilter.onAverageOnceEvery(15),
                InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP);
    }
}
