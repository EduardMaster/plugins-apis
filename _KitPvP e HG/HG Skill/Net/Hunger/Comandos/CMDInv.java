package Net.Hunger.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CMDInv implements Listener, CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
	if(!(sender instanceof Player)) {
	sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
	return true;
	}
	Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("inv")) { 
    if (sender.hasPermission("HungerGames.c.Admin")) {
    sender.sendMessage("§7[§a!§7] " + "§aEscolha o nome do jogador!");
    if (args.length > 0) {
    Player player = Bukkit.getPlayer(args[0]);
    if (player == null) {
    sender.sendMessage("§7[§a!§7] " + "§aO jogador esta offline");
    return true;
    }
    sender.sendMessage("§7[§a!§7] " + "§7Voce abriu o inventario do jogador §a" + player.getName());
    Bukkit.broadcast("§7[§a!§7] " + p.getName() + "§7 esta vendo o inventario de §a" + player.getName(), "hg.admin");
    p.openInventory(player.getInventory());
    }
    } else {
    p.sendMessage("§7[§a?§7] " + "§7Voce nao tem permissao!");
    }
    return true;
   }
	return true;
  }
 }