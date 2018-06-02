package Comandos;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Build implements Listener, CommandExecutor {
	
	public static HashMap<String, BuildStats> Build = new HashMap<>();
	
	public enum BuildStats {
		ON, OFF
	}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§bPrecisa ser um Player para usar esse comando");
			return true;
		}
		if (!(sender.hasPermission("fly.build"))) {
			sender.sendMessage("§c§lFly§7§lTrue §a: §c§lVoce nao tem permissao!");
			return true;
		}
		Player p = (Player)sender;
		if (args.length == 0) {
			p.sendMessage("§c§lFly§7§lTrue §a: §a§lUse /build ON ou OFF!");
		}
		if (args.length == 1) {
    	}
    
		if (args[0].equalsIgnoreCase("on")) {
			if (Build.get(p.getName()) == BuildStats.ON) {
				p.sendMessage("§b§lO Modo Construir ja esta ativado!");
				return true;
			} else {
				p.sendMessage("§b§lModo Construir ativado!");
				Build.put(p.getName(), BuildStats.ON);
				return true;
			}
		} else if (args[0].equalsIgnoreCase("off")) {
			if (Build.get(p.getName()) == BuildStats.OFF) {
				p.sendMessage("§c§lO Modo Construir ja estava desligado!");
				return true;
			} else {
				p.sendMessage("§c§lFly§7§lTrue §a: §c§lO Modo Construir foi desativado!");
				Build.put(p.getName(), BuildStats.OFF);
				return true;
			}
		} else p.sendMessage("§c§lFly§7§lTrue §a: §a§lUse /build ON ou OFF!");
		return false;
  }
    
    @EventHandler
    public void Entrou(PlayerJoinEvent e) {
    	Build.put(e.getPlayer().getName(), BuildStats.OFF);
    }
    
    @EventHandler
    public void Quebrar(BlockBreakEvent e) {
    	Player p = e.getPlayer();
    	if (Build.get(p.getName()) == BuildStats.OFF) {
    	e.setCancelled(true);
      }
    }
        @EventHandler
        public void Quebrar(BlockPlaceEvent e) {
        	Player p = e.getPlayer();
        	if (Build.get(p.getName()) == BuildStats.OFF) {
        	e.setCancelled(true);
        }
      }
 }