package club.someoneice.cofe_delight.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Coffee {
    private Item coffeeMag, coffeeCap;
    private Block blockMag, blockCap;

    public Coffee(Item mag, Item cap, Block bMag, Block bCap) {
        this.coffeeMag = mag;
        this.coffeeCap = cap;
        this.blockMag = bMag;
        this.blockCap = bCap;
    }

    public Item getMagItem() {
        return coffeeMag;
    }

    public Block getMagBlock() {
        return blockMag;
    }

    public Item getCapItem() {
        return coffeeCap;
    }

    public Block getCapBlock() {
        return blockCap;
    }

}
