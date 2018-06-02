/*    */ package neero.demon.comandos;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.command.ConsoleCommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class Tp implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 19 */     if (cmd.getName().equalsIgnoreCase("tp"))
/*    */     {
/* 21 */       if ((sender instanceof ConsoleCommandSender))
/*    */       {
/* 23 */         System.out.println("Console nao pode usar esse comando");
/* 24 */         return true;
/*    */       }
/* 26 */       Player p = (Player)sender;
/* 27 */       if (args.length == 0) {
/* 28 */         p.sendMessage(ChatColor.RED + "Sintaxe Incorreta."); } else { int j;
/* 29 */         if (args.length == 1)
/*    */         {
/* 31 */           if ((p.hasPermission("fire.tp")) || (p.isOp()))
/*    */           {
/* 33 */             Player targetPlayer = p.getServer().getPlayer(args[0]);
/* 34 */             Location tpLoc = targetPlayer.getLocation();
/* 35 */             p.teleport(tpLoc);
/* 36 */             Player[] arrayOfPlayer1; j = (arrayOfPlayer1 = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player s = arrayOfPlayer1[i];
/* 37 */               if (s.hasPermission("fire.tp")) {
/* 38 */                 s.playSound(s.getLocation(), Sound.ANVIL_USE, 5.0F, 5.0F);
/* 39 */                 s.sendMessage("§bO Staff §f" + p.getName() + "§b Se teleportou para " + "§f" + targetPlayer.getDisplayName());
/*    */               }
/*    */             }
/*    */           }
/*    */           else
/*    */           {
/* 45 */             p.sendMessage("sem permissao");
/*    */           }
/*    */         }
/* 48 */         else if (args.length == 2)
/* 49 */           if ((p.hasPermission("fire.tp")) || (p.isOp()))
/*    */           {
/* 51 */             Player targetPlayer = p.getServer().getPlayer(args[0]);
/* 52 */             Player targetPlayer2 = p.getServer().getPlayer(args[1]);
/* 53 */             if ((targetPlayer == null) || (targetPlayer2 == null))
/*    */             {
/* 55 */               p.sendMessage("§4§oJogador Offline!");
/*    */             }
/*    */             else
/*    */             {
/* 59 */               Location tpLoc = targetPlayer2.getLocation();
/* 60 */               targetPlayer.teleport(tpLoc);
/* 61 */               Player[] arrayOfPlayer2; int k = (arrayOfPlayer2 = Bukkit.getOnlinePlayers()).length; for (j = 0; j < k; j++) { Player s = arrayOfPlayer2[j];
/* 62 */                 if (s.hasPermission("fire.tp")) {
/* 63 */                   s.playSound(s.getLocation(), Sound.ANVIL_USE, 5.0F, 5.0F);
/* 64 */                   s.sendMessage("§bO §f" + targetPlayer.getDisplayName() + " §bfoi teleportado para o Staff " + "§f" + targetPlayer2.getDisplayName());
/*    */                 }
/*    */               }
/*    */             }
/*    */           }
/*    */           else
/*    */           {
/* 71 */             p.sendMessage("Sem permissao");
/*    */           }
/*    */       }
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\commands\Tp.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */