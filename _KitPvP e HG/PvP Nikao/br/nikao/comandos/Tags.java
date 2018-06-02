/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class Tags implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 12 */     Player p = (Player)sender;
/* 13 */     if (args.length == 0) {
/* 14 */       p.sendMessage("§7Você possui as tags:");
/* 15 */       p.sendMessage("");
/* 16 */       p.sendMessage("§7Normal");
/* 17 */       if (p.hasPermission("tag.vip")) {
/* 18 */         p.sendMessage("§a§lVIP");
/*    */       }
/* 20 */       if (p.hasPermission("tag.pro")) {
/* 21 */         p.sendMessage("§6Pro");
/*    */       }
/* 23 */       if (p.hasPermission("tag.youtuber")) {
/* 24 */         p.sendMessage("§bYoutuber");
/*    */       }
/* 26 */       if (p.hasPermission("tag.coder")) {
/* 27 */         p.sendMessage("§3Coder");
/*    */       }
/* 29 */       if (p.hasPermission("tag.builder")) {
/* 30 */         p.sendMessage("§eBuilder");
/*    */       }
/* 32 */       if (p.hasPermission("tag.trial")) {
/* 33 */         p.sendMessage("§dTrial");
/*    */       }
/* 35 */       if (p.hasPermission("tag.mod")) {
/* 36 */         p.sendMessage("§5Mod");
/*    */       }
/* 38 */       if (p.hasPermission("tag.admin")) {
/* 39 */         p.sendMessage("§cAdmin");
/*    */       }
/* 41 */       if (p.hasPermission("tag.dono")) {
/* 42 */         p.sendMessage("§4§lDono");
/*    */       }
/* 44 */       if ((p.hasPermission("tag.*")) || (p.isOp())) {
/* 45 */         p.sendMessage("");
/* 46 */         p.sendMessage("§6§lTodas as tags");
/*    */       }
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\Tags.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */