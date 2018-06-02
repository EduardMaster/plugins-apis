/*     */ package neero.demon.eventos;
/*     */ 
/*     */ import neero.demon.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
import org.bukkit.Sound;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.EventPriority;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.player.AsyncPlayerChatEvent;
/*     */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ 
/*     */ public class Nerfs implements Listener
/*     */ {
/*     */   @SuppressWarnings("deprecation")
@EventHandler
/*     */   public void onDamageByEntity(EntityDamageByEntityEvent event)
/*     */   {
/*  23 */     if ((event.getDamager() instanceof Player))
/*     */     {
/*  25 */       Player player = (Player)event.getDamager();
/*  26 */       if (event.getDamage() > 1.0D) {
/*  27 */         event.setDamage(event.getDamage() - 1.0D);
/*     */       }
/*  29 */       if ((event.getDamager() instanceof Player))
/*     */       {
/*  31 */         if ((player.getFallDistance() > 0.0F) && (!player.isOnGround()) && 
/*  32 */           (!player.hasPotionEffect(PotionEffectType.BLINDNESS)))
/*     */         {
/*  34 */           int NewDamage = (int)(event.getDamage() * 1.5D) - 
/*  35 */             (int)event.getDamage();
/*  36 */           if (event.getDamage() > 1.0D) {
/*  37 */             event.setDamage(event.getDamage() - NewDamage);
/*     */           }
/*     */         }
/*  40 */         if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
/*  41 */           event.setDamage(4.0D);
/*     */         }
/*  43 */         if (player.getItemInHand().getType() == Material.STONE_SWORD) {
/*  44 */           event.setDamage(4.0D);
/*     */         }
/*  46 */         if (player.getItemInHand().getType() == Material.IRON_SWORD) {
/*  47 */           event.setDamage(6.0D);
/*     */         }
/*  49 */         if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
/*  50 */           event.setDamage(7.0D);
/*     */         }
/*  52 */         if (player.getItemInHand().getType() == Material.STONE_AXE) {
/*  53 */           event.setDamage(4.5D);
/*     */         }
/*  55 */         if (player.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
/*  56 */           event.setDamage(event.getDamage() + 0.0D);
/*     */         }
/*  58 */         if ((player.getFallDistance() > 0.0F) && (!player.isOnGround()) && 
/*  59 */           (!player.hasPotionEffect(PotionEffectType.BLINDNESS)))
/*     */         {
/*  61 */           if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
/*  62 */             event.setDamage(event.getDamage() + 0.0D);
/*     */           }
/*  64 */           if (player.getItemInHand().getType() == Material.STONE_SWORD) {
/*  65 */             event.setDamage(event.getDamage() + 0.0D);
/*     */           }
/*  67 */           if (player.getItemInHand().getType() == Material.IRON_SWORD) {
/*  68 */             event.setDamage(event.getDamage() + 0.0D);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onBreakSwords(EntityDamageByEntityEvent e)
/*     */   {
/*  78 */     if (!(e.getDamager() instanceof Player)) {
/*  79 */       return;
/*     */     }
/*  81 */     if (!(e.getEntity() instanceof Player)) {
/*  82 */       return;
/*     */     }
/*  84 */     Player p = (Player)e.getDamager();
/*  85 */     if ((p.getItemInHand().getType() == Material.WOOD_SWORD) || 
/*  86 */       (p.getItemInHand().getType() == Material.STONE_SWORD) || 
/*  87 */       (p.getItemInHand().getType() == Material.IRON_SWORD) || 
/*  88 */       (p.getItemInHand().getType() == Material.GOLD_SWORD) || 
/*  89 */       (p.getItemInHand().getType() == Material.DIAMOND_SWORD)) {
/*  90 */       p.getItemInHand().setDurability((short)0);
/*  91 */       p.updateInventory();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @EventHandler
/*     */   public void move(EntityDamageEvent event)
/*     */   {
/* 100 */     if (event.getCause() == EntityDamageEvent.DamageCause.VOID) {
/* 101 */       event.setDamage(30);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler(priority=EventPriority.HIGHEST)
/*     */   public void chatFormat(AsyncPlayerChatEvent e) {
/* 107 */     Player p = e.getPlayer();
/* 110 */       e.setFormat(Ranks.getRankChat(p) + " " + ChatColor.GRAY + p.getDisplayName() + " §b§l§o» §f" + "%2$s");
/*     */     }
/*     */   
/*     */   @EventHandler
/*     */   public void onBlock(PlayerCommandPreprocessEvent e) {
	Player p = e.getPlayer();
/* 118 */     if ((e.getMessage().contains("/pl")) || 
/* 119 */       (e.getMessage().contains("/plugin")) || 
/* 120 */       (e.getMessage().contains("/ver")) || 
/* 121 */       (e.getMessage().contains("/version")) || 
/* 122 */       (e.getMessage().contains("/bukkit:plugins")) || 
/* 123 */       (e.getMessage().contains("/?")) || 
/* 124 */       (e.getMessage().contains("/help")) || 
/* 125 */       (e.getMessage().contains("/bukkit:me"))) {
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1.0F, 1.0F);
						p.sendMessage("§e§l1...");
					}
				},20L);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					
					public void run() {
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1.0F, 1.0F);
						p.sendMessage("§e§l2...");
					}
				},40L);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					
					public void run() {
						p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1.0F, 1.0F);
						p.sendMessage("§e§l3...");
					}
				},60L);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					
					public void run() {
						p.playSound(p.getLocation(), Sound.BLAZE_HIT, 5.0F, 5.0F);
						p.sendMessage("§e§lCRIADOR §6§lturkeyREIDELAS \n§a§lSKYPE §6turkey.reidasnovinha");
		/* 126 */       e.setCancelled(true);
					}
				},80L);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\events\Nerfs.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */