package me.waldxn.cubicalpickaxe.manager;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.wasteofplastic.askyblock.ASkyBlockAPI;
import me.waldxn.cubicalpickaxe.CubicalPickaxe;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
    private ItemStack pickaxeVertical = new ItemStack(Material.DIAMOND_PICKAXE);

    public PickaxeManager(CubicalPickaxe pl) {
        this.plugin = pl;
        FileConfiguration config = plugin.getConfig();
        ItemMeta pickaxeVerticalMeta = pickaxeVertical.getItemMeta();
        pickaxeVerticalMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', config.getString("pickaxe.name")));
        pickaxeVerticalMeta.addEnchant(Enchantment.DIG_SPEED, config.getInt("pickaxe.enchantments.efficiency"), true);
        pickaxeVerticalMeta.addEnchant(Enchantment.DURABILITY, config.getInt("pickaxe.enchantments.unbreaking"), true);
        pickaxeVerticalMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, config.getInt("pickaxe.enchantments.fortune"), true);
        ArrayList<String> loreVertical = new ArrayList<>();
        loreVertical.add("Cubical I");
        pickaxeVerticalMeta.setLore(loreVertical);
        pickaxeVertical.setItemMeta(pickaxeVerticalMeta);
    }

    public boolean checkConfigNulls() {

        if (plugin.getConfig().contains("pickaxe.name")) {

            return true;
        }

        if (plugin.getConfig().contains("pickaxe.enchantments.efficiency")) {
            Bukkit.getLogger().info(String.valueOf(plugin.getConfig().get("pickaxe.enchantments.efficiency")));
            return true;
        }

        if (plugin.getConfig().contains("pickaxe.enchantments.unbreaking")) {
            return true;
        }

        if (plugin.getConfig().contains("pickaxe.enchantments.fortune")) {
            return true;
        }

        return false;
    }

    public void createCubicalPickaxe(Player owner) {
        owner.getInventory().addItem(pickaxeVertical);
    }

    @EventHandler
    public void onCubicalPickaxeUse(BlockBreakEvent event) {

        if (ASkyBlockAPI.getInstance().playerIsOnIsland(event.getPlayer())) {
            if (event.getPlayer().getInventory().getItemInHand().isSimilar(pickaxeVertical)) {
                Block one = event.getBlock();
                Block two = one.getRelative(1, 0, 0);
                Block three = one.getRelative(-1, 0, 0);
                Block four = one.getRelative(0, 0, 1);
                Block five = one.getRelative(0, 0, -1);
                Block six = one.getRelative(1, 0, 1);
                Block seven = one.getRelative(1, 0, -1);
                Block eight = one.getRelative(-1, 0, 1);
                Block nine = one.getRelative(-1, 0, -1);
                Block ten = one.getRelative(0, 1, 0);
                Block eleven = one.getRelative(1, 1, 0);
                Block twelve = one.getRelative(-1, 1, 0);
                Block thirteen = one.getRelative(0, 1, 1);
                Block fourteen = one.getRelative(0, 1, -1);
                Block fifteen = one.getRelative(1, 1, 1);
                Block sixteen = one.getRelative(1, 1, -1);
                Block seventeen = one.getRelative(-1, 1, 1);
                Block eighteen = one.getRelative(-1, 1, -1);
                Block nineteen = one.getRelative(0, -1, 0);
                Block twenty = one.getRelative(1, -1, 0);
                Block twentyone = one.getRelative(-1, -1, 0);
                Block twentytwo = one.getRelative(0, -1, 1);
                Block twentythree = one.getRelative(0, -1, -1);
                Block twentyfour = one.getRelative(1, -1, 1);
                Block twentyfive = one.getRelative(1, -1, -1);
                Block twentysix = one.getRelative(-1, -1, 1);
                Block twentyseven = one.getRelative(-1, -1, -1);
                if (one.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), one)) {
                    one.breakNaturally();
                }
                if (two.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), two)) {
                    two.breakNaturally();
                }
                if (three.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), three)) {
                    three.breakNaturally();
                }
                if (four.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), four)) {
                    four.breakNaturally();
                }
                if (five.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), five)) {
                    five.breakNaturally();
                }
                if (six.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), six)) {
                    six.breakNaturally();
                }
                if (seven.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), seven)) {
                    seven.breakNaturally();
                }
                if (eight.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), eight)) {
                    eight.breakNaturally();
                }
                if (nine.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), nine)) {
                    nine.breakNaturally();
                }
                if (ten.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), ten)) {
                    ten.breakNaturally();
                }
                if (eleven.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), eleven)) {
                    eleven.breakNaturally();
                }
                if (twelve.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), twelve)) {
                    twelve.breakNaturally();
                }
                if (thirteen.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), thirteen)) {
                    thirteen.breakNaturally();
                }
                if (fourteen.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), fourteen)) {
                    fourteen.breakNaturally();
                }
                if (fifteen.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), fifteen)) {
                    fifteen.breakNaturally();
                }
                if (sixteen.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), sixteen)) {
                    sixteen.breakNaturally();
                }
                if (seventeen.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), seventeen)) {
                    seventeen.breakNaturally();
                }
                if (eighteen.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), eighteen)) {
                    eighteen.breakNaturally();
                }
                if (nineteen.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), nineteen)) {
                    nineteen.breakNaturally();
                }
                if (twenty.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), twenty)) {
                    twenty.breakNaturally();
                }
                if (twentyone.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), twentyone)) {
                    twentyone.breakNaturally();
                }
                if (twentytwo.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), twentytwo)) {
                    twentytwo.breakNaturally();
                }
                if (twentythree.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), twentythree)) {
                    twentythree.breakNaturally();
                }
                if (twentyfour.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), twentyfour)) {
                    twentyfour.breakNaturally();
                }
                if (twentyfive.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), twentyfive)) {
                    twentyfive.breakNaturally();
                }
                if (twentysix.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), twentysix)) {
                    twentysix.breakNaturally();
                }
                if (twentyseven.getType() != Material.BEDROCK && WorldGuardPlugin.inst().canBuild(event.getPlayer(), twentyseven)) {
                    twentyseven.breakNaturally();
                }
            }
        }
    }
}
