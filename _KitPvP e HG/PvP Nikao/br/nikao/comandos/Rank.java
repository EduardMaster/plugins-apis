/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class Rank implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 12 */     if (!(sender instanceof Player)) {
/* 13 */       sender.sendMessage("§7[§cErro§7] §cApenas jogadores podem executar esse comando");
/* 14 */       return true;
/*    */     }
/* 16 */     Player p = (Player)sender;
/* 17 */     if (args.length == 0) {
/* 18 */       p.sendMessage(" ");
/* 19 */       p.sendMessage("§7Rank:");
/* 20 */       p.sendMessage(" ");
/* 21 */       p.sendMessage("§6BRZ IV - §e1.000 Kills");
/* 22 */       p.sendMessage("§6BRZ III - §e3.000 Kills");
/* 23 */       p.sendMessage("§6BRZ II - §e5.000 Kills");
/* 24 */       p.sendMessage("§6BRZ I - §e10.000 Kills");
/* 25 */       p.sendMessage(" ");
/* 26 */       p.sendMessage("§7Use /rank brz e veja os premios");
/* 27 */     } else if ((args.length == 1) && 
/* 28 */       (args[0].equalsIgnoreCase("brz"))) {
/* 29 */       p.sendMessage(" ");
/* 30 */       p.sendMessage("§6BRZ IV - §eAo upar para o Rank BRZ IV você ganha o Kit: §aMonk");
/* 31 */       p.sendMessage("§6BRZ III - §eAo upar para o Rank BRZ IV você ganha o Kit: §aDeshfire e Magma");
/* 32 */       p.sendMessage("§6BRZ II - §eAo upar para o Rank BRZ IV você ganha o Kit: §aTimelord, Spiderman e Switcher");
/* 33 */       p.sendMessage("§6BRZ I - §eAo upar para o Rank BRZ IV você ganha o Kit: §aForcefield, Rain, Phantom e C4");
/* 34 */       p.sendMessage(" ");
/*    */     }
/*    */     
/* 37 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\Rank.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */