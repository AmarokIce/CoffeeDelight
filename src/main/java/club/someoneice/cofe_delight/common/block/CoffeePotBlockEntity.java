package club.someoneice.cofe_delight.common.block;

import club.someoneice.cofe_delight.init.BlockInit;
import club.someoneice.cofe_delight.init.TileEntityInit;
import com.nhoryzon.mc.farmersdelight.entity.block.HeatableBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CoffeePotBlockEntity extends BlockEntity implements HeatableBlockEntity {
    int timer;
    public boolean isCanCook, isFinish, isFail, hasSugar;

    public CoffeePotBlockEntity(BlockPos pos, BlockState state) {
        super(TileEntityInit.COFFEE_POT, pos, state);
        this.timer = 20 * 10;
        this.isCanCook = false;
        this.isFinish = false;
        this.isFail = false;
    }

    @Override
    public void readNbt(NbtCompound tag) {
        isCanCook = tag.getBoolean("isCanCook");
        isFinish = tag.getBoolean("isFinish");
        isFinish = tag.getBoolean("isFail");
        hasSugar = tag.getBoolean("hasSugar");
        timer = tag.getInt("time");
        super.readNbt(tag);
    }

    @Override
    public void writeNbt(NbtCompound tag) {
        tag.putBoolean("isCanCook", isCanCook);
        tag.putBoolean("isFinish", isFinish);
        tag.putBoolean("isFail", isFinish);
        tag.putBoolean("hasSugar", hasSugar);
        tag.putInt("time", timer);
        markDirty();
        super.writeNbt(tag);
    }

    public static void tick(World world, BlockPos pos, BlockState state, CoffeePotBlockEntity entity) {
        if (entity.isHeated(world, pos) && entity.isCanCook) {
            entity.timer--;

            if (entity.isFail && world.random.nextFloat() < 0.3F)
                smoke(world, pos);
            else if (entity.isFinish && world.random.nextFloat() < 0.05F)
                smoke(world, pos);
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

    private static void smoke(World world, BlockPos pos) {
        if (world.getBlockState(pos).isOf(BlockInit.TURKEY_POT))
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5D + world.random.nextDouble() * 0.3D - 0.2D, pos.getY() + 0.6D, pos.getZ() + 0.5D + world.random.nextDouble() * 0.3D - 0.2D, 0.0D, 0.0D, 0.0D);
        else if (world.getBlockState(pos).isOf(BlockInit.MOKA_POT))
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
