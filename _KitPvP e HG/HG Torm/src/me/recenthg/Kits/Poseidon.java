package me.recenthg.Kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Utils.Estado;


public class Poseidon implements Listener {
	
	  @EventHandler
	  public void onPlayerMove1(PlayerMoveEvent e) {
	    Player p = e.getPlayer();
	    if(Main.estados == Estado.ANDAMENTO) {
	    Material m = e.getPlayer().getLocation().getBlock().getType();
	    if((Habilidade.getAbility(p).equalsIgnoreCase("poseidon"))) {
	    if ((m == Material.STATIONARY_WATER) || (m == Material.WATER)) { 
	    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 40, 1)); 
	    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 1)); 
	  }  
	  }
	  }
  }
}