/*    */ package nobody.kit;
/*    */ 

		import nobody.eventos.KitAPI;
		import nobody.main.Main;

/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ 
/*    */ public class Thor implements org.bukkit.event.Listener
/*    */ {
/*    */   public Main plugin;
/*    */   
/*    */   @EventHandler
/*    */   public void onPlayerThor(PlayerInteractEvent e)
/*    */   {
/* 23 */     final Player p = e.getPlayer();
/* 24 */     if (e.getAction() != org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK) {
/* 25 */       return;
/*    */     }
/* 27 */     if ((p.getItemInHand().getType() == Material.STONE_AXE) && (KitAPI.getkit(p) == "Thor")) {
/* 28 */       if (KitAPI.cooldown.contains(p.getName())) {
/* 29 */         e.setCancelled(true);
/* 30 */         p.sendMessage("§7[§6§l!§7] §cAguarde o Cooldown");
/* 31 */         return;
/*    */       }
/* 33 */       e.setCancelled(true);
/* 34 */       Block b = e.getClickedBlock();
/* 35 */       World w = p.getWorld();
/* 36 */       w.spawnEntity(w.getHighestBlockAt(b.getLocation()).getLocation(), org.bukkit.entity.EntityType.LIGHTNING);
/* 37 */       KitAPI.cooldown.add(p.getName());
/* 38 */       org.bukkit.Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
/*    */         public void run() {
/* 40 */           KitAPI.cooldown.remove(p.getName());
/* 41 */           p.sendMessage("§7[§6§l!§7] §aVocê saiu do Cooldown!");
/*    */         }
/* 43 */       }, 100L);
/* 44 */       return;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Thor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */