package Net.Hunger.Eventos;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.PlayerInventory;

import Net.Hunger.Main;
import Net.Hunger.Comandos.CMDAdmin;

public class PreAndamento implements Listener {
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
	if(Main.Partida) {
	e.setCancelled(false);
	}
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
	if(Main.Partida) {
	e.setCancelled(false);
	}
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
	if(Main.Partida) {
	e.setCancelled(false);
	}
	}
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent e) {
	if(Main.Partida) {
	e.setCancelled(false);
	}
	}
}