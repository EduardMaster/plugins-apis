/*    */ package br.nikao.kits;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import net.minecraft.server.v1_7_R4.EntityPlayer;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*    */ 
/*    */ public class Stomper implements org.bukkit.event.Listener
/*    */ {
/* 17 */   static java.util.List<Player> cooldown = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void stomperEvent(EntityDamageEvent e) {
/* 21 */     if (!(e.getEntity() instanceof Player)) {
/* 22 */       return;
/*    */     }
/* 24 */     Player p = (Player)e.getEntity();
/* 25 */     if (e.getCause() != EntityDamageEvent.DamageCause.FALL) {
/* 26 */       e.getDamage();
/* 27 */       return;
/*    */     }
/* 29 */     if (br.nikao.outros.KitAPI.getkit(p) != "Stomper") {
/* 30 */       return;
/*    */     }
/* 32 */     if (e.getDamage() > 8.0D) {
/* 33 */       e.setDamage(8.0D);
/*    */     }
/* 35 */     for (Entity stompada : p.getNearbyEntities(5.0D, 5.0D, 5.0D)) {
/* 36 */       if (!(stompada instanceof Player)) {
/* 37 */         return;
/*    */       }
/* 39 */       if (!((Player)stompada).isSneaking()) {
/* 40 */         ((Player)stompada).damage(p.getFallDistance(), p);
/* 41 */         Player st = (Player)stompada;
/* 42 */         EntityPlayer p2 = ((CraftPlayer)st).getHandle();
/* 43 */         if (p2.getHealth() - p.getFallDistance() < 1.0F) {
/* 44 */           Location loc = p.getLocation();
/* 45 */           p.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, -5.0F);
/* 46 */           p.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, -3.0F);
/* 47 */           p.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, -1.0F);
/* 48 */           p.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, 1.0F);
/* 49 */           p.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, 3.0F);
/* 50 */           p.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, 5.0F);
/*    */         }
/*    */       } else {
/* 53 */         ((Player)stompada).damage(p.getFallDistance() / 3.0F, p);
/* 54 */         Player st = (Player)stompada;
/* 55 */         EntityPlayer p3 = ((CraftPlayer)st).getHandle();
/* 56 */         if (p3.getHealth() - p.getFallDistance() / 4.0F < 1.0F) {
/* 57 */           Location loc = p.getLocation();
/* 58 */           p.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, -5.0F);
/* 59 */           p.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, -3.0F);
/* 60 */           p.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, -1.0F);
/* 61 */           p.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, 1.0F);
/* 62 */           p.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, 3.0F);
/* 63 */           p.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, 5.0F);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Stomper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */