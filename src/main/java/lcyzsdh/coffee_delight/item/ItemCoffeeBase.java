package lcyzsdh.coffee_delight.item;

import lcyzsdh.coffee_delight.util.CoffeeType;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
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
import java.util.Optional;

public class ItemCoffeeBase extends BlockItem {
    ItemStack returnItem;
    Holder<MobEffect>[] effects;
    int time, level;

    public ItemCoffeeBase(Block block, CoffeeType type,ItemStack returnItem) {
        super(block, new Properties().food(new FoodProperties.Builder().nutrition(type.getHunger()).saturationModifier(type.getSaturation()).alwaysEdible().build()).stacksTo(1));
        this.returnItem = returnItem == null ? ItemStack.EMPTY : returnItem;
        this.effects = type.getEffects();
        this.time = type.getEffectTime();
        this.level = type.getEffectLevel();
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
    public ItemStack finishUsingItem(ItemStack item, Level world, LivingEntity user) {
        super.finishUsingItem(item, world, user);
        if (user instanceof Player player) {
            player.addItem(returnItem.copy());
            if (this.effects != null)
                for (Holder<MobEffect> effect : effects)
                    player.addEffect(new MobEffectInstance(effect, time, level));
        }
        return item;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("cofe.putOrEat.message"));
    }
}
