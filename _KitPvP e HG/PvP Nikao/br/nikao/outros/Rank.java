/*    */ package br.nikao.outros;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class Rank
/*    */ {
/*    */   public static void Rankup(Player p) throws java.sql.SQLException
/*    */   {
/* 14 */     int value = ((Integer)Main.XP.get(p.getName())).intValue();
/* 15 */     if (value == 1000) {
/* 16 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Rank", "BRZ IV");
/* 17 */       Bukkit.broadcastMessage("§6§lRank: §3§l" + p.getName() + " §eUpou para o rank §6BRZ IV");
/* 18 */       p.sendMessage("§6§lRank: §7Você ganhou o Kit: §aMonk§7, por upar de Rank.");
/* 19 */       Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit.monk");
/* 20 */       Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex reload");
/* 21 */       Main.getInstance().saveConfig();
/* 22 */       if (br.nikao.comandos.Score.score.contains(p.getName())) {
/* 23 */         return;
/*    */       }
/* 25 */       Scoreboards.Scores(p);
/*    */     }
/*    */     
/*    */ 
/* 29 */     if (value == 3000) {
/* 30 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Rank", "BRZ III");
/* 31 */       Bukkit.broadcastMessage("§6§lRank: §3§l" + p.getName() + " §eUpou para o rank §6BRZ III");
/* 32 */       p.sendMessage("§6§lRank: §7Você ganhou o Kit: §aDeshfire e Magma§7, por upar de Rank.");
/* 33 */       Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit.deshfire");
/* 34 */       Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit.magma");
/* 35 */       Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex reload");
/* 36 */       Main.getInstance().saveConfig();
/* 37 */       if (br.nikao.comandos.Score.score.contains(p.getName())) {
/* 38 */         return;
/*    */       }
/* 40 */       Scoreboards.Scores(p);
/*    */     }
/*    */     
/*    */ 
/* 44 */     if (value == 5000) {
/* 45 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Rank", "BRZ II");
/* 46 */       Bukkit.broadcastMessage("§6§lRank: §3§l" + p.getName() + " §eUpou para o rank §6BRZ II");
/* 47 */       p.sendMessage("§6§lRank: §7Você ganhou o Kit: §aTimelord, Spiderman e Switcher§7, por upar de Rank.");
/* 48 */       Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit.timelord");
/* 49 */       Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit.spiderman");
/* 50 */       Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit.switcher");
/* 51 */       Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex reload");
/* 52 */       Main.getInstance().saveConfig();
/* 53 */       if (br.nikao.comandos.Score.score.contains(p.getName())) {
/* 54 */         return;
/*    */       }
/* 56 */       Scoreboards.Scores(p);
/*    */     }
/*    */     
/*    */ 
/* 60 */     if (value == 10000) {
/* 61 */       Main.getInstance().getConfig().set("Status." + p.getUniqueId() + ".Rank", "BRZ I");
/* 62 */       Bukkit.broadcastMessage("§6§lRank: §3§l" + p.getName() + " §eUpou para o rank §6BRZ I");
/* 63 */       p.sendMessage("§6§lRank: §7Você ganhou o Kit: §aForcefield, Rain, Phantom e C4§7, por upar de Rank.");
/* 64 */       Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit.forcefield");
/* 65 */       Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit.rain");
/* 66 */       Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit.phantom");
/* 67 */       Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit.c4");
/* 68 */       Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex reload");
/* 69 */       Main.getInstance().saveConfig();
/* 70 */       if (br.nikao.comandos.Score.score.contains(p.getName())) {
/* 71 */         return;
/*    */       }
/* 73 */       Scoreboards.Scores(p);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\Rank.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */