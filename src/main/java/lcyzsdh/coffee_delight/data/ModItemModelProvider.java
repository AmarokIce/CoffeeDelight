package lcyzsdh.coffee_delight.data;

import lcyzsdh.coffee_delight.registry.BlockRegistry;
import lcyzsdh.coffee_delight.registry.ItemRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.basicItem(ItemRegistry.COFFEE_BERRIES.get());
        this.basicItem(ItemRegistry.COFFEE_BEANS.get());
        this.basicItem(ItemRegistry.COFFEE_BEANS_COOKED.get());
        this.basicItem(ItemRegistry.COFFEE_FLOUR.get());
        this.basicItem(ItemRegistry.COFFEE_PIE_SIDE.get());
        this.basicItem(ItemRegistry.QUICHE.get());
        this.basicItem(ItemRegistry.WAFER.get());
        this.basicItem(ItemRegistry.COFFEE_WAFER.get());
        this.basicItem(ItemRegistry.BERRIES_WAFER.get());
        this.basicItem(ItemRegistry.COFFEE_PIE.get());
        this.basicItem(ItemRegistry.CUCCUMELA_POT.get());
        this.basicItem(ItemRegistry.CUCCUMELA_BOTTOM.get());
        this.basicItem(ItemRegistry.CUCCUMELA_TOP.get());
        this.simpleBlockItem(BlockRegistry.COFFEE_BLOCK.get());
        this.basicItem(ItemRegistry.COFFEE_CAP.get());
        this.basicItem(ItemRegistry.COFFEE_MAG.get());
        this.basicItem(ItemRegistry.CLEVER.get());
        for(var items:ItemRegistry.COFFEE_MAP.values()){
            ResourceLocation res=Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(items.get()));
            if(items.getRegisteredName().contains("cap_")){
                getBuilder(res.toString())
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", ResourceLocation.fromNamespaceAndPath(res.getNamespace(), "item/cap_with_coffee"));
            }
            else {
                getBuilder(res.toString())
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", ResourceLocation.fromNamespaceAndPath(res.getNamespace(), "item/mag_with_coffee"));
            }
        }
        this.basicItem(ItemRegistry.MOKA_POT.get());
        this.basicItem(ItemRegistry.MOKA_BOTTOM.get());
        this.basicItem(ItemRegistry.MOKA_TOP.get());
        this.basicItem(ItemRegistry.TURKEY_HANDEL.get());
        this.basicItem(ItemRegistry.TURKEY_POT.get());
        this.basicItem(ItemRegistry.TURKEY_POT_PART.get());
    }
}
