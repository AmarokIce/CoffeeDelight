package club.someoneice.cofe_delight.common.block;

import club.someoneice.cofe_delight.CoffeeDelight;
import com.nhoryzon.mc.farmersdelight.block.PieBlock;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockPie extends PieBlock {
    public BlockPie(String name, Item pieside) {
        super(pieside);
        Registry.register(Registry.BLOCK, new Identifier(CoffeeDelight.MODID, name), this);
    }
}
