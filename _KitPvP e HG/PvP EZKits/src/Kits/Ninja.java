package Kits;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import Utils.KitAPI;
import Main.Main;

public class Ninja implements Listener{
	
	public static HashMap<String, Player> NinjaPlayer = new HashMap<>();
	public static HashMap<String, Integer> NinjaTime = new HashMap<>();
	
	@EventHandler
	public void Bater(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			final Player p = (Player)e.getDamager();
		    Player t = (Player )e.getEntity();
		    NinjaPlayer.put(p.getName(), t);
		    NinjaTime.put(p.getName(), 10);
		    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
				@Override
				public void run() {
					if (NinjaTime.get(p.getName()) <= 0) {
						if (KitAPI.getKit(p) == "Ninja" && !KitAPI.KitDelay.containsKey(p.getName())) {
							p.sendMessage("§7[§c!§7]§c§cVoce Perdeu seu Player" + NinjaPlayer.get(p.getName()).getDisplayName());
							
						}
						NinjaPlayer.remove(p.getName());
						
					}
					
				}
			} , 10 * 20);
		}
	}
	
	@EventHandler
	public void Agacha(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		if (p.isSneaking()) {
		if (KitAPI.getKit(p) == "Ninja") {
			if(!KitAPI.KitDelay.containsKey(p.getName())) {
				if (NinjaPlayer.containsKey(p.getName())) {
					Player t = NinjaPlayer.get(p.getName());
					if (p.getLocation().distance(t.getLocation()) <= 40) {
						p.teleport(t);
						p.sendMessage("§cNinjado");
						KitAPI.KitDelay.put(p.getName(), 10);
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
							
							@Override
							public void run() {
								if (KitAPI.KitDelay.containsKey(p.getName()) && KitAPI.KitDelay.get(p.getName()) <= 0 && KitAPI.getKit(p) == "Ninja") {
									p.sendMessage("§cSeu Ninja esta Pronto");
									KitAPI.KitDelay.remove(p.getName());
								}
								
							}
						}, 10 * 20);
					}else {
						p.sendMessage("§7[§c!§7]§cEsse Jogador esta Muito Longe");
					}
				}else {
					p.sendMessage("§7[§c!§7]§c§cVoce Não tem nenhum jogador marcado");
				}
			}else {
				p.sendMessage("§7[§c!§7]§c§cSeu Ninja esta Carregando");
			}
		}
	}
	}
}
