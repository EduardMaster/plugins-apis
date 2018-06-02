/*    */ package br.nikao.outros;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import java.util.HashMap;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class Scoreboards
/*    */ {
/*    */   public static void Scores(Player p)
/*    */   {
/* 12 */     ScoreboardAPI score = new ScoreboardAPI(Main.getInstance().getConfig().getString("Scoreboard").replace("&", "§"));
/* 13 */     score.resetarScoreboard();
/* 14 */     score.adicionarLinha("§0", Integer.valueOf(12));
/* 15 */     score.adicionarLinha("§c➟ §f§lMatou: §e" + Main.Kills.get(p.getName()), Integer.valueOf(11));
/* 16 */     score.adicionarLinha("§c➟ §f§lMorreu: §e" + Main.Deaths.get(p.getName()), Integer.valueOf(10));
/* 17 */     score.adicionarLinha("§c➟ §f§lKS: §e" + KillStreaks.KillStreak.get(p.getName()), Integer.valueOf(9));
/* 18 */     score.adicionarLinha("§1", Integer.valueOf(8));
/* 19 */     score.adicionarLinha("§c➟ §f§lXP: §e" + Main.XP.get(p.getName()), Integer.valueOf(7));
/* 20 */     score.adicionarLinha("§c➟ §f§lSeu Kit: §e" + KitAPI.getkit(p), Integer.valueOf(6));
/* 21 */     score.adicionarLinha("§c➟ §f§lSua Tag: " + TagsAPI.Tag.get(p.getName()), Integer.valueOf(5));
/* 22 */     score.adicionarLinha("§2", Integer.valueOf(4));
/* 23 */     score.adicionarLinha("§c➟ §f§lRank: §e" + (String)Main.Rank.get(p.getName()), Integer.valueOf(3));
/* 24 */     score.adicionarLinha("§c➟ §f§lJogadores: §e" + Bukkit.getOnlinePlayers().length + "/" + Bukkit.getMaxPlayers(), Integer.valueOf(2));
/* 25 */     score.adicionarLinha("§c➟ §f§l/score", Integer.valueOf(1));
/* 26 */     score.setarScoreboard();
/* 27 */     p.setScoreboard(score.pegarScoreboard());
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\Scoreboards.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */