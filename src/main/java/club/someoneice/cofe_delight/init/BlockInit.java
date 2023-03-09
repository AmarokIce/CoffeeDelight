package club.someoneice.cofe_delight.init;

import club.someoneice.cofe_delight.CoffeeDelight;
import club.someoneice.cofe_delight.common.block.*;
import club.someoneice.cofe_delight.util.BlockBean;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.PieBlock;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CoffeeDelight.MODID);

    public static final RegistryObject<Block> COFFEE_PIE = BLOCKS.register("coffee_pie",  () -> new PieBlock(BlockBehaviour.Properties.of(Material.CAKE),ItemInit.COFFEE_PIE_SIDE));
    public static final RegistryObject<Block> COFFEE_CAP = BLOCKS.register("coffee_cap", BlockCap::new);
    public static final RegistryObject<Block> COFFEE_MAG = BLOCKS.register("coffee_mag", BlockCap::new);
    public static final RegistryObject<Block> COFFEE_BUSH = BLOCKS.register("coffee_bush", CoffeeBush::new);
    // public static final RegistryObject<Block> COFFEE_WILD_BUSH = BLOCKS.register("coffee_wild_bush", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)));
    public static final RegistryObject<Block> COFFEE_BLOCK = BLOCKS.register("coffee_block", () -> new Block(BlockBehaviour.Properties.of(Material.PLANT)));


    public static final RegistryObject<Block> CUCCUMELA_POT = BLOCKS.register("cuccumela_pot", CoffeeCuccumelaPot::new);
    public static final RegistryObject<Block> MOKA_POT = BLOCKS.register("moka_pot", CoffeeMokaPot::new);
    public static final RegistryObject<Block> TURKEY_POT = BLOCKS.register("turkey_pot", CoffeeTurkeyPot::new);

    public static final RegistryObject<Block> CAP_BLACK_COFFEE     = BLOCKS.register("cap_black_coffee",            () -> new BlockCoffee(3, 0.2F, BlockBean.CAP.CAP));
    public static final RegistryObject<Block> CAP_DOUBLE_ESPRESSO  = BLOCKS.register("cap_double_espresso_coffee",  () -> new BlockCoffee(7, 0.5F, BlockBean.CAP.CAP));
    public static final RegistryObject<Block> CAP_ARABICA_COFFEE   = BLOCKS.register("cap_arabic_coffee",           () -> new BlockCoffee(3, 0.2F, BlockBean.CAP.CAP));
    public static final RegistryObject<Block> CAP_TURKEY_COFFEE    = BLOCKS.register("cap_turkey_coffee",           () -> new BlockCoffee(3, 0.2F, BlockBean.CAP.CAP, new MobEffect[]{MobEffects.MOVEMENT_SPEED}, 20 * 30, 0));
    public static final RegistryObject<Block> CAP_LATTE            = BLOCKS.register("cap_latte_coffee",            () -> new BlockCoffee(5, 0.3F, BlockBean.CAP.CAP));
    public static final RegistryObject<Block> CAP_MOKA             = BLOCKS.register("cap_moka_coffee",             () -> new BlockCoffee(7, 0.3F, BlockBean.CAP.CAP));
    public static final RegistryObject<Block> CAP_CAPPUCCINO       = BLOCKS.register("cap_cappuccino",              () -> new BlockCoffee(6, 0.4F, BlockBean.CAP.CAP));
    public static final RegistryObject<Block> CAP_USA              = BLOCKS.register("cap_usa_coffee",              () -> new BlockCoffee(4, 0.2F, BlockBean.CAP.CAP));
    public static final RegistryObject<Block> CAP_MACCHIATO        = BLOCKS.register("cap_macchiato",               () -> new BlockCoffee(9, 0.6F, BlockBean.CAP.CAP, new MobEffect[]{MobEffects.MOVEMENT_SPEED, MobEffects.DIG_SPEED}, 20 * 30, 1));
    public static final RegistryObject<Block> CAP_MILK_COFFEE      = BLOCKS.register("cap_milk_coffee",             () -> new BlockCoffee(6, 0.5F, BlockBean.CAP.CAP));
    public static final RegistryObject<Block> CAP_ICED_LATTE       = BLOCKS.register("cap_iced_lattee_coffee",      () -> new BlockCoffee(6, 0.4F, BlockBean.CAP.CAP));
    public static final RegistryObject<Block> CAP_ICED_MOKA        = BLOCKS.register("cap_iced_moka",               () -> new BlockCoffee(8, 0.4F, BlockBean.CAP.CAP));
    public static final RegistryObject<Block> CAP_ICED_CAPPUCCINO  = BLOCKS.register("cap_iced_cappuccino",         () -> new BlockCoffee(7, 0.5F, BlockBean.CAP.CAP));
    public static final RegistryObject<Block> CAP_ICED_USA         = BLOCKS.register("cap_iced_usa_coffee",         () -> new BlockCoffee(5, 0.2F, BlockBean.CAP.CAP));
    public static final RegistryObject<Block> CAP_ICED_MACCHIATO   = BLOCKS.register("cap_iced_macchiato",          () -> new BlockCoffee(10, 0.7F, BlockBean.CAP.CAP));
    public static final RegistryObject<Block> CAP_COCO             = BLOCKS.register("cap_coco",                    () -> new BlockCoffee(8, 0.6F, BlockBean.CAP.CAP));
    public static final RegistryObject<Block> CAP_ICED_COCO        = BLOCKS.register("cap_iced_coco",               () -> new BlockCoffee(9, 0.8F, BlockBean.CAP.CAP));
    public static final RegistryObject<Block> CAP_FAIL_COFFEE      = BLOCKS.register("cap_fail_coffee",             () -> new BlockCoffee(1, 0.1F, BlockBean.CAP.CAP, new MobEffect[]{MobEffects.HUNGER, MobEffects.BAD_OMEN}, 20 * 60, 0));

    public static final RegistryObject<Block> MAG_BLACK_COFFEE     = BLOCKS.register("mag_black_coffee",            () -> new BlockCoffee(3, 0.2F, BlockBean.CAP.MAG));
    public static final RegistryObject<Block> MAG_DOUBLE_ESPRESSO  = BLOCKS.register("mag_double_espresso_coffee",  () -> new BlockCoffee(7, 0.5F, BlockBean.CAP.MAG));
    public static final RegistryObject<Block> MAG_ARABICA_COFFEE   = BLOCKS.register("mag_arabic_coffee",           () -> new BlockCoffee(3, 0.2F, BlockBean.CAP.MAG));
    public static final RegistryObject<Block> MAG_TURKEY_COFFEE    = BLOCKS.register("mag_turkey_coffee",           () -> new BlockCoffee(3, 0.2F, BlockBean.CAP.MAG, new MobEffect[]{MobEffects.MOVEMENT_SPEED}, 20 * 30, 0));
    public static final RegistryObject<Block> MAG_LATTE            = BLOCKS.register("mag_latte_coffee",            () -> new BlockCoffee(5, 0.3F, BlockBean.CAP.MAG));
    public static final RegistryObject<Block> MAG_MOKA             = BLOCKS.register("mag_moka_coffee",             () -> new BlockCoffee(7, 0.3F, BlockBean.CAP.MAG));
    public static final RegistryObject<Block> MAG_CAPPUCCINO       = BLOCKS.register("mag_cappuccino",              () -> new BlockCoffee(6, 0.4F, BlockBean.CAP.MAG));
    public static final RegistryObject<Block> MAG_USA              = BLOCKS.register("mag_usa_coffee",              () -> new BlockCoffee(4, 0.2F, BlockBean.CAP.MAG));
    public static final RegistryObject<Block> MAG_MACCHIATO        = BLOCKS.register("mag_macchiato",               () -> new BlockCoffee(9, 0.6F, BlockBean.CAP.MAG, new MobEffect[]{MobEffects.MOVEMENT_SPEED, MobEffects.DIG_SPEED}, 20 * 30, 1));
    public static final RegistryObject<Block> MAG_MILK_COFFEE      = BLOCKS.register("mag_milk_coffee",             () -> new BlockCoffee(6, 0.5F, BlockBean.CAP.MAG));
    public static final RegistryObject<Block> MAG_ICED_LATTE       = BLOCKS.register("mag_iced_lattee_coffee",      () -> new BlockCoffee(6, 0.4F, BlockBean.CAP.MAG));
    public static final RegistryObject<Block> MAG_ICED_MOKA        = BLOCKS.register("mag_iced_moka",               () -> new BlockCoffee(8, 0.4F, BlockBean.CAP.MAG));
    public static final RegistryObject<Block> MAG_ICED_CAPPUCCINO  = BLOCKS.register("mag_iced_cappuccino",         () -> new BlockCoffee(7, 0.5F, BlockBean.CAP.MAG));
    public static final RegistryObject<Block> MAG_ICED_USA         = BLOCKS.register("mag_iced_usa_coffee",         () -> new BlockCoffee(5, 0.2F, BlockBean.CAP.MAG));
    public static final RegistryObject<Block> MAG_ICED_MACCHIATO   = BLOCKS.register("mag_iced_macchiato",          () -> new BlockCoffee(10, 0.7F, BlockBean.CAP.MAG));
    public static final RegistryObject<Block> MAG_COCO             = BLOCKS.register("mag_coco",                    () -> new BlockCoffee(8, 0.6F, BlockBean.CAP.MAG));
    public static final RegistryObject<Block> MAG_ICED_COCO        = BLOCKS.register("mag_iced_coco",               () -> new BlockCoffee(9, 0.8F, BlockBean.CAP.MAG));
    public static final RegistryObject<Block> MAG_FAIL_COFFEE      = BLOCKS.register("mag_fail_coffee",             () -> new BlockCoffee(1, 0.1F, BlockBean.CAP.MAG, new MobEffect[]{MobEffects.HUNGER, MobEffects.BAD_OMEN}, 20 * 60, 0));
}
