package club.someoneice.cofe_delight.util;

import club.someoneice.cofe_delight.CoffeeDelight;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockBean {
    public enum CAP {
        CAP,
        MAG
    }

    public static Block block(String name) {
        var block = new Block(AbstractBlock.Settings.of(Material.PLANT));
        Registry.register(Registry.BLOCK, new Identifier(CoffeeDelight.MODID, name), block);
        return block;
    }
}
