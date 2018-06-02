/*    */ package nobody.kit;
/*    */ 
/*    */ import java.util.Random;

import nobody.eventos.KitAPI;

/*    */ import org.bukkit.entity.LivingEntity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ 
/*    */ public class Ebola
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onEntityDamage(EntityDamageByEntityEvent e)
/*    */   {
/* 20 */     if (((e.getDamager() instanceof Player)) && 
/* 21 */       ((e.getEntity() instanceof LivingEntity))) {
/* 22 */       LivingEntity entity = (LivingEntity)e.getEntity();
/* 23 */       Player p = (Player)e.getDamager();
/* 24 */       if (KitAPI.getkit(p) == "Ebola") {
/* 25 */         Random rand = new Random();
/* 26 */         int percent = rand.nextInt(100);
/* 27 */         if (percent <= 9) {
/* 28 */           entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0));
/* 29 */           entity.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 0));
/* 30 */           entity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0));
/* 31 */           p.sendMessage("§7[§6§l!§7] §bVocê infectou um jogador.");
/* 32 */           return;
/*    */         }
/* 34 */         return;
/*    */       }
/* 36 */       return;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Ebola.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */