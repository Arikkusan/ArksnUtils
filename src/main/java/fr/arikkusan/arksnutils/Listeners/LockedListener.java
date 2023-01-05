package fr.arikkusan.arksnutils.Listeners;

import fr.arikkusan.arksnutils.Objects.APlayerList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerPortalEvent;

public class LockedListener implements Listener {

    private final APlayerList aPlayers;

    public LockedListener(APlayerList players) {
        this.aPlayers = players;
    }

    @EventHandler
    public void onBlockPlaced(BlockPlaceEvent e) {

        Player p = e.getPlayer();
        if (!aPlayers.getAPlayer(p).isLocked()) return;

        e.setCancelled(true);

    }
    @EventHandler
    public void onBlockPlaced(BlockBreakEvent e) {

        Player p = e.getPlayer();
        if (!aPlayers.getAPlayer(p).isLocked()) return;

        e.setCancelled(true);

    }
    @EventHandler
    public void onMove(PlayerMoveEvent e) {

        Player p = e.getPlayer();
        if (!aPlayers.getAPlayer(p).isLocked()) return;

        e.setCancelled(true);

    }
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent e) {

        Player p = (Player) e.getPlayer();
        if (!aPlayers.getAPlayer(p).isLocked()) return;

        e.setCancelled(true);

    }
    @EventHandler
    public void onInnterractEvent(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        if (!aPlayers.getAPlayer(p).isLocked()) return;

        e.setCancelled(true);

    }
    @EventHandler
    public void onPickupEvent(PlayerPickupItemEvent e) {

        Player p = e.getPlayer();
        if (!aPlayers.getAPlayer(p).isLocked()) return;

        e.setCancelled(true);

    }
    @EventHandler
    public void onDimentionalTravelOpen(PlayerPortalEvent e) {

        Player p = e.getPlayer();
        if (!aPlayers.getAPlayer(p).isLocked()) return;

        e.setCancelled(true);

    }
    @EventHandler
    public void onHitTaken(EntityDamageEvent e) {

        if (!(e.getEntity() instanceof Player)) return;

        Player p = (Player) e.getEntity();
        if (!aPlayers.getAPlayer(p).isLocked()) return;

        e.setCancelled(true);

    }
    @EventHandler
    public void onHitTaken(EntityDamageByEntityEvent e) {

        if (!(e.getEntity() instanceof Player))
            if (!(e.getDamager() instanceof Player)) return;

        Player p = (Player) e.getDamager();
        if (!aPlayers.getAPlayer(p).isLocked()) return;

        e.setCancelled(true);

    }



}
