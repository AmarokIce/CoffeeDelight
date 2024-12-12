package club.someoneice.cofe_delight.init;

import club.someoneice.cofe_delight.CoffeeDelight;
import club.someoneice.cofe_delight.common.block.CoffeePotBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TileEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CoffeeDelight.MODID);

    public static final RegistryObject<BlockEntityType<CoffeePotBlockEntity>> COFFEE_POT = TILE_ENTITIES.register("tile_coffee_pot", () -> BlockEntityType.Builder.of(CoffeePotBlockEntity::new, BlockInit.CUCCUMELA_POT.get(), BlockInit.MOKA_POT.get(), BlockInit.TURKEY_POT.get()).build(null));
}
