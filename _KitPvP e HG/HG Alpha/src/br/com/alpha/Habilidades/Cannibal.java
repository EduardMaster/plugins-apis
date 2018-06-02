package br.com.alpha.Habilidades;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import br.com.alpha.MCAlpha;
import br.com.alpha.ENUMs.KitsEnum;
import br.com.alpha.gamemanagement.GameTime;

public class Cannibal implements Listener {

	@EventHandler
	public void SnailKit(EntityDamageByEntityEvent e) {
		if ((e.getEntity() instanceof Player)) {

			if ((e.getDamager() instanceof Player)) {
				Player pAtacado = (Player) e.getEntity();
				Player pAtacou = (Player) e.getDamager();

				if (KitsEnum.getKit(pAtacou) == KitsEnum.CANNIBAL) {
					if (MCAlpha.Status == GameTime.INGAME) {
						int percent = new Random().nextInt(100);
						if (percent <= 30) {
							pAtacado.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 60, 1));
						}
					} else {
						e.setCancelled(true);
					}
				}
			}
		}
	}
}

