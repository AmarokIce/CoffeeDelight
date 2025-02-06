package club.someoneice.cofe_delight.init;

import club.someoneice.cofe_delight.CoffeeDelight;
import club.someoneice.cofe_delight.common.block.*;
import club.someoneice.cofe_delight.util.CupType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.PieBlock;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CoffeeDelight.MODID);

    public static final RegistryObject<Block> COFFEE_PIE = BLOCKS.register("coffee_pie",  () -> new PieBlock(BlockBehaviour.Properties.of(),ItemInit.COFFEE_PIE_SIDE));
    public static final RegistryObject<Block> COFFEE_CUP = BLOCKS.register("coffee_cap", BlockCap::new);
    public static final RegistryObject<Block> COFFEE_MUG = BLOCKS.register("coffee_mag", BlockCap::new);
    public static final RegistryObject<Block> COFFEE_BUSH = BLOCKS.register("coffee_bush", CoffeeBush::new);

    public static final RegistryObject<Block> COFFEE_BLOCK = BLOCKS.register("coffee_block", () -> new Block(BlockBehaviour.Properties.of()));


    public static final RegistryObject<Block> CUCCUMELA_POT = BLOCKS.register("cuccumela_pot", CoffeeCuccumelaPot::new);
    public static final RegistryObject<Block> MOKA_POT = BLOCKS.register("moka_pot", CoffeeMokaPot::new);
    public static final RegistryObject<Block> TURKEY_POT = BLOCKS.register("turkey_pot", CoffeeTurkeyPot::new);

    public static final RegistryObject<Block> CUP_BLACK_COFFEE     = BLOCKS.register("cup_black_coffee",            () -> new BlockCoffee(3, 0.2F, CupType.CUP));
    public static final RegistryObject<Block> CUP_DOUBLE_ESPRESSO  = BLOCKS.register("cup_double_espresso_coffee",  () -> new BlockCoffee(7, 0.5F, CupType.CUP));
    public static final RegistryObject<Block> CUP_ARABICA_COFFEE   = BLOCKS.register("cup_arabic_coffee",           () -> new BlockCoffee(3, 0.2F, CupType.CUP));
    public static final RegistryObject<Block> CUP_TURKEY_COFFEE    = BLOCKS.register("cup_turkey_coffee",           () -> new BlockCoffee(3, 0.2F, CupType.CUP, new MobEffect[]{MobEffects.MOVEMENT_SPEED}, 20 * 30, 0));
    public static final RegistryObject<Block> CUP_LATTE            = BLOCKS.register("cup_latte_coffee",            () -> new BlockCoffee(5, 0.3F, CupType.CUP));
    public static final RegistryObject<Block> CUP_MOKA             = BLOCKS.register("cup_moka_coffee",             () -> new BlockCoffee(7, 0.3F, CupType.CUP));
    public static final RegistryObject<Block> CUP_CAPPUCCINO       = BLOCKS.register("cup_cappuccino",              () -> new BlockCoffee(6, 0.4F, CupType.CUP));
    public static final RegistryObject<Block> CUP_USA              = BLOCKS.register("cup_usa_coffee",              () -> new BlockCoffee(4, 0.2F, CupType.CUP));
    public static final RegistryObject<Block> CUP_MACCHIATO        = BLOCKS.register("cup_macchiato",               () -> new BlockCoffee(9, 0.6F, CupType.CUP, new MobEffect[]{MobEffects.MOVEMENT_SPEED, MobEffects.DIG_SPEED}, 20 * 30, 1));
    public static final RegistryObject<Block> CUP_MILK_COFFEE      = BLOCKS.register("cup_milk_coffee",             () -> new BlockCoffee(6, 0.5F, CupType.CUP));
    public static final RegistryObject<Block> CUP_ICED_LATTE       = BLOCKS.register("cup_iced_lattee_coffee",      () -> new BlockCoffee(6, 0.4F, CupType.CUP));
    public static final RegistryObject<Block> CUP_ICED_MOKA        = BLOCKS.register("cup_iced_moka",               () -> new BlockCoffee(8, 0.4F, CupType.CUP));
    public static final RegistryObject<Block> CUP_ICED_CAPPUCCINO  = BLOCKS.register("cup_iced_cappuccino",         () -> new BlockCoffee(7, 0.5F, CupType.CUP));
    public static final RegistryObject<Block> CUP_ICED_USA         = BLOCKS.register("cup_iced_usa_coffee",         () -> new BlockCoffee(5, 0.2F, CupType.CUP));
    public static final RegistryObject<Block> CUP_ICED_MACCHIATO   = BLOCKS.register("cup_iced_macchiato",          () -> new BlockCoffee(10, 0.7F, CupType.CUP));
    public static final RegistryObject<Block> CUP_COCO             = BLOCKS.register("cup_coco",                    () -> new BlockCoffee(8, 0.6F, CupType.CUP));
    public static final RegistryObject<Block> CUP_ICED_COCO        = BLOCKS.register("cup_iced_coco",               () -> new BlockCoffee(9, 0.8F, CupType.CUP));
    public static final RegistryObject<Block> CUP_FAIL_COFFEE      = BLOCKS.register("cup_fail_coffee",             () -> new BlockCoffee(1, 0.1F, CupType.CUP, new MobEffect[]{MobEffects.HUNGER, MobEffects.BAD_OMEN}, 20 * 60, 0));

    public static final RegistryObject<Block> MUG_BLACK_COFFEE     = BLOCKS.register("mug_black_coffee",            () -> new BlockCoffee(3, 0.2F, CupType.MUG));
    public static final RegistryObject<Block> MUG_DOUBLE_ESPRESSO  = BLOCKS.register("mug_double_espresso_coffee",  () -> new BlockCoffee(7, 0.5F, CupType.MUG));
    public static final RegistryObject<Block> MUG_ARABICA_COFFEE   = BLOCKS.register("mug_arabic_coffee",           () -> new BlockCoffee(3, 0.2F, CupType.MUG));
    public static final RegistryObject<Block> MUG_TURKEY_COFFEE    = BLOCKS.register("mug_turkey_coffee",           () -> new BlockCoffee(3, 0.2F, CupType.MUG, new MobEffect[]{MobEffects.MOVEMENT_SPEED}, 20 * 30, 0));
    public static final RegistryObject<Block> MUG_LATTE            = BLOCKS.register("mug_latte_coffee",            () -> new BlockCoffee(5, 0.3F, CupType.MUG));
    public static final RegistryObject<Block> MUG_MOKA             = BLOCKS.register("mug_moka_coffee",             () -> new BlockCoffee(7, 0.3F, CupType.MUG));
    public static final RegistryObject<Block> MUG_CAPPUCCINO       = BLOCKS.register("mug_cappuccino",              () -> new BlockCoffee(6, 0.4F, CupType.MUG));
    public static final RegistryObject<Block> MUG_USA              = BLOCKS.register("mug_usa_coffee",              () -> new BlockCoffee(4, 0.2F, CupType.MUG));
    public static final RegistryObject<Block> MUG_MACCHIATO        = BLOCKS.register("mug_macchiato",               () -> new BlockCoffee(9, 0.6F, CupType.MUG, new MobEffect[]{MobEffects.MOVEMENT_SPEED, MobEffects.DIG_SPEED}, 20 * 30, 1));
    public static final RegistryObject<Block> MUG_MILK_COFFEE      = BLOCKS.register("mug_milk_coffee",             () -> new BlockCoffee(6, 0.5F, CupType.MUG));
    public static final RegistryObject<Block> MUG_ICED_LATTE       = BLOCKS.register("mug_iced_lattee_coffee",      () -> new BlockCoffee(6, 0.4F, CupType.MUG));
    public static final RegistryObject<Block> MUG_ICED_MOKA        = BLOCKS.register("mug_iced_moka",               () -> new BlockCoffee(8, 0.4F, CupType.MUG));
    public static final RegistryObject<Block> MUG_ICED_CAPPUCCINO  = BLOCKS.register("mug_iced_cappuccino",         () -> new BlockCoffee(7, 0.5F, CupType.MUG));
    public static final RegistryObject<Block> MUG_ICED_USA         = BLOCKS.register("mug_iced_usa_coffee",         () -> new BlockCoffee(5, 0.2F, CupType.MUG));
    public static final RegistryObject<Block> MUG_ICED_MACCHIATO   = BLOCKS.register("mug_iced_macchiato",          () -> new BlockCoffee(10, 0.7F, CupType.MUG));
    public static final RegistryObject<Block> MUG_COCO             = BLOCKS.register("mug_coco",                    () -> new BlockCoffee(8, 0.6F, CupType.MUG));
    public static final RegistryObject<Block> MUG_ICED_COCO        = BLOCKS.register("mug_iced_coco",               () -> new BlockCoffee(9, 0.8F, CupType.MUG));
    public static final RegistryObject<Block> MUG_FAIL_COFFEE      = BLOCKS.register("mug_fail_coffee",             () -> new BlockCoffee(1, 0.1F, CupType.MUG, new MobEffect[]{MobEffects.HUNGER, MobEffects.BAD_OMEN}, 20 * 60, 0));
}
