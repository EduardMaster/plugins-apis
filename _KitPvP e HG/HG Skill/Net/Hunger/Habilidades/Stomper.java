package Net.Hunger.Habilidades;

import java.util.List;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import Net.Hunger.Main;
import Net.Hunger.Comandos.CMDListener;
import Net.Hunger.Manager.Habilidade;

public class Stomper implements Listener { 
	
  @EventHandler
  public void StomperFall(EntityDamageEvent event) {
    if ((event.getEntity() instanceof Player))
    {
      Player p = (Player)event.getEntity();
      if ((event.getCause() == EntityDamageEvent.DamageCause.FALL) && (Main.Partida) && (Habilidade.getAbility(p).equalsIgnoreCase("stomper")))
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
              p.sendMessage("§7[§a!§7] Você esmagou §a" + stompados.getName());
              stompados.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
              p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
              if (stompados.isDead()) {
                CMDListener.setStreaks(p);
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
