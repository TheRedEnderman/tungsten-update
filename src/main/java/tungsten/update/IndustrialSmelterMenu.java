package tungsten.update;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookMenu;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipePropertySet;

public class IndustrialSmelterMenu extends AbstractFurnaceMenu {
    public IndustrialSmelterMenu(int containerId, Inventory inventory) {
        this(containerId, inventory, new SimpleContainer(3), new SimpleContainerData(4));
    }

    public IndustrialSmelterMenu(int containerId, Inventory inventory, Container container, ContainerData data) {
        super(ModMenus.INDUSTRIAL_SMELTER, RecipePropertySet.BLAST_FURNACE_INPUT, RecipeBookType.BLAST_FURNACE, containerId, inventory, container, data);

        // The vanilla input slot accepts any item: replace it with one that only takes raw tungsten.
        Slot input = new Slot(container, 0, 56, 17) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(ModItems.RAW_TUNGSTEN);
            }
        };
        input.index = 0;
        this.slots.set(0, input);

        // Fuel slot: lava bucket only (not even an empty bucket).
        Slot fuel = new Slot(container, 1, 56, 53) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(Items.LAVA_BUCKET);
            }
        };
        fuel.index = 1;
        this.slots.set(1, fuel);
    }

    @Override
    protected boolean canSmelt(ItemStack itemStack) {
        return itemStack.is(ModItems.RAW_TUNGSTEN);
    }

    @Override
    protected boolean isFuel(ItemStack itemStack) {
        return itemStack.is(Items.LAVA_BUCKET);
    }

    /** There is no recipe book in this menu: do nothing. */
    @Override
    public RecipeBookMenu.PostPlaceAction handlePlacement(boolean useMaxItems, boolean allowDroppingItemsToClear, RecipeHolder<?> recipe, ServerLevel level, Inventory inventory) {
        return RecipeBookMenu.PostPlaceAction.NOTHING;
    }
}