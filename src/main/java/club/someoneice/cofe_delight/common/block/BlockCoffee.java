package club.someoneice.cofe_delight.common.block;

import club.someoneice.cofe_delight.init.BlockInit;
import club.someoneice.cofe_delight.util.CupType;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

public class BlockCoffee extends BlockCup {
    float saturation;
    CupType cap;
    @Nonnull MobEffect[] effects;
    int hunger, time, level;

    public BlockCoffee(int hunger, float saturation, CupType cap, @Nullable MobEffect[] effects, int time, int level) {
        this.hunger = hunger;
        this.saturation = saturation;
        this.cap = cap;
        this.effects = Objects.requireNonNullElse(effects, new MobEffect[0]);
        this.time = time;
        this.level = level;
    }

    public BlockCoffee(int hunger, float saturation, CupType cap) {
        this(hunger, saturation, cap, null, 0, 0);
    }

    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        // Fixme - add sugar

        player.playSound(SoundEvents.HONEY_DRINK, 0.4f, 0.7f);
        player.getFoodData().eat(this.hunger, this.saturation);

        for (MobEffect effect : this.effects) {
            player.addEffect(new MobEffectInstance(effect, time, level));
        }

        // if (CoffeeDelight.isFarmersRespitInstall)
        //     player.addEffect(new MobEffectInstance(FREffects.CAFFEINATED.get(), time, level));

        switch (cap) {
            case CUP -> world.setBlockAndUpdate(pos, BlockInit.COFFEE_CUP.get().withPropertiesOf(state));
            case MUG -> world.setBlockAndUpdate(pos, BlockInit.COFFEE_MUG.get().withPropertiesOf(state));
        }

        return InteractionResult.SUCCESS;
    }
}
