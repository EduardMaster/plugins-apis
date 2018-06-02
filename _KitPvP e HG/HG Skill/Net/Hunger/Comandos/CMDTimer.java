package Net.Hunger.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Net.Hunger.Main;
import Net.Hunger.Timer.StringTimer;

public class CMDTimer implements CommandExecutor {
		
	  public static boolean isNumeric(String str) {
		    try {
		      Integer.parseInt(str);
		    } catch (NumberFormatException nfe) {
		      return false;
		    }
		    return true;
		  }

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		  if(!(sender instanceof Player )) {
			  sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
			  return true;
			  }
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("tpall")) {
			if(sender.hasPermission("HungerGames.c.tpall")) {
			   p.sendMessage("§7[§a!§7] Você teleportou todos os players!");
		        Bukkit.getLogger().info(p.getName() + " Trouxe todos jogadores a sua posição!");
			   for(Player pl : Bukkit.getOnlinePlayers()) {
				   pl.teleport(p.getLocation());
			   }
			  } else {
				  p.sendMessage("§7[§a?§7] Você não possue permissão para isso!");
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
				     Bukkit.getLogger().info(p.getName() + " Alterou a invenbilidade para " + StringTimer.TimerGame(Integer.valueOf(newTime)));
					 Bukkit.broadcastMessage("§7[§a!§7] Invencibilidade alterada para §a" + StringTimer.TimerGame(Integer.valueOf(newTime)));
					} else {
						sender.sendMessage("§7[§a!§7] Você não pode alterar para tanto tempo!");
					}
				} else sender.sendMessage("§7[§a!§7] Use: /inv [time]");
			} else {
				  p.sendMessage("§7[§a?§7] Você não possue permissão para isso!");
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
				     Bukkit.getLogger().info(p.getName() + " Alterou o tempo da partida para " + StringTimer.TimerGame(Integer.valueOf(newTime)));
					 Bukkit.broadcastMessage("§7[§a!§7] Tempo de partida alterada para §a" + StringTimer.TimerGame(Integer.valueOf(newTime)));
					} else {
						sender.sendMessage("§7[§a?§7] Você não pode alterar para tanto tempo!");
					}
				} else sender.sendMessage("§7[§a?§7] Use: /game [time]");
			} else {
				  p.sendMessage("§7[§a?§7] Você não possue permissão para isso!");
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
					 Bukkit.getLogger().info(p.getName() + " Alterou o PreGame para " + StringTimer.TimerGame(Integer.valueOf(newTime)));
					 Bukkit.broadcastMessage("§7[§a!§7] PreGame alterado para §a" + StringTimer.TimerGame(Integer.valueOf(newTime)));
					} else {
						sender.sendMessage("§7[§a?§7] Você não pode alterar para tanto tempo!");
					}
				} else sender.sendMessage("§7[§a?§7] Use: /tempo [time]");
			} else {
				  p.sendMessage("§7[§a?§7] Você não possue permissão para isso!");
				    return true;
			}
		}
		return false;
	}
}