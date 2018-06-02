package Zey.PvP.Commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import Zey.PvP.Main.Main;

import org.bukkit.*;

public class FlyCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender s, final Command cmd, final String label, final String[] args) {
        if (!(s instanceof Player)) {
            return false;
        }
        final Player p = (Player)s;
        if (!p.hasPermission("zey.pvp.fly")) {
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê precisa ser §e[SUPREMO] §cou superior, para voar.");
            return true;
        }
        
        if(Zey.PvP.APIs.WarpAPI.getWarp(p) == "Arena") {
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê só pode voar no spawn, volte ao spawn usando o comando: /spawn");
        	return true;
        }
        if(Zey.PvP.APIs.WarpAPI.getWarp(p) == "Fps") {
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê só pode voar no spawn, volte ao spawn usando o comando: /spawn");
        	return true;
        }
        if(Zey.PvP.APIs.WarpAPI.getWarp(p) == "Challenge") {
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê só pode voar no spawn, volte ao spawn usando o comando: /spawn");
        	return true;
        }
        if(Zey.PvP.APIs.WarpAPI.getWarp(p) == "Parkour") {
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê só pode voar no spawn, volte ao spawn usando o comando: /spawn");
        	return true;
        }
        if(Zey.PvP.APIs.WarpAPI.getWarp(p) == "Main") {
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê só pode voar no spawn, volte ao spawn usando o comando: /spawn");
        	return true;
        }
        
        if (args.length == 0) {
            if (p.getAllowFlight()) {
                p.setAllowFlight(false);
                p.setFlying(false);
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Modo Fly §c§lDESABILITADO §7para o jogador(a): §e" + p.getName());
                return true;
            }
            p.setAllowFlight(true);
            p.setFlying(true);
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Modo Fly §a§lHABILITADO §7para o jogador(a): §e" + p.getName());
            return true;
        }
        else {
            if (args.length != 1) {
                s.sendMessage("§7» §cErrado, Utilize a sintaxe correta: /fly [Jogador(a)]");
                return true;
            }
            if (!p.hasPermission("zey.pvp.fly.others")) {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê precisa ser §a[FRIEND] §cou superior, para permitir um jogador(a) voar.");
                return true;
            }
            final Player t = Bukkit.getPlayerExact(args[0]);
            if (t == null) {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cEste jogador(a) está offline.");
                return true;
            }
            if (t.getAllowFlight()) {
                t.setAllowFlight(false);
                t.setFlying(false);
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você §c§lDESABILITOU §7o Fly para o jogador(a): §e" + t.getName());
                t.sendMessage(String.valueOf(Main.prefix) + " §7» §7Fly §c§lDESABILITADO §7pelo jogador(a): §e" + p.getName());
                return true;
            }
            t.setAllowFlight(true);
            t.setFlying(true);
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você §a§lHABILITOU §7o modo Fly para o jogador(a): §e" + t.getName());
            t.sendMessage(String.valueOf(Main.prefix) + " §7» §7Fly §a§lHABILITADO §7pelo jogador(a): §e" + p.getName());
            return true;
        }
    }
}
