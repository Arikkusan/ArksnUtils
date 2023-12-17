package fr.arikkusan.arksnutils.menus;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * The Menu class represents a menu with a name, size, content, and click actions.
 */
public abstract class Menu implements IMenu {

    // the buttons of the menu
    private Map<Integer, MenuButton> buttons;

    public Menu() {
    }

    /**
     * Initializes the menu.
     */
    public abstract void initMenu(Player player);

    @Override
    public final int getSize() {
        int i = lineNumber();
        if (i < 1) i = 1;
        if (i > 6) i = 6;
        return 9 * i;
    }

    /**
     * @return the number of lines of the menu
     * @min 1
     * @max 6
     */
    public abstract int lineNumber();

    /**
     * fill empty slots with the given item
     *
     * @param line the line to fill
     * @param item the item to fill with
     */
    protected final void fillLine(int line, Material item) {
        int i = line;
        if (i < 0) i = 0;
        if (i > 5) i = 5;
        for (int j = 0; j < 9; j++) {
            if (buttons.containsKey(j + i * 9)) continue;
            addButton(j + i * 9, new MenuButton(item, "", null));
        }
    }

    /**
     * add a button to the menu
     *
     * @param slot   the slot to fill
     * @param button the action to be performed when the button is clicked by a player
     */
    protected final void addButton(int slot, MenuButton button) {
        buttons.put(slot, button);
    }

    @Override
    public void setContent(Player player, Inventory inventory) {
        buttons = new HashMap<>();
        // we initialize the menu buttons depending on the player
        initMenu(player);
        // we fill the inventory with the buttons
        buttons.forEach((integer, menuButton) -> {
            if (integer < 0 || integer > 9 * lineNumber()) return;
            inventory.setItem(integer, menuButton.getItem());
        });
    }

    @Override
    public void onClick(Player player, Inventory inventory, ItemStack item, int slot) {
        if (buttons.containsKey(slot))
            if (buttons.get(slot).getItem().equals(item))
                buttons.get(slot).runAction(player);
    }
}
