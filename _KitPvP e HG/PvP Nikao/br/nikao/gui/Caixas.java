/*     */ package br.nikao.gui;
/*     */ 
/*     */ import br.nikao.Main;
/*     */ import br.nikao.outros.KitsAleatorios;
/*     */ import java.util.ArrayList;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ public class Caixas implements org.bukkit.event.Listener, org.bukkit.command.CommandExecutor
/*     */ {
/*     */   public static ItemStack vidro;
/*     */   public static ItemMeta vidrometa;
/*     */   public static ItemStack vidro2;
/*     */   public static ItemMeta vidro2meta;
/*     */   public static ItemStack comprarcaixa;
/*     */   public static ItemMeta comprarcaixameta;
/*     */   public static ItemStack Ferro;
/*     */   public static ItemMeta Ferrometa;
/*     */   public static ItemStack Ouro;
/*     */   public static ItemMeta Ourometa;
/*     */   public static ItemStack Esmeralda;
/*     */   public static ItemMeta Esmeraldameta;
/*     */   
/*     */   public static java.util.List<String> Lore(String string)
/*     */   {
/*  32 */     String[] split = string.split(" ");
/*  33 */     string = "";
/*  34 */     org.bukkit.ChatColor color = org.bukkit.ChatColor.GOLD;
/*     */     
/*  36 */     ArrayList<String> newString = new ArrayList();
/*  37 */     for (int i = 0; i < split.length; i++) {
/*  38 */       if ((string.length() > 20) || (string.endsWith("."))) {
/*  39 */         newString.add(color + string);
/*  40 */         if (string.endsWith(".")) {
/*  41 */           newString.add("");
/*     */         }
/*  43 */         string = "";
/*     */       }
/*  45 */       string = string + (string.length() == 0 ? "" : " ") + split[i];
/*     */     }
/*  47 */     newString.add(string);
/*  48 */     return newString;
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
/*     */   @org.bukkit.event.EventHandler
/*     */   public void Gui(org.bukkit.event.player.PlayerInteractEvent e)
/*     */   {
/*  66 */     Player p = e.getPlayer();
/*  67 */     if ((e.getMaterial() == Material.ENCHANTMENT_TABLE) && (e.getItem().getType() == Material.ENCHANTMENT_TABLE) && (br.nikao.outros.KitAPI.getkit(p) == "Nenhum")) {
/*  68 */       p.playSound(p.getLocation(), org.bukkit.Sound.CLICK, 2.0F, 2.0F);
/*  69 */       Inventory loja = Bukkit.createInventory(p, 9, "§7§l§nCaixas");
/*     */       
/*  71 */       vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
/*  72 */       vidrometa = vidro.getItemMeta();
/*  73 */       vidrometa.setDisplayName(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§"));
/*  74 */       vidro.setItemMeta(vidrometa);
/*     */       
/*  76 */       comprarcaixa = new ItemStack(Material.CHEST);
/*  77 */       comprarcaixameta = comprarcaixa.getItemMeta();
/*  78 */       comprarcaixameta.setDisplayName("§a§lComprar Caixa");
/*  79 */       comprarcaixa.setItemMeta(comprarcaixameta);
/*     */       
/*  81 */       Ferro = new ItemStack(Material.IRON_BLOCK, 1);
/*  82 */       Ferrometa = Ferro.getItemMeta();
/*  83 */       Ferrometa.setDisplayName("§6§lCaixa: §7§lFerro");
/*  84 */       Ferrometa.setLore(Lore("§eGanhe um kit aleatorio"));
/*  85 */       Ferrometa.setLore(Lore("§f"));
/*  86 */       if (p.hasPermission("caixa.ferro")) {
/*  87 */         Ferrometa.setLore(Lore("§aVocê tem essa caixa"));
/*     */       } else {
/*  89 */         Ferrometa.setLore(Lore("§cVocê não tem essa caixa"));
/*     */       }
/*  91 */       Ferro.setItemMeta(Ferrometa);
/*     */       
/*  93 */       Ouro = new ItemStack(Material.GOLD_BLOCK, 1);
/*  94 */       Ourometa = Ouro.getItemMeta();
/*  95 */       Ourometa.setDisplayName("§6§lCaixa: §e§lOuro");
/*  96 */       Ourometa.setLore(Lore("§eGanhe dois kits aleatorio"));
/*  97 */       Ourometa.setLore(Lore("§f"));
/*  98 */       if (p.hasPermission("caixa.ouro")) {
/*  99 */         Ourometa.setLore(Lore("§aVocê tem essa caixa"));
/*     */       } else {
/* 101 */         Ourometa.setLore(Lore("§cVocê não tem essa caixa"));
/*     */       }
/* 103 */       Ouro.setItemMeta(Ourometa);
/*     */       
/* 105 */       Esmeralda = new ItemStack(Material.EMERALD_BLOCK, 1);
/* 106 */       Esmeraldameta = Esmeralda.getItemMeta();
/* 107 */       Esmeraldameta.setDisplayName("§6§lCaixa: §a§lEsmeralda");
/* 108 */       Esmeraldameta.setLore(Lore("§eGanhe tres kits aleatorio"));
/* 109 */       Esmeraldameta.setLore(Lore("§f"));
/* 110 */       if (p.hasPermission("caixa.esmeralda")) {
/* 111 */         Esmeraldameta.setLore(Lore("§aVocê tem essa caixa"));
/*     */       } else {
/* 113 */         Esmeraldameta.setLore(Lore("§cVocê não tem essa caixa"));
/*     */       }
/* 115 */       Esmeralda.setItemMeta(Esmeraldameta);
/*     */       
/* 117 */       for (int i = 0; i != 9; i++) {
/* 118 */         loja.setItem(i, vidro);
/*     */       }
/* 120 */       loja.setItem(0, Ferro);
/* 121 */       loja.setItem(4, Ouro);
/* 122 */       loja.setItem(8, Esmeralda);
/* 123 */       p.openInventory(loja);
/*     */     }
/*     */   }
/*     */   
/*     */   @org.bukkit.event.EventHandler
/*     */   public void Caixa(final InventoryClickEvent e)
/*     */   {
/* 130 */     if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
/* 131 */       final Player p = (Player)e.getWhoClicked();
/* 132 */       Inventory inv = e.getInventory();
/* 133 */       if (inv.getTitle().equalsIgnoreCase("§7§l§nCaixas"))
/*     */       {
/* 135 */         if (e.getCurrentItem().isSimilar(vidro)) {
/* 136 */           e.setCancelled(true);
/*     */         }
/*     */         
/* 139 */         if (e.getCurrentItem().isSimilar(vidro2)) {
/* 140 */           e.setCancelled(true);
/*     */         }
/*     */         
/* 143 */         if (e.getCurrentItem().isSimilar(comprarcaixa)) {
/* 144 */           p.closeInventory();
/* 145 */           e.setCancelled(true);
/* 146 */           p.chat("/comprarcaixa");
/* 147 */           p.playSound(p.getLocation(), org.bukkit.Sound.ANVIL_USE, 2.0F, 2.0F);
/* 148 */           p.updateInventory();
/*     */         }
/*     */         
/* 151 */         if (e.getCurrentItem().isSimilar(Ferro)) {
/* 152 */           p.closeInventory();
/* 153 */           if (!p.hasPermission("caixa.ferro")) {
/* 154 */             p.sendMessage("§c§lVocê não tem essa caixa");
/* 155 */             return;
/*     */           }
/* 157 */           final String kit = KitsAleatorios.Kit();
/* 158 */           Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove caixa.ferro");
/* 159 */           p.sendMessage("§7§l[§e§lCaixa§7§l] §7§lVocê abriu a caixa §f§lFerro§7§l, e seu Kit é: ");
/* 160 */           Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 164 */               p.sendMessage("§7§l[§e§lCaixa§7§l] §3§l" + kit);
/* 165 */               Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit." + kit);
/* 166 */               Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex reload");
/* 167 */               p.playSound(p.getLocation(), org.bukkit.Sound.FIREWORK_BLAST, 2.0F, 2.0F);
/* 168 */               p.getLocation().getWorld().spawnEntity(p.getLocation(), org.bukkit.entity.EntityType.FIREWORK);
/* 169 */               e.setCancelled(true);
/*     */             }
/* 171 */           }, 60L);
/*     */         }
/*     */         
/*     */ 
/* 175 */         if (e.getCurrentItem().isSimilar(Ouro)) {
/* 176 */           p.closeInventory();
/* 177 */           if (!p.hasPermission("caixa.ouro")) {
/* 178 */             p.sendMessage("§c§lVocê não tem essa caixa");
/* 179 */             return;
/*     */           }
/* 181 */           final String kit = KitsAleatorios.Kit();
/* 182 */           final String kit2 = KitsAleatorios.Kit();
/* 183 */           Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove caixa.ouro");
/* 184 */           p.sendMessage("§7§l[§e§lCaixa§7§l] §7§lVocê abriu a caixa §e§lOuro§7§l, e seu Kit é: ");
/* 185 */           Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 189 */               p.sendMessage("§7§l[§e§lCaixa§7§l] §3§l" + kit + " §7e §3§l" + kit2);
/* 190 */               Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit." + kit);
/* 191 */               Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit." + kit2);
/* 192 */               Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex reload");
/* 193 */               p.playSound(p.getLocation(), org.bukkit.Sound.FIREWORK_BLAST, 2.0F, 2.0F);
/* 194 */               p.getLocation().getWorld().spawnEntity(p.getLocation(), org.bukkit.entity.EntityType.FIREWORK);
/* 195 */               e.setCancelled(true);
/*     */             }
/* 197 */           }, 60L);
/*     */         }
/*     */         
/*     */ 
/* 201 */         if (e.getCurrentItem().isSimilar(Esmeralda)) {
/* 202 */           p.closeInventory();
/* 203 */           if (!p.hasPermission("caixa.esmeralda")) {
/* 204 */             p.sendMessage("§c§lVocê não tem essa caixa");
/* 205 */             return;
/*     */           }
/* 207 */           final String kit = KitsAleatorios.Kit();
/* 208 */           final String kit2 = KitsAleatorios.Kit();
/* 209 */           final String kit3 = KitsAleatorios.Kit();
/* 210 */           Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove caixa.esmeralda");
/* 211 */           p.sendMessage("§7§l[§e§lCaixa§7§l] §7§lVocê abriu a caixa §e§lEsmeralda§7§l, e seu Kit é: ");
/* 212 */           Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 216 */               p.sendMessage("§7§l[§e§lCaixa§7§l] §3§l" + kit + " §7, §3§l" + kit2 + " §7e §3§l" + kit3);
/* 217 */               Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit." + kit);
/* 218 */               Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit." + kit2);
/* 219 */               Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit." + kit3);
/* 220 */               Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex reload");
/* 221 */               p.playSound(p.getLocation(), org.bukkit.Sound.FIREWORK_BLAST, 2.0F, 2.0F);
/* 222 */               p.getLocation().getWorld().spawnEntity(p.getLocation(), org.bukkit.entity.EntityType.FIREWORK);
/* 223 */               e.setCancelled(true);
/*     */             }
/* 225 */           }, 60L);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args)
/*     */   {
/* 235 */     if (!(sender instanceof Player)) {
/* 236 */       sender.sendMessage("§7[§cErro§7] §cApenas jogadores podem executar esse comando");
/* 237 */       return true;
/*     */     }
/* 239 */     Player p = (Player)sender;
/* 240 */     if (br.nikao.outros.KitAPI.getkit(p) != "Nenhum") {
/* 241 */       p.sendMessage("§cNão foi possivel abrir suas caixas pois você está com um Kit.");
/* 242 */       return true;
/*     */     }
/* 244 */     Inventory loja = Bukkit.createInventory(p, 9, "§7§l§nCaixas");
/*     */     
/* 246 */     vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)11);
/* 247 */     vidrometa = vidro.getItemMeta();
/* 248 */     vidrometa.setDisplayName(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§"));
/* 249 */     vidro.setItemMeta(vidrometa);
/*     */     
/* 251 */     comprarcaixa = new ItemStack(Material.CHEST);
/* 252 */     comprarcaixameta = comprarcaixa.getItemMeta();
/* 253 */     comprarcaixameta.setDisplayName("§a§lComprar Caixa");
/* 254 */     comprarcaixa.setItemMeta(comprarcaixameta);
/*     */     
/* 256 */     Ferro = new ItemStack(Material.IRON_BLOCK, 1);
/* 257 */     Ferrometa = Ferro.getItemMeta();
/* 258 */     Ferrometa.setDisplayName("§6§lCaixa: §7§lFerro");
/* 259 */     Ferrometa.setLore(Lore("§eGanhe um kit aleatorio"));
/* 260 */     Ferrometa.setLore(Lore("§f"));
/* 261 */     if (p.hasPermission("caixa.ferro")) {
/* 262 */       Ferrometa.setLore(Lore("§aVocê tem essa caixa"));
/*     */     } else {
/* 264 */       Ferrometa.setLore(Lore("§cVocê não tem essa caixa"));
/*     */     }
/* 266 */     Ferro.setItemMeta(Ferrometa);
/*     */     
/* 268 */     Ouro = new ItemStack(Material.GOLD_BLOCK, 1);
/* 269 */     Ourometa = Ouro.getItemMeta();
/* 270 */     Ourometa.setDisplayName("§6§lCaixa: §e§lOuro");
/* 271 */     Ourometa.setLore(Lore("§eGanhe dois kits aleatorio"));
/* 272 */     Ourometa.setLore(Lore("§f"));
/* 273 */     if (p.hasPermission("caixa.ouro")) {
/* 274 */       Ourometa.setLore(Lore("§aVocê tem essa caixa"));
/*     */     } else {
/* 276 */       Ourometa.setLore(Lore("§cVocê não tem essa caixa"));
/*     */     }
/* 278 */     Ouro.setItemMeta(Ourometa);
/*     */     
/* 280 */     Esmeralda = new ItemStack(Material.EMERALD_BLOCK, 1);
/* 281 */     Esmeraldameta = Esmeralda.getItemMeta();
/* 282 */     Esmeraldameta.setDisplayName("§6§lCaixa: §a§lEsmeralda");
/* 283 */     Esmeraldameta.setLore(Lore("§eGanhe tres kits aleatorio"));
/* 284 */     Esmeraldameta.setLore(Lore("§f"));
/* 285 */     if (p.hasPermission("caixa.esmeralda")) {
/* 286 */       Esmeraldameta.setLore(Lore("§aVocê tem essa caixa"));
/*     */     } else {
/* 288 */       Esmeraldameta.setLore(Lore("§cVocê não tem essa caixa"));
/*     */     }
/* 290 */     Esmeralda.setItemMeta(Esmeraldameta);
/*     */     
/* 292 */     for (int i = 0; i != 9; i++) {
/* 293 */       loja.setItem(i, vidro);
/*     */     }
/* 295 */     loja.setItem(0, Ferro);
/* 296 */     loja.setItem(4, Ouro);
/* 297 */     loja.setItem(8, Esmeralda);
/* 298 */     p.openInventory(loja);
/* 299 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\gui\Caixas.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */