package com.bughatti.daycosmetics.menus;

import com.bughatti.daycosmetics.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class MainMenu {

    public static void open(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54,
                Main.getInstance().getConfig().getString("menus.main.title"));

        MenuUtils.fillBorders(inv);
        inv.setItem(20, MenuUtils.namedItem(Material.BLAZE_POWDER, "&cKill Effects"));
        inv.setItem(22, MenuUtils.namedItem(Material.NAME_TAG, "&eTags"));
        inv.setItem(24, MenuUtils.namedItem(Material.LEATHER_HELMET, "&bHats"));

        player.openInventory(inv);
    }
}
