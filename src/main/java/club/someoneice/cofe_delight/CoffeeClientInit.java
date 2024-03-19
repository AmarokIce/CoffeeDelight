package club.someoneice.cofe_delight;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import static club.someoneice.cofe_delight.init.BlockInit.COFFEE_BUSH;

@Environment(EnvType.CLIENT)
public class CoffeeClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(COFFEE_BUSH, RenderLayer.getCutout());
    }
}
