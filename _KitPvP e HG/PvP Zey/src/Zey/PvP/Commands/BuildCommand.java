package Zey.PvP.Commands;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;

import Zey.PvP.Main.Main;

public final class BuildCommand implements Listener, CommandExecutor
{
    public static ArrayList<Player> embuild;
    
    static {
        BuildCommand.embuild = new ArrayList<Player>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("build")) {
            if (p.hasPermission("zey.pvp.build")) {
                if (args.length == 0) {
                    if (!BuildCommand.embuild.contains(p)) {
                        BuildCommand.embuild.add(p);
                        p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Seu Modo Build §a§lHABILITADO§7.");
                    }
                    else {
                        BuildCommand.embuild.remove(p);
                        p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Seu Modo Build §c§lDESABILITADO§7.");
                    }
                }
                else {
                    final Player t = Bukkit.getPlayer(args[0]);
                    if (t == null) {
                        p.sendMessage(String.valueOf(Main.prefix) + " §7» §cEste jogador(a) está offline ou não existe.");
                        return true;
                    }
                    if (!BuildCommand.embuild.contains(t)) {
                        BuildCommand.embuild.add(t);
                        p.sendMessage(String.valueOf(Main.prefix) + " §7» Modo Build §a§lHABILITADO §7para o jogador(a): §e" + t.getName() + "§7.");
                        t.sendMessage(String.valueOf(Main.prefix) + " §7» Seu Modo Build foi §a§lHABILITADO §7pelo jogador(a): §e" + p.getName() + "§7.");
                    }
                    else {
                        BuildCommand.embuild.remove(t);
                        p.sendMessage(String.valueOf(Main.prefix) + " §7» Modo Build §c§lDESABILITADO §7para o jogador(a): §e" + t.getName() + "§7.");
                        t.sendMessage(String.valueOf(Main.prefix) + " §7» Seu Modo Build foi §c§lDESABILITADO §7pelo jogador(a): §e" + p.getName() + "§7.");
                    }
                }
            }
            else {
                p.sendMessage("§cVocê não tem permissão para isso.");
            }
        }
        return false;
    }
    
    @EventHandler
    public void aoconstruir(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        if (!BuildCommand.embuild.contains(p)) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void aoconstruir(final BlockBreakEvent e) {
        final Player p = e.getPlayer();
        if (!BuildCommand.embuild.contains(p)) {
            e.setCancelled(true);
        }
    }
}
