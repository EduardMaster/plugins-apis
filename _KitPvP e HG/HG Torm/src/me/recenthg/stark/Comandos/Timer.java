package me.recenthg.stark.Comandos;

import me.recent.stark.Main;
import me.recent.stark.Strings;
import me.recenthg.stark.Tempo.StringTimer;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Timer implements CommandExecutor {
		
	  public static boolean isNumeric(String str) {
		    try {
		      Integer.parseInt(str);
		    } catch (NumberFormatException nfe) {
		      return false;
		    }
		    return true;
		  }

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		  if(!(sender instanceof Player )) {
			  sender.sendMessage("§8\u276e§2§l!§8\u276f §7Comandos apenas no servidor!");
			  return true;
			  }
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("tpall")) {
			if(sender.hasPermission("HungerGames.c.tpall")) {
			   p.sendMessage("§8\u276e§2§l!§8\u276f §7Você teleportou todos os players!");
		        Bukkit.getLogger().info(p.getName() + " §7Trouxe todos jogadores a sua posição!");
			   for(Player pl : Bukkit.getOnlinePlayers()) {
				   pl.teleport(p.getLocation());
			   }
			  } else {
					p.sendMessage(Strings.semperm);
				    return true;
			  }
			}
		if(cmd.getName().equalsIgnoreCase("invencibilidade")) {
			if(p.hasPermission("HungerGames.c.time")) {
				if (args.length > 0) {
					if (isNumeric(args[0])) {
					int newTime = Integer.parseInt(args[0]);
					 if ((newTime == 0) && (Main.TimerInvencibilidade != 0))
					 Main.IniciarPartida();
					 else
					 Main.TimerInvencibilidade = newTime;
				     Bukkit.getLogger().info(p.getName() + "§7Alterou a invenbilidade para " + StringTimer.TimerGame(Integer.valueOf(newTime)));
					 Bukkit.broadcastMessage("§8\u276e§2§l!§8\u276f §7Invencibilidade alterada para §6" + StringTimer.TimerGame(Integer.valueOf(newTime)));
					} else {
						sender.sendMessage("§8\u276e§2§l!§8\u276f §7Você não pode alterar para tanto tempo!");
					}
				} else sender.sendMessage("§8\u276e§2§l!§8\u276f §7Use: /inv §7[§6time]");
			} else {
				p.sendMessage(Strings.semperm);
				    return true;
			}
		}
		if(cmd.getName().equalsIgnoreCase("game")) {
			if(p.hasPermission("HungerGames.c.time")) {
				if (args.length > 0) {
					if (isNumeric(args[0])) {
					int newTime = Integer.parseInt(args[0]);
					 if ((newTime == 0) && (Main.Andamento != 0))
						 Main.IniciarPartida();
					 else
					 Main.Andamento = newTime;
				     Bukkit.getLogger().info(p.getName() + " §7Alterou o tempo da partida para " + StringTimer.TimerGame(Integer.valueOf(newTime)));
					 Bukkit.broadcastMessage("§8\u276e§2§l!§8\u276f §7Tempo de partida alterada para §6" + StringTimer.TimerGame(Integer.valueOf(newTime)));
					} else {
						sender.sendMessage("§8\u276e§2§l!§8\u276f §7Você não pode alterar para tanto tempo!");
					}
				} else sender.sendMessage("§8\u276e§2§l!§8\u276f §7Use: /game §7[§6time§7]");
			} else {
				p.sendMessage(Strings.semperm);
				    return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("pregame")) {
			if(p.hasPermission("HungerGames.c.time")) {
				if (args.length > 0) {
					if (isNumeric(args[0])) {
					int newTime = Integer.parseInt(args[0]);
					 if ((newTime == 0) && (Main.TimerIniciando != 0))
						 Main.IniciarPartida();
					 else
					 Main.TimerIniciando = newTime;
					 Bukkit.getLogger().info(p.getName() + " §7Alterou o PreGame para " + StringTimer.TimerGame(Integer.valueOf(newTime)));
					 Bukkit.broadcastMessage("§8\u276e§2§l!§8\u276f §7PreGame alterado para §6" + StringTimer.TimerGame(Integer.valueOf(newTime)));
					} else {
						sender.sendMessage("§8\u276e§2§l!§8\u276f §7Você não pode alterar para tanto tempo!");
					}
				} else sender.sendMessage("§8\u276e§2§l!§8\u276f §7Use: /tempo §7[§6time§7]");
			} else {
				p.sendMessage(Strings.semperm);
				    return true;
			}
		}
		return false;
	}
}