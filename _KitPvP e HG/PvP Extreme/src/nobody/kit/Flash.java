/*    */ package nobody.kit;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.concurrent.TimeUnit;

import nobody.eventos.KitAPI;

/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.block.BlockFace;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ 
/*    */ public class Flash
/*    */   implements Listener
/*    */ {
/* 20 */   @SuppressWarnings({ "unchecked", "rawtypes" })
public static HashMap<String, Long> cooldown = new HashMap();
/*    */   
/*    */   @EventHandler
/*    */   public void flash(PlayerInteractEvent e)
/*    */   {
/* 25 */     Player p = e.getPlayer();
/* 26 */     if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
/* 27 */       (KitAPI.getkit(p) == "Flash") && 
/* 28 */       (p.getItemInHand().getType() == Material.REDSTONE_TORCH_ON)) {
/* 29 */       if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis()))
/*    */       {
/* 31 */         e.setCancelled(true);
/* 32 */         p.updateInventory();
/*    */         
/* 34 */         @SuppressWarnings("deprecation")
Block b = p.getTargetBlock(null, 100).getRelative(BlockFace.UP);
/* 35 */         p.teleport(b.getLocation());
/* 36 */         p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 10.0F, 10.0F);
/* 37 */         cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20L)));
/* 38 */         return;
/*    */       }
/* 40 */       p.sendMessage("§7[§6§l!§7] §cFlash em cooldown, Falta " + TimeUnit.MILLISECONDS.toSeconds(((Long)cooldown.get(p.getName())).longValue() - System.currentTimeMillis()) + "§c segundos para vocÃª poder usa-lo novamente");
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Flash.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */