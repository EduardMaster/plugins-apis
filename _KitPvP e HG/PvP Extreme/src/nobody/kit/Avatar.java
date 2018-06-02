/*     */ package nobody.kit;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;

import nobody.eventos.KitAPI;
import nobody.main.Main;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Effect;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.LivingEntity;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.entity.Snowball;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.player.PlayerDropItemEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.metadata.FixedMetadataValue;
/*     */ import org.bukkit.util.BlockIterator;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ public class Avatar implements org.bukkit.event.Listener
/*     */ {
/*  33 */   ArrayList<Snowball> Soltou = new ArrayList<Snowball>();
/*     */   public int id1;
/*  35 */   ArrayList<Snowball> Soltou1 = new ArrayList<Snowball>();
/*     */   
/*     */   public int id11;
/*  38 */   public static ArrayList<String> Avatar2 = new ArrayList<String>();
/*  39 */   public static ArrayList<String> Ferro = new ArrayList<String>();
/*  40 */   public static ArrayList<String> Red = new ArrayList<String>();
/*  41 */   public static ArrayList<String> Terras = new ArrayList<String>();
/*  42 */   public static List<Player> Tempo = new ArrayList<Player>();
/*     */   
/*     */   @EventHandler
/*     */   public void Trocar(PlayerInteractEvent e) {
/*  46 */     Player p = e.getPlayer();
/*     */     
/*  48 */     ItemStack Terra = new ItemStack(Material.GRASS);
/*  49 */     ItemMeta terram = Terra.getItemMeta();
/*  50 */     terram.setDisplayName(ChatColor.DARK_GREEN + "Terra");
/*  51 */     Terra.setItemMeta(terram);
/*     */     
/*  53 */     ItemStack Agua = new ItemStack(Material.LAPIS_BLOCK);
/*  54 */     ItemMeta Aguam = Agua.getItemMeta();
/*  55 */     Aguam.setDisplayName(ChatColor.DARK_AQUA + "Agua");
/*  56 */     Agua.setItemMeta(Aguam);
/*     */     
/*  58 */     ItemStack Aguac = new ItemStack(Material.BEACON);
/*  59 */     ItemMeta Aguacm = Aguac.getItemMeta();
/*  60 */     Aguacm.setDisplayName(ChatColor.DARK_AQUA + "B");
/*  61 */     Aguac.setItemMeta(Aguacm);
/*     */     
/*  63 */     ItemStack AR = new ItemStack(Material.WOOL);
/*  64 */     ItemMeta ARm = AR.getItemMeta();
/*  65 */     ARm.setDisplayName("AR");
/*  66 */     AR.setItemMeta(ARm);
/*     */     
/*  68 */     ItemStack Fogo = new ItemStack(Material.REDSTONE_BLOCK);
/*  69 */     ItemMeta Fogom = Fogo.getItemMeta();
/*  70 */     Fogom.setDisplayName(ChatColor.RED + "Fogo");
/*  71 */     Fogo.setItemMeta(Fogom);
/*  72 */     if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && (KitAPI.getkit(p) == "Avatar") && (p.getItemInHand().getType() == Material.WOOL)) {
/*  73 */       p.setItemInHand(AR);
/*  74 */       Ferro.add(p.getName());
/*  75 */     } else if ((Ferro.contains(p.getName())) && ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && (KitAPI.getkit(p) == "Avatar") && (p.getItemInHand().equals(AR))) {
/*  76 */       p.setItemInHand(Agua);
/*  77 */       Ferro.remove(p.getName());
/*  78 */       Avatar2.add(p.getName());
/*  79 */     } else if ((Avatar2.contains(p.getName())) && ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && (KitAPI.getkit(p) == "Avatar") && (p.getItemInHand().equals(Agua))) {
/*  80 */       p.setItemInHand(Terra);
/*  81 */       Avatar2.remove(p.getName());
/*  82 */       Terras.add(p.getName());
/*  83 */     } else if ((Terras.contains(p.getName())) && (Terras.contains(p.getName())) && ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && (KitAPI.getkit(p) == "Avatar") && (p.getItemInHand().equals(Terra))) {
/*  84 */       p.setItemInHand(Fogo);
/*  85 */       Terras.remove(p.getName());
/*  86 */       Red.add(p.getName());//
/*     */     }
/*  88 */     else if ((Red.contains(p.getName())) && ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && (KitAPI.getkit(p) == "Avatar") && 
/*  89 */       (p.getItemInHand().equals(Fogo)))
/*     */     {
/*  91 */       p.setItemInHand(AR);
/*  92 */       Red.remove(p.getName());
/*  93 */       Ferro.add(p.getName());
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void AvatarAr(PlayerInteractEvent event)
/*     */   {
/* 100 */     final Player p = event.getPlayer();
/* 101 */     if ((Ferro.contains(p.getName())) && ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && (KitAPI.getkit(p) == "Avatar") && 
/* 102 */       (p.getItemInHand().getType() == Material.WOOL)) {
/* 103 */       event.setCancelled(true);
/* 104 */       if (!Tempo.contains(p))
/*     */       {
/* 106 */         Tempo.add(p);
/*     */         
/* 108 */         Vector Ferro = p.getLocation().getDirection().normalize().multiply(55);
/* 109 */         Snowball FerroH = (Snowball)p.launchProjectile(Snowball.class);
/* 110 */         FerroH.setVelocity(Ferro);
/* 111 */         FerroH.setMetadata("Ar", new FixedMetadataValue(Main.instance, Boolean.valueOf(true)));
/*     */         
/* 113 */         Location pegou = p.getEyeLocation();
/*     */         
/* 115 */         BlockIterator Ferrao = new BlockIterator(pegou, 0.0D, 40);
/* 116 */         while (Ferrao.hasNext())
/*     */         {
/* 118 */           Location Ferrao2 = Ferrao.next().getLocation();
/*     */           
/* 120 */           Effect camelo = Effect.STEP_SOUND;
/* 121 */           p.playSound(p.getLocation(), Sound.STEP_WOOL, 5.5F, 5.5F);
/* 122 */           p.playSound(p.getLocation(), Sound.STEP_WOOL, 1.5F, 1.5F);
/* 123 */           p.playSound(p.getLocation(), Sound.STEP_WOOL, 2.5F, 2.5F);
/* 124 */           p.playSound(p.getLocation(), Sound.STEP_WOOL, 3.5F, 3.5F);
/* 125 */           p.playSound(p.getLocation(), Sound.STEP_WOOL, 4.5F, 4.5F);
/*     */           
/* 127 */           p.getWorld().playEffect(Ferrao2, camelo, 35);
/*     */         }
/* 129 */         this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 133 */             if (Avatar.Tempo.contains(p))
/*     */             {
/* 135 */               Avatar.Tempo.remove(p);
/* 136 */               p.sendMessage("§bVoce ja pode usar o kit !");
/* 137 */               p.playSound(p.getLocation(), Sound.LEVEL_UP, 15.5F, 15.5F);
/*     */             }
/*     */             
/*     */           }
/* 141 */         }, 250L);
/*     */       }
/*     */       else
/*     */       {
/* 145 */         p.sendMessage("§cAguarde para usar o kit !");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void EntityDamageEvent(EntityDamageByEntityEvent event)
/*     */   {
/* 153 */     Entity Tomou2 = event.getEntity();
/* 154 */     if ((event.getDamager() instanceof Snowball))
/*     */     {
/* 156 */       Snowball Tomou = (Snowball)event.getDamager();
/* 157 */       if (Tomou.hasMetadata("Ar"))
/*     */       {
/* 159 */         event.setDamage(8.0D);
/* 160 */         ((LivingEntity)Tomou2).addPotionEffect(new org.bukkit.potion.PotionEffect(org.bukkit.potion.PotionEffectType.BLINDNESS, 100, 0), true);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void AvatarAr1(PlayerInteractEvent event)
/*     */   {
/* 168 */     final Player p = event.getPlayer();
/* 169 */     if ((Avatar2.contains(p.getName())) && ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && (KitAPI.getkit(p) == "Avatar") && 
/* 170 */       (p.getItemInHand().getType() == Material.LAPIS_BLOCK)) {
/* 171 */       event.setCancelled(true);
/* 172 */       if (!Tempo.contains(p))
/*     */       {
/* 174 */         Tempo.add(p);
/*     */         
/* 176 */         Vector Agua = p.getLocation().getDirection().normalize().multiply(55);
/* 177 */         Snowball AguaH = (Snowball)p.launchProjectile(Snowball.class);
/* 178 */         AguaH.setVelocity(Agua);
/* 179 */         AguaH.setMetadata("Agua", new FixedMetadataValue(Main.instance, Boolean.valueOf(true)));
/*     */         
/* 181 */         Location pegou = p.getEyeLocation();
/*     */         
/* 183 */         BlockIterator Aguao = new BlockIterator(pegou, 0.0D, 40);
/* 184 */         while (Aguao.hasNext())
/*     */         {
/* 186 */           Location Aguao2 = Aguao.next().getLocation();
/*     */           
/* 188 */           Effect camelo = Effect.STEP_SOUND;
/* 189 */           p.playSound(p.getLocation(), Sound.STEP_WOOD, 5.5F, 5.5F);
/* 190 */           p.playSound(p.getLocation(), Sound.STEP_WOOD, 1.5F, 1.5F);
/* 191 */           p.playSound(p.getLocation(), Sound.STEP_WOOD, 2.5F, 2.5F);
/* 192 */           p.playSound(p.getLocation(), Sound.STEP_WOOD, 3.5F, 3.5F);
/* 193 */           p.playSound(p.getLocation(), Sound.STEP_WOOD, 4.5F, 4.5F);
/*     */           
/* 195 */           p.getWorld().playEffect(Aguao2, camelo, 9);
/*     */         }
/* 197 */         this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 201 */             if (Avatar.Tempo.contains(p))
/*     */             {
/* 203 */               Avatar.Tempo.remove(p);
/* 204 */               p.sendMessage("§bVoce ja pode usar o kit !");
/* 205 */               p.playSound(p.getLocation(), Sound.LEVEL_UP, 15.5F, 15.5F);
/*     */             }
/*     */             
/*     */           }
/* 209 */         }, 250L);
/*     */       }
/*     */       else
/*     */       {
/* 213 */         p.sendMessage("§cAguarde para usar o kit !");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void EntityDamageEvent11(EntityDamageByEntityEvent event)
/*     */   {
/* 221 */     Entity Tomou2 = event.getEntity();
/* 222 */     if ((event.getDamager() instanceof Snowball))
/*     */     {
/* 224 */       Snowball Tomou = (Snowball)event.getDamager();
/* 225 */       if (Tomou.hasMetadata("Agua"))
/*     */       {
/* 227 */         event.setDamage(11.0D);
/* 228 */         ((LivingEntity)Tomou2).addPotionEffect(new org.bukkit.potion.PotionEffect(org.bukkit.potion.PotionEffectType.POISON, 300, 0), true);
/*     */         
/* 230 */         Vector vector = Tomou2.getLocation().getDirection();
/* 231 */         vector.multiply(-1.0F);
/* 232 */         Tomou2.setVelocity(vector);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void AvatarAr11(PlayerInteractEvent event)
/*     */   {
/* 240 */     final Player p = event.getPlayer();
/* 241 */     if ((Red.contains(p.getName())) && ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && (KitAPI.getkit(p) == "Avatar") && 
/* 242 */       (p.getItemInHand().getType() == Material.REDSTONE_BLOCK)) {
/* 243 */       event.setCancelled(true);
/* 244 */       if (!Tempo.contains(p))
/*     */       {
/* 246 */         Tempo.add(p);
/*     */         
/* 248 */         Vector Fogo = p.getLocation().getDirection().normalize().multiply(55);
/* 249 */         Snowball FogoH = (Snowball)p.launchProjectile(Snowball.class);
/* 250 */         FogoH.setVelocity(Fogo);
/* 251 */         FogoH.setMetadata("Fogo", new FixedMetadataValue(Main.instance, Boolean.valueOf(true)));
/*     */         
/* 253 */         Location pegou = p.getEyeLocation();
/*     */         
/* 255 */         BlockIterator Fogao = new BlockIterator(pegou, 0.0D, 40);
/* 256 */         while (Fogao.hasNext())
/*     */         {
/* 258 */           Location Fogao2 = Fogao.next().getLocation();
/*     */           
/* 260 */           Effect camelo = Effect.STEP_SOUND;
/* 261 */           p.playSound(p.getLocation(), Sound.FIRE, 5.5F, 5.5F);
/* 262 */           p.playSound(p.getLocation(), Sound.FIRE, 1.5F, 1.5F);
/* 263 */           p.playSound(p.getLocation(), Sound.FIRE, 2.5F, 2.5F);
/* 264 */           p.playSound(p.getLocation(), Sound.FIRE, 3.5F, 3.5F);
/* 265 */           p.playSound(p.getLocation(), Sound.FIRE, 4.5F, 4.5F);
/*     */           
/* 267 */           p.getWorld().playEffect(Fogao2, camelo, 10);
/*     */         }
/* 269 */         this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 273 */             if (Avatar.Tempo.contains(p))
/*     */             {
/* 275 */               Avatar.Tempo.remove(p);
/* 276 */               p.sendMessage("§bVoce ja pode usar o kit !");
/* 277 */               p.playSound(p.getLocation(), Sound.LEVEL_UP, 15.5F, 15.5F);
/*     */             }
/*     */             
/*     */           }
/* 281 */         }, 250L);
/*     */       }
/*     */       else
/*     */       {
/* 285 */         p.sendMessage("§cAguarde para usar o kit !");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void EntityDamageEvent1(EntityDamageByEntityEvent event)
/*     */   {
/* 293 */     Entity Tomou2 = event.getEntity();
/* 294 */     if ((event.getDamager() instanceof Snowball))
/*     */     {
/* 296 */       Snowball Tomou = (Snowball)event.getDamager();
/* 297 */       if (Tomou.hasMetadata("Fogo"))
/*     */       {
/* 299 */         event.setDamage(12.0D);
/* 300 */         Tomou2.setFireTicks(150);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void AvatarTerra(PlayerInteractEvent event)
/*     */   {
/* 308 */     final Player p = event.getPlayer();
/* 309 */     if ((Terras.contains(p.getName())) && ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && (KitAPI.getkit(p) == "Avatar") && 
/* 310 */       (p.getItemInHand().getType() == Material.GRASS)) {
/* 311 */       event.setCancelled(true);
/* 312 */       if (!Tempo.contains(p))
/*     */       {
/* 314 */         Tempo.add(p);
/* 315 */         Vector Terra = p.getLocation().getDirection().normalize().multiply(55);
/* 316 */         Snowball TerraH = (Snowball)p.launchProjectile(Snowball.class);
/* 317 */         TerraH.setVelocity(Terra);
/* 318 */         TerraH.setMetadata("Terra", new FixedMetadataValue(Main.instance, Boolean.valueOf(true)));
/*     */         
/* 320 */         Location pegou = p.getEyeLocation();
/*     */         
/* 322 */         BlockIterator Terrao = new BlockIterator(pegou, 0.0D, 40);
/* 323 */         while (Terrao.hasNext())
/*     */         {
/* 325 */           Location Terrao2 = Terrao.next().getLocation();
/*     */           
/* 327 */           Effect camelo = Effect.STEP_SOUND;
/*     */           
/* 329 */           p.playSound(p.getLocation(), Sound.STEP_GRASS, 5.5F, 5.5F);
/* 330 */           p.playSound(p.getLocation(), Sound.STEP_GRASS, 1.5F, 1.5F);
/* 331 */           p.playSound(p.getLocation(), Sound.STEP_GRASS, 2.5F, 2.5F);
/* 332 */           p.playSound(p.getLocation(), Sound.STEP_GRASS, 3.5F, 3.5F);
/* 333 */           p.playSound(p.getLocation(), Sound.STEP_GRASS, 4.5F, 4.5F);
/*     */           
/* 335 */           p.getWorld().playEffect(Terrao2, camelo, 2);
/*     */         }
/* 337 */         this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 341 */             if (Avatar.Tempo.contains(p))
/*     */             {
/* 343 */               Avatar.Tempo.remove(p);
/* 344 */               p.sendMessage("§7[§6§l!§7] §bVoce ja pode usar o kit !");
/* 345 */               p.playSound(p.getLocation(), Sound.LEVEL_UP, 15.5F, 15.5F);
/*     */             }
/*     */             
/*     */           }
/* 349 */         }, 250L);
/*     */       }
/*     */       else
/*     */       {
/* 353 */         p.sendMessage("§7[§6§l!§7] §cAguarde para usar o kit !");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void EntityDamageEvent111(EntityDamageByEntityEvent event)
/*     */   {
/* 361 */     Entity Tomou2 = event.getEntity();
/* 362 */     if ((event.getDamager() instanceof Snowball))
/*     */     {
/* 364 */       Snowball Tomou = (Snowball)event.getDamager();
/* 365 */       if (Tomou.hasMetadata("Terra"))
/*     */       {
/* 367 */         event.setDamage(14.0D);
/*     */         
/* 369 */         Vector vector = Tomou2.getLocation().getDirection();
/* 370 */         vector.multiply(-3.2F);
/* 371 */         Tomou2.setVelocity(vector);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void drop(PlayerDropItemEvent e)
/*     */   {
/* 379 */     Player p = e.getPlayer();
/* 380 */     ItemStack item = e.getItemDrop().getItemStack();
/* 381 */     if ((Ferro.contains(p.getName())) && (item.getType() == Material.WOOL))
/*     */     {
/* 383 */       e.setCancelled(true);
/* 384 */       p.sendMessage("§7[§6§l!§7] §cVoce nao pode dropar este item !");
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void drop2(PlayerDropItemEvent e)
/*     */   {
/* 391 */     Player p = e.getPlayer();
/* 392 */     ItemStack item = e.getItemDrop().getItemStack();
/* 393 */     if ((Avatar2.contains(p.getName())) && (item.getType() == Material.LAPIS_BLOCK))
/*     */     {
/* 395 */       e.setCancelled(true);
/* 396 */       p.sendMessage("§7[§6§l!§7] §cVoce nao pode dropar este item !");
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void drop3(PlayerDropItemEvent e)
/*     */   {
/* 403 */     Player p = e.getPlayer();
/* 404 */     ItemStack item = e.getItemDrop().getItemStack();
/* 405 */     if ((Red.contains(p.getName())) && (item.getType() == Material.REDSTONE_BLOCK))
/*     */     {
/* 407 */       e.setCancelled(true);
/* 408 */       p.sendMessage("§7[§6§l!§7] §cVoce nao pode dropar este item !");
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void drop4(PlayerDropItemEvent e)
/*     */   {
/* 415 */     Player p = e.getPlayer();
/* 416 */     ItemStack item = e.getItemDrop().getItemStack();
/* 417 */     if ((Terras.contains(p.getName())) && (item.getType() == Material.GRASS))
/*     */     {
/* 419 */       e.setCancelled(true);
/* 420 */       p.sendMessage("§7[§6§l!§7] §cVoce nao pode dropar este item !");
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void ColocarBlocos(org.bukkit.event.block.BlockPlaceEvent e)
/*     */   {
/* 427 */     Player p = e.getPlayer();
/* 428 */     if (KitAPI.getkit(p) == "Avatar") {
/* 429 */       e.setCancelled(true);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Avatar.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */