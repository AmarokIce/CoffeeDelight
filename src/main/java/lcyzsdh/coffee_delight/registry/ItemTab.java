package lcyzsdh.coffee_delight.registry;

import lcyzsdh.coffee_delight.CoffeeDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ItemTab {
    public static final DeferredRegister<CreativeModeTab> ITEM_TAB=DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CoffeeDelight.MODID);

    public static final Supplier<CreativeModeTab> CD_TAB=ITEM_TAB.register("coffee_delight_tab",()-> CreativeModeTab.builder()
            .icon(()->new ItemStack(ItemRegistry.COFFEE_BERRIES.get()))
            .title(Component.translatable("itemGroup."+CoffeeDelight.MODID))
            .displayItems((pParams,pOutput)->{
                ItemRegistry.ITEMS.getEntries().forEach(item-> pOutput.accept(item.get()));
            })
            .build());
}
