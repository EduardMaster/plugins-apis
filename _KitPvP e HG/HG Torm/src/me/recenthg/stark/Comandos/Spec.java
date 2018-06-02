package me.recenthg.stark.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Strings;
import me.recenthg.stark.Manager.Espectadores;

public final class Spec implements Listener, CommandExecutor {
	
  @SuppressWarnings("deprecation")
@Override
  public final boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("spec")) && (p.hasPermission("HungerGames.c.spec"))) {
      if (args.length == 0) {
        sender.sendMessage("§8\u276e§2§l!§8\u276f §7Use /Specs [§aOn | Off§7]");
        return true;
      }
      if (args[0].equalsIgnoreCase("on")) {
        sender.sendMessage("§8\u276e§2§l!§8\u276f §7Todos ficaram visiveis para você!");
        Bukkit.broadcast("§a" + p.getName() + " §7Ativou os specs", "hg.admin");
        for(Player Invisiveis : Bukkit.getOnlinePlayers()) {
        p.showPlayer(Invisiveis);
        }
      } else if (args[0].equalsIgnoreCase("off")) {
         sender.sendMessage("§8\u276e§2§l!§8\u276f §7Todos ficaram invisiveis para você!");
         Bukkit.broadcast("§a" + p.getName() + " §7Desativou Os Specs", "hg.admin");
         for (Player p1 : Admin.admin) {
          p.hidePlayer(p1);
        }
        for (Player p2 : Espectadores.DamageMobs) {
         p.hidePlayer(p2);
       }
      } else {
       sender.sendMessage("§8\u276e§2§l!§8\u276f §7Specs §7[§aOn | Off§7]");
     }
    } else {
    	p.sendMessage(Strings.semperm);
    return true;
    }
return true;
  }
}