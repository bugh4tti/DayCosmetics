package com.bughatti.daycosmetics.commands;

import com.bughatti.daycosmetics.Main;
import com.bughatti.daycosmetics.menus.MainMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayCosmeticsCommand implements CommandExecutor, TabCompleter {

    private final Main plugin;

    public DayCosmeticsCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.getConfig().getString("messages.only-players"));
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            MainMenu.open(player);
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "help":
                player.sendMessage("§b» DayCosmetics §7- Comandos:");
                player.sendMessage("§7/daycosmetics §f- Abre el menú principal");
                player.sendMessage("§7/daycosmetics reload §f- Recarga la config");
                break;
            case "reload":
                plugin.reloadConfig();
                player.sendMessage(plugin.getConfig().getString("messages.plugin-reloaded"));
                break;
            default:
                MainMenu.open(player);
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("help", "reload");
        }
        return new ArrayList<>();
    }
              }
