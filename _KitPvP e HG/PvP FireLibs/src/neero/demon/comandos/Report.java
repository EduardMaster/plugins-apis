/*    */ package neero.demon.comandos;
/*    */ 
/*    */ /*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;

import neero.demon.Main;

/*    */ import org.apache.commons.lang.StringUtils;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Report
/*    */   implements CommandExecutor
/*    */ {
/* 22 */   public static ArrayList<String> reported = new ArrayList();
/*    */   
/*    */   private Main plugin;
/*    */   
/*    */   public Report(Main plugin)
/*    */   {
/* 28 */     this.plugin = plugin;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
/*    */   {
/* 34 */     final Player p = (Player)sender;
/* 35 */     if (!(sender instanceof Player))
/*    */     {
/* 37 */       sender.sendMessage("§cVoce nao e um jogador!");
/* 38 */       return false;
/*    */     }
/* 40 */     if (commandLabel.equalsIgnoreCase("report")) {
/* 41 */       if (args.length >= 2)
/*    */       {
/* 43 */         Player target = p.getServer().getPlayer(args[0]);
/* 44 */         if (target != null)
/*    */         {
/* 46 */           if (reported.contains(p.getName()))
/*    */           {
/* 48 */             p.sendMessage("§cCalma extressado , ja tem um staff olhando");
/* 49 */             return true;
/*    */           }
/* 51 */           String reportMsg = StringUtils.join(
/* 52 */             Arrays.copyOfRange(args, 1, args.length), " ");
/* 53 */           reported.add(p.getName());
/* 54 */           p.sendMessage("§8Voce reportou o §b" + target.getName() + "§8 por §b" + reportMsg);
/* 55 */           Player[] arrayOfPlayer; int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player s = arrayOfPlayer[i];
/* 56 */             if (s.hasPermission("fire.verreport")) {
/* 57 */               s.playSound(s.getLocation(), Sound.ANVIL_USE, 15.0F, 1.0F);
/* 58 */               s.sendMessage(ChatColor.RED + "-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
/* 59 */               s.sendMessage("§6§lPlayer reportado > §f§l" + target.getName() + " \n§6§lMotivo > §f§l " + reportMsg + "\n§6§lReporter >§f§l " + p.getName());
/* 60 */               s.sendMessage(ChatColor.RED + "-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
/* 61 */               Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*    */               {
/*    */                 public void run()
/*    */                 {
/* 65 */                   Report.reported.remove(p.getName());
/*    */                 }
/* 67 */               }, 250L);
/*    */             }
/*    */           }
/*    */         }
/*    */         else
/*    */         {
/* 73 */           p.sendMessage("Jogador " + args[0] + " nao esta online.");
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 78 */         p.sendMessage("§cArgumentos insuficientes. Use: /" + commandLabel + " <jogador> <motivo>");
/*    */       }
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\commands\Report.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */