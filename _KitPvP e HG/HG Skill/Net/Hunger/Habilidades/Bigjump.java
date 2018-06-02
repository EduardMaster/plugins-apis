package Net.Hunger.Habilidades;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import Net.Hunger.Main;
import Net.Hunger.Manager.Habilidade;

public class Bigjump implements Listener {
	
  int cool = 60;
  public static ArrayList<String> JumpProtecao = new ArrayList<String>();
  public static HashMap<String, Long> jcool = new HashMap<String, Long>();
  
  @EventHandler
  public void onInteractBoots(PlayerInteractEvent e) {
   Player p = e.getPlayer();
    if((p.getItemInHand().getType() == Material.LEATHER_BOOTS) && (Habilidade.getAbility(p).equalsIgnoreCase("bigjump"))) {
    e.setCancelled(true);
   }
  }
  
  @EventHandler
  public void onDamageFall(EntityDamageEvent e) {
  if(!(e.getEntity() instanceof Player)) {
  return;
  }
  Player p = (Player)e.getEntity();
  if(e.getCause() == DamageCause.FALL) {
  if (JumpProtecao.contains(p.getName())) {
  e.setCancelled(true);
  return;
  }
  }
  }
  
  @SuppressWarnings("deprecation")
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onPlayerJumper(PlayerInteractEvent e) {
    final Player p = e.getPlayer();
    if (Habilidade.getAbility(p).equalsIgnoreCase("bigjump")) {
      if (p.getItemInHand().getType() == Material.LEATHER_BOOTS) {
        if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_AIR)) {
            if (jcool.containsKey(p.getName())) {
              long seconds = ((Long)jcool.get(p.getName())).longValue() / 1000L + cool - System.currentTimeMillis() / 1000L;
              e.setCancelled(true);
              p.updateInventory();
              p.sendMessage("§7[§a?§7] Você deve aguardar §a" + seconds + "§7 segundos para usar novamente!");
              return;
            }
            jcool.put(p.getName(), Long.valueOf(System.currentTimeMillis()));
            e.setCancelled(true);
            p.updateInventory();
            Vector v = p.getLocation().getDirection().multiply(0).setY(7.0D);
            p.setVelocity(v);
            JumpProtecao.add(p.getName());
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
              public void run() {
               jcool.remove(p.getName());
              }
            }, 1200L);
            if(JumpProtecao.contains(p.getName())) {
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
             public void run() {
             JumpProtecao.remove(p.getName()); 
             }
           },150L);
          }
          return;
        }
        return;
      }
      return;
    }
 }
}