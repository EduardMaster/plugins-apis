package me.recenthg.stark.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Main;

public class SpecTp implements Listener, CommandExecutor {

	 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	 if (!(sender instanceof Player)) {
	   sender.sendMessage("§8\u276e§2§l!§8\u276f §7Comandos apenas no servidor!");
	    return true;
	   }
	   final Player p = (Player)sender;
	   if(Main.Watch.contains(p.getName())) {
	    if (args.length == 0) {
	      p.sendMessage("§8\u276e§2§l!§8\u276f §7Voce deve escolher o jogador!");
	      return true;
	     }
	     Player target = Bukkit.getServer().getPlayer(args[0]);
	     if (target == null) {
	     p.sendMessage("§8\u276e§2§l!§8\u276f §7Nao existe nenhum jogador com o nome §a" + args[0]);
	     return true;
	     }
	     p.teleport(target.getLocation());
	     p.sendMessage("§8\u276e§2§l!§8\u276f §7Voce foi teleportado para o §a" + target.getName());
	     Bukkit.getLogger().info("§a" + p.getName() + " §6Se teleportou atê §a" + target.getName());
	     return true;
	    } else {
	    p.sendMessage("§8\u276e§2§l!§8\u276f §7Você deve ser um espectador para usar isso!");
	    return true;
	    }
      }
     }