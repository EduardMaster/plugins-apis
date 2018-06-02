/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.AsyncPlayerChatEvent;
/*    */ 
/*    */ public class Chat implements CommandExecutor, Listener
/*    */ {
/* 13 */   public static boolean chat = true;
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
/* 16 */     if (!(sender instanceof Player)) {
/* 17 */       sender.sendMessage("§cApenas jogadores podem executar esse comando");
/* 18 */       return true;
/*    */     }
/* 20 */     if (args.length == 0) {
/* 21 */       sender.sendMessage("§cUse: /chat on ou off");
/* 22 */       return true;
/*    */     }
/* 24 */     if (sender.hasPermission("ng.desativarchat")) {
/* 25 */       if (args.length == 1) {
/* 26 */         if (args[0].equalsIgnoreCase("off")) {
/* 27 */           chat = false;
/* 28 */           Bukkit.broadcastMessage("§c§l* §7Chat do Servidor foi §4Desativado §c§l*");
/*    */         }
/*    */         
/* 31 */         if (args[0].equalsIgnoreCase("on")) {
/* 32 */           chat = true;
/* 33 */           Bukkit.broadcastMessage("§c§l* §7Chat do Servidor foi §aAtivado §c§l*");
/*    */         }
/*    */       }
/*    */     } else {
/* 37 */       sender.sendMessage("§cSem permissao");
/*    */     }
/* 39 */     return false;
/*    */   }
/*    */   
/*    */   @org.bukkit.event.EventHandler
/*    */   public void onPlayerChat(AsyncPlayerChatEvent e) {
/* 44 */     if ((!e.getPlayer().hasPermission("ng.chat")) && (!chat)) {
/* 45 */       e.getPlayer().sendMessage("§c§l* §7Chat do Servidor Está Temporariamente §4Desativado §c§l*");
/* 46 */       e.setCancelled(true);
/* 47 */       return;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\Chat.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */