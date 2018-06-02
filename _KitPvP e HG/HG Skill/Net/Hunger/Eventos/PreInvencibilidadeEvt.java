package Net.Hunger.Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import Net.Hunger.Main;

public class PreInvencibilidadeEvt implements Listener {
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
	if(Main.PreInvencibilidade) {
	e.setCancelled(false);
	}
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
	if(Main.PreInvencibilidade) {
	e.setCancelled(false);
	}
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
	if(Main.PreInvencibilidade) {
	e.setCancelled(false);
	}
	}
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent e) {
	if(Main.PreInvencibilidade) {
	e.setCancelled(false);
	}
	}
	
	@EventHandler
	public void DamagePlayers(EntityDamageByEntityEvent e) {
	if(!(e.getEntity() instanceof Player)) {
	return;
	}
	if(!(e.getDamager() instanceof Player)) {
	return;
	}
	if(Main.PreInvencibilidade) {
	e.setCancelled(true);
	return;
	}
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
    if(!(e.getEntity() instanceof Player)) {
    return;
    }
    if(Main.PreInvencibilidade) {
    e.setCancelled(true);
    return;
    }
	}
	
	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
	if(Main.PreInvencibilidade) {
	e.setCancelled(true);
	}
  }
}