/*    */ package nobody.kit;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.concurrent.TimeUnit;

import nobody.eventos.KitAPI;
import nobody.main.Main;

/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.entity.Snowball;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.entity.ProjectileHitEvent;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ 
/*    */ public class Spiderman implements org.bukkit.event.Listener
/*    */ {
/* 20 */   public static HashMap<String, Long> cooldown = new HashMap<String, Long>();
/* 21 */   public static HashMap<String, Snowball> teias = new HashMap<String, Snowball>();
/*    */   
/*    */   @EventHandler
/*    */   public void lancar(PlayerInteractEvent e) {
/* 25 */     Player p = e.getPlayer();
/* 26 */     if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
/* 27 */       (KitAPI.getkit(p) == "Spiderman") && (p.getItemInHand().getType() == Material.STRING)) {
/* 28 */       e.setCancelled(true);
/* 29 */       p.updateInventory();
/* 30 */       if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis())) {
/* 31 */         Snowball teia = (Snowball)p.launchProjectile(Snowball.class);
/* 32 */         teias.put(p.getName(), teia);
/* 33 */         cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(10L)));
/* 34 */         p.sendMessage("§7[§6§l!§7] §b§lTeia lançada!");
/* 35 */         p.playSound(p.getLocation(), Sound.IRONGOLEM_THROW, 1.0F, 1.0F);
/* 36 */         return;
/*    */       }
/* 38 */       p.sendMessage("§7[§6§l!§7] §cFalta " + TimeUnit.MILLISECONDS.toSeconds(((Long)cooldown.get(p.getName())).longValue() - System.currentTimeMillis()) + "§c segundos para vocÃª poder usar novamente");
/*    */     }
/*    */   }
/*    */   
/*    */   @SuppressWarnings("deprecation")
@EventHandler
/*    */   public void teia(ProjectileHitEvent e)
/*    */   {
/* 45 */     if (((e.getEntity() instanceof Snowball)) && 
/* 46 */       ((e.getEntity().getShooter() instanceof Player))) {
/* 47 */       Snowball teia = (Snowball)e.getEntity();
/* 48 */       Player p = (Player)e.getEntity().getShooter();
/* 49 */       if ((teias.containsKey(p.getName())) && 
/* 50 */         (teia == teias.get(p.getName()))) {
/* 51 */         teias.remove(p.getName());
/* 52 */         final Block b = teia.getLocation().getBlock();
/* 53 */         b.setType(Material.WEB);
/* 54 */         new org.bukkit.scheduler.BukkitRunnable() {
/*    */           public void run() {
/* 56 */             if (b.getType() == Material.WEB) {
/* 57 */               b.setType(Material.AIR);
/*    */             }
/*    */           }
/* 60 */         }.runTaskLater(Main.plugin, 100L);
/* 61 */         return;
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Spiderman.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */