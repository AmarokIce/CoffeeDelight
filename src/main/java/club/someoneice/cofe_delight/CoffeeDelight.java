package club.someoneice.cofe_delight;

import club.someoneice.cofe_delight.init.BlockInit;
import club.someoneice.cofe_delight.init.FeatureInit;
import club.someoneice.cofe_delight.init.ItemInit;
import club.someoneice.cofe_delight.init.TileEntityInit;
import club.someoneice.cofe_delight.util.ItemBean;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CoffeeDelight implements ModInitializer {
    public static final String MODID = "coffee_delight";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @Override
    public void onInitialize() {
        new ItemInit();
        new BlockInit();

        Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CoffeeDelight.MODID, "coffee_pot"), TileEntityInit.COFFEE_POT);


        var groupId = new Identifier(CoffeeDelight.MODID, CoffeeDelight.MODID);
        ItemGroup COFFEE = FabricItemGroup.builder().displayName(Text.translatable(groupId.toString()))
                .icon(() -> new ItemStack(ItemInit.COFFEE_PIE_SIDE))
                .entries(((displayContext, entries) -> ItemBean.ITEMS.forEach(entries::add))).build();
        Registry.register(Registries.ITEM_GROUP, groupId, COFFEE);

        FeatureInit.boot();
    }
}
