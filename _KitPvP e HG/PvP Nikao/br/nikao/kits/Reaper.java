/*    */ package br.nikao.kits;
/*    */ 
/*    */ import br.nikao.outros.KitAPI;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class Reaper implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void OnClick(EntityDamageByEntityEvent e)
/*    */   {
/* 18 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
/*    */     {
/* 20 */       Player damager = (Player)e.getDamager();
/* 21 */       Player victim = (Player)e.getEntity();
/* 22 */       if (KitAPI.getkit(damager) == "Reaper")
/*    */       {
/* 24 */         KitAPI.getkit(damager);
/* 25 */         if (damager.getInventory().getItemInHand().getType() == Material.WOOD_HOE)
/*    */         {
/* 27 */           victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 3));
/* 28 */           return;
/*    */         }
/* 30 */         return;
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Reaper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */