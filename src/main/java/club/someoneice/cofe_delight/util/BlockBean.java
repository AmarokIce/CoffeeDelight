package club.someoneice.cofe_delight.util;

import club.someoneice.cofe_delight.CoffeeDelight;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockBean {
    public enum CAP {
        CAP,
        MAG
    }

    public static Block block(String name) {
        var block = new Block(AbstractBlock.Settings.copy(Blocks.OAK_BUTTON));
        Registry.register(Registries.BLOCK, new Identifier(CoffeeDelight.MODID, name), block);
        return block;
    }
}
