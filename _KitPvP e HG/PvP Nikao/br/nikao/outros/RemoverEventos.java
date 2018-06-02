/*     */ package br.nikao.outros;
/*     */ 
/*     */ import br.nikao.Main;
/*     */ import br.nikao.minigames.VoidChallenge;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.block.SignChangeEvent;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*     */ import org.bukkit.event.entity.EntityExplodeEvent;
/*     */ import org.bukkit.event.entity.FoodLevelChangeEvent;
/*     */ import org.bukkit.event.player.PlayerDropItemEvent;
/*     */ import org.bukkit.event.player.PlayerLoginEvent;
/*     */ import org.bukkit.event.player.PlayerLoginEvent.Result;
/*     */ import org.bukkit.event.weather.WeatherChangeEvent;
/*     */ 
/*     */ public class RemoverEventos implements org.bukkit.event.Listener
/*     */ {
/*     */   @EventHandler
/*     */   public void fullJoin(PlayerLoginEvent e)
/*     */   {
/*  24 */     Player p = e.getPlayer();
/*  25 */     if (e.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
/*  26 */       if (p.hasPermission("ng.cheio")) {
/*  27 */         e.setResult(PlayerLoginEvent.Result.ALLOWED);
/*     */       } else {
/*  29 */         e.setKickMessage(Main.getInstance().getConfig().getString("Cheio"));
/*     */       }
/*  31 */     } else if (e.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST)
/*  32 */       e.setKickMessage("§c§lEstamos em Manutenção!");
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void Fome(FoodLevelChangeEvent e) {
/*  37 */     e.setCancelled(true);
/*  38 */     e.setFoodLevel(20);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void BaterEntity(EntityDamageByEntityEvent e) {
/*  43 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
/*  44 */       int porcentage = 50;
/*  45 */       e.setDamage(e.getDamage() * porcentage / 100.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void Chuva(WeatherChangeEvent e) {
/*  51 */     if (e.toWeatherState()) {
/*  52 */       e.setCancelled(true);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void CancelarDrops(PlayerDropItemEvent e) {
/*  58 */     Material t = e.getItemDrop().getItemStack().getType();
/*  59 */     if ((t.equals(Material.ENDER_CHEST)) || (t.equals(Material.EMERALD)) || 
/*  60 */       (t.equals(Material.PAPER)) || (t.equals(Material.STONE_SWORD)) || 
/*  61 */       (t.equals(Material.WOOD_SWORD)) || (t.equals(Material.FIREWORK)) || 
/*  62 */       (t.equals(Material.STONE_AXE)) || (t.equals(Material.PUMPKIN)) || 
/*  63 */       (t.equals(Material.REDSTONE_TORCH_ON)) || (t.equals(Material.BLAZE_ROD)) || 
/*  64 */       (t.equals(Material.DIAMOND_SWORD)) || (t.equals(Material.MILK_BUCKET)) || 
/*  65 */       (t.equals(Material.SLIME_BALL)) || (t.equals(Material.SPONGE)) || 
/*  66 */       (t.equals(Material.WOOD_HOE)) || (t.equals(Material.STRING)) || 
/*  67 */       (t.equals(Material.REDSTONE_BLOCK)) || (t.equals(Material.LAPIS_BLOCK)) || 
/*  68 */       (t.equals(Material.STONE_AXE)) || (t.equals(Material.SADDLE)) || 
/*  69 */       (t.equals(Material.MILK_BUCKET)) || (t.equals(Material.COMPASS)) || 
/*  70 */       (t.equals(Material.POTION)) || (t.equals(Material.LEATHER_CHESTPLATE)) || 
/*  71 */       (t.equals(Material.LEASH)) || (t.equals(Material.SNOW_BALL)) || 
/*  72 */       (t.equals(Material.TNT)) || (t.equals(Material.IRON_FENCE)) || 
/*  73 */       (t.equals(Material.PORTAL)) || (t.equals(Material.BEACON)) || 
/*  74 */       (t.equals(Material.BEACON)) || (t.equals(Material.EMERALD_BLOCK)) || 
/*  75 */       (t.equals(Material.WATCH)) || (t.equals(Material.NETHER_STAR)) || 
/*  76 */       (t.equals(Material.DIAMOND)) || (t.equals(Material.WRITTEN_BOOK)) || 
/*  77 */       (t.equals(Material.STAINED_GLASS_PANE)) || (t.equals(Material.CHEST)) || 
/*  78 */       (t.equals(Material.PISTON_STICKY_BASE)) || (t.equals(Material.NAME_TAG)) || 
/*  79 */       (t.equals(Material.EXP_BOTTLE)) || (t.equals(Material.STORAGE_MINECART)) || 
/*  80 */       (t.equals(Material.FISHING_ROD)) || (t.equals(Material.SPECKLED_MELON)) || 
/*  81 */       (t.equals(Material.BOW)) || (t.equals(Material.ARROW)) || (t.equals(Material.STICK)) || 
/*  82 */       (t.equals(Material.NETHER_FENCE)) || (t.equals(Material.SLIME_BALL)) || 
/*  83 */       (t.equals(Material.BOOK)) || (t.equals(Material.STATIONARY_WATER)) || 
/*  84 */       (t.equals(Material.QUARTZ)) || (t.equals(Material.FEATHER)) || 
/*  85 */       (t.equals(Material.WOOL)) || (t.equals(Material.STATIONARY_WATER)) || 
/*  86 */       (t.equals(Material.CAKE)) || (t.equals(Material.SKULL_ITEM)) || 
/*  87 */       (t.equals(Material.ENCHANTED_BOOK)) || (t.equals(Material.ENCHANTMENT_TABLE))) {
/*  88 */       e.setCancelled(true);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void explosão(EntityExplodeEvent e) {
/*  94 */     e.setCancelled(true);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void CorPlaca(SignChangeEvent e) {
/*  99 */     if (e.getLine(0).contains("&")) {
/* 100 */       e.setLine(0, e.getLine(0).replace("&", "§"));
/*     */     }
/* 102 */     if (e.getLine(1).contains("&")) {
/* 103 */       e.setLine(1, e.getLine(1).replace("&", "§"));
/*     */     }
/* 105 */     if (e.getLine(2).contains("&")) {
/* 106 */       e.setLine(2, e.getLine(2).replace("&", "§"));
/*     */     }
/* 108 */     if (e.getLine(3).contains("&"))
/* 109 */       e.setLine(3, e.getLine(3).replace("&", "§"));
/*     */   }
/*     */   
/*     */   public void chuva(WeatherChangeEvent e) {
/* 113 */     e.setCancelled(true);
/*     */   }
/*     */   
/*     */ 
/*     */   @EventHandler
/*     */   public void CairVoid(EntityDamageEvent e)
/*     */   {
/* 120 */     if ((e.getEntity() instanceof Player)) {
/* 121 */       Player p = (Player)e.getEntity();
/* 122 */       if (e.getCause() == EntityDamageEvent.DamageCause.VOID) {
/* 123 */         if (!VoidChallenge.voidchallenge.contains(p.getName())) {
/* 124 */           e.setDamage(99999);
/*     */         } else {}
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\RemoverEventos.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */