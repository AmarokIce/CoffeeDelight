package club.someoneice.cofe_delight.util;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    public static List<RegistryObject<?>> ObjectList = new ArrayList<>();
    public static List<Coffee> CoffeeList = new ArrayList<>();

    public DataGenerator() {
        for (RegistryObject<?> object : ObjectList) {
            if (object.get() instanceof Item) {
                // TODO
            } else if (object.get() instanceof Block) {
                // TODO
            }
        }
    }
}
