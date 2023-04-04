package club.someoneice.cofe_delight.common.block;

import club.someoneice.cofe_delight.CoffeeDelight;
import net.minecraft.block.*;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockCap extends Block {
    public static final IntProperty AMOUNT = IntProperty.of("amount", 1, 3);
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public BlockCap(String name) {
        super(Settings.of(Material.GLASS));
        Registry.register(Registry.BLOCK, new Identifier(CoffeeDelight.MODID, name), this);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        var item = new ItemStack(this);
        var itemEntity = new ItemEntity(world, pos.getX(), pos.getY() + 0.5F, pos.getZ(), item);
        world.spawnEntity(itemEntity);
    }

    @Nullable
    @Override
    public @org.jetbrains.annotations.Nullable BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(FACING, context.getPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AMOUNT, FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(6, 0, 6, 10, 6, 10);
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
