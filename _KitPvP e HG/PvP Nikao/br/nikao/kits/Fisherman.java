/*    */ package br.nikao.kits;
/*    */ 
/*    */ import br.nikao.outros.KitAPI;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerFishEvent;
/*    */ 
/*    */ public class Fisherman implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Pescar(PlayerFishEvent e)
/*    */   {
/* 14 */     Player p = e.getPlayer();
/* 15 */     if (((e.getCaught() instanceof Player)) && (KitAPI.getkit(p) == "Fisherman")) {
/* 16 */       Player t = (Player)e.getCaught();
/* 17 */       t.teleport(p);
/* 18 */       e.setCancelled(false);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Fisherman.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */