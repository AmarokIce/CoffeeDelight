package club.someoneice.cofe_delight.util;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class Coffee {
    /*
    private String name;
    private int hunger, time, level;
    private float saturation;
    private MobEffect[] effects;

    private RegistryObject<Item> coffeeMag, coffeeCap;
    private RegistryObject<Block> blockMag, blockCap;

    public Coffee(String name, int hunger, float saturation, MobEffect[] effects, int time, int level) {
        this.name = name;
        this.hunger = hunger;
        this.time = time;
        this.level = level;
        this.saturation = saturation;
        this.effects = effects;
        DataGenerator.CoffeeList.add(this);
    }

    public Coffee(String name, int hunger, float saturation) {
        this(name, hunger, saturation, null, 0, 0);
    }

    public Coffee registerItem(DeferredRegister<Item> registry) {
        this.coffeeCap = registry.register(name + "cap_item", () -> this.coffeeItemCap(hunger, saturation, new ItemStack(ItemInit.CAP.get()), effects, time, level));
        this.coffeeMag = registry.register(name + "mag_item", () -> this.coffeeItemMag(hunger, saturation, new ItemStack(ItemInit.MAG.get()), effects, time, level));
        return this;
    }

    public Coffee registerBlock(DeferredRegister<Block> register) {
        this.blockCap = register.register(name + "cap_block", () -> this.coffeeBlock(hunger, saturation, effects, time, level, BlockBean.CAP.CAP));
        this.blockMag = register.register(name + "mag_block", () -> this.coffeeBlock(hunger, saturation, effects, time, level, BlockBean.CAP.MAG));
        return this;
    }

    private Item coffeeItemCap(int hunger, float saturation, ItemStack returnItem, MobEffect[] effects, int time, int level) {
        Item.Properties properties = new Item.Properties().tab(CoffeeDelight.COFFEE);
        FoodProperties.Builder builder = new FoodProperties.Builder();
        builder.nutrition(hunger);
        builder.saturationMod(saturation);
        properties.food(builder.build());
        properties.stacksTo(1);
        return new ItemCoffeeBase(this.blockCap.get(), properties, returnItem, UseAnim.DRINK, effects, time, level);
    }

    private Item coffeeItemMag(int hunger, float saturation, ItemStack returnItem, MobEffect[] effects, int time, int level) {
        Item.Properties properties = new Item.Properties().tab(CoffeeDelight.COFFEE);
        FoodProperties.Builder builder = new FoodProperties.Builder();
        builder.nutrition(hunger);
        builder.saturationMod(saturation);
        properties.food(builder.build());
        properties.stacksTo(1);
        return new ItemCoffeeBase(this.blockMag.get(), properties, returnItem, UseAnim.DRINK, effects, time, level);
    }

    private Block coffeeBlock(int hunger, float saturation, MobEffect[] effects, int time, int level, BlockBean.CAP cap) {
        return new BlockCoffee(hunger, saturation, cap, effects, time, level);
    }
     */
    private RegistryObject<Item> coffeeMag, coffeeCap;
    private RegistryObject<Block> blockMag, blockCap;

    public Coffee(RegistryObject<Item> mag, RegistryObject<Item> cap, RegistryObject<Block> bMag, RegistryObject<Block> bCap) {
        this.coffeeMag = mag;
        this.coffeeCap = cap;
        this.blockMag = bMag;
        this.blockCap = bCap;
    }

    public RegistryObject<Item> getMagItem() {
        return coffeeMag;
    }

    public RegistryObject<Block> getMagBlock() {
        return blockMag;
    }

    public RegistryObject<Item> getCapItem() {
        return coffeeCap;
    }

    public RegistryObject<Block> getCapBlock() {
        return blockCap;
    }

}
