/*     */ package br.nikao.outros;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ public class KitAPI implements Listener
/*     */ {
/*     */   public static ItemStack sopa;
/*     */   public static ItemMeta sopameta;
/*     */   public static ItemStack cogu1;
/*     */   public static ItemMeta cogu1meta;
/*     */   public static ItemStack cogu2;
/*     */   public static ItemMeta cogu2meta;
/*     */   public static ItemStack pote;
/*     */   public static ItemMeta potemeta;
/*     */   public static ItemStack bu;
/*     */   public static ItemMeta bumeta;
/*     */   public static ItemStack espada;
/*     */   public static ItemMeta espadameta;
/*  27 */   public static HashMap<String, String> Kit = new HashMap();
/*  28 */   public static ArrayList<String> cooldown = new ArrayList();
/*     */   
/*  30 */   public static void setKit(Player p, String kit) { Kit.put(p.getName(), kit); }
/*     */   
/*     */   public static String getkit(Player p)
/*     */   {
/*  34 */     if (Kit.containsKey(p.getName())) {
/*  35 */       return (String)Kit.get(p.getName());
/*     */     }
/*  37 */     return "Nenhum";
/*     */   }
/*     */   
/*     */   public static void RemoveKit(Player p)
/*     */   {
/*  42 */     Kit.remove(p.getName());
/*     */   }
/*     */   
/*     */   public static void Itens(Player p) {
/*  46 */     sopa = new ItemStack(Material.MUSHROOM_SOUP);
/*  47 */     sopameta = sopa.getItemMeta();
/*  48 */     sopa.setItemMeta(sopameta);
/*     */     
/*  50 */     cogu1 = new ItemStack(Material.BROWN_MUSHROOM, 64);
/*  51 */     cogu1meta = cogu1.getItemMeta();
/*  52 */     cogu1.setItemMeta(cogu1meta);
/*     */     
/*  54 */     cogu2 = new ItemStack(Material.RED_MUSHROOM, 64);
/*  55 */     cogu2meta = cogu2.getItemMeta();
/*  56 */     cogu2.setItemMeta(cogu2meta);
/*     */     
/*  58 */     pote = new ItemStack(Material.BOWL, 64);
/*  59 */     potemeta = pote.getItemMeta();
/*  60 */     pote.setItemMeta(potemeta);
/*     */     
/*  62 */     espada = new ItemStack(Material.STONE_SWORD);
/*  63 */     espadameta = espada.getItemMeta();
/*  64 */     espadameta.setDisplayName("§b» §5Espada");
/*  65 */     espada.setItemMeta(espadameta);
/*     */     
/*  67 */     bu = new ItemStack(Material.COMPASS);
/*  68 */     bumeta = bu.getItemMeta();
/*  69 */     bumeta.setDisplayName("§3§l» §7§lBússola");
/*  70 */     bu.setItemMeta(bumeta);
/*     */     
/*  72 */     for (int i = 1; i < 35; i++) {
/*  73 */       p.getInventory().addItem(new ItemStack[] { sopa });
/*  74 */       p.getInventory().setItem(15, cogu1);
/*  75 */       p.getInventory().setItem(14, cogu2);
/*  76 */       p.getInventory().setItem(13, pote);
/*  77 */       p.getInventory().setItem(0, espada);
/*  78 */       p.getInventory().setItem(8, bu);
/*     */     }
/*  80 */     p.updateInventory();
/*     */   }
/*     */   
/*     */   public static void PvP(Player p)
/*     */   {
/*  85 */     p.getInventory().clear();
/*  86 */     Itens(p);
/*  87 */     setKit(p, "PvP");
/*     */     
/*  89 */     ItemStack espada = new ItemStack(Material.STONE_SWORD);
/*  90 */     ItemMeta espadameta = espada.getItemMeta();
/*  91 */     espadameta.setDisplayName("§b» §f§lEspada");
/*  92 */     espadameta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/*  93 */     espada.setItemMeta(espadameta);
/*     */     
/*  95 */     p.getInventory().setItem(0, espada);
/*  96 */     p.updateInventory();
/*     */   }
/*     */   
/*     */   public static void Kangaroo(Player p) {
/* 100 */     p.getInventory().clear();
/* 101 */     Itens(p);
/* 102 */     setKit(p, "Kangaroo");
/*     */     
/* 104 */     ItemStack kangaroo = new ItemStack(Material.FIREWORK);
/* 105 */     ItemMeta kangaroometa = kangaroo.getItemMeta();
/* 106 */     kangaroometa.setDisplayName("§b» §f§lKangaroo");
/* 107 */     kangaroo.setItemMeta(kangaroometa);
/*     */     
/* 109 */     p.getInventory().setItem(1, kangaroo);
/* 110 */     p.updateInventory();
/*     */   }
/*     */   
/*     */   public static void Archer(Player p) {
/* 114 */     p.getInventory().clear();
/* 115 */     Itens(p);
/* 116 */     setKit(p, "Archer");
/*     */     
/* 118 */     ItemStack arco = new ItemStack(Material.BOW);
/* 119 */     ItemMeta arcometa = arco.getItemMeta();
/* 120 */     arcometa.setDisplayName("§b» §f§lArcher");
/* 121 */     arcometa.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/* 122 */     arcometa.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
/* 123 */     arco.setItemMeta(arcometa);
/*     */     
/* 125 */     ItemStack flecha = new ItemStack(Material.ARROW);
/* 126 */     ItemMeta flechameta = flecha.getItemMeta();
/* 127 */     flechameta.setDisplayName("§b» §f§lArcher");
/* 128 */     flecha.setItemMeta(flechameta);
/*     */     
/* 130 */     p.getInventory().setItem(1, arco);
/* 131 */     p.getInventory().setItem(9, flecha);
/* 132 */     p.updateInventory();
/*     */   }
/*     */   
/*     */   public static void Viper(Player p) {
/* 136 */     p.getInventory().clear();
/* 137 */     Itens(p);
/* 138 */     setKit(p, "Viper");
/*     */   }
/*     */   
/*     */   public static void Snail(Player p) {
/* 142 */     p.getInventory().clear();
/* 143 */     Itens(p);
/* 144 */     setKit(p, "Snail");
/*     */   }
/*     */   
/*     */   public static void Ninja(Player p) {
/* 148 */     p.getInventory().clear();
/* 149 */     Itens(p);
/* 150 */     setKit(p, "Ninja");
/*     */   }
/*     */   
/*     */   public static void Fisherman(Player p) {
/* 154 */     p.getInventory().clear();
/* 155 */     Itens(p);
/* 156 */     setKit(p, "Fisherman");
/*     */     
/* 158 */     ItemStack varinha = new ItemStack(Material.FISHING_ROD);
/* 159 */     ItemMeta varinhameta = varinha.getItemMeta();
/* 160 */     varinhameta.setDisplayName("§b» §f§lFisherman");
/* 161 */     varinha.setItemMeta(varinhameta);
/*     */     
/* 163 */     p.getInventory().setItem(1, varinha);
/* 164 */     p.updateInventory();
/*     */   }
/*     */   
/*     */   public static void Fireman(Player p)
/*     */   {
/* 169 */     p.getInventory().clear();
/* 170 */     Itens(p);
/* 171 */     setKit(p, "Fireman");
/*     */   }
/*     */   
/*     */   public static void Barbarian(Player p) {
/* 175 */     p.getInventory().clear();
/* 176 */     Itens(p);
/* 177 */     setKit(p, "Barbarian");
/*     */     
/* 179 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/* 180 */     ItemMeta espadameta = espada.getItemMeta();
/* 181 */     espadameta.setDisplayName("§b» §f§lBarbarian");
/* 182 */     espada.setItemMeta(espadameta);
/*     */     
/* 184 */     p.getInventory().setItem(1, espada);
/* 185 */     p.updateInventory();
/*     */   }
/*     */   
/*     */   public static void Hulk(Player p)
/*     */   {
/* 190 */     p.getInventory().clear();
/* 191 */     Itens(p);
/* 192 */     setKit(p, "Hulk");
/*     */     
/* 194 */     ItemStack sela = new ItemStack(Material.SADDLE);
/* 195 */     ItemMeta selameta = sela.getItemMeta();
/* 196 */     selameta.setDisplayName("§b» §f§lHulk");
/* 197 */     sela.setItemMeta(selameta);
/*     */     
/* 199 */     p.getInventory().setItem(1, sela);
/* 200 */     p.updateInventory();
/*     */   }
/*     */   
/*     */   public static void Urgal(Player p)
/*     */   {
/* 205 */     p.getInventory().clear();
/* 206 */     Itens(p);
/* 207 */     setKit(p, "Urgal");
/*     */     
/* 209 */     ItemStack urgal = new ItemStack(Material.POTION, 2, (short)8233);
/* 210 */     ItemMeta urgalmeta = urgal.getItemMeta();
/* 211 */     urgalmeta.setDisplayName("§b» §f§lPoção");
/* 212 */     urgal.setItemMeta(urgalmeta);
/*     */     
/* 214 */     p.getInventory().setItem(1, urgal);
/* 215 */     p.updateInventory();
/*     */   }
/*     */   
/*     */   public static void Viking(Player p)
/*     */   {
/* 220 */     p.getInventory().clear();
/* 221 */     Itens(p);
/* 222 */     setKit(p, "Viking");
/*     */     
/* 224 */     ItemStack viking = new ItemStack(Material.STONE_AXE);
/* 225 */     ItemMeta vikingmeta = viking.getItemMeta();
/* 226 */     vikingmeta.setDisplayName("§b» §f§lMachado");
/* 227 */     viking.setItemMeta(vikingmeta);
/*     */     
/* 229 */     p.getInventory().setItem(0, viking);
/* 230 */     p.updateInventory();
/*     */   }
/*     */   
/*     */   public static void Grandpa(Player p)
/*     */   {
/* 235 */     p.getInventory().clear();
/* 236 */     Itens(p);
/* 237 */     setKit(p, "Grandpa");
/*     */     
/* 239 */     ItemStack grandpa = new ItemStack(Material.BLAZE_ROD);
/* 240 */     ItemMeta grandpameta = grandpa.getItemMeta();
/* 241 */     grandpameta.setDisplayName("§b» §f§lVarinha");
/* 242 */     grandpameta.addEnchant(Enchantment.KNOCKBACK, 2, true);
/* 243 */     grandpa.setItemMeta(grandpameta);
/*     */     
/* 245 */     p.getInventory().setItem(1, grandpa);
/* 246 */     p.updateInventory();
/*     */   }
/*     */   
/*     */   public static void Stomper(Player p)
/*     */   {
/* 251 */     p.getInventory().clear();
/* 252 */     Itens(p);
/* 253 */     setKit(p, "Stomper");
/*     */     
/* 255 */     p.updateInventory();
/*     */   }
/*     */   
/*     */   public static void Specialist(Player p)
/*     */   {
/* 260 */     p.getInventory().clear();
/* 261 */     Itens(p);
/* 262 */     setKit(p, "Specialist");
/*     */     
/*     */ 
/* 265 */     ItemStack enchant = new ItemStack(Material.BOOK);
/* 266 */     ItemMeta enchantmeta = enchant.getItemMeta();
/* 267 */     enchantmeta.setDisplayName("§b» §f§lEncantar");
/* 268 */     enchant.setItemMeta(enchantmeta);
/*     */     
/* 270 */     p.getInventory().setItem(1, enchant);
/*     */   }
/*     */   
/*     */   public static void Turtle(Player p)
/*     */   {
/* 275 */     p.getInventory().clear();
/* 276 */     Itens(p);
/* 277 */     setKit(p, "Turtle");
/*     */   }
/*     */   
/*     */ 
/*     */   public static void Berserker(Player p)
/*     */   {
/* 283 */     p.getInventory().clear();
/* 284 */     Itens(p);
/* 285 */     setKit(p, "Berserker");
/*     */   }
/*     */   
/*     */ 
/*     */   public static void Poseidon(Player p)
/*     */   {
/* 291 */     p.getInventory().clear();
/* 292 */     Itens(p);
/* 293 */     setKit(p, "Poseidon");
/*     */   }
/*     */   
/*     */ 
/*     */   public static void Paladino(Player p)
/*     */   {
/* 299 */     p.getInventory().clear();
/* 300 */     Itens(p);
/* 301 */     setKit(p, "Paladino");
/*     */     
/*     */ 
/* 304 */     ItemStack paladino = new ItemStack(Material.LEATHER_CHESTPLATE);
/* 305 */     ItemMeta paladinometa = paladino.getItemMeta();
/* 306 */     paladinometa.setDisplayName("§b» §f§lPeitoral");
/* 307 */     paladino.setItemMeta(paladinometa);
/*     */     
/* 309 */     p.getInventory().setChestplate(paladino);
/*     */   }
/*     */   
/*     */   public static void Resouper(Player p)
/*     */   {
/* 314 */     p.getInventory().clear();
/* 315 */     Itens(p);
/* 316 */     setKit(p, "Resouper");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void Lavaman(Player p)
/*     */   {
/* 323 */     p.getInventory().clear();
/* 324 */     Itens(p);
/* 325 */     setKit(p, "Lavaman");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void Anchor(Player p)
/*     */   {
/* 332 */     p.getInventory().clear();
/* 333 */     Itens(p);
/* 334 */     setKit(p, "Anchor");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void Camel(Player p)
/*     */   {
/* 341 */     p.getInventory().clear();
/* 342 */     Itens(p);
/* 343 */     setKit(p, "Camel");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void Frosty(Player p)
/*     */   {
/* 350 */     p.getInventory().clear();
/* 351 */     Itens(p);
/* 352 */     setKit(p, "Frosty");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void Grappler(Player p)
/*     */   {
/* 359 */     p.getInventory().clear();
/* 360 */     Itens(p);
/* 361 */     setKit(p, "Grappler");
/*     */     
/*     */ 
/* 364 */     ItemStack laço = new ItemStack(Material.LEASH);
/* 365 */     ItemMeta laçometa = laço.getItemMeta();
/* 366 */     laçometa.setDisplayName("§b» §f§lLaço");
/* 367 */     laço.setItemMeta(laçometa);
/*     */     
/* 369 */     p.getInventory().setItem(1, laço);
/*     */   }
/*     */   
/*     */   public static void Switcher(Player p)
/*     */   {
/* 374 */     p.getInventory().clear();
/* 375 */     Itens(p);
/* 376 */     setKit(p, "Switcher");
/*     */     
/*     */ 
/* 379 */     ItemStack switcher = new ItemStack(Material.SNOW_BALL, 16);
/* 380 */     ItemMeta switchermeta = switcher.getItemMeta();
/* 381 */     switchermeta.setDisplayName("§b» §f§lBolas de neve");
/* 382 */     switcher.setItemMeta(switchermeta);
/*     */     
/* 384 */     p.getInventory().setItem(1, switcher);
/*     */   }
/*     */   
/*     */   public static void Launcher(Player p)
/*     */   {
/* 389 */     p.getInventory().clear();
/* 390 */     Itens(p);
/* 391 */     setKit(p, "Launcher");
/*     */     
/*     */ 
/* 394 */     ItemStack launcher = new ItemStack(Material.FISHING_ROD);
/* 395 */     ItemMeta launchermeta = launcher.getItemMeta();
/* 396 */     launchermeta.setDisplayName("§b» §f§lLaucher");
/* 397 */     launcher.setItemMeta(launchermeta);
/*     */     
/* 399 */     p.getInventory().setItem(1, launcher);
/*     */   }
/*     */   
/*     */   public static void Endermage(Player p)
/*     */   {
/* 404 */     p.getInventory().clear();
/* 405 */     Itens(p);
/* 406 */     setKit(p, "Endermage");
/*     */     
/*     */ 
/* 409 */     ItemStack tnt = new ItemStack(Material.PORTAL);
/* 410 */     ItemMeta tntmeta = tnt.getItemMeta();
/* 411 */     tntmeta.setDisplayName("§b» §f§lPortal");
/* 412 */     tnt.setItemMeta(tntmeta);
/*     */     
/* 414 */     p.getInventory().setItem(1, tnt);
/*     */   }
/*     */   
/*     */   public static void Reaper(Player p)
/*     */   {
/* 419 */     p.getInventory().clear();
/* 420 */     Itens(p);
/* 421 */     setKit(p, "Reaper");
/*     */     
/*     */ 
/* 424 */     ItemStack flash = new ItemStack(Material.WOOD_HOE);
/* 425 */     ItemMeta flashmeta = flash.getItemMeta();
/* 426 */     flashmeta.setDisplayName("§b» §f§lFoiçe");
/* 427 */     flash.setItemMeta(flashmeta);
/*     */     
/* 429 */     p.getInventory().setItem(1, flash);
/*     */   }
/*     */   
/*     */   public static void Ryu(Player p)
/*     */   {
/* 434 */     p.getInventory().clear();
/* 435 */     Itens(p);
/* 436 */     setKit(p, "Ryu");
/*     */     
/*     */ 
/* 439 */     ItemStack flash = new ItemStack(Material.BEACON);
/* 440 */     ItemMeta flashmeta = flash.getItemMeta();
/* 441 */     flashmeta.setDisplayName("§b» §f§lHadouken");
/* 442 */     flash.setItemMeta(flashmeta);
/*     */     
/* 444 */     p.getInventory().setItem(1, flash);
/*     */   }
/*     */   
/*     */   public static void Magma(Player p)
/*     */   {
/* 449 */     p.getInventory().clear();
/* 450 */     Itens(p);
/* 451 */     setKit(p, "Magma");
/*     */   }
/*     */   
/*     */ 
/*     */   public static void Spiderman(Player p)
/*     */   {
/* 457 */     p.getInventory().clear();
/* 458 */     Itens(p);
/* 459 */     setKit(p, "Spiderman");
/*     */     
/*     */ 
/* 462 */     ItemStack spider = new ItemStack(Material.STRING);
/* 463 */     ItemMeta spidermeta = spider.getItemMeta();
/* 464 */     spidermeta.setDisplayName("§b» §f§lTeia");
/* 465 */     spider.setItemMeta(spidermeta);
/*     */     
/* 467 */     p.getInventory().setItem(1, spider);
/*     */   }
/*     */   
/*     */   public static void Deshfire(Player p)
/*     */   {
/* 472 */     p.getInventory().clear();
/* 473 */     Itens(p);
/* 474 */     setKit(p, "Deshfire");
/*     */     
/*     */ 
/* 477 */     ItemStack spider = new ItemStack(Material.REDSTONE_BLOCK);
/* 478 */     ItemMeta spidermeta = spider.getItemMeta();
/* 479 */     spidermeta.setDisplayName("§b» §f§lDeshfire");
/* 480 */     spider.setItemMeta(spidermeta);
/*     */     
/* 482 */     p.getInventory().setItem(1, spider);
/*     */   }
/*     */   
/*     */   public static void Critical(Player p)
/*     */   {
/* 487 */     p.getInventory().clear();
/* 488 */     Itens(p);
/* 489 */     setKit(p, "Critical");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void Thor(Player p)
/*     */   {
/* 496 */     p.getInventory().clear();
/* 497 */     Itens(p);
/* 498 */     setKit(p, "Thor");
/*     */     
/*     */ 
/* 501 */     ItemStack infernor = new ItemStack(Material.STONE_AXE);
/* 502 */     ItemMeta infernormeta = infernor.getItemMeta();
/* 503 */     infernormeta.setDisplayName("§b» §f§lMachado");
/* 504 */     infernor.setItemMeta(infernormeta);
/*     */     
/* 506 */     p.getInventory().setItem(1, infernor);
/* 507 */     p.updateInventory();
/*     */   }
/*     */   
/*     */   public static void ForceField(Player p)
/*     */   {
/* 512 */     p.getInventory().clear();
/* 513 */     Itens(p);
/* 514 */     setKit(p, "ForceField");
/*     */     
/*     */ 
/* 517 */     ItemStack ff = new ItemStack(Material.NETHER_FENCE);
/* 518 */     ItemMeta ffmeta = ff.getItemMeta();
/* 519 */     ffmeta.setDisplayName("§b» §f§lAtivar");
/* 520 */     ff.setItemMeta(ffmeta);
/*     */     
/* 522 */     p.getInventory().setItem(1, ff);
/*     */   }
/*     */   
/*     */   public static void Timelord(Player p)
/*     */   {
/* 527 */     p.getInventory().clear();
/* 528 */     Itens(p);
/* 529 */     setKit(p, "Timelord");
/*     */     
/*     */ 
/* 532 */     ItemStack timelord = new ItemStack(Material.WATCH);
/* 533 */     ItemMeta timelordmeta = timelord.getItemMeta();
/* 534 */     timelordmeta.setDisplayName("§b» §f§lCongelar");
/* 535 */     timelord.setItemMeta(timelordmeta);
/*     */     
/* 537 */     p.getInventory().setItem(1, timelord);
/*     */   }
/*     */   
/*     */   public static void Backpacker(Player p)
/*     */   {
/* 542 */     p.getInventory().clear();
/* 543 */     Itens(p);
/* 544 */     setKit(p, "Backpacker");
/*     */     
/*     */ 
/* 547 */     ItemStack bp = new ItemStack(Material.CHEST);
/* 548 */     ItemMeta bpmeta = bp.getItemMeta();
/* 549 */     bpmeta.setDisplayName("§b» §f§lSopas");
/* 550 */     bp.setItemMeta(bpmeta);
/*     */     
/* 552 */     p.getInventory().setItem(1, bp);
/*     */   }
/*     */   
/*     */   public static void Phantom(Player p)
/*     */   {
/* 557 */     p.getInventory().clear();
/* 558 */     Itens(p);
/* 559 */     setKit(p, "Phantom");
/*     */     
/*     */ 
/* 562 */     ItemStack pena = new ItemStack(Material.FEATHER);
/* 563 */     ItemMeta penameta = pena.getItemMeta();
/* 564 */     penameta.setDisplayName("§b» §f§lPena");
/* 565 */     pena.setItemMeta(penameta);
/*     */     
/* 567 */     p.getInventory().setItem(1, pena);
/*     */   }
/*     */   
/*     */   public static void Rain(Player p)
/*     */   {
/* 572 */     p.getInventory().clear();
/* 573 */     Itens(p);
/* 574 */     setKit(p, "Rain");
/*     */     
/*     */ 
/* 577 */     ItemStack flecha = new ItemStack(Material.ARROW, 1);
/* 578 */     ItemMeta flechameta = flecha.getItemMeta();
/* 579 */     flechameta.setDisplayName("§b» §f§lFlecha");
/* 580 */     flecha.setItemMeta(flechameta);
/*     */     
/* 582 */     p.getInventory().setItem(1, flecha);
/*     */   }
/*     */   
/*     */   public static void QuickDropper(Player p)
/*     */   {
/* 587 */     p.getInventory().clear();
/* 588 */     Itens(p);
/* 589 */     setKit(p, "QuickDropper");
/*     */   }
/*     */   
/*     */ 
/*     */   public static void Monk(Player p)
/*     */   {
/* 595 */     p.getInventory().clear();
/* 596 */     Itens(p);
/* 597 */     setKit(p, "Monk");
/*     */     
/*     */ 
/* 600 */     ItemStack monk = new ItemStack(Material.BLAZE_ROD);
/* 601 */     ItemMeta monkmeta = monk.getItemMeta();
/* 602 */     monkmeta.setDisplayName("§b» §f§lMonk");
/* 603 */     monk.setItemMeta(monkmeta);
/*     */     
/* 605 */     p.getInventory().setItem(1, monk);
/*     */   }
/*     */   
/*     */   public static void C4(Player p) {
/* 609 */     p.getInventory().clear();
/* 610 */     Itens(p);
/* 611 */     setKit(p, "C4");
/*     */     
/* 613 */     ItemStack bomba = new ItemStack(Material.SLIME_BALL);
/* 614 */     ItemMeta bombameta = bomba.getItemMeta();
/* 615 */     bombameta.setDisplayName("§b» §f§lAllahu Akbar");
/* 616 */     bomba.setItemMeta(bombameta);
/*     */     
/* 618 */     p.getInventory().setItem(1, bomba);
/* 619 */     p.updateInventory();
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\KitAPI.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */