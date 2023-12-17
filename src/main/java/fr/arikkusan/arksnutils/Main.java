package fr.arikkusan.arksnutils;

import fr.arikkusan.arksnutils.commands.ArksnCommand;
import fr.arikkusan.arksnutils.listener.GuiListener;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nullable;
import java.util.Objects;

public final class Main extends JavaPlugin {

    private static Plugin plugin;

    /**
     * Retrieves the instance of the plugin.
     *
     * @return the instance of the plugin
     */
    public static Plugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        // we set the plugin 'singleton' like
        plugin = this;

    }


    /**
     * Sets the click sound of the GUIs.
     *
     * @param clickSound the sound to play when a player clicks in a GUI
     */
    @Nullable
    public static void enableMenu(Sound clickSound) {
        ((Main) plugin).addListener(clickSound != null ? new GuiListener(clickSound) : new GuiListener());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    /**
     * Adds a command and tab completer to the server.
     *
     * @param label   The label of the command.
     * @param command The ArksnCommand object that will handle the command execution and tab completion.
     */
    private void addCommandAndTabCompleter(String label, ArksnCommand command) {
        try {
            Objects.requireNonNull(getCommand(label)).setTabCompleter(command);
            Objects.requireNonNull(getCommand(label)).setExecutor(command);
        } catch (NullPointerException e) {
            getServer().getConsoleSender().sendMessage(ChatColor.RED + String.format("The command %s is not written in the plugin.yml file!", label));
        }
    }

    /**
     * Registers a listener to receive events.
     *
     * @param listener the listener to be registered
     */
    private void addListener(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }

}
