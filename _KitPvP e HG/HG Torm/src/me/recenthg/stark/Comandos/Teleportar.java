package me.recenthg.stark.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Strings;

public class Teleportar implements CommandExecutor, Listener {

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)  {
    if (!(sender instanceof Player)) {
      sender.sendMessage("§8\u276e§2§l!§8\u276f §7Comandos apenas no servidor!");
      return true;
    }
    Player player = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("tp")) {
      if (!player.hasPermission("HungerGames.c.tp")) {
    		player.sendMessage(Strings.semperm);
        return true;
      }
      if (args.length == 0) {
        player.sendMessage("§8\u276e§2§l!§8\u276f §7Use /tp [player] §7para ir ate um player!");
        player.sendMessage("§8\u276e§2§l!§8\u276f §7Use /s [player] §7para puxar um player ate você!");
        return true;
      }
      if (args.length == 1) {
        Player target = Bukkit.getPlayerExact(args[0]);
        if ((target == null) || (!(target instanceof Player))) {
          player.sendMessage("§8\u276e§2§l!§8\u276f §7Jogador não encontrado!");
          return true;
        }
        player.teleport(target);
        player.sendMessage("§8\u276e§2§l!§8\u276f §7Teleportado para §6" + target.getName());
        Bukkit.getLogger().info(player.getName() + "§7Teleportou-se ate §6" + target.getName());
  	    Bukkit.broadcast("§7" + player.getName() + ChatColor.GRAY + " Se teleportou para §6" + target.getName(), "hg.admin");
        return true;
      }
      if (args.length > 1)
      {
        player.sendMessage("§8\u276e§2§l!§8\u276f §7Use /tp [player] §7para ir ate um player!");
        player.sendMessage("§8\u276e§2§l!§8\u276f §7Use /s [player] §7para puxar um player ate você!");
        return true;
      }
    }
    else if (cmd.getName().equalsIgnoreCase("s"))
    {
      if (!player.hasPermission("HungerGames.c.tp"))
      {
        player.sendMessage("§8\u276e§2§l!§8\u276f §7Você não tem permissao para fazer isso!");
        return true;
      }
      if (args.length == 0)
      {
        player.sendMessage("§8\u276e§2§l!§8\u276f §7Use /tp [player] §7para ir ate um player!");
        player.sendMessage("§8\u276e§2§l!§8\u276f §7Use /s [player] §7para puxar um player ate você!");
        return true;
      }
      if (args.length == 1)
      {
        Player target = Bukkit.getPlayerExact(args[0]);
        if ((target == null) || (!(target instanceof Player)))
        {
          player.sendMessage("§8\u276e§2§l!§8\u276f §7Jogador não encontrado!");
          return true;
        }
        target.teleport(player);
        player.sendMessage("§8\u276e§2§l!§8\u276f §7Você trouxe o jogador §6" + target.getName());
        Bukkit.getLogger().info(player.getName() + " §7Trouxe!" + target.getName());
  	    Bukkit.broadcast("§6" + player.getName() + ChatColor.GRAY + " §7Teleportou Para §6" + target.getName(), "hg.admin");
        return true;
      }
      if (args.length > 1)
      {
        player.sendMessage("§8\u276e§2§l!§8\u276f §7Use /tp §7[§6player§7] §7para ir ate um player!");
        player.sendMessage("§8\u276e§2§l!§8\u276f §7Use /s §7[§6player§7] §7para puxar um player ate você!");
        return true;
      }
    }
    return false;
  }
}