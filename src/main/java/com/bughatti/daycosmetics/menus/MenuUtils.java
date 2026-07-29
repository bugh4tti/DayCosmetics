package com.bughatti.daycosmetics.menus;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuUtils {

    public static void fillBorders(Inventory inv) {
        ItemStack panel = namedItem(Material.GRAY_STAINED_GLASS_PANE, " ");
        int size = inv.getSize();
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, panel);
            inv.setItem(size - 9 + i, panel);
        }
        for (int i = 0; i < size; i += 9) {
            inv.setItem(i, panel);
            inv.setItem(i + 8, panel);
        }
    }

    public static ItemStack namedItem(Material mat, String name) {
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }
}
