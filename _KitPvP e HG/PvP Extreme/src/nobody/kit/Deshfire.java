/*     */ package nobody.kit;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;

import nobody.eventos.KitAPI;
import nobody.main.Main;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Color;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.LeatherArmorMeta;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ public class Deshfire implements org.bukkit.event.Listener
/*     */ {
/*  27 */   public int boost = Integer.valueOf(6).intValue();
/*  28 */   public static ArrayList<String> sonic = new ArrayList<String>();
/*  29 */   ArrayList<String> fall = new ArrayList<String>();
/*  30 */   public static List<Player> cooldownm = new ArrayList<Player>();
/*  31 */   public static HashMap<String, ItemStack[]> Armadura = new HashMap<String, ItemStack[]>();
/*     */   
/*     */   @EventHandler
/*     */   public void VelotrolClick(PlayerInteractEvent e) {
/*  35 */     final Player p = e.getPlayer();
/*  36 */     if ((e.getPlayer().getItemInHand().getType() == Material.REDSTONE_BLOCK) && (KitAPI.getkit(p) == "Deshfire")) {
/*  37 */       if ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_AIR)) {
/*  38 */         e.setCancelled(true);
/*  39 */         p.playSound(p.getLocation(), Sound.ANVIL_LAND, 2.0F, 2.0F);
/*     */       }
/*  41 */       if (cooldownm.contains(p)) {
/*  42 */         p.sendMessage("§7[§6§l!§7] §c§lAguarde o cooldown acabar!");
/*  43 */         return;
/*     */       }
/*  45 */       cooldownm.add(p);
/*  46 */       p.setVelocity(p.getEyeLocation().getDirection().multiply(this.boost).add(new Vector(0, 0, 0)));
/*  47 */       p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), org.bukkit.Effect.MOBSPAWNER_FLAMES, 10, 0);
p.getLocation();
/*  49 */       for (Entity pertos : p.getNearbyEntities(8.0D, 8.0D, 8.0D)) {
/*  50 */         if ((pertos instanceof Player)) {
/*  52 */           ((Player)pertos).damage(10.0D);
/*  53 */           pertos.setVelocity(new Vector(0.1D, 0.0D, 0.1D));
/*  54 */           ((Player)pertos).setFireTicks(150);
/*     */         }
/*     */       }
/*  57 */       ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
/*  58 */       LeatherArmorMeta kCapacete = (LeatherArmorMeta)Capacete.getItemMeta();
/*  59 */       kCapacete.setColor(Color.RED);
/*  60 */       Capacete.setItemMeta(kCapacete);
/*     */       
/*  62 */       ItemStack Peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
/*  63 */       LeatherArmorMeta kPeitoral = (LeatherArmorMeta)Peitoral.getItemMeta();
/*  64 */       kPeitoral.setColor(Color.RED);
/*  65 */       Peitoral.setItemMeta(kPeitoral);
/*     */       
/*  67 */       ItemStack Calça = new ItemStack(Material.LEATHER_LEGGINGS);
/*  68 */       LeatherArmorMeta kCalça = (LeatherArmorMeta)Calça.getItemMeta();
/*  69 */       kCalça.setColor(Color.RED);
/*  70 */       Calça.setItemMeta(kCalça);
/*     */       
/*  72 */       ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
/*  73 */       LeatherArmorMeta kBota = (LeatherArmorMeta)Capacete.getItemMeta();
/*  74 */       kBota.setColor(Color.RED);
/*  75 */       Bota.setItemMeta(kBota);
/*     */       
/*  77 */       Armadura.put(p.getName(), p.getInventory().getArmorContents());
/*     */       
/*  79 */       p.getInventory().setHelmet(Capacete);
/*  80 */       p.getInventory().setChestplate(Peitoral);
/*  81 */       p.getInventory().setLeggings(Calça);
/*  82 */       p.getInventory().setBoots(Bota);
/*  83 */       p.updateInventory();
/*     */       
/*  85 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/*  87 */           p.getInventory().setHelmet(null);
/*  88 */           p.getInventory().setChestplate(null);
/*  89 */           p.getInventory().setLeggings(null);
/*  90 */           p.getInventory().setBoots(null);
/*  91 */           p.updateInventory();
/*     */         }
/*  93 */       }, 50L);
/*     */       
/*  95 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/*  97 */           Deshfire.cooldownm.remove(p);
/*  98 */           p.sendMessage("§7[§6§l!§7] §a§lVoce pode usar novamente!");
/*  99 */           p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0F, 5.0F);
/*     */         }
/* 101 */       }, 700L);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerDamageSponge(EntityDamageEvent e) {
/* 107 */     if (!(e.getEntity() instanceof Player)) {
/* 108 */       return;
/*     */     }
/* 110 */     Player p = (Player)e.getEntity();
/* 111 */     if ((e.getCause() == org.bukkit.event.entity.EntityDamageEvent.DamageCause.FALL) && (this.fall.contains(p.getName()))) {
/* 112 */       this.fall.remove(p.getName());
/* 113 */       e.setDamage(6.5D);
/* 114 */       return;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Deshfire.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */