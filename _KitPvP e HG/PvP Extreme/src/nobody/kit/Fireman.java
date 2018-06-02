/*    */ package nobody.kit;
/*    */ 
/*    */ import nobody.eventos.KitAPI;

import org.bukkit.entity.LivingEntity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ 
/*    */ public class Fireman implements org.bukkit.event.Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void damage(EntityDamageEvent e)
/*    */   {
/* 17 */     if ((e.getEntity() instanceof Player)) {
/* 18 */       Player p = (Player)e.getEntity();
/* 19 */       if ((KitAPI.getkit(p) == "Fireman") && (
/* 20 */         (e.getCause() == EntityDamageEvent.DamageCause.LAVA) || 
/* 21 */         (e.getCause() == EntityDamageEvent.DamageCause.FIRE) || 
/* 22 */         (e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK)))
/* 23 */         e.setCancelled(true);
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void Fogo(EntityDamageByEntityEvent e) {
/* 29 */     if ((e.getDamager() instanceof Player))
/*    */     {
/* 31 */       Player p = (Player)e.getDamager();
/* 32 */       if ((KitAPI.getkit(p) == "Fireman") && 
/* 33 */         (p.getInventory().getItemInHand() != null) && 
/* 34 */         (p.getInventory().getItemInHand().getType() == org.bukkit.Material.WOOD_SWORD) && 
/* 35 */         ((e.getEntity() instanceof LivingEntity))) {
/* 36 */         LivingEntity en = (LivingEntity)e.getEntity();
/* 37 */         if (en.isDead()) {
/* 38 */           return;
/*    */         }
/* 40 */         en.setFireTicks(100);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Fireman.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */