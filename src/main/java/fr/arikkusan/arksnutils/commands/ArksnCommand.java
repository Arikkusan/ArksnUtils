package fr.arikkusan.arksnutils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * The ArksnCommand class represents a custom command abstract class with a lot of command simplification, for example
 * already handling the difference between a player and a command prompt that is executing a command.
 * Implementing classes must override the playerCommand() and onTabComplete() methods
 */
public abstract class ArksnCommand implements CommandExecutor, TabCompleter {

    /**
     * Current command used linked to the class
     */
    protected String commandName;


    /**
     * Handles the onCommand event for custom commands.
     *
     * @param sender the command sender
     * @param cmd    the command being executed
     * @param label  the alias or label used to execute the command
     * @param args   the arguments supplied with the command
     * @return true if the command was successfully executed, false otherwise
     */
    @Override
    public final boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        this.commandName = cmd.getName();
        boolean commandResult;
        if (sender instanceof Player) {
            commandResult = playerCommand((Player) sender, args);
        } else {
            commandResult = consoleCommand(sender, args);
        }

        return commandResult;
    }

    /**
     * Handles a player command.
     *
     * @param player the player executing the command
     * @param args   the arguments supplied with the command
     * @return true if the command was successfully executed, false otherwise
     */
    protected abstract boolean playerCommand(Player player, String[] args);

    /**
     * Handles commands executed through the console.
     *
     * @param sender the command sender
     * @param args   the arguments supplied with the command
     * @return true indicating the command was successfully executed
     */
    protected boolean consoleCommand(CommandSender sender, String[] args) {
        sender.sendMessage("Only players can use this command.");
        return true;
    }

    /**
     * Called when the tab completion is requested for a command.
     *
     * @param sender  the command sender requesting tab completion
     * @param command the command being tab completed
     * @param label   the alias or label used to execute the command
     * @param args    the arguments supplied with the command
     * @return a list of possible tab completions for the command
     */
    @Override
    public abstract List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args);


}
