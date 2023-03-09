package club.someoneice.cofe_delight.common.block;

import club.someoneice.cofe_delight.init.TileEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.block.entity.HeatableBlockEntity;

public class CoffeePotBlockEntity extends BlockEntity implements HeatableBlockEntity {
    int timer;
    public boolean isCanCook, isFinish, isFail, hasSugar;

    public CoffeePotBlockEntity(BlockPos pos, BlockState state) {
        super(TileEntityInit.COFFEE_POT.get(), pos, state);
        this.timer = 20 * 10;
        this.isCanCook = false;
        this.isFinish = false;
        this.isFail = false;
    }

    @Override
    public void load(CompoundTag tag) {
        isCanCook = tag.getBoolean("isCanCook");
        isFinish = tag.getBoolean("isFinish");
        isFinish = tag.getBoolean("isFail");
        hasSugar = tag.getBoolean("hasSugar");
        timer = tag.getInt("time");
        super.load(tag);
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        tag.putBoolean("isCanCook", isCanCook);
        tag.putBoolean("isFinish", isFinish);
        tag.putBoolean("isFail", isFinish);
        tag.putBoolean("hasSugar", hasSugar);
        tag.putInt("time", timer);
        super.saveAdditional(tag);
    }

    @Override
    public CompoundTag getUpdateTag() {
        var tag = new CompoundTag();
        tag.putBoolean("isCanCook", isCanCook);
        tag.putBoolean("isFinish", isFinish);
        tag.putBoolean("isFail", isFinish);
        tag.putBoolean("hasSugar", hasSugar);
        tag.putInt("time", timer);
        return tag;
    }

    public static void tick(Level world, BlockPos pos, BlockState state, CoffeePotBlockEntity entity) {
        if (entity.isHeated(world, pos) && entity.isCanCook) {
            entity.timer--;

            if (entity.isFail)
                world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5D, pos.getY() + 0.6D, pos.getZ() + 0.5D, 0.0D, 3.0D, 0.0D);
            else if (entity.isFinish && world.random.nextInt(10) < 2)
                world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5D, pos.getY() + 0.6D, pos.getZ() + 0.5D, 0.0D, 3.0D, 0.0D);

            if (entity.timer <= 0) {
                entity.timer = 20 * 6;
                if (!entity.isFinish) entity.isFinish = true;
                else entity.isFail = true;
            }
        }

        if (!entity.isCanCook) {
            entity.timer = 20 * 10;
            entity.isFail = entity.isFinish = false;
        }
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
