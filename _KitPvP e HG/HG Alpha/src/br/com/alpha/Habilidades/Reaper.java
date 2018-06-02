package br.com.alpha.Habilidades;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import br.com.alpha.MCAlpha;
import br.com.alpha.ENUMs.KitsEnum;
import br.com.alpha.gamemanagement.GameTime;

public class Reaper implements Listener {
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent e) {
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (MCAlpha.Status==GameTime.INGAME) {
			Player s = (Player) e.getEntity();
			Player p = (Player) e.getDamager();
			if ((p.getItemInHand().getType() == Material.WOOD_HOE) && (KitsEnum.getKit(p)==KitsEnum.REAPER)) {
				Random rand = new Random();
				int percent = rand.nextInt(100);
				if (percent <= 33) {
					s.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 120, 0));
					return;
				}
				return;
			}
			return;
		}
	}
}