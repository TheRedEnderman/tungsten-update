package tungsten.update;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;

public final class ModItems {
    public static final ResourceKey<Item> TUNGSTEN_INGOT_KEY =
            ResourceKey.create(Registries.ITEM, TungstenUpdate.id("tungsten_ingot"));

    public static final Item TUNGSTEN_INGOT = Registry.register(
            BuiltInRegistries.ITEM,
            TUNGSTEN_INGOT_KEY,
            new Item(new Item.Properties().fireResistant().setId(TUNGSTEN_INGOT_KEY))
    );

    public static final ResourceKey<Item> RAW_TUNGSTEN_KEY =
            ResourceKey.create(Registries.ITEM, TungstenUpdate.id("raw_tungsten"));

    public static final Item RAW_TUNGSTEN = Registry.register(
            BuiltInRegistries.ITEM,
            RAW_TUNGSTEN_KEY,
            new Item(new Item.Properties().fireResistant().setId(RAW_TUNGSTEN_KEY))
    );

    private static final TagKey<Block> INCORRECT_FOR_TUNGSTEN_TOOL =
            TagKey.create(Registries.BLOCK, TungstenUpdate.id("incorrect_for_tungsten_tool"));

    private static final TagKey<Item> REPAIRS_TUNGSTEN_TOOL =
            TagKey.create(Registries.ITEM, TungstenUpdate.id("repairs_tungsten_tool"));

    public static final ToolMaterial TUNGSTEN_TOOL_MATERIAL = new ToolMaterial(
            INCORRECT_FOR_TUNGSTEN_TOOL,
            1800,
            9.0F,
            4.0F,
            14,
            REPAIRS_TUNGSTEN_TOOL
    );

    public static final ResourceKey<Item> TUNGSTEN_PICKAXE_KEY =
            ResourceKey.create(Registries.ITEM, TungstenUpdate.id("tungsten_pickaxe"));

    public static final Item TUNGSTEN_PICKAXE = Registry.register(
            BuiltInRegistries.ITEM,
            TUNGSTEN_PICKAXE_KEY,
            new Item(new Item.Properties()
                    .pickaxe(TUNGSTEN_TOOL_MATERIAL, 1.0F, -2.8F).fireResistant()
                    .setId(TUNGSTEN_PICKAXE_KEY))
    );

    public static final ResourceKey<CreativeModeTab> TUNGSTEN_TAB_KEY =
            ResourceKey.create(Registries.CREATIVE_MODE_TAB, TungstenUpdate.id("tungsten"));

    public static final CreativeModeTab TUNGSTEN_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            TUNGSTEN_TAB_KEY,
            FabricCreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.tungsten-update.tungsten"))
                    .icon(() -> TUNGSTEN_INGOT.getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(TUNGSTEN_INGOT);
                        output.accept(RAW_TUNGSTEN);
                        output.accept(ModBlocks.TUNGSTEN_ORE);
                        output.accept(ModBlocks.INDUSTRIAL_SMELTER);
                        output.accept(TUNGSTEN_PICKAXE);
                    })
                    .build()
    );

    public static void initialize() {}

    private ModItems() {}
}