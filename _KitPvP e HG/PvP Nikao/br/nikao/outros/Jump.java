/*     */ package br.nikao.outros;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.block.BlockFace;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.EventPriority;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*     */ import org.bukkit.event.player.PlayerMoveEvent;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ public class Jump implements org.bukkit.event.Listener
/*     */ {
/*     */   public static br.nikao.Main plugin;
/*  20 */   public static ArrayList<String> Diamante = new ArrayList();
/*  21 */   public static ArrayList<String> Ferro = new ArrayList();
/*  22 */   public static ArrayList<String> Sponja = new ArrayList();
/*  23 */   public static ArrayList<String> Esmeralda = new ArrayList();
/*     */   
/*     */   public Jump(br.nikao.Main main) {
/*  26 */     plugin = main;
/*     */   }
/*     */   
/*     */   @EventHandler(priority=EventPriority.MONITOR)
/*     */   public void Jump1(PlayerMoveEvent e) {
/*  31 */     Player p = e.getPlayer();
/*  32 */     if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SPONGE) {
/*  33 */       p.playSound(p.getLocation(), Sound.ORB_PICKUP, 6.0F, 1.0F);
/*  34 */       Sponja.remove(p.getName());
/*  35 */       Vector sponge = p.getLocation().getDirection().multiply(0).setY(1);
/*  36 */       p.setVelocity(sponge);
/*  37 */       Sponja.add(p.getName());
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void Voar1(EntityDamageEvent e) {
/*  43 */     if ((e.getEntity() instanceof Player)) {
/*  44 */       Player p = (Player)e.getEntity();
/*  45 */       if ((e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) && (Sponja.contains(p.getName()))) {
/*  46 */         e.setCancelled(true);
/*  47 */         Sponja.remove(p.getName());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler(priority=EventPriority.MONITOR)
/*     */   public void Jump2(PlayerMoveEvent e) {
/*  54 */     Player p = e.getPlayer();
/*  55 */     if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.EMERALD_BLOCK) {
/*  56 */       p.playSound(p.getLocation(), Sound.ORB_PICKUP, 6.0F, 1.0F);
/*  57 */       Esmeralda.remove(p.getName());
/*  58 */       Vector sponge = p.getLocation().getDirection().multiply(0).setY(3);
/*  59 */       p.setVelocity(sponge);
/*  60 */       Esmeralda.add(p.getName());
/*  61 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void Voar2(EntityDamageEvent e) {
/*  67 */     if ((e.getEntity() instanceof Player)) {
/*  68 */       Player p = (Player)e.getEntity();
/*  69 */       if ((e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) && 
/*  70 */         (Esmeralda.contains(p.getName()))) {
/*  71 */         e.setCancelled(true);
/*  72 */         Esmeralda.remove(p.getName());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler(priority=EventPriority.MONITOR)
/*     */   public void Jump3(PlayerMoveEvent e) {
/*  79 */     Player p = e.getPlayer();
/*  80 */     if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.IRON_BLOCK) {
/*  81 */       p.playSound(p.getLocation(), Sound.ORB_PICKUP, 6.0F, 1.0F);
/*  82 */       Ferro.remove(p.getName());
/*  83 */       Vector sponge = p.getLocation().getDirection().multiply(0).setY(2);
/*  84 */       p.setVelocity(sponge);
/*  85 */       Ferro.add(p.getName());
/*  86 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void Voar3(EntityDamageEvent e) {
/*  92 */     if ((e.getEntity() instanceof Player)) {
/*  93 */       Player p = (Player)e.getEntity();
/*  94 */       if ((e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) && 
/*  95 */         (Ferro.contains(p.getName()))) {
/*  96 */         e.setCancelled(true);
/*  97 */         Ferro.remove(p.getName());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler(priority=EventPriority.MONITOR)
/*     */   public void Jump4(PlayerMoveEvent e) {
/* 104 */     Player p = e.getPlayer();
/* 105 */     if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.DIAMOND_BLOCK) {
/* 106 */       p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 35.0F, 1.0F);
/* 107 */       Diamante.remove(p.getName());
/* 108 */       Vector sponge = p.getLocation().getDirection().multiply(3).setY(1);
/* 109 */       p.setVelocity(sponge);
/* 110 */       Diamante.add(p.getName());
/* 111 */       if (KitAPI.getkit(p) == "Nenhum") {
/* 112 */         p.getInventory().clear();
/* 113 */         p.getInventory().setArmorContents(null);
/* 114 */         KitAPI.PvP(p);
/* 115 */         p.updateInventory();
/* 116 */         p.sendMessage("§cNao foi encontrado nenhum Kit, Adicionando Kit §aPvP");
/*     */       }
/* 118 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void Voar4(EntityDamageEvent e) {
/* 124 */     if ((e.getEntity() instanceof Player)) {
/* 125 */       Player p = (Player)e.getEntity();
/* 126 */       if ((e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) && 
/* 127 */         (Diamante.contains(p.getName()))) {
/* 128 */         e.setCancelled(true);
/* 129 */         Diamante.remove(p.getName());
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\Jump.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */