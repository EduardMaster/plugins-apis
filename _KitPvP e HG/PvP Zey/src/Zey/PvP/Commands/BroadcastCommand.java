package Zey.PvP.Commands;

import org.bukkit.event.*;

import Zey.PvP.Main.*;

import org.bukkit.command.*;
import org.bukkit.*;

public class BroadcastCommand implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("broadcast") || cmd.getName().equalsIgnoreCase("bc")) {
            if (sender.hasPermission("zey.pvp.bc")) {
                if (args.length == 0) {
                    sender.sendMessage(String.valueOf(Main.prefix) + " §7» §cErrado, utilize a sintaxe Correta: /bc [Mensagem]");
                    return true;
                }
                String msg = "";
                for (final String msg2 : args) {
                    msg = String.valueOf(String.valueOf(String.valueOf(msg))) + msg2 + " ";
                }
                Bukkit.broadcastMessage(String.valueOf(Main.prefix) + " §6» §f" + msg.replace("&", "§"));
                return true;
            }
            else {
                sender.sendMessage("§cVocê não tem permissão para isso.");
            }
        }
        return false;
    }
}
