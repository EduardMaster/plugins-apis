package Net.Hunger.Habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Net.Hunger.Main;
import Net.Hunger.Comandos.CMDAdmin;
import Net.Hunger.Manager.Habilidade;

public class Firer implements Listener {

	ArrayList<String> Pegos = new ArrayList<String>();
	ArrayList<String> Cooldown = new ArrayList<String>();
	
	@EventHandler
	public void onShift(PlayerToggleSneakEvent event) {
	final Player p = event.getPlayer();
	if((Main.Partida)) {
	if((Habilidade.getAbility(p).equalsIgnoreCase("firer"))) {
    if(Cooldown.contains(p.getName())) {
    p.sendMessage("§7[§a?§7] Você esta no cooldown!");
    } else {
    for (final Entity e : p.getNearbyEntities(10.0D, 10.0D, 10.0D)) {
     if ((e instanceof Player)) {
      if(!Main.Watch.contains(((Player) e).getName()) && (!CMDAdmin.admin.contains(p.getName()))) {
     e.setFireTicks(100);
      Cooldown.add(p.getName());
      Pegos.add(((Player) e).getPlayer().getName());
      ((Player) e).getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 170, 2));
      ((Player) e).getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 170, 2));
      p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 170, 2));
      p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 170, 2));
      ((Player) e).getPlayer().sendMessage("§7[§a!§7] Você foi atingido por 1 firer");
      p.sendMessage("§7[§a!§7] Todos ao seu redor foram atingidos!");
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
      public void run() {
      Cooldown.remove(p.getName());
         }
        },750L);
       }
      }
     }
    }
   }
  } 
 }
}