package club.someoneice.cofe_delight.util;

import club.someoneice.cofe_delight.CoffeeDelight;
import club.someoneice.cofe_delight.common.item.ItemDrinkWithEffectBase;
import club.someoneice.cofe_delight.common.item.ItemToolBase;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.block.Block;

public class ItemBean {
    public static Item itemItem() {
        return new Item(properties());
    }

    public static Item itemBlock(Block block) {
        return new BlockItem(block, properties());
    }

    public static Item itemTool() {
        return new ItemToolBase();
    }

    public static Item itemFood(int hunger, float saturation) {
        return new Item(properties().food(new FoodProperties.Builder().nutrition(hunger).saturationMod(saturation).build()));
    }

    public static Item itemFood(int hunger, float saturation, boolean dogfood, boolean fastfood, boolean alwayseat, MobEffect[] effects, int time, int level) {
        Item.Properties properties = properties();
        FoodProperties.Builder builder = new FoodProperties.Builder();
        builder.nutrition(hunger);
        builder.saturationMod(saturation);
        if (dogfood) builder.meat();
        if (fastfood) builder.fast();
        if (alwayseat) builder.alwaysEat();
        properties.food(builder.build());
        return new ItemDrinkWithEffectBase(properties, ItemStack.EMPTY, UseAnim.EAT, effects, time, level);
    }

    private static Item.Properties properties() {
        return new Item.Properties().tab(CoffeeDelight.COFFEE);
    }
}
