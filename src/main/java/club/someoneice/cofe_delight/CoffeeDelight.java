package club.someoneice.cofe_delight;

import club.someoneice.cofe_delight.init.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CoffeeDelight.MODID)
public class CoffeeDelight {
    public static final String MODID = "coffee_delight";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    // public static final boolean isFarmersRespitInstall = FMLLoader.getLoadingModList().getModFileById("farmersrespite") != null;

    public CoffeeDelight() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        TileEntityInit.TILE_ENTITIES.register(bus);
        TabInit.TABS.register(bus);

        // WildCoffee.FEATURES.register(bus);
        // WildCoffee.PATCHES.register(bus);

        new CoffeeInit();

        MinecraftForge.EVENT_BUS.register(this);
        bus.register(this);
    }
}
