package club.someoneice.cofe_delight.common.item;

import club.someoneice.cofe_delight.CoffeeDelight;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class ItemCoffeeBase extends BlockItem {
    ItemStack returnItem;
    MobEffect[] effects;
    int time, level;

    public ItemCoffeeBase(Block block, int hunger, float saturation, ItemStack returnItem, MobEffect[] effects, int time, int level) {
        super(block, new Properties().tab(CoffeeDelight.COFFEE).food(new FoodProperties.Builder().nutrition(hunger).saturationMod(saturation).alwaysEat().build()));
        this.returnItem = returnItem == null ? ItemStack.EMPTY : returnItem;
        this.effects = effects;
        this.time = time;
        this.level = level;
    }

    public ItemCoffeeBase(Block block, int hunger, float saturation, ItemStack returnItem) {
        this(block, hunger, saturation, returnItem, null, 0, 0);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getPlayer().isShiftKeyDown()) {
            return super.useOn(context);
        } else return InteractionResult.PASS;
    }

    @Override
    public UseAnim getUseAnimation(@NotNull ItemStack item) {
        return UseAnim.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack item, Level world, LivingEntity player) {
        super.finishUsingItem(item, world, player);
        if (player instanceof Player && this.returnItem != ItemStack.EMPTY) {
            ((Player) player).addItem(returnItem);
            if (this.effects != null)
                for (MobEffect effect : effects)
                    player.addEffect(new MobEffectInstance(effect, time, level));
        }

        return item;
    }

    public void appendHoverText(ItemStack item, @Nullable Level world, List<Component> list, TooltipFlag flag) {
        list.add(new TranslatableComponent("cofe.putOrEat.message"));
    }
}
