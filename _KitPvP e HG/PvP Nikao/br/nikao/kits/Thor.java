/*    */ package br.nikao.kits;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import br.nikao.outros.KitAPI;
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class Thor implements org.bukkit.event.Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onPlayerThor(PlayerInteractEvent e)
/*    */   {
/* 21 */     final Player p = e.getPlayer();
/* 22 */     if (e.getAction() != org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK) {
/* 23 */       return;
/*    */     }
/* 25 */     if ((p.getItemInHand().getType() == Material.STONE_AXE) && (KitAPI.getkit(p) == "Thor")) {
/* 26 */       if (KitAPI.cooldown.contains(p.getName())) {
/* 27 */         e.setCancelled(true);
/* 28 */         p.sendMessage("§cAguarde o Cooldown");
/* 29 */         return;
/*    */       }
/* 31 */       e.setCancelled(true);
/* 32 */       Block b = e.getClickedBlock();
/* 33 */       World w = p.getWorld();
/* 34 */       w.spawnEntity(w.getHighestBlockAt(b.getLocation()).getLocation(), org.bukkit.entity.EntityType.LIGHTNING);
/* 35 */       KitAPI.cooldown.add(p.getName());
/* 36 */       org.bukkit.Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*    */         public void run() {
/* 38 */           KitAPI.cooldown.remove(p.getName());
/* 39 */           p.sendMessage("§aPode usar o thor novamente");
/*    */         }
/* 41 */       }, 100L);
/* 42 */       return;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Thor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */