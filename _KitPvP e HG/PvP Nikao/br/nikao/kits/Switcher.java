/*    */ package br.nikao.kits;
/*    */ 
/*    */ import br.nikao.outros.KitAPI;
/*    */ import org.bukkit.Effect;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.entity.Snowball;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ 
/*    */ public class Switcher implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Kits(EntityDamageByEntityEvent e)
/*    */   {
/* 23 */     if (((e.getDamager() instanceof Snowball)) && 
/* 24 */       ((e.getEntity() instanceof Player)))
/*    */     {
/* 26 */       Snowball s = (Snowball)e.getDamager();
/* 27 */       if ((s.getShooter() instanceof Player))
/*    */       {
/* 29 */         Player shooter = (Player)s.getShooter();
/* 30 */         if (KitAPI.getkit(shooter) == "Switcher") {
/* 31 */           org.bukkit.Location shooterLoc = shooter.getLocation();
/* 32 */           shooter.teleport(e.getEntity().getLocation());
/* 33 */           e.getEntity().teleport(shooterLoc);
/* 34 */           shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.ENDER_SIGNAL, 10);
/* 35 */           shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.EXTINGUISH, 10);
/* 36 */           shooter.getWorld().playSound(shooter.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.2F);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void Kits2(PlayerDeathEvent e) {
/* 44 */     Player p = e.getEntity();
/* 45 */     if (((e.getEntity() instanceof Player)) && ((e.getEntity().getKiller() instanceof Player))) {
/* 46 */       Player k = e.getEntity().getKiller();
/* 47 */       if (KitAPI.getkit(k) == "Switcher") {
/* 48 */         k.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
/* 49 */         k.getInventory().addItem(new ItemStack[] { new ItemStack(Material.SNOW_BALL, 16) });
/* 50 */         k.sendMessage("§7§lForam adicionados 16 Bolas de neve por você ter matado: §e" + p.getName());
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Switcher.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */