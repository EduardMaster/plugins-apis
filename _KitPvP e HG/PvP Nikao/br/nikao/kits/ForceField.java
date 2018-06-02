/*    */ package br.nikao.kits;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import br.nikao.outros.KitAPI;
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class ForceField implements Listener
/*    */ {
/* 23 */   public static ArrayList<Player> cooldown = new ArrayList();
/* 24 */   public static ArrayList<Player> noFF = new ArrayList();
/*    */   
/*    */   public static void Force(Player p) {
/* 27 */     Location local = p.getLocation();
/* 28 */     java.util.List<Entity> Inimigos = local.getWorld().getEntities();
/* 29 */     for (Entity e : Inimigos)
/* 30 */       if ((e.getLocation().distance(local) < 6.0D) && ((e instanceof Player)))
/*    */       {
/* 32 */         Player d = (Player)e;
/* 33 */         if (d != p)
/* 34 */           d.damage(2.2D);
/*    */       }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void Interact(PlayerInteractEvent e) {
/* 40 */     final Player p = e.getPlayer();
/*    */     
/* 42 */     if ((KitAPI.getkit(p) == "ForceField") && (e.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_AIR) && (p.getItemInHand().getType() == Material.NETHER_FENCE)) {
/* 43 */       if (cooldown.contains(p)) {
/* 44 */         p.sendMessage("§cAguarde o cooldown acabar.");
/* 45 */         return;
/*    */       }
/* 47 */       cooldown.add(p);
/* 48 */       noFF.add(p);
/* 49 */       p.sendMessage("§7§lTodos a um raio de 6 blocos iram tomar dano");
/*    */       
/* 51 */       Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
/*    */         public void run() {
/* 53 */           if (ForceField.noFF.contains(p))
/* 54 */             ForceField.Force(p);
/*    */         }
/* 56 */       }, 1L, 1L);
/* 57 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*    */         public void run() {
/* 59 */           if (KitAPI.getkit(p) == "ForceField") {
/* 60 */             ForceField.noFF.remove(p);
/*    */           }
/*    */         }
/* 63 */       }, 135L);
/* 64 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*    */         public void run() {
/* 66 */           if (KitAPI.getkit(p) == "ForceField") {
/* 67 */             ForceField.cooldown.remove(p);
/* 68 */             p.sendMessage("§a§lO FF está pronto para uso !");
/* 69 */             p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0F, 5.0F);
/*    */           }
/*    */         }
/* 72 */       }, 800L);
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void Morrer(PlayerDeathEvent e) {
/* 78 */     Player p = e.getEntity();
/* 79 */     if (noFF.contains(p)) {
/* 80 */       noFF.remove(p);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\ForceField.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */