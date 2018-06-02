/*    */ package neero.demon.comandos;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
import org.bukkit.Warning;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
/*    */ import org.bukkit.event.player.PlayerQuitEvent;
/*    */ 
/*    */ public class ClearChat implements CommandExecutor, Listener
/*    */ {
/* 18 */   public static boolean pausado = false;
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
/*    */   {
/* 22 */     Player p = (Player)sender;
/* 23 */     if (cmd.getName().equalsIgnoreCase("pchat"))
/*    */     {
/* 25 */       if (!p.hasPermission("fire.pchat"))
/*    */       {
/* 27 */         p.sendMessage(ChatColor.RED + "§e§lEXTREMEPVP §6§l> Voce nao tem permissao para isso!");
/* 28 */         return true;
/*    */       }
/* 30 */       if (pausado)
/*    */       {
/* 32 */         Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "§e§lEXTREMEPVP §6§l> Chat Normal!");
/* 33 */         pausado = false;
/*    */       }
/*    */       else
/*    */       {
/* 37 */         Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "§e§lEXTREMEPVP §6§l> Chat Pausado!");
/* 38 */         pausado = true;
/*    */       }
/*    */     }
/* 41 */     if (cmd.getName().equalsIgnoreCase("cc"))
/*    */     {
/* 43 */       if (!p.hasPermission("fire.cc"))
/*    */       {
/* 45 */         p.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
/* 46 */         return true;
/*    */       }
/* 48 */       for (int i = 0; i < 100; i++) {
/* 49 */         Bukkit.getServer().broadcastMessage("");
/*    */       }
/* 51 */       Bukkit.getServer().broadcastMessage(ChatColor.BLUE + "§e§lEXTREMEPVP §6§l> Chat Limpo!");
/*    */     }
/* 53 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void onQuit(PlayerQuitEvent e)
/*    */   {
/* 68 */     if (pausado) {
/* 69 */       e.setQuitMessage("");
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onChat(AsyncPlayerChatEvent e)
/*    */   {
/* 76 */     Player p = e.getPlayer();
/* 77 */     if ((pausado) && 
/* 78 */       (!p.hasPermission("fire.mchat")))
/*    */     {
/* 80 */       e.setCancelled(true);
/* 81 */       p.sendMessage(ChatColor.RED + "O Chat esta Pausado!");
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\commands\ClearChat.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */