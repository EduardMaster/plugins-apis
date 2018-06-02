/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class TogglePvP implements org.bukkit.command.CommandExecutor, org.bukkit.event.Listener
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 12 */     if (!(sender instanceof Player)) {
/* 13 */       sender.sendMessage("§7[§cErro§7] §cApenas jogadores podem executar esse comando");
/* 14 */       return true;
/*    */     }
/* 16 */     Player p = (Player)sender;
/* 17 */     if ((cmd.getName().equalsIgnoreCase("togglepvp")) && ((p.hasPermission("ng.pvp")) || (p.isOp()))) {
/* 18 */       if (p.getWorld().getPVP()) {
/* 19 */         p.getWorld().setPVP(false);
/* 20 */         org.bukkit.Bukkit.getServer().broadcastMessage("§4§lATENÇÃO: §7§lAgora o pvp do servidor está: §cDesativado");
/* 21 */         return true;
/*    */       }
/* 23 */       p.getWorld().setPVP(true);
/* 24 */       org.bukkit.Bukkit.getServer().broadcastMessage("§4§lATENÇÃO: §7§lAgora o pvp do servidor está: §aAtivado");
/* 25 */       return true;
/*    */     }
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\TogglePvP.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */