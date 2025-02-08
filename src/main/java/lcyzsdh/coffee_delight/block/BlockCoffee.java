package lcyzsdh.coffee_delight.block;

import lcyzsdh.coffee_delight.registry.BlockRegistry;
import lcyzsdh.coffee_delight.util.CoffeeType;
import lcyzsdh.coffee_delight.util.CupType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BlockCoffee extends BlockCap{
    float saturation;
    CupType cap;
    Holder<MobEffect>[] effects;
    int hunger, time, stage;
    boolean hasSugar = false;

    public BlockCoffee(CoffeeType type, CupType cap) {
        this.hunger = type.getHunger();
        this.saturation = type.getSaturation();
        this.cap = cap;
        this.effects = type.getEffects();
        this.time = type.getEffectTime();
        this.stage = type.getEffectLevel();
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(player.getItemInHand(hand).is(Items.SUGAR) && !this.hasSugar){
            hasSugar = true;
            return ItemInteractionResult.SUCCESS;
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        player.playSound(SoundEvents.HONEY_DRINK, 1.0F, 1.0F);
        player.getFoodData().eat(this.hunger, this.saturation);
        if (effects != null)
            for (Holder<MobEffect> effect : this.effects)
                player.addEffect(new MobEffectInstance(effect, time, stage));

        if (hasSugar) player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20 * 30, 1));
        switch (cap) {
            case CAP -> level.setBlock(pos, BlockRegistry.COFFEE_CAP.get().withPropertiesOf(state), 0);
            case MAG -> level.setBlock(pos, BlockRegistry.COFFEE_MAG.get().withPropertiesOf(state), 0);
        }

        return InteractionResult.SUCCESS;
    }
}
