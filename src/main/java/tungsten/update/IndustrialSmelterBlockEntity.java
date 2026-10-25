package tungsten.update;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class IndustrialSmelterBlockEntity extends AbstractFurnaceBlockEntity {
    /** Cooking time of one ingot (2 minutes). Must match "cookingtime" in the industrial_smelting recipe JSON. */
    public static final int COOKING_TICKS = 2400;

    private static final Component DEFAULT_NAME = Component.translatable("container.tungsten-update.industrial_smelter");

    public IndustrialSmelterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.INDUSTRIAL_SMELTER, pos, state, ModRecipes.INDUSTRIAL_SMELTING);
    }

    @Override
    protected Component getDefaultName() {
        return DEFAULT_NAME;
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return new IndustrialSmelterMenu(containerId, inventory, this, this.dataAccess);
    }

    /**
     * A lava bucket burns exactly as long as one ingot takes, so one bucket = one ingot.
     * The +1 is needed because the last burning tick does not count as "lit" in the vanilla tick logic.
     * Anything that is not a lava bucket does not burn at all.
     */
    @Override
    protected int getBurnDuration(ServerLevel level, ItemStack fuelItem) {
        return fuelItem.is(Items.LAVA_BUCKET) ? COOKING_TICKS + 1 : 0;
    }

    @Override
    protected float getSpeedMultiplier(ServerLevel level, ItemStack fuelItem) {
        return 1.0F;
    }

    /** Input: raw tungsten only. Fuel: lava bucket only. Output: nothing can be placed (also applies to hoppers). */
    @Override
    public boolean canPlaceItem(int slot, ItemStack stack) {
        return switch (slot) {
            case 0 -> stack.is(ModItems.RAW_TUNGSTEN);
            case 1 -> stack.is(Items.LAVA_BUCKET);
            default -> false;
        };
    }
}