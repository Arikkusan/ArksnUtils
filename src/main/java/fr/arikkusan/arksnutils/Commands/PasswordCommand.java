package fr.arikkusan.arksnutils.Commands;

import fr.arikkusan.arksnutils.Objects.APlayer;
import fr.arikkusan.arksnutils.Objects.APlayerList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PasswordCommand implements CommandExecutor, TabCompleter {
    private final APlayerList aPlayers;
    private String BRUT_PASSWORD = "Arikkusan";


    public PasswordCommand(APlayerList players) {
        this.aPlayers = players;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        Player p = (Player) sender;
        APlayer ap = aPlayers.getAPlayer(p);

        if (!ap.isLocked()) {
            p.sendMessage(
                    ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Vous êtes déjà connecté !"
            );
            // p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1F, 1F);
            return true;
        }

        if (args.length == 0) {
            p.sendMessage(
                    ChatColor.RED + "" + ChatColor.BOLD + "Use /password <password>"
            );
            // p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1F, 1F);
            return true;
        }

        if (!args[0].equals(BRUT_PASSWORD)) {
            p.sendMessage(
                    ChatColor.RED + "" + ChatColor.BOLD + "Wrong password !"
            );
            // p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1F, 1F);
            return true;
        }

        p.sendMessage(
                ChatColor.GREEN + "" + ChatColor.BOLD + "Password correct !"
        );

        ap.setLocked(false);

        aPlayers.remove(aPlayers.getAPlayer(p));
        aPlayers.add(ap);

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return new ArrayList<>();
    }
}
