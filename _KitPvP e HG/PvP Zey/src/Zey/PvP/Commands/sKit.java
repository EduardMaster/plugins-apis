package Zey.PvP.Commands;

import org.bukkit.event.*;
import org.bukkit.inventory.*;

import Zey.PvP.Main.*;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import java.util.*;

public class sKit implements Listener, CommandExecutor
{
    public HashMap<String, ItemStack[]> itens;
    public HashMap<String, ItemStack[]> armor;
    
    public sKit(final Main main) {
        this.itens = new HashMap<String, ItemStack[]>();
        this.armor = new HashMap<String, ItemStack[]>();
    }
    
    public boolean isInt(final String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException ex) {
            return false;
        }
    }
    
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        final Player p = (Player)Sender;
        if (Label.equalsIgnoreCase("skit") && Sender instanceof Player) {
            if (!p.hasPermission("zey.pvp.skit")) {
                p.sendMessage("§cVocê não tem permissão para isso.");
                return true;
            }
            if (Args.length == 0) {
                p.sendMessage("       ");
                p.sendMessage("                " + Main.prefix);
                p.sendMessage("");
                p.sendMessage("§b» §eUtilize /skit criar [Kit]");
                p.sendMessage("§b» §eUtilize /skit aplicar [Kit] [Raio de Blocos]");
                p.sendMessage("       ");
                return true;
            }
            if (Args[0].equalsIgnoreCase("criar")) {
                if (Args.length == 1) {
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §cUse: /skit para ver um mini-tutorial.");
                    return true;
                }
                final String nome = Args[1];
                this.itens.put(nome, p.getInventory().getContents());
                this.armor.put(nome, p.getInventory().getArmorContents());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §aO Kit: §e" + Args[1] + " §aFoi Criado");
                return true;
            }
            else if (Args[0].equalsIgnoreCase("aplicar")) {
                if (Args.length <= 2) {
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §cUtlize /skit para ver um mini-tutorial.");
                    return true;
                }
                final String nome = Args[1];
                if (!this.itens.containsKey(nome) && !this.armor.containsKey(nome)) {
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §cO Kit §e" + nome + " §cnão existe");
                    return true;
                }
                if (this.isInt(Args[2])) {
                    final int n = Integer.parseInt(Args[2]);
                    for (final Entity e : p.getNearbyEntities((double)n, (double)n, (double)n)) {
                        if (e instanceof Player) {
                            final Player p2 = (Player)e;
                            p2.getInventory().setArmorContents((ItemStack[])this.armor.get(nome));
                            p2.getInventory().setContents((ItemStack[])this.itens.get(nome));
                        }
                    }
                    Bukkit.getServer().broadcastMessage("");
                    Bukkit.getServer().broadcastMessage(String.valueOf(Main.prefix) + " §f» §7O Kit §e" + nome + " §7foi aplicado em um raio de §e" + n + " §ablocos");
                    Bukkit.getServer().broadcastMessage("");
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você aplicou o kit §e" + nome + " §7em um raio de §e" + n + " §7blocos");
                    return true;
                }
            }
        }
        return false;
    }
}
