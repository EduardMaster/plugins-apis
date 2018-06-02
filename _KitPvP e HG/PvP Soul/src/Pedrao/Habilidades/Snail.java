package Pedrao.Habilidades;

	import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
	import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Pedrao.KitAPI;
	import Pedrao.Main;

	public class Snail implements Listener {

		public Snail(Main main) {
		}

		  @EventHandler
		  public void onSnaiAl(EntityDamageByEntityEvent e)
		  {
		    if (!(e.getEntity() instanceof Player)) {
		      return;
		    }
		    if (!(e.getDamager() instanceof Player)) {
		      return;
		    }
		    Player p = (Player)e.getEntity();
		    Player d = (Player)e.getDamager();
		    if (!KitAPI.Viper.contains(d.getName())) {
		      return;
		    }
		    if ((Math.random() > 0.4D) && (Math.random() > 0.1D)) {
		      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 80, 1));
		    }
		  }
	}