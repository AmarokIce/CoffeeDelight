package club.someoneice.cofe_delight.util;

import club.someoneice.cofe_delight.CoffeeDelight;
import club.someoneice.cofe_delight.common.item.ItemDrinkWithEffectBase;
import club.someoneice.cofe_delight.common.item.ItemToolBase;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.UseAction;

import java.util.List;

public class ItemBean {
    public static final List<Item> ITEMS = Lists.newArrayList();

    public static Item itemItem(String name) {
        return register(name, new Item(properties()));
    }

    public static Item itemBlock(String name, Block block) {
        return register(name, new BlockItem(block, properties()));
    }

    public static Item itemTool(String name, int damage, ItemStack returnItem) {
        return register(name, new ItemToolBase(damage, returnItem));
    }

    public static Item itemFood(String name, int hunger, float saturation) {
        return register(name, new Item(properties().food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).build())));
    }

    public static Item itemFood(String name, int hunger, float saturation, boolean dogfood, boolean fastfood, boolean alwayseat, StatusEffect[] effects, int time, int level) {
        Item.Settings properties = properties();
        FoodComponent.Builder builder = new FoodComponent.Builder();
        builder.hunger(hunger);
        builder.saturationModifier(saturation);
        if (dogfood) builder.meat();
        if (fastfood) builder.snack();
        if (alwayseat) builder.alwaysEdible();
        properties.food(builder.build());
        return register(name, new ItemDrinkWithEffectBase(name, properties, ItemStack.EMPTY, UseAction.EAT, effects, time, level));
    }

    public static Item register(String name, Item item) {
        ITEMS.add(item);
        return Registry.register(Registries.ITEM, new Identifier(CoffeeDelight.MODID, name), item);
    }

    private static Item.Settings properties() {
        return new Item.Settings();
    }
}
