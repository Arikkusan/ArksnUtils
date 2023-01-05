package fr.arikkusan.arksnutils.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomNameCommands implements CommandExecutor, TabCompleter {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if (args.length == 2) {
            if (p.isOp()) {
                setCustomName(args[0], args[1]);
            }
        } else if (args.length == 1)
            setCustomName(p, args[0]);
        else
            p.sendMessage(
                    ChatColor.RED +
                            "Pour obtenir un nom custom utilise la commande /CustomName <NomCustom>"
            );

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> tabCompletion = new ArrayList<>();

        Collection<? extends Player> players = Bukkit.getServer().getOnlinePlayers();

        if (args.length == 1)
            tabCompletion.add("CustomName");
        else
            for (Player p : players)
                tabCompletion.add(p.getName());


        return tabCompletion;
    }

    public void setCustomName(String username, String pseudo) {

        Collection<? extends Player> players = Bukkit.getServer().getOnlinePlayers();
        ArrayList<String> playersName = new ArrayList<>();

        for (Player player : players)
            playersName.add(player.getName());

        if (playersName.contains(username)) {
            for (Player player : players) {
                if (player.getName().equalsIgnoreCase(username)) {
                    player.setCustomName(pseudo);
                    player.setDisplayName(player.getCustomName());

                    player.sendMessage(
                            ChatColor.GOLD +
                                    "Votre surnom a été défini en tant que " +
                                    ChatColor.GOLD +
                                    player.getCustomName()
                    );
                }
            }

        }

    }

    public void setCustomName(Player p, String pseudo) {

        p.setCustomName(pseudo);
        p.setDisplayName(p.getCustomName());
        p.sendMessage(
                ChatColor.GOLD +
                        "Votre surnom a été défini en tant que " +
                        ChatColor.GOLD +
                        p.getCustomName()
        );


    }

}
