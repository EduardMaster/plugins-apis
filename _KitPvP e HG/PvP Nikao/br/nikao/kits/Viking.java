/*    */ package br.nikao.kits;
/*    */ 
/*    */ import br.nikao.outros.KitAPI;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ 
/*    */ public class Viking implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Kits(EntityDamageByEntityEvent e)
/*    */   {
/* 14 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
/* 15 */       Player t = (Player)e.getDamager();
/* 16 */       if (KitAPI.getkit(t) == "Viking") {
/* 17 */         e.setDamage(e.getDamage() + 2.5D);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Viking.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */