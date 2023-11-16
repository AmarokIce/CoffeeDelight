package club.someoneice.cofe_delight.common.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class ItemDrinkWithEffectBase extends ItemDrinkBase {
    MobEffect[] effects;
    int time;
    int level;

    public ItemDrinkWithEffectBase(Properties properties, ItemStack returnItem, UseAnim anim, MobEffect[] effects, int time, int level) {
        super(properties, returnItem, anim);
        this.effects = effects;
        this.time = time;
        this.level = level;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack item, Level world, LivingEntity player) {
        super.finishUsingItem(item, world, player);
        if (player instanceof Player && this.effects != null)
            for (MobEffect effect : effects)
                player.addEffect(new MobEffectInstance(effect, time, level));

        return item;
    }
}
