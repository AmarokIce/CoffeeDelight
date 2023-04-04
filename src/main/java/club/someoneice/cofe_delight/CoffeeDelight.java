package club.someoneice.cofe_delight;

import club.someoneice.cofe_delight.common.gem.WildCoffee;
import club.someoneice.cofe_delight.init.BlockInit;
import club.someoneice.cofe_delight.init.ItemInit;
import club.someoneice.cofe_delight.init.TileEntityInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CoffeeDelight implements ModInitializer {
    public static final String MODID = "coffee_delight";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public static final ItemGroup COFFEE = FabricItemGroupBuilder.create(new Identifier(CoffeeDelight.MODID, CoffeeDelight.MODID)).icon(() -> new ItemStack(ItemInit.COFFEE_PIE_SIDE)).build();


    @Override
    public void onInitialize() {
        new ItemInit();
        new BlockInit();
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(CoffeeDelight.MODID, "coffee_pot"), TileEntityInit.COFFEE_POT);

        WildCoffee.register();
    }
}
