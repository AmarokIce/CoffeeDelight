package lcyzsdh.coffee_delight.data;

import lcyzsdh.coffee_delight.CoffeeDelight;
import lcyzsdh.coffee_delight.worldgen.ModBiomeModifier;
import lcyzsdh.coffee_delight.worldgen.ModFeatures;
import lcyzsdh.coffee_delight.worldgen.ModPlacement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldgenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacement::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifier::bootstrap);

    public ModWorldgenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(CoffeeDelight.MODID));
    }
}
