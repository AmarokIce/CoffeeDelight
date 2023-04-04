package club.someoneice.cofe_delight.common.block;

import club.someoneice.cofe_delight.init.CoffeeInit;
import club.someoneice.cofe_delight.init.ItemInit;
import club.someoneice.cofe_delight.util.Coffee;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CoffeeTurkeyPot extends CoffeePotBase {
    public CoffeeTurkeyPot(String name) {
        super(name);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.getBlockEntity(pos) instanceof CoffeePotBlockEntity entity) {
            if (!entity.isCanCook && player.getStackInHand(hand).isOf(ItemInit.COFFEE_FLOUR)) {
                player.getStackInHand(hand).split(1);
                entity.setCanCook(true);
            } else if (entity.isCanCook && player.getStackInHand(hand).isOf(Items.SUGAR)) {
                player.getStackInHand(hand).split(1);
                entity.putSugar();
            } else if (entity.isCanCook && entity.isFinish) {
                ItemStack itemInHand = player.getStackInHand(hand).copy();

                Coffee coffee = entity.hasSugar() ? CoffeeInit.TURKEY_COFFEE : CoffeeInit.ARABICA_COFFEE;

                if (itemInHand.isOf(ItemInit.MAG))
                    itemInHand = entity.isFail ? new ItemStack(CoffeeInit.FAIL_COFFEE.getMagItem()) : new ItemStack(coffee.getMagItem());
                else if (itemInHand.isOf(ItemInit.CAP))
                    itemInHand = entity.isFail ? new ItemStack(CoffeeInit.FAIL_COFFEE.getCapItem()) : new ItemStack(coffee.getCapItem());
                else return ActionResult.PASS;

                entity.setCanCook(false);
                player.getStackInHand(hand).split(1);
                player.giveItemStack(itemInHand);
            }
        }

        return ActionResult.SUCCESS;
    }
}
