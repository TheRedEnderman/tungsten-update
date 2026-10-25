package tungsten.update;

import java.util.Set;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BlockEntityType;

public final class ModBlockEntities {
    public static final ResourceKey<BlockEntityType<?>> INDUSTRIAL_SMELTER_KEY =
            ResourceKey.create(Registries.BLOCK_ENTITY_TYPE, TungstenUpdate.id("industrial_smelter"));

    public static final BlockEntityType<IndustrialSmelterBlockEntity> INDUSTRIAL_SMELTER = Registry.register(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            INDUSTRIAL_SMELTER_KEY,
            new BlockEntityType<IndustrialSmelterBlockEntity>(IndustrialSmelterBlockEntity::new, Set.of(ModBlocks.INDUSTRIAL_SMELTER))
    );

    public static void initialize() {}

    private ModBlockEntities() {}
}