package club.someoneice.cofe_delight.common.block;

import club.someoneice.cofe_delight.CoffeeDelight;
import club.someoneice.cofe_delight.init.ItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class CoffeeBush extends SweetBerryBushBlock {
    public CoffeeBush(String name) {
        super(Settings.copy(Blocks.SWEET_BERRY_BUSH));
        Registry.register(Registry.BLOCK, new Identifier(CoffeeDelight.MODID, name), this);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int i = state.get(AGE);
        if (i != 3 && player.getStackInHand(hand).isOf(Items.BONE_MEAL))
            return ActionResult.PASS;
        else if (i > 1) {
            dropStack(world, pos, new ItemStack(ItemInit.COFFEE_BERRIES, 1 + world.random.nextInt(2) + (i != 3 ? 1 : 0)));
            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            world.setBlockState(pos, state.with(AGE, 1), 2);
            return ActionResult.success(world.isClient);
        } else return super.onUse(state, world, pos, player, hand, hit);
    }
}
