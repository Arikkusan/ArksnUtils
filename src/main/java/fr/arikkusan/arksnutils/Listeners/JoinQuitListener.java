package fr.arikkusan.arksnutils.Listeners;

import fr.arikkusan.arksnutils.Objects.APlayer;
import fr.arikkusan.arksnutils.Objects.APlayerList;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitListener implements Listener {

    private final APlayerList aPlayers;

    public JoinQuitListener(APlayerList players) {
        this.aPlayers = players;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();
        p.sendMessage(
                ChatColor.GOLD + "Bienvenu sur le serveur IUTopia !"
        );

        e.setJoinMessage(
                ChatColor.GOLD + "" + ChatColor.BOLD + p.getDisplayName() + ChatColor.GOLD + " à rejoint le serveur."
        );

        if (aPlayers.containsPlayer(p)) return;
        aPlayers.add(new APlayer(p));

        p.sendMessage(
                ChatColor.GOLD + "Veuillez renseigner le mot de passe pour pouvoir jouer avec la commande /password <password>"
        );
        //p.playSound(p.getLocation(), Sound.AMBIENCE_THUNDER, 1F, 1F);



    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {

        Player p = e.getPlayer();

        e.setQuitMessage(
                ChatColor.GOLD + "" + ChatColor.BOLD + p.getDisplayName() + ChatColor.GOLD + " à quitté le serveur."
        );

    }

}
