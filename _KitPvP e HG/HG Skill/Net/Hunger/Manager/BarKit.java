package Net.Hunger.Manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import Net.Hunger.Main;

public class BarKit implements Listener {
  
  @EventHandler
  public void onPlayerKit(EntityDamageByEntityEvent e) {
   if (!(e.getEntity() instanceof Player)) {
   return;
   }
   if (!(e.getDamager() instanceof Player)) {
   return;
   }
   if(Main.Partida) {
   final Player t = (Player)e.getEntity();
   final Player p = (Player)e.getDamager();
   final String KitName = Habilidade.NomeDoKit(Habilidade.getAbility(t));
   BarAPI.setName(p, t.getName() + " - Kit " + KitName, 400L);
   Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
   public void run() {
   BarAPI.removeBar(p);
   }
   }, 80L);
   return;
   }
  }
}