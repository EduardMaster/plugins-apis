/*    */ package br.nikao.kits;
/*    */ 
/*    */ import br.nikao.outros.KitAPI;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class Kangaroo implements org.bukkit.event.Listener
/*    */ {
/* 21 */   ArrayList<Player> kangaroo = new ArrayList();
/* 22 */   static List<Player> kanguru = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void Kits(PlayerInteractEvent e) {
/* 26 */     Player p = e.getPlayer();
/* 27 */     if ((p.getItemInHand().getType() == Material.FIREWORK) && (KitAPI.getkit(p) == "Kangaroo")) {
/* 28 */       if ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_AIR)) {
/* 29 */         e.setCancelled(true);
/*    */       }
/* 31 */       if (!kanguru.contains(p)) {
/* 32 */         if (!p.isSneaking()) {
/* 33 */           p.setFallDistance(-3.0F);
/* 34 */           Vector vector = p.getEyeLocation().getDirection();
/* 35 */           vector.multiply(0.3F);
/* 36 */           vector.setY(1.0F);
/* 37 */           p.setVelocity(vector);
/*    */         } else {
/* 39 */           p.setFallDistance(-3.0F);
/* 40 */           Vector vector = p.getEyeLocation().getDirection();
/* 41 */           vector.multiply(1.1F);
/* 42 */           vector.setY(0.5D);
/* 43 */           p.setVelocity(vector);
/*    */         }
/* 45 */         kanguru.add(p);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void Kits(PlayerMoveEvent e) {
/* 52 */     Player p = e.getPlayer();
/* 53 */     if (kanguru.contains(p)) {
/* 54 */       Block b = p.getLocation().getBlock();
/* 55 */       if ((b.getType() != Material.AIR) || 
/* 56 */         (b.getRelative(org.bukkit.block.BlockFace.DOWN).getType() != Material.AIR)) {
/* 57 */         kanguru.remove(p);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void Kits(EntityDamageEvent e) {
/* 64 */     if ((e instanceof Player)) {
/* 65 */       Player p = (Player)e;
/* 66 */       if (((e.getEntity() instanceof Player)) && 
/* 67 */         (e.getCause() == EntityDamageEvent.DamageCause.FALL) && 
/* 68 */         (p.getInventory().contains(Material.FIREWORK)) && 
/* 69 */         (e.getDamage() >= 12.0D)) {
/* 70 */         e.setDamage(12.0D);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Kangaroo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */