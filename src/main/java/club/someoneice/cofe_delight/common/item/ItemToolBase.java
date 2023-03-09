package club.someoneice.cofe_delight.common.item;

import club.someoneice.cofe_delight.CoffeeDelight;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemToolBase extends Item {
    ItemStack returnItem;

    public ItemToolBase(int damage, ItemStack returnItem) {
        super(new Properties().tab(CoffeeDelight.COFFEE).defaultDurability(damage));
        this.returnItem = returnItem == null ? ItemStack.EMPTY : returnItem;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        if (itemStack.getDamageValue() >= itemStack.getMaxDamage())
            return this.returnItem;
        else {
            itemStack.setDamageValue(itemStack.getDamageValue() + 1);
            return itemStack;
        }
    }

    @Override
    public boolean hasContainerItem(ItemStack stack)
    {
        return true;
    }
}
