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
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ 
/*    */ public class Resouper implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onKill(PlayerDeathEvent e)
/*    */   {
/* 18 */     if ((e.getEntity().getKiller() instanceof Player))
/*    */     {
/* 20 */       Player k = e.getEntity().getKiller();
/* 21 */       if (KitAPI.getkit(k) == "Resouper") {
/* 22 */         k.getInventory().remove(Material.BOWL);
/*    */         try
/*    */         {
/* 25 */           for (int i = 0; i < 34; i++) {
/* 26 */             k.getInventory().setItem(k.getInventory().firstEmpty(), new ItemStack(Material.MUSHROOM_SOUP));
/*    */           }
/*    */         }
/*    */         catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException) {}
/* 30 */         k.sendMessage("§a§lVocê foi resoupado");
/* 31 */         k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
/* 32 */         return;
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Resouper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */