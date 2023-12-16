package fr.arikkusan.arksnutils;

import fr.arikkusan.arksnutils.menus.IMenu;
import fr.arikkusan.arksnutils.menus.MenuManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class GuiListener implements Listener {

    @EventHandler
    public void onGuiEvent(InventoryClickEvent event) {

        String inventoryTitle = event.getView().getTitle();
        IMenu menu = MenuManager.getInventoryWithName(inventoryTitle);

        if (menu == null) return;

        Player p = (Player) event.getWhoClicked();
        Inventory inventory = event.getClickedInventory();
        ItemStack item = event.getCurrentItem();
        int slot = event.getSlot();

        p.getItemOnCursor();
        p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 1f, 1f);
        menu.onClick(p, inventory, item, slot);

        event.setCancelled(true);
    }

}
