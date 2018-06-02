package me.Pedro.Eventos;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.Pedro.Main;
import me.Pedro.INV.Caixa;
import me.Pedro.INV.Kits;
import me.Pedro.INV.Loja;
import me.Pedro.INV.MiniGamesInv;
import me.Pedro.INV.Warps;
import me.Pedro.Score.Habilidade;

public class Evento implements Listener {
	public Evento(Main main) {
	}

	@EventHandler
	public void join(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.getInventory().clear();
		p.teleport(p.getWorld().getSpawnLocation());
		API.GiveSpawn(p);
		Habilidade.removeAbility(p);
		KitAPI.remove(p);
	}
	@EventHandler 
	public void re(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		API.GiveSpawn(p);
		KitAPI.remove(p);
		Habilidade.removeAbility(p);
	}
	
	@EventHandler
	public void abrirClasses(PlayerInteractEvent evento) {
		Player jogador = evento.getPlayer();
		if (jogador.getItemInHand().getType().equals(Material.CHEST)) {
			if (jogador.getItemInHand().getItemMeta().hasDisplayName()) {
				if (jogador.getItemInHand().getItemMeta().getDisplayName()
						.equalsIgnoreCase("§c§lKITS §7- " + jogador.getName())) {
					evento.setCancelled(true);
					if (evento.getAction() == Action.RIGHT_CLICK_AIR) {
						Kits.guiKits1(jogador);
					}
				}
			}
		}
	}
	@EventHandler
	public void abrirClasse1s(PlayerInteractEvent evento) {
		Player jogador = evento.getPlayer();
		if (jogador.getItemInHand().getType().equals(Material.PAPER)) {
			if (jogador.getItemInHand().getItemMeta().hasDisplayName()) {
				if (jogador.getItemInHand().getItemMeta().getDisplayName()
						.equalsIgnoreCase("§c§lWARPS §7- " + jogador.getName())) {
					evento.setCancelled(true);
					if (evento.getAction() == Action.RIGHT_CLICK_AIR) {
						Warps.gui(jogador);
					}
				}
			}
		}
	}
	@EventHandler
	public void abrirClass1e1s(PlayerInteractEvent evento) {
		Player jogador = evento.getPlayer();
		if (jogador.getItemInHand().getType().equals(Material.STORAGE_MINECART)) {
			if (jogador.getItemInHand().getItemMeta().hasDisplayName()) {
				if (jogador.getItemInHand().getItemMeta().getDisplayName()
						.equalsIgnoreCase("§c§lCAIXA §7- " + jogador.getName())) {
					evento.setCancelled(true);
					if (evento.getAction() == Action.RIGHT_CLICK_AIR) {
						Caixa.guiKits(jogador);
					}
				}
			}
		}
	}
	@EventHandler
	public void abrirClass1e112s(PlayerInteractEvent evento) {
		Player jogador = evento.getPlayer();
		if (jogador.getItemInHand().getType().equals(Material.COMPASS)) {
			if (jogador.getItemInHand().getItemMeta().hasDisplayName()) {
				if (jogador.getItemInHand().getItemMeta().getDisplayName()
						.equalsIgnoreCase("§c§lMINIGAMES §7- " + jogador.getName())) {
					evento.setCancelled(true);
					if (evento.getAction() == Action.RIGHT_CLICK_AIR) {
						MiniGamesInv.guiKits(jogador);
					}
				}
			}
		}
	}
	@EventHandler
	public void abrirClass1e1112s(PlayerInteractEvent evento) {
		Player jogador = evento.getPlayer();
		if (jogador.getItemInHand().getType().equals(Material.EXP_BOTTLE)) {
			if (jogador.getItemInHand().getItemMeta().hasDisplayName()) {
				if (jogador.getItemInHand().getItemMeta().getDisplayName()
						.equalsIgnoreCase("§c§lLOJA §7- " + jogador.getName())) {
					evento.setCancelled(true);
					if (evento.getAction() == Action.RIGHT_CLICK_AIR) {
						Loja.GuiLojaKit(jogador);
					}
				}
			}
		}
	}
}
