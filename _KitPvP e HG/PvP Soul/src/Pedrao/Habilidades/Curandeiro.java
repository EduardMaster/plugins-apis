package Pedrao.Habilidades;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Pedrao.KitAPI;
import Pedrao.Main;
import Pedrao.Effect.Raios;

public class Curandeiro
  implements Listener
{
  
	  @SuppressWarnings({ })
  
  public Curandeiro() {}
  
  public Curandeiro(Main main) {}
  
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
public static HashMap<String, Long> cooldown = new HashMap();
  @EventHandler
  public void interact(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      (KitAPI.Curandeiro.contains(p.getName())) && 
      (p.getItemInHand().getType() == Material.SULPHUR))
    {
      if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis()))
      {
        e.setCancelled(true);
        p.updateInventory();
        
        p.sendMessage(Main.prefix + " Curando");
        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 250, 10));
        p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 250, 5));
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 250, 225));
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 250, 225));
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 250, 10));
        p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
		Raios.coneEffect(p.getLocation().clone().add(0.0D, 0.1D, 0.0D));
        cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(80L)));
        return;
      }
      p.sendMessage(Main.cl);
    }
  }
}
