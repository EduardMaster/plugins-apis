/*     */ package neero.demon.comandos;
/*     */ 
/*     */ import neero.demon.utils.ItemManager;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ public class Kit2 implements org.bukkit.event.Listener, CommandExecutor
/*     */ {
/*  19 */   private static ItemManager im = new ItemManager();
/*     */   
/*     */ 
/*     */   public static void setupGUI(Player p)
/*     */   {
/*  24 */     Inventory inv = Bukkit.createInventory(p, 54, "            §6§lKits disponiveis");
/*     */     
/*     */ 
/*     */ 
/*  28 */     ItemStack vidro = im.createItem(Material.STAINED_GLASS_PANE, "vidro", "-", new String[0], 1, (short)0);
/*  29 */     ItemStack vermelho = im.createItem(Material.THIN_GLASS, "vidro", "-", new String[0], 1, (short)14);
/*  30 */     ItemStack verde = im.createItem(Material.THIN_GLASS, "vidro", "-", new String[0], 1, (short)5);
/*  31 */     ItemStack fogo = im.createItem(Material.getMaterial(351), "vidro", "§6Kits Secundarios", new String[0], 1, (short)10);
/*  32 */     ItemStack kit2 = im.createItem(Material.getMaterial(351), "vidro", "§e§lKits", new String[] { "§e§lAbra os Kits Secundários" }, 1, (short)8);
/*  32 */     ItemStack loja = im.createItem(Material.getMaterial(351), "vidro", "§e§lLoja", new String[] { "§e§lAbra a Loja" }, 1, (short)8);
/*     */     
/*     */ 
/*  71 */     ItemStack Stomper2 = im.createItem(Material.getMaterial(309), "vidro", "§e§lStomper2", new String[] { "§7Mate seus amigos pulando em cima deles." }, 1, (short)0);
			 ItemStack ajnin2 = im.createItem(Material.getMaterial(399), "vidro", "§e§lAjnin2", new String[] { "§7Puxe seus inimigos usando SHIFT." }, 1, (short)0);
			 ItemStack anchor = im.createItem(Material.ANVIL, "vidro", "§e§lAnchor2", new String[] { "§7Não leve knockback" }, 1, (short)0);
			 ItemStack antistomper2 = im.createItem(Material.DIAMOND_BOOTS, "vidro", "§e§lAntiStomper2", new String[] { "§7Não seja stompado =)" }, 1, (short)0);
/*     */     
/*  85 */     inv.setItem(0, vermelho);
/*  86 */     inv.setItem(1, vidro);
/*  87 */     inv.setItem(2, kit2);
/*  88 */     inv.setItem(3, vidro);
/*  89 */     inv.setItem(4, fogo);
/*  90 */     inv.setItem(5, vidro);
/*  91 */     inv.setItem(6, loja);
/*  92 */     inv.setItem(7, vidro);
/*  93 */     inv.setItem(8, verde);
/*     */     
/*     */ 
/*     */ 
/*  98 */     if (p.hasPermission("kit2.Stomper")) {
/*  99 */       inv.addItem(new ItemStack[] { Stomper2 });
/*     */     }
/*     */     
/*  98 */     if (p.hasPermission("kit2.ajnin")) {
/*  99 */       inv.addItem(new ItemStack[] { ajnin2 });
/*     */     }
/*  98 */     if (p.hasPermission("kit2.anchor")) {
/*  99 */       inv.addItem(new ItemStack[] { anchor });
/*     */     }
/*  98 */     if (p.hasPermission("kit2.antistomper")) {
/*  99 */       inv.addItem(new ItemStack[] { antistomper2 });
/*     */     }

/* 276 */     for (int i = 0; i < inv.getSize(); i++) {
/* 277 */       if (inv.getItem(i) == null) {
/* 278 */         inv.setItem(i, vidro);
/*     */       }
/*     */     }
/* 281 */     p.openInventory(inv);
/*     */   }
/*     */   
/*     */   public static void setupGUI2(Player p)
/*     */   {
/* 286 */     Inventory inv = Bukkit.createInventory(p, 54, "               §c§lOutros kits");
/*     */     
/* 288 */     ItemStack vidro = im.createItem(Material.getMaterial(102), "vidro", "-", new String[0], 1, (short)0);
/* 289 */     ItemStack vermelho = im.createItem(Material.getMaterial(171), "vidro", "§4§lSem informcoes", new String[0], 1, (short)14);
/* 290 */     ItemStack verde = im.createItem(Material.getMaterial(171), "vidro", "§4§lPagina", new String[0], 1, (short)5);
/* 291 */     ItemStack fogo = im.createItem(Material.getMaterial(51), "vidro", "§6§oJapaaPvP", new String[0], 1, (short)0);
/* 292 */     ItemStack baudofim = im.createItem(Material.getMaterial(130), "vidro", "§6§lDicas de Kits", new String[] { "§e§lKit Kangaroo!;-;" }, 1, (short)0);
/* 331 */     ItemStack Stomper2 = im.createItem(Material.getMaterial(309), "vidro", "§e§lStomper2", new String[] { "§7Mate seus amigos pulando em cima deles." }, 1, (short)0);
/*     */     
/* 345 */     inv.setItem(0, vermelho);
/* 346 */     inv.setItem(1, vidro);
/* 347 */     inv.setItem(2, baudofim);
/* 348 */     inv.setItem(3, vidro);
/* 349 */     inv.setItem(4, fogo);
/* 350 */     inv.setItem(5, vidro);
/* 351 */     inv.setItem(6, baudofim);
/* 352 */     inv.setItem(7, vidro);
/* 353 */     inv.setItem(8, verde);
/*     */     
/* 355 */     if (!p.hasPermission("kit2.Stomper")) {
/* 356 */       inv.addItem(new ItemStack[] { Stomper2 });

/* 532 */     for (int i = 0; i < inv.getSize(); i++) {
/* 533 */       if (inv.getItem(i) == null) {
/* 534 */         inv.setItem(i, vidro);
/*     */       
/*     */     }
/* 537 */     p.openInventory(inv);
				}
				}
/*     */   }
/*     */   
/*     */ 
/*     */   @org.bukkit.event.EventHandler
/*     */   public void click(InventoryClickEvent event)
/*     */   {
/* 544 */     Player p = (Player)event.getWhoClicked();
/* 545 */     if (p.getOpenInventory().getTitle().equalsIgnoreCase("            §6§lKits disponiveis")) {
/* 546 */       if (event.getCurrentItem() == null) {
/* 547 */         return;
/*     */       }
/* 549 */       if (event.getCurrentItem() == null) {
/* 550 */         event.setCancelled(true);
/*     */       }
/* 552 */       if ((event.getCurrentItem().getType().equals(Material.CARPET)) && 
/* 553 */         (event.getCurrentItem().getTypeId() == 171) && (event.getCurrentItem().getData().getData() == 5)) {
/* 554 */         setupGUI2(p);
/* 555 */         event.setCancelled(true);
/* 556 */         return;
/*     */       }
/*     */       
/* 559 */       if ((event.getCurrentItem().getTypeId() == 102) || (event.getCurrentItem().getTypeId() == 106) || (event.getCurrentItem().getTypeId() == 51)) {
/* 560 */         event.setCancelled(true);
/* 561 */         p.closeInventory();
/* 562 */         return;
/*     */       }
/* 564 */       p.chat("/" + ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
/* 565 */       event.setCancelled(true);
/* 566 */       p.closeInventory();
/*     */     }
/* 568 */     if (event.getInventory().getName().equalsIgnoreCase("               §c§lOutros kits")) {
/* 569 */       if ((event.getCurrentItem().getTypeId() == 171) && (event.getCurrentItem().getData().getData() == 14)) {
/* 570 */         setupGUI(p);
/* 571 */         event.setCancelled(true);
/* 572 */         return;
/*     */       }
/* 574 */       if ((event.getCurrentItem().getTypeId() == 102) || (event.getCurrentItem().getTypeId() == 106) || (event.getCurrentItem().getTypeId() == 51)) {
/* 575 */         event.setCancelled(true);
/* 576 */         p.closeInventory();
/* 577 */         return;
/*     */       }
/* 579 */       p.chat("/" + ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
/* 580 */       event.setCancelled(true);
/* 581 */       p.closeInventory();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
/* 586 */     if ((commandLabel.equalsIgnoreCase("kit2")) || (commandLabel.equalsIgnoreCase("kits"))) {
/* 587 */       Player p = (Player)sender;
/*     */       
/* 589 */       setupGUI(p);
/*     */     }
/*     */     
/*     */ 
/* 593 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\commands\Kit.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */