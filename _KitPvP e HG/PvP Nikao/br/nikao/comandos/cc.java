/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class cc
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arcgs)
/*    */   {
/* 14 */     if (!(sender instanceof Player)) {
/* 15 */       sender.sendMessage("§f[§cErro§f] §cApenas jogadores podem usar isso");
/* 16 */       return true;
/*    */     }
/* 18 */     if (!sender.hasPermission("ng.cc")) {
/* 19 */       sender.sendMessage("§cSem Permissão");
/*    */     } else { Player[] arrayOfPlayer;
/* 21 */       int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player s = arrayOfPlayer[i];
/* 22 */         for (int i = 0; i != 100; i++) {
/* 23 */           s.sendMessage("  ");
/*    */         }
/* 25 */         s.sendMessage("§c§l* §7Chat do Servidor foi Limpo §c§l*");
/*    */       }
/* 27 */       sender.sendMessage("§c§l* §7Você Limpou o Chat! §c§l*");
/* 28 */       return false;
/*    */     }
/* 30 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\cc.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */