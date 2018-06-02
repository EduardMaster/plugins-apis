/*    */ package neero.demon.comandos;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class Broadcast
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
/*    */   {
/* 15 */     Player player = (Player)sender;
/* 16 */     if (((commandLabel.equalsIgnoreCase("bc")) || (commandLabel.equalsIgnoreCase("broadcast"))) && (player.hasPermission("fire.bc"))) {
/* 17 */       if (args.length >= 1)
/*    */       {
/* 19 */         String bcast = "";
/* 20 */         for (int x = 0; x < args.length; x++) {
/* 21 */           bcast = bcast + args[x] + " ";
/*    */         }
/* 23 */         bcast = ChatColor.translateAlternateColorCodes('§', bcast);
/* 24 */         Bukkit.broadcastMessage("§4§lAVISO " + ChatColor.RESET + bcast);
/*    */       }
/*    */       else
/*    */       {
/* 28 */         sender.sendMessage(ChatColor.AQUA + "Use: /broadcast [mensagem]");
/*    */       }
/*    */     }
/* 31 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\commands\Broadcast.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */