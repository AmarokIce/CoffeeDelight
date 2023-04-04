package club.someoneice.cofe_delight.init;

import club.someoneice.cofe_delight.common.block.CoffeePotBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;

public class TileEntityInit {
    public static final BlockEntityType<CoffeePotBlockEntity> COFFEE_POT = FabricBlockEntityTypeBuilder.create(CoffeePotBlockEntity::new, BlockInit.CUCCUMELA_POT, BlockInit.MOKA_POT, BlockInit.TURKEY_POT).build(null);
}
