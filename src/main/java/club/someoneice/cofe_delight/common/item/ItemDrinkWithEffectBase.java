package club.someoneice.cofe_delight.common.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class ItemDrinkWithEffectBase extends ItemDrinkBase {
    StatusEffect[] effects;
    int time;
    int level;

    public ItemDrinkWithEffectBase(String name, Settings properties, ItemStack returnItem, UseAction anim, StatusEffect[] effects, int time, int level) {
        super(name, properties, returnItem, anim);
        this.effects = effects;
        this.time = time;
        this.level = level;
    }

    @Override
    public ItemStack finishUsing(ItemStack item, World world, LivingEntity user) {
        super.finishUsing(item, world, user);
        if (user instanceof PlayerEntity player && this.effects != null) for (StatusEffect effect : effects)
            player.addStatusEffect(new StatusEffectInstance(effect, time, level));

        return item;
    }
}
