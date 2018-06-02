package Net.Hunger.Comandos;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Net.Hunger.Main;

public class CMDSpawn implements Listener, CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
	if(!(sender instanceof Player)) {
	sender.sendMessage("§7[§a!§7] §bComandos apenas no servidor!");
	return true;
	}
	Player p = (Player)sender;
	if(cmd.getName().equalsIgnoreCase("spawn")) {
	if(Main.PreGame) {
    Bukkit.getServer().getWorld("world");
	p.getLocation();
    Random random = new Random();           
    Location teleportLocation = null;	            
    int x = random.nextInt(400) + 1;
    int y = 150;
    int z = random.nextInt(400) + 1;            
    boolean isOnLand = false;            
    while (isOnLand == false) {
    teleportLocation = new Location(p.getWorld(), x, y, z);	                    
    if (teleportLocation.getBlock().getType() != Material.AIR) {
    isOnLand = true;
    } else y--;    
    }
    p.teleport(new Location(p.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1, teleportLocation.getZ()));	
    } else {
	sender.sendMessage("§7[§a?§7] §7Você so pode se teleportar antes da partida iniciar!");
	return true;	
    }
	  }
	return false;
	}
}