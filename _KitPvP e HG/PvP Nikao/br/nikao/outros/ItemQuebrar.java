/*    */ package br.nikao.outros;
/*    */ 
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ 
/*    */ public class ItemQuebrar implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Andar(PlayerMoveEvent e)
/*    */   {
/* 16 */     Player p = e.getPlayer();
/* 17 */     ItemStack item1 = p.getItemInHand();
/* 18 */     Material Material1 = Material.getMaterial(item1.getTypeId());
/* 19 */     if ((!Material1.isBlock()) && (Material1.getMaxDurability() >= 1) && 
/* 20 */       (item1.getDurability() != 0)) {
/* 21 */       p.getItemInHand().setDurability((short)0);
/* 22 */       p.updateInventory();
/*    */     }
/*    */     
/* 25 */     PlayerInventory item2 = p.getInventory();
/* 26 */     if (p.getInventory().getHelmet() != null) {
/* 27 */       Material material2 = Material.getMaterial(item2.getHelmet().getTypeId());
/* 28 */       if ((!material2.isBlock()) && (material2.getMaxDurability() >= 1) && 
/* 29 */         (item2.getHelmet().getDurability() != 0)) {
/* 30 */         p.getInventory().getHelmet().setDurability((short)0);
/* 31 */         p.updateInventory();
/*    */       }
/*    */     }
/*    */     
/* 35 */     if (p.getInventory().getChestplate() != null) {
/* 36 */       Material material2 = Material.getMaterial(item2.getChestplate().getTypeId());
/* 37 */       if ((!material2.isBlock()) && (material2.getMaxDurability() >= 1) && 
/* 38 */         (item2.getChestplate().getDurability() != 0)) {
/* 39 */         p.getInventory().getChestplate().setDurability((short)0);
/* 40 */         p.updateInventory();
/*    */       }
/*    */     }
/*    */     
/* 44 */     if (p.getInventory().getLeggings() != null) {
/* 45 */       Material material2 = Material.getMaterial(item2.getLeggings().getTypeId());
/* 46 */       if ((!material2.isBlock()) && (material2.getMaxDurability() >= 1) && 
/* 47 */         (item2.getLeggings().getDurability() != 0)) {
/* 48 */         p.getInventory().getLeggings().setDurability((short)1);
/* 49 */         p.updateInventory();
/*    */       }
/*    */     }
/*    */     
/* 53 */     if (p.getInventory().getBoots() != null) {
/* 54 */       Material material2 = Material.getMaterial(item2.getBoots().getTypeId());
/* 55 */       if ((!material2.isBlock()) && (material2.getMaxDurability() >= 1) && 
/* 56 */         (item2.getBoots().getDurability() != 0)) {
/* 57 */         p.getInventory().getBoots().setDurability((short)0);
/* 58 */         p.updateInventory();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\ItemQuebrar.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */