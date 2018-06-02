/*    */ package nobody.kit;
/*    */ 

/*    */ import java.util.ArrayList;

import nobody.eventos.KitAPI;
import nobody.main.Main;

/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ 
/*    */ public class ForceField implements Listener
/*    */ {
/* 22 */   public static ArrayList<Player> cooldown = new ArrayList<Player>();
/* 23 */   public static ArrayList<Player> noFF = new ArrayList<Player>();
/*    */   
/*    */   public static void Force(Player p) {
/* 26 */     Location local = p.getLocation();
/* 27 */     java.util.List<Entity> Inimigos = local.getWorld().getEntities();
/* 28 */     for (Entity e : Inimigos)
/* 29 */       if ((e.getLocation().distance(local) < 6.0D) && ((e instanceof Player)))
/*    */       {
/* 31 */         Player d = (Player)e;
/* 32 */         if (d != p)
/* 33 */           d.damage(2.2D);
/*    */       }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void Interact(PlayerInteractEvent e) {
/* 39 */     final Player p = e.getPlayer();
/*    */     
/* 41 */     if ((KitAPI.getkit(p) == "ForceField") && (e.getAction() == Action.RIGHT_CLICK_AIR) && (p.getItemInHand().getType() == Material.NETHER_FENCE)) {
/* 42 */       if (cooldown.contains(p)) {
/* 43 */         p.sendMessage("§cEspere o cooldown acabar.");
/* 44 */         return;
/*    */       }
/* 46 */       cooldown.add(p);
/* 47 */       noFF.add(p);
/* 48 */       p.sendMessage("§cFF Ativado.");
/*    */       
/* 50 */       Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
/*    */         public void run() {
/* 52 */           if (ForceField.noFF.contains(p)) {
/* 53 */             ForceField.Force(p);
/*    */           }
/*    */         }
/* 56 */       }, 1L, 1L);
/* 57 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*    */       {
/*    */         public void run() {
/* 60 */           ForceField.noFF.remove(p);
/*    */         }
/*    */         
/* 63 */       }, 135L);
/* 64 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*    */       {
/*    */         public void run() {
/* 67 */           ForceField.cooldown.remove(p);
/* 68 */           p.sendMessage("§bVocê ja pode usar o FF.");
/* 69 */           p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0F, 5.0F);
/*    */         }
/* 71 */       }, 800L);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\ForceField.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */