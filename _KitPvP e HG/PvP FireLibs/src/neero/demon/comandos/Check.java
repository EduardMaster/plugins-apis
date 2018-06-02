/*    */ package neero.demon.comandos;
/*    */ 
/*    */ /*    */ import java.net.InetSocketAddress;

import neero.demon.Main;

/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Damageable;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class Check implements CommandExecutor
/*    */ {
/*    */   private Main plugin;
/*    */   
/*    */   public Check(Main plugin)
/*    */   {
/* 22 */     this.plugin = plugin;
/*    */   }
/*    */   
/*    */ 
/*    */   public static int getAmount(Player p, Material m)
/*    */   {
/* 28 */     int amount = 0;
/* 29 */     ItemStack[] arrayOfItemStack; int j = (arrayOfItemStack = p.getInventory().getContents()).length; for (int i = 0; i < j; i++) { ItemStack item = arrayOfItemStack[i];
/* 30 */       if ((item != null) && (item.getType() == m) && 
/* 31 */         (item.getAmount() > 0)) {
/* 32 */         amount += item.getAmount();
/*    */       }
/*    */     }
/* 35 */     return amount;
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
/*    */   {
/* 40 */     if (!(sender instanceof Player))
/*    */     {
/* 42 */       sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
/* 43 */       return false;
/*    */     }
/* 45 */     final Player p = (Player)sender;
/* 46 */     if ((commandLabel.equalsIgnoreCase("check")) && 
/* 47 */       (p.hasPermission("fire.check")) && 
/* 48 */       (args.length == 1))
/*    */     {
/* 50 */       final Player target = p.getServer().getPlayer(args[0]);
/* 51 */       if (target != null)
/*    */       {
/* 53 */         p.sendMessage("§c§lGerando Informaçooes do Player ... Aguarde!");
/* 54 */         org.bukkit.Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
/*    */           public void run() {
/* 56 */             Damageable hp = target;
/* 57 */             p.sendMessage("§7§lInformaçõeses do player §6§l§o" + target.getName());
/* 58 */             p.sendMessage("§7§lItem selecionado: §e§l§o" + target.getItemInHand().getType());
/* 59 */             p.sendMessage("§7§lVida: §e§l§o" + (int)hp.getHealth());
/* 60 */             p.sendMessage("§7§lSopas: §e§l§o" + Check.getAmount(target, Material.MUSHROOM_SOUP));
/* 61 */             p.sendMessage("§7§lGamemode: §e§l§o" + target.getGameMode());
/* 62 */             p.sendMessage("§7§lIP : §e§l§o" + target.getAddress().getHostString());
/*    */           }
/* 64 */         }, 20L);
/*    */       }
/*    */       else
/*    */       {
/* 68 */         p.sendMessage(ChatColor.RED + "Jogador " + args[0] + 
/* 69 */           " inexistente!");
/*    */       }
/*    */     }
/*    */     else {
/* 73 */       p.sendMessage(ChatColor.RED + "Errado! Use /" + commandLabel + 
/* 74 */         " <jogador>");
/*    */     }
/*    */     
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\commands\Check.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */