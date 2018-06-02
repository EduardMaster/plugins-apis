/*    */ package br.nikao.kits;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import br.nikao.outros.KitAPI;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class Anchor implements org.bukkit.event.Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Kits(EntityDamageByEntityEvent e)
/*    */   {
/* 18 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
/* 19 */       final Player p = (Player)e.getEntity();
/* 20 */       Player k = (Player)e.getDamager();
/* 21 */       if (KitAPI.getkit(k) == "Anchor") {
/* 22 */         p.setVelocity(new Vector());
/* 23 */         p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 1.0F, 1.0F);
/* 24 */         k.playSound(p.getLocation(), Sound.ANVIL_BREAK, 1.0F, 1.0F);
/* 25 */         org.bukkit.Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*    */           public void run() {
/* 27 */             p.setVelocity(new Vector());
/*    */           }
/* 29 */         }, 1L);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void Matador(EntityDamageByEntityEvent e) {
/* 36 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
/* 37 */       final Player p = (Player)e.getEntity();
/* 38 */       if (KitAPI.getkit(p) == "Anchor") {
/* 39 */         p.setVelocity(new Vector());
/* 40 */         p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 1.0F, 1.0F);
/* 41 */         org.bukkit.Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*    */           public void run() {
/* 43 */             p.setVelocity(new Vector());
/*    */           }
/* 45 */         }, 1L);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Anchor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */