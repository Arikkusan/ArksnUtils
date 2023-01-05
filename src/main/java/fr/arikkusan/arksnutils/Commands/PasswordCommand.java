package fr.arikkusan.arksnutils.Commands;

import fr.arikkusan.arksnutils.Objects.APlayer;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PasswordCommand implements CommandExecutor, TabCompleter {
    private String BRUT_PASSWORD = "Arikkusan";


    public PasswordCommand(ArrayList<APlayer> players) {



    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        Player p = (Player) sender;

        if (args.length == 0) {
            p.sendMessage(
                    ChatColor.RED + "" + ChatColor.BOLD + "Use /password <password>"
            );
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1F, 1F);
            return true;
        }

        if (!args[0].equals(BRUT_PASSWORD)) {
            p.sendMessage(
                    ChatColor.RED + "" + ChatColor.BOLD + "Wrong password"
            );
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1F, 1F);
            return true;
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
