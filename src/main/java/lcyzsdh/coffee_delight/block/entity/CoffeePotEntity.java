package lcyzsdh.coffee_delight.block.entity;

import lcyzsdh.coffee_delight.registry.BlockEntityRegistry;
import lcyzsdh.coffee_delight.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.block.entity.HeatableBlockEntity;

public class CoffeePotEntity extends BlockEntity implements HeatableBlockEntity {
    int timer;
    public boolean isCanCook, isFinish, isFail, hasSugar;

    public CoffeePotEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.COFFEE_POT.get(), pos, blockState);
        this.timer = 20 * 10;
        this.isCanCook = false;
        this.isFinish = false;
        this.isFail = false;
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        isCanCook = tag.getBoolean("isCanCook");
        isFinish = tag.getBoolean("isFinish");
        isFinish = tag.getBoolean("isFail");
        hasSugar = tag.getBoolean("hasSugar");
        timer = tag.getInt("time");
        super.loadAdditional(tag, registries);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.putBoolean("isCanCook", isCanCook);
        tag.putBoolean("isFinish", isFinish);
        tag.putBoolean("isFail", isFinish);
        tag.putBoolean("hasSugar", hasSugar);
        tag.putInt("time", timer);
        super.saveAdditional(tag, registries);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        var tag = new CompoundTag();
        tag.putBoolean("isCanCook", isCanCook);
        tag.putBoolean("isFinish", isFinish);
        tag.putBoolean("isFail", isFinish);
        tag.putBoolean("hasSugar", hasSugar);
        tag.putInt("time", timer);
        return tag;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, CoffeePotEntity blockEntity) {
        if (blockEntity.isHeated(level, pos) && blockEntity.isCanCook) {
            blockEntity.timer--;

            if (blockEntity.isFail && level.random.nextFloat() < 0.3F)
                smoke(level, pos);
            else if (blockEntity.isFinish && level.random.nextFloat() < 0.05F)
                smoke(level, pos);
            if (blockEntity.timer <= 0) {
                blockEntity.timer = 20 * 6;
                if (!blockEntity.isFinish) blockEntity.isFinish = true;
                else blockEntity.isFail = true;
            }
        }

        if (!blockEntity.isCanCook) {
            blockEntity.timer = 20 * 10;
            blockEntity.isFail = blockEntity.isFinish = false;
        }
    }

    private static void smoke(Level world, BlockPos pos) {
        if (world.getBlockState(pos).is(BlockRegistry.TURKEY_POT.get()))
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5D + world.random.nextDouble() * 0.3D - 0.2D, pos.getY() + 0.6D, pos.getZ() + 0.5D + world.random.nextDouble() * 0.3D - 0.2D, 0.0D, 0.0D, 0.0D);
        else if (world.getBlockState(pos).is(BlockRegistry.MOKA_POT.get()))
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5D + world.random.nextDouble() * 0.3D - 0.2D, pos.getY() + 0.856D, pos.getZ() + 0.5D + world.random.nextDouble() * 0.3D - 0.2D, 0.0D, 0.0D, 0.0D);
        else
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5D + world.random.nextDouble() * 0.3D - 0.2D, pos.getY() + 1.0D, pos.getZ() + 0.5D + world.random.nextDouble() * 0.3D - 0.2D, 0.0D, 0.0D, 0.0D);
    }
    public void putSugar() {
        this.hasSugar = true;
    }

    public boolean hasSugar() {
        return this.hasSugar;
    }

    public void setCanCook(boolean canCook) {
        this.isCanCook = canCook;
    }
}