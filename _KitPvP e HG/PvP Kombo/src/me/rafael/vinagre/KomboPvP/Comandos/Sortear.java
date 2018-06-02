package me.rafael.vinagre.KomboPvP.Comandos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Board;
import me.rafael.vinagre.KomboPvP.Listeners.SpamCheck;
import me.rafael.vinagre.KomboPvP.MySQL.MySQLManager;

@SuppressWarnings("unused")
public class Sortear 
implements Listener, CommandExecutor
{
	boolean caixa = false;

	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args){
		if(!(sender instanceof Player)){
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("sortear")){
			Player p = (Player)sender;
			if(!p.hasPermission("kitpvp.admin")){
				return true;
			}
			if(args.length == 0){
				p.sendMessage("§e§lDesert§f§lPvP §7» §aUse /sortear <caixa>");
				return true;
			}
			if(args[0].equalsIgnoreCase("caixa")){
				if(caixa == true){
					p.sendMessage("§e§lDesert§f§lPvP §7» §cJa existe um sorteio aberto !");
					return true;
				}
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage("§e§lDesert§f§lPvP §7» §aSorteando uma Caixa Normal daqui 1 Minuto ! \nPara participar fique online !");
				Bukkit.broadcastMessage(" ");
                caixa = true;
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					
					@SuppressWarnings({ "deprecation", "rawtypes" })
					@Override
					public void run() {
						if(caixa == true){
						caixa = false;
				          @SuppressWarnings("unchecked")
						ArrayList<String> emsabugado = new ArrayList();
				          for (Player emsabugo : Bukkit.getOnlinePlayers()) {
				        	  if(!emsabugo.hasPermission("kitpvp.admin")){
				        		  emsabugado.add(emsabugo.getName());
				        	  }
				          }
				          if(emsabugado.size() < 5){
								Bukkit.broadcastMessage(" ");
								Bukkit.broadcastMessage("§e§lDesert§f§lPvP §7» §cSorteio cancelado pela falta de jogadores !");
								Bukkit.broadcastMessage(" ");
				        	  return;
				          }
				          String o = (String)emsabugado.get(new Random().nextInt(emsabugado.size()));
				          Player p2 = Bukkit.getPlayer(o);
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage("§e§lDesert§f§lPvP §7» §aSorteio finalizado ! \nGanhador: §f" + p2.getName() + " §a!");
							Bukkit.broadcastMessage(" ");
			        	  try {
							MySQLManager.setCaixaN(p2, MySQLManager.getCaixasN(p2) + 1);
			                Board.setScoreBoard(p2);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					  }
					}
				}, 60 * 20L);
				return true;
			}
		}
		return true;
	}
}