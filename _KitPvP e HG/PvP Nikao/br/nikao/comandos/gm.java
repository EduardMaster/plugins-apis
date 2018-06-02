/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import org.bukkit.GameMode;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class gm implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 13 */     if (!(sender instanceof Player)) {
/* 14 */       sender.sendMessage("§cApenas jogadores podem executar esse comando.");
/* 15 */       return true;
/*    */     }
/* 17 */     Player p = (Player)sender;
/* 18 */     if (p.hasPermission("ng.gm")) {
/* 19 */       if (args.length == 0) {
/* 20 */         p.sendMessage("§6§lINFO: §7Seu modo de jogo está: §e" + p.getGameMode());
/* 21 */         return true;
/*    */       }
/*    */     } else {
/* 24 */       p.sendMessage("§cSem permissao.");
/*    */     }
/* 26 */     if (p.hasPermission("ng.gm")) {
/* 27 */       if ((args.length == 1) && 
/* 28 */         (args[0].equalsIgnoreCase("1"))) {
/* 29 */         if (p.getGameMode() == GameMode.CREATIVE) {
/* 30 */           p.sendMessage("§cSeu modo de jogo já está no §eCriativo");
/* 31 */           return true;
/*    */         }
/* 33 */         p.setGameMode(GameMode.CREATIVE);
/* 34 */         p.sendMessage("§6§lINFO: §7Agora seu modo de jogo está: §e§lCriativo");
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 39 */       if ((args.length == 1) && 
/* 40 */         (args[0].equalsIgnoreCase("2"))) {
/* 41 */         if (p.getGameMode() == GameMode.ADVENTURE) {
/* 42 */           p.sendMessage("§cSeu modo de jogo já está no §eAventura");
/* 43 */           return true;
/*    */         }
/* 45 */         p.setGameMode(GameMode.ADVENTURE);
/* 46 */         p.sendMessage("§6§lINFO: §7Agora seu modo de jogo está: §e§lAventura");
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 51 */       if ((args.length == 1) && 
/* 52 */         (args[0].equalsIgnoreCase("0"))) {
/* 53 */         if (p.getGameMode() == GameMode.SURVIVAL) {
/* 54 */           p.sendMessage("§cSeu modo de jogo já está no §eSobrevivencia");
/* 55 */           return true;
/*    */         }
/* 57 */         p.setGameMode(GameMode.SURVIVAL);
/* 58 */         p.sendMessage("§6§lINFO: §7Agora seu modo de jogo está: §e§lSobrevivencia");
/*    */       }
/*    */     }
/*    */     else
/*    */     {
/* 63 */       p.sendMessage("§cSem permissao.");
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\gm.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */