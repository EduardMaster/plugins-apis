package Pedrao.Habilidades;

	import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Pedrao.KitAPI;
import Pedrao.Main;
import Pedrao.Effect.Raios;

	public class WaterBender implements Listener {

		public WaterBender(Main main) {
		}

		public static ArrayList<String> wateratack = new ArrayList<String>();
		public static ArrayList<String> cooldown = new ArrayList<String>();
		
		@SuppressWarnings("deprecation")
		@EventHandler
		public void PlayerInteractEvt(PlayerInteractEntityEvent e) {
			final Player p = e.getPlayer();
			final Player ent = (Player)e.getRightClicked();
			if (cooldown.contains(p.getName())) {
			  p.sendMessage(Main.cl);
				return;
				
			}
			if (KitAPI.WaterBender.contains(p.getName())) {
			if (p.getItemInHand().getType() == Material.INK_SACK) {
				wateratack.add(ent.getName());
				Raios.kitaguala(ent.getLocation());
				cooldown.add(p.getName());
				ent.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 50, 200));
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.instance, new Runnable() {
					
					@Override
					public void run() {
						wateratack.remove(ent.getName());
					}
				}, 20 * 2);
				
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
			    {
			      public void run()
			      {
			        cooldown.remove(p.getName());
			        p.sendMessage(Main.prefix + " Você já pode utilizar seu kit");
			      }
			    }, 800L);
			  }
				
			  }
			
			}
		
		@EventHandler
		public void PlayerMov(PlayerMoveEvent e) {
			Player p = e.getPlayer();
			if (wateratack.contains(p.getName())) {
				p.teleport(p);
			}
		}
	}