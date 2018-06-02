/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.BlockBreakEvent;
/*    */ import org.bukkit.event.block.BlockPlaceEvent;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ 
/*    */ public class Build
/*    */   implements Listener, CommandExecutor
/*    */ {
/* 17 */   public static HashMap<String, BuildStats> Build = new HashMap();
/*    */   
/*    */   public static enum BuildStats {
/* 20 */     ON,  OFF;
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 25 */     if (!(sender instanceof Player)) {
/* 26 */       sender.sendMessage("§f[§cErro§f] §cApenas jogadores podem usar isso");
/* 27 */       return true;
/*    */     }
/* 29 */     if (!sender.hasPermission("ng.build")) {
/* 30 */       sender.sendMessage("§cSem Permissão.");
/* 31 */       return true;
/*    */     }
/* 33 */     Player p = (Player)sender;
/* 34 */     if (args.length == 0) {
/* 35 */       p.sendMessage("§cUse: /build on ou off");
/* 36 */       return true;
/*    */     }
/* 38 */     if (args[0].equalsIgnoreCase("on")) {
/* 39 */       if (Build.get(p.getName()) == BuildStats.ON) {
/* 40 */         p.sendMessage("§cSeu Build já está ativado");
/* 41 */         return true;
/*    */       }
/* 43 */       p.sendMessage("§7Seu modo construir agora está: §aAtivo");
/* 44 */       Build.put(p.getName(), BuildStats.ON);
/* 45 */       return true;
/*    */     }
/* 47 */     if (args[0].equalsIgnoreCase("off")) {
/* 48 */       if (Build.get(p.getName()) == BuildStats.OFF) {
/* 49 */         p.sendMessage("§cSeu Build já está desativado");
/*    */       } else {
/* 51 */         p.sendMessage("§7Seu modo construir agora está: §cDesativado");
/* 52 */         Build.put(p.getName(), BuildStats.OFF);
/* 53 */         return true;
/*    */       }
/* 55 */     } else p.sendMessage("§cUse: /build on ou off");
/* 56 */     return false;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void Entrou(PlayerJoinEvent e) {
/* 61 */     Build.put(e.getPlayer().getName(), BuildStats.OFF);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void Quebrar(BlockBreakEvent e) {
/* 66 */     Player p = e.getPlayer();
/* 67 */     if (Build.get(p.getName()) == BuildStats.OFF) {
/* 68 */       e.setCancelled(true);
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void Quebrar(BlockPlaceEvent e) {
/* 74 */     Player p = e.getPlayer();
/* 75 */     if (Build.get(p.getName()) == BuildStats.OFF) {
/* 76 */       e.setCancelled(true);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\Build.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */