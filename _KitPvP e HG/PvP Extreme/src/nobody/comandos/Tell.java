package nobody.comandos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tell implements CommandExecutor {
	
	  public static HashMap<Player, Player> gettell = new HashMap<>();
	  static ArrayList<Player> telloff = new ArrayList<>();

	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    if (label.equalsIgnoreCase("tell")) {
	      if (args.length == 0) {
	        p.sendMessage("§7[§6§l!§7] Use /Tell (Jogador) (Mensagem)");
	        return true;
	      }
	      Player target = Bukkit.getPlayer(args[0]);
	      if (args[0].toLowerCase().equalsIgnoreCase("on")) {
	        telloff.remove(p);
	        p.sendMessage("§7[§6§l!§7] §7Seu Tell Está : §aATIVADO");
	      } else if (args[0].toLowerCase().equalsIgnoreCase("off")) {
	        telloff.add(p);
	        p.sendMessage("§7[§6§l!§7] §7Seu Tell Está : §4DESATIVADO");
	      }
	      if (args.length > 1) {
	        if (target == null) {
	          p.sendMessage("§7[§6§l!§7] §7Jogador Offline");
	          return true;
	        }
	        if (telloff.contains(target)) {
	          p.sendMessage("§7[§6§l!§7] §7O Tell do Jogador está §4DESATIVADO");
	          return true;
	        }
	        StringBuilder sb = new StringBuilder();
	        for (int i = 1; i < args.length; i++) {
	          sb.append(args[i]).append(" ");
	        }
	        String allArgs = sb.toString().trim();
	        p.sendMessage("[§aEu§r --> §a" + target.getName() + "§r: " + allArgs);
	        target.sendMessage("§a" + p.getName() + " eu§r] §r--> " + allArgs);
	        gettell.put(p, target);
	        gettell.put(target, p);
	      }
	    } else if (label.equalsIgnoreCase("r")) {
	      if (args.length == 0) {
	        p.sendMessage("§7[§6§l!§7] §7Use /s (Mensagem)");
	        return true;
	      }
	      if (!gettell.containsKey(p)) {
	        p.sendMessage("§7[§6§l!§7] §7Você não tem ninguém para responder");
	        return true;
	      }
	      Player deslogo = (Player)gettell.get(p);
	      if (deslogo == null) {
	        p.sendMessage("§7[§6§l!§7] §7Jogador Offline");
	        return true;
	      }
	      if (telloff.contains(deslogo)) {
	        p.sendMessage("§7[§6§l!§7] §7O Tell do Jogador está §4DESATIVADO");
	        return true;
	      }
	      StringBuilder sb = new StringBuilder();
	      for (int i = 0; i < args.length; i++) {
	        sb.append(args[i]).append(" ");
	      }
	      String allArgs = sb.toString().trim();
	      p.sendMessage("[§aEu§r » §a" + deslogo.getName() + "§r: " + allArgs);
	      deslogo.sendMessage("§a" + p.getName() + " eu§r] §r» " + allArgs);
	    }
	    return false;
	  }

}
