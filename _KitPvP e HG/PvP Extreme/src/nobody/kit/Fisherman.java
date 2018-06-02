/*    */ package nobody.kit;
/*    */ 
/*    */ import nobody.eventos.KitAPI;

import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerFishEvent;
/*    */ 
/*    */ public class Fisherman
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Pescar(PlayerFishEvent e)
/*    */   {
/* 15 */     Player p = e.getPlayer();
/* 16 */     if (((e.getCaught() instanceof Player)) && (KitAPI.getkit(p) == "Fisherman")) {
/* 17 */       Player t = (Player)e.getCaught();
/* 18 */       t.teleport(p);
/* 19 */       e.setCancelled(false);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Fisherman.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */