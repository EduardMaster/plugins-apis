/*     */ package br.nikao.kits;
/*     */ 
/*     */ import br.nikao.Main;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Color;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.LeatherArmorMeta;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class Phantom implements org.bukkit.event.Listener
/*     */ {
/*  19 */   static List<String> cooldown = new ArrayList();
/*     */   
/*     */   @org.bukkit.event.EventHandler
/*     */   public void onInteractPhantom(PlayerInteractEvent event) {
/*  23 */     Player p = event.getPlayer();
/*     */     
/*  25 */     ItemStack chest = new ItemStack(Material.LEATHER_HELMET, 1);
/*  26 */     LeatherArmorMeta chestp = (LeatherArmorMeta)chest.getItemMeta();
/*  27 */     chestp.setColor(Color.WHITE);
/*  28 */     chest.setItemMeta(chestp);
/*  29 */     ItemStack chest1 = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
/*  30 */     LeatherArmorMeta chestp1 = (LeatherArmorMeta)chest1.getItemMeta();
/*  31 */     chestp1.setColor(Color.WHITE);
/*  32 */     chest1.setItemMeta(chestp1);
/*  33 */     ItemStack calca = new ItemStack(Material.LEATHER_LEGGINGS, 1);
/*  34 */     LeatherArmorMeta chestp11 = (LeatherArmorMeta)calca.getItemMeta();
/*  35 */     chestp11.setColor(Color.WHITE);
/*  36 */     calca.setItemMeta(chestp11);
/*  37 */     ItemStack chest11 = new ItemStack(Material.LEATHER_BOOTS, 1);
/*  38 */     LeatherArmorMeta chestp111 = (LeatherArmorMeta)chest11.getItemMeta();
/*  39 */     chestp111.setColor(Color.WHITE);
/*  40 */     chest11.setItemMeta(chestp111);
/*  41 */     if ((event.getPlayer().hasPermission("kit.phantom")) && 
/*  42 */       (event.getAction().name().contains("RIGHT")) && 
/*  43 */       (event.getPlayer().getItemInHand().getType() == Material.FEATHER) && 
/*  44 */       (br.nikao.outros.KitAPI.getkit(p) == "Phantom"))
/*     */     {
/*  46 */       final Player p1 = event.getPlayer();
/*  47 */       if (cooldown.contains(p1.getName())) {
/*  48 */         p1.sendMessage("§cAguarde o cooldown");
/*  49 */         return;
/*     */       }
/*  51 */       cooldown.add(p1.getName());
/*  52 */       p1.setAllowFlight(true);
/*  53 */       p1.setFlying(true);
/*  54 */       p1.getInventory().setHelmet(new ItemStack(chest));
/*  55 */       p1.getInventory().setChestplate(new ItemStack(chest1));
/*  56 */       p1.getInventory().setLeggings(new ItemStack(calca));
/*  57 */       p1.getInventory().setBoots(new ItemStack(chest11));
/*  58 */       p1.updateInventory();
/*  59 */       p.sendMessage("§a§lVocê pode voar");
/*     */       
/*  61 */       int i = 5;
/*  62 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */ 
/*     */         public void run() {}
/*     */ 
/*     */ 
/*  68 */       }, i);
/*  69 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */ 
/*     */         public void run() {}
/*     */ 
/*     */ 
/*  75 */       }, i + 20);
/*  76 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/*  78 */           p1.sendMessage("§aVoce tem 3 segundos para pousar , vai morrer!");
/*     */         }
/*     */         
/*  81 */       }, i + 40);
/*  82 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/*  84 */           p1.sendMessage("§aVoce tem 2 segundos para pousar , vai morrer!");
/*     */         }
/*     */         
/*  87 */       }, i + 60);
/*  88 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/*  90 */           p1.sendMessage("§cVoce tem 1 segundo para pousar , vai morrer!");
/*     */         }
/*     */         
/*  93 */       }, i + 80);
/*     */       
/*  95 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/*  97 */           p1.setAllowFlight(false);
/*  98 */           p1.sendMessage("§c§lVoce não pode mais voar.");
/*  99 */           p1.getInventory().setHelmet(null);
/* 100 */           p1.getInventory().setChestplate(null);
/* 101 */           p1.getInventory().setLeggings(null);
/* 102 */           p1.getInventory().setBoots(null);
/* 103 */           p1.updateInventory();
/*     */         }
/*     */         
/* 106 */       }, 100L);
/*     */       
/* 108 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/* 110 */           Phantom.cooldown.remove(p1.getName());
/* 111 */           p1.sendMessage("§a§lVoce pode usar agora!");
/*     */         }
/*     */         
/* 114 */       }, 800L);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Phantom.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */