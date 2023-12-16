package fr.arikkusan.arksnutils.listener;

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

    /**
     * The sound to play when a player clicks on a button.
     */
    private final Sound clickSound;

    /**
     * Creates a GuiListener with the default click sound.
     */
    public GuiListener() {
        this.clickSound = Sound.UI_BUTTON_CLICK;
    }

    /**
     * Creates a GuiListener with the given click sound.
     *
     * @param clickSound the sound to play when a player clicks on a button
     */
    public GuiListener(Sound clickSound) {
        this.clickSound = clickSound;
    }

    @EventHandler
    public void onGuiEvent(InventoryClickEvent event) {

        // We get the name of the inventory and the menu associated with it
        String inventoryTitle = event.getView().getTitle();
        IMenu menu = MenuManager.getInventoryWithName(inventoryTitle);

        // We check if the menu is null
        if (menu == null) return;

        // We get the player, the inventory, the item and the slot
        Player p = (Player) event.getWhoClicked();
        Inventory inventory = event.getClickedInventory();
        ItemStack item = event.getCurrentItem();
        int slot = event.getSlot();

        // We play the click sound if it is not null
        if (clickSound != null) p.playSound(p.getLocation(), clickSound, 1f, 1f);

        // We call the onClick method of the menu
        menu.onClick(p, inventory, item, slot);

        // We cancel the event
        event.setCancelled(true);
    }

}
