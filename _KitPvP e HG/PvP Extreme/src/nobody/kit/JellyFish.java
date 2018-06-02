/*     */ package nobody.kit;
/*     */ 
/*     */ import java.util.ArrayList;

import nobody.eventos.KitAPI;
import nobody.main.Main;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.block.BlockFace;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.block.BlockPhysicsEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerMoveEvent;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ 
/*     */ public class JellyFish implements org.bukkit.event.Listener
/*     */ {
/*  23 */   ArrayList<Block> naoescorrer = new ArrayList<Block>();
/*     */   
/*     */   @EventHandler
/*     */   public void colocaragua(PlayerInteractEvent event)
/*     */   {
/*  28 */     Player p = event.getPlayer();
/*  29 */     if ((KitAPI.getkit(p) == "JellyFish") && 
/*  30 */       (p.getItemInHand().getType() == Material.AIR) && 
/*  31 */       (event.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK)) {
/*  32 */       Block b = event.getClickedBlock();
/*     */       
/*  34 */       BlockFace lado = event.getBlockFace();
/*  35 */       int x = b.getLocation().getBlockX();
/*  36 */       int y = b.getLocation().getBlockY();
/*  37 */       int z = b.getLocation().getBlockZ();
/*  38 */       if (lado == BlockFace.DOWN)
/*     */       {
/*  40 */         final Block b2 = b.getWorld().getBlockAt(x, y - 1, z);
/*  41 */         if (b2.getType() == Material.AIR)
/*     */         {
/*  43 */           b2.setType(Material.STATIONARY_WATER);
/*  44 */           this.naoescorrer.add(b2);
/*  45 */           Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/*  49 */               b2.setType(Material.AIR);
/*  50 */               JellyFish.this.naoescorrer.remove(b2);
/*     */             }
/*     */             
/*  53 */           }, 60L);
/*     */         }
/*     */         else
/*     */         {
/*  57 */           p.sendMessage("§7[§6§l!§7] §cVocê não pode colocar agua aqui!");
/*     */         }
/*     */       }
/*  60 */       else if (lado == BlockFace.UP)
/*     */       {
/*  62 */         final Block b2 = b.getWorld().getBlockAt(x, y + 1, z);
/*  63 */         if (b2.getType() == Material.AIR)
/*     */         {
/*  65 */           b2.setType(Material.STATIONARY_WATER);
/*  66 */           this.naoescorrer.add(b2);
/*  67 */           Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/*  71 */               b2.setType(Material.AIR);
/*  72 */               JellyFish.this.naoescorrer.remove(b2);
/*     */             }
/*     */             
/*  75 */           }, 60L);
/*     */         }
/*     */         else
/*     */         {
/*  79 */           p.sendMessage("§7[§6§l!§7] §cVocê não pode colocar agua aqui!");
/*     */         }
/*     */       }
/*  82 */       else if (lado == BlockFace.NORTH)
/*     */       {
/*  84 */         final Block b2 = b.getWorld().getBlockAt(x, y, z - 1);
/*  85 */         if (b2.getType() == Material.AIR)
/*     */         {
/*  87 */           b2.setType(Material.STATIONARY_WATER);
/*  88 */           this.naoescorrer.add(b2);
/*  89 */           Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/*  93 */               b2.setType(Material.AIR);
/*  94 */               JellyFish.this.naoescorrer.remove(b2);
/*     */             }
/*     */             
/*  97 */           }, 60L);
/*     */         }
/*     */         else
/*     */         {
/* 101 */           p.sendMessage("§7[§6§l!§7] §cVocê não pode colocar agua aqui!");
/*     */         }
/*     */       }
/* 104 */       else if (lado == BlockFace.SOUTH)
/*     */       {
/* 106 */         final Block b2 = b.getWorld().getBlockAt(x, y, z + 1);
/* 107 */         if (b2.getType() == Material.AIR)
/*     */         {
/* 109 */           b2.setType(Material.STATIONARY_WATER);
/* 110 */           this.naoescorrer.add(b2);
/* 111 */           Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 115 */               b2.setType(Material.AIR);
/* 116 */               JellyFish.this.naoescorrer.remove(b2);
/*     */             }
/*     */             
/* 119 */           }, 60L);
/*     */         }
/*     */         else
/*     */         {
/* 123 */           p.sendMessage("§7[§6§l!§7] §cVocê não pode colocar agua aqui!");
/*     */         }
/*     */       }
/* 126 */       else if (lado == BlockFace.WEST)
/*     */       {
/* 128 */         final Block b2 = b.getWorld().getBlockAt(x - 1, y, z);
/* 129 */         if (b2.getType() == Material.AIR)
/*     */         {
/* 131 */           b2.setType(Material.STATIONARY_WATER);
/* 132 */           this.naoescorrer.add(b2);
/* 133 */           Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 137 */               b2.setType(Material.AIR);
/* 138 */               JellyFish.this.naoescorrer.remove(b2);
/*     */             }
/*     */             
/* 141 */           }, 60L);
/*     */         }
/*     */         else
/*     */         {
/* 145 */           p.sendMessage("§7[§6§l!§7] §cVocê não pode colocar agua aqui!");
/*     */         }
/*     */       }
/* 148 */       else if (lado == BlockFace.EAST)
/*     */       {
/* 150 */         final Block b2 = b.getWorld().getBlockAt(x + 1, y, z);
/* 151 */         if (b2.getType() == Material.AIR)
/*     */         {
/* 153 */           b2.setType(Material.STATIONARY_WATER);
/* 154 */           this.naoescorrer.add(b2);
/* 155 */           Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 159 */               b2.setType(Material.AIR);
/* 160 */               JellyFish.this.naoescorrer.remove(b2);
/*     */             }
/*     */             
/* 163 */           }, 60L);
/*     */         }
/*     */         else
/*     */         {
/* 167 */           p.sendMessage("§7[§6§l!§7] §cVocê não pode colocar agua aqui!");
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void naoescorrer(BlockPhysicsEvent event)
/*     */   {
/* 176 */     Block b = event.getBlock();
/* 177 */     if ((b.getType() == Material.STATIONARY_WATER) && (this.naoescorrer.contains(b))) {
/* 178 */       event.setCancelled(true);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void veneno(PlayerMoveEvent event) {
/* 184 */     Player p = event.getPlayer();
/* 185 */     Block b = p.getLocation().getBlock();
/* 186 */     if (KitAPI.getkit(p) == "JellyFish") {
/* 187 */       p.removePotionEffect(PotionEffectType.POISON);
/* 188 */     } else if ((b.getType() == Material.STATIONARY_WATER) && (!p.getInventory().contains(Material.CLAY_BALL)) && (this.naoescorrer.contains(b))) {
/* 189 */       p.addPotionEffect(new org.bukkit.potion.PotionEffect(PotionEffectType.POISON, 50, 0));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\JellyFish.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */