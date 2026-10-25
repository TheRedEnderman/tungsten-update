package tungsten.update;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

public final class ModMenus {
    public static final MenuType<IndustrialSmelterMenu> INDUSTRIAL_SMELTER = Registry.register(
            BuiltInRegistries.MENU,
            TungstenUpdate.id("industrial_smelter"),
            new MenuType<IndustrialSmelterMenu>(IndustrialSmelterMenu::new, FeatureFlags.REGISTRY.subset())
    );

    public static void initialize() {}

    private ModMenus() {}
}