/*     */ package nobody.kit;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;

import nobody.eventos.KitAPI;
import nobody.main.Main;

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
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ public class Sonic implements org.bukkit.event.Listener
/*     */ {
/*  28 */   public int boost = Integer.valueOf(6).intValue();
/*  29 */   public static ArrayList<String> sonic = new ArrayList<String>();
/*  30 */   ArrayList<String> fall = new ArrayList<String>();
/*  31 */   public static List<Player> cooldownm = new ArrayList<Player>();
/*  32 */   public static HashMap<String, ItemStack[]> Armadura = new HashMap<String, ItemStack[]>();
/*     */   
/*     */   @EventHandler
/*     */   public void VelotrolClick(PlayerInteractEvent e)
/*     */   {
/*  37 */     final Player p = e.getPlayer();
/*  38 */     if ((e.getPlayer().getItemInHand().getType() == Material.LAPIS_BLOCK) && (KitAPI.getkit(p) == "Sonic")) {
/*  39 */       if ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_AIR)) {
/*  40 */         e.setCancelled(true);
/*  41 */         p.playSound(p.getLocation(), Sound.ANVIL_LAND, 2.0F, 2.0F);
/*     */       }
/*  43 */       if (cooldownm.contains(p)) {
/*  44 */         p.sendMessage("§7[§6§l!§7] §cAguarde o cooldown acabar!");
/*  45 */         return;
/*     */       }
/*  47 */       cooldownm.add(p);
/*  48 */       p.setVelocity(p.getEyeLocation().getDirection().multiply(this.boost).add(new Vector(0, 0, 0)));
/*  49 */       p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), org.bukkit.Effect.SMOKE, 10, 0);
p.getLocation();
/*  51 */       for (Entity pertos : p.getNearbyEntities(8.0D, 8.0D, 8.0D)) {
/*  52 */         if ((pertos instanceof Player))
/*     */         {
/*  55 */           ((Player)pertos).damage(10.0D);
/*  56 */           pertos.setVelocity(new Vector(0.1D, 0.0D, 0.1D));
/*  57 */           ((Player)pertos).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 105, 105));
/*  58 */           p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 105));
/*     */         }
/*     */       }
/*  61 */       ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
/*  62 */       LeatherArmorMeta kCapacete = (LeatherArmorMeta)Capacete.getItemMeta();
/*  63 */       kCapacete.setColor(Color.BLUE);
/*  64 */       Capacete.setItemMeta(kCapacete);
/*     */       
/*  66 */       ItemStack Peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
/*  67 */       LeatherArmorMeta kPeitoral = (LeatherArmorMeta)Peitoral.getItemMeta();
/*  68 */       kPeitoral.setColor(Color.BLUE);
/*  69 */       Peitoral.setItemMeta(kPeitoral);
/*     */       
/*  71 */       ItemStack Calça = new ItemStack(Material.LEATHER_LEGGINGS);
/*  72 */       LeatherArmorMeta kCalça = (LeatherArmorMeta)Calça.getItemMeta();
/*  73 */       kCalça.setColor(Color.BLUE);
/*  74 */       Calça.setItemMeta(kCalça);
/*     */       
/*  76 */       ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
/*  77 */       LeatherArmorMeta kBota = (LeatherArmorMeta)Capacete.getItemMeta();
/*  78 */       kBota.setColor(Color.BLUE);
/*  79 */       Bota.setItemMeta(kBota);
/*     */       
/*  81 */       Armadura.put(p.getName(), p.getInventory().getArmorContents());
/*     */       
/*  83 */       p.getInventory().setHelmet(Capacete);
/*  84 */       p.getInventory().setChestplate(Peitoral);
/*  85 */       p.getInventory().setLeggings(Calça);
/*  86 */       p.getInventory().setBoots(Bota);
/*  87 */       p.updateInventory();
/*     */       
/*  89 */       org.bukkit.Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/*  91 */           p.getInventory().setHelmet(null);
/*  92 */           p.getInventory().setChestplate(null);
/*  93 */           p.getInventory().setLeggings(null);
/*  94 */           p.getInventory().setBoots(null);
/*  95 */           p.updateInventory();
/*     */         }
/*  97 */       }, 50L);
/*     */       
/*  99 */       org.bukkit.Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/* 101 */           Sonic.cooldownm.remove(p);
/* 102 */           p.sendMessage("§7[§6§l!§7] §aVoce pode usar novamente!");
/* 103 */           p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0F, 5.0F);
/*     */         }
/* 105 */       }, 700L);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerDamageSponge(EntityDamageEvent e) {
/* 111 */     if (!(e.getEntity() instanceof Player)) {
/* 112 */       return;
/*     */     }
/* 114 */     Player p = (Player)e.getEntity();
/* 115 */     if ((e.getCause() == org.bukkit.event.entity.EntityDamageEvent.DamageCause.FALL) && (this.fall.contains(p.getName()))) {
/* 116 */       this.fall.remove(p.getName());
/* 117 */       e.setDamage(6.5D);
/* 118 */       return;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Sonic.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */