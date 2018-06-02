/*    */ package nobody.kit;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;

import nobody.eventos.KitAPI;

/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class Kangaroo implements org.bukkit.event.Listener
/*    */ {
/* 19 */   private HashMap<Player, Integer> jumpinho = new HashMap<Player, Integer>();
/* 20 */   public static ArrayList<Player> kangarinho = new ArrayList<Player>();
/*    */   
/*    */   @EventHandler
/*    */   public void interact(PlayerInteractEvent e) {
/* 24 */     Player p = e.getPlayer();
/* 25 */     if ((KitAPI.getkit(p) == "Kangaroo") && (p.getItemInHand().getType() == Material.FIREWORK)) {
/* 26 */       e.setCancelled(true);
/* 27 */       if (!this.jumpinho.containsKey(p)) {
/* 28 */         if (!p.isSneaking()) {
/* 29 */           if (!((CraftPlayer)p).getHandle().onGround) {
/* 30 */             this.jumpinho.put(p, Integer.valueOf(1));
/* 31 */             p.setVelocity(new Vector(p.getVelocity().getX(), 1.0D, p.getVelocity().getZ()));
/*    */           } else {
/* 33 */             p.setVelocity(new Vector(p.getVelocity().getX(), 1.0D, p.getVelocity().getZ()));
/*    */           }
/* 35 */         } else if (!((CraftPlayer)p).getHandle().onGround) {
/* 36 */           p.setVelocity(p.getLocation().getDirection().multiply(1.2D));
/* 37 */           p.setVelocity(new Vector(p.getVelocity().getX(), 0.5D, p.getVelocity().getZ()));
/* 38 */           this.jumpinho.put(p, Integer.valueOf(1));
/*    */         } else {
/* 40 */           p.setVelocity(p.getLocation().getDirection().multiply(1.2D));
/* 41 */           p.setVelocity(new Vector(p.getVelocity().getX(), 0.5D, p.getVelocity().getZ()));
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void landed(PlayerMoveEvent e) {
/* 49 */     if ((e.getPlayer().getLocation().getBlock().getRelative(org.bukkit.block.BlockFace.DOWN).getType() != Material.AIR) && 
/* 50 */       (this.jumpinho.containsKey(e.getPlayer()))) {
/* 51 */       this.jumpinho.remove(e.getPlayer());
/*    */     }
/*    */   }
/*    */   
/*    */   @SuppressWarnings("deprecation")
@EventHandler
/*    */   public void poucodano(EntityDamageEvent e) {
/* 57 */     if ((e.getEntity() instanceof Player)) {
/* 58 */       Player p = (Player)e.getEntity();
/* 59 */       if (KitAPI.getkit(p) == "Kangaroo") {
/* 60 */         if (e.getDamage() > 7.0D) {
/* 61 */           e.setDamage(7);
/*    */         } else {
/* 63 */           e.setDamage(e.getDamage());
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Kangaroo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */