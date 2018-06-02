/*    */ package nobody.kit;
/*    */ 
/*    */ import java.util.ArrayList;

import nobody.eventos.KitAPI;

/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.EventPriority;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class Stomper implements Listener
/*    */ {
/* 25 */   public static ArrayList<Player> cooldownm = new ArrayList<Player>();
/*    */   
/*    */   @EventHandler(priority=EventPriority.HIGH)
/*    */   public void onPlayerStomp(EntityDamageEvent e) {
/* 29 */     if (!(e.getEntity() instanceof Player)) {
/* 30 */       return;
/*    */     }
/* 32 */     Player p = (Player)e.getEntity();
/* 33 */     if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
/* 34 */       if (KitAPI.getkit(p) == "Stomper") {
/* 35 */         for (Entity ent : p.getNearbyEntities(3.0D, 3.0D, 3.0D)) {
/* 36 */           if ((ent instanceof Player)) {
/* 37 */             Player plr = (Player)ent;
/* 38 */             if (e.getDamage() <= 4.0D) {
/* 39 */               e.setCancelled(true);
/* 40 */               return;
/*    */             }
/* 42 */             if (plr.isSneaking()) {
/* 43 */               plr.damage(6.0D, p);
/* 44 */               plr.sendMessage("§cVoce foi pisoteado por: §6" + p.getName());
/*    */             } else {
/* 46 */               plr.damage(9999.0D, p);
/* 47 */               plr.sendMessage("§cVoce foi pisoteado por: §6" + p.getName());
/*    */             }
/*    */           }
/*    */         }
/* 51 */         e.setDamage(4.0D);
/* 52 */         return;
/*    */       }
/* 54 */       return;
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void stomperApple(PlayerInteractEvent event)
/*    */   {
/* 61 */     final Player p = event.getPlayer();
/* 62 */     if ((event.getPlayer().getItemInHand().getType() == Material.EMERALD_BLOCK) && 
/* 63 */       (KitAPI.getkit(p) == "Stomper")) {
/* 64 */       if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
/* 65 */         (event.getAction() == Action.LEFT_CLICK_BLOCK) || 
/* 66 */         (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
/* 67 */         (event.getAction() == Action.RIGHT_CLICK_AIR)) {
/* 68 */         event.setCancelled(true);
/*    */       }
/* 70 */       if (cooldownm.contains(p)) {
/* 71 */         p.sendMessage("§cAguarde o cooldown acabar!");
/* 72 */         return;
/*    */       }
/* 74 */       Vector vector = p.getEyeLocation().getDirection();
/* 75 */       vector.multiply(0.0F);
/* 76 */       vector.setY(6.0F);
/* 77 */       p.setVelocity(vector);
/* 78 */       Location loc = p.getLocation();
/* 79 */       p.getWorld().playSound(loc, Sound.ENDERMAN_TELEPORT, 5.0F, -5.0F);
/* 80 */       cooldownm.add(p);
/* 81 */       org.bukkit.Bukkit.getScheduler().scheduleSyncDelayedTask(nobody.main.Main.getInstance(), new Runnable()
/*    */       {
/*    */         public void run()
/*    */         {
/* 85 */           Stomper.cooldownm.remove(p);
/* 86 */           p.sendMessage("§7[§6§l!§7] §aVoce Pode Usar Novamente!");
/* 87 */           p.getWorld().playSound(p.getLocation(), Sound.EXPLODE, 5.0F, 5.0F);
/*    */         }
/*    */         
/* 90 */       }, 500L);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Stomper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */