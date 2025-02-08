package lcyzsdh.coffee_delight.item;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class ItemCoffeePie extends BlockItem {
    public ItemCoffeePie(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public @NotNull UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        if(context.getPlayer().isShiftKeyDown()){
            return super.useOn(context);
        }
        return InteractionResult.PASS;
    }
}
