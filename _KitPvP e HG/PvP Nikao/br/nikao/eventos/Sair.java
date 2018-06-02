/*    */ package br.nikao.eventos;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import br.nikao.outros.Config;
/*    */ import br.nikao.outros.KitAPI;
/*    */ import br.nikao.outros.Scoreboards;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.player.PlayerQuitEvent;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class Sair implements org.bukkit.event.Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Eventos(PlayerQuitEvent e)
/*    */   {
/* 21 */     e.setQuitMessage(null);
/* 22 */     Player p = e.getPlayer();
/* 23 */     Config.addKill(p, ((Integer)Main.Kills.get(p.getName())).intValue());
/* 24 */     Config.addDeaths(p, ((Integer)Main.Deaths.get(p.getName())).intValue());
/* 25 */     Config.addXP(p, ((Integer)Main.XP.get(p.getName())).intValue());
/* 26 */     Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Rank", Main.Rank.get(p.getName()));
/* 27 */     Main.getInstance().saveConfig();
/*    */     Player[] arrayOfPlayer;
/* 29 */     int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { final Player s = arrayOfPlayer[i];
/* 30 */       Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*    */       {
/*    */         public void run()
/*    */         {
/* 34 */           if (br.nikao.comandos.Score.score.contains(s.getName())) {
/* 35 */             return;
/*    */           }
/* 37 */           Scoreboards.Scores(s);
/*    */         }
/*    */         
/*    */ 
/* 41 */       }, 20L);
/* 42 */       if (Main.getInstance().getConfig().getString("Saiu").equals("true")) {
/* 43 */         s.sendMessage(Main.getInstance().getConfig().getString("Saiu2").replace("{player}", p.getName()).replace("&", "§"));
/* 44 */       } else if (Main.getInstance().getConfig().getString("Saiu").equals("false")) {
/* 45 */         return;
/*    */       }
/*    */     }
/* 48 */     p.getInventory().clear();
/* 49 */     KitAPI.RemoveKit(p);
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\eventos\Sair.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */