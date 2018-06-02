/*    */ package br.nikao.kits;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import br.nikao.outros.KitAPI;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;
/*    */ 
/*    */ public class Magma implements org.bukkit.event.Listener
/*    */ {
/*    */   public static Main plugin;
/*    */   
/*    */   public Magma(Main main)
/*    */   {
/* 20 */     plugin = main;
/*    */   }
/*    */   
/*    */ 
/*    */   public Magma() {}
/*    */   
/*    */   @EventHandler
/*    */   public void viperEvent(EntityDamageByEntityEvent event)
/*    */   {
/* 29 */     if ((!(event.getEntity() instanceof Player)) || 
/* 30 */       (!(event.getDamager() instanceof Player))) {
/* 31 */       return;
/*    */     }
/* 33 */     Player player = (Player)event.getDamager();
/* 34 */     Player player1 = (Player)event.getEntity();
/* 35 */     if (KitAPI.getkit(player) != "Magma") {
/* 36 */       return;
/*    */     }
/* 38 */     if ((Math.random() > 0.4D) && (Math.random() < 0.1D))
/* 39 */       player1.setFireTicks(100);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onPlayerMove(PlayerMoveEvent event1) {
/* 44 */     Player player11 = event1.getPlayer();
/* 45 */     if ((KitAPI.getkit(player11) == "Magma'") && (
/* 46 */       (player11.getLocation().getBlock().getType() == Material.WATER) || (player11.getLocation().getBlock().getType() == Material.STATIONARY_WATER))) {
/* 47 */       player11.addPotionEffect(new org.bukkit.potion.PotionEffect(org.bukkit.potion.PotionEffectType.POISON, 65, 0));
/* 48 */       player11.addPotionEffect(new org.bukkit.potion.PotionEffect(org.bukkit.potion.PotionEffectType.SLOW, 65, 0));
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void damage(EntityDamageEvent e)
/*    */   {
/* 55 */     if ((e.getEntity() instanceof Player)) {
/* 56 */       Player p = (Player)e.getEntity();
/* 57 */       if ((KitAPI.getkit(p) == "Magma") && (
/* 58 */         (e.getCause() == EntityDamageEvent.DamageCause.LAVA) || 
/* 59 */         (e.getCause() == EntityDamageEvent.DamageCause.FIRE) || 
/* 60 */         (e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK))) {
/* 61 */         e.setCancelled(true);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Magma.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */