package club.someoneice.cofe_delight.mixin;

import club.someoneice.cofe_delight.common.item.ItemToolBase;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Item.class)
public class ItemMixin {
    @Mutable
    @Shadow @Final
    private Item recipeRemainder;

    @Inject(method = "<init>", at = {@At("TAIL")})
    public void finishCrafting(Item.Settings settings, CallbackInfo ci) {
        Item thisInstance = (Item)(Object)this;
        if (thisInstance instanceof ItemToolBase) {
            this.recipeRemainder = thisInstance;
        }
    }
}
