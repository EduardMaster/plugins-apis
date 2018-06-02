/*    */ package br.nikao.kits;
/*    */ 
/*    */ import br.nikao.outros.KitAPI;
/*    */ import java.util.Random;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class Viper implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Kits(EntityDamageByEntityEvent e)
/*    */   {
/* 19 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
/* 20 */       Player p = (Player)e.getEntity();
/* 21 */       Player t = (Player)e.getDamager();
/* 22 */       if ((KitAPI.getkit(t) == "Viper") && (t.getItemInHand().getType() == Material.STONE_SWORD) && 
/* 23 */         (new Random().nextInt(100) <= 25)) {
/* 24 */         p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Viper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */