package club.someoneice.cofe_delight.common.item;

import club.someoneice.cofe_delight.CoffeeDelight;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.UseAction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemCoffeeBase extends BlockItem {
    ItemStack returnItem;
    StatusEffect[] effects;
    int time, level;

    public ItemCoffeeBase(String name, Block block, int hunger, float saturation, ItemStack returnItem, StatusEffect[] effects, int time, int level) {
        super(block, new Item.Settings().group(CoffeeDelight.COFFEE).food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).alwaysEdible().build()));
        this.returnItem = returnItem == null ? ItemStack.EMPTY : returnItem;
        this.effects = effects;
        this.time = time;
        this.level = level;

        Registry.register(Registry.ITEM, new Identifier(CoffeeDelight.MODID, name), this);
    }

    public ItemCoffeeBase(String name, Block block, int hunger, float saturation, ItemStack returnItem) {
        this(name, block, hunger, saturation, returnItem, null, 0, 0);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getPlayer().isSneaking()) {
            return super.useOnBlock(context);
        } else return ActionResult.PASS;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public ItemStack finishUsing(ItemStack item, World world, LivingEntity user) {
        super.finishUsing(item, world, user);
        if (user instanceof PlayerEntity player && this.returnItem != ItemStack.EMPTY) {
            player.giveItemStack(returnItem);
            if (this.effects != null)
                for (StatusEffect effect : effects)
                    player.addStatusEffect(new StatusEffectInstance(effect, time, level));
        }

        return item;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("cofe.putOrEat.message"));
    }
}
