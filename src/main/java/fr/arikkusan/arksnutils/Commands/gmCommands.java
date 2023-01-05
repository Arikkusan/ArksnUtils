package fr.arikkusan.arksnutils.Commands;

import fr.arikkusan.arksnutils.Objects.APlayerList;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class gmCommands implements CommandExecutor, TabCompleter {
    private final APlayerList players;

    public gmCommands(APlayerList players) {
        this.players = players;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        GameMode gameMode = p.getGameMode();

        if (gameMode.equals(GameMode.SURVIVAL))
            p.setGameMode(GameMode.CREATIVE);
        else
            p.setGameMode(GameMode.SURVIVAL);


        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return new ArrayList<>();
    }
}
