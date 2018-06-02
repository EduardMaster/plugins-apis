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
/*    */ public class Viper implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Bater(EntityDamageByEntityEvent e)
/*    */   {
/* 19 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
/* 20 */       Player p = (Player)e.getEntity();
/* 21 */       Player t = (Player)e.getDamager();
/* 22 */       if ((KitAPI.getkit(t) == "Viper") && (t.getItemInHand().getType() == Material.WOOD_SWORD) && 
/* 23 */         (new Random().nextInt(100) <= 25)) {
/* 24 */         p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Viper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */