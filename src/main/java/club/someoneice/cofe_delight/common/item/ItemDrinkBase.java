package club.someoneice.cofe_delight.common.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ItemDrinkBase extends Item {
    ItemStack returnItem;
    UseAnim anim;

    public ItemDrinkBase(Properties properties, ItemStack returnItem, UseAnim anim) {
        super(properties);
        this.returnItem = returnItem == null ? ItemStack.EMPTY : returnItem;
        this.anim = anim == null ? UseAnim.EAT : anim;
    }

    @Override
    public UseAnim getUseAnimation(@NotNull ItemStack item) {
        return anim;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack item, Level world, LivingEntity player) {
        super.finishUsingItem(item, world, player);
        if (player instanceof Player && this.returnItem != ItemStack.EMPTY)
            ((Player) player).addItem(returnItem);

        return item;
    }
}
