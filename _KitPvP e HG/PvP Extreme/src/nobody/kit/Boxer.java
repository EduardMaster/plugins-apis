/*    */ package nobody.kit;
/*    */ 
/*    */ import nobody.eventos.KitAPI;
import nobody.main.Main;

import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ 
/*    */ public class Boxer implements Listener
/*    */ {
/*    */   public Main plugin;
/* 15 */   public int DanoBoxer = 10;
/*    */   
/*    */   public Boxer(Main instance) {
/* 18 */     this.plugin = instance;
/*    */   }
/*    */   
/*    */   @SuppressWarnings("deprecation")
@EventHandler
/*    */   public void onEntityDamage(EntityDamageByEntityEvent e)
/*    */   {
/* 24 */     if ((e.getDamager() instanceof Player)) {
/* 25 */       Player boxer = (Player)e.getDamager();
/* 26 */       if ((KitAPI.getkit(boxer) == "Boxer") && (boxer.getItemInHand().getType() == Material.QUARTZ)) {
/* 27 */         e.setDamage(this.DanoBoxer);
/*    */       }
/*    */     }
/* 30 */     if (((e.getEntity() instanceof Player)) && 
/* 31 */       ((e.getDamager() instanceof Player))) {
/* 32 */       Player boxer = (Player)e.getEntity();
/* 33 */       Player player = (Player)e.getDamager();
/* 34 */       if ((KitAPI.getkit(boxer) == "Boxer") && (player.getItemInHand() == null)) {
/* 35 */         e.setDamage(e.getDamage() - 1.0D);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Boxer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */