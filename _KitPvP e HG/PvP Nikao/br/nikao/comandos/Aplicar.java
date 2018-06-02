/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class Aplicar implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 14 */     Player p = (Player)sender;
/* 15 */     if (args.length == 0) {
/* 16 */       p.sendMessage(Main.getInstance().getConfig().getString("LinkDoFormulario").replace("&", "§"));
/*    */     }
/* 18 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\Aplicar.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */