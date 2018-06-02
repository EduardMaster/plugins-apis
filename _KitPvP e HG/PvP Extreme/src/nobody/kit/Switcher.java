/*    */ package nobody.kit;
/*    */ 
/*    */ import nobody.eventos.KitAPI;

import org.bukkit.Effect;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.entity.Snowball;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ 
/*    */ public class Switcher implements Listener
/*    */ {
/*    */   @SuppressWarnings("deprecation")
@EventHandler
/*    */   public void snowball(EntityDamageByEntityEvent e)
/*    */   {
/* 20 */     if (((e.getDamager() instanceof Snowball)) && 
/* 21 */       ((e.getEntity() instanceof Player)))
/*    */     {
/* 23 */       Snowball s = (Snowball)e.getDamager();
/* 24 */       if ((s.getShooter() instanceof Player))
/*    */       {
/* 26 */         Player shooter = (Player)s.getShooter();
/* 27 */         if (KitAPI.getkit(shooter) == "Switcher") {
/* 28 */           Location shooterLoc = shooter.getLocation();
/* 29 */           shooter.teleport(e.getEntity().getLocation());
/* 30 */           e.getEntity().teleport(shooterLoc);
/* 31 */           shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.ENDER_SIGNAL, 10);
/* 32 */           shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.EXTINGUISH, 10);
/* 33 */           shooter.getWorld().playSound(shooter.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.2F);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Switcher.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */