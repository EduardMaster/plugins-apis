/*    */ package neero.demon.comandos;
/*    */ 
/*    */ /*    */ import java.util.ArrayList;
/*    */ import java.util.List;

import neero.demon.Main;

/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Inventario
/*    */   implements CommandExecutor, Listener
/*    */ {
/*    */   Main main;
/* 20 */   public static final List<Player> admin = new ArrayList();
/*    */   
/*    */   public Inventario(Main plugin)
/*    */   {
/* 24 */     plugin = this.main;
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
/*    */   {
/* 29 */     if (!(sender instanceof Player))
/*    */     {
/* 31 */       sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
/* 32 */       return false;
/*    */     }
/* 34 */     Player p = (Player)sender;
/* 35 */     if (commandLabel.equalsIgnoreCase("inv")) {
/* 36 */       if (p.hasPermission("weak.inv"))
/*    */       {
/* 38 */         if (args.length == 0)
/*    */         {
/* 40 */           p.sendMessage(ChatColor.GOLD + " Utilize >> " + ChatColor.GRAY + "/inv <Player>");
/*    */         }
/* 42 */         else if (args.length == 1)
/*    */         {
/* 44 */           Player target = p.getServer().getPlayer(args[0]);
/* 45 */           if (target != null) {
/* 46 */             p.sendMessage(ChatColor.GOLD + " Observando >> " + ChatColor.GRAY + target.getName());
/* 47 */             p.openInventory(target.getInventory());
/*    */           } else {
/* 49 */             p.sendMessage(ChatColor.RED + "Jogador " + args[0] + 
/* 50 */               "inexistente.");
/*    */           }
/*    */         }
/*    */         else
/*    */         {
/* 55 */           p.sendMessage(ChatColor.GOLD + "Utilize >> " + ChatColor.GRAY + "/inv <Player>");
/*    */         }
/*    */       }
/*    */       else {
/* 59 */         p.sendMessage(ChatColor.RED + 
/* 60 */           " Voce nao tem permissao para isso!");
/*    */       }
/*    */     }
/*    */     
/* 64 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\commands\Inventario.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */