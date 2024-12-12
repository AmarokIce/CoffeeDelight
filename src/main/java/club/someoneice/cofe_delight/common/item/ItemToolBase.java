package club.someoneice.cofe_delight.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemToolBase extends Item {
    public ItemToolBase() {
        super(new Properties());
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return this.getDefaultInstance();
    }

    @Override
    public boolean hasCraftingRemainingItem() {
        return true;
    }

}
