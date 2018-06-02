/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class Arena implements org.bukkit.command.CommandExecutor, org.bukkit.event.Listener
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args)
/*    */   {
/* 15 */     if (!(sender instanceof Player)) {
/* 16 */       sender.sendMessage("§f[§cErro§f] §cApenas jogadores podem usar isso");
/* 17 */       return true;
/*    */     }
/* 19 */     if ((sender.hasPermission("ng.arena")) && (cmd.getName().equalsIgnoreCase("arena"))) {
/* 20 */       if (args.length == 0) {
/* 21 */         sender.sendMessage("§cUse /arena <player>");
/*    */       }
/* 23 */       if (args.length == 1) {
/* 24 */         Player o = Bukkit.getPlayer(args[0]);
/* 25 */         if (o != null) {
/* 26 */           o.getLocation().add(0.0D, 13.0D, 0.0D).getBlock().setType(Material.BEDROCK);
/* 27 */           o.getLocation().add(0.0D, 11.0D, 1.0D).getBlock().setType(Material.BEDROCK);
/* 28 */           o.getLocation().add(1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
/* 29 */           o.getLocation().add(0.0D, 11.0D, -1.0D).getBlock().setType(Material.BEDROCK);
/* 30 */           o.getLocation().add(-1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
/* 31 */           o.getLocation().add(0.0D, 10.0D, 0.0D).getBlock().setType(Material.BEDROCK);
/* 32 */           o.teleport(o.getLocation().add(0.0D, 11.0D, -0.05D));
/* 33 */           sender.sendMessage("§7§lA Jaula foi criada com sucesso");
/*    */           Player[] arrayOfPlayer;
/* 35 */           int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
/* 36 */           for (int i = 0; i < j; i++) {
/* 37 */             Player p2 = arrayOfPlayer[i];
/* 38 */             if (p2.hasPermission("arena")) {
/* 39 */               p2.sendMessage("§6§l" + sender.getName() + " §7prendeu §e§l" + o.getDisplayName() + " §7em uma jaula");
/*    */             }
/*    */           }
/*    */         } else {
/* 43 */           sender.sendMessage("§cEsté jogador não existe ou está offline");
/*    */         }
/*    */       }
/*    */     } else {
/* 47 */       sender.sendMessage("§cSem Permissão");
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\Arena.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */