/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class Report implements CommandExecutor, Listener
/*    */ {
/* 19 */   public static ArrayList<String> reported = new ArrayList();
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 23 */     if (!(sender instanceof Player)) {
/* 24 */       sender.sendMessage("§7[§cErro§7] §cApenas jogadores podem executar esse comando");
/* 25 */       return true;
/*    */     }
/* 27 */     final Player p = (Player)sender;
/* 28 */     if (label.equalsIgnoreCase("report")) {
/* 29 */       if (args.length >= 2) {
/* 30 */         Player target = p.getServer().getPlayer(args[0]);
/* 31 */         if (target != null) {
/* 32 */           if (target == p) {
/* 33 */             p.sendMessage("§4§lERRO: §cVocê não pode se reportar.");
/* 34 */             return true;
/*    */           }
/* 36 */           if (reported.contains(p.getName())) {
/* 37 */             p.sendMessage("§cEsse jogador já foi reportado aguarde uma resposta");
/* 38 */             p.playSound(p.getLocation(), Sound.EXPLODE, 2.0F, 2.0F);
/* 39 */             return true;
/*    */           }
/* 41 */           String reportMsg = StringUtils.join(Arrays.copyOfRange(args, 1, args.length), " ");
/* 42 */           reported.add(p.getName());
/* 43 */           p.sendMessage("§aObrigado, os staffs já estão vendo seu report");
/* 44 */           p.playSound(p.getLocation(), Sound.ANVIL_USE, 2.0F, 2.0F);
/* 45 */           Player[] arrayOfPlayer; int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player s = arrayOfPlayer[i];
/* 46 */             if (s.hasPermission("ng.report")) {
/* 47 */               s.playSound(s.getLocation(), Sound.LEVEL_UP, 15.0F, 1.0F);
/* 48 */               s.sendMessage("§9§l§m--------------------------");
/* 49 */               s.sendMessage("               §e§l★ §4§l§nREPORT§f §e§l★");
/* 50 */               s.sendMessage("§9§l§m--------------------------");
/* 51 */               s.sendMessage(" ");
/* 52 */               s.sendMessage("§c§l● §7§lSujeito: §b" + target.getName());
/* 53 */               s.sendMessage("§c§l● §7§lVitima: §b" + p.getName());
/* 54 */               s.sendMessage("§c§l● §7§lMotivo: §b" + reportMsg);
/* 55 */               s.sendMessage(" ");
/*    */             }
/*    */           }
/* 58 */           Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*    */           {
/*    */             public void run()
/*    */             {
/* 62 */               Report.reported.remove(p.getName());
/*    */             }
/* 64 */           }, 250L);
/*    */         } else {
/* 66 */           p.sendMessage("§cEsse jogador não está online");
/*    */         }
/*    */       } else {
/* 69 */         p.sendMessage("§cUse: /report <Player> <Motivo>");
/*    */       }
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\Report.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */