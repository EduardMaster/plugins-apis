package Net.Hunger.Habilidades;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Net.Hunger.Main;
import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Manager.Habilidade;

public class Reaper implements Listener {
	
  @EventHandler
  public void onEntityDamage(EntityDamageByEntityEvent e) {
  if (!(e.getDamager() instanceof Player)) {
  return;
  }
  if(!(e.getEntity() instanceof Player)) {
  return;
  }
  if(Main.Partida) {
  Player s = (Player)e.getEntity();
  Player p = (Player)e.getDamager();
  if ((p.getItemInHand().getType() == Material.WOOD_HOE) && ((Habilidade.getAbility(p).equalsIgnoreCase("reaper")))) {
   Random rand = new Random();
   int percent = rand.nextInt(100);
   if (percent <= 33) {
   s.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 120, 0));
   return;
   }
   return;
   }
   return;
   }
  }
 }