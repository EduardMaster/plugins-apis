/*    */ package br.nikao.outros;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Effect;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.entity.Item;
/*    */ import org.bukkit.event.entity.ItemSpawnEvent;
/*    */ import org.bukkit.event.player.PlayerPickupItemEvent;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class Drop implements org.bukkit.event.Listener
/*    */ {
/*    */   @org.bukkit.event.EventHandler
/*    */   public void onItemDrop(final ItemSpawnEvent e)
/*    */   {
/* 19 */     Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*    */     {
/*    */       public void run()
/*    */       {
/* 23 */         Vector vector = e.getLocation().getDirection();
/* 24 */         vector.multiply(0.0F);
/* 25 */         vector.setY(0.6F);
/* 26 */         e.getEntity().setVelocity(vector);
/*    */       }
/* 28 */     }, 20L);
/* 29 */     Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*    */     {
/*    */       public void run() {
/* 32 */         e.getEntity().remove();
/* 33 */         e.getLocation().getWorld().playEffect(e.getLocation(), Effect.ENDER_SIGNAL, 200, 200);
/* 34 */         e.getLocation().getWorld().playEffect(e.getLocation(), Effect.SMOKE, 200, 200);
/* 35 */         e.getLocation().getWorld().playEffect(e.getLocation(), Effect.FLAME, 200, 200);
/*    */       }
/* 37 */     }, 60L);
/*    */     
/* 39 */     Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*    */     {
/*    */       public void run()
/*    */       {
/* 43 */         e.getEntity().remove();
/*    */       }
/* 45 */     }, 65L);
/*    */   }
/*    */   
/*    */   @org.bukkit.event.EventHandler
/*    */   public void pegaritem(PlayerPickupItemEvent e) {
/* 50 */     e.setCancelled(true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\Drop.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */