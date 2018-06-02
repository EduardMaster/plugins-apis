/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
/*    */ import org.bukkit.help.HelpMap;
/*    */ 
/*    */ public class ComandoInexistente implements org.bukkit.event.Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e)
/*    */   {
/* 17 */     if (!e.isCancelled()) {
/* 18 */       Player player = e.getPlayer();
/* 19 */       String cmd = e.getMessage().split(" ")[0];
/* 20 */       org.bukkit.help.HelpTopic topic = org.bukkit.Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
/* 21 */       if (topic == null) {
/* 22 */         player.sendMessage(Main.getInstance().getConfig().getString("ComandoErro").replace("&", "§"));
/* 23 */         player.playSound(player.getLocation(), Sound.EXPLODE, 2.0F, 2.0F);
/* 24 */         e.setCancelled(true);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\ComandoInexistente.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */