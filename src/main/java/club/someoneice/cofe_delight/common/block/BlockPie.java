package club.someoneice.cofe_delight.common.block;

import club.someoneice.cofe_delight.CoffeeDelight;
import com.nhoryzon.mc.farmersdelight.block.PieBlock;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockPie extends PieBlock {
    public BlockPie(String name, Item pieside) {
        super(pieside);
        Registry.register(Registries.BLOCK, new Identifier(CoffeeDelight.MODID, name), this);
    }
}
