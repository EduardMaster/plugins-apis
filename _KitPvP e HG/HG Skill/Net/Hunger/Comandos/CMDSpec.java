package Net.Hunger.Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Net.Hunger.Main;
import Net.Hunger.Manager.EspectadoresManager;

public final class CMDSpec implements Listener, CommandExecutor {
	
  @Override
  public final boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("spec")) && (p.hasPermission("HungerGames.c.Admin"))) {
      if (args.length == 0) {
        sender.sendMessage("§7[§a!§7] Você deve usar:");
        sender.sendMessage("§7[§a!§7] /Specs [§aOn§7|§aOff§7]");
        return true;
      }
      if (args[0].equalsIgnoreCase("on")) {
        sender.sendMessage("§7[§a!§7] Todos ficaram visiveis para você!");
        Bukkit.broadcast(p.getName() + ChatColor.GRAY + " Ativou os specs", "hg.admin");
        for(Player Invisiveis : Bukkit.getOnlinePlayers()) {
        p.showPlayer(Invisiveis);
        }
      } else if (args[0].equalsIgnoreCase("off")) {
         sender.sendMessage("§7[§a!§7] Todos ficaram invisiveis para você!");
         Bukkit.broadcast(p.getName() + ChatColor.GRAY + " Desativou os specs", "hg.admin");
         for (Player p1 : CMDAdmin.admin) {
          p.hidePlayer(p1);
        }
        for (Player p2 : EspectadoresManager.DamageMobs) {
         p.hidePlayer(p2);
       }
      } else {
       sender.sendMessage("§7[§a!§7] Você deve usar:");
       sender.sendMessage("§7[§a!§7] /Specs [§aOn§7|§aOff§7]");
     }
    } else {
    p.sendMessage("§7[§a?§7] " + "Você não possue permissão para isso!");
    return true;
    }
return true;
  }
}