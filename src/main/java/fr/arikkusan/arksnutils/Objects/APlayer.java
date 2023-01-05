package fr.arikkusan.arksnutils.Objects;

import org.bukkit.entity.Player;

public class APlayer {

    private Player player;
    private String role;
    private ATeam team;
    private final boolean locked;
    private int passwordAttempts;

    public APlayer(Player p) {
        this.player = p;
        this.role = null;
        this.team = null;
        this.locked = true;
        passwordAttempts = 0;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ATeam getTeam() {
        return team;
    }

    public void setTeam(ATeam team) {
        this.team = team;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        locked = locked;
    }

    public int getPasswordAttempts() {
        return passwordAttempts;
    }

    public void setPasswordAttempts(int passwordAttempts) {
        this.passwordAttempts = passwordAttempts;
    }
}
