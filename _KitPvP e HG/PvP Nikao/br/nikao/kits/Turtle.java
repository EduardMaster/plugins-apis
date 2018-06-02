/*    */ package br.nikao.kits;
/*    */ 
/*    */ import br.nikao.outros.KitAPI;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ 
/*    */ public class Turtle implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void LevouDano(EntityDamageEvent e)
/*    */   {
/* 15 */     if ((e.getEntity() instanceof Player)) {
/* 16 */       Player p = (Player)e.getEntity();
/* 17 */       if ((KitAPI.getkit(p) == "Turtle") && (p.isSneaking())) {
/* 18 */         e.setDamage(2.5D);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void DeuDan(EntityDamageByEntityEvent e)
/*    */   {
/* 26 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
/* 27 */       Player p = (Player)e.getDamager();
/* 28 */       if ((KitAPI.getkit(p) == "Turtle") && (p.isSneaking())) {
/* 29 */         e.setDamage(1);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Turtle.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */