package tungsten.update.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;
import tungsten.update.ModMenus;

public class TungstenUpdateClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MenuScreens.register(ModMenus.INDUSTRIAL_SMELTER, IndustrialSmelterScreen::new);
    }
}