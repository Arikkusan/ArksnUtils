package fr.arikkusan.arksnutils.Objects;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class APlayerList extends ArrayList<APlayer> {

    private static APlayerList instance;

    public APlayerList(int initialCapacity) {
        super(initialCapacity);

        if (instance != )

        instance = this;

    }

    public static APlayerList getInstance() {
        return instance;
    }

    public APlayer getAPlayer(Player player) {


        for (APlayer p: this)
            if (p.getPlayer().getUniqueId().equals(player.getUniqueId())) return p;


        APlayer newPlayer = new APlayer(player);
        add(newPlayer);
        return newPlayer;

    }
}
