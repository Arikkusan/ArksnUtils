package fr.arikkusan.arksnutils;

import fr.arikkusan.arksnutils.listener.GuiListener;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

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
        plugin = this;

        addListener(new GuiListener());

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
