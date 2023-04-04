package club.someoneice.cofe_delight.common.block;

import club.someoneice.cofe_delight.init.CoffeeInit;
import club.someoneice.cofe_delight.init.ItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CoffeeCuccumelaPot extends CoffeePotBase {
    public CoffeeCuccumelaPot(String name) {
        super(name);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.getBlockEntity(pos) instanceof CoffeePotBlockEntity entity) {
            if (!entity.isCanCook && player.getStackInHand(hand).isOf(ItemInit.COFFEE_FLOUR)) {
                player.getStackInHand(hand).split(1);
                entity.setCanCook(true);
            } else if (entity.isCanCook && entity.isFinish) {
                ItemStack itemInHand = player.getStackInHand(hand).copy();

                if (itemInHand.isOf(ItemInit.MAG))
                    itemInHand = entity.isFail ? new ItemStack(CoffeeInit.FAIL_COFFEE.getMagItem()) : new ItemStack(CoffeeInit.DOUBLE_ESPRESSO.getMagItem());
                else if (itemInHand.isOf(ItemInit.CAP))
                    itemInHand = entity.isFail ? new ItemStack(CoffeeInit.FAIL_COFFEE.getCapItem()) : new ItemStack(CoffeeInit.DOUBLE_ESPRESSO.getCapItem());
                else return ActionResult.PASS;

                entity.setCanCook(false);
                player.getStackInHand(hand).split(1);
                player.giveItemStack(itemInHand);
                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.SUCCESS;
    }
}
