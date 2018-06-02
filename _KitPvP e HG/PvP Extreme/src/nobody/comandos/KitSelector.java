/*     */ package nobody.comandos;
/*     */ 
		import nobody.main.Main;
		import org.bukkit.Material;
/*     */ import org.bukkit.entity.Player;
		import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ public class KitSelector implements org.bukkit.event.Listener, org.bukkit.command.CommandExecutor
/*     */ {
/*     */   public static ItemStack vidro;
/*     */   public static ItemMeta vidrometa;
/*     */   public static ItemStack vidro1;
/*     */   public static ItemMeta vidro1meta;
/*     */   public static ItemStack amarelo1;
/*     */   public static ItemMeta amarelo1meta;
/*     */   public static ItemStack azul1;
/*     */   public static ItemMeta azul1meta;
/*     */   public static ItemStack escada;
/*     */   public static ItemMeta escadameta;
/*     */   public static ItemStack pvp;
/*     */   public static ItemMeta pvpmeta;
/*     */   public static ItemStack archer;
/*     */   public static ItemMeta archermeta;
/*     */   public static ItemStack viper;
/*     */   public static ItemMeta vipermeta;
/*     */   public static ItemStack snail;
/*     */   
/*     */   public static java.util.List<String> Lore(String string)
/*     */   {
/*  30 */     String[] split = string.split(" ");
/*  31 */     string = "";
/*  32 */     org.bukkit.ChatColor color = org.bukkit.ChatColor.GOLD;
/*     */     
/*  34 */     java.util.ArrayList<String> newString = new java.util.ArrayList<String>();
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
/*     */   public static ItemMeta snailmeta;
/*     */   
/*     */   public static ItemStack fisherman;
/*     */   
/*     */   public static ItemMeta fishermanmeta;
/*     */   
/*     */   public static ItemStack kangaroo;
/*     */   
/*     */   public static ItemMeta kangaroometa;
/*     */   
/*     */   public static ItemStack stomper;
/*     */   
/*     */   public static ItemMeta stompermeta;
/*     */   
/*     */   public static ItemStack viking;
/*     */   
/*     */   public static ItemMeta vikingmeta;
/*     */   
/*     */   public static ItemStack ninja;
/*     */   
/*     */   public static ItemMeta ninjameta;
/*     */   
/*     */   public static ItemStack specialist;
/*     */   
/*     */   public static ItemMeta specialistmeta;
/*     */   public static ItemStack turtle;
/*     */   public static ItemMeta turtlemeta;
/*     */   public static ItemStack grandpa;
/*     */   public static ItemMeta grandpameta;
/*     */   public static ItemStack urgal;
/*     */   public static ItemMeta urgalmeta;
/*     */   public static ItemStack poseidon;
/*     */   public static ItemMeta poseidonmeta;
/*     */   public static ItemStack berserker;
/*     */   public static ItemMeta berserkermeta;
/*     */   public static ItemStack paladino;
/*     */   public static ItemMeta paladinometa;
/*     */   public static ItemStack resouper;
/*     */   public static ItemMeta resoupermeta;
/*     */   public static ItemStack lavaman;
/*     */   public static ItemMeta lavamanmeta;
/*     */   public static ItemStack anchor;
/*     */   public static ItemMeta anchormeta;
/*     */   public static ItemStack camel;
/*     */   public static ItemMeta camelmeta;
/*     */   public static ItemStack frosty;
/*     */   public static ItemMeta frostymeta;
/*     */   public static ItemStack grappler;
/*     */   public static ItemMeta grapplermeta;
/*     */   public static ItemStack hulk;
/*     */   public static ItemMeta hulkmeta;
/*     */   public static ItemStack switcher;
/*     */   public static ItemMeta switchermeta;
/*     */   public static ItemStack launcher;
/*     */   public static ItemMeta launchermeta;
/*     */   public static ItemStack bomber;
/*     */   public static ItemMeta bombermeta;
/*     */   public static ItemStack endermage;
/*     */   public static ItemMeta endermagemeta;
/*     */   public static ItemStack fireman;
/*     */   public static ItemMeta firemanmeta;
/*     */   public static ItemStack flash;
/*     */   public static ItemMeta flashmeta;
/*     */   public static ItemStack milkman;
/*     */   public static ItemMeta milkmanmeta;
/*     */   public static ItemStack reaper;
/*     */   public static ItemMeta reapermeta;
/*     */   public static ItemStack ryu;
/*     */   public static ItemMeta ryumeta;
/*     */   public static ItemStack jellyfish;
/*     */   public static ItemMeta jellyfishmeta;
/*     */   public static ItemStack c4;
/*     */   public static ItemMeta c4meta;
/*     */   public static ItemStack magma;
/*     */   public static ItemMeta magmameta;
/*     */   public static ItemStack spiderman;
/*     */   public static ItemMeta spidermanmeta;
/*     */   public static ItemStack deshfire;
/*     */   public static ItemMeta deshfiremeta;
/*     */   public static ItemStack sonic;
/*     */   public static ItemMeta sonicmeta;
/*     */   public static ItemStack critical;
/*     */   public static ItemMeta criticalmeta;
/*     */   public static ItemStack thor;
/*     */   public static ItemMeta thormeta;
/*     */   public static ItemStack boxer;
/*     */   public static ItemMeta boxermeta;
/*     */   public static ItemStack ebola;
/*     */   public static ItemMeta ebolameta;
/*     */   public static ItemStack ff;
/*     */   public static ItemMeta ffmeta;
/*     */   public static ItemStack timelord;
/*     */   public static ItemMeta timelordmeta;
/*     */   public static ItemStack quickdropper;
/*     */   public static ItemMeta quickdroppermeta;
/*     */   public static ItemStack kits2;
/*     */   public static ItemMeta kits2meta;
/*     */   public static ItemStack vinha1;
/*     */   public static ItemMeta vinha1meta;
/*     */   public static ItemStack grade;
/*     */   public static ItemMeta grademeta;
/*     */   public static ItemStack fogo;
/*     */   public static ItemMeta fogometa;
/*     */   
/*     */   @EventHandler
/*     */   public void PvP(InventoryClickEvent e) {
/* 165 */     if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
/* 166 */       Player p = (Player)e.getWhoClicked();
/* 167 */       Inventory inv = e.getInventory();
/* 168 */       if (inv.getTitle().equalsIgnoreCase("§e§nSeus Kits")) {
/* 169 */         if (e.getCurrentItem().isSimilar(vidro)) {
/* 170 */           e.setCancelled(true);
/*     */         }
/* 172 */         if (e.getCurrentItem().isSimilar(pvp)) {
/* 173 */           e.setCancelled(true);
/* 174 */           p.closeInventory();
/* 175 */           p.chat("/kit pvp");
/*     */         }
/*     */         
/* 178 */         if (e.getCurrentItem().isSimilar(kangaroo)) {
/* 179 */           e.setCancelled(true);
/* 180 */           p.closeInventory();
/* 181 */           p.chat("/kit kangaroo");
/*     */         }
/*     */         
/* 184 */         if (e.getCurrentItem().isSimilar(archer)) {
/* 185 */           e.setCancelled(true);
/* 186 */           p.closeInventory();
/* 187 */           p.chat("/kit archer");
/*     */         }
/*     */         
/* 190 */         if (e.getCurrentItem().isSimilar(viper)) {
/* 191 */           e.setCancelled(true);
/* 192 */           p.closeInventory();
/* 193 */           p.chat("/kit viper");
/*     */         }
/*     */         
/* 196 */         if (e.getCurrentItem().isSimilar(snail)) {
/* 197 */           e.setCancelled(true);
/* 198 */           p.closeInventory();
/* 199 */           p.chat("/kit snail");
/*     */         }
/*     */         
/* 202 */         if (e.getCurrentItem().isSimilar(fisherman)) {
/* 203 */           e.setCancelled(true);
/* 204 */           p.closeInventory();
/* 205 */           p.chat("/kit fisherman");
/*     */         }
/*     */         
/* 208 */         if (e.getCurrentItem().isSimilar(stomper)) {
/* 209 */           e.setCancelled(true);
/* 210 */           p.closeInventory();
/* 211 */           p.chat("/kit stomper");
/*     */         }
/*     */         
/* 214 */         if (e.getCurrentItem().isSimilar(viking)) {
/* 215 */           e.setCancelled(true);
/* 216 */           p.closeInventory();
/* 217 */           p.chat("/kit viking");
/*     */         }
/*     */         
/* 220 */         if (e.getCurrentItem().isSimilar(ninja)) {
/* 221 */           e.setCancelled(true);
/* 222 */           p.closeInventory();
/* 223 */           p.chat("/kit ninja");
/*     */         }
/*     */         
/* 226 */         if (e.getCurrentItem().isSimilar(specialist)) {
/* 227 */           e.setCancelled(true);
/* 228 */           p.closeInventory();
/* 229 */           p.chat("/kit specialist");
/*     */         }
/*     */         
/* 232 */         if (e.getCurrentItem().isSimilar(turtle)) {
/* 233 */           e.setCancelled(true);
/* 234 */           p.closeInventory();
/* 235 */           p.chat("/kit turtle");
/*     */         }
/*     */         
/* 238 */         if (e.getCurrentItem().isSimilar(grandpa)) {
/* 239 */           e.setCancelled(true);
/* 240 */           p.closeInventory();
/* 241 */           p.chat("/kit grandpa");
/*     */         }
/*     */         
/* 244 */         if (e.getCurrentItem().isSimilar(urgal)) {
/* 245 */           e.setCancelled(true);
/* 246 */           p.closeInventory();
/* 247 */           p.chat("/kit urgal");
/*     */         }
/*     */         
/* 250 */         if (e.getCurrentItem().isSimilar(poseidon)) {
/* 251 */           e.setCancelled(true);
/* 252 */           p.closeInventory();
/* 253 */           p.chat("/kit poseidon");
/*     */         }
/*     */         
/* 256 */         if (e.getCurrentItem().isSimilar(berserker)) {
/* 257 */           e.setCancelled(true);
/* 258 */           p.closeInventory();
/* 259 */           p.chat("/kit berserker");
/*     */         }
/*     */         
/* 262 */         if (e.getCurrentItem().isSimilar(paladino)) {
/* 263 */           e.setCancelled(true);
/* 264 */           p.closeInventory();
/* 265 */           p.chat("/kit paladino");
/*     */         }
/*     */         
/* 268 */         if (e.getCurrentItem().isSimilar(resouper)) {
/* 269 */           e.setCancelled(true);
/* 270 */           p.closeInventory();
/* 271 */           p.chat("/kit resouper");
/*     */         }
/*     */         
/* 274 */         if (e.getCurrentItem().isSimilar(lavaman)) {
/* 275 */           e.setCancelled(true);
/* 276 */           p.closeInventory();
/* 277 */           p.chat("/kit lavaman");
/*     */         }
/*     */         
/* 280 */         if (e.getCurrentItem().isSimilar(anchor)) {
/* 281 */           e.setCancelled(true);
/* 282 */           p.closeInventory();
/* 283 */           p.chat("/kit anchor");
/*     */         }
/* 285 */         if (e.getCurrentItem().isSimilar(camel)) {
/* 286 */           e.setCancelled(true);
/* 287 */           p.closeInventory();
/* 288 */           p.chat("/kit camel");
/*     */         }
/* 290 */         if (e.getCurrentItem().isSimilar(frosty)) {
/* 291 */           e.setCancelled(true);
/* 292 */           p.closeInventory();
/* 293 */           p.chat("/kit frosty");
/*     */         }
/* 295 */         if (e.getCurrentItem().isSimilar(grappler)) {
/* 296 */           e.setCancelled(true);
/* 297 */           p.closeInventory();
/* 298 */           p.chat("/kit grappler");
/*     */         }
/* 300 */         if (e.getCurrentItem().isSimilar(hulk)) {
/* 301 */           e.setCancelled(true);
/* 302 */           p.closeInventory();
/* 303 */           p.chat("/kit hulk");
/*     */         }
/* 305 */         if (e.getCurrentItem().isSimilar(switcher)) {
/* 306 */           e.setCancelled(true);
/* 307 */           p.closeInventory();
/* 308 */           p.chat("/kit switcher");
/*     */         }
/*     */         
/* 311 */         if (e.getCurrentItem().isSimilar(launcher)) {
/* 312 */           e.setCancelled(true);
/* 313 */           p.closeInventory();
/* 314 */           p.chat("/kit launcher");
/*     */         }
/*     */         
/* 317 */         if (e.getCurrentItem().isSimilar(bomber)) {
/* 318 */           e.setCancelled(true);
/* 319 */           p.closeInventory();
/* 320 */           p.chat("/kit bomber");
/*     */         }
/*     */         
/* 323 */         if (e.getCurrentItem().isSimilar(endermage)) {
/* 324 */           e.setCancelled(true);
/* 325 */           p.closeInventory();
/* 326 */           p.chat("/kit endermage");
/*     */         }
/*     */         
/* 329 */         if (e.getCurrentItem().isSimilar(fireman)) {
/* 330 */           e.setCancelled(true);
/* 331 */           p.closeInventory();
/* 332 */           p.chat("/kit fireman");
/*     */         }
/*     */         
/* 335 */         if (e.getCurrentItem().isSimilar(flash)) {
/* 336 */           e.setCancelled(true);
/* 337 */           p.closeInventory();
/* 338 */           p.chat("/kit flash");
/*     */         }
/*     */         
/* 341 */         if (e.getCurrentItem().isSimilar(milkman)) {
/* 342 */           e.setCancelled(true);
/* 343 */           p.closeInventory();
/* 344 */           p.chat("/kit milkman");
/*     */         }
/*     */         
/* 347 */         if (e.getCurrentItem().isSimilar(reaper)) {
/* 348 */           e.setCancelled(true);
/* 349 */           p.closeInventory();
/* 350 */           p.chat("/kit reaper");
/*     */         }
/* 352 */         if (e.getCurrentItem().isSimilar(ryu)) {
/* 353 */           e.setCancelled(true);
/* 354 */           p.closeInventory();
/* 355 */           p.chat("/kit ryu");
/*     */         }
/* 357 */         if (e.getCurrentItem().isSimilar(jellyfish)) {
/* 358 */           e.setCancelled(true);
/* 359 */           p.closeInventory();
/* 360 */           p.chat("/kit jellyfish");
/*     */         }
/* 362 */         if (e.getCurrentItem().isSimilar(c4)) {
/* 363 */           e.setCancelled(true);
/* 364 */           p.closeInventory();
/* 365 */           p.chat("/kit c4");
/*     */         }
/* 367 */         if (e.getCurrentItem().isSimilar(magma)) {
/* 368 */           e.setCancelled(true);
/* 369 */           p.closeInventory();
/* 370 */           p.chat("/kit magma");
/*     */         }
/* 372 */         if (e.getCurrentItem().isSimilar(spiderman)) {
/* 373 */           e.setCancelled(true);
/* 374 */           p.closeInventory();
/* 375 */           p.chat("/kit spiderman");
/*     */         }
/* 377 */         if (e.getCurrentItem().isSimilar(deshfire)) {
/* 378 */           e.setCancelled(true);
/* 379 */           p.closeInventory();
/* 380 */           p.chat("/kit deshfire");
/*     */         }
/*     */         
/* 383 */         if (e.getCurrentItem().isSimilar(sonic)) {
/* 384 */           e.setCancelled(true);
/* 385 */           p.closeInventory();
/* 386 */           p.chat("/kit sonic");
/*     */         }
/*     */         
/* 389 */         if (e.getCurrentItem().isSimilar(critical)) {
/* 390 */           e.setCancelled(true);
/* 391 */           p.closeInventory();
/* 392 */           p.chat("/kit critical");
/*     */         }
/*     */         
/* 395 */         if (e.getCurrentItem().isSimilar(thor)) {
/* 396 */           e.setCancelled(true);
/* 397 */           p.closeInventory();
/* 398 */           p.chat("/kit thor");
/*     */         }
/*     */         
/* 401 */         if (e.getCurrentItem().isSimilar(boxer)) {
/* 402 */           e.setCancelled(true);
/* 403 */           p.closeInventory();
/* 404 */           p.chat("/kit boxer");
/*     */         }
/* 406 */         if (e.getCurrentItem().isSimilar(ebola)) {
/* 407 */           e.setCancelled(true);
/* 408 */           p.closeInventory();
/* 409 */           p.chat("/kit ebola");
/*     */         }
/* 411 */         if (e.getCurrentItem().isSimilar(ff)) {
/* 412 */           e.setCancelled(true);
/* 413 */           p.closeInventory();
/* 414 */           p.chat("/kit forcefield");
/*     */         }
/* 416 */         if (e.getCurrentItem().isSimilar(timelord)) {
/* 417 */           e.setCancelled(true);
/* 418 */           p.closeInventory();
/* 419 */           p.chat("/kit timelord");
/*     */         }
/* 421 */         if (e.getCurrentItem().isSimilar(kits2)) {
/* 422 */           e.setCancelled(true);
/* 423 */           p.closeInventory();
/* 424 */           p.playSound(p.getLocation(), org.bukkit.Sound.ANVIL_USE, 2.0F, 2.0F);
/* 425 */           p.chat("/kits2");
/*     */         }
/* 427 */         if (e.getCurrentItem().isSimilar(quickdropper)) {
/* 428 */           e.setCancelled(true);
/* 429 */           p.closeInventory();
/* 430 */           p.playSound(p.getLocation(), org.bukkit.Sound.ANVIL_USE, 2.0F, 2.0F);
/* 431 */           p.chat("/kit quickdropper");
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args)
/*     */   {
/* 439 */     if (!(sender instanceof Player)) {
/* 440 */       sender.sendMessage("§7[§cErro§7] §cApenas jogadores podem usar isso");
/* 441 */       return true;
/*     */     }
/* 443 */     Player p = (Player)sender;
/* 444 */     Inventory kit = org.bukkit.Bukkit.createInventory(p, 54, "§e§nSeus Kits");
/*     */     
/* 446 */     vinha1 = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)14);
/* 447 */     vinha1meta = vinha1.getItemMeta();
/* 448 */     vinha1meta.setDisplayName("§7-");
/* 449 */     vinha1.setItemMeta(vinha1meta);
/*     */     
/* 451 */     grade = new ItemStack(Material.IRON_FENCE, 1);
/* 452 */     grademeta = grade.getItemMeta();
/* 453 */     grademeta.setDisplayName("§7-");
/* 454 */     grade.setItemMeta(grademeta);
/*     */     
/* 456 */     vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)3);
/* 457 */     vidrometa = vidro.getItemMeta();
/* 458 */     vidrometa.setDisplayName("§eExtreme§7Kits");
/* 459 */     vidro.setItemMeta(vidrometa);
/*     */     
/* 461 */     vidro1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
/* 462 */     vidro1meta = vidro1.getItemMeta();
/* 463 */     vidro1meta.setDisplayName("§7-");
/* 464 */     vidro1.setItemMeta(vidro1meta);

/* 461 */     amarelo1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)4);
/* 462 */     amarelo1meta = amarelo1.getItemMeta();
/* 463 */     amarelo1meta.setDisplayName("§7-");
/* 464 */     amarelo1.setItemMeta(amarelo1meta);
		
/* 461 */     azul1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)3);
/* 462 */     azul1meta = azul1.getItemMeta();
/* 463 */     azul1meta.setDisplayName("§7-");
/* 464 */     azul1.setItemMeta(azul1meta);
/*     */     
/* 466 */     fogo = new ItemStack(Material.CAKE, 1);
/* 467 */     fogometa = fogo.getItemMeta();
/* 468 */     fogometa.setDisplayName("§eSeus Kits");
/* 469 */     fogo.setItemMeta(fogometa);
/*     */     
/* 471 */     escada = new ItemStack(Material.LADDER, 1);
/* 472 */     escadameta = escada.getItemMeta();
/* 473 */     escadameta.setDisplayName("§7-");
/* 474 */     escada.setItemMeta(escadameta);







/*     */     
/* 476 */     pvp = new ItemStack(Material.STONE_SWORD, 1);
/* 477 */     pvpmeta = pvp.getItemMeta();
/* 478 */     pvpmeta.setDisplayName("§ePvP");
/* 479 */     pvpmeta.setLore(Lore("§7Esse §7kit §7não §7tem §7habilidades §7porém §7bom §7para §7PvP"));
/* 480 */     pvp.setItemMeta(pvpmeta);
/*     */     
/* 482 */     kangaroo = new ItemStack(Material.FIREWORK, 1);
/* 483 */     kangaroometa = kangaroo.getItemMeta();
/* 484 */     kangaroometa.setDisplayName("§eKangaroo");
/* 485 */     kangaroometa.setLore(Lore("§7Esse §7kit §7você §7tem §7habilidade §7de §7sair §7dando §7pulos §7igual §7um §7Canguru"));
/* 486 */     kangaroo.setItemMeta(kangaroometa);
/*     */     
/* 488 */     archer = new ItemStack(Material.BOW, 1);
/* 489 */     archermeta = archer.getItemMeta();
/* 490 */     archermeta.setDisplayName("§eArcher");
/* 491 */     archermeta.setLore(Lore("§7Esse §7kit §7você §7recebe §7um §7arco §7e §7uma §7flecha §7para §7dar §7Head-Shot "));
/* 492 */     archer.setItemMeta(archermeta);
/*     */     
/* 494 */     viper = new ItemStack(Material.SPIDER_EYE, 1);
/* 495 */     vipermeta = viper.getItemMeta();
/* 496 */     vipermeta.setDisplayName("§eViper");
/* 497 */     vipermeta.setLore(Lore("§7Esse §7kit §7você §7tem §725% §7de §7chance §7para §7dar §7poison §7em §7seu §7inimigo  "));
/* 498 */     viper.setItemMeta(vipermeta);
/*     */     
/* 500 */     snail = new ItemStack(Material.WEB, 1);
/* 501 */     snailmeta = snail.getItemMeta();
/* 502 */     snailmeta.setDisplayName("§eSnail");
/* 503 */     snailmeta.setLore(Lore("§7Esse §7kit §7você §7tem §725% §7de §7chance §7para §7deixar §7seu §7inimigo §7com §7lentidão "));
/* 504 */     snail.setItemMeta(snailmeta);
/*     */     
/* 506 */     fisherman = new ItemStack(Material.FISHING_ROD, 1);
/* 507 */     fishermanmeta = fisherman.getItemMeta();
/* 508 */     fishermanmeta.setDisplayName("§eFisherman");
/* 509 */     fishermanmeta.setLore(Lore("§7Esse §7kit §7você §7tem §7a §7habilidade §7de §7poder §7puxar §7seu §7inimigo "));
/* 510 */     fisherman.setItemMeta(fishermanmeta);
/*     */     
/* 512 */     stomper = new ItemStack(Material.LEATHER_BOOTS, 1);
/* 513 */     stompermeta = stomper.getItemMeta();
/* 514 */     stompermeta.setDisplayName("§eStomper");
/* 515 */     stompermeta.setLore(Lore("§7Esse §7kit §7você §7tem §7a §7habilidade §7de §7poder §7esmagar §7seu §7inimigo "));
/* 516 */     stomper.setItemMeta(stompermeta);
/*     */     
/* 518 */     viking = new ItemStack(Material.STONE_AXE, 1);
/* 519 */     vikingmeta = viking.getItemMeta();
/* 520 */     vikingmeta.setDisplayName("§eViking");
/* 521 */     vikingmeta.setLore(Lore("§7Esse §7kit §7você §7tem §7a §7habilidade §7de §7poder §7dar §7mais §7dano §7com §7seu §7machado "));
/* 522 */     viking.setItemMeta(vikingmeta);
/*     */     
/* 524 */     ninja = new ItemStack(Material.COMPASS, 1);
/* 525 */     ninjameta = ninja.getItemMeta();
/* 526 */     ninjameta.setDisplayName("§eNinja");
/* 527 */     ninjameta.setLore(Lore("§7Esse §7kit §7você §7tem §7a §7habilidade §7de §7poder §7teleportar §7para §7o §7ultimo §7player §7que §7você §7bateu "));
/* 528 */     ninja.setItemMeta(ninjameta);
/*     */     
/* 530 */     specialist = new ItemStack(Material.ENCHANTMENT_TABLE, 1);
/* 531 */     specialistmeta = specialist.getItemMeta();
/* 532 */     specialistmeta.setDisplayName("§eSpecialist");
/* 533 */     specialistmeta.setLore(Lore("§7Esse §7kit §7você §7tem §7a §7habilidade §7de §7poder §7encantar §7seus §7itens §7ganhando §7XP §7ao §7matar §7um §7player "));
/* 534 */     specialist.setItemMeta(specialistmeta);
/*     */     
/* 536 */     turtle = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
/* 537 */     turtlemeta = turtle.getItemMeta();
/* 538 */     turtlemeta.setDisplayName("§eTurtle");
/* 539 */     turtlemeta.setLore(Lore("§7Esse §7kit §7você §7tem §7a §7habilidade §7de §7quando §7o §7player §7inimigo §7te §7bater §7e §7você §7estiver §7agaixado §7você §7tomará §7menos §7dano "));
/* 540 */     turtle.setItemMeta(turtlemeta);
/*     */     
/* 542 */     grandpa = new ItemStack(Material.STICK, 1);
/* 543 */     grandpameta = grandpa.getItemMeta();
/* 544 */     grandpameta.setDisplayName("§eGrandpa");
/* 545 */     grandpameta.addEnchant(org.bukkit.enchantments.Enchantment.KNOCKBACK, 2, true);
/* 546 */     grandpameta.setLore(Lore("§7Esse §7kit §7você §7tem §7uma §7varinha §7magica §7onde §7você §7pode §7lançar §7seu §7inimigo §7longe "));
/* 547 */     grandpa.setItemMeta(grandpameta);
/*     */     
/* 549 */     urgal = new ItemStack(Material.POTION, 1, (short)8201);
/* 550 */     urgalmeta = urgal.getItemMeta();
/* 551 */     urgalmeta.setDisplayName("§eUrgal");
/* 552 */     urgalmeta.setLore(Lore("§7Receba §7duas §7poçÃµes §7de §7força §7e §7mate §7seus §7inimigos"));
/* 553 */     urgal.setItemMeta(urgalmeta);
/*     */     
/* 555 */     poseidon = new ItemStack(Material.WATER_BUCKET);
/* 556 */     poseidonmeta = poseidon.getItemMeta();
/* 557 */     poseidonmeta.setDisplayName("§ePoseidon");
/* 558 */     poseidonmeta.setLore(Lore("§7Ganhe §7velocidade §7e §7força §7quando §7interagir §7com §7água"));
/* 559 */     poseidon.setItemMeta(poseidonmeta);
/*     */     
/* 561 */     berserker = new ItemStack(Material.WOOL, 1, (short)15);
/* 562 */     berserkermeta = berserker.getItemMeta();
/* 563 */     berserkermeta.setDisplayName("§eBerserker");
/* 564 */     berserkermeta.setLore(Lore("§7Ganhe §7velocidade §7e §7força §7quando §7matar §7um §7jogador"));
/* 565 */     berserker.setItemMeta(berserkermeta);
/*     */     
/* 567 */     paladino = new ItemStack(Material.LEATHER_CHESTPLATE);
/* 568 */     paladinometa = paladino.getItemMeta();
/* 569 */     paladinometa.setDisplayName("§ePaladino");
/* 570 */     paladinometa.setLore(Lore("§7Receba §7um §7peitoral §7de §7couro §7e §7tenha §7mais §7proteção"));
/* 571 */     paladino.setItemMeta(paladinometa);
/*     */     
/* 573 */     resouper = new ItemStack(Material.MUSHROOM_SOUP);
/* 574 */     resoupermeta = resouper.getItemMeta();
/* 575 */     resoupermeta.setDisplayName("§eResouper");
/* 576 */     resoupermeta.setLore(Lore("§7Seja §7resoupado §7ao §7matar §7um §7player"));
/* 577 */     resouper.setItemMeta(resoupermeta);
/*     */     
/* 579 */     lavaman = new ItemStack(Material.LAVA_BUCKET);
/* 580 */     lavamanmeta = lavaman.getItemMeta();
/* 581 */     lavamanmeta.setDisplayName("§eLavaman");
/* 582 */     lavamanmeta.setLore(Lore("§7Ganhe §7velocidade §7e §7força §7quando §7interagir §7com §7lava, §7porÃ©m §7quando §7interagir §7com §7água §7levará §7dano"));
/* 583 */     lavaman.setItemMeta(lavamanmeta);
/*     */     
/* 585 */     anchor = new ItemStack(Material.ANVIL);
/* 586 */     anchormeta = anchor.getItemMeta();
/* 587 */     anchormeta.setDisplayName("§eAnchor");
/* 588 */     anchormeta.setLore(Lore("§7Não §7tome §7knock-back §7quando §7um §7player §7te §7bate"));
/* 589 */     anchor.setItemMeta(anchormeta);
/*     */     
/* 591 */     camel = new ItemStack(Material.SAND);
/* 592 */     camelmeta = camel.getItemMeta();
/* 593 */     camelmeta.setDisplayName("§eCamel");
/* 594 */     camelmeta.setLore(Lore("§7Ganhe §7regeneração §7e §7velocidade §7no §7deserto"));
/* 595 */     camel.setItemMeta(camelmeta);
/*     */     
/* 597 */     frosty = new ItemStack(Material.ICE);
/* 598 */     frostymeta = frosty.getItemMeta();
/* 599 */     frostymeta.setDisplayName("§eFrosty");
/* 600 */     frostymeta.setLore(Lore("§7Ganhe §7regeneração §7e §7velocidade §7no §7gelo §7e §7neve"));
/* 601 */     frosty.setItemMeta(frostymeta);
/*     */     
/* 603 */     grappler = new ItemStack(Material.LEASH);
/* 604 */     grapplermeta = grappler.getItemMeta();
/* 605 */     grapplermeta.setDisplayName("§eGrappler");
/* 606 */     grapplermeta.setLore(Lore("§7Use §7seu §7laço §7e §7ande §7mais §7rapido"));
/* 607 */     grappler.setItemMeta(grapplermeta);
/*     */     
/* 609 */     hulk = new ItemStack(Material.SADDLE);
/* 610 */     hulkmeta = hulk.getItemMeta();
/* 611 */     hulkmeta.setDisplayName("§eHulk");
/* 612 */     hulkmeta.setLore(Lore("§7Pegue §7seu §inimigo §7e §7o §7jogue §7para §7longe"));
/* 613 */     hulk.setItemMeta(hulkmeta);
/*     */     
/* 615 */     switcher = new ItemStack(Material.SNOW_BALL);
/* 616 */     switchermeta = switcher.getItemMeta();
/* 617 */     switchermeta.setDisplayName("§eSwitcher");
/* 618 */     switchermeta.setLore(Lore("§7Jogue §7uma §7Bolinha §7de §7Neve §7e §7se §7teleporte §7para §7o §7outro §7player"));
/* 619 */     switcher.setItemMeta(switchermeta);
/*     */     
/* 621 */     launcher = new ItemStack(Material.SPONGE);
/* 622 */     launchermeta = launcher.getItemMeta();
/* 623 */     launchermeta.setDisplayName("§eLauncher");
/* 624 */     launchermeta.setLore(Lore("§7Jogue §7seu §7inimigo §7para §7o §7alto §7e §7mate-o "));
/* 625 */     launcher.setItemMeta(launchermeta);
/*     */     
/* 627 */     bomber = new ItemStack(Material.TNT);
/* 628 */     bombermeta = bomber.getItemMeta();
/* 629 */     bombermeta.setDisplayName("§eBomber");
/* 630 */     bombermeta.setLore(Lore("§7Jogue §7bomba §7e §7mate §7seus §7inimigos §7explodido"));
/* 631 */     bomber.setItemMeta(bombermeta);
/*     */     
/* 633 */     endermage = new ItemStack(Material.PORTAL);
/* 634 */     endermagemeta = endermage.getItemMeta();
/* 635 */     endermagemeta.setDisplayName("§eEndermage");
/* 636 */     endermagemeta.setLore(Lore("§7Puxe §7seus §7inimigos §7e §7mate-os"));
/* 637 */     endermage.setItemMeta(endermagemeta);
/*     */     
/* 639 */     fireman = new ItemStack(Material.FIRE);
/* 640 */     firemanmeta = fireman.getItemMeta();
/* 641 */     firemanmeta.setDisplayName("§eFireman");
/* 642 */     firemanmeta.setLore(Lore("§7Quando §7você §7entrar §7em §7combate §7com §7outro §7jogador, §7ele §7tomará §7dano §7de §7fogo"));
/* 643 */     fireman.setItemMeta(firemanmeta);
/*     */     
/* 645 */     flash = new ItemStack(Material.REDSTONE_TORCH_ON);
/* 646 */     flashmeta = flash.getItemMeta();
/* 647 */     flashmeta.setDisplayName("§eFlash");
/* 648 */     flashmeta.setLore(Lore("§7Seja §7rapido §7como §7o §7flash §7e §7fuja §7de, §7inimigos"));
/* 649 */     flash.setItemMeta(flashmeta);
/*     */     
/* 651 */     milkman = new ItemStack(Material.MILK_BUCKET);
/* 652 */     milkmanmeta = milkman.getItemMeta();
/* 653 */     milkmanmeta.setDisplayName("§eMilkman");
/* 654 */     milkmanmeta.setLore(Lore("§7Ganhe §7poderes §7quando §7tomar §7aquele §7leitin §7gostoso"));
/* 655 */     milkman.setItemMeta(milkmanmeta);
/*     */     
/* 657 */     reaper = new ItemStack(Material.WOOD_HOE);
/* 658 */     reapermeta = reaper.getItemMeta();
/* 659 */     reapermeta.setDisplayName("§eReaper");
/* 660 */     reapermeta.setLore(Lore("§7Clique §7com §7o §7botão §7direito §7com §7sua §7foiçe §7em §7outros §7player §7e §7de §7efeito §7Wither"));
/* 661 */     reaper.setItemMeta(reapermeta);
/*     */     
/* 663 */     ryu = new ItemStack(Material.BEACON);
/* 664 */     ryumeta = ryu.getItemMeta();
/* 665 */     ryumeta.setDisplayName("§eRyu");
/* 666 */     ryumeta.setLore(Lore("§7Jogue §7uma §7bolinha §7de §7neve §7e §7de §7efeitos §7em §7outros §7player "));
/* 667 */     ryu.setItemMeta(ryumeta);
/*     */     
/* 669 */     jellyfish = new ItemStack(Material.STATIONARY_WATER);
/* 670 */     jellyfishmeta = jellyfish.getItemMeta();
/* 671 */     jellyfishmeta.setDisplayName("§eJellyfish");
/* 672 */     jellyfishmeta.setLore(Lore("§7Coloque §7uma §7agua §7no §7chão §7e §7deixe §7seus §7inimigos §7com §7Poison "));
/* 673 */     jellyfish.setItemMeta(jellyfishmeta);
/*     */     
/* 675 */     c4 = new ItemStack(Material.STONE_BUTTON);
/* 676 */     c4meta = c4.getItemMeta();
/* 677 */     c4meta.setDisplayName("§eC4");
/* 678 */     c4meta.setLore(Lore("§7Implante §7uma §7bomba §7e §7explode §7com §7os §7orgãos §7de §7outros §7jogadores "));
/* 679 */     c4.setItemMeta(c4meta);
/*     */     
/* 681 */     magma = new ItemStack(Material.MAGMA_CREAM);
/* 682 */     magmameta = magma.getItemMeta();
/* 683 */     magmameta.setDisplayName("§eMagma");
/* 684 */     magma.setItemMeta(magmameta);
/*     */     
/* 686 */     spiderman = new ItemStack(Material.STRING);
/* 687 */     spidermanmeta = spiderman.getItemMeta();
/* 688 */     spidermanmeta.setDisplayName("§eSpiderman");
/* 689 */     spidermanmeta.setLore(Lore("§7Jogue §7uma §7teia §7e §7prenda §7seu §7inimigo"));
/* 690 */     spiderman.setItemMeta(spidermanmeta);
/*     */     
/* 692 */     deshfire = new ItemStack(Material.REDSTONE_BLOCK);
/* 693 */     deshfiremeta = deshfire.getItemMeta();
/* 694 */     deshfiremeta.setDisplayName("§eDeshfire");
/* 695 */     deshfiremeta.setLore(Lore("§7Taque §7fogo §7em §7seu §7inimigo §7clicando §7com §7o §7botão §7direito §7em §7cima §7do §7bloco §7de §7Redstone "));
/* 696 */     deshfire.setItemMeta(deshfiremeta);
/*     */     
/* 698 */     sonic = new ItemStack(Material.LAPIS_BLOCK);
/* 699 */     sonicmeta = sonic.getItemMeta();
/* 700 */     sonicmeta.setDisplayName("§eSonic");
/* 701 */     sonicmeta.setLore(Lore("§7Fuja §7de §7seus §7inimigos §7e §7faça §7refil §7rapido"));
/* 702 */     sonic.setItemMeta(sonicmeta);
/*     */     
/* 704 */     critical = new ItemStack(Material.GOLDEN_APPLE);
/* 705 */     criticalmeta = critical.getItemMeta();
/* 706 */     criticalmeta.setDisplayName("§eCritical");
/* 707 */     criticalmeta.setLore(Lore("§7Tenha §733% §7de §7chance §7de §7dar §7um §7golpe §7critico §7em §7seu §7inimigo"));
/* 708 */     critical.setItemMeta(criticalmeta);
/*     */     
/* 710 */     thor = new ItemStack(Material.WOOD_AXE);
/* 711 */     thormeta = thor.getItemMeta();
/* 712 */     thormeta.setDisplayName("§eThor");
/* 713 */     thormeta.setLore(Lore("§7Sinta-se §7o §7thor §7e §7mande §7raios §7na §7cabeça §7dos §7seus §7inimigos"));
/* 714 */     thor.setItemMeta(thormeta);
/*     */     
/* 716 */     boxer = new ItemStack(Material.QUARTZ);
/* 717 */     boxermeta = boxer.getItemMeta();
/* 718 */     boxermeta.setDisplayName("§eBoxer");
/* 719 */     boxermeta.setLore(Lore("§7Sinta-se §7o §7lutador §7e §7saia §7dando §7murros §7fortes"));
/* 720 */     boxer.setItemMeta(boxermeta);
/*     */     
/* 722 */     ebola = new ItemStack(Material.POISONOUS_POTATO);
/* 723 */     ebolameta = ebola.getItemMeta();
/* 724 */     ebolameta.setDisplayName("§eEbola");
/* 725 */     ebolameta.setLore(Lore("§7Transmita §7doenças §7ao §7hitar §7um §7jogador"));
/* 726 */     ebola.setItemMeta(ebolameta);
/*     */     
/* 728 */     ff = new ItemStack(Material.NETHER_FENCE);
/* 729 */     ffmeta = ff.getItemMeta();
/* 730 */     ffmeta.setDisplayName("§eForcefield");
/* 731 */     ffmeta.setLore(Lore("§7Crie §7um §7campo §7de §7força §7e §7mate §7jogadores"));
/* 732 */     ff.setItemMeta(ffmeta);
/*     */     
/* 734 */     timelord = new ItemStack(Material.WATCH);
/* 735 */     timelordmeta = timelord.getItemMeta();
/* 736 */     timelordmeta.setDisplayName("§eTimelord");
/* 737 */     timelordmeta.setLore(Lore("§7Congele §7seus §7inimigos §7e §7tenha §7mais §7chance §7de §7mata-los"));
/* 738 */     timelord.setItemMeta(timelordmeta);
/*     */     
/* 740 */     quickdropper = new ItemStack(Material.BOWL);
/* 741 */     quickdroppermeta = quickdropper.getItemMeta();
/* 742 */     quickdroppermeta.setDisplayName("§eQuickDropper");
/* 743 */     quickdroppermeta.setLore(Lore("§7Ao §7Tomar §7Sopa §7Automaticamente §7Ela §7Irá §7Ser §7Dropada"));
/* 744 */     quickdropper.setItemMeta(quickdroppermeta);
/*     */     
/* 746 */     kits2 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)5);
/* 747 */     kits2meta = kits2.getItemMeta();
/* 748 */     kits2meta.setDisplayName("§aAvançar");
/* 749 */     kits2.setItemMeta(kits2meta);

/* 751 */     for (int i = 0; i != 54; i++) {
/* 752 */       kit.setItem(i, vidro);
/*     */     }
/* 754 */     kit.setItem(0, vinha1);
/* 755 */     kit.setItem(1, vidro1);
/* 756 */     kit.setItem(2, vidro1);
/* 757 */     kit.setItem(3, vidro1);
/* 758 */     kit.setItem(4, fogo);
/* 759 */     kit.setItem(5, vidro1);
/* 760 */     kit.setItem(6, vidro1);
/* 761 */     kit.setItem(7, vidro1);
/* 762 */     kit.setItem(8, kits2);
/* 754 */     kit.setItem(9, amarelo1);
/* 755 */     kit.setItem(10, azul1);
/* 756 */     kit.setItem(11, amarelo1);
/* 757 */     kit.setItem(12, azul1);
/* 758 */     kit.setItem(13, amarelo1);
/* 759 */     kit.setItem(14, azul1);
/* 760 */     kit.setItem(15, amarelo1);
/* 761 */     kit.setItem(16, azul1);
/* 761 */     kit.setItem(17, amarelo1);
/*     */     
/* 764 */     if (p.hasPermission("kit.pvp")) {
/* 765 */       kit.removeItem(new ItemStack[] { vidro });
/* 766 */       kit.addItem(new ItemStack[] { pvp });
/*     */     }
/* 772 */     if (p.hasPermission("kit.archer")) {
/* 773 */       kit.removeItem(new ItemStack[] { vidro });
/* 774 */       kit.addItem(new ItemStack[] { archer });
/*     */     }
/* 768 */     if (p.hasPermission("kit.kangaroo")) {
/* 769 */       kit.removeItem(new ItemStack[] { vidro });
/* 770 */       kit.addItem(new ItemStack[] { kangaroo });
/*     */     }
/* 776 */     if (p.hasPermission("kit.viper")) {
/* 777 */       kit.removeItem(new ItemStack[] { vidro });
/* 778 */       kit.addItem(new ItemStack[] { viper });
/*     */     }
/* 780 */     if ((Main.getInstance().loja.getString(p.getName().toLowerCase() + ".Snail").equals("true")) || (p.hasPermission("kit.snail"))) {
/* 781 */       kit.removeItem(new ItemStack[] { vidro });
/* 782 */       kit.addItem(new ItemStack[] { snail });
/*     */     }
/* 784 */     if (p.hasPermission("kit.fisherman")) {
/* 785 */       kit.removeItem(new ItemStack[] { vidro });
/* 786 */       kit.addItem(new ItemStack[] { fisherman });
/*     */     }
/* 788 */     if ((Main.getInstance().loja.getString(p.getName().toLowerCase() + ".Stomper").equals("true")) || (p.hasPermission("kit.stomper"))) {
/* 789 */       kit.removeItem(new ItemStack[] { vidro });
/* 790 */       kit.addItem(new ItemStack[] { stomper });
/*     */     }
/* 792 */     if (p.hasPermission("kit.viking")) {
/* 793 */       kit.removeItem(new ItemStack[] { vidro });
/* 794 */       kit.addItem(new ItemStack[] { viking });
/*     */     }
/* 796 */     if (p.hasPermission("kit.ninja")) {
/* 797 */       kit.removeItem(new ItemStack[] { vidro });
/* 798 */       kit.addItem(new ItemStack[] { ninja });
/*     */     }
/* 800 */     if (p.hasPermission("kit.specialist")) {
/* 801 */       kit.removeItem(new ItemStack[] { vidro });
/* 802 */       kit.addItem(new ItemStack[] { specialist });
/*     */     }
/* 804 */     if (p.hasPermission("kit.turtle")) {
/* 805 */       kit.removeItem(new ItemStack[] { vidro });
/* 806 */       kit.addItem(new ItemStack[] { turtle });
/*     */     }
/* 808 */     if (p.hasPermission("kit.grandpa")) {
/* 809 */       kit.removeItem(new ItemStack[] { vidro });
/* 810 */       kit.addItem(new ItemStack[] { grandpa });
/*     */     }
/* 812 */     if (p.hasPermission("kit.urgal")) {
/* 813 */       kit.removeItem(new ItemStack[] { vidro });
/* 814 */       kit.addItem(new ItemStack[] { urgal });
/*     */     }
/* 816 */     if (p.hasPermission("kit.poseidon")) {
/* 817 */       kit.removeItem(new ItemStack[] { vidro });
/* 818 */       kit.addItem(new ItemStack[] { poseidon });
/*     */     }
/* 820 */     if (p.hasPermission("kit.berserker")) {
/* 821 */       kit.removeItem(new ItemStack[] { vidro });
/* 822 */       kit.addItem(new ItemStack[] { berserker });
/*     */     }
/* 824 */     if (p.hasPermission("kit.paladino")) {
/* 825 */       kit.removeItem(new ItemStack[] { vidro });
/* 826 */       kit.addItem(new ItemStack[] { paladino });
/*     */     }
/* 828 */     if (p.hasPermission("kit.resouper")) {
/* 829 */       kit.removeItem(new ItemStack[] { vidro });
/* 830 */       kit.addItem(new ItemStack[] { resouper });
/*     */     }
/* 832 */     if (p.hasPermission("kit.lavaman")) {
/* 833 */       kit.removeItem(new ItemStack[] { vidro });
/* 834 */       kit.addItem(new ItemStack[] { lavaman });
/*     */     }
/* 836 */     if ((Main.getInstance().loja.getString(p.getName().toLowerCase() + ".Anchor").equals("true")) || (p.hasPermission("kit.anchor"))) {
/* 837 */       kit.removeItem(new ItemStack[] { vidro });
/* 838 */       kit.addItem(new ItemStack[] { anchor });
/*     */     }
/* 840 */     if ((Main.getInstance().loja.getString(p.getName().toLowerCase() + ".Camel").equals("true")) || (p.hasPermission("kit.camel"))) {
/* 841 */       kit.removeItem(new ItemStack[] { vidro });
/* 842 */       kit.addItem(new ItemStack[] { camel });
/*     */     }
/* 844 */     if (p.hasPermission("kit.frosty")) {
/* 845 */       kit.removeItem(new ItemStack[] { vidro });
/* 846 */       kit.addItem(new ItemStack[] { frosty });
/*     */     }
/* 848 */     if (p.hasPermission("kit.grappler")) {
/* 849 */       kit.removeItem(new ItemStack[] { vidro });
/* 850 */       kit.addItem(new ItemStack[] { grappler });
/*     */     }
/* 852 */     if (p.hasPermission("kit.hulk")) {
/* 853 */       kit.removeItem(new ItemStack[] { vidro });
/* 854 */       kit.addItem(new ItemStack[] { hulk });
/*     */     }
/* 856 */     if (p.hasPermission("kit.switcher")) {
/* 857 */       kit.removeItem(new ItemStack[] { vidro });
/* 858 */       kit.addItem(new ItemStack[] { switcher });
/*     */     }
/* 860 */     if (p.hasPermission("kit.launcher")) {
/* 861 */       kit.removeItem(new ItemStack[] { vidro });
/* 862 */       kit.addItem(new ItemStack[] { launcher });
/*     */     }
/* 864 */     if (p.hasPermission("kit.bomber")) {
/* 865 */       kit.removeItem(new ItemStack[] { vidro });
/* 866 */       kit.addItem(new ItemStack[] { bomber });
/*     */     }
/* 868 */     if ((Main.getInstance().loja.getString(p.getName().toLowerCase() + ".Endermage").equals("true")) || (p.hasPermission("kit.endermage"))) {
/* 869 */       kit.removeItem(new ItemStack[] { vidro });
/* 870 */       kit.addItem(new ItemStack[] { endermage });
/*     */     }
/* 872 */     if (p.hasPermission("kit.fireman")) {
/* 873 */       kit.removeItem(new ItemStack[] { vidro });
/* 874 */       kit.addItem(new ItemStack[] { fireman });
/*     */     }
/* 876 */     if (p.hasPermission("kit.flash")) {
/* 877 */       kit.removeItem(new ItemStack[] { vidro });
/* 878 */       kit.addItem(new ItemStack[] { flash });
/*     */     }
/* 880 */     if (p.hasPermission("kit.milkman")) {
/* 881 */       kit.removeItem(new ItemStack[] { vidro });
/* 882 */       kit.addItem(new ItemStack[] { milkman });
/*     */     }
/* 884 */     if (p.hasPermission("kit.reaper")) {
/* 885 */       kit.removeItem(new ItemStack[] { vidro });
/* 886 */       kit.addItem(new ItemStack[] { reaper });
/*     */     }
/* 888 */     if (p.hasPermission("kit.ryu")) {
/* 889 */       kit.removeItem(new ItemStack[] { vidro });
/* 890 */       kit.addItem(new ItemStack[] { ryu });
/*     */     }
/* 892 */     if (p.hasPermission("kit.jellyfish")) {
/* 893 */       kit.removeItem(new ItemStack[] { vidro });
/* 894 */       kit.addItem(new ItemStack[] { jellyfish });
/*     */     }
/* 896 */     if (p.hasPermission("kit.c4")) {
/* 897 */       kit.removeItem(new ItemStack[] { vidro });
/* 898 */       kit.addItem(new ItemStack[] { c4 });
/*     */     }
/* 900 */     if (p.hasPermission("kit.magma")) {
/* 901 */       kit.removeItem(new ItemStack[] { vidro });
/* 902 */       kit.addItem(new ItemStack[] { magma });
/*     */     }
/* 904 */     if (p.hasPermission("kit.spiderman")) {
/* 905 */       kit.removeItem(new ItemStack[] { vidro });
/* 906 */       kit.addItem(new ItemStack[] { spiderman });
/*     */     }
/* 908 */     if (p.hasPermission("kit.deshfire")) {
/* 909 */       kit.removeItem(new ItemStack[] { vidro });
/* 910 */       kit.addItem(new ItemStack[] { deshfire });
/*     */     }
/* 944 */     p.openInventory(kit);
/* 945 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Gui\KitSelector.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */