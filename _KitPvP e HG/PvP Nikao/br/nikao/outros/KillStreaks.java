/*    */ package br.nikao.outros;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import java.util.HashMap;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class KillStreaks
/*    */   implements Listener
/*    */ {
/* 15 */   public static HashMap<String, Integer> KillStreak = new HashMap();
/*    */   
/*    */   public static void addKillStreak(Player p) {
/* 18 */     int value = ((Integer)KillStreak.get(p.getName())).intValue();
/* 19 */     KillStreak.put(p.getName(), Integer.valueOf(value + 1));
/*    */   }
/*    */   
/*    */   public static void setKillStreak(Player p) {
/* 23 */     KillStreak.put(p.getName(), Integer.valueOf(0));
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void Outros(PlayerDeathEvent e) {
/* 28 */     if ((e.getEntity().getKiller() instanceof Player)) {
/* 29 */       final Player p = e.getEntity().getKiller();
/* 30 */       Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*    */       {
/*    */         public void run()
/*    */         {
/* 34 */           switch (((Integer)KillStreaks.KillStreak.get(p.getName())).intValue()) {
/*    */           case 5: case 10: 
/*    */           case 15: 
/*    */           case 20: 
/*    */           case 25: 
/*    */           case 30: 
/*    */           case 35: 
/*    */           case 40: 
/*    */           case 45: 
/*    */           case 50: 
/*    */           case 55: 
/*    */           case 60: 
/*    */           case 65: 
/*    */           case 70: 
/*    */           case 75: 
/*    */           case 80: 
/*    */           case 85: 
/*    */           case 90: 
/*    */           case 95: 
/*    */           case 100: 
/*    */           case 125: 
/*    */           case 150: 
/*    */           case 200: 
/*    */             Player[] arrayOfPlayer;
/* 58 */             int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player s = arrayOfPlayer[i];
/* 59 */               s.sendMessage("§c" + p.getName() + " §7Pegou um §eKS §7de §c§o" + KillStreaks.KillStreak.get(p.getName()));
/*    */             }
/*    */           }
/*    */         }
/* 63 */       }, 1L);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\KillStreaks.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */