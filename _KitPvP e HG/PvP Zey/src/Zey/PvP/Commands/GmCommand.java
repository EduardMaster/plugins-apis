package Zey.PvP.Commands;

import org.bukkit.event.*;
import Zey.PvP.Main.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class GmCommand implements CommandExecutor, Listener
{
    public GmCommand(final Main main) {
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("gm")) {
            if (sender instanceof ConsoleCommandSender) {
                System.out.println(String.valueOf(Main.prefix) + " §7» §cApenas jogadores podem usar isso.");
                return true;
            }
            final Player p = (Player)sender;
            if (args.length == 0) {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cErrado, utilize a sintaxe correta: /gm [0/1]");
            }
            else if (args.length == 1) {
                if (p.hasPermission("zey.pvp.gm") || p.isOp()) {
                    if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("criativo")) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Seu gamemode foi alterado para §a§lCRIATIVO§7.");
                    }
                    else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("sobrevivencia")) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Seu gamemode foi alterado para §c§lSOBREVIVENCIA§7.");
                    }
                    else {
                        p.sendMessage(String.valueOf(Main.prefix) + " §7» §cGamemode Inexistente.");
                    }
                }
                else {
                    p.sendMessage("§cVocê não tem permissão para isso.");
                }
            }
        }
        return false;
    }
}
