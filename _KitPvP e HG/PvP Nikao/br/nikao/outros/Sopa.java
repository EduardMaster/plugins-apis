/*    */ package br.nikao.outros;
/*    */ 
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Damageable;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class Sopa implements org.bukkit.event.Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void SopaBeber(PlayerInteractEvent e)
/*    */   {
/* 17 */     Player p = e.getPlayer();
/* 18 */     if (e.getMaterial() == Material.MUSHROOM_SOUP) {
/* 19 */       Damageable d = p;
/* 20 */       if (d.getHealth() != d.getMaxHealth()) {
/* 21 */         if (d.getHealth() > d.getMaxHealth() - 7.0D) {
/* 22 */           d.setHealth(d.getMaxHealth());
/*    */         } else {
/* 24 */           d.setHealth(d.getHealth() + 7.0D);
/*    */         }
/* 26 */         p.playSound(p.getLocation(), Sound.DRINK, 1.0F, 1.0F);
/* 27 */         p.getItemInHand().setType(Material.BOWL);
/* 28 */         p.getItemInHand().setAmount(1);
/* 29 */         ItemMeta m = p.getItemInHand().getItemMeta();
/* 30 */         m.setDisplayName("§f§l» §6Pote");
/* 31 */         p.updateInventory();
/* 32 */         if (KitAPI.getkit(p) == "QuickDropper") {
/* 33 */           p.setItemInHand(null);
/* 34 */           p.getWorld().dropItem(p.getEyeLocation(), new ItemStack(Material.BOWL));
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\Sopa.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */