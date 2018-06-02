/*    */ package neero.demon.comandos;
/*    */ 
/*    */ import neero.demon.Main;

/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class Fly
/*    */   implements CommandExecutor
/*    */ {
/*    */   private Main plugin;
/*    */   
/*    */   public Fly(Main plugin)
/*    */   {
/* 19 */     this.plugin = plugin;
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 24 */     Player p = (Player)sender;
/* 25 */     if ((cmd.getName().equalsIgnoreCase("fly")) && (cmd.getName().equalsIgnoreCase("voar")) && 
/* 26 */       (p.hasPermission("fire.fly"))) {
/* 27 */       if (args.length == 0)
/*    */       {
/* 29 */         if (!p.getAllowFlight())
/*    */         {
/* 31 */           p.setAllowFlight(true);
/* 32 */           p.sendMessage("§6Fly Ativado para : " + ChatColor.RED + p.getName());
/*    */         }
/*    */         else
/*    */         {
/* 36 */           p.setAllowFlight(false);
/* 37 */           p.sendMessage("§6Fly desativado para : " + ChatColor.RED + p.getName());
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 42 */         Player t = p.getServer().getPlayer(args[0]);
/* 43 */         if (t != null)
/*    */         {
/* 45 */           if (!t.getAllowFlight())
/*    */           {
/* 47 */             t.setAllowFlight(true);
/* 48 */             t.sendMessage("§6Fly Ativado para : " + ChatColor.RED + t.getName());
/*    */           }
/*    */           else
/*    */           {
/* 52 */             t.setAllowFlight(false);
/* 53 */             t.sendMessage("§6Fly desativado para : " + ChatColor.RED + t.getName());
/*    */           }
/*    */         }
/*    */         else {
/* 57 */           p.sendMessage("§4Erro: Jogador inexistente!");
/*    */         }
/*    */       }
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\commands\Fly.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */