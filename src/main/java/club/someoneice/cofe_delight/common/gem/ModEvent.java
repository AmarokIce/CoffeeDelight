package club.someoneice.cofe_delight.common.gem;

import club.someoneice.cofe_delight.CoffeeDelight;
import club.someoneice.cofe_delight.init.BlockInit;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = CoffeeDelight.MODID)
public class ModEvent {
    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        if (event.getCategory().equals(Biome.BiomeCategory.DESERT)) event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WildCoffee.PATCH_WILD_COFFEE.getHolder().get());
    }
}
