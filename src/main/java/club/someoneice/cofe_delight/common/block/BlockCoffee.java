package club.someoneice.cofe_delight.common.block;

import club.someoneice.cofe_delight.init.BlockInit;
import club.someoneice.cofe_delight.util.BlockBean;
import net.minecraft.block.BlockState;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlockCoffee extends BlockCap {
    float saturation;
    BlockBean.CAP cap;
    @Nullable StatusEffect[] effects;
    int hunger, time, level;
    boolean hasSugar = false;

    // TODO
    public BlockCoffee(String name, int hunger, float saturation, BlockBean.CAP cap, @Nullable StatusEffect[] effects, int time, int level) {
        super(name);
        this.hunger = hunger;
        this.saturation = saturation;
        this.cap = cap;
        this.effects = effects;
        this.time = time;
        this.level = level;
    }

    public BlockCoffee(String name, int hunger, float saturation, BlockBean.CAP cap) {
        this(name, hunger, saturation, cap, null, 0, 0);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getStackInHand(hand).isOf(Items.SUGAR) && !this.hasSugar) {
            hasSugar = true;
            return ActionResult.SUCCESS;
        }

        player.playSound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.0F, 1.0F);
        player.getHungerManager().add(this.hunger, this.saturation);
        if (effects != null)
            for (StatusEffect effect : this.effects)
                player.addStatusEffect(new StatusEffectInstance(effect, time, level));

        if (hasSugar) player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 30, 1));
        switch (cap) {
            case CAP -> world.setBlockState(pos, BlockInit.COFFEE_CAP.getDefaultState(), 0);
            case  MAG -> world.setBlockState(pos, BlockInit.COFFEE_MAG.getDefaultState(), 0);
        }

        return ActionResult.SUCCESS;
    }
}
