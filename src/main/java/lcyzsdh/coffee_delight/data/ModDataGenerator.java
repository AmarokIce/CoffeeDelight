package lcyzsdh.coffee_delight.data;

import lcyzsdh.coffee_delight.CoffeeDelight;
import lcyzsdh.coffee_delight.data.lootable.ModBlockLootSubProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = "coffee_delight",bus = EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output=generator.getPackOutput();
        var lp=event.getLookupProvider();
        ExistingFileHelper existingFileHelper=event.getExistingFileHelper();

        generator.addProvider(event.includeServer(), new ModWorldgenProvider(output, lp));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(output, CoffeeDelight.MODID,existingFileHelper));
        generator.addProvider(event.includeClient(),new ModItemModelProvider(output, CoffeeDelight.MODID, existingFileHelper));
        generator.addProvider(event.includeServer(),new ModRecipeProvider(output,lp));
        generator.addProvider(event.includeServer(),new ModLootTableProvider(output,lp));
    }
}
