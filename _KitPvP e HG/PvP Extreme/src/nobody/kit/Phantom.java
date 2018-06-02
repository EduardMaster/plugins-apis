/*     */ package nobody.kit;
/*     */ 

/*     */ import java.util.ArrayList;
/*     */ import java.util.List;

import nobody.eventos.KitAPI;
import nobody.main.Main;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Color;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.LeatherArmorMeta;
/*     */ 
/*     */ public class Phantom implements org.bukkit.event.Listener
/*     */ {
/*  19 */   static List<String> cooldown = new ArrayList<String>();
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
/*  44 */       (KitAPI.getkit(p) == "Phantom"))
/*     */     {
/*  46 */       final Player p1 = event.getPlayer();
/*  47 */       if (cooldown.contains(p1.getName())) {
/*  48 */         return;
/*     */       }
/*  50 */       cooldown.add(p1.getName());
/*  51 */       p1.setAllowFlight(true);
/*  52 */       p1.setFlying(true);
/*  53 */       p1.getInventory().setHelmet(new ItemStack(chest));
/*  54 */       p1.getInventory().setChestplate(new ItemStack(chest1));
/*  55 */       p1.getInventory().setLeggings(new ItemStack(calca));
/*  56 */       p1.getInventory().setBoots(new ItemStack(chest11));
/*  57 */       p1.updateInventory();
/*  58 */       p.sendMessage("§7[§6§l!§7] §aVocê pode voar");
/*     */       
/*  60 */       int i = 5;
/*  61 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */ 
/*     */         public void run() {}
/*     */ 
/*     */ 
/*  67 */       }, i);
/*  68 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */ 
/*     */         public void run() {}
/*     */ 
/*     */ 
/*  74 */       }, i + 20);
/*  75 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/*  77 */           p1.sendMessage("§7[§6§l!§7] §aVoce tem 3 segundos para pousar , vai morrer!");
/*     */         }
/*     */         
/*  80 */       }, i + 40);
/*  81 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/*  83 */           p1.sendMessage("§7[§6§l!§7] §aVoce tem 2 segundos para pousar , vai morrer!");
/*     */         }
/*     */         
/*  86 */       }, i + 60);
/*  87 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/*  89 */           p1.sendMessage("§7[§6§l!§7] §cVoce tem 1 segundo para pousar , vai morrer!");
/*     */         }
/*     */         
/*  92 */       }, i + 80);
/*     */       
/*  94 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/*  96 */           p1.setAllowFlight(false);
/*  97 */           p1.sendMessage("§7[§6§l!§7] §c§lVoce não pode mais voar.");
/*  98 */           p1.getInventory().setHelmet(null);
/*  99 */           p1.getInventory().setChestplate(null);
/* 100 */           p1.getInventory().setLeggings(null);
/* 101 */           p1.getInventory().setBoots(null);
/* 102 */           p1.updateInventory();
/*     */         }
/*     */         
/* 105 */       }, 100L);
/*     */       
/* 107 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/* 109 */           Phantom.cooldown.remove(p1.getName());
/* 110 */           p1.sendMessage("§7[§6§l!§7] §aVoce saiu do Cooldown!");
/*     */         }
/*     */         
/* 113 */       }, 800L);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Phantom.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */