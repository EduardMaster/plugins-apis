package Net.Hunger.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Net.Hunger.Main;

public class CMDSpecTp implements Listener, CommandExecutor {

	 @SuppressWarnings("deprecation")
	 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	 if (!(sender instanceof Player)) {
	   sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
	    return true;
	   }
	   final Player p = (Player)sender;
	   if(Main.Watch.contains(p.getName())) {
	    if (args.length == 0) {
	      p.sendMessage("§7[§a!§7] Voce deve escolher o jogador!");
	      return true;
	     }
	     Player target = Bukkit.getServer().getPlayer(args[0]);
	     if (target == null) {
	     p.sendMessage("§7[§a!§7] Nao existe nenhum jogador com o nome §a" + args[0]);
	     return true;
	     }
	     p.teleport(target.getLocation());
	     p.sendMessage("§7[§a!§7] Voce foi teleportado para o §a" + target.getName());
	     Bukkit.getLogger().info(p.getName() + " Se teleportou até " + target.getName());
	     return true;
	    } else {
	    p.sendMessage("§7[§a?§7] Você deve ser um §aespectador §7para usar isso!");
	    return true;
	    }
      }
     }