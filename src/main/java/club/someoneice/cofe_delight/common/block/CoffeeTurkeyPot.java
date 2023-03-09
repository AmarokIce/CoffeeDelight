package club.someoneice.cofe_delight.common.block;

import club.someoneice.cofe_delight.init.CoffeeInit;
import club.someoneice.cofe_delight.init.ItemInit;
import club.someoneice.cofe_delight.util.Coffee;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class CoffeeTurkeyPot extends CoffeePotBase {
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CoffeePotBlockEntity(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (world.getBlockEntity(pos) instanceof CoffeePotBlockEntity entity) {
            if (!entity.isCanCook && player.getItemInHand(hand).is(ItemInit.COFFEE_FLOUR.get())) {
                player.getItemInHand(hand).shrink(1);
                entity.setCanCook(true);
            } else if (entity.isCanCook && player.getItemInHand(hand).is(Items.SUGAR)) {
                player.getItemInHand(hand).shrink(1);
                entity.putSugar();
            } else if (entity.isCanCook && entity.isFinish) {
                ItemStack itemInHand = player.getItemInHand(hand).copy();

                Coffee coffee = entity.hasSugar() ? CoffeeInit.TURKEY_COFFEE : CoffeeInit.ARABICA_COFFEE;

                if (itemInHand.is(ItemInit.MAG.get()))
                    itemInHand = entity.isFail ? new ItemStack(CoffeeInit.FAIL_COFFEE.getMagItem().get()) : new ItemStack(coffee.getMagItem().get());
                else if (itemInHand.is(ItemInit.CAP.get()))
                    itemInHand = entity.isFail ? new ItemStack(CoffeeInit.FAIL_COFFEE.getCapItem().get()) : new ItemStack(coffee.getCapItem().get());
                else return InteractionResult.PASS;

                entity.setCanCook(false);
                player.getItemInHand(hand).shrink(1);
                player.addItem(itemInHand);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
