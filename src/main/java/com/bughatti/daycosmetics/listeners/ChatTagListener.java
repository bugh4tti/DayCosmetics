package com.bughatti.daycosmetics.listeners;

import com.bughatti.daycosmetics.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatTagListener implements Listener {

    private final Main plugin;

    public ChatTagListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        String tagKey = plugin.getCosmeticsManager().getTag(player.getUniqueId());

        String tag = plugin.getConfig().getString("tags." + tagKey + ".tag", "");
        tag = ChatColor.translateAlternateColorCodes('&', tag);

        e.setFormat(tag + "%s: %s");
    }
}
