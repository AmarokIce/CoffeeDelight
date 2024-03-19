package club.someoneice.cofe_delight.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;
import org.jetbrains.annotations.NotNull;

public class ItemCoffeePie extends ItemCoffeeBase {
    public ItemCoffeePie(String name, Block block, int hunger, float saturation) {
        super(name, block, hunger, saturation, ItemStack.EMPTY);
    }

    @Override
    public UseAction getUseAction(@NotNull ItemStack item) {
        return UseAction.EAT;
    }
}
