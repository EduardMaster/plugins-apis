/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class Tp implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 13 */     if (!(sender instanceof Player)) {
/* 14 */       sender.sendMessage("§7§l[§cErro§7§l] §cApenas jogadores podem executar este comando!");
/* 15 */       return true;
/*    */     }
/* 17 */     Player p = (Player)sender;
/* 18 */     if ((cmd.getName().equalsIgnoreCase("tp")) && (p.hasPermission("ng.tp"))) {
/* 19 */       if (args.length == 0) {
/* 20 */         p.sendMessage("§cUse: /tp <Player>");
/* 21 */         return true;
/*    */       }
/* 23 */       Player k = Bukkit.getServer().getPlayer(args[0]);
/* 24 */       if (k == null) {
/* 25 */         p.sendMessage("§cEste jogador encontra-se offline ou não existe");
/* 26 */         return true;
/*    */       }
/* 28 */       p.teleport(k.getLocation());
/* 29 */       if (Admin.admin.contains(p.getName())) { Player[] arrayOfPlayer;
/* 30 */         int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player s = arrayOfPlayer[i];
/* 31 */           s.hidePlayer(p);
/*    */         }
/*    */       }
/* 34 */       return true;
/*    */     }
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\Tp.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */