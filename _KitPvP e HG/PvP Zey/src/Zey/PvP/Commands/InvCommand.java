package Zey.PvP.Commands;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;

import Zey.PvP.Main.*;

public class InvCommand implements Listener, CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String Label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(String.valueOf(Main.prefix) + " §7» §cApenas jogadores podem usar isso.");
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("inv")) {
            if (sender.hasPermission("zey.pvp.inv")) {
                sender.sendMessage(String.valueOf(Main.prefix) + " §7» §cErrado, utilize a sintaxe correta: /inv [Jogador(a)]");
                if (args.length > 0) {
                    final Player player = Bukkit.getPlayer(args[0]);
                    if (player == null) {
                        sender.sendMessage(String.valueOf(Main.prefix) + " §7» §cEste jogador(a) está offline ou não existe.");
                        return true;
                    }
                    sender.sendMessage(String.valueOf(Main.prefix) + " §7» §7Inventario §a§lABERTO§7 com sucesso.");
                    p.openInventory((Inventory)player.getInventory());
                }
            }
            else {
                p.sendMessage("§cVocê não tem permissão para isso.");
            }
            return true;
        }
        return true;
    }
}
