package me.waldxn.cubicalpickaxe.manager;

import me.waldxn.cubicalpickaxe.CubicalPickaxe;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PickaxeManager implements Listener {

    private CubicalPickaxe plugin;
    private FileConfiguration config;

    public PickaxeManager(CubicalPickaxe pl) {
        this.plugin = pl;
        this.config = plugin.getConfig();
    }

    public boolean checkConfigNulls() {

        if (plugin.getConfig().getString("pickaxe.name") == null) { return false; }

        if (plugin.getConfig().getString("pickaxe.enchantments.efficiency") == null) { return false; }

        if (plugin.getConfig().getString("pickaxe.enchantments.unbreaking") == null) { return false; }

        if (plugin.getConfig().getString("pickaxe.enchantments.fortune") == null) { return false; }

        return true;
    }

    public void createCubicalPickaxe(Player owner, int efficiencyLevel, int unbreakingLevel, int fortuneLevel) {
        ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta pickaxeMeta = pickaxe.getItemMeta();
        pickaxeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', config.getString("pickaxe.name")));
        pickaxeMeta.addEnchant(Enchantment.DIG_SPEED, config.getInt("pickaxe.enchantments.efficiency"), true);
        pickaxeMeta.addEnchant(Enchantment.DURABILITY, config.getInt("pickaxe.enchantments.unbreaking"), true);
        pickaxeMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, config.getInt("pickaxe.enchantments.fortune"), true);
        ArrayList<String> lore = new ArrayList<>();
        lore.add("Cubical I");
        pickaxeMeta.setLore(lore);
        pickaxe.setItemMeta(pickaxeMeta);
    }
}
