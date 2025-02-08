package lcyzsdh.coffee_delight.block;

import com.mojang.serialization.MapCodec;
import lcyzsdh.coffee_delight.block.entity.CoffeePotEntity;
import lcyzsdh.coffee_delight.registry.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockCuccumelaPot extends BlockCoffeePotBase{
    public static final MapCodec<BlockCuccumelaPot> CODEC = simpleCodec(BlockCuccumelaPot::new);

    public BlockCuccumelaPot(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Block.box(4,0,4,12,15,12);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(level.getBlockEntity(pos) instanceof CoffeePotEntity){
            CoffeePotEntity entity = (CoffeePotEntity) level.getBlockEntity(pos);
            if (!entity.isCanCook && player.getItemInHand(hand).is(ItemRegistry.COFFEE_FLOUR.get())) {
                player.getItemInHand(hand).shrink(1);
                entity.setCanCook(true);
            } else if (entity.isCanCook && entity.isFinish) {
                ItemStack itemInHand = player.getItemInHand(hand).copy();
                if (itemInHand.getItem()==ItemRegistry.COFFEE_MAG.get())
                    itemInHand = entity.isFail ? new ItemStack(ItemRegistry.COFFEE_MAP.get("mag_fail_coffee").get()) : new ItemStack(ItemRegistry.COFFEE_MAP.get("mag_double_espresso_coffee").get());
                else if (itemInHand.is(ItemRegistry.COFFEE_CAP.get()))
                    itemInHand = entity.isFail ? new ItemStack(ItemRegistry.COFFEE_MAP.get("cap_fail_coffee").get()) : new ItemStack(ItemRegistry.COFFEE_MAP.get("cap_double_espresso_coffee").get());
                else return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

                entity.setCanCook(false);
                player.getItemInHand(hand).shrink(1);
                player.addItem(itemInHand);
                return ItemInteractionResult.SUCCESS;
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}
