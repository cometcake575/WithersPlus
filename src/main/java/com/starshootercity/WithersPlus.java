package com.starshootercity;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class WithersPlus extends JavaPlugin {
    private static WithersPlus instance;
    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new WitherPreparer(), this);
    }

    public static WithersPlus getInstance() {
        return instance;
    }
}