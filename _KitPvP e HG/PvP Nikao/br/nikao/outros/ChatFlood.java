/*    */ package br.nikao.outros;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.AsyncPlayerChatEvent;
/*    */ 
/*    */ 
/*    */ public class ChatFlood
/*    */   implements Listener
/*    */ {
/* 14 */   private Map<String, Long> timeout = new HashMap();
/*    */   
/*    */   @EventHandler
/*    */   public void onChat(AsyncPlayerChatEvent e) {
/* 18 */     Player p = e.getPlayer();
/* 19 */     if ((this.timeout.containsKey(p.getName())) && (((Long)this.timeout.get(p.getName())).longValue() > System.currentTimeMillis())) {
/* 20 */       e.setCancelled(true);
/* 21 */       p.sendMessage("§cSem flood.");
/* 22 */       return;
/*    */     }
/* 24 */     this.timeout.put(p.getName(), Long.valueOf(System.currentTimeMillis() + 2500L));
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\ChatFlood.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */