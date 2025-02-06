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
    public static final RegistryObject<Item> CUP = ITEMS.register("coffee_cup", () -> new BlockItem(BlockInit.COFFEE_CUP.get(), new Item.Properties()));
    public static final RegistryObject<Item> MUG = ITEMS.register("coffee_mug", () -> new BlockItem(BlockInit.COFFEE_MUG.get(), new Item.Properties()));

    public static final RegistryObject<Item> CUP_BLACK_COFFEE     = ITEMS.register("cup_black_coffee",              () -> new ItemCoffeeBase(BlockInit.CUP_BLACK_COFFEE.get(), 3, 0.2F, new ItemStack(CUP.get())));
    public static final RegistryObject<Item> CUP_DOUBLE_ESPRESSO  = ITEMS.register("cup_double_espresso_coffee",    () -> new ItemCoffeeBase(BlockInit.CUP_DOUBLE_ESPRESSO.get(), 7, 0.5F, new ItemStack(CUP.get())));
    public static final RegistryObject<Item> CUP_ARABICA_COFFEE   = ITEMS.register("cup_arabic_coffee",             () -> new ItemCoffeeBase(BlockInit.CUP_ARABICA_COFFEE.get(), 3, 0.2F, new ItemStack(CUP.get())));
    public static final RegistryObject<Item> CUP_TURKEY_COFFEE    = ITEMS.register("cup_turkey_coffee",             () -> new ItemCoffeeBase(BlockInit.CUP_TURKEY_COFFEE.get(), 3, 0.2F, new ItemStack(CUP.get()), new MobEffect[]{MobEffects.MOVEMENT_SPEED}, 20 * 30, 0));
    public static final RegistryObject<Item> CUP_LATTE            = ITEMS.register("cup_latte_coffee",              () -> new ItemCoffeeBase(BlockInit.CUP_LATTE.get(), 5, 0.3F, new ItemStack(CUP.get())));
    public static final RegistryObject<Item> CUP_MOKA             = ITEMS.register("cup_moka_coffee",               () -> new ItemCoffeeBase(BlockInit.CUP_MOKA.get(), 7, 0.3F, new ItemStack(CUP.get())));
    public static final RegistryObject<Item> CUP_CAPPUCCINO       = ITEMS.register("cup_cappuccino",                () -> new ItemCoffeeBase(BlockInit.CUP_CAPPUCCINO.get(), 6, 0.4F, new ItemStack(CUP.get())));
    public static final RegistryObject<Item> CUP_USA              = ITEMS.register("cup_usa_coffee",                () -> new ItemCoffeeBase(BlockInit.CUP_USA.get(), 4, 0.2F, new ItemStack(CUP.get())));
    public static final RegistryObject<Item> CUP_MACCHIATO        = ITEMS.register("cup_macchiato",                 () -> new ItemCoffeeBase(BlockInit.CUP_MACCHIATO.get(), 9, 0.6F, new ItemStack(CUP.get()), new MobEffect[]{MobEffects.MOVEMENT_SPEED, MobEffects.DIG_SPEED}, 20 * 30, 1));
    public static final RegistryObject<Item> CUP_MILK_COFFEE      = ITEMS.register("cup_milk_coffee",               () -> new ItemCoffeeBase(BlockInit.CUP_MILK_COFFEE.get(), 6, 0.5F, new ItemStack(CUP.get())));
    public static final RegistryObject<Item> CUP_ICED_LATTE       = ITEMS.register("cup_iced_lattee_coffee",        () -> new ItemCoffeeBase(BlockInit.CUP_ICED_LATTE.get(), 6, 0.4F, new ItemStack(CUP.get())));
    public static final RegistryObject<Item> CUP_ICED_MOKA        = ITEMS.register("cup_iced_moka",                 () -> new ItemCoffeeBase(BlockInit.CUP_ICED_MOKA.get(), 8, 0.4F, new ItemStack(CUP.get())));
    public static final RegistryObject<Item> CUP_ICED_CAPPUCCINO  = ITEMS.register("cup_iced_cappuccino",           () -> new ItemCoffeeBase(BlockInit.CUP_ICED_CAPPUCCINO.get(), 7, 0.5F, new ItemStack(CUP.get())));
    public static final RegistryObject<Item> CUP_ICED_USA         = ITEMS.register("cup_iced_usa_coffee",           () -> new ItemCoffeeBase(BlockInit.CUP_ICED_USA.get(), 5, 0.2F, new ItemStack(CUP.get())));
    public static final RegistryObject<Item> CUP_ICED_MACCHIATO   = ITEMS.register("cup_iced_macchiato",            () -> new ItemCoffeeBase(BlockInit.CUP_ICED_MACCHIATO.get(), 10, 0.7F, new ItemStack(CUP.get())));
    public static final RegistryObject<Item> CUP_COCO             = ITEMS.register("cup_coco",                      () -> new ItemCoffeeBase(BlockInit.CUP_COCO.get(), 8, 0.6F, new ItemStack(CUP.get())));
    public static final RegistryObject<Item> CUP_ICED_COCO        = ITEMS.register("cup_iced_coco",                 () -> new ItemCoffeeBase(BlockInit.CUP_ICED_COCO.get(), 9, 0.8F, new ItemStack(CUP.get())));
    public static final RegistryObject<Item> CUP_FAIL_COFFEE      = ITEMS.register("cup_fail_coffee",               () -> new ItemCoffeeBase(BlockInit.CUP_FAIL_COFFEE.get(), 1, 0.1F, new ItemStack(CUP.get()), new MobEffect[]{MobEffects.HUNGER, MobEffects.BAD_OMEN}, 20 * 60, 0));

    public static final RegistryObject<Item> MUG_BLACK_COFFEE     = ITEMS.register("mug_black_coffee",              () -> new ItemCoffeeBase(BlockInit.MUG_BLACK_COFFEE.get(), 3, 0.2F, new ItemStack(MUG.get())));
    public static final RegistryObject<Item> MUG_DOUBLE_ESPRESSO  = ITEMS.register("mug_double_espresso_coffee",    () -> new ItemCoffeeBase(BlockInit.MUG_DOUBLE_ESPRESSO.get(), 7, 0.5F, new ItemStack(MUG.get())));
    public static final RegistryObject<Item> MUG_ARABICA_COFFEE   = ITEMS.register("mug_arabic_coffee",             () -> new ItemCoffeeBase(BlockInit.MUG_ARABICA_COFFEE.get(), 3, 0.2F, new ItemStack(MUG.get())));
    public static final RegistryObject<Item> MUG_TURKEY_COFFEE    = ITEMS.register("mug_turkey_coffee",             () -> new ItemCoffeeBase(BlockInit.MUG_TURKEY_COFFEE.get(), 3, 0.2F, new ItemStack(MUG.get()), new MobEffect[]{MobEffects.MOVEMENT_SPEED}, 20 * 30, 0));
    public static final RegistryObject<Item> MUG_LATTE            = ITEMS.register("mug_latte_coffee",              () -> new ItemCoffeeBase(BlockInit.MUG_LATTE.get(), 5, 0.3F, new ItemStack(MUG.get())));
    public static final RegistryObject<Item> MUG_MOKA             = ITEMS.register("mug_moka_coffee",               () -> new ItemCoffeeBase(BlockInit.MUG_MOKA.get(), 7, 0.3F, new ItemStack(MUG.get())));
    public static final RegistryObject<Item> MUG_CAPPUCCINO       = ITEMS.register("mug_cappuccino",                () -> new ItemCoffeeBase(BlockInit.MUG_CAPPUCCINO.get(), 6, 0.4F, new ItemStack(MUG.get())));
    public static final RegistryObject<Item> MUG_USA              = ITEMS.register("mug_usa_coffee",                () -> new ItemCoffeeBase(BlockInit.MUG_USA.get(), 4, 0.2F, new ItemStack(MUG.get())));
    public static final RegistryObject<Item> MUG_MACCHIATO        = ITEMS.register("mug_macchiato",                 () -> new ItemCoffeeBase(BlockInit.MUG_MACCHIATO.get(), 9, 0.6F, new ItemStack(MUG.get()), new MobEffect[]{MobEffects.MOVEMENT_SPEED, MobEffects.DIG_SPEED}, 20 * 30, 1));
    public static final RegistryObject<Item> MUG_MILK_COFFEE      = ITEMS.register("mug_milk_coffee",               () -> new ItemCoffeeBase(BlockInit.MUG_MILK_COFFEE.get(), 6, 0.5F, new ItemStack(MUG.get())));
    public static final RegistryObject<Item> MUG_ICED_LATTE       = ITEMS.register("mug_iced_lattee_coffee",        () -> new ItemCoffeeBase(BlockInit.MUG_ICED_LATTE.get(), 6, 0.4F, new ItemStack(MUG.get())));
    public static final RegistryObject<Item> MUG_ICED_MOKA        = ITEMS.register("mug_iced_moka",                 () -> new ItemCoffeeBase(BlockInit.MUG_ICED_MOKA.get(), 8, 0.4F, new ItemStack(MUG.get())));
    public static final RegistryObject<Item> MUG_ICED_CAPPUCCINO  = ITEMS.register("mug_iced_cappuccino",           () -> new ItemCoffeeBase(BlockInit.MUG_ICED_CAPPUCCINO.get(), 7, 0.5F, new ItemStack(MUG.get())));
    public static final RegistryObject<Item> MUG_ICED_USA         = ITEMS.register("mug_iced_usa_coffee",           () -> new ItemCoffeeBase(BlockInit.MUG_ICED_USA.get(), 5, 0.2F, new ItemStack(MUG.get())));
    public static final RegistryObject<Item> MUG_ICED_MACCHIATO   = ITEMS.register("mug_iced_macchiato",            () -> new ItemCoffeeBase(BlockInit.MUG_ICED_MACCHIATO.get(), 10, 0.7F, new ItemStack(MUG.get())));
    public static final RegistryObject<Item> MUG_COCO             = ITEMS.register("mug_coco",                      () -> new ItemCoffeeBase(BlockInit.MUG_COCO.get(), 8, 0.6F, new ItemStack(MUG.get())));
    public static final RegistryObject<Item> MUG_ICED_COCO        = ITEMS.register("mug_iced_coco",                 () -> new ItemCoffeeBase(BlockInit.MUG_ICED_COCO.get(), 9, 0.8F, new ItemStack(MUG.get())));
    public static final RegistryObject<Item> MUG_FAIL_COFFEE      = ITEMS.register("mug_fail_coffee",               () -> new ItemCoffeeBase(BlockInit.MUG_FAIL_COFFEE.get(), 1, 0.1F, new ItemStack(MUG.get()), new MobEffect[]{MobEffects.HUNGER, MobEffects.BAD_OMEN}, 20 * 60, 0));
}
