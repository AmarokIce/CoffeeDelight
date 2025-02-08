package lcyzsdh.coffee_delight.data.lootable;

import lcyzsdh.coffee_delight.block.BlockCoffeeBush;
import lcyzsdh.coffee_delight.registry.BlockRegistry;
import lcyzsdh.coffee_delight.registry.ItemRegistry;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.HashSet;
import java.util.Set;

public class ModBlockLootSubProvider extends BlockLootSubProvider {
    private static final Set<Block> BLOCK_SET=new HashSet<>();
    public ModBlockLootSubProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        BlockRegistry.BLOCKS.getEntries().forEach(entry->{
            BLOCK_SET.add(entry.get());
            Block block=entry.get();
            if(entry.getRegisteredName().equals(BlockRegistry.COFFEE_BUSH.getRegisteredName())) {
                add(block, value -> applyExplosionDecay(value,
                        LootTable.lootTable()
                                .withPool(
                                LootPool.lootPool()
                                        .when(
                                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.COFFEE_BUSH.get())
                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockCoffeeBush.AGE, 3))
                                        )
                                        .add(LootItem.lootTableItem(ItemRegistry.COFFEE_BERRIES.get()))
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                        )
                                .withPool(
                                        LootPool.lootPool()
                                                .when(
                                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.COFFEE_BUSH.get())
                                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                                )
                                                .add(LootItem.lootTableItem(ItemRegistry.COFFEE_BERRIES.get()))
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                                )));
            }
            else{
                dropSelf(block);
            }
        });
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BLOCK_SET;
    }
}
