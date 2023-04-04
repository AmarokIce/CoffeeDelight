package club.someoneice.cofe_delight.util;

import club.someoneice.cofe_delight.CoffeeDelight;
import club.someoneice.cofe_delight.common.item.ItemDrinkWithEffectBase;
import club.someoneice.cofe_delight.common.item.ItemToolBase;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.UseAction;
import net.minecraft.util.registry.Registry;

public class ItemBean {
    public static Item itemItem(String name) {
        var item = new Item(properties());
        Registry.register(Registry.ITEM, new Identifier(CoffeeDelight.MODID, name), item);
        return item;
    }

    public static Item itemBlock(String name, Block block) {
        var item = new BlockItem(block, properties());
        Registry.register(Registry.ITEM, new Identifier(CoffeeDelight.MODID, name), item);
        return item;
    }

    public static Item itemTool(String name, int damage, ItemStack returnItem) {
        return new ItemToolBase(name, damage, returnItem);
    }

    public static Item itemFood(String name, int hunger, float saturation) {
        var item = new Item(properties().food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).build()));
        Registry.register(Registry.ITEM, new Identifier(CoffeeDelight.MODID, name), item);
        return item;
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
        return new ItemDrinkWithEffectBase(name, properties, ItemStack.EMPTY, UseAction.EAT, effects, time, level);
    }

    private static Item.Settings properties() {
        return new Item.Settings().group(CoffeeDelight.COFFEE);
    }
}
