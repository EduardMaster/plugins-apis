package br.com.alpha.Habilidades;

import java.util.List;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import br.com.alpha.MCAlpha;
import br.com.alpha.ENUMs.KitsEnum;
import br.com.alpha.gamemanagement.GameTime;



public class Tower implements Listener {
	public boolean danonaterra = true;

	@EventHandler
	public void StomperFall(EntityDamageEvent event) {
		if ((event.getEntity() instanceof Player)) {
			Player p = (Player) event.getEntity();
			if ((event.getCause() == EntityDamageEvent.DamageCause.FALL) && (MCAlpha.Status==GameTime.INGAME)
					&& (KitsEnum.getKit(p)==KitsEnum.TOWER)) {
				List<Entity> entity = p.getNearbyEntities(8.0D, 5.0D, 8.0D);
				for (Entity en : entity) {
					if ((en instanceof Player)) {
						Player stompados = (Player) en;
						if (stompados.isSneaking()) {
							stompados.damage(4.0D);
							stompados.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
							p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
						} else {
							stompados.damage(p.getFallDistance() - 8.0F);

							stompados.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
							p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
						}
					}
				}
				if (event.getDamage() > 4.0D) {
					event.setDamage(4.0D);
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDamage(BlockDamageEvent event) {
		Player p = event.getPlayer();
		if ((KitsEnum.getKit(p)==KitsEnum.TOWER) && (event.getBlock().getType() == Material.DIRT)) {
			event.getBlock().getLocation().distance(p.getWorld().getSpawnLocation());
			boolean drop = true;
			if (((CraftPlayer) p).getHealth() < 20.0D) {
				double hp = ((CraftPlayer) p).getHealth() + 1.0D;
				if (hp > 20.0D) {
					hp = 20.0D;
				}
				p.setHealth((int) hp);
				drop = false;
			} else if (p.getFoodLevel() < 20) {
				p.setFoodLevel(p.getFoodLevel() + 1);
				drop = false;
			} else {
				p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 30, 1), false);
			}
			event.getBlock().getWorld().playEffect(event.getBlock().getLocation(), Effect.STEP_SOUND,
					Material.DIRT.getId());
			event.getBlock().setType(Material.AIR);
			if (drop) {
				event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation().add(0.5D, 0.0D, 0.5D),
						new ItemStack(Material.DIRT));
			}
		}
	}

	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		if ((this.danonaterra) && (event.getCause() == EntityDamageEvent.DamageCause.FALL)
				&& ((event.getEntity() instanceof Player))) {
			Player p = (Player) event.getEntity();
			if (KitsEnum.getKit(p)==KitsEnum.TOWER) {
				Location loc = event.getEntity().getLocation();
				boolean dirt = false;
				for (float x = -0.35F; (x <= 0.35F) && (!dirt); x += 0.35F) {
					for (float z = -0.35F; (z <= 0.35F) && (!dirt); z += 0.35F) {
						Block b = loc.clone().add(x, -1.0D, z).getBlock();
						if (b.getType() == Material.DIRT) {
							dirt = true;
						}
					}
				}
				if (dirt) {
					event.setCancelled(true);
				}
			}
		}
	}
}
