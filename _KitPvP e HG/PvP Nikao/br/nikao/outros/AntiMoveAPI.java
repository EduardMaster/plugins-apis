/*    */ package br.nikao.outros;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class AntiMoveAPI
/*    */   implements Listener
/*    */ {
/* 13 */   public static ArrayList<String> AntiMove1 = new ArrayList();
/* 14 */   public static ArrayList<String> AntiMove2 = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void Andar(PlayerMoveEvent e) {
/* 18 */     Player p = e.getPlayer();
/* 19 */     if (AntiMove1.contains(p.getName())) e.setCancelled(true);
/* 20 */     if (AntiMove2.contains(p.getName())) {
/* 21 */       p.setVelocity(new Vector(0.0D, -2.0D, 0.0D));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\AntiMoveAPI.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */