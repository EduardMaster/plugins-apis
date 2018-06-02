/*     */ package br.nikao.gui;
/*     */ 
/*     */ import br.nikao.Main;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ public class LojaDeKits implements org.bukkit.command.CommandExecutor, org.bukkit.event.Listener
/*     */ {
/*     */   public static ItemStack vidro;
/*     */   public static ItemMeta vidrometa;
/*     */   public static ItemStack vinha;
/*     */   public static ItemMeta vinhameta;
/*     */   public static ItemStack vidro2;
/*     */   public static ItemMeta vidro2meta;
/*     */   public static ItemStack quickdropper;
/*     */   public static ItemMeta quickdroppermeta;
/*     */   public static ItemStack stomper;
/*     */   public static ItemMeta stompermeta;
/*     */   public static ItemStack thor;
/*     */   public static ItemMeta thormeta;
/*     */   public static ItemStack ninja;
/*     */   public static ItemMeta ninjameta;
/*     */   
/*     */   public static java.util.List<String> Lore(String string)
/*     */   {
/*  30 */     String[] split = string.split(" ");
/*  31 */     string = "";
/*     */     
/*  33 */     java.util.ArrayList<String> newString = new java.util.ArrayList();
/*  34 */     for (int i = 0; i < split.length; i++) {
/*  35 */       if ((string.length() > 20) || (string.endsWith("."))) {
/*  36 */         newString.add(string);
/*  37 */         if (string.endsWith(".")) {
/*  38 */           newString.add("");
/*     */         }
/*  40 */         string = "";
/*     */       }
/*  42 */       string = string + (string.length() == 0 ? "" : " ") + split[i];
/*     */     }
/*  44 */     newString.add(string);
/*  45 */     return newString;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @org.bukkit.event.EventHandler
/*     */   public void Clicar(org.bukkit.event.player.PlayerInteractEvent e)
/*     */   {
/*  66 */     Player p = e.getPlayer();
/*  67 */     if ((e.getMaterial() == Material.EXP_BOTTLE) && (e.getItem().getType() == Material.EXP_BOTTLE) && (br.nikao.outros.KitAPI.getkit(p) == "Nenhum") && (e.getItem().getItemMeta().getDisplayName() == "§7» §f§lLoja §8§l(§6§nXP§8§l)")) {
/*  68 */       p.playSound(p.getLocation(), org.bukkit.Sound.CLICK, 2.0F, 2.0F);
/*  69 */       Inventory loja = org.bukkit.Bukkit.createInventory(p, 27, "§7§l§nLoja de Kits");
/*     */       
/*  71 */       vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
/*  72 */       vidrometa = vidro.getItemMeta();
/*  73 */       vidrometa.setDisplayName(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§"));
/*  74 */       vidro.setItemMeta(vidrometa);
/*     */       
/*  76 */       vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)11);
/*  77 */       vidro2meta = vidro2.getItemMeta();
/*  78 */       vidro2meta.setDisplayName(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§"));
/*  79 */       vidro2.setItemMeta(vidro2meta);
/*     */       
/*  81 */       quickdropper = new ItemStack(Material.BOWL, 1);
/*  82 */       quickdroppermeta = quickdropper.getItemMeta();
/*  83 */       quickdroppermeta.setDisplayName("§7§lKit: §eQuickDropper");
/*  84 */       quickdroppermeta.setLore(Lore(""));
/*  85 */       quickdroppermeta.setLore(Lore("§7§lXP: §f§l10.000"));
/*  86 */       quickdropper.setItemMeta(quickdroppermeta);
/*     */       
/*  88 */       stomper = new ItemStack(Material.IRON_BOOTS, 1);
/*  89 */       stompermeta = stomper.getItemMeta();
/*  90 */       stompermeta.setDisplayName("§7§lKit: §eStomper");
/*  91 */       stompermeta.setLore(Lore(""));
/*  92 */       stompermeta.setLore(Lore("§7§lXP: §f§l50.000"));
/*  93 */       stomper.setItemMeta(stompermeta);
/*     */       
/*  95 */       thor = new ItemStack(Material.STONE_AXE, 1);
/*  96 */       thormeta = thor.getItemMeta();
/*  97 */       thormeta.setDisplayName("§7§lKit: §eThor");
/*  98 */       thormeta.setLore(Lore(""));
/*  99 */       thormeta.setLore(Lore("§7§lXP: §f§l15.000"));
/* 100 */       thor.setItemMeta(thormeta);
/*     */       
/* 102 */       ninja = new ItemStack(Material.COMPASS, 1);
/* 103 */       ninjameta = ninja.getItemMeta();
/* 104 */       ninjameta.setDisplayName("§7§lKit: §eNinja");
/* 105 */       ninjameta.setLore(Lore(""));
/* 106 */       ninjameta.setLore(Lore("§7§lXP: §f§l20.000"));
/* 107 */       ninja.setItemMeta(ninjameta);
/*     */       
/* 109 */       for (int i = 0; i != 27; i++) {
/* 110 */         loja.setItem(i, vidro);
/*     */       }
/* 112 */       loja.setItem(0, vidro2);
/* 113 */       loja.setItem(8, vidro2);
/* 114 */       loja.setItem(9, vidro2);
/* 115 */       loja.setItem(10, vidro2);
/* 116 */       loja.setItem(11, quickdropper);
/* 117 */       loja.setItem(12, thor);
/* 118 */       loja.setItem(13, vidro2);
/* 119 */       loja.setItem(14, ninja);
/* 120 */       loja.setItem(15, stomper);
/* 121 */       loja.setItem(16, vidro2);
/* 122 */       loja.setItem(17, vidro2);
/* 123 */       loja.setItem(18, vidro2);
/* 124 */       loja.setItem(26, vidro2);
/* 125 */       p.openInventory(loja);
/*     */     }
/*     */   }
/*     */   
/*     */   @org.bukkit.event.EventHandler
/*     */   public void Kits(InventoryClickEvent e) throws java.sql.SQLException {
/* 131 */     if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
/* 132 */       Player p = (Player)e.getWhoClicked();
/* 133 */       Inventory inv = e.getInventory();
/* 134 */       int value = Main.getInstance().getConfig().getInt("Status." + p.getName() + ".XP");
/* 135 */       if (inv.getTitle().equalsIgnoreCase("§7§l§nLoja de Kits"))
/*     */       {
/* 137 */         if (e.getCurrentItem().isSimilar(vidro)) {
/* 138 */           e.setCancelled(true);
/*     */         }
/*     */         
/* 141 */         if (e.getCurrentItem().isSimilar(vidro2)) {
/* 142 */           e.setCancelled(true);
/*     */         }
/*     */         
/* 145 */         if (e.getCurrentItem().isSimilar(quickdropper)) {
/* 146 */           e.setCancelled(true);
/* 147 */           if (!p.hasPermission("kit.quickdropper")) {
/* 148 */             if (value >= 10000) {
/* 149 */               Sucesso(p, "QuickDropper");
/* 150 */               Main.XP.put(p.getName(), Integer.valueOf(value - 10000));
/*     */             } else {
/* 152 */               MoneyErro(p, "QuickDropper", 10000);
/*     */             }
/*     */           } else {
/* 155 */             Jatem(p);
/*     */           }
/*     */         }
/*     */         
/* 159 */         if (e.getCurrentItem().isSimilar(stomper)) {
/* 160 */           e.setCancelled(true);
/* 161 */           if (!p.hasPermission("kit.stomper")) {
/* 162 */             if (value >= 50000) {
/* 163 */               Sucesso(p, "Stomper");
/* 164 */               Main.XP.put(p.getName(), Integer.valueOf(value - 50000));
/*     */             } else {
/* 166 */               MoneyErro(p, "Stomper", 50000);
/*     */             }
/*     */           } else {
/* 169 */             Jatem(p);
/*     */           }
/*     */         }
/*     */         
/* 173 */         if (e.getCurrentItem().isSimilar(thor)) {
/* 174 */           e.setCancelled(true);
/* 175 */           if (!p.hasPermission("kit.thor")) {
/* 176 */             if (value >= 15000) {
/* 177 */               Sucesso(p, "Thor");
/* 178 */               Main.XP.put(p.getName(), Integer.valueOf(value - 15000));
/*     */             } else {
/* 180 */               MoneyErro(p, "Thor", 15000);
/*     */             }
/*     */           } else {
/* 183 */             Jatem(p);
/*     */           }
/*     */         }
/*     */         
/* 187 */         if (e.getCurrentItem().isSimilar(ninja)) {
/* 188 */           e.setCancelled(true);
/* 189 */           if (!p.hasPermission("kit.ninja")) {
/* 190 */             if (value >= 20000) {
/* 191 */               Sucesso(p, "Ninja");
/* 192 */               Main.XP.put(p.getName(), Integer.valueOf(value - 20000));
/*     */             } else {
/* 194 */               MoneyErro(p, "Ninja", 20000);
/*     */             }
/*     */           } else {
/* 197 */             Jatem(p);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args)
/*     */   {
/* 206 */     if (!(sender instanceof Player)) {
/* 207 */       sender.sendMessage("§7[§cErro§7] §cApenas jogadores podem executar esse comando");
/* 208 */       return true;
/*     */     }
/* 210 */     Player p = (Player)sender;
/* 211 */     if (br.nikao.outros.KitAPI.getkit(p) != "Nenhum") {
/* 212 */       p.sendMessage("§cNão foi possivel abrir a loja de kits pois você está com um Kit.");
/* 213 */       return true;
/*     */     }
/* 215 */     Inventory loja = org.bukkit.Bukkit.createInventory(p, 27, "§7§l§nLoja de Kits");
/*     */     
/* 217 */     vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)11);
/* 218 */     vidrometa = vidro.getItemMeta();
/* 219 */     vidrometa.setDisplayName(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§"));
/* 220 */     vidro.setItemMeta(vidrometa);
/*     */     
/* 222 */     vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)11);
/* 223 */     vidro2meta = vidro2.getItemMeta();
/* 224 */     vidro2meta.setDisplayName(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§"));
/* 225 */     vidro2.setItemMeta(vidro2meta);
/*     */     
/* 227 */     quickdropper = new ItemStack(Material.BOWL, 1);
/* 228 */     quickdroppermeta = quickdropper.getItemMeta();
/* 229 */     quickdroppermeta.setDisplayName("§7§lKit: §eQuickDropper");
/* 230 */     quickdroppermeta.setLore(Lore(""));
/* 231 */     quickdroppermeta.setLore(Lore("§7§lXP: §f§l10.000"));
/* 232 */     quickdropper.setItemMeta(quickdroppermeta);
/*     */     
/* 234 */     stomper = new ItemStack(Material.IRON_BOOTS, 1);
/* 235 */     stompermeta = stomper.getItemMeta();
/* 236 */     stompermeta.setDisplayName("§7§lKit: §eStomper");
/* 237 */     stompermeta.setLore(Lore(""));
/* 238 */     stompermeta.setLore(Lore("§7§lXP: §f§l50.000"));
/* 239 */     stomper.setItemMeta(stompermeta);
/*     */     
/* 241 */     thor = new ItemStack(Material.STONE_SWORD, 1);
/* 242 */     thormeta = thor.getItemMeta();
/* 243 */     thormeta.setDisplayName("§7§lKit: §eThor");
/* 244 */     thormeta.setLore(Lore(""));
/* 245 */     thormeta.setLore(Lore("§7§lXP: §f§l15.000"));
/* 246 */     thor.setItemMeta(thormeta);
/*     */     
/* 248 */     ninja = new ItemStack(Material.COMPASS, 1);
/* 249 */     ninjameta = ninja.getItemMeta();
/* 250 */     ninjameta.setDisplayName("§7§lKit: §eNinja");
/* 251 */     ninjameta.setLore(Lore(""));
/* 252 */     ninjameta.setLore(Lore("§7§lXP: §f§l20.000"));
/* 253 */     ninja.setItemMeta(ninjameta);
/*     */     
/* 255 */     for (int i = 0; i != 27; i++) {
/* 256 */       loja.setItem(i, vidro);
/*     */     }
/* 258 */     loja.setItem(0, vidro2);
/* 259 */     loja.setItem(8, vidro2);
/* 260 */     loja.setItem(9, vidro2);
/* 261 */     loja.setItem(10, vidro2);
/* 262 */     loja.setItem(11, quickdropper);
/* 263 */     loja.setItem(12, thor);
/* 264 */     loja.setItem(13, vidro2);
/* 265 */     loja.setItem(14, ninja);
/* 266 */     loja.setItem(15, stomper);
/* 267 */     loja.setItem(16, vidro2);
/* 268 */     loja.setItem(17, vidro2);
/* 269 */     loja.setItem(18, vidro2);
/* 270 */     loja.setItem(26, vidro2);
/* 271 */     p.openInventory(loja);
/* 272 */     return false;
/*     */   }
/*     */   
/*     */   public void MoneyErro(Player p, String k, int m) {
/* 276 */     p.sendMessage("§cDesculpe, você não possui " + m + " §cde XP para comprar esse Kit");
/* 277 */     p.closeInventory();
/*     */   }
/*     */   
/*     */   public void Jatem(Player p) {
/* 281 */     p.sendMessage("§cVocê já possui este Kit.");
/* 282 */     p.closeInventory();
/*     */   }
/*     */   
/*     */   public void Sucesso(Player p, String k) {
/* 286 */     p.sendMessage("§7§lParabéns você acabá de comprar o Kit §e" + k);
/* 287 */     org.bukkit.Bukkit.getServer().dispatchCommand(org.bukkit.Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit." + k);
/* 288 */     p.closeInventory();
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\gui\LojaDeKits.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */