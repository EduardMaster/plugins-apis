/*     */ package br.nikao.kits;
/*     */ 
/*     */ import br.nikao.Main;
/*     */ import br.nikao.outros.KitAPI;
/*     */ import java.util.ArrayList;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.EntityType;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class Rain implements org.bukkit.event.Listener
/*     */ {
/*  23 */   public static ArrayList<String> rain = new ArrayList();
/*  24 */   public static ArrayList<String> cooldown = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void onHit(EntityDamageByEntityEvent e) {
/*  28 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof org.bukkit.entity.Arrow))) {
/*  29 */       e.setDamage(3.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void RainClick(PlayerInteractEntityEvent e) {
/*  35 */     if (!(e.getRightClicked() instanceof Player)) {
/*  36 */       return;
/*     */     }
/*  38 */     final Player p = e.getPlayer();
/*  39 */     final Player r = (Player)e.getRightClicked();
/*  40 */     if ((p.getItemInHand().getType() == Material.ARROW) && (KitAPI.getkit(p) == "Rain")) {
/*  41 */       if ((KitAPI.getkit(p) == "Rain") && (cooldown.contains(p.getName()))) {
/*  42 */         p.sendMessage("§cO Rain está em cooldown aguarde");
/*  43 */         return;
/*     */       }
/*  45 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/*  47 */           Location loc = r.getLocation();
/*  48 */           loc.setY(loc.getY() + 3.0D);
/*  49 */           r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
/*     */           
/*  51 */           Entity arrow2 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc, EntityType.ARROW);
/*     */         }
/*  53 */       }, 40L);
/*     */       
/*  55 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */         public void run() {
/*  58 */           Location loc2 = r.getLocation();
/*  59 */           loc2.setY(loc2.getY() + 3.0D);
/*  60 */           r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
/*     */           
/*  62 */           Entity arrow3 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc2, EntityType.ARROW);
/*     */         }
/*     */         
/*  65 */       }, 35L);
/*     */       
/*  67 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */         public void run() {
/*  70 */           Location loc3 = r.getLocation();
/*  71 */           loc3.setY(loc3.getY() + 3.0D);
/*  72 */           r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
/*     */           
/*  74 */           Entity arrow4 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc3, EntityType.ARROW);
/*     */         }
/*     */         
/*  77 */       }, 30L);
/*  78 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */         public void run() {
/*  81 */           Location loc3 = r.getLocation();
/*  82 */           loc3.setY(loc3.getY() + 3.0D);
/*  83 */           r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
/*     */           
/*  85 */           Entity arrow4 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc3, EntityType.ARROW);
/*     */         }
/*     */         
/*  88 */       }, 25L);
/*  89 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */         public void run() {
/*  92 */           Location loc3 = r.getLocation();
/*  93 */           loc3.setY(loc3.getY() + 3.0D);
/*  94 */           r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
/*     */           
/*  96 */           Entity arrow4 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc3, EntityType.ARROW);
/*     */         }
/*     */         
/*  99 */       }, 20L);
/*     */       
/* 101 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */         public void run() {
/* 104 */           Location loc4 = r.getLocation();
/* 105 */           loc4.setY(loc4.getY() + 3.0D);
/* 106 */           r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
/*     */           
/* 108 */           Entity arrow5 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc4, EntityType.ARROW);
/*     */         }
/*     */         
/* 111 */       }, 5L);
/*     */       
/* 113 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */         public void run() {
/* 116 */           Location loc6 = r.getLocation();
/* 117 */           loc6.setY(loc6.getY() + 3.0D);
/* 118 */           r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
/*     */           
/* 120 */           Entity arrow6 = Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc6, EntityType.ARROW);
/*     */         }
/*     */         
/* 123 */       }, 3L);
/*     */       
/* 125 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */         public void run() {
/* 128 */           Location loc5 = r.getLocation();
/* 129 */           loc5.setY(loc5.getY() + 2.5D);
/* 130 */           r.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 0));
/*     */         }
/*     */         
/* 133 */       }, 2L);
/*     */       
/* 135 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */         public void run() {
/* 138 */           Rain.rain.remove(p.getName());
/*     */         }
/*     */         
/* 141 */       }, 50L);
/* 142 */       cooldown.add(p.getName());
/* 143 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */         public void run() {
/* 146 */           Rain.cooldown.remove(p.getName());
/* 147 */           p.sendMessage("§a§lVocê ja pode usar novamente !");
/* 148 */           p.getWorld().playSound(p.getLocation(), org.bukkit.Sound.BURP, 5.0F, 5.0F);
/*     */         }
/* 150 */       }, 700L);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Rain.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */