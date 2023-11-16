package club.someoneice.cofe_delight.common.block;

import club.someoneice.cofe_delight.CoffeeDelight;
import club.someoneice.cofe_delight.init.BlockInit;
import club.someoneice.cofe_delight.util.BlockBean;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class BlockCoffee extends BlockCap {
    float saturation;
    BlockBean.CAP cap;
    @Nullable MobEffect[] effects;
    int hunger, time, level;
    boolean hasSugar = false;

    // TODO
    public BlockCoffee(int hunger, float saturation, BlockBean.CAP cap, @Nullable MobEffect[] effects, int time, int level) {
        this.hunger = hunger;
        this.saturation = saturation;
        this.cap = cap;
        this.effects = effects;
        this.time = time;
        this.level = level;
    }

    public BlockCoffee(int hunger, float saturation, BlockBean.CAP cap) {
        this(hunger, saturation, cap, null, 0, 0);
    }

    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (player.getItemInHand(hand).is(Items.SUGAR) && !this.hasSugar) {
            hasSugar = true;
            return InteractionResult.SUCCESS;
        }

        player.playSound(SoundEvents.HONEY_DRINK, 1.0F, 1.0F);
        player.getFoodData().eat(this.hunger, this.saturation);
        if (effects != null)
            for (MobEffect effect : this.effects)
                player.addEffect(new MobEffectInstance(effect, time, level));

        // if (CoffeeDelight.isFarmersRespitInstall)
        //     player.addEffect(new MobEffectInstance(FREffects.CAFFEINATED.get(), time, level));

        if (hasSugar) player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20 * 30, 1));
        switch (cap) {
            case CAP -> world.setBlock(pos, BlockInit.COFFEE_CAP.get().withPropertiesOf(state), 0);
            case  MAG -> world.setBlock(pos, BlockInit.COFFEE_MAG.get().withPropertiesOf(state), 0);
        }

        return InteractionResult.SUCCESS;
    }
}
