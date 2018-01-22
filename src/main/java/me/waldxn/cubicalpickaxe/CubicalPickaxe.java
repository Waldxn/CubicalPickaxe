package me.waldxn.cubicalpickaxe;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class CubicalPickaxe extends JavaPlugin {

    @Override
    public void onEnable() {
        createConfig();

    }

    @Override
    public void onDisable() {


    }

    private void createConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                getLogger().info("Config.yml not found, creating!");
                saveDefaultConfig();
            } else {
                getLogger().info("Config.yml found, loading!");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
