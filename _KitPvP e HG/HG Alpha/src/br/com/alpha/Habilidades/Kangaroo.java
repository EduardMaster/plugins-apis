package br.com.alpha.Habilidades;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import br.com.alpha.MCAlpha;
import br.com.alpha.ENUMs.KitsEnum;
import br.com.alpha.gamemanagement.GameTime;

public class Kangaroo implements Listener{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	ArrayList<Player> kanga = new ArrayList();
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player jogador = event.getPlayer();
		if ((jogador.getItemInHand().getType() == Material.FIREWORK) && (MCAlpha.Status == GameTime.INVENCIBILIDADE || MCAlpha.Status == GameTime.INGAME) && (KitsEnum.getKit(jogador) == KitsEnum.KANGAROO)) {
			event.setCancelled(true);
			if ((event.getAction() == Action.LEFT_CLICK_AIR) || (event.getAction() == Action.LEFT_CLICK_BLOCK)
					|| (event.getAction() == Action.RIGHT_CLICK_BLOCK)
					|| (event.getAction() == Action.RIGHT_CLICK_AIR)) {
			}
			if (!this.kanga.contains(jogador)) {
				if (!jogador.isSneaking()) {
					jogador.setFallDistance(-3.0F);
					Vector vector = jogador.getEyeLocation().getDirection();
					vector.multiply(0.6F);
					vector.setY(1.0F);
					jogador.setVelocity(vector);
				} else {
					jogador.setFallDistance(-3.0F);
					Vector vector = jogador.getEyeLocation().getDirection();
					vector.multiply(1.35F);
					vector.setY(0.66D);
					jogador.setVelocity(vector);
				}
				this.kanga.add(jogador);
			}
		}
	}
	@EventHandler
	public void onMove(PlayerMoveEvent event){
		Player jogador = event.getPlayer();
		if (this.kanga.contains(jogador)) {
			Block b = jogador.getLocation().getBlock();
			if ((b.getType() != Material.AIR) || (b.getRelative(BlockFace.DOWN).getType() != Material.AIR))
				this.kanga.remove(jogador);
		}
	}
	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		if (event.getItemDrop().getItemStack().getType() == Material.FIREWORK)
			event.setCancelled(true);
	}
	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		Entity e = event.getEntity();
		if ((e instanceof Player)) {
			Player jogador = (Player) e;
			if (((event.getEntity() instanceof Player)) && (event.getCause() == EntityDamageEvent.DamageCause.FALL)
					&& (jogador.getInventory().contains(Material.FIREWORK)) && (event.getDamage() >= 12.0D))
				event.setDamage(12.0D);
		}
	}
}
