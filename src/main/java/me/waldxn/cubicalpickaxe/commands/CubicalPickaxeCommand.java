package me.waldxn.cubicalpickaxe.commands;

import me.waldxn.cubicalpickaxe.manager.PickaxeManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CubicalPickaxeCommand implements CommandExecutor {

    private PickaxeManager manager;

    public CubicalPickaxeCommand(PickaxeManager m) {
        this.manager = m;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player owner;

        if (args.length == 0 && !(sender instanceof Player)) {
            sender.sendMessage("You can't give console a cubical pickaxe!");
            return true;
        } else if (args.length == 0) {
            owner = (Player) sender;
        } else if (args.length == 1) {
            if (Bukkit.getPlayer(args[1]) != null) {
                owner = Bukkit.getPlayer(args[1]);
            } else {
                sender.sendMessage(args[1] + " isn't online!");
                return true;
            }
        } else {
            return false;
        }

        if (owner.getInventory().firstEmpty() == -1) {
            sender.sendMessage("Inventory full. Please make space for the cubical pickaxe!");
            return true;
        }

        if (!manager.checkConfigNulls()) {
            sender.sendMessage("Check config. Invalid values!");
            return true;
        }

        manager.createCubicalPickaxe(owner);

        if (sender != owner) {
            sender.sendMessage("Cubical Pickaxe added to " + owner.getName() + "'s inventory!");
            owner.sendMessage("Cubical Pickaxe added to your inventory!");
        } else {
            owner.sendMessage("Cubical Pickaxe added to your inventory!");
        }


        return true;
    }
}
