package me.recenthg.Kits;

import java.util.Random;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Utils.Estado;

public class Snail implements Listener {

	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent e) {
		 if (Main.estados == Estado.INVENCIBILIDADE ||Main.estados == Estado.ANDAMENTO) {

			if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof LivingEntity))) {
				LivingEntity entity = (LivingEntity) e.getEntity();
				Player p = (Player) e.getDamager();
					if ((Habilidade.getAbility(p).equalsIgnoreCase("snail"))) {
						Random rand = new Random();
						int percent = rand.nextInt(100);
						if (percent <= 33) {
							entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 0));
							return;
						}
						return;
					}
					return;
				}
			
		}
	}
}