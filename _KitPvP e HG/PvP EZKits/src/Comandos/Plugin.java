package Comandos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Plugin  implements Listener{
	
	@SuppressWarnings("rawtypes")
	@EventHandler
	public void onCommandPreProcess(PlayerCommandPreprocessEvent e) {
		String[] msg = e.getMessage().split(" ");
		@SuppressWarnings("unchecked")
		List<String> plugins = new ArrayList();
		plugins.add("pl");
		plugins.add("plugins");
		plugins.add("?");
		plugins.add("ver");
		    for (String Loop : plugins) {
		    	if (msg[0].equalsIgnoreCase("/" + Loop)) {
		    		
		    		e.getPlayer().sendMessage("§6§l=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		    		e.getPlayer().sendMessage("§5§lPlugin Criado por EzequiasSales");
		    		e.getPlayer().sendMessage("§6§l=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		    		e.setCancelled(true);
		    	}
		    }
		
	}

}
