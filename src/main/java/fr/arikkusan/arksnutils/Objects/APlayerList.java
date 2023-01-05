package fr.arikkusan.arksnutils.Objects;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class APlayerList extends ArrayList<APlayer> {

    public APlayer getAPlayer(Player player) {


        if (containsPlayer(player))
            for (APlayer p : this)
                if (p.getPlayer().getUniqueId().equals(player.getUniqueId())) return p;


        APlayer newPlayer = new APlayer(player);
        add(newPlayer);
        return newPlayer;

    }

    public boolean containsAPlayer(APlayer aPlayer) {
        for (APlayer p : this)
            if (p.getPlayer().getUniqueId().equals(aPlayer.getPlayer().getUniqueId())) return true;
        return false;
    }

    public boolean containsPlayer(Player player) {
        for (APlayer p : this)
            if (p.getPlayer().getUniqueId().equals(player.getUniqueId())) return true;
        return false;

    }
}
