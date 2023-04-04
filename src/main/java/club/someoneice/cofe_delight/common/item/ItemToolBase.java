package club.someoneice.cofe_delight.common.item;

import club.someoneice.cofe_delight.CoffeeDelight;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemToolBase extends Item {
    ItemStack returnItem;

    public ItemToolBase(String name, int damage, ItemStack returnItem) {
        super(new Settings().group(CoffeeDelight.COFFEE).maxDamage(damage));
        this.returnItem = returnItem == null ? ItemStack.EMPTY : returnItem;
        Registry.register(Registry.ITEM, new Identifier(CoffeeDelight.MODID, name), this);
    }
}
