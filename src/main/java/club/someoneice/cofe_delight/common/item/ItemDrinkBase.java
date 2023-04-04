package club.someoneice.cofe_delight.common.item;

import club.someoneice.cofe_delight.CoffeeDelight;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.UseAction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class ItemDrinkBase extends Item {
    ItemStack returnItem;
    UseAction anim;

    public ItemDrinkBase(String name, Item.Settings properties, ItemStack returnItem, UseAction anim) {
        super(properties);
        this.returnItem = returnItem == null ? ItemStack.EMPTY : returnItem;
        this.anim = anim == null ? UseAction.EAT : anim;

        Registry.register(Registry.ITEM, new Identifier(CoffeeDelight.MODID, name), this);
    }

    @Override
    public UseAction getUseAction(@NotNull ItemStack item) {
        return anim;
    }

    @Override
    public ItemStack finishUsing(ItemStack item, World world, LivingEntity user) {
        super.finishUsing(item, world, user);
        if (user instanceof PlayerEntity entity && this.returnItem != ItemStack.EMPTY) entity.giveItemStack(returnItem);
        return item;
    }
}
