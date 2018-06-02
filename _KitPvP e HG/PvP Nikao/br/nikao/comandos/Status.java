/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import br.nikao.outros.TagsAPI;
/*    */ import java.util.HashMap;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class Status
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 18 */     if (!(sender instanceof Player)) {
/* 19 */       sender.sendMessage("§7§l§nInformacoes do servidor:");
/* 20 */       sender.sendMessage("");
/* 21 */       sender.sendMessage("§6§lOnline: §f§l" + Bukkit.getOnlinePlayers().length);
/* 22 */       sender.sendMessage("");
/* 23 */       return true;
/*    */     }
/* 25 */     if (args.length == 0) {
/* 26 */       Player p = (Player)sender;
/* 27 */       int kills = ((Integer)Main.Kills.get(p.getName())).intValue();
/* 28 */       int deaths = ((Integer)Main.Deaths.get(p.getName())).intValue();
/* 29 */       int xp = ((Integer)Main.XP.get(p.getName())).intValue();
/* 30 */       int vc = Main.getInstance().getConfig().getInt("Status." + p.getUniqueId() + ".VC");
/* 31 */       String rank = (String)Main.Rank.get(p.getName());
/* 32 */       p.sendMessage("");
/* 33 */       p.sendMessage("§7§lSeus status:");
/* 34 */       p.sendMessage("");
/* 35 */       p.sendMessage("§6§lMatou: §f§l" + kills);
/* 36 */       p.sendMessage("§6§lMorreu: §f§l" + deaths);
/* 37 */       p.sendMessage("§6§lXP: §f§l" + xp);
/* 38 */       p.sendMessage("§6§lRank: §f§l" + rank);
/* 39 */       p.sendMessage("§6§lTag: §f§l" + TagsAPI.Tag.get(p.getName()));
/* 40 */       p.sendMessage("§6§lRecord VC: §f§l" + vc);
/*    */     }
/* 42 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\Status.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */