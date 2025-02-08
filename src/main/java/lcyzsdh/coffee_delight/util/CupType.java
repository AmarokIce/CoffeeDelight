package lcyzsdh.coffee_delight.util;

import lcyzsdh.coffee_delight.registry.ItemRegistry;
import net.minecraft.world.item.Item;

public enum CupType {
    CAP("cap"),
    MAG("mag");
    private final String name;

    CupType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
