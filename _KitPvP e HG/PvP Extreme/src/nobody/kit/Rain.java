/*     */ package nobody.kit;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;

import nobody.eventos.KitAPI;
import nobody.main.Main;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.entity.EntityType;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ 
/*     */ public class Rain implements org.bukkit.event.Listener
/*     */ {
/*  24 */   public static ArrayList<String> rain = new ArrayList<String>();
/*     */   
/*  26 */   public static List<String> cooldown = new ArrayList<String>();
/*     */   
/*     */   @EventHandler
/*     */   public void onHit(EntityDamageByEntityEvent e) {
/*  30 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof org.bukkit.entity.Arrow))) {
/*  31 */       e.setDamage(3.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void RainClick(PlayerInteractEntityEvent e) {
/*  37 */     if (!(e.getRightClicked() instanceof Player)) {
/*  38 */       return;
/*     */     }
/*  40 */     final Player p = e.getPlayer();
/*  41 */     final Player r = (Player)e.getRightClicked();
/*  42 */     if ((p.getItemInHand().getType() == Material.ARROW) && (KitAPI.getkit(p) == "Rain")) {
/*  43 */       if ((KitAPI.getkit(p) == "Rain") && (cooldown.contains(p))) {
/*  44 */         p.sendMessage("§7[§6§l!§7] §cO rain está em cooldown aguarde");
/*  45 */         return;
/*     */       }
/*  47 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
/*     */         public void run() {
/*  49 */           Location loc = r.getLocation();
/*  50 */           loc.setY(loc.getY() + 2.5D);
/*  51 */           r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc, EntityType.ARROW);         }
/*  55 */       }, 40L);
/*     */       
/*  57 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
/*     */       {
/*     */         public void run() {
/*  60 */           Location loc2 = r.getLocation();
/*  61 */           loc2.setY(loc2.getY() + 2.5D);
/*  62 */           r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc2, EntityType.ARROW);         }
/*     */         
/*  67 */       }, 35L);
/*     */       
/*  69 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
/*     */       {
/*     */         public void run() {
/*  72 */           Location loc3 = r.getLocation();
/*  73 */           loc3.setY(loc3.getY() + 2.5D);
/*  74 */           r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc3, EntityType.ARROW);         }
/*     */         
/*  79 */       }, 30L);
/*  80 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
/*     */       {
/*     */         public void run() {
/*  83 */           Location loc3 = r.getLocation();
/*  84 */           loc3.setY(loc3.getY() + 2.5D);
/*  85 */           r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc3, EntityType.ARROW);         }
/*     */         
/*  90 */       }, 25L);
/*  91 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
/*     */       {
/*     */         public void run() {
/*  94 */           Location loc3 = r.getLocation();
/*  95 */           loc3.setY(loc3.getY() + 2.5D);
/*  96 */           r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc3, EntityType.ARROW);         }
/*     */         
/* 101 */       }, 20L);
/*     */       
/* 103 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
/*     */       {
/*     */         public void run() {
/* 106 */           Location loc4 = r.getLocation();
/* 107 */           loc4.setY(loc4.getY() + 2.5D);
/* 108 */           r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc4, EntityType.ARROW);         }
/*     */         
/* 113 */       }, 5L);
/*     */       
/* 115 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
/*     */       {
/*     */         public void run() {
/* 118 */           Location loc6 = r.getLocation();
/* 119 */           loc6.setY(loc6.getY() + 2.5D);
/* 120 */           r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc6, EntityType.ARROW);         }
/*     */         
/* 125 */       }, 3L);
/*     */       
/* 127 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
/*     */       {
/*     */         public void run() {
/* 130 */           Location loc5 = r.getLocation();
/* 131 */           loc5.setY(loc5.getY() + 2.5D);
/* 132 */           r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
/*     */         }
/*     */         
/* 135 */       }, 2L);
/*     */       
/* 137 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
/*     */       {
/*     */         public void run() {
/* 140 */           Rain.rain.remove(p.getName());
/*     */         }
/*     */         
/* 143 */       }, 50L);
/* 144 */       cooldown.add(p.getName());
/* 145 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
/*     */       {
/*     */         public void run() {
/* 148 */           Rain.cooldown.remove(p);
/* 149 */           p.sendMessage("§7[§6§l!§7] §aO Cooldown Acabou!");
/* 150 */           p.getWorld().playSound(p.getLocation(), org.bukkit.Sound.BURP, 5.0F, 5.0F);
/*     */         }
/* 152 */       }, 700L);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Rain.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */