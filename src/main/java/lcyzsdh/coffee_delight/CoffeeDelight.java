package lcyzsdh.coffee_delight;

import lcyzsdh.coffee_delight.registry.BlockEntityRegistry;
import lcyzsdh.coffee_delight.registry.BlockRegistry;
import lcyzsdh.coffee_delight.registry.ItemRegistry;
import lcyzsdh.coffee_delight.registry.ItemTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(CoffeeDelight.MODID)
public class CoffeeDelight {
    public static final String MODID = "coffee_delight";
    public static final Logger LOGGER= LogManager.getLogger(MODID);
    public CoffeeDelight(IEventBus modBus) {
        BlockRegistry.BLOCKS.register(modBus);
        ItemRegistry.ITEMS.register(modBus);
        ItemTab.ITEM_TAB.register(modBus);
        BlockEntityRegistry.BLOCK_ENTITY.register(modBus);
    }
}
