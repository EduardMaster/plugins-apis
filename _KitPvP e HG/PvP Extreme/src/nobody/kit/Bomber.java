/*    */ package nobody.kit;
/*    */ 
/*    */ import nobody.eventos.KitAPI;

/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.entity.TNTPrimed;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ 
/*    */ public class Bomber implements org.bukkit.event.Listener
/*    */ {
/*    */   public static org.bukkit.craftbukkit.Main plugin;
/* 18 */   public long cooldownLenght = 0L;
/*    */   
/*    */   @EventHandler
/*    */   public void eventBomber(PlayerInteractEvent e) {
/* 22 */     Player p = e.getPlayer();
/* 23 */     if ((p.getItemInHand().getType() == Material.TNT) && (KitAPI.getkit(p) == "Bomber") && ((e.getAction().equals(Action.RIGHT_CLICK_AIR)) || (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)))) {
/* 24 */       if (hasCooldown()) {
/* 25 */         p.sendMessage("§7[§6§l!§7] §cFaltam " + cooldownTimeRemaining() + " para o cooldown acabar!");
/* 26 */         return;
/*    */       }
/* 28 */       TNTPrimed tnt = (TNTPrimed)p.getWorld().spawn(p.getLocation(), TNTPrimed.class);
/* 29 */       tnt.setVelocity(p.getEyeLocation().getDirection().multiply(2.5D));
/* 30 */       tnt.setFuseTicks(40);
/* 31 */       p.getLocation().getWorld().createExplosion(p.getLocation(), 4.0F);
/* 32 */       addCooldown(p, 30);
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void bomberDamage(EntityDamageEvent event) {
/* 38 */     if (!(event.getEntity() instanceof Player))
/* 39 */       return;
/* 40 */     Player p = (Player)event.getEntity();
/* 41 */     if (KitAPI.getkit(p) != "Bomber")
/* 42 */       return;
/* 43 */     if (event.getCause() != EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)
/* 44 */       return;
/* 45 */     event.setCancelled(true);
/*    */   }
/*    */   
/*    */   public void addCooldown(Player player, int seconds) {
/* 49 */     this.cooldownLenght = (System.currentTimeMillis() + seconds * 1000);
/*    */   }
/*    */   
/*    */   public String cooldownTimeRemaining() {
/* 53 */     long faltam = (this.cooldownLenght - System.currentTimeMillis()) / 1000L;
/* 54 */     if (faltam < 60L) {
/* 55 */       return faltam + " segundos restantes";
/*    */     }
/* 57 */     return faltam + " minutos restantes";
/*    */   }
/*    */   
/*    */   public boolean hasCooldown() {
/* 61 */     return this.cooldownLenght > System.currentTimeMillis();
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Bomber.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */