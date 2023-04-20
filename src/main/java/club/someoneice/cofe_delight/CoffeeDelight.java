package club.someoneice.cofe_delight;

import club.someoneice.cofe_delight.common.gem.ModEvent;
import club.someoneice.cofe_delight.common.gem.WildCoffee;
import club.someoneice.cofe_delight.init.BlockInit;
import club.someoneice.cofe_delight.init.CoffeeInit;
import club.someoneice.cofe_delight.init.ItemInit;
import club.someoneice.cofe_delight.init.TileEntityInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Mod(CoffeeDelight.MODID)
public class CoffeeDelight {
    public static final String MODID = "coffee_delight";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static final boolean isFarmersRespitInstall = FMLLoader.getLoadingModList().getModFileById("farmersrespite") != null;

    public static final CreativeModeTab COFFEE = new CreativeModeTab(CoffeeDelight.MODID) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ItemInit.COFFEE_PIE_SIDE.get());
        }
    };

    public CoffeeDelight() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        TileEntityInit.TILE_ENTITIES.register(bus);

        WildCoffee.FEATURES.register(bus);
        WildCoffee.PATCHES.register(bus);

        new CoffeeInit();

        MinecraftForge.EVENT_BUS.register(new ModEvent());
        MinecraftForge.EVENT_BUS.register(this);
    }
}
