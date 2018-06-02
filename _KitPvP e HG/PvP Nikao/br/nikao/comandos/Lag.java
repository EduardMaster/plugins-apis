/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import java.text.DecimalFormat;
/*    */ import net.minecraft.server.v1_7_R4.EntityPlayer;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class Lag implements CommandExecutor, Listener
/*    */ {
/* 16 */   public static int TickCount = 0;
/* 17 */   public static long[] Ticks = new long[63];
/* 18 */   public static long LastTick = 0L;
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
/* 21 */     if (!(sender instanceof Player)) {
/* 22 */       sender.sendMessage("§f[§cErro§f] §cApenas jogadores podem usar isso");
/* 23 */       return true;
/*    */     }
/* 25 */     if (label.equalsIgnoreCase("lag")) {
/* 26 */       double tps = getTPS();
/* 27 */       double lag = 100.0D - tps / 20.0D * 100.0D;
/* 28 */       DecimalFormat format = new DecimalFormat("##.##");
/* 29 */       sender.sendMessage(ChatColor.GOLD + "Servidor rodando em " + format.format(tps) + " tps");
/* 30 */       sender.sendMessage(ChatColor.GOLD + "Lag esta aproximadamente " + format.format(lag) + "%");
/* 31 */       return true;
/*    */     }
/* 33 */     if (label.equalsIgnoreCase("ping")) {
/* 34 */       if (args.length == 0) {
/* 35 */         if (!(sender instanceof Player)) {
/* 36 */           sender.sendMessage(ChatColor.RED + "Use: /ping <player>");
/* 37 */           return true;
/*    */         }
/* 39 */         CraftPlayer cp = (CraftPlayer)sender;
/* 40 */         EntityPlayer ep = cp.getHandle();
/* 41 */         sender.sendMessage("§7§lSeu Ping é de: §e" + ep.ping + " §ems.");
/* 42 */         return true;
/*    */       }
/* 44 */       if (args.length == 1)
/*    */       {
/* 46 */         Player target = Bukkit.getPlayer(args[0]);
/* 47 */         if (target == null)
/*    */         {
/* 49 */           sender.sendMessage(ChatColor.RED + "Player nao esta online!");
/* 50 */           return true;
/*    */         }
/* 52 */         CraftPlayer cp = (CraftPlayer)target;
/* 53 */         EntityPlayer ep = cp.getHandle();
/* 54 */         sender.sendMessage(ChatColor.GREEN + "O ping de " + target.getName() + " e de " + ep.ping + " ms");
/* 55 */         return true;
/*    */       }
/* 57 */       sender.sendMessage(ChatColor.RED + "Use: /ping [player]");
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public static double getTPS()
/*    */   {
/* 65 */     return getTPS(100);
/*    */   }
/*    */   
/*    */   public static double getTPS(int ticks)
/*    */   {
/* 70 */     if (TickCount < ticks) {
/* 71 */       return 20.0D;
/*    */     }
/* 73 */     int target = (TickCount - 1 - ticks) % Ticks.length;
/* 74 */     long elapsed = System.currentTimeMillis() - Ticks[target];
/* 75 */     if (ticks / (elapsed / 1000.0D) > 20.0D) {
/* 76 */       return 20.0D;
/*    */     }
/* 78 */     return ticks / (elapsed / 1000.0D);
/*    */   }
/*    */   
/*    */   public static double getElapsed(int tickID)
/*    */   {
/* 83 */     if (TickCount - tickID >= Ticks.length) {
/* 84 */       return (TickCount - tickID) * getTPS();
/*    */     }
/* 86 */     long time = Ticks[(tickID % Ticks.length)];
/* 87 */     return System.currentTimeMillis() - time;
/*    */   }
/*    */   
/*    */   public void run()
/*    */   {
/* 92 */     Ticks[(TickCount % Ticks.length)] = System.currentTimeMillis();
/*    */     
/* 94 */     TickCount += 1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\Lag.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */