package br.com.alpha.InGame.Listeners.Kits.Managers;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

public class KitManager {

	public static HashMap<UUID,String> playerkit = new HashMap<>();
	
	
	public static String getPlayerKit(Player p) {
		 if (!playerkit.containsKey(p.getUniqueId())) { return "None"; }
		return playerkit.get(p.getUniqueId());
	}
	public static void setPlayerKit(Player p,String kit) {
		if (playerkit.containsKey(p.getUniqueId())) {
			playerkit.remove(p.getUniqueId());
		}
		playerkit.put(p.getUniqueId(), kit);
	}
	// n é essee, é por enum.
}
