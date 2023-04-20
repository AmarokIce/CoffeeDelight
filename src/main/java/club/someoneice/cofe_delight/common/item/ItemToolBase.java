package club.someoneice.cofe_delight.common.item;

import club.someoneice.cofe_delight.CoffeeDelight;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemToolBase extends Item {
    public ItemToolBase() {
        super(new Properties().tab(CoffeeDelight.COFFEE));
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return this.getDefaultInstance();
    }

    @Override
    public boolean hasContainerItem(ItemStack stack)
    {
        return true;
    }
}
