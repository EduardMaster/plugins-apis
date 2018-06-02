/*    */ package br.nikao.outros;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class Bussula implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onCompass(PlayerInteractEvent event)
/*    */   {
/* 20 */     Player p = event.getPlayer();
/* 21 */     if ((p.getItemInHand().getType() == Material.COMPASS) && (KitAPI.getkit(p) != "Nenhum") && ((event.getAction() == Action.LEFT_CLICK_AIR) || (event.getAction() == Action.LEFT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_AIR))) {
/* 22 */       Boolean found = Boolean.valueOf(false);
/* 23 */       for (int i = 0; i < 250; i++) {
/* 24 */         List<Entity> entities = p.getNearbyEntities(i, 128.0D, i);
/* 25 */         for (Object e : entities) {
/* 26 */           if ((((Entity)e).getType().equals(EntityType.PLAYER)) && (p.getLocation().distance(((Entity)e).getLocation()) > 0.0D)) {
/* 27 */             p.setCompassTarget(((Entity)e).getLocation());
/* 28 */             p.sendMessage("§3§l» §7§lBússola apontando para: §e" + ((Player)e).getName());
/* 29 */             found = Boolean.valueOf(true);
/* 30 */             break;
/*    */           }
/*    */         }
/* 33 */         if (found.booleanValue()) {
/*    */           break;
/*    */         }
/*    */       }
/* 37 */       if (!found.booleanValue()) {
/* 38 */         p.sendMessage("§3§l» §cNenhum jogador encontrado");
/* 39 */         p.setCompassTarget(new Location(p.getWorld(), 0.0D, 120.0D, 0.0D));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\Bussula.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */