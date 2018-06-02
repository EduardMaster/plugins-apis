/*     */ package br.nikao.gui;
/*     */ 
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ public class Kits implements org.bukkit.event.Listener, org.bukkit.command.CommandExecutor
/*     */ {
/*     */   public static ItemStack vidro;
/*     */   public static org.bukkit.inventory.meta.ItemMeta vidrometa;
/*     */   public static ItemStack vidrored;
/*     */   public static org.bukkit.inventory.meta.ItemMeta vidroredmeta;
/*     */   public static ItemStack iron;
/*     */   public static org.bukkit.inventory.meta.ItemMeta ironmeta;
/*     */   public static ItemStack netherstar;
/*     */   public static org.bukkit.inventory.meta.ItemMeta netherstarmeta;
/*     */   public static ItemStack pvp;
/*     */   public static org.bukkit.inventory.meta.ItemMeta pvpmeta;
/*     */   public static ItemStack archer;
/*     */   public static org.bukkit.inventory.meta.ItemMeta archermeta;
/*     */   public static ItemStack viper;
/*     */   public static org.bukkit.inventory.meta.ItemMeta vipermeta;
/*     */   public static ItemStack kangaroo;
/*     */   public static org.bukkit.inventory.meta.ItemMeta kangaroometa;
/*     */   public static ItemStack snail;
/*     */   public static org.bukkit.inventory.meta.ItemMeta snailmeta;
/*     */   public static ItemStack anchor;
/*     */   public static org.bukkit.inventory.meta.ItemMeta anchormeta;
/*     */   public static ItemStack phantom;
/*     */   
/*     */   public static java.util.List<String> Lore(String string) {
/*  30 */     String[] split = string.split(" ");
/*  31 */     string = "";
/*  32 */     org.bukkit.ChatColor color = org.bukkit.ChatColor.GOLD;
/*     */     
/*  34 */     java.util.ArrayList<String> newString = new java.util.ArrayList();
/*  35 */     for (int i = 0; i < split.length; i++) {
/*  36 */       if ((string.length() > 20) || (string.endsWith("."))) {
/*  37 */         newString.add(color + string);
/*  38 */         if (string.endsWith(".")) {
/*  39 */           newString.add("");
/*     */         }
/*  41 */         string = "";
/*     */       }
/*  43 */       string = string + (string.length() == 0 ? "" : " ") + split[i];
/*     */     }
/*  45 */     newString.add(string);
/*  46 */     return newString;
/*     */   }
/*     */   
/*     */ 
/*     */   public static org.bukkit.inventory.meta.ItemMeta phantommeta;
/*     */   
/*     */   public static ItemStack ninja;
/*     */   
/*     */   public static org.bukkit.inventory.meta.ItemMeta ninjameta;
/*     */   
/*     */   public static ItemStack thor;
/*     */   
/*     */   public static org.bukkit.inventory.meta.ItemMeta thormeta;
/*     */   
/*     */   public static ItemStack timelord;
/*     */   
/*     */   public static org.bukkit.inventory.meta.ItemMeta timelordmeta;
/*     */   
/*     */   public static ItemStack fisherman;
/*     */   
/*     */   public static org.bukkit.inventory.meta.ItemMeta fishermanmeta;
/*     */   
/*     */   public static ItemStack fireman;
/*     */   
/*     */   public static org.bukkit.inventory.meta.ItemMeta firemanmeta;
/*     */   
/*     */   public static ItemStack barbarian;
/*     */   
/*     */   public static org.bukkit.inventory.meta.ItemMeta barbarianmeta;
/*     */   
/*     */   public static ItemStack hulk;
/*     */   
/*     */   public static org.bukkit.inventory.meta.ItemMeta hulkmeta;
/*     */   
/*     */   public static ItemStack urgal;
/*     */   
/*     */   public static org.bukkit.inventory.meta.ItemMeta urgalmeta;
/*     */   
/*     */   public static ItemStack viking;
/*     */   
/*     */   public static org.bukkit.inventory.meta.ItemMeta vikingmeta;
/*     */   
/*     */   public static ItemStack grandpa;
/*     */   
/*     */   public static org.bukkit.inventory.meta.ItemMeta grandpameta;
/*     */   public static ItemStack stomper;
/*     */   public static org.bukkit.inventory.meta.ItemMeta stompermeta;
/*     */   public static ItemStack camel;
/*     */   public static org.bukkit.inventory.meta.ItemMeta camelmeta;
/*     */   public static ItemStack critical;
/*     */   public static org.bukkit.inventory.meta.ItemMeta criticalmeta;
/*     */   public static ItemStack deshfire;
/*     */   public static org.bukkit.inventory.meta.ItemMeta deshfiremeta;
/*     */   public static ItemStack endermage;
/*     */   public static org.bukkit.inventory.meta.ItemMeta endermagemeta;
/*     */   public static ItemStack forcefield;
/*     */   public static org.bukkit.inventory.meta.ItemMeta forcefieldmeta;
/*     */   public static ItemStack frosty;
/*     */   public static org.bukkit.inventory.meta.ItemMeta frostymeta;
/*     */   public static ItemStack grappler;
/*     */   public static org.bukkit.inventory.meta.ItemMeta grapplermeta;
/*     */   public static ItemStack launcher;
/*     */   public static org.bukkit.inventory.meta.ItemMeta launchermeta;
/*     */   public static ItemStack magma;
/*     */   public static org.bukkit.inventory.meta.ItemMeta magmameta;
/*     */   public static ItemStack monk;
/*     */   public static org.bukkit.inventory.meta.ItemMeta monkmeta;
/*     */   public static ItemStack poseidon;
/*     */   public static org.bukkit.inventory.meta.ItemMeta poseidonmeta;
/*     */   public static ItemStack rain;
/*     */   public static org.bukkit.inventory.meta.ItemMeta rainmeta;
/*     */   public static ItemStack reaper;
/*     */   public static org.bukkit.inventory.meta.ItemMeta reapermeta;
/*     */   public static ItemStack resouper;
/*     */   public static org.bukkit.inventory.meta.ItemMeta resoupermeta;
/*     */   public static ItemStack ryu;
/*     */   public static org.bukkit.inventory.meta.ItemMeta ryumeta;
/*     */   public static ItemStack specialist;
/*     */   public static org.bukkit.inventory.meta.ItemMeta specialistmeta;
/*     */   public static ItemStack spiderman;
/*     */   public static org.bukkit.inventory.meta.ItemMeta spidermanmeta;
/*     */   public static ItemStack switcher;
/*     */   public static org.bukkit.inventory.meta.ItemMeta switchermeta;
/*     */   public static ItemStack turtle;
/*     */   public static org.bukkit.inventory.meta.ItemMeta turtlemeta;
/*     */   public static ItemStack quickdropper;
/*     */   public static org.bukkit.inventory.meta.ItemMeta quickdroppermeta;
/*     */   public static ItemStack c4;
/*     */   public static org.bukkit.inventory.meta.ItemMeta c4meta;
/*     */   @org.bukkit.event.EventHandler
/*     */   public void Gui(org.bukkit.event.player.PlayerInteractEvent e)
/*     */   {
/* 138 */     org.bukkit.entity.Player p = e.getPlayer();
/* 139 */     if ((e.getMaterial() == org.bukkit.Material.CHEST) && (e.getItem().getType() == org.bukkit.Material.CHEST) && (br.nikao.outros.KitAPI.getkit(p) == "Nenhum")) {
/* 140 */       p.playSound(p.getLocation(), org.bukkit.Sound.CLICK, 2.0F, 2.0F);
/* 141 */       p.chat("/kits");
/*     */     }
/*     */   }
/*     */   
/*     */   @org.bukkit.event.EventHandler
/*     */   public void PvP(org.bukkit.event.inventory.InventoryClickEvent e) {
/* 147 */     if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
/* 148 */       org.bukkit.entity.Player p = (org.bukkit.entity.Player)e.getWhoClicked();
/* 149 */       org.bukkit.inventory.Inventory inv = e.getInventory();
/* 150 */       if (inv.getTitle().equalsIgnoreCase("§3§l§nSeus Kits")) {
/* 151 */         if (e.getCurrentItem().isSimilar(vidro)) {
/* 152 */           e.setCancelled(true);
/*     */         }
/*     */         
/* 155 */         if (e.getCurrentItem().isSimilar(vidrored)) {
/* 156 */           e.setCancelled(true);
/*     */         }
/*     */         
/* 159 */         if (e.getCurrentItem().isSimilar(iron)) {
/* 160 */           e.setCancelled(true);
/*     */         }
/*     */         
/* 163 */         if (e.getCurrentItem().isSimilar(netherstar)) {
/* 164 */           e.setCancelled(true);
/*     */         }
/*     */         
/* 167 */         if (e.getCurrentItem().isSimilar(pvp)) {
/* 168 */           e.setCancelled(true);
/* 169 */           p.closeInventory();
/* 170 */           p.chat("/kit pvp");
/*     */         }
/*     */         
/* 173 */         if (e.getCurrentItem().isSimilar(kangaroo)) {
/* 174 */           e.setCancelled(true);
/* 175 */           p.closeInventory();
/* 176 */           p.chat("/kit kangaroo");
/*     */         }
/*     */         
/* 179 */         if (e.getCurrentItem().isSimilar(archer)) {
/* 180 */           e.setCancelled(true);
/* 181 */           p.closeInventory();
/* 182 */           p.chat("/kit archer");
/*     */         }
/*     */         
/* 185 */         if (e.getCurrentItem().isSimilar(viper)) {
/* 186 */           e.setCancelled(true);
/* 187 */           p.closeInventory();
/* 188 */           p.chat("/kit viper");
/*     */         }
/*     */         
/* 191 */         if (e.getCurrentItem().isSimilar(snail)) {
/* 192 */           e.setCancelled(true);
/* 193 */           p.closeInventory();
/* 194 */           p.chat("/kit snail");
/*     */         }
/*     */         
/* 197 */         if (e.getCurrentItem().isSimilar(fisherman)) {
/* 198 */           e.setCancelled(true);
/* 199 */           p.closeInventory();
/* 200 */           p.chat("/kit fisherman");
/*     */         }
/*     */         
/* 203 */         if (e.getCurrentItem().isSimilar(stomper)) {
/* 204 */           e.setCancelled(true);
/* 205 */           p.closeInventory();
/* 206 */           p.chat("/kit stomper");
/*     */         }
/*     */         
/* 209 */         if (e.getCurrentItem().isSimilar(viking)) {
/* 210 */           e.setCancelled(true);
/* 211 */           p.closeInventory();
/* 212 */           p.chat("/kit viking");
/*     */         }
/*     */         
/* 215 */         if (e.getCurrentItem().isSimilar(ninja)) {
/* 216 */           e.setCancelled(true);
/* 217 */           p.closeInventory();
/* 218 */           p.chat("/kit ninja");
/*     */         }
/*     */         
/* 221 */         if (e.getCurrentItem().isSimilar(specialist)) {
/* 222 */           e.setCancelled(true);
/* 223 */           p.closeInventory();
/* 224 */           p.chat("/kit specialist");
/*     */         }
/*     */         
/* 227 */         if (e.getCurrentItem().isSimilar(turtle)) {
/* 228 */           e.setCancelled(true);
/* 229 */           p.closeInventory();
/* 230 */           p.chat("/kit turtle");
/*     */         }
/*     */         
/* 233 */         if (e.getCurrentItem().isSimilar(grandpa)) {
/* 234 */           e.setCancelled(true);
/* 235 */           p.closeInventory();
/* 236 */           p.chat("/kit grandpa");
/*     */         }
/*     */         
/* 239 */         if (e.getCurrentItem().isSimilar(urgal)) {
/* 240 */           e.setCancelled(true);
/* 241 */           p.closeInventory();
/* 242 */           p.chat("/kit urgal");
/*     */         }
/*     */         
/* 245 */         if (e.getCurrentItem().isSimilar(poseidon)) {
/* 246 */           e.setCancelled(true);
/* 247 */           p.closeInventory();
/* 248 */           p.chat("/kit poseidon");
/*     */         }
/*     */         
/* 251 */         if (e.getCurrentItem().isSimilar(resouper)) {
/* 252 */           e.setCancelled(true);
/* 253 */           p.closeInventory();
/* 254 */           p.chat("/kit resouper");
/*     */         }
/*     */         
/* 257 */         if (e.getCurrentItem().isSimilar(anchor)) {
/* 258 */           e.setCancelled(true);
/* 259 */           p.closeInventory();
/* 260 */           p.chat("/kit anchor");
/*     */         }
/* 262 */         if (e.getCurrentItem().isSimilar(camel)) {
/* 263 */           e.setCancelled(true);
/* 264 */           p.closeInventory();
/* 265 */           p.chat("/kit camel");
/*     */         }
/* 267 */         if (e.getCurrentItem().isSimilar(frosty)) {
/* 268 */           e.setCancelled(true);
/* 269 */           p.closeInventory();
/* 270 */           p.chat("/kit frosty");
/*     */         }
/* 272 */         if (e.getCurrentItem().isSimilar(grappler)) {
/* 273 */           e.setCancelled(true);
/* 274 */           p.closeInventory();
/* 275 */           p.chat("/kit grappler");
/*     */         }
/* 277 */         if (e.getCurrentItem().isSimilar(hulk)) {
/* 278 */           e.setCancelled(true);
/* 279 */           p.closeInventory();
/* 280 */           p.chat("/kit hulk");
/*     */         }
/* 282 */         if (e.getCurrentItem().isSimilar(switcher)) {
/* 283 */           e.setCancelled(true);
/* 284 */           p.closeInventory();
/* 285 */           p.chat("/kit switcher");
/*     */         }
/*     */         
/* 288 */         if (e.getCurrentItem().isSimilar(launcher)) {
/* 289 */           e.setCancelled(true);
/* 290 */           p.closeInventory();
/* 291 */           p.chat("/kit launcher");
/*     */         }
/*     */         
/* 294 */         if (e.getCurrentItem().isSimilar(endermage)) {
/* 295 */           e.setCancelled(true);
/* 296 */           p.closeInventory();
/* 297 */           p.chat("/kit endermage");
/*     */         }
/*     */         
/* 300 */         if (e.getCurrentItem().isSimilar(fireman)) {
/* 301 */           e.setCancelled(true);
/* 302 */           p.closeInventory();
/* 303 */           p.chat("/kit fireman");
/*     */         }
/*     */         
/* 306 */         if (e.getCurrentItem().isSimilar(reaper)) {
/* 307 */           e.setCancelled(true);
/* 308 */           p.closeInventory();
/* 309 */           p.chat("/kit reaper");
/*     */         }
/* 311 */         if (e.getCurrentItem().isSimilar(ryu)) {
/* 312 */           e.setCancelled(true);
/* 313 */           p.closeInventory();
/* 314 */           p.chat("/kit ryu");
/*     */         }
/* 316 */         if (e.getCurrentItem().isSimilar(magma)) {
/* 317 */           e.setCancelled(true);
/* 318 */           p.closeInventory();
/* 319 */           p.chat("/kit magma");
/*     */         }
/* 321 */         if (e.getCurrentItem().isSimilar(spiderman)) {
/* 322 */           e.setCancelled(true);
/* 323 */           p.closeInventory();
/* 324 */           p.chat("/kit spiderman");
/*     */         }
/* 326 */         if (e.getCurrentItem().isSimilar(deshfire)) {
/* 327 */           e.setCancelled(true);
/* 328 */           p.closeInventory();
/* 329 */           p.chat("/kit deshfire");
/*     */         }
/*     */         
/* 332 */         if (e.getCurrentItem().isSimilar(critical)) {
/* 333 */           e.setCancelled(true);
/* 334 */           p.closeInventory();
/* 335 */           p.chat("/kit critical");
/*     */         }
/*     */         
/* 338 */         if (e.getCurrentItem().isSimilar(thor)) {
/* 339 */           e.setCancelled(true);
/* 340 */           p.closeInventory();
/* 341 */           p.chat("/kit thor");
/*     */         }
/*     */         
/* 344 */         if (e.getCurrentItem().isSimilar(forcefield)) {
/* 345 */           e.setCancelled(true);
/* 346 */           p.closeInventory();
/* 347 */           p.chat("/kit forcefield");
/*     */         }
/* 349 */         if (e.getCurrentItem().isSimilar(timelord)) {
/* 350 */           e.setCancelled(true);
/* 351 */           p.closeInventory();
/* 352 */           p.chat("/kit timelord");
/*     */         }
/* 354 */         if (e.getCurrentItem().isSimilar(quickdropper)) {
/* 355 */           e.setCancelled(true);
/* 356 */           p.closeInventory();
/* 357 */           p.chat("/kit quickdropper");
/*     */         }
/* 359 */         if (e.getCurrentItem().isSimilar(c4)) {
/* 360 */           e.setCancelled(true);
/* 361 */           p.closeInventory();
/* 362 */           p.chat("/kit c4");
/*     */         }
/* 364 */         if (e.getCurrentItem().isSimilar(monk)) {
/* 365 */           e.setCancelled(true);
/* 366 */           p.closeInventory();
/* 367 */           p.chat("/kit monk");
/*     */         }
/* 369 */         if (e.getCurrentItem().isSimilar(phantom)) {
/* 370 */           e.setCancelled(true);
/* 371 */           p.closeInventory();
/* 372 */           p.chat("/kit phantom");
/*     */         }
/* 374 */         if (e.getCurrentItem().isSimilar(rain)) {
/* 375 */           e.setCancelled(true);
/* 376 */           p.closeInventory();
/* 377 */           p.chat("/kit rain");
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args)
/*     */   {
/* 386 */     if (!(sender instanceof org.bukkit.entity.Player)) {
/* 387 */       sender.sendMessage("§e[§cErro§7] §cApenas jogadores podem usar isso");
/* 388 */       return true;
/*     */     }
/* 390 */     org.bukkit.entity.Player p = (org.bukkit.entity.Player)sender;
/* 391 */     if (br.nikao.outros.KitAPI.getkit(p) != "Nenhum") {
/* 392 */       p.sendMessage("§cNão foi possivel abrir seus kits pois você está com um Kit !");
/* 393 */       return true;
/*     */     }
/* 395 */     org.bukkit.inventory.Inventory kit = org.bukkit.Bukkit.createInventory(p, 54, "§3§l§nSeus Kits");
/*     */     
/* 397 */     vidro = new ItemStack(org.bukkit.Material.STAINED_GLASS_PANE, 1);
/* 398 */     vidrometa = vidro.getItemMeta();
/* 399 */     vidrometa.setDisplayName(br.nikao.Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§"));
/* 400 */     vidro.setItemMeta(vidrometa);
/*     */     
/* 402 */     vidrored = new ItemStack(org.bukkit.Material.STAINED_GLASS_PANE, 1, (short)11);
/* 403 */     vidroredmeta = vidrored.getItemMeta();
/* 404 */     vidroredmeta.setDisplayName(br.nikao.Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§"));
/* 405 */     vidrored.setItemMeta(vidroredmeta);
/*     */     
/* 407 */     iron = new ItemStack(org.bukkit.Material.IRON_FENCE, 1);
/* 408 */     ironmeta = iron.getItemMeta();
/* 409 */     ironmeta.setDisplayName("§6§l-");
/* 410 */     iron.setItemMeta(ironmeta);
/*     */     
/* 412 */     netherstar = new ItemStack(org.bukkit.Material.NETHER_STAR, 1);
/* 413 */     netherstarmeta = netherstar.getItemMeta();
/* 414 */     netherstarmeta.setDisplayName("§7§lSeus Kits §8§l(§e" + p.getName() + "§8§l)");
/* 415 */     netherstar.setItemMeta(netherstarmeta);
/*     */     
/* 417 */     pvp = new ItemStack(org.bukkit.Material.STONE_SWORD, 1);
/* 418 */     pvpmeta = pvp.getItemMeta();
/* 419 */     pvpmeta.setDisplayName("§7§lKit: §6§lPvP");
/* 420 */     pvpmeta.setLore(Lore("§eMate §eseus §einimigos §ecom §esua §eespada §eafiada"));
/* 421 */     pvp.setItemMeta(pvpmeta);
/*     */     
/* 423 */     kangaroo = new ItemStack(org.bukkit.Material.FIREWORK, 1);
/* 424 */     kangaroometa = kangaroo.getItemMeta();
/* 425 */     kangaroometa.setDisplayName("§7§lKit: §6§lKangaroo");
/* 426 */     kangaroometa.setLore(Lore("§eNão §edeixe §eseu §einimigo §efugir §ecom §eeste §ekit"));
/* 427 */     kangaroo.setItemMeta(kangaroometa);
/*     */     
/* 429 */     archer = new ItemStack(org.bukkit.Material.BOW, 1);
/* 430 */     archermeta = archer.getItemMeta();
/* 431 */     archermeta.setDisplayName("§7§lKit: §6§lArcher");
/* 432 */     archermeta.setLore(Lore("§eMire §ee §eatire §eflechas §eem §eseus §einimigos"));
/* 433 */     archer.setItemMeta(archermeta);
/*     */     
/* 435 */     viper = new ItemStack(org.bukkit.Material.SPIDER_EYE, 1);
/* 436 */     vipermeta = viper.getItemMeta();
/* 437 */     vipermeta.setDisplayName("§7§lKit: §6§lViper");
/* 438 */     vipermeta.setLore(Lore("§eTenha §e25% §ede §echance §ede §edeixar §eseu §einimigo §eenvenenado"));
/* 439 */     viper.setItemMeta(vipermeta);
/*     */     
/* 441 */     snail = new ItemStack(org.bukkit.Material.SOUL_SAND, 1);
/* 442 */     snailmeta = snail.getItemMeta();
/* 443 */     snailmeta.setDisplayName("§7§lKit: §6§lSnail");
/* 444 */     snailmeta.setLore(Lore("§eTenha §e25% §ede §echance §ede §edeixar §eseu §einimigo §ecom §elentidão"));
/* 445 */     snail.setItemMeta(snailmeta);
/*     */     
/* 447 */     fisherman = new ItemStack(org.bukkit.Material.FISHING_ROD, 1);
/* 448 */     fishermanmeta = fisherman.getItemMeta();
/* 449 */     fishermanmeta.setDisplayName("§7§lKit: §6§lFisherman");
/* 450 */     fishermanmeta.setLore(Lore("§ePesque §ee §epuxe §eseus §einimigos"));
/* 451 */     fisherman.setItemMeta(fishermanmeta);
/*     */     
/* 453 */     stomper = new ItemStack(org.bukkit.Material.IRON_BOOTS, 1);
/* 454 */     stompermeta = stomper.getItemMeta();
/* 455 */     stompermeta.setDisplayName("§7§lKit: §6§lStomper");
/* 456 */     stompermeta.setLore(Lore("§eMate §eseus §einimigos §eesmagados"));
/* 457 */     stomper.setItemMeta(stompermeta);
/*     */     
/* 459 */     viking = new ItemStack(org.bukkit.Material.STONE_AXE, 1);
/* 460 */     vikingmeta = viking.getItemMeta();
/* 461 */     vikingmeta.setDisplayName("§7§lKit: §6§lViking");
/* 462 */     vikingmeta.setLore(Lore("§eDe §emais §edano §ecom §eseu §emachado"));
/* 463 */     viking.setItemMeta(vikingmeta);
/*     */     
/* 465 */     ninja = new ItemStack(org.bukkit.Material.COMPASS, 1);
/* 466 */     ninjameta = ninja.getItemMeta();
/* 467 */     ninjameta.setDisplayName("§7§lKit: §6§lNinja");
/* 468 */     ninjameta.setLore(Lore("§eTransforme-se §eem §eum §eninja §ee §eteleporte-se §epara §eseu §einimigo"));
/* 469 */     ninja.setItemMeta(ninjameta);
/*     */     
/* 471 */     specialist = new ItemStack(org.bukkit.Material.ENCHANTMENT_TABLE, 1);
/* 472 */     specialistmeta = specialist.getItemMeta();
/* 473 */     specialistmeta.setDisplayName("§7§lKit: §6§lSpecialist");
/* 474 */     specialistmeta.setLore(Lore("§eMate §eplayers §ee §eganhe §eXP §epara §eencantar §eseus §eitens"));
/* 475 */     specialist.setItemMeta(specialistmeta);
/*     */     
/* 477 */     turtle = new ItemStack(org.bukkit.Material.DIAMOND_CHESTPLATE, 1);
/* 478 */     turtlemeta = turtle.getItemMeta();
/* 479 */     turtlemeta.setDisplayName("§7§lKit: §6§lTurtle");
/* 480 */     turtlemeta.setLore(Lore("§eFique §eagaixado §ee §etome §emenos §edano"));
/* 481 */     turtle.setItemMeta(turtlemeta);
/*     */     
/* 483 */     grandpa = new ItemStack(org.bukkit.Material.BLAZE_ROD, 1);
/* 484 */     grandpameta = grandpa.getItemMeta();
/* 485 */     grandpameta.setDisplayName("§7§lKit: §6§lGrandpa");
/* 486 */     grandpameta.addEnchant(org.bukkit.enchantments.Enchantment.KNOCKBACK, 2, true);
/* 487 */     grandpameta.setLore(Lore("§eBata §eem §eseus §einimigos §ecom §esua §evarinha §ee §efaça §eeles §evoarem"));
/* 488 */     grandpa.setItemMeta(grandpameta);
/*     */     
/* 490 */     urgal = new ItemStack(org.bukkit.Material.POTION, 1, (short)8201);
/* 491 */     urgalmeta = urgal.getItemMeta();
/* 492 */     urgalmeta.setDisplayName("§7§lKit: §6§lUrgal");
/* 493 */     urgalmeta.setLore(Lore("§eTome sua poção de força e mate seus inimigos"));
/* 494 */     urgal.setItemMeta(urgalmeta);
/*     */     
/* 496 */     poseidon = new ItemStack(org.bukkit.Material.WATER_BUCKET);
/* 497 */     poseidonmeta = poseidon.getItemMeta();
/* 498 */     poseidonmeta.setDisplayName("§7§lKit: §6§lPoseidon");
/* 499 */     poseidonmeta.setLore(Lore("§eGanhe §evelocidade §ee §eforça §ena §eágua"));
/* 500 */     poseidon.setItemMeta(poseidonmeta);
/*     */     
/* 502 */     resouper = new ItemStack(org.bukkit.Material.MUSHROOM_SOUP);
/* 503 */     resoupermeta = resouper.getItemMeta();
/* 504 */     resoupermeta.setDisplayName("§7§lKit: §6§lResouper");
/* 505 */     resoupermeta.setLore(Lore("§eGanhe §esopas §eao §ematar §eum §eplayer"));
/* 506 */     resouper.setItemMeta(resoupermeta);
/*     */     
/* 508 */     anchor = new ItemStack(org.bukkit.Material.ANVIL);
/* 509 */     anchormeta = anchor.getItemMeta();
/* 510 */     anchormeta.setDisplayName("§7§lKit: §6§lAnchor");
/* 511 */     anchormeta.setLore(Lore("§eNão §eleve §erepulsão §eao §elevar §eum §ehit, §ee §enão §ede §erepulsão"));
/* 512 */     anchor.setItemMeta(anchormeta);
/*     */     
/* 514 */     camel = new ItemStack(org.bukkit.Material.SAND);
/* 515 */     camelmeta = camel.getItemMeta();
/* 516 */     camelmeta.setDisplayName("§7§lKit: §6§lCamel");
/* 517 */     camelmeta.setLore(Lore("§eGanhe §evelocidade §ee §eregeneração §eno §edeserto"));
/* 518 */     camel.setItemMeta(camelmeta);
/*     */     
/* 520 */     frosty = new ItemStack(org.bukkit.Material.ICE);
/* 521 */     frostymeta = frosty.getItemMeta();
/* 522 */     frostymeta.setDisplayName("§7§lKit: §6§lFrosty");
/* 523 */     frostymeta.setLore(Lore("§eGanhe §eregeneração §ee §evelocidade §eno §egelo §ee §eneve"));
/* 524 */     frosty.setItemMeta(frostymeta);
/*     */     
/* 526 */     grappler = new ItemStack(org.bukkit.Material.LEASH);
/* 527 */     grapplermeta = grappler.getItemMeta();
/* 528 */     grapplermeta.setDisplayName("§7§lKit: §6§lGrappler");
/* 529 */     grapplermeta.setLore(Lore("§eJogue §eseu §elaço §ee §eande §emais §erápido"));
/* 530 */     grappler.setItemMeta(grapplermeta);
/*     */     
/* 532 */     hulk = new ItemStack(org.bukkit.Material.SADDLE);
/* 533 */     hulkmeta = hulk.getItemMeta();
/* 534 */     hulkmeta.setDisplayName("§7§lKit: §6§lHulk");
/* 535 */     hulkmeta.setLore(Lore("§ePegue §eseu §einimigo §ee §ejogue-o §elonge"));
/* 536 */     hulk.setItemMeta(hulkmeta);
/*     */     
/* 538 */     switcher = new ItemStack(org.bukkit.Material.SNOW_BALL);
/* 539 */     switchermeta = switcher.getItemMeta();
/* 540 */     switchermeta.setDisplayName("§7§lKit: §6§lSwitcher");
/* 541 */     switchermeta.setLore(Lore("§eJogue §euma §ebolinha §ede §eneve §eem §eseu §einimigo §ee §etroque §ede §elugar §ecom §eele"));
/* 542 */     switcher.setItemMeta(switchermeta);
/*     */     
/* 544 */     launcher = new ItemStack(org.bukkit.Material.SPONGE);
/* 545 */     launchermeta = launcher.getItemMeta();
/* 546 */     launchermeta.setDisplayName("§7§lKit: §6§lLauncher");
/* 547 */     launchermeta.setLore(Lore("§ePesque §eseu §einimigo §ee §efaça §eele §evoar"));
/* 548 */     launcher.setItemMeta(launchermeta);
/*     */     
/* 550 */     endermage = new ItemStack(org.bukkit.Material.PORTAL);
/* 551 */     endermagemeta = endermage.getItemMeta();
/* 552 */     endermagemeta.setDisplayName("§7§lKit: §6§lEndermage");
/* 553 */     endermagemeta.setLore(Lore("§ePuxe §etodos §eque §eestiverem §eabaixo §ee §eacima §ede §evocê"));
/* 554 */     endermage.setItemMeta(endermagemeta);
/*     */     
/* 556 */     fireman = new ItemStack(org.bukkit.Material.FIRE);
/* 557 */     firemanmeta = fireman.getItemMeta();
/* 558 */     firemanmeta.setDisplayName("§7§lKit: §6§lFireman");
/* 559 */     firemanmeta.setLore(Lore("§eColoque §efogo §eem §eseu §einimigo"));
/* 560 */     fireman.setItemMeta(firemanmeta);
/*     */     
/* 562 */     reaper = new ItemStack(org.bukkit.Material.WOOD_HOE);
/* 563 */     reapermeta = reaper.getItemMeta();
/* 564 */     reapermeta.setDisplayName("§7§lKit: §6§lReaper");
/* 565 */     reapermeta.setLore(Lore("§eClique §ecom §eo §ebotão §edireito §eem §eseu §einimigo §ee §efaça §eele §eficar §ecom §eefeito §ewhiter"));
/* 566 */     reaper.setItemMeta(reapermeta);
/*     */     
/* 568 */     ryu = new ItemStack(org.bukkit.Material.BEACON);
/* 569 */     ryumeta = ryu.getItemMeta();
/* 570 */     ryumeta.setDisplayName("§7§lKit: §6§lRyu");
/* 571 */     ryumeta.setLore(Lore("§eJogue §euma §ebolinha §ede §eneve §ee §edeixe §eseus §einimigos §ecom §eefeitos §ecabulosos"));
/* 572 */     ryu.setItemMeta(ryumeta);
/*     */     
/* 574 */     magma = new ItemStack(org.bukkit.Material.MAGMA_CREAM);
/* 575 */     magmameta = magma.getItemMeta();
/* 576 */     magmameta.setDisplayName("§7§lKit: §6§lMagma");
/* 577 */     magmameta.setLore(Lore("§eTenha §e25% §ede §echance §ede §equeimar §eseu §einimigo"));
/* 578 */     magma.setItemMeta(magmameta);
/*     */     
/* 580 */     spiderman = new ItemStack(org.bukkit.Material.STRING);
/* 581 */     spidermanmeta = spiderman.getItemMeta();
/* 582 */     spidermanmeta.setDisplayName("§7§lKit: §6§lSpiderman");
/* 583 */     spidermanmeta.setLore(Lore("§eJogue §esua §eteia §ee §eprenda §eseus §einimigos"));
/* 584 */     spiderman.setItemMeta(spidermanmeta);
/*     */     
/* 586 */     deshfire = new ItemStack(org.bukkit.Material.REDSTONE_BLOCK);
/* 587 */     deshfiremeta = deshfire.getItemMeta();
/* 588 */     deshfiremeta.setDisplayName("§7§lKit: §6§lDeshfire");
/* 589 */     deshfiremeta.setLore(Lore("§eClique §ena §esua §eredstone §ee §etaque §efogo §eem §etodos §eos §eplayers §ea §esua §evolta"));
/* 590 */     deshfire.setItemMeta(deshfiremeta);
/*     */     
/* 592 */     critical = new ItemStack(org.bukkit.Material.GOLDEN_APPLE);
/* 593 */     criticalmeta = critical.getItemMeta();
/* 594 */     criticalmeta.setDisplayName("§7§lKit: §6§lCritical");
/* 595 */     criticalmeta.setLore(Lore("§eTenha §e33% §ede §echance §ede §edar §eum §egolpe §ecritico §eem §eseu §eoponente"));
/* 596 */     critical.setItemMeta(criticalmeta);
/*     */     
/* 598 */     thor = new ItemStack(org.bukkit.Material.WOOD_AXE);
/* 599 */     thormeta = thor.getItemMeta();
/* 600 */     thormeta.setDisplayName("§7§lKit: §6§lThor");
/* 601 */     thormeta.setLore(Lore("§eLançe §eraios §ee §emate §eseu §eoponente"));
/* 602 */     thor.setItemMeta(thormeta);
/*     */     
/* 604 */     forcefield = new ItemStack(org.bukkit.Material.NETHER_FENCE);
/* 605 */     forcefieldmeta = forcefield.getItemMeta();
/* 606 */     forcefieldmeta.setDisplayName("§7§lKit: §6§lForcefield");
/* 607 */     forcefieldmeta.setLore(Lore("§eCrie §eum §ecampo §ede §eforça §ea §esua §evolta"));
/* 608 */     forcefield.setItemMeta(forcefieldmeta);
/*     */     
/* 610 */     timelord = new ItemStack(org.bukkit.Material.WATCH);
/* 611 */     timelordmeta = timelord.getItemMeta();
/* 612 */     timelordmeta.setDisplayName("§7§lKit: §6§lTimelord");
/* 613 */     timelordmeta.setLore(Lore("§eCongele §eseus §einimigos §ee §emate-os!"));
/* 614 */     timelord.setItemMeta(timelordmeta);
/*     */     
/* 616 */     quickdropper = new ItemStack(org.bukkit.Material.BOWL);
/* 617 */     quickdroppermeta = quickdropper.getItemMeta();
/* 618 */     quickdroppermeta.setDisplayName("§7§lKit: §6§lQuickDropper");
/* 619 */     quickdroppermeta.setLore(Lore("§eAo §etomar §euma §esopa §edrope §ea §etigela §eautomaticamente"));
/* 620 */     quickdropper.setItemMeta(quickdroppermeta);
/*     */     
/* 622 */     c4 = new ItemStack(org.bukkit.Material.SLIME_BALL);
/* 623 */     c4meta = c4.getItemMeta();
/* 624 */     c4meta.setDisplayName("§7§lKit: §6§lC4");
/* 625 */     c4meta.setLore(Lore("§eImplante sua §ebomba §ee §emate §eseus §einimigos"));
/* 626 */     c4.setItemMeta(c4meta);
/*     */     
/* 628 */     monk = new ItemStack(org.bukkit.Material.BLAZE_ROD);
/* 629 */     monkmeta = monk.getItemMeta();
/* 630 */     monkmeta.setDisplayName("§7§lKit: §6§lMonk");
/* 631 */     monkmeta.setLore(Lore("§eConfuda §eo §einventario §ede §eseus §einimigos"));
/* 632 */     monk.setItemMeta(monkmeta);
/*     */     
/* 634 */     phantom = new ItemStack(org.bukkit.Material.FEATHER);
/* 635 */     phantommeta = phantom.getItemMeta();
/* 636 */     phantommeta.setDisplayName("§7§lKit: §6§lPhantom");
/* 637 */     phantommeta.setLore(Lore("§eTenha a §ehabilidade §ede §evoar!"));
/* 638 */     phantom.setItemMeta(phantommeta);
/*     */     
/* 640 */     rain = new ItemStack(org.bukkit.Material.ARROW);
/* 641 */     rainmeta = rain.getItemMeta();
/* 642 */     rainmeta.setDisplayName("§7§lKit: §6§lRain");
/* 643 */     rainmeta.setLore(Lore("§eClique §ecom §esua §eflecha §ee §efaça §ecair §eflechas §ena §ecabeça §ede §eseus §einimigos"));
/* 644 */     rain.setItemMeta(rainmeta);
/*     */     
/* 646 */     for (int i = 0; i != 54; i++) {
/* 647 */       kit.setItem(i, vidro);
/*     */     }
/* 649 */     kit.setItem(0, vidrored);
/* 650 */     kit.setItem(1, vidrored);
/* 651 */     kit.setItem(2, vidrored);
/* 652 */     kit.setItem(3, iron);
/* 653 */     kit.setItem(4, netherstar);
/* 654 */     kit.setItem(5, iron);
/* 655 */     kit.setItem(6, vidrored);
/* 656 */     kit.setItem(7, vidrored);
/* 657 */     kit.setItem(8, vidrored);
/* 658 */     if (p.hasPermission("kit.pvp")) {
/* 659 */       kit.removeItem(new ItemStack[] { vidro });
/* 660 */       kit.addItem(new ItemStack[] { pvp });
/*     */     }
/* 662 */     if (p.hasPermission("kit.kangaroo")) {
/* 663 */       kit.removeItem(new ItemStack[] { vidro });
/* 664 */       kit.addItem(new ItemStack[] { kangaroo });
/*     */     }
/* 666 */     if (p.hasPermission("kit.archer")) {
/* 667 */       kit.removeItem(new ItemStack[] { vidro });
/* 668 */       kit.addItem(new ItemStack[] { archer });
/*     */     }
/* 670 */     if (p.hasPermission("kit.viper")) {
/* 671 */       kit.removeItem(new ItemStack[] { vidro });
/* 672 */       kit.addItem(new ItemStack[] { viper });
/*     */     }
/* 674 */     if (p.hasPermission("kit.snail")) {
/* 675 */       kit.removeItem(new ItemStack[] { vidro });
/* 676 */       kit.addItem(new ItemStack[] { snail });
/*     */     }
/* 678 */     if (p.hasPermission("kit.fisherman")) {
/* 679 */       kit.removeItem(new ItemStack[] { vidro });
/* 680 */       kit.addItem(new ItemStack[] { fisherman });
/*     */     }
/* 682 */     if (p.hasPermission("kit.stomper")) {
/* 683 */       kit.removeItem(new ItemStack[] { vidro });
/* 684 */       kit.addItem(new ItemStack[] { stomper });
/*     */     }
/* 686 */     if (p.hasPermission("kit.viking")) {
/* 687 */       kit.removeItem(new ItemStack[] { vidro });
/* 688 */       kit.addItem(new ItemStack[] { viking });
/*     */     }
/* 690 */     if (p.hasPermission("kit.ninja")) {
/* 691 */       kit.removeItem(new ItemStack[] { vidro });
/* 692 */       kit.addItem(new ItemStack[] { ninja });
/*     */     }
/* 694 */     if (p.hasPermission("kit.specialist")) {
/* 695 */       kit.removeItem(new ItemStack[] { vidro });
/* 696 */       kit.addItem(new ItemStack[] { specialist });
/*     */     }
/* 698 */     if (p.hasPermission("kit.turtle")) {
/* 699 */       kit.removeItem(new ItemStack[] { vidro });
/* 700 */       kit.addItem(new ItemStack[] { turtle });
/*     */     }
/* 702 */     if (p.hasPermission("kit.grandpa")) {
/* 703 */       kit.removeItem(new ItemStack[] { vidro });
/* 704 */       kit.addItem(new ItemStack[] { grandpa });
/*     */     }
/* 706 */     if (p.hasPermission("kit.urgal")) {
/* 707 */       kit.removeItem(new ItemStack[] { vidro });
/* 708 */       kit.addItem(new ItemStack[] { urgal });
/*     */     }
/* 710 */     if (p.hasPermission("kit.poseidon")) {
/* 711 */       kit.removeItem(new ItemStack[] { vidro });
/* 712 */       kit.addItem(new ItemStack[] { poseidon });
/*     */     }
/* 714 */     if (p.hasPermission("kit.resouper")) {
/* 715 */       kit.removeItem(new ItemStack[] { vidro });
/* 716 */       kit.addItem(new ItemStack[] { resouper });
/*     */     }
/* 718 */     if (p.hasPermission("kit.anchor")) {
/* 719 */       kit.removeItem(new ItemStack[] { vidro });
/* 720 */       kit.addItem(new ItemStack[] { anchor });
/*     */     }
/* 722 */     if (p.hasPermission("kit.camel")) {
/* 723 */       kit.removeItem(new ItemStack[] { vidro });
/* 724 */       kit.addItem(new ItemStack[] { camel });
/*     */     }
/* 726 */     if (p.hasPermission("kit.frosty")) {
/* 727 */       kit.removeItem(new ItemStack[] { vidro });
/* 728 */       kit.addItem(new ItemStack[] { frosty });
/*     */     }
/* 730 */     if (p.hasPermission("kit.grappler")) {
/* 731 */       kit.removeItem(new ItemStack[] { vidro });
/* 732 */       kit.addItem(new ItemStack[] { grappler });
/*     */     }
/* 734 */     if (p.hasPermission("kit.hulk")) {
/* 735 */       kit.removeItem(new ItemStack[] { vidro });
/* 736 */       kit.addItem(new ItemStack[] { hulk });
/*     */     }
/* 738 */     if (p.hasPermission("kit.switcher")) {
/* 739 */       kit.removeItem(new ItemStack[] { vidro });
/* 740 */       kit.addItem(new ItemStack[] { switcher });
/*     */     }
/* 742 */     if (p.hasPermission("kit.launcher")) {
/* 743 */       kit.removeItem(new ItemStack[] { vidro });
/* 744 */       kit.addItem(new ItemStack[] { launcher });
/*     */     }
/* 746 */     if (p.hasPermission("kit.endermage")) {
/* 747 */       kit.removeItem(new ItemStack[] { vidro });
/* 748 */       kit.addItem(new ItemStack[] { endermage });
/*     */     }
/* 750 */     if (p.hasPermission("kit.fireman")) {
/* 751 */       kit.removeItem(new ItemStack[] { vidro });
/* 752 */       kit.addItem(new ItemStack[] { fireman });
/*     */     }
/* 754 */     if (p.hasPermission("kit.reaper")) {
/* 755 */       kit.removeItem(new ItemStack[] { vidro });
/* 756 */       kit.addItem(new ItemStack[] { reaper });
/*     */     }
/* 758 */     if (p.hasPermission("kit.ryu")) {
/* 759 */       kit.removeItem(new ItemStack[] { vidro });
/* 760 */       kit.addItem(new ItemStack[] { ryu });
/*     */     }
/* 762 */     if (p.hasPermission("kit.magma")) {
/* 763 */       kit.removeItem(new ItemStack[] { vidro });
/* 764 */       kit.addItem(new ItemStack[] { magma });
/*     */     }
/* 766 */     if (p.hasPermission("kit.spiderman")) {
/* 767 */       kit.removeItem(new ItemStack[] { vidro });
/* 768 */       kit.addItem(new ItemStack[] { spiderman });
/*     */     }
/* 770 */     if (p.hasPermission("kit.deshfire")) {
/* 771 */       kit.removeItem(new ItemStack[] { vidro });
/* 772 */       kit.addItem(new ItemStack[] { deshfire });
/*     */     }
/* 774 */     if (p.hasPermission("kit.critical")) {
/* 775 */       kit.removeItem(new ItemStack[] { vidro });
/* 776 */       kit.addItem(new ItemStack[] { critical });
/*     */     }
/* 778 */     if (p.hasPermission("kit.thor")) {
/* 779 */       kit.removeItem(new ItemStack[] { vidro });
/* 780 */       kit.addItem(new ItemStack[] { thor });
/*     */     }
/* 782 */     if (p.hasPermission("kit.forcefield")) {
/* 783 */       kit.removeItem(new ItemStack[] { vidro });
/* 784 */       kit.addItem(new ItemStack[] { forcefield });
/*     */     }
/* 786 */     if (p.hasPermission("kit.timelord")) {
/* 787 */       kit.removeItem(new ItemStack[] { vidro });
/* 788 */       kit.addItem(new ItemStack[] { timelord });
/*     */     }
/* 790 */     if (p.hasPermission("kit.quickdropper")) {
/* 791 */       kit.removeItem(new ItemStack[] { vidro });
/* 792 */       kit.addItem(new ItemStack[] { quickdropper });
/*     */     }
/* 794 */     if (p.hasPermission("kit.c4")) {
/* 795 */       kit.removeItem(new ItemStack[] { vidro });
/* 796 */       kit.addItem(new ItemStack[] { c4 });
/*     */     }
/* 798 */     if (p.hasPermission("kit.monk")) {
/* 799 */       kit.removeItem(new ItemStack[] { vidro });
/* 800 */       kit.addItem(new ItemStack[] { monk });
/*     */     }
/* 802 */     if (p.hasPermission("kit.phantom")) {
/* 803 */       kit.removeItem(new ItemStack[] { vidro });
/* 804 */       kit.addItem(new ItemStack[] { phantom });
/*     */     }
/* 806 */     if (p.hasPermission("kit.rain")) {
/* 807 */       kit.removeItem(new ItemStack[] { vidro });
/* 808 */       kit.addItem(new ItemStack[] { rain });
/*     */     }
/* 810 */     p.openInventory(kit);
/* 811 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\gui\Kits.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */