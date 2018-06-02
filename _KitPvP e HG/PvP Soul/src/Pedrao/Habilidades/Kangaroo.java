package Pedrao.Habilidades;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import Pedrao.KitAPI;
import Pedrao.Main;

public class Kangaroo implements Listener {

	public Kangaroo(Main main) {
	}

	ArrayList<String> jumpa = new ArrayList<String>();
	private HashMap<String, Integer> inta = new HashMap<String, Integer>();

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Block b = p.getLocation().getBlock();
		if (p.getItemInHand().getType() == Material.FIREWORK && (KitAPI.Kangaroo.contains(p.getName()))) {
			e.setCancelled(true);
			if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)
					|| (e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_AIR)) {
				if ((b.getType() == Material.AIR) && (b.getRelative(BlockFace.DOWN).getType() == Material.AIR)) {
					this.jumpa.contains(p.getName());
				}
				if ((((Integer) this.inta.get(p.getName())).intValue() == 1) && (p.isSneaking())) {
					Vector v1 = p.getLocation().getDirection().multiply(1.5D).setY(0.45D);
					p.setVelocity(v1);
					this.inta.put(p.getName(), Integer.valueOf(0));
				}
				this.jumpa.contains(p.getName());
				if ((((Integer) this.inta.get(p.getName())).intValue() == 1) && (!p.isSneaking())) {
					Vector v2 = p.getLocation().getDirection().multiply(0.35D).setY(0.9D);
					p.setVelocity(v2);
					this.inta.put(p.getName(), Integer.valueOf(0));
				}
			}
		}
	}

	@EventHandler
	public void onTomarDano(EntityDamageEvent event) {
		Entity e = event.getEntity();
		if ((e instanceof Player)) {
			Player player = (Player) e;
			if (((event.getEntity() instanceof Player)) && (event.getCause() == EntityDamageEvent.DamageCause.FALL)
					&& (player.getInventory().contains(Material.FIREWORK)) && (event.getDamage() >= 7.0D)) {
				event.setDamage(7.0D);
			}
		}
	}

	@EventHandler
	public void fly(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		Block b = p.getLocation().getBlock();
		if (b.getRelative(BlockFace.DOWN).getType() == Material.AIR) {
			this.jumpa.add(p.getName());
		} else if ((b.getType() != Material.AIR) || (b.getRelative(BlockFace.DOWN).getType() != Material.AIR)) {
			this.inta.put(p.getName(), Integer.valueOf(1));
			this.jumpa.remove(p.getName());
		}
	}
}
