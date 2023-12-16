package fr.arikkusan.arksnutils.menus;

import fr.arikkusan.arksnutils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.function.Consumer;

/**
 * The MenuButton class represents a button in a menu.
 */
public class MenuButton {

    private ItemStack item;
    private Consumer<Player> clickAction;

    /**
     * Creates a MenuButton with the given ItemStack and click action.
     *
     * @param item        the ItemStack representing the button
     * @param clickAction the action to be performed when the button is clicked by a player
     */
    public MenuButton(ItemStack item, Consumer<Player> clickAction) {
        this.item = item;
        this.clickAction = clickAction;
    }


    public MenuButton(ItemStack item, String itemName, Consumer<Player> clickAction) {
        this.item = item;
        Utils.setName(item, itemName);
        this.clickAction = clickAction;
    }


    /**
     * Retrieves the ItemStack associated with this MenuButton.
     *
     * @return the ItemStack representing the button
     */
    public ItemStack getItem() {
        return item;
    }

    /**
     * Sets the ItemStack associated with this MenuButton.
     *
     * @param item the new ItemStack representing the button
     */
    public void setItem(ItemStack item) {
        this.item = item;
    }

    /**
     * Sets the name of the item associated with this MenuButton.
     *
     * @param name the new name for the item
     */
    public void setItemName(String name) {
        Utils.setName(item, name);
    }

    /**
     * Sets the lore of the item associated with this MenuButton.
     *
     * @param lore the new lore for the item
     */
    public void setItemLore(List<String> lore) {
        Utils.setLore(item, lore);
    }

    /**
     * Sets the action to be performed when the button is clicked by a player.
     *
     * @param clickAction the action to be performed
     */
    public void setClickAction(Consumer<Player> clickAction) {
        this.clickAction = clickAction;
    }

    /**
     * Executes the click action associated with this MenuButton for the specified player.
     *
     * @param player the player triggering the button click
     */
    public void runAction(Player player) {
        if (clickAction == null) return;
        clickAction.accept(player);
    }

}