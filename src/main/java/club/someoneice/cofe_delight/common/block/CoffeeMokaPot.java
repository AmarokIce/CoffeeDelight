package club.someoneice.cofe_delight.common.block;

import club.someoneice.cofe_delight.init.CoffeeInit;
import club.someoneice.cofe_delight.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CoffeeMokaPot extends CoffeePotBase {
    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (world.getBlockEntity(pos) instanceof CoffeePotBlockEntity entity) {
            if (!entity.isCanCook && player.getItemInHand(hand).is(ItemInit.COFFEE_FLOUR.get())) {
                player.getItemInHand(hand).shrink(1);
                entity.setCanCook(true);
            } else if (entity.isFinish) {
                ItemStack itemInHand = player.getItemInHand(hand).copy();

                if (itemInHand.is(ItemInit.MAG.get()))
                    itemInHand = entity.isFail ? new ItemStack(CoffeeInit.FAIL_COFFEE.getMagItem().get()) : new ItemStack(CoffeeInit.BLACK_COFFEE.getMagItem().get());
                else if (itemInHand.is(ItemInit.CAP.get()))
                    itemInHand = entity.isFail ? new ItemStack(CoffeeInit.FAIL_COFFEE.getCapItem().get()) : new ItemStack(CoffeeInit.BLACK_COFFEE.getCapItem().get());
                else return InteractionResult.PASS;

                entity.setCanCook(false);
                player.getItemInHand(hand).shrink(1);
                player.addItem(itemInHand);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
