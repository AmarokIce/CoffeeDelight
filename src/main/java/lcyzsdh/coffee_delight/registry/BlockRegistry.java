package lcyzsdh.coffee_delight.registry;

import lcyzsdh.coffee_delight.CoffeeDelight;
import lcyzsdh.coffee_delight.block.*;
import lcyzsdh.coffee_delight.util.CoffeeType;
import lcyzsdh.coffee_delight.util.CupType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;

import java.util.HashMap;
import java.util.Map;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CoffeeDelight.MODID);

    public static final DeferredBlock<Block> COFFEE_BUSH = BLOCKS.register("coffee_bush", BlockCoffeeBush::new);
    public static final DeferredBlock<Block> COFFEE_BLOCK=BLOCKS.register("coffee_block",()->new Block(BlockBehaviour.Properties.ofFullCopy(ModBlocks.CABBAGE_CROP.get())));
    public static final DeferredBlock<Block> COFFEE_PIE=BLOCKS.register("coffee_pie",()->new PieBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.APPLE_PIE.get()),ItemRegistry.COFFEE_PIE_SIDE));
    public static final DeferredBlock<Block> CUCCUMELA_POT=BLOCKS.register("cuccumela_pot",()->new BlockCuccumelaPot(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> MOKA_POT=BLOCKS.register("moka_pot",()->new BlockMokaPot(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> TURKEY_POT=BLOCKS.register("turkey_pot",()->new BlockTurkeyPot(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> COFFEE_CAP=BLOCKS.register("coffee_cap", BlockCap::new);
    public static final DeferredBlock<Block> COFFEE_MAG=BLOCKS.register("coffee_mag",BlockCap::new);

    public static final Map<String, DeferredBlock<Block>> COFFEE_MAP=new HashMap<>();

    static {
        for(CoffeeType coffeeType : CoffeeType.values()){
            for(CupType cupType : CupType.values()){
                String name=cupType.toString()+"_"+coffeeType.getName();
                COFFEE_MAP.put(name,BLOCKS.register(name,()->new BlockCoffee(coffeeType,cupType)));
            }
        }
    }
    

}
