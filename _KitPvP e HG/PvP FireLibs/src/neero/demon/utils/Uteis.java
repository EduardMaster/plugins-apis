/*    */ package neero.demon.utils;
/*    */ 
/*    */ /*    */ import java.util.HashMap;

import neero.demon.Main;

/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ 
/*    */ public class Uteis
/*    */ {
/* 12 */   public static HashMap<Player, Long> cooldown = new HashMap();
/*    */   
/*    */   public static void addCooldown(Player p, int seconds)
/*    */   {
/* 16 */     long cooldownLength = System.currentTimeMillis() + seconds * 1000;
/*    */     
/* 18 */     cooldown.remove(p);
/* 19 */     cooldown.put(p, Long.valueOf(cooldownLength));
/* 20 */     Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), 
/* 21 */       new Runnable() {
/*    */         public void run() {
/* 23 */           Uteis.cooldown.remove(this);
/*    */         }
/*    */         
/* 26 */       }, seconds * 20);
/*    */   }
/*    */   
/*    */   public static long getCooldown(Player p) {
/* 30 */     long cooldownLength = ((Long)cooldown.get(p)).longValue();
/* 31 */     long left = (cooldownLength - System.currentTimeMillis()) / 1000L;
/* 32 */     return 
/* 33 */       left;
/*    */   }
/*    */   
/*    */   public static boolean hasCooldown(Player p) {
/* 37 */     return cooldown.containsKey(p);
/*    */   }
/*    */   
/*    */   public static void removeCooldown(Player p) {
/* 41 */     cooldown.remove(p);
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\managers\Uteis.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */