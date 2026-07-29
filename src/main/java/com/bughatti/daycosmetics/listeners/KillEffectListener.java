package com.bughatti.daycosmetics.listeners;

import com.bughatti.daycosmetics.Main;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillEffectListener implements Listener {

    private final Main plugin;

    public KillEffectListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player victim = e.getEntity();
        Player killer = victim.getKiller();
        if (killer == null) return;

        String effectKey = plugin.getCosmeticsManager().getKillEffect(killer.getUniqueId());
        if (effectKey.equals("none")) return;

        String particleName = plugin.getConfig().getString("killeffects." + effectKey + ".particle");
        if (particleName == null) return;

        Particle particle = Particle.valueOf(particleName);
        Location loc = victim.getLocation().add(0, 1, 0);
        victim.getWorld().spawnParticle(particle, loc, 60, 0.5, 0.8, 0.5, 0.05);
    }
}
