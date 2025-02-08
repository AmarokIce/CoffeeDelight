package lcyzsdh.coffee_delight.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ItemClever extends Item {
    public ItemClever() {
        super(new Properties().durability(20));
    }

    @Override
    public @NotNull ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack stack = itemStack.copy();
        stack.setDamageValue(stack.getDamageValue() + 1);
        return stack;
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }
}
