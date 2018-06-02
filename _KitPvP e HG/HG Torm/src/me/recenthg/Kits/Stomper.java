package me.recenthg.Kits;

import java.util.List;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Manager.Listeners;
import me.recenthg.Utils.Estado;

public class Stomper implements Listener { 
	
  @EventHandler
  public void StomperFall(EntityDamageEvent event) {
    if ((event.getEntity() instanceof Player))
    {
      Player p = (Player)event.getEntity();
      if (Main.estados == Estado.ANDAMENTO)
    	  if ((Habilidade.getAbility(p).equalsIgnoreCase("stomper")))
      if ((event.getCause() == EntityDamageEvent.DamageCause.FALL))
      {
        List<Entity> entity = p.getNearbyEntities(8.0D, 5.0D, 8.0D);
        for (Entity en : entity) {
          if ((en instanceof Player))
          {
            Player stompados = (Player)en;
            if (stompados.isSneaking())
            {
              stompados.damage(4.0D);
              stompados.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
              p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
            } else {
              stompados.damage(p.getFallDistance() - 8);
              p.sendMessage("§8\u276e§4§l!§8\u276f §7Você esmagou §4" + stompados.getName());
              stompados.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
              p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
              if (stompados.isDead()) {
                Listeners.setStreaks(p);
              }
            }
          }
        }
        if (event.getDamage() > 4.0D) {
          event.setDamage(4.0D);
        }
      }
    }
  }
}
