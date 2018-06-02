package br.com.alpha.Habilidades;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import br.com.alpha.MCAlpha;
import br.com.alpha.ENUMs.KitsEnum;
import br.com.alpha.gamemanagement.GameTime;


public class Thor implements Listener {
	
	public static ArrayList<String>cooldownp =new ArrayList<>();
	
	@EventHandler
	void thor(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (KitsEnum.getKit(p)==KitsEnum.THOR&&MCAlpha.Status==GameTime.INGAME) {

			if (!cooldownp.contains(p.getName())) {
				cooldownp.add(p.getName());
				@SuppressWarnings("deprecation")
				org.bukkit.Location location = p.getTargetBlock(null, 20).getLocation();
				p.getWorld().strikeLightning(location);
			}else {
				p.sendMessage("§cVocê está em cooldown.");
			}
		}
	}

}
