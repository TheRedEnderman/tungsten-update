package tungsten.update;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public final class ModBlocks {
    public static final ResourceKey<Block> TUNGSTEN_ORE_BLOCK_KEY =
            ResourceKey.create(Registries.BLOCK, TungstenUpdate.id("tungsten_ore"));

    public static final ResourceKey<Item> TUNGSTEN_ORE_ITEM_KEY =
            ResourceKey.create(Registries.ITEM, TungstenUpdate.id("tungsten_ore"));

    public static final Block TUNGSTEN_ORE = Registry.register(
            BuiltInRegistries.BLOCK,
            TUNGSTEN_ORE_BLOCK_KEY,
            new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.of()
                    .strength(7.5F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .setId(TUNGSTEN_ORE_BLOCK_KEY))
    );

    static {
        Registry.register(
                BuiltInRegistries.ITEM,
                TUNGSTEN_ORE_ITEM_KEY,
                new BlockItem(TUNGSTEN_ORE,
                        new Item.Properties()
                                .useBlockDescriptionPrefix().fireResistant()
                                .setId(TUNGSTEN_ORE_ITEM_KEY))
        );
    }

    public static void initialize() {}

    private ModBlocks() {}
}
