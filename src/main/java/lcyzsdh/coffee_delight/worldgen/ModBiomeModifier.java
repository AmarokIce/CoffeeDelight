package lcyzsdh.coffee_delight.worldgen;

import lcyzsdh.coffee_delight.CoffeeDelight;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifier {
    public static final ResourceKey<BiomeModifier> ADD_COFFEE_BUSH=ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(CoffeeDelight.MODID,"add_coffee_bush"));

    public static void bootstrap(BootstrapContext<BiomeModifier> pContext){
        var placedFeatures=pContext.lookup(Registries.PLACED_FEATURE);
        var biomes=pContext.lookup(Registries.BIOME);
        pContext.register(ADD_COFFEE_BUSH,new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.HAS_DESERT_PYRAMID),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacement.COFFEE_BUSH)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }
}
