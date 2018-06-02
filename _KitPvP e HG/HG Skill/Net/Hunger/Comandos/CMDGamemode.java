package Net.Hunger.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CMDGamemode implements CommandExecutor, Listener{

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    if (!(sender instanceof Player)) {
	      sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
	      return true;
	    }
	    Player player = (Player)sender;
	    if (!player.hasPermission("HungerGames.c.gm")) {
	      player.sendMessage("§7[§a!§7] Você não possue permissão para isso!");
	      return true;
	    }
	    if (args.length == 0) {
	      sender.sendMessage("§7[§a!§7] Use /gm [gamemode] [player] ou /gm [gamemode]");
	      return true;
	    }
	    if (args.length == 1) {
	     if (args[0].equalsIgnoreCase("0")) {
	       player.setGameMode(GameMode.SURVIVAL);
	       player.sendMessage("§7[§a!§7] Seu gamemode foi atualizado para survival.");
      	  Bukkit.broadcast(player.getName() + ChatColor.GRAY + " Entrou no gamemode 0!", "hg.admin");
	      } else if (args[0].equalsIgnoreCase("1")) {
	        player.setGameMode(GameMode.CREATIVE);
	        player.sendMessage("§7[§a!§7] Seu gamemode foi atualizado para criativo.");
	      	Bukkit.broadcast("§7[§a!§7] §a" + player.getName() + ChatColor.GRAY + " Entrou no gamemode 1!", "hg.admin");
	      } else if (args[0].equalsIgnoreCase("2")) {
	        player.setGameMode(GameMode.ADVENTURE);
	        player.sendMessage("§7[§a!§7] Seu gamemode foi atualizado para adventure.");
	      	Bukkit.broadcast("§7[§a!§7] §a" + player.getName() + ChatColor.GRAY + " Entrou no gamemode 2!", "hg.admin");
	      }  else {
	        sender.sendMessage("§7[§a?§7] Esse gamemode não existe!");
	        return true;
	      }
	      return true;
	    }
	    if (args.length == 2) {
	      Player target = Bukkit.getPlayerExact(args[1]);
	      if ((target == null) || (!(target instanceof Player))) {
	        player.sendMessage("§7[§a?§7] Jogador não encontrado!");
	        return true;
	      } if (args[0].equalsIgnoreCase("0")) {
	        target.setGameMode(GameMode.SURVIVAL);
	        target.sendMessage("§7[§a!§7] " + "Você entrou no modo §asurvival.");
	        target.sendMessage("§7[§a!§7] §a" + target.getName() + " atualizou seu gamemode para survival.");
	      	Bukkit.broadcast("§7[§a!§7] §a" + player.getName() + ChatColor.GRAY + " Atualizou o gamemode de §a" + target.getName() + " para 0", "hg.admin");
	      } else if (args[0].equalsIgnoreCase("1")) {
	        target.setGameMode(GameMode.CREATIVE);
	        target.sendMessage("§7[§a!§7] " + "Você entrou no modo criativo.");
	        target.sendMessage("§7[§a!§7] §a " + target.getName() + "§7 atualizou seu gamemode para criativo.");
	      	Bukkit.broadcast("§7[§a!§7] §a" + player.getName() + "§7 Atualizou o gamemode de §a" + target.getName() + " para 1", "hg.admin");
	      } else if (args[0].equalsIgnoreCase("2")) {
	        target.setGameMode(GameMode.ADVENTURE);
	        target.sendMessage("§7[§a!§7] " + "Você entrou no modo adventure.");
	        target.sendMessage("§7[§a!§7] §a" + target.getName() + "§7 atualizou seu gamemode para adventure.");
	         Bukkit.broadcast("§7[§a!§7] §a" + player.getName() + "§7 Atualizou o gamemode de §a" + target.getName() + " para 2", "hg.admin");
	      } else {
	        sender.sendMessage("§7[§a?§7] Esse gamemode nao existe!");
	        return true;
	      }
	      return false;
	    }
	    if (args.length > 2) {
	      sender.sendMessage("§7[§a?§7] Use /gm [gamemode] [player] ou /gm [gamemode]");
	      return true;
	    }
	    return false;
	  }
}