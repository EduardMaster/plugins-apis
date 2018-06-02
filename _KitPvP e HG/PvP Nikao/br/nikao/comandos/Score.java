/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import br.nikao.outros.ScoreboardAPI;
/*    */ import br.nikao.outros.Scoreboards;
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class Score
/*    */   implements CommandExecutor
/*    */ {
/* 15 */   public static ArrayList<String> score = new ArrayList();
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 19 */     if (!(sender instanceof Player)) {
/* 20 */       sender.sendMessage("§7§l[§cErro§7§l] §cApenas jogadores podem executar esse comando");
/* 21 */       return true;
/*    */     }
/* 23 */     if (args.length == 0) {
/* 24 */       Player p = (Player)sender;
/* 25 */       ScoreboardAPI sb = new ScoreboardAPI("nada");
/* 26 */       if (score.contains(p.getName())) {
/* 27 */         p.sendMessage("§6§lINFO: §7Agora sua Scoreboard está: §aAtivada");
/* 28 */         Scoreboards.Scores(p);
/* 29 */         score.remove(p.getName());
/*    */       } else {
/* 31 */         p.sendMessage("§6§lINFO: §7Agora sua Scoreboard está: §cDesativada");
/* 32 */         score.add(p.getName());
/*    */         
/* 34 */         sb.resetarScoreboard();
/* 35 */         p.setScoreboard(sb.pegarScoreboard());
/*    */       }
/*    */     }
/*    */     
/* 39 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\Score.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */