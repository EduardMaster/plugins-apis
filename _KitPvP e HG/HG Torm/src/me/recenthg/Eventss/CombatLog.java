package me.recenthg.Eventss;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.recenthg.Main;
import me.recenthg.CMDS.Admin;
import me.recenthg.Manager.Habilidade;

public class CombatLog implements Listener {
	
	public static HashMap<String, Integer> Combate = new HashMap<>();
	public static ArrayList<String> MorreuCombat = new ArrayList<>();
	
	public static boolean addCombate(final Player p) {
		if (p.isOnline()) {
			Combate.put(p.getName(), 13);
			MorreuCombat.add(p.getName());
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				
				@Override
				public void run() {
					if (Combate.containsKey(p.getName())) {
						Combate.remove(p.getName());
						MorreuCombat.remove(p.getName());
					}
					
				}
			}, 13*20);
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void Bater(EntityDamageByEntityEvent e) {
		if (e.isCancelled() || e.getDamage() == 0)return;
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (Admin.admin.contains(p.getName())) {
				if (e.getDamager() instanceof Player) {
					Player t = (Player)e.getDamager();
					if (Combate.containsKey(t.getName())) {
						addCombate(t);
					} else {
						addCombate(t);
					}
					if (Combate.containsKey(p.getName())) {
						addCombate(p);
					} else {
						addCombate(p);
					}
				}
			} else {
				if (e.getDamager() instanceof Projectile) {
					Entity s = e.getDamager();
					s = (Entity)((Projectile)s).getShooter();
					if (s instanceof Player) {
						Player p1 = (Player) e.getEntity();
						Player t = (Player)s;
						if (Combate.containsKey(t.getName())) {
							addCombate(t);
						} else {
							addCombate(t);
						}
						if (Combate.containsKey(p1.getName())) {
							addCombate(p1);
						} else {
							addCombate(p1);
						}
					}
				}
			}
		}
	}
	
	@EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
	public void sair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (!p.isDead()) {
			if (Combate.containsKey(p.getName())) {
				p.damage(1000.0D);
				Combate.remove(p.getName());
				Bukkit.broadcastMessage("§7" + p.getDisplayName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu queimado!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getDisplayName() + " Saiu do servidor!");
			}
		}
	}

}
