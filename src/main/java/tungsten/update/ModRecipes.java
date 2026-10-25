package tungsten.update;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public final class ModRecipes {
    public static final RecipeType<IndustrialSmeltingRecipe> INDUSTRIAL_SMELTING = Registry.register(
            BuiltInRegistries.RECIPE_TYPE,
            TungstenUpdate.id("industrial_smelting"),
            new RecipeType<IndustrialSmeltingRecipe>() {
                @Override
                public String toString() {
                    return "industrial_smelting";
                }
            }
    );

    public static final RecipeSerializer<IndustrialSmeltingRecipe> INDUSTRIAL_SMELTING_SERIALIZER = Registry.register(
            BuiltInRegistries.RECIPE_SERIALIZER,
            TungstenUpdate.id("industrial_smelting"),
            IndustrialSmeltingRecipe.SERIALIZER
    );

    public static void initialize() {}

    private ModRecipes() {}
}