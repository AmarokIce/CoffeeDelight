package lcyzsdh.coffee_delight.registry;

import lcyzsdh.coffee_delight.CoffeeDelight;
import lcyzsdh.coffee_delight.block.entity.CoffeePotEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY=DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, CoffeeDelight.MODID);
    public static final Supplier<BlockEntityType<CoffeePotEntity>> COFFEE_POT=BLOCK_ENTITY.register("tile_coffee_pot",()->BlockEntityType.Builder.of(CoffeePotEntity::new,
            BlockRegistry.CUCCUMELA_POT.get(),BlockRegistry.TURKEY_POT.get(),BlockRegistry.MOKA_POT.get()).build(null));
}
