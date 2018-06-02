package Pedrao.Habilidades;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import Pedrao.KitAPI;
import Pedrao.Main;

public class Thresh implements Listener {

	public Thresh(Main main) {
	}
	  public static HashMap<String, Long> cooldown = new HashMap<String, Long>();
	  public static HashMap<String, Snowball> tiros = new HashMap<String, Snowball>();
	  @EventHandler
	  public void disparar(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();
	    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
	      (p.getItemInHand().getType() == Material.GOLD_PICKAXE) && 
	      (KitAPI.Thresh.contains(p.getName())))
	    {
	      if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis()))
	      {
	        e.setCancelled(true);
	        p.updateInventory();
	        Snowball tiro = (Snowball)p.launchProjectile(Snowball.class);
	        Vector vec = p.getLocation().getDirection();
	        tiro.setVelocity(new Vector(
	          vec.getX() * 1.0D * 3.5D, 
	          vec.getY() * 1.0D * 4.0D, 
	          vec.getZ() * 1.0D * 3.5D));
	        tiros.put(p.getName(), tiro);
	        cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(15L)));
	        p.playSound(p.getLocation(), Sound.GLASS, 1.0F, 1.0F);
	        p.sendMessage(Main.prefix + "§aVocê lançou seu Thresh!");
	        return;
	      }
	      p.sendMessage(Main.cl);
	    }
	  }
	  
	  @SuppressWarnings("deprecation")
	@EventHandler
	  public void onEntityDamagerByEntity(EntityDamageByEntityEvent e)
	  {
	    Entity ent = e.getEntity();
	    Entity damager = e.getDamager();
	    if ((ent instanceof Player))
	    {
	      Player hit = (Player)ent;
	      if ((damager instanceof Snowball))
	      {
	        Snowball snowball = (Snowball)damager;
	        if ((snowball.getShooter() instanceof Player))
	        {
	          Player shooter = (Player)snowball.getShooter();
	          if (!KitAPI.Thresh.contains(shooter.getName())) {
	            return;
	          }
	          Location ploc = shooter.getLocation();
	          @SuppressWarnings("unused")
			Location hitloc = hit.getLocation();
	          hit.teleport(ploc);
	          hit.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
	          hit.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1));
	          hit.sendMessage(Main.prefix + " Alguem Usou o Kit Thresh Em Você!");
	        }
	      }
	    }
	  }
}
	  