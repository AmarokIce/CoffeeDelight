package club.someoneice.cofe_delight.common.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class ItemCoffeePie extends ItemCoffeeBase{
    public ItemCoffeePie(Block block, int hunger, float saturation) {
        super(block, hunger, saturation, ItemStack.EMPTY);
    }

    @Override
    public UseAnim getUseAnimation(@NotNull ItemStack item) {
        return UseAnim.EAT;
    }
}
