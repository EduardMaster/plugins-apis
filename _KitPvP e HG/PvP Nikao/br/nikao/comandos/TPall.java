/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class TPall
/*    */   implements Listener, CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 15 */     Player p = (Player)sender;
/* 16 */     if (!(sender instanceof Player)) {
/* 17 */       sender.sendMessage("§7[§cErro§7] §cApenas jogadores podem executar esse comando");
/* 18 */       return true; }
/*    */     Player[] arrayOfPlayer;
/* 20 */     int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player s = arrayOfPlayer[i];
/* 21 */       if ((cmd.getName().equalsIgnoreCase("tpall")) && (sender.hasPermission("ng.tpall"))) {
/* 22 */         s.teleport(p);
/* 23 */         s.sendMessage("§6§lTodos foram teleportados para §b" + p.getDisplayName());
/*    */       } else {
/* 25 */         p.sendMessage("§cSem permissão");
/*    */       }
/*    */     }
/* 28 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\TPall.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */