/*    */ package nobody.kit;
/*    */ 
/*    */ import nobody.eventos.KitAPI;
import nobody.main.Main;

import org.bukkit.Bukkit;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.EventPriority;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class Anchor implements org.bukkit.event.Listener
/*    */ {
/*    */   @EventHandler(priority=EventPriority.MONITOR)
/*    */   public void onPlayerHitAnchor(EntityDamageByEntityEvent e)
/*    */   {
/* 20 */     if (!(e.getEntity() instanceof Player)) {
/* 21 */       return;
/*    */     }
/* 23 */     if (!(e.getDamager() instanceof Player)) {
/* 24 */       return;
/*    */     }
/* 26 */     final Player p = (Player)e.getEntity();
/* 27 */     Player a = (Player)e.getDamager();
/* 28 */     if (nobody.eventos.KitAPI.getkit(p) == "Anchor") {
/* 29 */       p.setVelocity(new Vector());
/* 30 */       p.playSound(p.getLocation(), Sound.ARROW_HIT, 4.0F, 4.0F);
/* 31 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*    */         public void run() {
/* 33 */           p.setVelocity(new Vector());
/*    */         }
/* 35 */       }, 1L); /*
/*    */     }
/* 37 */     if (KitAPI.getkit(p) == "Anchor") {
/* 38 */       a.playSound(a.getLocation(), Sound.ARROW_HIT, 4.0F, 4.0F);
/* 39 */       p.setVelocity(new Vector());
/* 40 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*    */         public void run() {
/* 42 */           p.setVelocity(new Vector());
/*    */         }
/* 44 */       }, 1L);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Anchor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */