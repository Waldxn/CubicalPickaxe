package me.waldxn.cubicalpickaxe.manager;

import me.waldxn.cubicalpickaxe.CubicalPickaxe;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PickaxeManager implements Listener {

    private CubicalPickaxe plugin;
    private FileConfiguration config;
    private ArrayList<String> lore = new ArrayList<>();

    public PickaxeManager(CubicalPickaxe pl) {
        this.plugin = pl;
        this.config = plugin.getConfig();
        lore.add("Cubical I");
    }

    public boolean checkConfigNulls() {

        if (plugin.getConfig().get("pickaxe.name") == null) {
            return false;
        }

        if (plugin.getConfig().get("pickaxe.enchantments.efficiency") == null) {
            return false;
        }

        if (plugin.getConfig().get("pickaxe.enchantments.unbreaking") == null) {
            return false;
        }

        if (plugin.getConfig().get("pickaxe.enchantments.fortune") == null) {
            return false;
        }

        return true;
    }

    public void createCubicalPickaxe(Player owner) {
        ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta pickaxeMeta = pickaxe.getItemMeta();
        pickaxeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', config.getString("pickaxe.name")));
        pickaxeMeta.addEnchant(Enchantment.DIG_SPEED, config.getInt("pickaxe.enchantments.efficiency"), true);
        pickaxeMeta.addEnchant(Enchantment.DURABILITY, config.getInt("pickaxe.enchantments.unbreaking"), true);
        pickaxeMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, config.getInt("pickaxe.enchantments.fortune"), true);

        pickaxeMeta.setLore(lore);
        pickaxe.setItemMeta(pickaxeMeta);
        owner.getInventory().addItem(pickaxe);
    }

    @EventHandler
    public void onCubicalPickaxeUse(BlockBreakEvent event) {
        if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().toString().equalsIgnoreCase("Cubical I")) {
            Location one = event.getBlock().getLocation();
            Location two = one.add(1, 0, 0);
            Location three = one.add(-1, 0, 0);
            Location four = one.add(0, 0, 1);
            Location five = one.add(0, 0, -1);
            Location six = one.add(1, 0, 1);
            Location seven = one.add(1, 0, -1);
            Location eight = one.add(-1, 0, 1);
            Location nine = one.add(-1, 0, -1);
            one.getBlock().breakNaturally();
            two.getBlock().breakNaturally();
            three.getBlock().breakNaturally();
            four.getBlock().breakNaturally();
            five.getBlock().breakNaturally();
            six.getBlock().breakNaturally();
            seven.getBlock().breakNaturally();
            eight.getBlock().breakNaturally();
            nine.getBlock().breakNaturally();
        }
    }
}
