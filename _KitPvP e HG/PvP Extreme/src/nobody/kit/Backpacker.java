/*    */ package nobody.kit;
/*    */ 

/*    */ import java.util.ArrayList;
/*    */ import java.util.List;

import nobody.eventos.KitAPI;
import nobody.main.Main;

/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class Backpacker implements Listener
/*    */ {
/* 22 */   @SuppressWarnings({ "unchecked", "rawtypes" })
static List<String> cooldownbk = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void backpackerKit(PlayerInteractEvent event)
/*    */   {
/* 27 */     final Player p = event.getPlayer();
/* 28 */     ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
/* 29 */     ItemMeta sopas = sopa.getItemMeta();
/* 30 */     sopas.setDisplayName("§6Sopa");
/* 31 */     sopa.setItemMeta(sopas);
/* 32 */     if ((p.getItemInHand().getType() == Material.CHEST) && (KitAPI.getkit(p) == "Backpacker")) {
/* 33 */       if ((event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_AIR))
/* 34 */         event.setCancelled(true);
/* 35 */       if (cooldownbk.contains(p))
/*    */       {
/* 37 */         p.sendMessage("§7[§6§l!§7] §cBackpacker está em cooldown aguarde");
/*    */       }
/*    */       else
/*    */       {
/* 41 */         Inventory v = Bukkit.createInventory(null, 27, "§e§nBackpacker");
/* 42 */         for (int i = 0; i < 27; i++) {
/* 43 */           v.addItem(new ItemStack[] { new ItemStack(sopa) });
/*    */         }
/* 45 */         event.getPlayer().openInventory(v);
/* 46 */         cooldownbk.add(p.getName());
/* 47 */         Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
/*    */           public void run() {
/* 49 */             Backpacker.cooldownbk.remove(p);
/*    */           }
/*    */           
/* 52 */         }, 750L);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Backpacker.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */