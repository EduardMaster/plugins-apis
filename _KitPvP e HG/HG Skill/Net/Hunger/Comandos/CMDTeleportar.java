package Net.Hunger.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CMDTeleportar implements CommandExecutor, Listener {

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)  {
    if (!(sender instanceof Player)) {
      sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
      return true;
    }
    Player player = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("tp")) {
      if (!player.hasPermission("HungerGames.c.tp")) {
    	player.sendMessage("§7[§a?§7] Você não possue permissão para isso!");
        return true;
      }
      if (args.length == 0) {
        player.sendMessage("§7[§a?§7] Use /tp [player] para ir até um player!");
        player.sendMessage("§7[§a?§7] Use /s [player] para puxar um player até você!");
        return true;
      }
      if (args.length == 1) {
        Player target = Bukkit.getPlayerExact(args[0]);
        if ((target == null) || (!(target instanceof Player))) {
          player.sendMessage("§7[§a?§7] Jogador não encontrado!");
          return true;
        }
        player.teleport(target);
        player.sendMessage("§7[§a!§7] " + "Teleportado para §a" + target.getName());
        Bukkit.getLogger().info(player.getName() + " Teleportou-se até " + target.getName());
  	    Bukkit.broadcast("§7[§a!§7] §a" + player.getName() + ChatColor.GRAY + " Se teleportou para §a" + target.getName(), "hg.admin");
        return true;
      }
      if (args.length > 1)
      {
        player.sendMessage("§7[§a?§7] Use /tp [player] para ir até um player!");
        player.sendMessage("§7[§a?§7] Use /s [player] para puxar um player até você!");
        return true;
      }
    }
    else if (cmd.getName().equalsIgnoreCase("s"))
    {
      if (!player.hasPermission("HungerGames.c.tp"))
      {
        player.sendMessage("§7[§a?§7] Você não tem permissao para fazer isso!");
        return true;
      }
      if (args.length == 0)
      {
        player.sendMessage("§7[§a?§7] Use /tp [player] para ir até um player!");
        player.sendMessage("§7[§a?§7] Use /s [player] para puxar um player até você!");
        return true;
      }
      if (args.length == 1)
      {
        Player target = Bukkit.getPlayerExact(args[0]);
        if ((target == null) || (!(target instanceof Player)))
        {
          player.sendMessage("§7[§a!§7] Jogador não encontrado!");
          return true;
        }
        target.teleport(player);
        player.sendMessage("§7[§a!§7] Você trouxe o jogador §a" + target.getName());
        Bukkit.getLogger().info(player.getName() + " Trouxe!" + target.getName());
  	    Bukkit.broadcast("§7[§a!§7] §a" + player.getName() + ChatColor.GRAY + " Se teleportou para §a" + target.getName(), "hg.admin");
        return true;
      }
      if (args.length > 1)
      {
        player.sendMessage("§7[§a?§7] Use /tp [player] para ir até um player!");
        player.sendMessage("§7[§a?§7] Use /s [player] para puxar um player até você!");
        return true;
      }
    }
    return false;
  }
}