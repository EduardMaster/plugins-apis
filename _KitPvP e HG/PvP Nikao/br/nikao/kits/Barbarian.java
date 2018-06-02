/*    */ package br.nikao.kits;
/*    */ 
/*    */ import br.nikao.outros.KitAPI;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
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
/* 17 */     if ((e.getEntity().getKiller() instanceof Player)) {
/* 18 */       Player k = e.getEntity().getKiller();
/* 19 */       if (KitAPI.getkit(k) == "Barbarian") {
/* 20 */         if (k.getItemInHand().getType() == Material.WOOD_SWORD) {
/* 21 */           k.setItemInHand(new ItemStack(Material.STONE_SWORD));
/* 22 */           k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
/* 23 */           k.sendMessage("§f§lUPGRADE: §aSua espada está evoluindo....");
/* 24 */         } else if (k.getItemInHand().getType() == Material.STONE_SWORD) {
/* 25 */           k.setItemInHand(new ItemStack(Material.IRON_SWORD));
/* 26 */           k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
/* 27 */           k.sendMessage("§f§lUPGRADE: §aSua espada está no modo maximo !");
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Barbarian.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */