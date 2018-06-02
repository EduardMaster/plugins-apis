/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class TPHere implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 13 */     if (args.length == 0) {
/* 14 */       sender.sendMessage("§cUse: /tphere <Nick>");
/* 15 */       return true;
/*    */     }
/* 17 */     Player p = (Player)sender;
/* 18 */     if (args.length == 1) {
/* 19 */       if (!sender.hasPermission("ng.tphere")) {
/* 20 */         sender.sendMessage("§cSem permissão.");
/* 21 */         return true;
/*    */       }
/* 23 */       Player t = Bukkit.getPlayer(args[0]);
/* 24 */       t.teleport(p);
/* 25 */       t.sendMessage("§6§lINFO: §e" + p.getName() + " §7puxou você.");
/* 26 */       p.sendMessage("§6§lINFO: §7Você puxou §e" + t.getName());
/*    */     }
/*    */     
/* 29 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\TPHere.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */