package fr.arikkusan.arksnutils.menus;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

/**
 * The MenuManager class is used to register menus and open them.
 */
public class MenuManager {

    private static final Map<Class<? extends Menu>, Menu> menus = new HashMap<>();

    /**
     * Registers the given menu.
     *
     * @param menu the menu to register
     */
    public static void registerMenu(Menu menu) {
        menus.put(menu.getClass(), menu);
    }

    /**
     * Opens the menu with the given class for the given player.
     *
     * @param p      the player to open the menu for
     * @param gClass the class of the menu to open
     */
    public static void open(Player p, Class<? extends Menu> gClass) {

        // we check if the menu is registered
        if (!menus.containsKey(gClass)) return;

        // we get the menu & we create the inventory
        IMenu menu = menus.get(gClass);
        Inventory inv = Bukkit.createInventory(null, menu.getSize(), menu.name());
        menu.setContent(p, inv);

        // we open the inventory
        p.openInventory(inv);

    }

    /**
     * Retrieves the menu with the given name.
     *
     * @param inventoryTitle the name of the menu
     * @return the menu with the given name, or null if there is no menu with this name
     * @see IMenu#name()
     */
    public static Menu getInventoryWithName(String inventoryTitle) {
        for (Menu menu : menus.values()) {
            if (inventoryTitle.equals(menu.name())) return menu;
        }
        return null;
    }
}