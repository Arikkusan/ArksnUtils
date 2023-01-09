package fr.arikkusan.arksnutils;

import fr.arikkusan.arksnutils.Commands.CustomNameCommands;
import fr.arikkusan.arksnutils.Commands.PasswordCommand;
import fr.arikkusan.arksnutils.Commands.gmCommands;
import fr.arikkusan.arksnutils.Listeners.JoinQuitListener;
import fr.arikkusan.arksnutils.Listeners.LockedListener;
import fr.arikkusan.arksnutils.Objects.APlayerList;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Objects;

public final class Main extends JavaPlugin {

    private static Main instance;
    private static APlayerList players;
    private static ArrayList<String> passwords;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        players = new APlayerList();
        passwords = new ArrayList<>();
        passwords.add("Arikkusan");

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "ArksnUtils plugin launched with success");

        registerEventListeners();
        registerCommands(true);


    }

    private void registerCommands(boolean passwordEnabled) {
        CustomNameCommands CustomNameCmd = new CustomNameCommands();
        gmCommands gmCmd = new gmCommands(players);

        if (passwordEnabled) {
            PasswordCommand passwordCommand = new PasswordCommand(players, passwords);

            Objects.requireNonNull(getCommand("password")).setTabCompleter(passwordCommand);
            Objects.requireNonNull(getCommand("password")).setExecutor(passwordCommand);
        }

        Objects.requireNonNull(getCommand("CustomName")).setTabCompleter(CustomNameCmd);
        Objects.requireNonNull(getCommand("CustomName")).setExecutor(CustomNameCmd);

        Objects.requireNonNull(getCommand("gm")).setTabCompleter(gmCmd);
        Objects.requireNonNull(getCommand("gm")).setExecutor(gmCmd);
    }

    private void registerEventListeners() {
        getServer().getPluginManager().registerEvents(new JoinQuitListener("Bienvenu sur le serveur IUTopia !", players), this);
        getServer().getPluginManager().registerEvents(new LockedListener(players), this);

    }

    @Override
    public void onLoad() {
        super.onLoad();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "ArksnUtils loaded with success");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "ArksnUtils plugin closed with success");
    }

    public static Main getInstance() {
        return instance;
    }
}
