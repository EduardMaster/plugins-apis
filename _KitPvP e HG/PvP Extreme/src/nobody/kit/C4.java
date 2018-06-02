/*    */ package nobody.kit;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;

import nobody.main.Main;

/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Item;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class C4 implements Listener
/*    */ {
/* 20 */   @SuppressWarnings({ "unchecked", "rawtypes" })
private ArrayList<Player> cooldown = new ArrayList();
/*    */   public static Main plugin;
/* 22 */   @SuppressWarnings({ "unchecked", "rawtypes" })
private Map<Player, Item> inbomb = new HashMap();
/*    */   
/*    */   public C4(Main main) {
/* 25 */     plugin = main;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void a(PlayerInteractEvent e) {
/* 30 */     final Player p = e.getPlayer();
/* 31 */     if (p.getItemInHand().getType() == Material.AIR) {
/* 32 */       return;
/*    */     }
/* 34 */     if (p.getInventory().getItemInHand().getType() != Material.SLIME_BALL) {
/* 35 */       return;
/*    */     }
/* 37 */     if (e.getAction().name().contains("RIGHT")) {
/* 38 */       if (this.inbomb.containsKey(p)) {
/* 39 */         return;
/*    */       }
/* 41 */       if (this.cooldown.contains(p)) {
/* 42 */         p.sendMessage("§7[§6§l!§7] §cAguarde o cooldown acabar");
/* 43 */         return;
/*    */       }
/* 45 */       Item C4bomb = p.getWorld().dropItem(p.getEyeLocation(), new ItemStack(Material.TNT));
/* 46 */       C4bomb.setVelocity(e.getPlayer().getEyeLocation().getDirection().multiply(0.6D));
/* 47 */       C4bomb.setPickupDelay(999999);
/* 48 */       C4bomb.getItemStack().getItemMeta().setDisplayName("§bBomba");
/* 49 */       this.inbomb.put(p, C4bomb);
/* 50 */       this.cooldown.add(p);
/* 51 */     } else if (this.inbomb.containsKey(p)) {
/* 52 */       Item C4bomb = (Item)this.inbomb.get(p);
/* 53 */       p.getWorld().createExplosion(C4bomb.getLocation(), 3.0F, true);
/* 54 */       this.inbomb.remove(p);
/* 55 */       C4bomb.remove();
/* 56 */       org.bukkit.Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*    */         public void run() {
/* 58 */           C4.this.cooldown.remove(p);
/* 59 */           p.sendMessage("§l§bVoce ja pode usar o C4");
/* 60 */           p.playSound(p.getLocation(), org.bukkit.Sound.LEVEL_UP, 20.0F, 1.0F);
/*    */         }
/* 62 */       }, 600L);
/*    */     } else {
/* 64 */       p.sendMessage("§7[§6§l!§7] §l§4 A Bomba ainda nao foi plantada");
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\C4.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */