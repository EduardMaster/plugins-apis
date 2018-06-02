/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
/*    */ 
/*    */ public class me implements Listener
/*    */ {
/*    */   @org.bukkit.event.EventHandler
/*    */   public void onMe(PlayerCommandPreprocessEvent e)
/*    */   {
/* 12 */     Player p = e.getPlayer();
/* 13 */     if (e.getMessage().toLowerCase().startsWith("/me")) {
/* 14 */       e.setCancelled(true);
/* 15 */       p.sendMessage("§cEste comando foi retirado!");
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\me.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */