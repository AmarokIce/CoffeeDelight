package lcyzsdh.coffee_delight.data;

import lcyzsdh.coffee_delight.registry.ItemRegistry;
import lcyzsdh.coffee_delight.util.CoffeeType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput p_recipeOutput, HolderLookup.Provider holderLookup) {
        //cuttingboard recipe
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ItemRegistry.COFFEE_BERRIES.get()),Ingredient.of(CommonTags.TOOLS_KNIFE),ItemRegistry.COFFEE_BEANS.get(),1).build(p_recipeOutput);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ItemRegistry.COFFEE_BEANS_COOKED.get()),Ingredient.of(CommonTags.TOOLS_KNIFE),ItemRegistry.COFFEE_FLOUR.get(),1).build(p_recipeOutput);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ItemRegistry.COFFEE_PIE.get()),Ingredient.of(CommonTags.TOOLS_KNIFE),ItemRegistry.COFFEE_PIE_SIDE.get(),4).build(p_recipeOutput);

        //smelting recipe
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistry.COFFEE_BEANS.get()), RecipeCategory.FOOD,ItemRegistry.COFFEE_BEANS_COOKED.get(),0.35F,200).unlockedBy("has_coffee_berries",has(ItemRegistry.COFFEE_BERRIES.get())).save(p_recipeOutput);

        //cooking pot recipe
        CookingPotRecipeBuilder.cookingPotRecipe(ItemRegistry.QUICHE.get(),1,200,1.0F)
                .addIngredient(Items.EGG).addIngredient(Items.POTATO).addIngredient(ModItems.WHEAT_DOUGH.get())
                .unlockedBy("has_coffee",has(ItemRegistry.COFFEE_BEANS.get())).setRecipeBookTab(CookingPotRecipeBookTab.DRINKS).build(p_recipeOutput);
        CookingPotRecipeBuilder.cookingPotRecipe(ItemRegistry.COFFEE_MAP.get("cap_"+ CoffeeType.ICED_MOKA.getName()).get(),1,200,1.0F)
                .addIngredient(ItemRegistry.COFFEE_MAP.get("cap_"+ CoffeeType.MOKA.getName()).get()).addIngredient(Items.SNOWBALL)
                .unlockedBy("has_coffee",has(ItemRegistry.COFFEE_BEANS.get())).setRecipeBookTab(CookingPotRecipeBookTab.DRINKS).build(p_recipeOutput);

        //crafting recipe
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,ItemRegistry.WAFER.get(),2)
                .requires(ModItems.WHEAT_DOUGH.get()).requires(ModItems.MILK_BOTTLE.get()).requires(Items.SUGAR)
                .unlockedBy("has_wheat_dough",has(ModItems.WHEAT_DOUGH.get())).save(p_recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,ItemRegistry.COFFEE_WAFER.get())
                .requires(ItemRegistry.WAFER.get(),2).requires(ItemRegistry.COFFEE_FLOUR.get())
                .unlockedBy("has_wafer",has(ItemRegistry.WAFER.get())).save(p_recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,ItemRegistry.BERRIES_WAFER.get())
                .requires(ItemRegistry.WAFER.get(),2).requires(Items.SWEET_BERRIES)
                .unlockedBy("has_wafer",has(ItemRegistry.WAFER.get())).save(p_recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ItemRegistry.CUCCUMELA_TOP.get())
                .pattern("###").pattern("#*#").pattern("# #")
                .define('#',Items.COPPER_INGOT).define('*',Items.IRON_INGOT)
                .unlockedBy("has_coffee",has(ItemRegistry.COFFEE_BEANS.get())).save(p_recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ItemRegistry.CUCCUMELA_BOTTOM.get())
                .pattern(" # ").pattern("#*#").pattern("###")
                .define('#',Items.COPPER_INGOT).define('*',Items.HOPPER)
                .unlockedBy("has_coffee",has(ItemRegistry.COFFEE_BEANS.get())).save(p_recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ItemRegistry.CUCCUMELA_POT.get())
                .pattern(" x ").pattern("#*#").pattern("%-%")
                .define('x',ItemRegistry.CUCCUMELA_TOP.get()).define('#',Items.COPPER_INGOT).define('*',Items.HOPPER).define('%', Items.IRON_INGOT).define('-',ItemRegistry.CUCCUMELA_BOTTOM.get())
                .unlockedBy("has_coffee",has(ItemRegistry.COFFEE_BEANS.get())).save(p_recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS,ItemRegistry.COFFEE_BLOCK.get())
                .pattern("###").pattern("###").pattern("###")
                .define('#',ItemRegistry.COFFEE_BEANS.get())
                .unlockedBy("has_coffee",has(ItemRegistry.COFFEE_BEANS.get())).save(p_recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ItemRegistry.COFFEE_CAP.get())
                .pattern("   ").pattern("# #").pattern("###")
                .define('#',Items.QUARTZ)
                .unlockedBy("has_coffee",has(ItemRegistry.COFFEE_BEANS.get())).save(p_recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ItemRegistry.COFFEE_MAG.get(),2)
                .pattern("# #").pattern("#*#").pattern("###")
                .define('#',Items.BLUE_TERRACOTTA).define('*',Items.YELLOW_TERRACOTTA)
                .unlockedBy("has_coffee",has(ItemRegistry.COFFEE_BEANS.get())).save(p_recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ItemRegistry.MOKA_TOP.get())
                .pattern("###").pattern("# #").pattern("#*#")
                .define('#',Items.IRON_INGOT).define('*',Items.COPPER_INGOT)
                .unlockedBy("has_coffee",has(ItemRegistry.COFFEE_BEANS.get())).save(p_recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ItemRegistry.MOKA_BOTTOM.get())
                .pattern("#*#").pattern("#@#").pattern("###")
                .define('#',Items.IRON_INGOT).define('*',Items.COPPER_INGOT).define('@',Items.HOPPER)
                .unlockedBy("has_coffee",has(ItemRegistry.COFFEE_BEANS.get())).save(p_recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ItemRegistry.MOKA_POT.get())
                .pattern(" x ").pattern("#*#").pattern(" - ")
                .define('x',ItemRegistry.MOKA_TOP.get()).define('#',Items.IRON_INGOT).define('*',Items.HOPPER).define('-',ItemRegistry.MOKA_BOTTOM.get())
                .unlockedBy("has_coffee",has(ItemRegistry.COFFEE_BEANS.get())).save(p_recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ItemRegistry.TURKEY_HANDEL.get())
                .pattern("X**")
                .define('X',Items.IRON_INGOT).define('*', ItemTags.PLANKS)
                .unlockedBy("has_coffee",has(ItemRegistry.COFFEE_BEANS.get())).save(p_recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ItemRegistry.TURKEY_POT_PART.get())
                .pattern(" # ").pattern("###").pattern("###")
                .define('#',Items.COPPER_INGOT)
                .unlockedBy("has_coffee",has(ItemRegistry.COFFEE_BEANS.get())).save(p_recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ItemRegistry.TURKEY_POT.get())
                .requires(ItemRegistry.TURKEY_HANDEL.get()).requires(ItemRegistry.TURKEY_POT_PART.get())
                .unlockedBy("has_coffee",has(ItemRegistry.COFFEE_BEANS.get())).save(p_recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ItemRegistry.CLEVER.get())
                .pattern("# #").pattern("###").pattern(" # ")
                .define('#',Items.GLASS)
                .unlockedBy("has_coffee",has(ItemRegistry.COFFEE_BEANS.get())).save(p_recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ItemRegistry.COFFEE_MAP.get("cap_"+ CoffeeType.BLACK_COFFEE.getName()).get())
                .pattern(" # ").pattern(" * ").pattern(" ^ ")
                .define('#',ItemRegistry.COFFEE_FLOUR).define('*',ItemRegistry.CLEVER).define('^',ItemRegistry.COFFEE_CAP)
                .unlockedBy("has_coffee",has(ItemRegistry.COFFEE_BEANS.get())).save(p_recipeOutput);
    }
}
