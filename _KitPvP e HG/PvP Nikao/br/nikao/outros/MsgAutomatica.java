/*    */ package br.nikao.outros;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class MsgAutomatica
/*    */ {
/*    */   public MsgAutomatica(org.bukkit.plugin.Plugin plugin)
/*    */   {
/* 14 */     Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
/*    */       public void run() { Player[] arrayOfPlayer;
/* 16 */         int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player s = arrayOfPlayer[i];
/* 17 */           s.sendMessage("");
/* 18 */           s.sendMessage(Main.getInstance().getConfig().getString("Mensagem1").replace("&", "§"));
/* 19 */           s.sendMessage("");
/*    */         }
/*    */         
/* 22 */         Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*    */           public void run() { Player[] arrayOfPlayer;
/* 24 */             int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player s = arrayOfPlayer[i];
/* 25 */               s.sendMessage("");
/* 26 */               s.sendMessage(Main.getInstance().getConfig().getString("Mensagem2").replace("&", "§"));
/* 27 */               s.sendMessage("");
/*    */             }
/*    */           }
/* 30 */         }, 1200L);
/*    */         
/* 32 */         Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*    */           public void run() { Player[] arrayOfPlayer;
/* 34 */             int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player s = arrayOfPlayer[i];
/* 35 */               s.sendMessage("");
/* 36 */               s.sendMessage(Main.getInstance().getConfig().getString("Mensagem3").replace("&", "§"));
/* 37 */               s.sendMessage("");
/*    */             }
/*    */           }
/* 40 */         }, 2400L);
/*    */         
/* 42 */         Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*    */           public void run() { Player[] arrayOfPlayer;
/* 44 */             int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player s = arrayOfPlayer[i];
/* 45 */               s.sendMessage("");
/* 46 */               s.sendMessage(Main.getInstance().getConfig().getString("Mensagem4").replace("&", "§"));
/* 47 */               s.sendMessage("");
/*    */             }
/*    */           }
/* 50 */         }, 4600L);
/*    */         
/* 52 */         Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*    */           public void run() { Player[] arrayOfPlayer;
/* 54 */             int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player s = arrayOfPlayer[i];
/* 55 */               s.sendMessage("");
/* 56 */               s.sendMessage(Main.getInstance().getConfig().getString("Mensagem5").replace("&", "§"));
/* 57 */               s.sendMessage("");
/*    */             }
/*    */           }
/* 60 */         }, 5800L);
/*    */       }
/* 62 */     }, 0L, 7000L);
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\MsgAutomatica.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */