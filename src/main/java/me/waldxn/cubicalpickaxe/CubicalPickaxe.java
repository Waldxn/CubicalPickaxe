package me.waldxn.cubicalpickaxe;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.wasteofplastic.askyblock.ASkyBlockAPI;
import me.waldxn.cubicalpickaxe.commands.CubicalPickaxeCommand;
import me.waldxn.cubicalpickaxe.manager.PickaxeManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class CubicalPickaxe extends JavaPlugin {

    private PickaxeManager pickaxeManager = new PickaxeManager(this);


    @Override
    public void onEnable() {
        createConfig();
        registerEvents();
        registerCommands();
        getWorldGuard();
        getAsbAPI();
    }

    private void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(pickaxeManager, this);
    }

    private void registerCommands() {
        getCommand("cubicalpickaxe").setExecutor(new CubicalPickaxeCommand(pickaxeManager));
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

    private WorldGuardPlugin getWorldGuard() {
        Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");
        if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
            return null;
        }
        return (WorldGuardPlugin) plugin;
    }

    private ASkyBlockAPI getAsbAPI() {
        Plugin plugin = getServer().getPluginManager().getPlugin("ASkyBlock");
        if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
            return null;
        }
        return (ASkyBlockAPI) plugin;
    }
}
