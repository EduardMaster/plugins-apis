/*    */ package br.nikao.gui;
/*    */ 
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class Status implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Clicar(PlayerInteractEvent e)
/*    */   {
/* 16 */     Player p = e.getPlayer();
/* 17 */     if ((e.getMaterial() == Material.ENCHANTED_BOOK) && (e.getItem().getType() == Material.ENCHANTED_BOOK) && (br.nikao.outros.KitAPI.getkit(p) == "Nenhum")) {
/* 18 */       p.playSound(p.getLocation(), Sound.CLICK, 2.0F, 2.0F);
/* 19 */       p.chat("/regras");
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\gui\Status.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */