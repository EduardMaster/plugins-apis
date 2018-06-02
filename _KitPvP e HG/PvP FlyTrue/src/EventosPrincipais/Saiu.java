package EventosPrincipais;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import Utils.KitAPI;

public class Saiu implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void Sair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(null);
		for (Player s: Bukkit.getOnlinePlayers()) {
			s.sendMessage("§7§c-§7 §c" + p.getName());
	 }
		KitAPI.RemoveKit(p);
   }
 }