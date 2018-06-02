/*    */ package br.nikao.eventos;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import br.nikao.comandos.Score;
/*    */ import br.nikao.minigames.VoidChallenge;
/*    */ import br.nikao.outros.KillStreaks;
/*    */ import br.nikao.outros.KitAPI;
/*    */ import br.nikao.outros.Scoreboards;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ 
/*    */ public class Morrer implements org.bukkit.event.Listener
/*    */ {
/*    */   @org.bukkit.event.EventHandler
/*    */   public void Eventos(PlayerDeathEvent e) throws java.sql.SQLException
/*    */   {
/* 22 */     e.setDeathMessage(null);
/* 23 */     Player p = e.getEntity();
/* 24 */     if ((e.getEntity().getKiller() instanceof Player)) {
/* 25 */       Player t = e.getEntity().getKiller();
/* 26 */       KillStreaks.setKillStreak(p);
/* 27 */       p.sendMessage("§4§lVocê morreu para §6" + t.getName());
/* 28 */       p.sendMessage("§6§lXP: §4§l-§7§l30");
/* 29 */       Main.Deaths.put(p.getName(), Integer.valueOf(((Integer)Main.Deaths.get(p.getName())).intValue() + 1));
/* 30 */       Main.XP.put(p.getName(), Integer.valueOf(((Integer)Main.XP.get(p.getName())).intValue() - 30));
/* 31 */       if (Score.score.contains(p.getName())) {
/* 32 */         return;
/*    */       }
/* 34 */       Scoreboards.Scores(p);
/*    */       
/*    */ 
/* 37 */       KillStreaks.addKillStreak(t);
/* 38 */       t.sendMessage("§6§lVocê matou §c" + p.getName());
/* 39 */       t.sendMessage("§6§lXP: §2§l+§7§l60");
/* 40 */       br.nikao.outros.Rank.Rankup(t);
/* 41 */       Main.Kills.put(t.getName(), Integer.valueOf(((Integer)Main.Kills.get(t.getName())).intValue() + 1));
/* 42 */       Main.XP.put(t.getName(), Integer.valueOf(((Integer)Main.XP.get(t.getName())).intValue() + 60));
/* 43 */       p.getInventory().clear();
/* 44 */       KitAPI.RemoveKit(p);
/* 45 */       e.getDrops().clear();
/* 46 */       if (Score.score.contains(t.getName())) {
/* 47 */         return;
/*    */       }
/* 49 */       Scoreboards.Scores(t);
/*    */     }
/*    */     else
/*    */     {
/* 53 */       int record = Main.getInstance().getConfig().getInt("Status." + p.getUniqueId() + ".VC");
/* 54 */       if (VoidChallenge.voidchallenge.contains(p.getName())) {
/* 55 */         p.sendMessage("§7§lVocê conseguiu ficar §f" + p.getLevel() + " segundos §7§lno VoidChallenge");
/* 56 */         if (p.getLevel() > record) {
/* 57 */           Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".VC", Integer.valueOf(p.getLevel()));
/* 58 */           p.sendMessage("§7§lVocê fez um novo record no VoidChallenge: §e" + p.getLevel() + " segundos.");
/*    */         }
/* 60 */         p.setExp(0.0F);
/* 61 */         p.setLevel(0);
/* 62 */         p.getInventory().clear();
/* 63 */         VoidChallenge.voidchallenge.remove(p.getName());
/* 64 */         e.getDrops().clear();
/* 65 */         KitAPI.RemoveKit(p);
/* 66 */         KillStreaks.setKillStreak(p);
/*    */       } else {
/* 68 */         KillStreaks.setKillStreak(p);
/* 69 */         p.sendMessage("§4§lVocê morreu!");
/* 70 */         p.sendMessage("§6§lXP: §4§l-§7§l30");
/* 71 */         Main.Deaths.put(p.getName(), Integer.valueOf(((Integer)Main.Deaths.get(p.getName())).intValue() + 1));
/* 72 */         Main.XP.put(p.getName(), Integer.valueOf(((Integer)Main.XP.get(p.getName())).intValue() - 30));
/* 73 */         KitAPI.RemoveKit(p);
/* 74 */         e.getDrops().clear();
/* 75 */         if (Score.score.contains(p.getName())) {
/* 76 */           return;
/*    */         }
/* 78 */         Scoreboards.Scores(p);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\eventos\Morrer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */