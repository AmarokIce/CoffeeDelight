package lcyzsdh.coffee_delight.registry;

import lcyzsdh.coffee_delight.CoffeeDelight;
import lcyzsdh.coffee_delight.item.ItemClever;
import lcyzsdh.coffee_delight.item.ItemCoffeeBase;
import lcyzsdh.coffee_delight.item.ItemCoffeePie;
import lcyzsdh.coffee_delight.util.CupType;
import lcyzsdh.coffee_delight.util.CoffeeType;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS=DeferredRegister.createItems(CoffeeDelight.MODID);

    //coffee beans
    public static final DeferredItem<Item> COFFEE_BERRIES=ITEMS.register("coffee_berries",()->new BlockItem(BlockRegistry.COFFEE_BUSH.get(),new Item.Properties()));
    public static final DeferredItem<Item> COFFEE_FLOUR=ITEMS.register("coffee_flour",()->new Item(new Item.Properties()));
    public static final DeferredItem<Item> COFFEE_BEANS=ITEMS.register("coffee_beans",()->new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> COFFEE_BEANS_COOKED=ITEMS.register("coffee_beans_cooked",()->itemFood(1,0.1F));
    public static final DeferredItem<Item> COFFEE_BLOCK=ITEMS.register("coffee_block",()->new BlockItem(BlockRegistry.COFFEE_BLOCK.get(), new Item.Properties()));

    //snacks
    public static final DeferredItem<Item> COFFEE_PIE_SIDE = ITEMS.register("coffee_pie_side", ()->itemFood(3, 0.1F));
    public static final DeferredItem<Item> COFFEE_PIE = ITEMS.register("coffee_pie", () -> new ItemCoffeePie(BlockRegistry.COFFEE_PIE.get(),new Item.Properties().food(new FoodProperties.Builder().nutrition(12).saturationModifier(0.4F).build())));
    public static final DeferredItem<Item> QUICHE = ITEMS.register("quiche_side", () -> itemFood(5, 0.3F));
    public static final DeferredItem<Item> WAFER = ITEMS.register("wafer", () -> itemFood(2, 0.1f));
    public static final DeferredItem<Item> COFFEE_WAFER = ITEMS.register("coffee_wafer",()->new Item(new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(2).saturationModifier(0.1F).fast()
            .effect(()->new MobEffectInstance(MobEffects.MOVEMENT_SPEED,20*10,0),1.0F)
            .effect(()->new MobEffectInstance(MobEffects.DIG_SPEED,20*10,0),1.0F)
            .effect(()->new MobEffectInstance(MobEffects.NIGHT_VISION,20*10,0),1.0F)
            .build())));
    public static final DeferredItem<Item> BERRIES_WAFER = ITEMS.register("berries_wafer", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(2).saturationModifier(0.1F).fast()
            .effect(()->new MobEffectInstance(MobEffects.REGENERATION,100,0),1.0F).build())));

    public static final DeferredItem<Item> CUCCUMELA_TOP=ITEMS.register("cuccumela_top",()->new Item(new Item.Properties()));
    public static final DeferredItem<Item> CUCCUMELA_BOTTOM=ITEMS.register("cuccumela_bottom",()->new Item(new Item.Properties()));
    public static final DeferredItem<Item> CUCCUMELA_POT= ITEMS.register("cuccumela_pot",()->new BlockItem(BlockRegistry.CUCCUMELA_POT.get(), new Item.Properties()));
    public static final DeferredItem<Item> CLEVER=ITEMS.register("mr_clever", ItemClever::new);
    public static final DeferredItem<Item> MOKA_TOP = ITEMS.register("moka_top", ()->new Item(new Item.Properties()));
    public static final DeferredItem<Item> MOKA_BOTTOM = ITEMS.register("moka_bottom", ()->new Item(new Item.Properties()));
    public static final DeferredItem<Item> MOKA_POT = ITEMS.register("moka_pot", () -> new BlockItem(BlockRegistry.MOKA_POT.get(), new Item.Properties()));
    public static final DeferredItem<Item> TURKEY_HANDEL = ITEMS.register("turkey_handel", ()->new Item(new Item.Properties()));
    public static final DeferredItem<Item> TURKEY_POT_PART = ITEMS.register("turkey_pot_part", ()->new Item(new Item.Properties()));
    public static final DeferredItem<Item> TURKEY_POT = ITEMS.register("turkey_pot", () -> new BlockItem(BlockRegistry.TURKEY_POT.get(), new Item.Properties()));
    public static final DeferredItem<Item> COFFEE_CAP=ITEMS.register("coffee_cap",()->new BlockItem(BlockRegistry.COFFEE_CAP.get(), new Item.Properties()));
    public static final DeferredItem<Item> COFFEE_MAG=ITEMS.register("coffee_mag",()->new BlockItem(BlockRegistry.COFFEE_MAG.get(), new Item.Properties()));

    public static final Map<String,DeferredItem<Item>> COFFEE_MAP=new HashMap<>();//all coffee items


    public static Item itemFood(int nutrition, float saturation) {
        return new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation).build()));
    }

    static {
        for(CoffeeType coffeeType : CoffeeType.values()){
            for(CupType cupType : CupType.values()){
                String name=cupType.toString()+"_"+coffeeType.getName();
                var block=BlockRegistry.COFFEE_MAP.get(name);
                switch (cupType){
                    case CAP:
                        COFFEE_MAP.put(name,ITEMS.register(name,()->new ItemCoffeeBase(block.get(),coffeeType,new ItemStack(ItemRegistry.COFFEE_CAP.get()))));
                        break;
                    case MAG:
                        COFFEE_MAP.put(name,ITEMS.register(name,()->new ItemCoffeeBase(block.get(),coffeeType,new ItemStack(ItemRegistry.COFFEE_MAG.get()))));
                        break;
                }
            }
        }
    }
}
