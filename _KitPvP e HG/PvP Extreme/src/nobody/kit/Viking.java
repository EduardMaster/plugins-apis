/*    */ package nobody.kit;
/*    */ 
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ 
/*    */ public class Viking implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Bater(EntityDamageByEntityEvent e)
/*    */   {
/* 14 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
/* 15 */       Player t = (Player)e.getDamager();
/* 16 */       if (nobody.eventos.KitAPI.getkit(t) == "Viking") {
/* 17 */         e.setDamage(e.getDamage() + 3.5D);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Viking.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */