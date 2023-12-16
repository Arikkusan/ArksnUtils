package fr.arikkusan.arksnutils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

/**
 * The Utils class contains utility methods.
 */
public class Utils {

    /**
     * Sets the name of an ItemStack
     *
     * @param itemStack  the ItemStack to set the name of
     * @param customName the new name for the ItemStack
     */
    public static void setName(ItemStack itemStack, String customName) {

        ItemMeta data = itemStack.getItemMeta();
        data.setDisplayName(ChatColor.BOLD + customName);
        itemStack.setItemMeta(data);

    }

    /**
     * Sets the lore of an ItemStack
     *
     * @param itemStack the ItemStack to set the lore of
     * @param lore      the new lore for the ItemStack
     */
    public static void setLore(ItemStack itemStack, List<String> lore) {

        ItemMeta data = itemStack.getItemMeta();
        data.setLore(lore);
        itemStack.setItemMeta(data);

    }

    /**
     * Creates a player head ItemStack with the given player as owner, so the skin of the head will be the skin of the given player.
     *
     * @param player the player to create the head of
     * @return the player head ItemStack
     */
    public static ItemStack getSkull(Player player) {
        // create a new itemstack with the player head
        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);

        // create a new skull meta
        SkullMeta meta = (SkullMeta) playerHead.getItemMeta();

        // set the owner of the player head
        assert meta != null;
        meta.setOwningPlayer(player);
        playerHead.setItemMeta(meta);
        // set the name of the player head
        Utils.setName(playerHead, ChatColor.GREEN + ChatColor.stripColor(player.getDisplayName()));
        return playerHead;
    }
}
