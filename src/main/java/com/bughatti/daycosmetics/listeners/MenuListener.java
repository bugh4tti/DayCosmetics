package com.bughatti.daycosmetics.listeners;

import com.bughatti.daycosmetics.Main;
import com.bughatti.daycosmetics.menus.KillEffectsMenu;
import com.bughatti.daycosmetics.menus.TagsMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListener implements Listener {

    private final Main plugin;

    public MenuListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        String title = e.getView().getTitle();
        boolean isOurMenu = title.contains("DayCosmetics") || title.contains("Kill Effects") || title.contains("Tags");
        if (!isOurMenu) return;

        e.setCancelled(true);
        if (e.getCurrentItem() == null || e.getClickedInventory() == null) return;

        Player player = (Player) e.getWhoClicked();
        String itemName = e.getCurrentItem().getItemMeta().getDisplayName();

        if (itemName.equals("§cKill Effects")) {
            KillEffectsMenu.open(player);
            return;
        }
        if (itemName.equals("§eTags")) {
            TagsMenu.open(player);
            return;
        }

        String effectKey = matchKey(itemName, "killeffects");
        if (effectKey != null) {
            plugin.getCosmeticsManager().setKillEffect(player.getUniqueId(), effectKey);
            player.sendMessage(plugin.getConfig().getString("messages.effect-selected")
                    .replace("%effect%", itemName));
            return;
        }

        String tagKey = matchKey(itemName, "tags");
        if (tagKey != null) {
            plugin.getCosmeticsManager().setTag(player.getUniqueId(), tagKey);
            player.sendMessage("§aSeleccionaste el tag: §f" + itemName);
        }
    }

    private String matchKey(String displayName, String section) {
        var sec = plugin.getConfig().getConfigurationSection(section);
        if (sec == null) return null;
        for (String key : sec.getKeys(false)) {
            String name = plugin.getConfig().getString(section + "." + key + ".name");
            if (name != null && name.replace("&", "§").equalsIgnoreCase(displayName)) {
                return key;
            }
        }
        return null;
    }
          }
