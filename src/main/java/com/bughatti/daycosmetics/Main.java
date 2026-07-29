package com.bughatti.daycosmetics;

import com.bughatti.daycosmetics.commands.DayCosmeticsCommand;
import com.bughatti.daycosmetics.listeners.ChatTagListener;
import com.bughatti.daycosmetics.listeners.KillEffectListener;
import com.bughatti.daycosmetics.listeners.MenuListener;
import com.bughatti.daycosmetics.managers.CosmeticsManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    private CosmeticsManager cosmeticsManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        this.cosmeticsManager = new CosmeticsManager(this);

        getCommand("daycosmetics").setExecutor(new DayCosmeticsCommand(this));
        getCommand("daycosmetics").setTabCompleter(new DayCosmeticsCommand(this));

        getServer().getPluginManager().registerEvents(new MenuListener(this), this);
        getServer().getPluginManager().registerEvents(new KillEffectListener(this), this);
        getServer().getPluginManager().registerEvents(new ChatTagListener(this), this);

        getLogger().info("DayCosmetics habilitado correctamente.");
    }

    @Override
    public void onDisable() {
        getLogger().info("DayCosmetics deshabilitado.");
    }

    public static Main getInstance() {
        return instance;
    }

    public CosmeticsManager getCosmeticsManager() {
        return cosmeticsManager;
    }
          }
