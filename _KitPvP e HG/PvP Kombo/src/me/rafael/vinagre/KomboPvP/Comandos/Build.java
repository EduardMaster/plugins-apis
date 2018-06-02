package me.rafael.vinagre.KomboPvP.Comandos;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;



public final class Build implements Listener, CommandExecutor
{
    public static ArrayList<Player> embuild;
    
    static {
        Build.embuild = new ArrayList<Player>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("build")) {
            if (p.hasPermission("kitpvp.build")) {
                if (args.length == 0) {
                    if (!Build.embuild.contains(p)) {
                        Build.embuild.add(p);
                        p.sendMessage(String.valueOf( "§aVoc\u00ea ativou seu modo build"));
                    }
                    else {
                        Build.embuild.remove(p);
                        p.sendMessage(String.valueOf( "§cVoc\u00ea desativou seu modo build"));
                    }
                }
                else {
                    final Player t = Bukkit.getPlayer(args[0]);
                    if (t == null) {
                        p.sendMessage("Jogador off");
                        return true;
                    }
                    if (!Build.embuild.contains(t)) {
                        Build.embuild.add(t);
                        p.sendMessage(String.valueOf( "§aVoc\u00ea ativou o modo build de: §7" + t.getName()));
                    }
                    else {
                        Build.embuild.remove(t);
                        p.sendMessage(String.valueOf("§cVoc\u00ea desativou o modo build de: §7" + t.getName()));
                    }
                }
            }
            else {
                p.sendMessage("§4§lErro: §c§lAcesso negado");
            }
        }
        return false;
    }
    
    @EventHandler
    public void aoconstruir(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        if (!Build.embuild.contains(p)) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void aoconstruir(final BlockBreakEvent e) {
        final Player p = e.getPlayer();
        if (!Build.embuild.contains(p)) {
            e.setCancelled(true);
        }
    }
}