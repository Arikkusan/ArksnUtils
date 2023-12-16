package fr.arikkusan.arksnutils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

public class Utils {


    public static void setName(ItemStack itemStack, String customName) {

        ItemMeta data = itemStack.getItemMeta();
        data.setDisplayName(ChatColor.BOLD + customName);
        itemStack.setItemMeta(data);

    }

    public static void setLore(ItemStack itemStack, List<String> lore) {

        ItemMeta data = itemStack.getItemMeta();
        data.setLore(lore);
        itemStack.setItemMeta(data);

    }

    public static ItemStack getSkull(Player player) {
        // create a new itemstack with the player head
        ItemStack playerHead = new ItemStack(org.bukkit.Material.PLAYER_HEAD);

        // create a new skull meta
        SkullMeta meta = (SkullMeta) playerHead.getItemMeta();

        // set the owner of the player head
        meta.setOwningPlayer(player);
        playerHead.setItemMeta(meta);
        // set the name of the player head
        Utils.setName(playerHead, ChatColor.GREEN + ChatColor.stripColor(player.getDisplayName()));
        return playerHead;
    }
}
