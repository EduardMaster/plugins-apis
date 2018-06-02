/*    */ package nobody.kit;
/*    */ 
/*    */ import java.util.Random;

import nobody.eventos.KitAPI;

/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ 
/*    */ public class Snail implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Bater(EntityDamageByEntityEvent e)
/*    */   {
/* 19 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
/* 20 */       Player p = (Player)e.getEntity();
/* 21 */       Player t = (Player)e.getDamager();
/* 22 */       if ((KitAPI.getkit(t) == "Snail") && (t.getItemInHand().getType() == Material.WOOD_SWORD) && 
/* 23 */         (new Random().nextInt(100) <= 25)) {
/* 24 */         p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 0, true));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Snail.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */