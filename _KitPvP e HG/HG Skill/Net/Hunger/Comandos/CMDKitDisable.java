package Net.Hunger.Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import Net.Hunger.Manager.EspectadoresManager;
import Net.Hunger.Manager.Habilidade;

public final class CMDKitDisable implements Listener, CommandExecutor {
	
  public static boolean KitsDisable;
	
  @EventHandler
  public void NoKitDisable(final PlayerCommandPreprocessEvent event) {
  Player p = event.getPlayer();
  if(KitsDisable) {
  if(event.getMessage().toLowerCase().startsWith("/kit ")) {
  p.sendMessage("§7[§a!§7] Os Kits estão desativados!");
  event.setCancelled(true);
  return;
  }
  }
  }
	
  @Override
  public final boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	if (!(sender instanceof Player)) {
      sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
	  return true;
	  }
    Player p = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("togglekit"))) {
    if(p.hasPermission("HungerGames.c.Toggle")) {
     if (args.length == 0) {
      sender.sendMessage("§7[§a!§7] Você deve usar:");
      sender.sendMessage("§7[§a!§7] /ToggleKit [§aNick]");
     return true;
     }
    Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target == null) {
      p.sendMessage("§7[§a!§7] Nao existe nenhum jogador com o nome §a" + target.getName());
     return true;
    }
    if(args[0].equalsIgnoreCase(target.getName())) {
    Habilidade.removeAbility(target);
    p.sendMessage("§7[§a!§7] Você desativou o kit de §a" + target.getName());
    target.sendMessage("§7[§a!§7] Seu kit foi desativado §a" + sender.getName());
     }
    } else {
     p.sendMessage("§7[§a?§7] " + "Você não possue permissão para isso!");
    return true;
    }
    }
	return true;
  }
}
  