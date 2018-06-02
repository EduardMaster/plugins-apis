/*     */ package br.nikao.outros;
/*     */ 
/*     */ import br.nikao.Main;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Color;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.inventory.meta.LeatherArmorMeta;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class WarpsAPI implements Listener, org.bukkit.command.CommandExecutor
/*     */ {
/*  27 */   public static final List<Player> warping = new ArrayList();
/*  28 */   public static List<String> tanawarp = new ArrayList();
/*  29 */   public static ArrayList<String> oitc = new ArrayList();
/*     */   
/*     */ 
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  34 */     final Player p = (Player)sender;
/*  35 */     if (cmd.getName().equalsIgnoreCase("setrdm")) {
/*  36 */       if (!p.hasPermission("ng.warp")) {
/*  37 */         sender.sendMessage("§cSem Permissão!");
/*  38 */         return true;
/*     */       }
/*  40 */       Main.getInstance().getConfig().set("Warps.RdmWorld", p.getLocation().getWorld().getName());
/*  41 */       Main.getInstance().getConfig().set("Warps.RdmX", Double.valueOf(p.getLocation().getX()));
/*  42 */       Main.getInstance().getConfig().set("Warps.RdmY", Double.valueOf(p.getLocation().getY()));
/*  43 */       Main.getInstance().getConfig().set("Warps.RdmZ", Double.valueOf(p.getLocation().getZ()));
/*  44 */       Main.getInstance().saveConfig();
/*  45 */       p.sendMessage("§6§lWarp: §7A warp RDM foi setada com sucesso!");
/*  46 */       return true;
/*     */     }
/*  48 */     if (cmd.getName().equalsIgnoreCase("setmdr"))
/*     */     {
/*  50 */       if (!p.hasPermission("ng.warp"))
/*     */       {
/*  52 */         sender.sendMessage("§cSem Permissão!");
/*  53 */         return true;
/*     */       }
/*  55 */       Main.getInstance().getConfig().set("Warps.MdrWorld", p.getLocation().getWorld().getName());
/*  56 */       Main.getInstance().getConfig().set("Warps.MdrX", Double.valueOf(p.getLocation().getX()));
/*  57 */       Main.getInstance().getConfig().set("Warps.MdrY", Double.valueOf(p.getLocation().getY()));
/*  58 */       Main.getInstance().getConfig().set("Warps.MdrZ", Double.valueOf(p.getLocation().getZ()));
/*  59 */       Main.getInstance().saveConfig();
/*  60 */       p.sendMessage("§6§lWarp: §7A warp MDR foi setada com sucesso!");
/*  61 */       return true;
/*     */     }
/*  63 */     if (cmd.getName().equalsIgnoreCase("setspawn"))
/*     */     {
/*  65 */       if (!p.hasPermission("ng.warp"))
/*     */       {
/*  67 */         sender.sendMessage("§cSem Permissão!");
/*  68 */         return true;
/*     */       }
/*  70 */       Main.getInstance().getConfig().set("Warps.SpawnWorld", p.getLocation().getWorld().getName());
/*  71 */       Main.getInstance().getConfig().set("Warps.SpawnX", Double.valueOf(p.getLocation().getX()));
/*  72 */       Main.getInstance().getConfig().set("Warps.SpawnY", Double.valueOf(p.getLocation().getY()));
/*  73 */       Main.getInstance().getConfig().set("Warps.SpawnZ", Double.valueOf(p.getLocation().getZ()));
/*  74 */       Main.getInstance().saveConfig();
/*  75 */       World world = p.getWorld();
/*  76 */       Location loc = p.getLocation();
/*  77 */       world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
/*  78 */       p.sendMessage("§6§lWarp: §7O spawn foi setado com sucesso");
/*  79 */       return true;
/*     */     }
/*  81 */     if (cmd.getName().equalsIgnoreCase("setfps"))
/*     */     {
/*  83 */       if (!p.hasPermission("ng.warp")) {
/*  84 */         sender.sendMessage("§cSem Permissão!");
/*  85 */         return true;
/*     */       }
/*  87 */       Main.getInstance().getConfig().set("Warps.FpsWorld", p.getLocation().getWorld().getName());
/*  88 */       Main.getInstance().getConfig().set("Warps.FpsX", Double.valueOf(p.getLocation().getX()));
/*  89 */       Main.getInstance().getConfig().set("Warps.FpsY", Double.valueOf(p.getLocation().getY()));
/*  90 */       Main.getInstance().getConfig().set("Warps.FpsZ", Double.valueOf(p.getLocation().getZ()));
/*  91 */       Main.getInstance().saveConfig();
/*  92 */       p.sendMessage("§6§lWarp: §7A warp FPS foi setada com sucesso!");
/*  93 */       return true;
/*     */     }
/*     */     
/*  96 */     if (cmd.getName().equalsIgnoreCase("setchallenge")) {
/*  97 */       if (!p.hasPermission("ng.warp")) {
/*  98 */         sender.sendMessage("§cSem Permissão!");
/*  99 */         return true;
/*     */       }
/* 101 */       Main.getInstance().getConfig().set("Warps.ChallengeWorld", p.getLocation().getWorld().getName());
/* 102 */       Main.getInstance().getConfig().set("Warps.ChallengeX", Double.valueOf(p.getLocation().getX()));
/* 103 */       Main.getInstance().getConfig().set("Warps.ChallengeY", Double.valueOf(p.getLocation().getY()));
/* 104 */       Main.getInstance().getConfig().set("Warps.ChallengeZ", Double.valueOf(p.getLocation().getZ()));
/* 105 */       Main.getInstance().saveConfig();
/* 106 */       p.sendMessage("§6§lWarp: §7A warp Lava-Challenge foi setada com sucesso!");
/* 107 */       return true;
/*     */     }
/*     */     
/* 110 */     if (cmd.getName().equalsIgnoreCase("rdm")) {
/* 111 */       p.sendMessage("§6§lINFO: §7Você será teleportado em 5 segundos");
/* 112 */       p.getInventory().setArmorContents(null);
/* 113 */       p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 2, true));
/* 114 */       p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 2, true));
/* 115 */       p.setHealth(1);
/* 116 */       p.setMaxHealth(1);
/* 117 */       p.getInventory().clear();
/* 118 */       warping.add(p);
/* 119 */       Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/* 121 */           if (WarpsAPI.warping.contains(p)) {
/* 122 */             for (PotionEffect effect : p.getActivePotionEffects()) {
/* 123 */               p.removePotionEffect(effect.getType());
/*     */             }
/* 125 */             World w = Bukkit.getServer().getWorld(Main.getInstance().getConfig().getString("Warps.RdmWorld"));
/* 126 */             double x = Main.getInstance().getConfig().getDouble("Warps.RdmX");
/* 127 */             double y = Main.getInstance().getConfig().getDouble("Warps.RdmY");
/* 128 */             double z = Main.getInstance().getConfig().getDouble("Warps.RdmZ");
/* 129 */             PlayerInventory inv = p.getInventory();
/*     */             try {
/* 131 */               p.teleport(new Location(w, x, y, z));
/*     */             } catch (Exception e) {
/* 133 */               p.sendMessage("§4§lERRO: §7A warp RDM não foi setada");
/*     */             }
/* 135 */             p.setHealth(1);
/* 136 */             p.setMaxHealth(1);
/* 137 */             p.getInventory().clear();
/* 138 */             KitAPI.setKit(p, "PvP");
/*     */             
/* 140 */             ItemStack espada = new ItemStack(Material.STONE_SWORD);
/* 141 */             inv.addItem(new ItemStack[] { espada });
/*     */             
/* 143 */             ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
/* 144 */             ItemMeta sopameta = sopa.getItemMeta();
/*     */             
/* 146 */             sopa.setItemMeta(sopameta);
/*     */             
/* 148 */             ItemStack cogu1 = new ItemStack(Material.BROWN_MUSHROOM, 64);
/* 149 */             ItemMeta cogu1meta = cogu1.getItemMeta();
/*     */             
/* 151 */             cogu1.setItemMeta(cogu1meta);
/*     */             
/* 153 */             ItemStack cogu2 = new ItemStack(Material.RED_MUSHROOM, 64);
/* 154 */             ItemMeta cogu2meta = cogu2.getItemMeta();
/*     */             
/* 156 */             cogu2.setItemMeta(cogu2meta);
/*     */             
/* 158 */             ItemStack pote = new ItemStack(Material.BOWL, 64);
/* 159 */             ItemMeta potemeta = pote.getItemMeta();
/*     */             
/* 161 */             pote.setItemMeta(potemeta);
/*     */             
/* 163 */             for (int i = 1; i < 35; i++) {
/* 164 */               p.getInventory().addItem(new ItemStack[] { sopa });
/* 165 */               p.getInventory().setItem(15, cogu1);
/* 166 */               p.getInventory().setItem(14, cogu2);
/* 167 */               p.getInventory().setItem(13, pote);
/*     */             }
/*     */             
/* 170 */             p.sendMessage("§7§lVocê foi teleportado");
/* 171 */             p.getInventory().setHelmet(new ItemStack(Material.AIR));
/* 172 */             p.getInventory().setChestplate(new ItemStack(Material.AIR));
/* 173 */             p.getInventory().setLeggings(new ItemStack(Material.AIR));
/* 174 */             p.getInventory().setBoots(new ItemStack(Material.AIR));
/* 175 */             p.setMaxHealth(20);
/* 176 */             p.setHealth(20);
/* 177 */             WarpsAPI.warping.remove(p);
/* 178 */             WarpsAPI.tanawarp.add(p.getName());
/*     */           }
/*     */           
/*     */         }
/* 182 */       }, 100L);
/*     */     }
/* 184 */     if (cmd.getName().equalsIgnoreCase("mdr")) {
/* 185 */       p.sendMessage("§6§lINFO: §7Você será teleportado em 5 segundos");
/* 186 */       p.getInventory().setArmorContents(null);
/* 187 */       p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 2, true));
/* 188 */       p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 2, true));
/* 189 */       p.setHealth(1);
/* 190 */       p.setMaxHealth(1);
/* 191 */       p.getInventory().clear();
/* 192 */       warping.add(p);
/* 193 */       Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/* 195 */           if (WarpsAPI.warping.contains(p)) {
/* 196 */             for (PotionEffect effect : p.getActivePotionEffects()) {
/* 197 */               p.removePotionEffect(effect.getType());
/*     */             }
/* 199 */             KitAPI.setKit(p, "PvP");
/* 200 */             World w = Bukkit.getServer().getWorld(Main.getInstance().getConfig().getString("Warps.MdrWorld"));
/* 201 */             double x = Main.getInstance().getConfig().getDouble("Warps.MdrX");
/* 202 */             double y = Main.getInstance().getConfig().getDouble("Warps.MdrY");
/* 203 */             double z = Main.getInstance().getConfig().getDouble("Warps.MdrZ");
/* 204 */             PlayerInventory inv = p.getInventory();
/*     */             try {
/* 206 */               p.teleport(new Location(w, x, y, z));
/*     */             } catch (Exception e) {
/* 208 */               p.sendMessage("§4§lERRO: §7A warp MDR não foi setada");
/*     */             }
/* 210 */             p.getInventory().clear();
/*     */             
/* 212 */             ItemStack espada = new ItemStack(Material.STONE_SWORD);
/* 213 */             inv.addItem(new ItemStack[] { espada });
/*     */             
/* 215 */             ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
/* 216 */             ItemMeta sopameta = sopa.getItemMeta();
/*     */             
/* 218 */             sopa.setItemMeta(sopameta);
/*     */             
/* 220 */             ItemStack cogu1 = new ItemStack(Material.BROWN_MUSHROOM, 64);
/* 221 */             ItemMeta cogu1meta = cogu1.getItemMeta();
/*     */             
/* 223 */             cogu1.setItemMeta(cogu1meta);
/*     */             
/* 225 */             ItemStack cogu2 = new ItemStack(Material.RED_MUSHROOM, 64);
/* 226 */             ItemMeta cogu2meta = cogu2.getItemMeta();
/*     */             
/* 228 */             cogu2.setItemMeta(cogu2meta);
/*     */             
/* 230 */             ItemStack pote = new ItemStack(Material.BOWL, 64);
/* 231 */             ItemMeta potemeta = pote.getItemMeta();
/*     */             
/* 233 */             pote.setItemMeta(potemeta);
/*     */             
/* 235 */             for (int i = 1; i < 35; i++) {
/* 236 */               p.getInventory().addItem(new ItemStack[] { sopa });
/* 237 */               p.getInventory().setItem(15, cogu1);
/* 238 */               p.getInventory().setItem(14, cogu2);
/* 239 */               p.getInventory().setItem(13, pote);
/*     */             }
/*     */             
/* 242 */             p.sendMessage("§7§lVocê foi teleportado");
/* 243 */             p.getInventory().setHelmet(new ItemStack(Material.AIR));
/* 244 */             p.getInventory().setChestplate(new ItemStack(Material.AIR));
/* 245 */             p.getInventory().setLeggings(new ItemStack(Material.AIR));
/* 246 */             p.getInventory().setBoots(new ItemStack(Material.AIR));
/* 247 */             p.setMaxHealth(20);
/* 248 */             p.setHealth(20);
/* 249 */             WarpsAPI.warping.remove(p);
/* 250 */             WarpsAPI.tanawarp.add(p.getName());
/*     */           }
/*     */           
/*     */         }
/*     */         
/* 255 */       }, 100L);
/*     */     }
/*     */     
/* 258 */     if (cmd.getName().equalsIgnoreCase("challenge")) {
/* 259 */       p.sendMessage("§6§lINFO: §7Você será teleportado em 5 segundos");
/* 260 */       p.getInventory().setArmorContents(null);
/* 261 */       p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 2, true));
/* 262 */       p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 2, true));
/* 263 */       p.setHealth(1);
/* 264 */       p.setMaxHealth(1);
/* 265 */       p.getInventory().clear();
/* 266 */       warping.add(p);
/* 267 */       Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/* 269 */           if (WarpsAPI.warping.contains(p)) {
/* 270 */             for (PotionEffect effect : p.getActivePotionEffects()) {
/* 271 */               p.removePotionEffect(effect.getType());
/*     */             }
/* 273 */             World w = Bukkit.getServer().getWorld(Main.getInstance().getConfig().getString("Warps.ChallengeWorld"));
/* 274 */             double x = Main.getInstance().getConfig().getDouble("Warps.ChallengeX");
/* 275 */             double y = Main.getInstance().getConfig().getDouble("Warps.ChallengeY");
/* 276 */             double z = Main.getInstance().getConfig().getDouble("Warps.ChallengeZ");
/*     */             try {
/* 278 */               p.teleport(new Location(w, x, y, z));
/*     */             } catch (Exception e) {
/* 280 */               p.sendMessage("§4§lERRO: §7A warp Challenge não foi setada");
/*     */             }
/* 282 */             KitAPI.setKit(p, "PvP");
/* 283 */             p.getInventory().clear();
/*     */             
/* 285 */             ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
/* 286 */             ItemMeta sopameta = sopa.getItemMeta();
/*     */             
/* 288 */             sopa.setItemMeta(sopameta);
/*     */             
/* 290 */             ItemStack cogu1 = new ItemStack(Material.BROWN_MUSHROOM, 64);
/* 291 */             ItemMeta cogu1meta = cogu1.getItemMeta();
/*     */             
/* 293 */             cogu1.setItemMeta(cogu1meta);
/*     */             
/* 295 */             ItemStack cogu2 = new ItemStack(Material.RED_MUSHROOM, 64);
/* 296 */             ItemMeta cogu2meta = cogu2.getItemMeta();
/*     */             
/* 298 */             cogu2.setItemMeta(cogu2meta);
/*     */             
/* 300 */             ItemStack pote = new ItemStack(Material.BOWL, 64);
/* 301 */             ItemMeta potemeta = pote.getItemMeta();
/*     */             
/* 303 */             pote.setItemMeta(potemeta);
/*     */             
/* 305 */             for (int i = 1; i < 35; i++) {
/* 306 */               p.getInventory().addItem(new ItemStack[] { sopa });
/* 307 */               p.getInventory().setItem(15, cogu1);
/* 308 */               p.getInventory().setItem(14, cogu2);
/* 309 */               p.getInventory().setItem(13, pote);
/*     */             }
/*     */             
/* 312 */             p.sendMessage("§7§lVocê foi teleportado");
/* 313 */             p.getInventory().setHelmet(new ItemStack(Material.AIR));
/* 314 */             p.getInventory().setChestplate(new ItemStack(Material.AIR));
/* 315 */             p.getInventory().setLeggings(new ItemStack(Material.AIR));
/* 316 */             p.getInventory().setBoots(new ItemStack(Material.AIR));
/* 317 */             p.setMaxHealth(20);
/* 318 */             p.setHealth(20);
/* 319 */             WarpsAPI.warping.remove(p);
/* 320 */             WarpsAPI.tanawarp.add(p.getName());
/*     */           }
/*     */           
/*     */         }
/* 324 */       }, 100L);
/*     */     }
/* 326 */     if (cmd.getName().equalsIgnoreCase("fps")) {
/* 327 */       p.sendMessage("§6§lINFO: §7Você será teleportado em 5 segundos");
/* 328 */       p.getInventory().setArmorContents(null);
/* 329 */       p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 2, true));
/* 330 */       p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 2, true));
/* 331 */       p.setHealth(1);
/* 332 */       p.setMaxHealth(1);
/* 333 */       p.getInventory().clear();
/* 334 */       warping.add(p);
/* 335 */       Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/* 337 */           if (WarpsAPI.warping.contains(p)) {
/* 338 */             for (PotionEffect effect : p.getActivePotionEffects()) {
/* 339 */               p.removePotionEffect(effect.getType());
/*     */             }
/* 341 */             World w = Bukkit.getServer().getWorld(Main.getInstance().getConfig().getString("Warps.FpsWorld"));
/* 342 */             double x = Main.getInstance().getConfig().getDouble("Warps.FpsX");
/* 343 */             double y = Main.getInstance().getConfig().getDouble("Warps.FpsY");
/* 344 */             double z = Main.getInstance().getConfig().getDouble("Warps.FpsZ");
/*     */             try {
/* 346 */               p.teleport(new Location(w, x, y, z));
/*     */             } catch (Exception e) {
/* 348 */               p.sendMessage("§4§lERRO: §7A warp FPS não foi setada");
/*     */             }
/* 350 */             KitAPI.setKit(p, "PvP");
/* 351 */             p.sendMessage("§7§lVocê foi teleportado");
/* 352 */             p.setMaxHealth(20);
/* 353 */             p.setHealth(20);
/* 354 */             WarpsAPI.warping.remove(p);
/* 355 */             WarpsAPI.tanawarp.add(p.getName());
/* 356 */             p.getInventory().clear();
/*     */             
/* 358 */             ItemStack espada = new ItemStack(Material.STONE_SWORD);
/* 359 */             ItemMeta espadameta = espada.getItemMeta();
/* 360 */             espadameta.setDisplayName("§b» §5Espada");
/* 361 */             espada.setItemMeta(espadameta);
/*     */             
/* 363 */             ItemStack Item = new ItemStack(Material.LEATHER_CHESTPLATE);
/* 364 */             LeatherArmorMeta ItemMeta = (LeatherArmorMeta)Item.getItemMeta();
/* 365 */             ItemMeta.setColor(Color.LIME);
/* 366 */             ItemMeta.setDisplayName("§b» §aFPS");
/* 367 */             Item.setItemMeta(ItemMeta);
/*     */             
/* 369 */             ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
/* 370 */             ItemMeta sopameta = sopa.getItemMeta();
/*     */             
/* 372 */             sopa.setItemMeta(sopameta);
/*     */             
/* 374 */             ItemStack cogu1 = new ItemStack(Material.BROWN_MUSHROOM, 64);
/* 375 */             ItemMeta cogu1meta = cogu1.getItemMeta();
/*     */             
/* 377 */             cogu1.setItemMeta(cogu1meta);
/*     */             
/* 379 */             ItemStack cogu2 = new ItemStack(Material.RED_MUSHROOM, 64);
/* 380 */             ItemMeta cogu2meta = cogu2.getItemMeta();
/*     */             
/* 382 */             cogu2.setItemMeta(cogu2meta);
/*     */             
/* 384 */             ItemStack pote = new ItemStack(Material.BOWL, 64);
/* 385 */             ItemMeta potemeta = pote.getItemMeta();
/*     */             
/* 387 */             pote.setItemMeta(potemeta);
/*     */             
/* 389 */             p.getInventory().addItem(new ItemStack[] { espada });
/* 390 */             for (int i = 1; i < 35; i++) {
/* 391 */               p.getInventory().addItem(new ItemStack[] { sopa });
/* 392 */               p.getInventory().setChestplate(Item);
/* 393 */               p.getInventory().setItem(15, cogu1);
/* 394 */               p.getInventory().setItem(14, cogu2);
/* 395 */               p.getInventory().setItem(13, pote);
/* 396 */               p.updateInventory();
/*     */             }
/*     */           }
/*     */         }
/* 400 */       }, 100L);
/*     */     }
/*     */     
/* 403 */     if (cmd.getName().equalsIgnoreCase("spawn")) {
/* 404 */       p.sendMessage("§6§lINFO: §7Você será teleportado em 5 segundos");
/* 405 */       p.getInventory().setArmorContents(null);
/* 406 */       p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 2, true));
/* 407 */       p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 2, true));
/* 408 */       p.setHealth(1);
/* 409 */       p.setMaxHealth(1);
/* 410 */       p.getInventory().clear();
/* 411 */       warping.add(p);
/* 412 */       Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*     */         public void run() {
/* 414 */           if (WarpsAPI.warping.contains(p)) {
/*     */             try {
/* 416 */               p.teleport(p.getWorld().getSpawnLocation());
/*     */             } catch (Exception e) {
/* 418 */               p.sendMessage("§4§lERRO: §7O spawn não foi setada");
/*     */             }
/*     */             
/* 421 */             p.getInventory().clear();
/* 422 */             for (PotionEffect effect : p.getActivePotionEffects()) {
/* 423 */               p.removePotionEffect(effect.getType());
/*     */             }
/* 425 */             p.getInventory().setArmorContents(null);
/* 426 */             for (PotionEffect effect : p.getActivePotionEffects()) {
/* 427 */               p.removePotionEffect(effect.getType());
/*     */             }
/* 429 */             p.sendMessage("§7§lVocê foi teleportado");
/* 430 */             p.getInventory().setHelmet(new ItemStack(Material.AIR));
/* 431 */             p.getInventory().setChestplate(new ItemStack(Material.AIR));
/* 432 */             p.getInventory().setLeggings(new ItemStack(Material.AIR));
/* 433 */             p.getInventory().setBoots(new ItemStack(Material.AIR));
/* 434 */             p.setMaxHealth(20);
/* 435 */             p.setHealth(20);
/* 436 */             WarpsAPI.warping.remove(p);
/* 437 */             WarpsAPI.tanawarp.remove(p.getName());
/* 438 */             KitAPI.RemoveKit(p);
/*     */             
/* 440 */             ItemStack kit = new ItemStack(Material.CHEST);
/* 441 */             ItemMeta kitmeta = kit.getItemMeta();
/* 442 */             kitmeta.setDisplayName("§7» §f§lSeus Kits §8§l(§7§n" + p.getName() + "§8§l)");
/* 443 */             kit.setItemMeta(kitmeta);
/*     */             
/* 445 */             ItemStack warps = new ItemStack(Material.PAPER);
/* 446 */             ItemMeta warpsmeta = warps.getItemMeta();
/* 447 */             warpsmeta.setDisplayName("§7» §f§lWarps");
/* 448 */             warps.setItemMeta(warpsmeta);
/*     */             
/* 450 */             ItemStack loja = new ItemStack(Material.EXP_BOTTLE);
/* 451 */             ItemMeta lojameta = loja.getItemMeta();
/* 452 */             lojameta.setDisplayName("§7» §f§lLoja §8§l(§6§nXP§8§l)");
/* 453 */             loja.setItemMeta(lojameta);
/*     */             
/* 455 */             ItemStack status = new ItemStack(Material.ENCHANTED_BOOK);
/* 456 */             ItemMeta statusmeta = status.getItemMeta();
/* 457 */             statusmeta.setDisplayName("§7» §f§lRegras");
/* 458 */             status.setItemMeta(statusmeta);
/*     */             
/* 460 */             ItemStack caixa = new ItemStack(Material.ENCHANTMENT_TABLE);
/* 461 */             ItemMeta caixameta = caixa.getItemMeta();
/* 462 */             caixameta.setDisplayName("§7» §f§l§nCaixas");
/* 463 */             caixa.setItemMeta(caixameta);
/*     */             
/* 465 */             ItemStack vidro = new ItemStack(Material.IRON_FENCE, 1, (short)15);
/* 466 */             ItemMeta vidrometa = vidro.getItemMeta();
/* 467 */             vidrometa.setDisplayName("§c§lSTOMPA§8§l-§e§lKITS");
/* 468 */             vidro.setItemMeta(vidrometa);
/*     */             
/* 470 */             p.getInventory().setItem(0, status);
/* 471 */             p.getInventory().setItem(2, vidro);
/* 472 */             p.getInventory().setItem(3, warps);
/* 473 */             p.getInventory().setItem(4, kit);
/* 474 */             p.getInventory().setItem(5, loja);
/* 475 */             p.getInventory().setItem(6, vidro);
/* 476 */             p.getInventory().setItem(8, caixa);
/* 477 */             p.updateInventory();
/* 478 */             WarpsAPI.tanawarp.remove(p);
/*     */           }
/*     */           
/*     */         }
/* 482 */       }, 100L);
/*     */     }
/*     */     
/* 485 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\WarpsAPI.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */