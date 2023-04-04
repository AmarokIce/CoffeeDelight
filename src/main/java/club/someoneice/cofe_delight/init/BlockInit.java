package club.someoneice.cofe_delight.init;

import club.someoneice.cofe_delight.common.block.*;
import club.someoneice.cofe_delight.util.BlockBean;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;

public class BlockInit {
    public static final Block COFFEE_PIE = new BlockPie("coffee_pie", ItemInit.COFFEE_PIE_SIDE);
    public static final Block COFFEE_CAP = new BlockCap("coffee_cap");
    public static final Block COFFEE_MAG = new BlockCap("coffee_mag");
    public static final Block COFFEE_BUSH = new CoffeeBush("coffee_bush");
    // public static final Block COFFEE_WILD_BUSH = ("coffee_wild_bush", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)));
    public static final Block COFFEE_BLOCK = BlockBean.block("coffee_block");


    public static final Block CUCCUMELA_POT = new CoffeeCuccumelaPot("cuccumela_pot");
    public static final Block MOKA_POT = new CoffeeMokaPot("moka_pot");
    public static final Block TURKEY_POT = new CoffeeTurkeyPot("turkey_pot");

    public static final Block CAP_BLACK_COFFEE     = new BlockCoffee("cap_black_coffee",            3, 0.2F, BlockBean.CAP.CAP);
    public static final Block CAP_DOUBLE_ESPRESSO  = new BlockCoffee("cap_double_espresso_coffee",  7, 0.5F, BlockBean.CAP.CAP);
    public static final Block CAP_ARABICA_COFFEE   = new BlockCoffee("cap_arabic_coffee",           3, 0.2F, BlockBean.CAP.CAP);
    public static final Block CAP_TURKEY_COFFEE    = new BlockCoffee("cap_turkey_coffee",           3, 0.2F, BlockBean.CAP.CAP, new StatusEffect[]{StatusEffects.SPEED}, 20 * 30, 0);
    public static final Block CAP_LATTE            = new BlockCoffee("cap_latte_coffee",            5, 0.3F, BlockBean.CAP.CAP);
    public static final Block CAP_MOKA             = new BlockCoffee("cap_moka_coffee",             7, 0.3F, BlockBean.CAP.CAP);
    public static final Block CAP_CAPPUCCINO       = new BlockCoffee("cap_cappuccino",              6, 0.4F, BlockBean.CAP.CAP);
    public static final Block CAP_USA              = new BlockCoffee("cap_usa_coffee",              4, 0.2F, BlockBean.CAP.CAP);
    public static final Block CAP_MACCHIATO        = new BlockCoffee("cap_macchiato",               9, 0.6F, BlockBean.CAP.CAP, new StatusEffect[]{StatusEffects.SPEED, StatusEffects.HASTE}, 20 * 30, 1);
    public static final Block CAP_MILK_COFFEE      = new BlockCoffee("cap_milk_coffee",             6, 0.5F, BlockBean.CAP.CAP);
    public static final Block CAP_ICED_LATTE       = new BlockCoffee("cap_iced_lattee_coffee",      6, 0.4F, BlockBean.CAP.CAP);
    public static final Block CAP_ICED_MOKA        = new BlockCoffee("cap_iced_moka",               8, 0.4F, BlockBean.CAP.CAP);
    public static final Block CAP_ICED_CAPPUCCINO  = new BlockCoffee("cap_iced_cappuccino",         7, 0.5F, BlockBean.CAP.CAP);
    public static final Block CAP_ICED_USA         = new BlockCoffee("cap_iced_usa_coffee",         5, 0.2F, BlockBean.CAP.CAP);
    public static final Block CAP_ICED_MACCHIATO   = new BlockCoffee("cap_iced_macchiato",          10, 0.7F, BlockBean.CAP.CAP);
    public static final Block CAP_COCO             = new BlockCoffee("cap_coco",                    8, 0.6F, BlockBean.CAP.CAP);
    public static final Block CAP_ICED_COCO        = new BlockCoffee("cap_iced_coco",               9, 0.8F, BlockBean.CAP.CAP);
    public static final Block CAP_FAIL_COFFEE      = new BlockCoffee("cap_fail_coffee",             1, 0.1F, BlockBean.CAP.CAP, new StatusEffect[]{StatusEffects.HUNGER, StatusEffects.BAD_OMEN}, 20 * 60, 0);

    public static final Block MAG_BLACK_COFFEE     = new BlockCoffee("mag_black_coffee",            3, 0.2F, BlockBean.CAP.MAG);
    public static final Block MAG_DOUBLE_ESPRESSO  = new BlockCoffee("mag_double_espresso_coffee",  7, 0.5F, BlockBean.CAP.MAG);
    public static final Block MAG_ARABICA_COFFEE   = new BlockCoffee("mag_arabic_coffee",           3, 0.2F, BlockBean.CAP.MAG);
    public static final Block MAG_TURKEY_COFFEE    = new BlockCoffee("mag_turkey_coffee",           3, 0.2F, BlockBean.CAP.MAG, new StatusEffect[]{StatusEffects.SPEED}, 20 * 30, 0);
    public static final Block MAG_LATTE            = new BlockCoffee("mag_latte_coffee",            5, 0.3F, BlockBean.CAP.MAG);
    public static final Block MAG_MOKA             = new BlockCoffee("mag_moka_coffee",             7, 0.3F, BlockBean.CAP.MAG);
    public static final Block MAG_CAPPUCCINO       = new BlockCoffee("mag_cappuccino",              6, 0.4F, BlockBean.CAP.MAG);
    public static final Block MAG_USA              = new BlockCoffee("mag_usa_coffee",              4, 0.2F, BlockBean.CAP.MAG);
    public static final Block MAG_MACCHIATO        = new BlockCoffee("mag_macchiato",               9, 0.6F, BlockBean.CAP.MAG, new StatusEffect[]{StatusEffects.SPEED, StatusEffects.HASTE}, 20 * 30, 1);
    public static final Block MAG_MILK_COFFEE      = new BlockCoffee("mag_milk_coffee",             6, 0.5F, BlockBean.CAP.MAG);
    public static final Block MAG_ICED_LATTE       = new BlockCoffee("mag_iced_lattee_coffee",      6, 0.4F, BlockBean.CAP.MAG);
    public static final Block MAG_ICED_MOKA        = new BlockCoffee("mag_iced_moka",               8, 0.4F, BlockBean.CAP.MAG);
    public static final Block MAG_ICED_CAPPUCCINO  = new BlockCoffee("mag_iced_cappuccino",         7, 0.5F, BlockBean.CAP.MAG);
    public static final Block MAG_ICED_USA         = new BlockCoffee("mag_iced_usa_coffee",         5, 0.2F, BlockBean.CAP.MAG);
    public static final Block MAG_ICED_MACCHIATO   = new BlockCoffee("mag_iced_macchiato",          10, 0.7F, BlockBean.CAP.MAG);
    public static final Block MAG_COCO             = new BlockCoffee("mag_coco",                    8, 0.6F, BlockBean.CAP.MAG);
    public static final Block MAG_ICED_COCO        = new BlockCoffee("mag_iced_coco",               9, 0.8F, BlockBean.CAP.MAG);
    public static final Block MAG_FAIL_COFFEE      = new BlockCoffee("mag_fail_coffee",             1, 0.1F, BlockBean.CAP.MAG, new StatusEffect[]{StatusEffects.HUNGER, StatusEffects.BAD_OMEN}, 20 * 60, 0);
}
