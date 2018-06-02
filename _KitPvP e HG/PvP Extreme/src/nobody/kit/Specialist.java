/*    */ package nobody.kit;
/*    */ 
/*    */ import nobody.eventos.KitAPI;

import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class Specialist implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Clicar(PlayerInteractEvent e)
/*    */   {
/* 17 */     Player p = e.getPlayer();
/* 18 */     if ((e.getMaterial() == Material.BOOK) && (e.getItem().getType() == Material.BOOK) && (KitAPI.getkit(p) == "Specialist")) {
/* 19 */       p.openEnchanting(p.getLocation(), true);
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void Matar(PlayerDeathEvent e) {
/* 25 */     Player p = e.getEntity();
/* 26 */     Player t = e.getEntity().getKiller();
/* 27 */     if (((p instanceof Player)) && ((t instanceof Player)) && 
/* 28 */       (KitAPI.getkit(t) == "Specialist")) {
/* 29 */       t.sendMessage("§7[§6§l!§7] §6Você ganhou um de XP, por matar §c" + p.getName());
/* 30 */       t.getInventory().setItem(8, new ItemStack(Material.EXP_BOTTLE));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Specialist.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */