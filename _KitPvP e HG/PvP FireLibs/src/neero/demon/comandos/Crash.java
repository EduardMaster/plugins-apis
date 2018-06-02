/*    */ package neero.demon.comandos;
/*    */ 
/*    */ import neero.demon.Main;

/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class Crash implements CommandExecutor
/*    */ {
/*    */   public static Main plugin;
/*    */   
/*    */   public Crash(Main main)
/*    */   {
/* 20 */     plugin = main;
/*    */   }
/*    */   
/*    */ 
/* 24 */   private Inventory inv = null;
/*    */   
/*    */   @SuppressWarnings("deprecation")
public boolean onCommand(final CommandSender sender, Command command, String label, String[] args)
/*    */   {
/* 28 */     if ((label.equalsIgnoreCase("crash")) && (sender.hasPermission("fire.crash"))) {
/* 29 */       if (args.length < 1) {
/* 30 */         sender.sendMessage(ChatColor.RED + "Sintaxe: /crash <jogador>");
/* 31 */         return true;
/*    */       }
/* 33 */       final Player other = Bukkit.getPlayer(args[0]);
/* 34 */       if (other == null)
/*    */       {
/* 36 */         sender.sendMessage(ChatColor.RED + "O jogador especificado n√£o foi encontrado!");
/* 37 */         return true;
/*    */       }
/* 39 */       sender.sendMessage("ß8[ß6ßlEKß8] Preparando para crashar o jogador " + ChatColor.GOLD + other.getName() + ChatColor.GRAY + "...");
/* 40 */       Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new BukkitRunnable() {
/*    */         public void run() {
/* 42 */           Crash.this.inv = Bukkit.createInventory(null, 756);
/* 43 */           other.openInventory(Crash.this.inv);
/* 44 */           sender.sendMessage("ß8[ß6ßlEKß8] Jogador crashado!");
/*    */         }
/* 46 */       }, 35L);
/*    */     }
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\commands\Crash.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */