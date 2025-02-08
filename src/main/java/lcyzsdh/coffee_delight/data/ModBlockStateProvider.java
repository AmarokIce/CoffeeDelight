package lcyzsdh.coffee_delight.data;

import lcyzsdh.coffee_delight.CoffeeDelight;
import lcyzsdh.coffee_delight.block.BlockCap;
import lcyzsdh.coffee_delight.block.BlockCoffeeBush;
import lcyzsdh.coffee_delight.block.BlockCuccumelaPot;
import lcyzsdh.coffee_delight.registry.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.block.PieBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    private static final int DEFAULT_ANGLE_OFFSET = 180;
    public ModBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //coffee bush
        ModelFile model1=this.models().withExistingParent("coffee_bush_stage0","block/cross").texture("cross", ResourceLocation.fromNamespaceAndPath(CoffeeDelight.MODID,"block/coffee_bush_stage0")).renderType("cutout");
        ModelFile model2=this.models().withExistingParent("coffee_bush_stage1","block/cross").texture("cross", ResourceLocation.fromNamespaceAndPath(CoffeeDelight.MODID,"block/coffee_bush_stage1")).renderType("cutout");
        ModelFile model3=this.models().withExistingParent("coffee_bush_stage2","block/cross").texture("cross", ResourceLocation.fromNamespaceAndPath(CoffeeDelight.MODID,"block/coffee_bush_stage2")).renderType("cutout");
        ModelFile model4=this.models().withExistingParent("coffee_bush_stage3","block/cross").texture("cross", ResourceLocation.fromNamespaceAndPath(CoffeeDelight.MODID,"block/coffee_bush_stage3")).renderType("cutout");
        getVariantBuilder(BlockRegistry.COFFEE_BUSH.get())
                .forAllStates(state -> {
                    int age = state.getValue(BlockCoffeeBush.AGE);
                    return ConfiguredModel.builder()
                            .modelFile(age == 0 ? model1 : age == 1 ? model2 : age == 2 ? model3 : model4)
                            .build();
                });

        //coffee pie
        ModelFile model5=this.models().withExistingParent("coffee_pie",ResourceLocation.fromNamespaceAndPath(FarmersDelight.MODID,"pie"))
                .texture("particle","coffee_delight:block/coffee_pie_top")
                .texture("bottom","coffee_delight:block/pie_bottom")
                .texture("side","coffee_delight:block/pie_side")
                .texture("top","coffee_delight:block/coffee_pie_top");
        ModelFile model6=this.models().withExistingParent("coffee_pie_slice1",ResourceLocation.fromNamespaceAndPath(FarmersDelight.MODID,"block/pie_slice1"))
                .texture("particle","coffee_delight:block/coffee_pie_top")
                .texture("bottom","coffee_delight:block/pie_bottom")
                .texture("inner","coffee_delight:block/coffee_pie_inner")
                .texture("side","coffee_delight:block/pie_side")
                .texture("top","coffee_delight:block/coffee_pie_top");
        ModelFile model7=this.models().withExistingParent("coffee_pie_slice2",ResourceLocation.fromNamespaceAndPath(FarmersDelight.MODID,"block/pie_slice2"))
                .texture("particle","coffee_delight:block/coffee_pie_top")
                .texture("bottom","coffee_delight:block/pie_bottom")
                .texture("inner","coffee_delight:block/coffee_pie_inner")
                .texture("side","coffee_delight:block/pie_side")
                .texture("top","coffee_delight:block/coffee_pie_top");
        ModelFile model8=this.models().withExistingParent("coffee_pie_slice3",ResourceLocation.fromNamespaceAndPath(FarmersDelight.MODID,"block/pie_slice3"))
                .texture("particle","coffee_delight:block/coffee_pie_top")
                .texture("bottom","coffee_delight:block/pie_bottom")
                .texture("inner","coffee_delight:block/coffee_pie_inner")
                .texture("side","coffee_delight:block/pie_side")
                .texture("top","coffee_delight:block/coffee_pie_top");
        getVariantBuilder(BlockRegistry.COFFEE_PIE.get())
                .forAllStates(state -> {
                    int slices=state.getValue(PieBlock.BITES);
                    return ConfiguredModel.builder()
                            .modelFile(slices == 0 ? model5 :slices == 1 ? model6 : slices == 2 ? model7 : model8)
                            .rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + DEFAULT_ANGLE_OFFSET) % 360)
                            .build();
                });

        //cuccumela pot
        getVariantBuilder(BlockRegistry.CUCCUMELA_POT.get())
                .forAllStates(state -> {
                    return ConfiguredModel.builder()
                            .modelFile(models().getExistingFile(ResourceLocation.fromNamespaceAndPath(CoffeeDelight.MODID,"block/cuccumela_pot")))
                            .rotationY(((int) state.getValue(BlockCuccumelaPot.FACING).toYRot() + DEFAULT_ANGLE_OFFSET) % 360)
                            .build();
                });
        getVariantBuilder(BlockRegistry.MOKA_POT.get())
                .forAllStates(state -> {
                    return ConfiguredModel.builder()
                            .modelFile(models().getExistingFile(ResourceLocation.fromNamespaceAndPath(CoffeeDelight.MODID,"block/moka_pot")))
                            .rotationY(((int) state.getValue(BlockCuccumelaPot.FACING).toYRot() + DEFAULT_ANGLE_OFFSET) % 360)
                            .build();
                });
        getVariantBuilder(BlockRegistry.TURKEY_POT.get())
                .forAllStates(state -> {
                    return ConfiguredModel.builder()
                            .modelFile(models().getExistingFile(ResourceLocation.fromNamespaceAndPath(CoffeeDelight.MODID,"block/turkey_pot")))
                            .rotationY(((int) state.getValue(BlockCuccumelaPot.FACING).toYRot() + DEFAULT_ANGLE_OFFSET) % 360)
                            .build();
                });
        ModelFile model9=this.models().withExistingParent("coffee_block","block/cube")
                .texture("particle","coffee_delight:block/coffee_bag_top")
                .texture("down","coffee_delight:block/bag_bottom")
                .texture("up","coffee_delight:block/coffee_bag_top")
                .texture("north","coffee_delight:block/bag_side_tied")
                .texture("south","coffee_delight:block/bag_side_tied")
                .texture("west","coffee_delight:block/bag_side")
                .texture("east","coffee_delight:block/bag_side");
        this.simpleBlock(BlockRegistry.COFFEE_BLOCK.get(),model9);
        getVariantBuilder(BlockRegistry.COFFEE_CAP.get())
                .forAllStates(state -> {
                    return ConfiguredModel.builder()
                            .modelFile(models().getExistingFile(ResourceLocation.fromNamespaceAndPath(CoffeeDelight.MODID,"block/cap")))
                            .rotationY(((int) state.getValue(BlockCap.FACING).toYRot() + DEFAULT_ANGLE_OFFSET) % 360)
                            .build();
                });
        getVariantBuilder(BlockRegistry.COFFEE_MAG.get())
                .forAllStates(state -> {
                    return ConfiguredModel.builder()
                            .modelFile(models().getExistingFile(ResourceLocation.fromNamespaceAndPath(CoffeeDelight.MODID,"block/mag")))
                            .rotationY(((int) state.getValue(BlockCap.FACING).toYRot() + DEFAULT_ANGLE_OFFSET) % 360)
                            .build();
                });

        for(var block:BlockRegistry.COFFEE_MAP.values()){
            if(block.getRegisteredName().contains("cap")){
                getVariantBuilder(block.get())
                        .forAllStates(state -> {
                            return ConfiguredModel.builder()
                                    .modelFile(models().getExistingFile(ResourceLocation.fromNamespaceAndPath(CoffeeDelight.MODID,"block/cap_with_coffee")))
                                    .rotationY(((int) state.getValue(BlockCap.FACING).toYRot() + DEFAULT_ANGLE_OFFSET) % 360)
                                    .build();
                        });
            }
            else{
                getVariantBuilder(block.get())
                        .forAllStates(state -> {
                            return ConfiguredModel.builder()
                                    .modelFile(models().getExistingFile(ResourceLocation.fromNamespaceAndPath(CoffeeDelight.MODID,"block/mag_with_coffee")))
                                    .rotationY(((int) state.getValue(BlockCap.FACING).toYRot() + DEFAULT_ANGLE_OFFSET) % 360)
                                    .build();
                        });
            }
        }
    }

}
