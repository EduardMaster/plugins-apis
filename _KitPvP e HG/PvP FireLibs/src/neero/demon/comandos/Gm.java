/*    */ package neero.demon.comandos;
/*    */ 
/*    */ import neero.demon.Main;

/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.GameMode;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class Gm
/*    */   implements CommandExecutor
/*    */ {
/*    */   Main main;
/*    */   
/*    */   public Gm(Main plugin)
/*    */   {
/* 19 */     plugin = this.main;
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
/*    */   {
/* 24 */     Player player = (Player)sender;
/* 25 */     if ((cmd.getName().equalsIgnoreCase("gm")) && (sender.hasPermission("fire.gm")))
/*    */     {
/* 27 */       if (args.length != 1)
/*    */       {
/* 29 */         player.sendMessage(ChatColor.RED + "/gm 0 ou 1");
/* 30 */         return true;
/*    */       }
/* 32 */       if (args.length == 1)
/*    */       {
/* 34 */         if (args[0].equalsIgnoreCase("0"))
/*    */         {
/* 36 */           player.setGameMode(GameMode.SURVIVAL);
/* 37 */           player.sendMessage("§4§LGAMEMODE §e§l§oVoce alterou seu modo de jogo para §a§oSurvival §e§l§o!");
/*    */         }
/* 39 */         if (args[0].equalsIgnoreCase("1"))
/*    */         {
/* 41 */           player.setGameMode(GameMode.CREATIVE);
/* 42 */           player.sendMessage("§4§LGAMEMODE §e§l§oVoce alterou seu modo de jogo para §a§oCreative §e§l§o!");
/*    */         }
/* 44 */         return true;
/*    */       }
/*    */     }
/* 47 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\commands\Gm.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */