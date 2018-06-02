package me.rafael.vinagre.KomboPvP.Comandos;



	import org.bukkit.command.*;
	import org.bukkit.entity.*;
import org.bukkit.event.Listener;

import Scoreboard.ScoreDoBasic;
import XP.XpM;
import me.Drink_2.API;
import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.KillsDeathsMoney;
import tk.Killman96.main.Stats;

import org.bukkit.*;

	public class Status implements CommandExecutor
	{
	    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
	        final Player p = (Player)sender;
	        if (cmd.getName().equalsIgnoreCase("status")) {
	            if (args.length == 0) {
	            	p.sendMessage("§c=- §6§lSeus Status §c=-");
	                p.sendMessage("§6Suas Kills: §c" + KillsDeathsMoney.getKills(p));
	                p.sendMessage("§6Suas Mortes: §c" + KillsDeathsMoney.getDeaths(p));
	                p.sendMessage("§6Seu XP: §c" + XpM.getPlayerMoney(p));
	                return true;
	            }
	            if (args.length > 0 && args.length < 2) {
	                final Player t = Bukkit.getServer().getPlayer(args[0]);
	                if (t != null) {
	                    p.sendMessage("§6Status de §5" + t.getDisplayName());
	                    p.sendMessage("§6Kills: §c" + KillsDeathsMoney.getKills(t));
	                    p.sendMessage("§6Mortes: §c" + KillsDeathsMoney.getDeaths(t));
	                    p.sendMessage("§6XP: §c" + XpM.getPlayerMoney(t));
	                    return true;
	                }
	            }
	          
	            }
	        
	        return false;
	    }
	}

