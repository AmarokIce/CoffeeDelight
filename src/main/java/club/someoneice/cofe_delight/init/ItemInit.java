package club.someoneice.cofe_delight.init;

import club.someoneice.cofe_delight.CoffeeDelight;
import club.someoneice.cofe_delight.common.item.ItemCoffeeBase;
import club.someoneice.cofe_delight.common.item.ItemCoffeePie;
import club.someoneice.cofe_delight.util.ItemBean;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CoffeeDelight.MODID);

    // TODO - CoffeeInit Effect and Iced Effect.

    // CoffeeInit Beans
    public static final RegistryObject<Item> COFFEE_BERRIES = ITEMS.register("coffee_berries", () -> ItemBean.itemBlock(BlockInit.COFFEE_BUSH.get()));
    public static final RegistryObject<Item> COFFEE_FLOUR = ITEMS.register("coffee_flour", ItemBean::itemItem);
    public static final RegistryObject<Item> COFFEE_BEANS = ITEMS.register("coffee_beans", () -> ItemBean.itemFood(1, 0.1F));
    public static final RegistryObject<Item> COFFEE_BEANS_COOKED = ITEMS.register("coffee_beans_cooked", () -> ItemBean.itemFood(1, 0.1F));
    public static final RegistryObject<Item> COFFEE_BLOCK = ITEMS.register("coffee_block_item", () -> ItemBean.itemBlock(BlockInit.COFFEE_BLOCK.get()));

    // Snack
    public static final RegistryObject<Item> COFFEE_PIE_SIDE = ITEMS.register("coffee_pie_side", () -> ItemBean.itemFood(3, 0.1F));
    public static final RegistryObject<Item> COFFEE_PIE = ITEMS.register("coffee_pie", () -> new ItemCoffeePie(BlockInit.COFFEE_PIE.get(),12, 0.4F));
    public static final RegistryObject<Item> QUICHE = ITEMS.register("quiche_side", () -> ItemBean.itemFood(5, 0.3F));
    public static final RegistryObject<Item> WAFER = ITEMS.register("wafer", () -> ItemBean.itemFood(2, 0.1f));
    public static final RegistryObject<Item> COFFEE_WAFER = ITEMS.register("coffee_wafer", () -> ItemBean.itemFood(2, 0.1f, false, true, false, new MobEffect[]{MobEffects.MOVEMENT_SPEED, MobEffects.DIG_SPEED, MobEffects.NIGHT_VISION}, 20 * 10, 0));
    public static final RegistryObject<Item> BERRIES_WAFER = ITEMS.register("berries_wafer", () -> ItemBean.itemFood(2, 0.1f, false, true, false, new MobEffect[]{MobEffects.REGENERATION}, 20 * 5, 0));

    // Items
    /* Cuccumela */
    public static final RegistryObject<Item> CUCCUMELA_TOP = ITEMS.register("cuccumela_top", ItemBean::itemItem);
    public static final RegistryObject<Item> CUCCUMELA_BOTTOM = ITEMS.register("cuccumela_bottom", ItemBean::itemItem);
    public static final RegistryObject<Item> CUCCUMELA_POT = ITEMS.register("cuccumela_pot", () -> ItemBean.itemBlock(BlockInit.CUCCUMELA_POT.get()));

    /* Moka Pot */
    public static final RegistryObject<Item> MOKA_TOP = ITEMS.register("moka_top", ItemBean::itemItem);
    public static final RegistryObject<Item> MOKA_BOTTOM = ITEMS.register("moka_bottom", ItemBean::itemItem);
    public static final RegistryObject<Item> MOKA_POT = ITEMS.register("moka_pot", () -> ItemBean.itemBlock(BlockInit.MOKA_POT.get()));
    /* Balancing Siphon ( TODO ) */
    public static final RegistryObject<Item> BALACING_SIPHON = ITEMS.register("balacing_siphon", ItemBean::itemItem);

    /* Mr.Clever */
    public static final RegistryObject<Item> Clever = ITEMS.register("mr_clever", ItemBean::itemTool);

    /* Turkey CoffeeInit Pot */
    public static final RegistryObject<Item> TURKEY_HANDEL = ITEMS.register("turkey_handel", ItemBean::itemItem);
    public static final RegistryObject<Item> TURKEY_POT_PART = ITEMS.register("turkey_pot_part", ItemBean::itemItem);
    public static final RegistryObject<Item> TURKEY_POT = ITEMS.register("turkey_pot", () -> ItemBean.itemBlock(BlockInit.TURKEY_POT.get()));

    // Cap
    public static final RegistryObject<Item> CAP = ITEMS.register("coffee_cap", () -> new BlockItem(BlockInit.COFFEE_CAP.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAG = ITEMS.register("coffee_mag", () -> new BlockItem(BlockInit.COFFEE_MAG.get(), new Item.Properties()));

    public static final RegistryObject<Item> CAP_BLACK_COFFEE     = ITEMS.register("cap_black_coffee",              () -> new ItemCoffeeBase(BlockInit.CAP_BLACK_COFFEE.get(), 3, 0.2F, new ItemStack(CAP.get())));
    public static final RegistryObject<Item> CAP_DOUBLE_ESPRESSO  = ITEMS.register("cap_double_espresso_coffee",    () -> new ItemCoffeeBase(BlockInit.CAP_DOUBLE_ESPRESSO.get(), 7, 0.5F, new ItemStack(CAP.get())));
    public static final RegistryObject<Item> CAP_ARABICA_COFFEE   = ITEMS.register("cap_arabic_coffee",             () -> new ItemCoffeeBase(BlockInit.CAP_ARABICA_COFFEE.get(), 3, 0.2F, new ItemStack(CAP.get())));
    public static final RegistryObject<Item> CAP_TURKEY_COFFEE    = ITEMS.register("cap_turkey_coffee",             () -> new ItemCoffeeBase(BlockInit.CAP_TURKEY_COFFEE.get(), 3, 0.2F, new ItemStack(CAP.get()), new MobEffect[]{MobEffects.MOVEMENT_SPEED}, 20 * 30, 0));
    public static final RegistryObject<Item> CAP_LATTE            = ITEMS.register("cap_latte_coffee",              () -> new ItemCoffeeBase(BlockInit.CAP_LATTE.get(), 5, 0.3F, new ItemStack(CAP.get())));
    public static final RegistryObject<Item> CAP_MOKA             = ITEMS.register("cap_moka_coffee",               () -> new ItemCoffeeBase(BlockInit.CAP_MOKA.get(), 7, 0.3F, new ItemStack(CAP.get())));
    public static final RegistryObject<Item> CAP_CAPPUCCINO       = ITEMS.register("cap_cappuccino",                () -> new ItemCoffeeBase(BlockInit.CAP_CAPPUCCINO.get(), 6, 0.4F, new ItemStack(CAP.get())));
    public static final RegistryObject<Item> CAP_USA              = ITEMS.register("cap_usa_coffee",                () -> new ItemCoffeeBase(BlockInit.CAP_USA.get(), 4, 0.2F, new ItemStack(CAP.get())));
    public static final RegistryObject<Item> CAP_MACCHIATO        = ITEMS.register("cap_macchiato",                 () -> new ItemCoffeeBase(BlockInit.CAP_MACCHIATO.get(), 9, 0.6F, new ItemStack(CAP.get()), new MobEffect[]{MobEffects.MOVEMENT_SPEED, MobEffects.DIG_SPEED}, 20 * 30, 1));
    public static final RegistryObject<Item> CAP_MILK_COFFEE      = ITEMS.register("cap_milk_coffee",               () -> new ItemCoffeeBase(BlockInit.CAP_MILK_COFFEE.get(), 6, 0.5F, new ItemStack(CAP.get())));
    public static final RegistryObject<Item> CAP_ICED_LATTE       = ITEMS.register("cap_iced_lattee_coffee",        () -> new ItemCoffeeBase(BlockInit.CAP_ICED_LATTE.get(), 6, 0.4F, new ItemStack(CAP.get())));
    public static final RegistryObject<Item> CAP_ICED_MOKA        = ITEMS.register("cap_iced_moka",                 () -> new ItemCoffeeBase(BlockInit.CAP_ICED_MOKA.get(), 8, 0.4F, new ItemStack(CAP.get())));
    public static final RegistryObject<Item> CAP_ICED_CAPPUCCINO  = ITEMS.register("cap_iced_cappuccino",           () -> new ItemCoffeeBase(BlockInit.CAP_ICED_CAPPUCCINO.get(), 7, 0.5F, new ItemStack(CAP.get())));
    public static final RegistryObject<Item> CAP_ICED_USA         = ITEMS.register("cap_iced_usa_coffee",           () -> new ItemCoffeeBase(BlockInit.CAP_ICED_USA.get(), 5, 0.2F, new ItemStack(CAP.get())));
    public static final RegistryObject<Item> CAP_ICED_MACCHIATO   = ITEMS.register("cap_iced_macchiato",            () -> new ItemCoffeeBase(BlockInit.CAP_ICED_MACCHIATO.get(), 10, 0.7F, new ItemStack(CAP.get())));
    public static final RegistryObject<Item> CAP_COCO             = ITEMS.register("cap_coco",                      () -> new ItemCoffeeBase(BlockInit.CAP_COCO.get(), 8, 0.6F, new ItemStack(CAP.get())));
    public static final RegistryObject<Item> CAP_ICED_COCO        = ITEMS.register("cap_iced_coco",                 () -> new ItemCoffeeBase(BlockInit.CAP_ICED_COCO.get(), 9, 0.8F, new ItemStack(CAP.get())));
    public static final RegistryObject<Item> CAP_FAIL_COFFEE      = ITEMS.register("cap_fail_coffee",               () -> new ItemCoffeeBase(BlockInit.CAP_FAIL_COFFEE.get(), 1, 0.1F, new ItemStack(CAP.get()), new MobEffect[]{MobEffects.HUNGER, MobEffects.BAD_OMEN}, 20 * 60, 0));

    public static final RegistryObject<Item> MAG_BLACK_COFFEE     = ITEMS.register("mag_black_coffee",              () -> new ItemCoffeeBase(BlockInit.MAG_BLACK_COFFEE.get(), 3, 0.2F, new ItemStack(MAG.get())));
    public static final RegistryObject<Item> MAG_DOUBLE_ESPRESSO  = ITEMS.register("mag_double_espresso_coffee",    () -> new ItemCoffeeBase(BlockInit.MAG_DOUBLE_ESPRESSO.get(), 7, 0.5F, new ItemStack(MAG.get())));
    public static final RegistryObject<Item> MAG_ARABICA_COFFEE   = ITEMS.register("mag_arabic_coffee",             () -> new ItemCoffeeBase(BlockInit.MAG_ARABICA_COFFEE.get(), 3, 0.2F, new ItemStack(MAG.get())));
    public static final RegistryObject<Item> MAG_TURKEY_COFFEE    = ITEMS.register("mag_turkey_coffee",             () -> new ItemCoffeeBase(BlockInit.MAG_TURKEY_COFFEE.get(), 3, 0.2F, new ItemStack(MAG.get()), new MobEffect[]{MobEffects.MOVEMENT_SPEED}, 20 * 30, 0));
    public static final RegistryObject<Item> MAG_LATTE            = ITEMS.register("mag_latte_coffee",              () -> new ItemCoffeeBase(BlockInit.MAG_LATTE.get(), 5, 0.3F, new ItemStack(MAG.get())));
    public static final RegistryObject<Item> MAG_MOKA             = ITEMS.register("mag_moka_coffee",               () -> new ItemCoffeeBase(BlockInit.MAG_MOKA.get(), 7, 0.3F, new ItemStack(MAG.get())));
    public static final RegistryObject<Item> MAG_CAPPUCCINO       = ITEMS.register("mag_cappuccino",                () -> new ItemCoffeeBase(BlockInit.MAG_CAPPUCCINO.get(), 6, 0.4F, new ItemStack(MAG.get())));
    public static final RegistryObject<Item> MAG_USA              = ITEMS.register("mag_usa_coffee",                () -> new ItemCoffeeBase(BlockInit.MAG_USA.get(), 4, 0.2F, new ItemStack(MAG.get())));
    public static final RegistryObject<Item> MAG_MACCHIATO        = ITEMS.register("mag_macchiato",                 () -> new ItemCoffeeBase(BlockInit.MAG_MACCHIATO.get(), 9, 0.6F, new ItemStack(MAG.get()), new MobEffect[]{MobEffects.MOVEMENT_SPEED, MobEffects.DIG_SPEED}, 20 * 30, 1));
    public static final RegistryObject<Item> MAG_MILK_COFFEE      = ITEMS.register("mag_milk_coffee",               () -> new ItemCoffeeBase(BlockInit.MAG_MILK_COFFEE.get(), 6, 0.5F, new ItemStack(MAG.get())));
    public static final RegistryObject<Item> MAG_ICED_LATTE       = ITEMS.register("mag_iced_lattee_coffee",        () -> new ItemCoffeeBase(BlockInit.MAG_ICED_LATTE.get(), 6, 0.4F, new ItemStack(MAG.get())));
    public static final RegistryObject<Item> MAG_ICED_MOKA        = ITEMS.register("mag_iced_moka",                 () -> new ItemCoffeeBase(BlockInit.MAG_ICED_MOKA.get(), 8, 0.4F, new ItemStack(MAG.get())));
    public static final RegistryObject<Item> MAG_ICED_CAPPUCCINO  = ITEMS.register("mag_iced_cappuccino",           () -> new ItemCoffeeBase(BlockInit.MAG_ICED_CAPPUCCINO.get(), 7, 0.5F, new ItemStack(MAG.get())));
    public static final RegistryObject<Item> MAG_ICED_USA         = ITEMS.register("mag_iced_usa_coffee",           () -> new ItemCoffeeBase(BlockInit.MAG_ICED_USA.get(), 5, 0.2F, new ItemStack(MAG.get())));
    public static final RegistryObject<Item> MAG_ICED_MACCHIATO   = ITEMS.register("mag_iced_macchiato",            () -> new ItemCoffeeBase(BlockInit.MAG_ICED_MACCHIATO.get(), 10, 0.7F, new ItemStack(MAG.get())));
    public static final RegistryObject<Item> MAG_COCO             = ITEMS.register("mag_coco",                      () -> new ItemCoffeeBase(BlockInit.MAG_COCO.get(), 8, 0.6F, new ItemStack(MAG.get())));
    public static final RegistryObject<Item> MAG_ICED_COCO        = ITEMS.register("mag_iced_coco",                 () -> new ItemCoffeeBase(BlockInit.MAG_ICED_COCO.get(), 9, 0.8F, new ItemStack(MAG.get())));
    public static final RegistryObject<Item> MAG_FAIL_COFFEE      = ITEMS.register("mag_fail_coffee",               () -> new ItemCoffeeBase(BlockInit.MAG_FAIL_COFFEE.get(), 1, 0.1F, new ItemStack(MAG.get()), new MobEffect[]{MobEffects.HUNGER, MobEffects.BAD_OMEN}, 20 * 60, 0));
}
