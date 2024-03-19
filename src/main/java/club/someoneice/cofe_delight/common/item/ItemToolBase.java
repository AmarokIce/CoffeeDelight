package club.someoneice.cofe_delight.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemToolBase extends Item {
    ItemStack returnItem;

    public ItemToolBase(int damage, ItemStack returnItem) {
        super(new Settings().maxDamage(damage));
        this.returnItem = returnItem == null ? ItemStack.EMPTY : returnItem;
    }
}
