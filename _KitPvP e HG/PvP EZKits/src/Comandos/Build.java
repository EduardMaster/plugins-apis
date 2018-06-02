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

public class Build implements Listener,CommandExecutor{
	
	public static HashMap<String, BuildStats> Build = new HashMap<>();
	
	public enum BuildStats {
		ON, OFF
	}

	@Override
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (!(sender instanceof Player)) {
			sender.sendMessage("Para usar isso tem que ser um player");
			return true;
		}
		if (!(sender.hasPermission("ezkits.admin"))) {
			sender.sendMessage("§cVoce Não tem Permissão!");
			return true;
		}
		Player p = (Player)sender;
		if (args.length == 0) {
			p.sendMessage("§cUse §a/build <on ou off>");
			
		}
		if (args[0].equalsIgnoreCase("on")) {
			if (Build.get(p.getName()) == BuildStats.ON) {
				p.sendMessage("§aSeu Build ja Esta Ativado");
				return true;
			} else {
				p.sendMessage("§aVoce Ativou seu Build");
				Build.put(p.getName(), BuildStats.ON);
				return true;
			}
		} else if (args[0].equalsIgnoreCase("off")) {
			if (Build.get(p.getName()) == BuildStats.OFF) {
				p.sendMessage("§a Seu Modo Build ja estava desativado");
				return true;
			} else {
				p.sendMessage("§aVoce Desativou seu Build");
				Build.put(p.getName(), BuildStats.OFF);
				return true;
			}
		} else p.sendMessage("§cUse §a/build <on/off>");
		return false;
	}
	
	@EventHandler
	public void Entrou(PlayerJoinEvent e) {
		Build.put(e.getPlayer().getName(), BuildStats.OFF);
	}
	
	@EventHandler
	public void Quebrar(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (Build.get(p.getName()) == BuildStats.OFF){ p.sendMessage("§aAtive o Modo Build Para Construir"); {
			e.setCancelled(true);
		}
		}
	}
		@EventHandler
		public void Quebrar(BlockPlaceEvent e) {
			Player p = e.getPlayer();
			if (Build.get(p.getName()) == BuildStats.OFF){
				e.setCancelled(true);
			}	
		
  }
	
}
