/*    */ package neero.demon;
/*    */ 
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ 
/*    */ public class clearinventory
/*    */ {
/*    */   public void clearInv(Player p)
/*    */   {
/* 10 */     p.getInventory().clear();
/* 11 */     p.getInventory().setArmorContents(null);
/* 12 */     for (PotionEffect effect : p.getActivePotionEffects()) {
/* 13 */       p.removePotionEffect(effect.getType());
/*    */     }
/*    */   }
/*    */ }


