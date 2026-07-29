package com.bughatti.daycosmetics.menus;

import com.bughatti.daycosmetics.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TagsMenu {

    public static void open(Player player) {
        Main plugin = Main.getInstance();
        Inventory inv = Bukkit.createInventory(null, 54,
                plugin.getConfig().getString("menus.tags.title"));

        MenuUtils.fillBorders(inv);

        ConfigurationSection sec = plugin.getConfig().getConfigurationSection("tags");
        for (String key : sec.getKeys(false)) {
            String path = "tags." + key + ".";
            Material mat = Material.valueOf(plugin.getConfig().getString(path + "material"));
            String name = plugin.getConfig().getString(path + "name");
            int slot = plugin.getConfig().getInt(path + "slot");

            ItemStack item = MenuUtils.namedItem(mat, name);
            inv.setItem(slot, item);
        }

        player.openInventory(inv);
    }
}
