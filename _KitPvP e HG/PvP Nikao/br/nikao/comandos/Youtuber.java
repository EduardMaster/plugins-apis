/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public class Youtuber implements Listener, CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 15 */     if (!(sender instanceof Player)) {
/* 16 */       sender.sendMessage("§f[§cErro§f] §cApenas jogadores podem usar isso");
/* 17 */       return true;
/*    */     }
/* 19 */     Player p = (Player)sender;
/* 20 */     if (cmd.getName().equalsIgnoreCase("youtuber")) {}
/* 21 */     p.playSound(p.getLocation(), Sound.BLAZE_HIT, 2.0F, 2.0F);
/* 22 */     p.sendMessage("");
/* 23 */     p.sendMessage("§e§l§m-§6§l§m-§e§l§m-§6§l§m-§e§l§m-§6§l§m-§e§l§m-§6§l§m-§e§l§m-§6§l§m-§e§l§m-§6§l§m-§e§l§m-§6§l§m-§e§l§m-§6§l§m-§e§l§m-§6§l§m-§e§l§m-§6§l§m-§e§l§m-§6§l§m-");
/* 24 */     p.sendMessage("");
/* 25 */     p.sendMessage("§7§lTag §bYoutuber:");
/* 26 */     p.sendMessage(Main.getInstance().getConfig().getString("Youtuber").replace("&", "§"));
/* 27 */     p.sendMessage(" ");
/* 28 */     p.sendMessage("§e§l§m-§6§l§m-§e§l§m-§6§l§m-§e§l§m-§6§l§m-§e§l§m-§6§l§m-§e§l§m-§6§l§m-§e§l§m-§6§l§m-§e§l§m-§6§l§m-§e§l§m-§6§l§m-§e§l§m-§6§l§m-§e§l§m-§6§l§m-§e§l§m-§6§l§m-");
/* 29 */     p.sendMessage(" ");
/* 30 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\Youtuber.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */