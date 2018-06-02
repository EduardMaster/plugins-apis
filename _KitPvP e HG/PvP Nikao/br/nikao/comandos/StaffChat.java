/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class StaffChat implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 13 */     if (!(sender instanceof Player)) {
/* 14 */       sender.sendMessage("§f[§cErro§f] §cApenas jogadores podem usar isso");
/* 15 */       return true;
/*    */     }
/* 17 */     Player p = (Player)sender;
/* 18 */     if (!sender.hasPermission("ng.sc")) {
/* 19 */       sender.sendMessage("§cSem Permissão");
/*    */     } else {
/* 21 */       if (args.length == 0) {
/* 22 */         p.sendMessage("§cUse: /cs <Mensagem>");
/* 23 */         return true;
/*    */       }
/* 25 */       String message = "";
/* 26 */       for (int i = 0; i < args.length; i++) {
/* 27 */         if (i == args.length - 1) {
/* 28 */           message = message + args[i];
/*    */         } else
/* 30 */           message = message + args[i] + " ";
/*    */       }
/*    */       Player[] arrayOfPlayer;
/* 33 */       int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player s = arrayOfPlayer[i];
/* 34 */         if (s.hasPermission("ng.sc")) {
/* 35 */           s.sendMessage("[§bChat da Staff§f] §6" + p.getName() + ": §f" + message.replace("&", "§"));
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 40 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\StaffChat.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */