/*    */ package nobody.kit;
/*    */ 
/*    */ import nobody.eventos.KitAPI;

import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.enchantments.Enchantment;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class Barbarian implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onKill(PlayerDeathEvent e)
/*    */   {
/* 19 */     if ((e.getEntity().getKiller() instanceof Player)) {
/* 20 */       Player k = e.getEntity().getKiller();
/* 21 */       if (KitAPI.getkit(k) == "Barbarian") {
/* 22 */         if (k.getItemInHand().getType() == Material.WOOD_SWORD) {
/* 23 */           k.setItemInHand(new ItemStack(Material.STONE_SWORD));
/* 24 */           k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
/* 25 */           k.sendMessage(ChatColor.GRAY + "UPGRADE! Level " + ChatColor.WHITE + "1");
/* 26 */         } else if (k.getItemInHand().getType() == Material.STONE_SWORD) {
/* 27 */           k.setItemInHand(new ItemStack(Material.IRON_SWORD));
/* 28 */           k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
/* 29 */           k.sendMessage(ChatColor.GRAY + "UPGRADE! Level " + ChatColor.WHITE + "2");
/* 30 */         } else if (k.getItemInHand().getType() == Material.IRON_SWORD) {
/* 31 */           k.setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
/* 32 */           k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
/* 33 */           k.sendMessage(ChatColor.GRAY + "UPGRADE! Level " + ChatColor.WHITE + "3");
/* 34 */         } else if (k.getItemInHand().getType() == Material.DIAMOND_SWORD) {
/* 35 */           int max = 1;
/* 36 */           if (k.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
/* 37 */             int lvl = k.getItemInHand().getEnchantmentLevel(Enchantment.DAMAGE_ALL);
/* 38 */             if (lvl + 1 <= max) {
/* 39 */               k.getItemInHand().removeEnchantment(Enchantment.DAMAGE_ALL);
/* 40 */               k.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, lvl + 1);
/* 41 */               k.updateInventory();
/* 42 */               k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
/* 43 */               if (lvl + 1 == 1)
/* 44 */                 k.sendMessage(ChatColor.GRAY + "UPGRADE! Level " + ChatColor.WHITE + "5");
/*    */             }
/* 46 */             if (lvl + 1 == 0)
/* 47 */               k.sendMessage("§7[§6§l!§7] §6Você chegou ao level maximo!");
/*    */           } else {
/* 49 */             k.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, 1);
/* 50 */             k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
/* 51 */             k.sendMessage(ChatColor.GRAY + "UPGRADE! Level " + ChatColor.WHITE + "4");
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Barbarian.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */