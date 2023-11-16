package club.someoneice.cofe_delight.init;

import club.someoneice.cofe_delight.CoffeeDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TabInit {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CoffeeDelight.MODID);

    public static final RegistryObject<CreativeModeTab> COFFEE_TAB = TABS.register(CoffeeDelight.MODID, () -> CreativeModeTab.builder()
            .title(Component.translatable("item_group." + CoffeeDelight.MODID))
            .icon(() -> new ItemStack(ItemInit.COFFEE_PIE_SIDE.get()))
            .displayItems((params, output) -> {
                ItemInit.ITEMS.getEntries().forEach(it -> { output.accept(it.get()); });
            })
            .build()
    );
}
