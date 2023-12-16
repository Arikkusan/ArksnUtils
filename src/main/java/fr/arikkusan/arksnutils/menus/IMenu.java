package fr.arikkusan.arksnutils.menus;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * The IMenu interface represents a menu with a name, size, content, and click actions.
 */
// Interface from "Alexis Dalle - Creation d'un plugin spigot 1.8 #23"
public interface IMenu {
    String name();

    int getSize();

    void setContent(Player player, Inventory inventory);

    void onClick(Player player, Inventory inventory, ItemStack item, int slot);
}
