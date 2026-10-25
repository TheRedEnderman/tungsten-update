package tungsten.update;

import com.mojang.serialization.MapCodec;
import java.util.List;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.display.RecipeDisplay;

public class IndustrialSmeltingRecipe extends AbstractCookingRecipe {
    public static final MapCodec<IndustrialSmeltingRecipe> MAP_CODEC = cookingMapCodec(IndustrialSmeltingRecipe::new);
    public static final StreamCodec<RegistryFriendlyByteBuf, IndustrialSmeltingRecipe> STREAM_CODEC = cookingStreamCodec(IndustrialSmeltingRecipe::new);
    public static final RecipeSerializer<IndustrialSmeltingRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);

    public IndustrialSmeltingRecipe(
            Recipe.CommonInfo commonInfo,
            AbstractCookingRecipe.CookingBookInfo bookInfo,
            Ingredient ingredient,
            ItemStackTemplate result,
            float experience,
            int cookingTime
    ) {
        super(commonInfo, bookInfo, ingredient, result, experience, cookingTime);
    }

    @Override
    protected Item furnaceIcon() {
        return Items.BLAST_FURNACE;
    }

    @Override
    public RecipeSerializer<IndustrialSmeltingRecipe> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public RecipeType<IndustrialSmeltingRecipe> getType() {
        return ModRecipes.INDUSTRIAL_SMELTING;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.BLAST_FURNACE_MISC;
    }

    /** No recipe book entry: this recipe must not show up in (or be placed from) the vanilla blast furnace book. */
    @Override
    public List<RecipeDisplay> display() {
        return List.of();
    }
}