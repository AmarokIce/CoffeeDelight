package club.someoneice.cofe_delight.init;

import club.someoneice.cofe_delight.common.item.ItemCoffeeBase;
import club.someoneice.cofe_delight.common.item.ItemCoffeePie;
import club.someoneice.cofe_delight.util.ItemBean;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@SuppressWarnings("unused")
public class ItemInit {
    // CoffeeInit Beans
    public static final Item COFFEE_BERRIES = ItemBean.itemBlock("coffee_berries", BlockInit.COFFEE_BUSH);
    public static final Item COFFEE_FLOUR = ItemBean.itemItem("coffee_flour");
    public static final Item COFFEE_BEANS = ItemBean.itemFood("coffee_beans", 1, 0.1F);
    public static final Item COFFEE_BEANS_COOKED = ItemBean.itemFood("coffee_beans_cooked", 1, 0.1F);
    public static final Item COFFEE_BLOCK = ItemBean.itemBlock("coffee_block_item", BlockInit.COFFEE_BLOCK);

    // Snack
    public static final Item COFFEE_PIE_SIDE = ItemBean.itemFood("coffee_pie_side", 3, 0.1F);
    public static final Item COFFEE_PIE = new ItemCoffeePie("coffee_pie", BlockInit.COFFEE_PIE,12, 0.4F);
    public static final Item QUICHE = ItemBean.itemFood("quiche_side", 5, 0.3F);
    public static final Item WAFER = ItemBean.itemFood("wafer", 2, 0.1f);
    public static final Item COFFEE_WAFER = ItemBean.itemFood("coffee_wafer", 2, 0.1f, false, true, false, new StatusEffect[]{StatusEffects.SPEED, StatusEffects.HASTE, StatusEffects.NIGHT_VISION}, 20 * 10, 0);
    public static final Item BERRIES_WAFER = ItemBean.itemFood("berries_wafer", 2, 0.1f, false, true, false, new StatusEffect[]{StatusEffects.REGENERATION}, 20 * 5, 0);

    // Items
    /* Cuccumela */
    public static final Item CUCCUMELA_TOP = ItemBean.itemItem("cuccumela_top");
    public static final Item CUCCUMELA_BOTTOM = ItemBean.itemItem("cuccumela_bottom");
    public static final Item CUCCUMELA_POT = ItemBean.itemBlock("cuccumela_pot", BlockInit.CUCCUMELA_POT);

    /* Moka Pot */
    public static final Item MOKA_TOP = ItemBean.itemItem("moka_top");
    public static final Item MOKA_BOTTOM = ItemBean.itemItem("moka_bottom");
    public static final Item MOKA_POT = ItemBean.itemBlock("moka_pot", BlockInit.MOKA_POT);
    /* Balancing Siphon ( TODO ) */
    public static final Item BALACING_SIPHON = ItemBean.itemItem("balacing_siphon");

    /* Mr.Clever */
    public static final Item Clever = ItemBean.itemTool("mr_clever", 50, ItemStack.EMPTY);

    /* Turkey CoffeeInit Pot */
    public static final Item TURKEY_HANDEL = ItemBean.itemItem("turkey_handel");
    public static final Item TURKEY_POT_PART = ItemBean.itemItem("turkey_pot_part");
    public static final Item TURKEY_POT = ItemBean.itemBlock("turkey_pot", BlockInit.TURKEY_POT);

    // Cap
    public static final Item CAP = ItemBean.itemBlock("coffee_cap", BlockInit.COFFEE_CAP);
    public static final Item MAG = ItemBean.itemBlock("coffee_mag", BlockInit.COFFEE_MAG);

    public static final Item CAP_BLACK_COFFEE     = new ItemCoffeeBase("cap_black_coffee",              BlockInit.CAP_BLACK_COFFEE, 3, 0.2F, new ItemStack(CAP));
    public static final Item CAP_DOUBLE_ESPRESSO  = new ItemCoffeeBase("cap_double_espresso_coffee",    BlockInit.CAP_DOUBLE_ESPRESSO, 7, 0.5F, new ItemStack(CAP));
    public static final Item CAP_ARABICA_COFFEE   = new ItemCoffeeBase("cap_arabic_coffee",             BlockInit.CAP_ARABICA_COFFEE, 3, 0.2F, new ItemStack(CAP));
    public static final Item CAP_TURKEY_COFFEE    = new ItemCoffeeBase("cap_turkey_coffee",             BlockInit.CAP_TURKEY_COFFEE, 3, 0.2F, new ItemStack(CAP), new StatusEffect[]{StatusEffects.SPEED}, 20 * 30, 0);
    public static final Item CAP_LATTE            = new ItemCoffeeBase("cap_latte_coffee",              BlockInit.CAP_LATTE, 5, 0.3F, new ItemStack(CAP));
    public static final Item CAP_MOKA             = new ItemCoffeeBase("cap_moka_coffee",               BlockInit.CAP_MOKA, 7, 0.3F, new ItemStack(CAP));
    public static final Item CAP_CAPPUCCINO       = new ItemCoffeeBase("cap_cappuccino",                BlockInit.CAP_CAPPUCCINO, 6, 0.4F, new ItemStack(CAP));
    public static final Item CAP_USA              = new ItemCoffeeBase("cap_usa_coffee",                BlockInit.CAP_USA, 4, 0.2F, new ItemStack(CAP));
    public static final Item CAP_MACCHIATO        = new ItemCoffeeBase("cap_macchiato",                 BlockInit.CAP_MACCHIATO, 9, 0.6F, new ItemStack(CAP), new StatusEffect[]{StatusEffects.SPEED, StatusEffects.HASTE}, 20 * 30, 1);
    public static final Item CAP_MILK_COFFEE      = new ItemCoffeeBase("cap_milk_coffee",               BlockInit.CAP_MILK_COFFEE, 6, 0.5F, new ItemStack(CAP));
    public static final Item CAP_ICED_LATTE       = new ItemCoffeeBase("cap_iced_lattee_coffee",        BlockInit.CAP_ICED_LATTE, 6, 0.4F, new ItemStack(CAP));
    public static final Item CAP_ICED_MOKA        = new ItemCoffeeBase("cap_iced_moka",                 BlockInit.CAP_ICED_MOKA, 8, 0.4F, new ItemStack(CAP));
    public static final Item CAP_ICED_CAPPUCCINO  = new ItemCoffeeBase("cap_iced_cappuccino",           BlockInit.CAP_ICED_CAPPUCCINO, 7, 0.5F, new ItemStack(CAP));
    public static final Item CAP_ICED_USA         = new ItemCoffeeBase("cap_iced_usa_coffee",           BlockInit.CAP_ICED_USA, 5, 0.2F, new ItemStack(CAP));
    public static final Item CAP_ICED_MACCHIATO   = new ItemCoffeeBase("cap_iced_macchiato",            BlockInit.CAP_ICED_MACCHIATO, 10, 0.7F, new ItemStack(CAP));
    public static final Item CAP_COCO             = new ItemCoffeeBase("cap_coco",                      BlockInit.CAP_COCO, 8, 0.6F, new ItemStack(CAP));
    public static final Item CAP_ICED_COCO        = new ItemCoffeeBase("cap_iced_coco",                 BlockInit.CAP_ICED_COCO, 9, 0.8F, new ItemStack(CAP));
    public static final Item CAP_FAIL_COFFEE      = new ItemCoffeeBase("cap_fail_coffee",               BlockInit.CAP_FAIL_COFFEE, 1, 0.1F, new ItemStack(CAP), new StatusEffect[]{StatusEffects.HUNGER, StatusEffects.BAD_OMEN}, 20 * 60, 0);

    public static final Item MAG_BLACK_COFFEE     = new ItemCoffeeBase("mag_black_coffee",              BlockInit.MAG_BLACK_COFFEE, 3, 0.2F, new ItemStack(MAG));
    public static final Item MAG_DOUBLE_ESPRESSO  = new ItemCoffeeBase("mag_double_espresso_coffee",    BlockInit.MAG_DOUBLE_ESPRESSO, 7, 0.5F, new ItemStack(MAG));
    public static final Item MAG_ARABICA_COFFEE   = new ItemCoffeeBase("mag_arabic_coffee",             BlockInit.MAG_ARABICA_COFFEE, 3, 0.2F, new ItemStack(MAG));
    public static final Item MAG_TURKEY_COFFEE    = new ItemCoffeeBase("mag_turkey_coffee",             BlockInit.MAG_TURKEY_COFFEE, 3, 0.2F, new ItemStack(MAG), new StatusEffect[]{StatusEffects.SPEED}, 20 * 30, 0);
    public static final Item MAG_LATTE            = new ItemCoffeeBase("mag_latte_coffee",              BlockInit.MAG_LATTE, 5, 0.3F, new ItemStack(MAG));
    public static final Item MAG_MOKA             = new ItemCoffeeBase("mag_moka_coffee",               BlockInit.MAG_MOKA, 7, 0.3F, new ItemStack(MAG));
    public static final Item MAG_CAPPUCCINO       = new ItemCoffeeBase("mag_cappuccino",                BlockInit.MAG_CAPPUCCINO, 6, 0.4F, new ItemStack(MAG));
    public static final Item MAG_USA              = new ItemCoffeeBase("mag_usa_coffee",                BlockInit.MAG_USA, 4, 0.2F, new ItemStack(MAG));
    public static final Item MAG_MACCHIATO        = new ItemCoffeeBase("mag_macchiato",                 BlockInit.MAG_MACCHIATO, 9, 0.6F, new ItemStack(MAG), new StatusEffect[]{StatusEffects.SPEED, StatusEffects.HASTE}, 20 * 30, 1);
    public static final Item MAG_MILK_COFFEE      = new ItemCoffeeBase("mag_milk_coffee",               BlockInit.MAG_MILK_COFFEE, 6, 0.5F, new ItemStack(MAG));
    public static final Item MAG_ICED_LATTE       = new ItemCoffeeBase("mag_iced_lattee_coffee",        BlockInit.MAG_ICED_LATTE, 6, 0.4F, new ItemStack(MAG));
    public static final Item MAG_ICED_MOKA        = new ItemCoffeeBase("mag_iced_moka",                 BlockInit.MAG_ICED_MOKA, 8, 0.4F, new ItemStack(MAG));
    public static final Item MAG_ICED_CAPPUCCINO  = new ItemCoffeeBase("mag_iced_cappuccino",           BlockInit.MAG_ICED_CAPPUCCINO, 7, 0.5F, new ItemStack(MAG));
    public static final Item MAG_ICED_USA         = new ItemCoffeeBase("mag_iced_usa_coffee",           BlockInit.MAG_ICED_USA, 5, 0.2F, new ItemStack(MAG));
    public static final Item MAG_ICED_MACCHIATO   = new ItemCoffeeBase("mag_iced_macchiato",            BlockInit.MAG_ICED_MACCHIATO, 10, 0.7F, new ItemStack(MAG));
    public static final Item MAG_COCO             = new ItemCoffeeBase("mag_coco",                      BlockInit.MAG_COCO, 8, 0.6F, new ItemStack(MAG));
    public static final Item MAG_ICED_COCO        = new ItemCoffeeBase("mag_iced_coco",                 BlockInit.MAG_ICED_COCO, 9, 0.8F, new ItemStack(MAG));
    public static final Item MAG_FAIL_COFFEE      = new ItemCoffeeBase("mag_fail_coffee",               BlockInit.MAG_FAIL_COFFEE, 1, 0.1F, new ItemStack(MAG), new StatusEffect[]{StatusEffects.HUNGER, StatusEffects.BAD_OMEN}, 20 * 60, 0);
}