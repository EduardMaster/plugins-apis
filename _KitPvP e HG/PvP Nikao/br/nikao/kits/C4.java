/*    */ package br.nikao.kits;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import br.nikao.outros.KitAPI;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.entity.Item;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class C4 implements Listener
/*    */ {
/* 22 */   private ArrayList<Player> cooldown = new ArrayList();
/* 23 */   private Map<Player, Item> inbomb = new HashMap();
/*    */   
/*    */   @EventHandler
/*    */   public void a(PlayerInteractEvent e) {
/* 27 */     final Player p = e.getPlayer();
/* 28 */     if (p.getItemInHand().getType() == Material.AIR) {
/* 29 */       return;
/*    */     }
/* 31 */     if (p.getInventory().getItemInHand().getType() != Material.SLIME_BALL) {
/* 32 */       return;
/*    */     }
/* 34 */     if (KitAPI.getkit(p) != "C4") {
/* 35 */       return;
/*    */     }
/* 37 */     if (e.getAction().name().contains("RIGHT")) {
/* 38 */       if (this.inbomb.containsKey(p)) {
/* 39 */         return;
/*    */       }
/* 41 */       if (this.cooldown.contains(p)) {
/* 42 */         p.sendMessage("§cAguarde o cooldown acabar");
/* 43 */         return;
/*    */       }
/* 45 */       Item C4bomb = p.getWorld().dropItem(p.getEyeLocation(), new ItemStack(Material.TNT));
/* 46 */       C4bomb.setVelocity(e.getPlayer().getEyeLocation().getDirection().multiply(0.6D));
/* 47 */       C4bomb.setPickupDelay(999999);
/* 48 */       C4bomb.getItemStack().getItemMeta().setDisplayName("§c§lBomba");
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
/* 59 */           p.sendMessage("§7§lO C4 já está pronto para uso");
/* 60 */           p.playSound(p.getLocation(), org.bukkit.Sound.LEVEL_UP, 20.0F, 1.0F);
/*    */         }
/* 62 */       }, 600L);
/*    */     } else {
/* 64 */       p.sendMessage("§c§lImplante a bomba primeiro !");
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\C4.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */