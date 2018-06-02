package me.Pedro.Eventos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.Pedro.Main;

public class Protecao implements Listener {
	
	public static ArrayList<Player> protecao = new ArrayList<>();
	

	
	public Protecao(Main main) {
	}

	@EventHandler
	public void entrar(PlayerJoinEvent e) {
		e.getPlayer().teleport(Bukkit.getWorld("world").getSpawnLocation());
		if(protecao.contains(e.getPlayer())) {
			protecao.remove(e.getPlayer());
			e.getPlayer().sendMessage(API.sev + "Voce recebeu a protecao do Spawn!");
		}
	}
		@EventHandler
		public void entrar1(PlayerRespawnEvent e) {
			e.getPlayer().teleport(Bukkit.getWorld("world").getSpawnLocation());
			if(protecao.contains(e.getPlayer())) {
				protecao.remove(e.getPlayer());
				e.getPlayer().sendMessage(API.sev + "Voce recebeu a protecao do Spawn!");
			}
	}
	
	@EventHandler
	public void dano(EntityDamageByEntityEvent e) {
		
		if (e.getDamager() instanceof Arrow){
			Arrow arrow = (Arrow) e.getDamager();
			 if (arrow.getShooter() instanceof Player){
				 if(arrow.getShooter().equals(e.getEntity())) {
	            		e.setCancelled(true);
	            	}
				 if(!protecao.contains(e.getEntity())) {
						e.setCancelled(true);
					}
			 }
		}
		Material material = Material.FISHING_ROD;
     	if(material == Material.FISHING_ROD) {
     		 if(!protecao.contains(e.getEntity())) {
					e.setCancelled(true);
				}
     		
     	}
     	if(e.getDamager() instanceof FishHook) {
			FishHook fish = (FishHook) e.getDamager();
			if(fish.getShooter().equals(e.getEntity())) {
				e.setCancelled(true);
			}
		}
		if(!(e.getEntity() instanceof Player)) return;
		if(!(e.getDamager() instanceof Player)) return;
		if(!protecao.contains(e.getEntity())) {
			e.setCancelled(true);
		}
		if(!protecao.contains(e.getDamager())) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void mexer(PlayerMoveEvent e) {
		if(protecao.contains(e.getPlayer())) return;
		Player p = e.getPlayer();
		if (p.getLocation().getBlockX() > Bukkit.getWorld("world").getSpawnLocation().getBlockX() + 10) {
			p.sendMessage(API.sev + "Voce perdeu a protecao do Spawn!");
			protecao.add(p);
		}
		if (p.getLocation().getBlockX() < -(10 - Bukkit.getWorld("world").getSpawnLocation().getBlockX())) {
			p.sendMessage(API.sev + "Voce perdeu a protecao do Spawn!");
			protecao.add(p);
		}
		if (p.getLocation().getBlockZ() > Bukkit.getWorld("world").getSpawnLocation().getBlockZ() + 10) {
			p.sendMessage(API.sev + "Voce perdeu a protecao do Spawn!");
			protecao.add(p);
		}
		if (p.getLocation().getBlockZ() < -(10 - Bukkit.getWorld("world").getSpawnLocation().getBlockZ())) {
			p.sendMessage(API.sev + "Voce perdeu a protecao do Spawn!");
			protecao.add(p);
		}
	}

}
