package club.someoneice.cofe_delight.init;

import club.someoneice.cofe_delight.util.Coffee;

public class CoffeeInit {
    /*
    public static final Coffee BLACK_COFFEE     = new Coffee("black_coffee", 3, 0.2F);
    public static final Coffee DOUBLE_ESPRESSO  = new Coffee("double_espresso_coffee", 7, 0.5F);
    public static final Coffee ARABICA_COFFEE   = new Coffee("arabic_coffee", 3, 0.2F);
    public static final Coffee TURKEY_COFFEE    = new Coffee("turkey_coffee", 3, 0.2F, new MobEffect[]{MobEffects.MOVEMENT_SPEED}, 20 * 30, 0);
    public static final Coffee LATTE            = new Coffee("latte_coffee", 5, 0.3F);
    public static final Coffee MOKA             = new Coffee("moka_coffee", 7, 0.3F);
    public static final Coffee CAPPUCCINO       = new Coffee("cappuccino", 6, 0.4F);
    public static final Coffee USA              = new Coffee("usa_coffee", 4, 0.2F);
    public static final Coffee MACCHIATO        = new Coffee("macchiato", 9, 0.6F, new MobEffect[]{MobEffects.MOVEMENT_SPEED, MobEffects.DIG_SPEED}, 20 * 30, 1);
    public static final Coffee MILK_COFFEE      = new Coffee("milk_coffee", 6, 0.5F);
    public static final Coffee ICED_LATTE       = new Coffee("iced_lattee_coffee", 6, 0.4F);
    public static final Coffee ICED_MOKA        = new Coffee("iced_moka", 8, 0.4F);
    public static final Coffee ICED_CAPPUCCINO  = new Coffee("iced_cappuccino", 7, 0.5F);
    public static final Coffee ICED_USA         = new Coffee("iced_usa_coffee", 5, 0.2F);
    public static final Coffee ICED_MACCHIATO   = new Coffee("iced_macchiato", 10, 0.7F);
    public static final Coffee COCO             = new Coffee("coco", 8, 0.6F);
    public static final Coffee ICED_COCO        = new Coffee("iced_coco", 9, 0.8F);
    public static final Coffee FAIL_COFFEE      = new Coffee("fail_coffee", 1, 0.1F, new MobEffect[]{MobEffects.HUNGER, MobEffects.BAD_OMEN}, 20 * 60, 0);
    */

    public static final Coffee BLACK_COFFEE     = new Coffee(ItemInit.MUG_BLACK_COFFEE, ItemInit.CUP_BLACK_COFFEE, BlockInit.MUG_BLACK_COFFEE, BlockInit.CUP_BLACK_COFFEE);
    public static final Coffee DOUBLE_ESPRESSO  = new Coffee(ItemInit.MUG_DOUBLE_ESPRESSO, ItemInit.CUP_DOUBLE_ESPRESSO, BlockInit.MUG_DOUBLE_ESPRESSO, BlockInit.CUP_DOUBLE_ESPRESSO);
    public static final Coffee ARABICA_COFFEE   = new Coffee(ItemInit.MUG_ARABICA_COFFEE, ItemInit.CUP_ARABICA_COFFEE, BlockInit.MUG_ARABICA_COFFEE, BlockInit.CUP_ARABICA_COFFEE);
    public static final Coffee TURKEY_COFFEE    = new Coffee(ItemInit.MUG_TURKEY_COFFEE, ItemInit.CUP_TURKEY_COFFEE, BlockInit.MUG_TURKEY_COFFEE, BlockInit.CUP_TURKEY_COFFEE);
    public static final Coffee LATTE            = new Coffee(ItemInit.MUG_LATTE, ItemInit.CUP_LATTE, BlockInit.MUG_LATTE, BlockInit.CUP_LATTE);
    public static final Coffee MOKA             = new Coffee(ItemInit.MUG_MOKA, ItemInit.CUP_MOKA, BlockInit.MUG_MOKA, BlockInit.CUP_MOKA);
    public static final Coffee CAPPUCCINO       = new Coffee(ItemInit.MUG_CAPPUCCINO, ItemInit.CUP_CAPPUCCINO, BlockInit.MUG_CAPPUCCINO, BlockInit.CUP_CAPPUCCINO);
    public static final Coffee USA              = new Coffee(ItemInit.MUG_USA, ItemInit.CUP_USA, BlockInit.MUG_USA, BlockInit.CUP_USA);
    public static final Coffee MACCHIATO        = new Coffee(ItemInit.MUG_MACCHIATO, ItemInit.CUP_MACCHIATO, BlockInit.MUG_MACCHIATO, BlockInit.CUP_MACCHIATO);
    public static final Coffee MILK_COFFEE      = new Coffee(ItemInit.MUG_MILK_COFFEE, ItemInit.CUP_MILK_COFFEE, BlockInit.MUG_MILK_COFFEE, BlockInit.CUP_MILK_COFFEE);
    public static final Coffee ICED_LATTE       = new Coffee(ItemInit.MUG_ICED_LATTE, ItemInit.CUP_ICED_LATTE, BlockInit.MUG_ICED_LATTE, BlockInit.CUP_ICED_LATTE);
    public static final Coffee ICED_MOKA        = new Coffee(ItemInit.MUG_ICED_MOKA, ItemInit.CUP_ICED_MOKA, BlockInit.MUG_ICED_MOKA, BlockInit.CUP_ICED_MOKA);
    public static final Coffee ICED_CAPPUCCINO  = new Coffee(ItemInit.MUG_ICED_CAPPUCCINO, ItemInit.CUP_ICED_CAPPUCCINO, BlockInit.MUG_ICED_CAPPUCCINO, BlockInit.CUP_ICED_CAPPUCCINO);
    public static final Coffee ICED_USA         = new Coffee(ItemInit.MUG_ICED_USA, ItemInit.CUP_ICED_USA, BlockInit.MUG_ICED_USA, BlockInit.CUP_ICED_USA);
    public static final Coffee ICED_MACCHIATO   = new Coffee(ItemInit.MUG_ICED_MACCHIATO, ItemInit.CUP_ICED_MACCHIATO, BlockInit.MUG_ICED_MACCHIATO, BlockInit.CUP_ICED_MACCHIATO);
    public static final Coffee COCO             = new Coffee(ItemInit.MUG_COCO, ItemInit.CUP_COCO, BlockInit.MUG_COCO, BlockInit.CUP_COCO);
    public static final Coffee ICED_COCO        = new Coffee(ItemInit.MUG_ICED_COCO, ItemInit.CUP_ICED_COCO, BlockInit.MUG_ICED_COCO, BlockInit.CUP_ICED_COCO);
    public static final Coffee FAIL_COFFEE      = new Coffee(ItemInit.MUG_FAIL_COFFEE, ItemInit.CUP_FAIL_COFFEE, BlockInit.MUG_FAIL_COFFEE, BlockInit.CUP_FAIL_COFFEE);
}
