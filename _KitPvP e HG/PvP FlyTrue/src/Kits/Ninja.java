package Kits;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import Main.Main;
import Utils.KitAPI;

public class Ninja  implements Listener {
	
	public static HashMap<String, Player> NinjaPlayer = new HashMap<>();
	public static HashMap<String, Integer> NinjaTime = new HashMap<>();
	
	@EventHandler
	public void Bater(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			final Player p = (Player)e.getDamager();
			Player t = (Player)e.getEntity();
			if (KitAPI.getKit(p) == "Ninja") {
				NinjaPlayer.put(p.getName(), t);
				NinjaTime.put(p.getName(), 10);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable() {
					public void run() {
						if (NinjaTime.get(p.getName()) <= 0) {
							if (KitAPI.getKit(p) == "Ninja" && KitAPI.KitDelay.containsKey(p.getName())) {
								p.sendMessage("§cVoce perdeu seu player §6" + NinjaPlayer.get(p.getName()).getDisplayName() + " §cNo Ninja");
					
				}
							NinjaPlayer.remove(p.getName());
						}
					}
				}, 10 * 20);
				}
			}
		}
    @EventHandler
    public void Agachar(PlayerToggleSneakEvent e) {
    	Player p = e.getPlayer();
    	if (p.isSneaking()) {
    	if (KitAPI.getKit(p) == "Ninja") {
    		if (!KitAPI.KitDelay.containsKey(p.getName())) {
    			if (NinjaPlayer.containsKey(p.getName())) {
    				Player t = NinjaPlayer.get(p.getName());
    				if (p.getLocation().distance(t.getLocation()) <= 35) {
    					p.teleport(t);
    					p.sendMessage("§bVoce usou seu Kit!");
    					KitAPI.KitDelay.put(p.getName(), 10);
    					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable() {
    						@Override
							public void run() {
								if (KitAPI.KitDelay.containsKey(p.getName()) && KitAPI.KitDelay.get(p.getName()) <= 0 && KitAPI.getKit(p) == "Ninja") {
									p.sendMessage("§cKit Ninja Pronto");
									KitAPI.KitDelay.remove(p.getName());
								}
							}
						}, 10 * 20);
    				} else {
    					p.sendMessage("§cPlayer esta muito distante");
    					return;
    				}
    			} else {
    				p.sendMessage("§cVoce nao tem nenhum jogador no seu ninja");
    				return;
    			}
    		} else {
    			p.sendMessage("§cKit Em Cooldown");
    			return;
    		}
    	}
    }
    }
   }