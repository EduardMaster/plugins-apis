/*     */ package br.nikao.gui;
/*     */ 
/*     */ import br.nikao.Main;
/*     */ import br.nikao.minigames.VoidChallenge;
/*     */ import br.nikao.outros.KitAPI;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class Warps implements org.bukkit.command.CommandExecutor, org.bukkit.event.Listener
/*     */ {
/*     */   public static ItemStack vidro;
/*     */   public static ItemMeta vidrometa;
/*     */   public static ItemStack Eventos;
/*     */   public static ItemMeta Eventosmeta;
/*     */   public static ItemStack Minigames;
/*     */   public static ItemMeta Minigamesmeta;
/*     */   public static ItemStack vc;
/*     */   public static ItemMeta vcmeta;
/*     */   public static ItemStack ct;
/*     */   public static ItemMeta ctmeta;
/*     */   public static ItemStack fps;
/*     */   public static ItemMeta fpsmeta;
/*     */   public static ItemStack challenge;
/*     */   public static ItemMeta challengemeta;
/*     */   public static ItemStack rdm;
/*     */   public static ItemMeta rdmmeta;
/*     */   public static ItemStack mdr;
/*     */   public static ItemMeta mdrmeta;
/*     */   public static ItemStack k1v1;
/*     */   public static ItemMeta k1v1meta;
/*     */   public static ItemStack voltar;
/*     */   public static ItemMeta voltarmeta;
/*     */   
/*     */   @EventHandler
/*     */   public void Clicar(PlayerInteractEvent e)
/*     */   {
/*  50 */     Player p = e.getPlayer();
/*  51 */     if ((e.getMaterial() == Material.PAPER) && (e.getItem().getType() == Material.PAPER) && (KitAPI.getkit(p) == "Nenhum")) {
/*  52 */       p.playSound(p.getLocation(), Sound.CLICK, 2.0F, 2.0F);
/*  53 */       p.chat("/warps");
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void Warp(InventoryClickEvent e) {
/*  59 */     if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
/*  60 */       Player p = (Player)e.getWhoClicked();
/*  61 */       Inventory inv = e.getInventory();
/*  62 */       if (inv.getTitle().equalsIgnoreCase("§6§l§nWarps")) {
/*  63 */         if (e.getCurrentItem().isSimilar(vidro)) {
/*  64 */           e.setCancelled(true);
/*     */         }
/*     */         
/*  67 */         if (e.getCurrentItem().isSimilar(fps)) {
/*  68 */           p.chat("/fps");
/*  69 */           e.setCancelled(true);
/*  70 */           p.closeInventory();
/*     */         }
/*     */         
/*  73 */         if (e.getCurrentItem().isSimilar(challenge)) {
/*  74 */           p.chat("/challenge");
/*  75 */           e.setCancelled(true);
/*  76 */           p.closeInventory();
/*     */         }
/*     */         
/*  79 */         if (e.getCurrentItem().isSimilar(k1v1)) {
/*  80 */           p.chat("/1v1");
/*  81 */           e.setCancelled(true);
/*  82 */           p.closeInventory();
/*     */         }
/*     */         
/*  85 */         if (e.getCurrentItem().isSimilar(Eventos)) {
/*  86 */           e.setCancelled(true);
/*  87 */           p.closeInventory();
/*  88 */           Inventory eventos = Bukkit.createInventory(p, 9, "§1§l§nEventos");
/*     */           
/*  90 */           vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
/*  91 */           vidrometa = vidro.getItemMeta();
/*  92 */           vidrometa.setDisplayName(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§"));
/*  93 */           vidro.setItemMeta(vidrometa);
/*     */           
/*  95 */           rdm = new ItemStack(Material.WOOL);
/*  96 */           rdmmeta = rdm.getItemMeta();
/*  97 */           rdmmeta.setDisplayName("§8§l§nRDM (Rei da Mesa)");
/*  98 */           rdm.setItemMeta(rdmmeta);
/*     */           
/* 100 */           mdr = new ItemStack(Material.WOOL, 1, (short)15);
/* 101 */           mdrmeta = mdr.getItemMeta();
/* 102 */           mdrmeta.setDisplayName("§8§l§nMDR (Mãe da rua)");
/* 103 */           mdr.setItemMeta(mdrmeta);
/*     */           
/* 105 */           voltar = new ItemStack(Material.REDSTONE_TORCH_ON);
/* 106 */           voltarmeta = voltar.getItemMeta();
/* 107 */           voltarmeta.setDisplayName("§6§l<- §7§lVoltar para o menu");
/* 108 */           voltar.setItemMeta(voltarmeta);
/*     */           
/* 110 */           for (int i = 0; i != 9; i++) {
/* 111 */             eventos.setItem(i, vidro);
/*     */           }
/* 113 */           eventos.setItem(3, rdm);
/* 114 */           eventos.setItem(6, mdr);
/* 115 */           eventos.setItem(0, voltar);
/* 116 */           p.openInventory(eventos);
/*     */         }
/*     */         
/* 119 */         if (e.getCurrentItem().isSimilar(Minigames)) {
/* 120 */           e.setCancelled(true);
/* 121 */           p.closeInventory();
/* 122 */           Inventory minigames = Bukkit.createInventory(p, 9, "§3§l§nMini-games");
/*     */           
/* 124 */           vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
/* 125 */           vidrometa = vidro.getItemMeta();
/* 126 */           vidrometa.setDisplayName(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§"));
/* 127 */           vidro.setItemMeta(vidrometa);
/*     */           
/* 129 */           vc = new ItemStack(Material.BEDROCK);
/* 130 */           vcmeta = vc.getItemMeta();
/* 131 */           vcmeta.setDisplayName("§8§l§nVoid Challenge");
/* 132 */           vc.setItemMeta(vcmeta);
/*     */           
/* 134 */           ct = new ItemStack(Material.STONE_SWORD);
/* 135 */           ctmeta = ct.getItemMeta();
/* 136 */           ctmeta.setDisplayName("§8§l§nTeste de Click");
/* 137 */           ct.setItemMeta(ctmeta);
/*     */           
/* 139 */           voltar = new ItemStack(Material.REDSTONE_TORCH_ON);
/* 140 */           voltarmeta = voltar.getItemMeta();
/* 141 */           voltarmeta.setDisplayName("§6§l<- §7§lVoltar para o menu");
/* 142 */           voltar.setItemMeta(voltarmeta);
/*     */           
/* 144 */           for (int i = 0; i != 9; i++) {
/* 145 */             minigames.setItem(i, vidro);
/*     */           }
/* 147 */           minigames.setItem(3, ct);
/* 148 */           minigames.setItem(6, vc);
/* 149 */           minigames.setItem(0, voltar);
/* 150 */           p.openInventory(minigames);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void Minigames(InventoryClickEvent e)
/*     */   {
/* 159 */     if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
/* 160 */       final Player p = (Player)e.getWhoClicked();
/* 161 */       Inventory inv = e.getInventory();
/* 162 */       if (inv.getTitle().equalsIgnoreCase("§3§l§nMini-games")) {
/* 163 */         if (e.getCurrentItem().isSimilar(vidro)) {
/* 164 */           e.setCancelled(true);
/*     */         }
/*     */         
/* 167 */         if (e.getCurrentItem().isSimilar(voltar)) {
/* 168 */           e.setCancelled(true);
/* 169 */           p.closeInventory();
/* 170 */           p.chat("/warps");
/*     */         }
/*     */         
/* 173 */         if (e.getCurrentItem().isSimilar(ct)) {
/* 174 */           e.setCancelled(true);
/* 175 */           p.closeInventory();
/* 176 */           p.chat("/clicktest");
/*     */         }
/*     */         
/* 179 */         if (e.getCurrentItem().isSimilar(vc)) {
/* 180 */           e.setCancelled(true);
/* 181 */           VoidChallenge.voidchallenge.add(p.getName());
/* 182 */           p.closeInventory();
/* 183 */           Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 187 */               p.sendMessage("§7§lO Void Challenge irá iniciar em: §e5 segundos");
/* 188 */               p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0F, 2.0F);
/*     */             }
/*     */             
/* 191 */           }, 20L);
/*     */           
/* 193 */           Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 197 */               p.sendMessage("§7§lO Void Challenge irá iniciar em: §e4 segundos");
/* 198 */               p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0F, 2.0F);
/*     */             }
/*     */             
/* 201 */           }, 40L);
/*     */           
/* 203 */           Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 207 */               p.sendMessage("§7§lO Void Challenge irá iniciar em: §e3 segundos");
/* 208 */               p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0F, 2.0F);
/*     */             }
/*     */             
/* 211 */           }, 60L);
/*     */           
/* 213 */           Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 217 */               p.sendMessage("§7§lO Void Challenge irá iniciar em: §e2 segundos");
/* 218 */               p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0F, 2.0F);
/*     */             }
/*     */             
/* 221 */           }, 80L);
/*     */           
/* 223 */           Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 227 */               p.sendMessage("§7§lO Void Challenge irá iniciar em: §e1 segundo");
/* 228 */               p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0F, 2.0F);
/*     */             }
/* 230 */           }, 100L);
/*     */           
/* 232 */           Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 236 */               p.sendMessage("§7§lO Void Challenge iniciou!");
/* 237 */               p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 2.0F, 2.0F);
/* 238 */               p.teleport(new org.bukkit.Location(p.getWorld(), 0.0D, -5.0D, 0.0D));
/*     */             }
/*     */             
/* 241 */           }, 120L);
/* 242 */           KitAPI.setKit(p, "PvP");
/* 243 */           p.getInventory().clear();
/*     */           
/* 245 */           ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
/* 246 */           ItemMeta sopameta = sopa.getItemMeta();
/* 247 */           sopa.setItemMeta(sopameta);
/*     */           
/* 249 */           ItemStack cogu1 = new ItemStack(Material.BROWN_MUSHROOM, 64);
/* 250 */           ItemMeta cogu1meta = cogu1.getItemMeta();
/* 251 */           cogu1.setItemMeta(cogu1meta);
/*     */           
/* 253 */           ItemStack cogu2 = new ItemStack(Material.RED_MUSHROOM, 64);
/* 254 */           ItemMeta cogu2meta = cogu2.getItemMeta();
/* 255 */           cogu2.setItemMeta(cogu2meta);
/*     */           
/* 257 */           ItemStack pote = new ItemStack(Material.BOWL, 64);
/* 258 */           ItemMeta potemeta = pote.getItemMeta();
/* 259 */           pote.setItemMeta(potemeta);
/*     */           
/* 261 */           for (int i = 1; i < 35; i++) {
/* 262 */             p.getInventory().addItem(new ItemStack[] { sopa });
/* 263 */             p.getInventory().setItem(13, pote);
/* 264 */             p.getInventory().setItem(14, cogu1);
/* 265 */             p.getInventory().setItem(15, cogu2);
/* 266 */             p.updateInventory();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void Eventos(InventoryClickEvent e) {
/* 275 */     if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
/* 276 */       Player p = (Player)e.getWhoClicked();
/* 277 */       Inventory inv = e.getInventory();
/* 278 */       if (inv.getTitle().equalsIgnoreCase("§1§l§nEventos")) {
/* 279 */         if (e.getCurrentItem().isSimilar(vidro)) {
/* 280 */           e.setCancelled(true);
/*     */         }
/*     */         
/* 283 */         if (e.getCurrentItem().isSimilar(rdm)) {
/* 284 */           e.setCancelled(true);
/* 285 */           p.chat("/rdm");
/* 286 */           p.closeInventory();
/*     */         }
/*     */         
/* 289 */         if (e.getCurrentItem().isSimilar(mdr)) {
/* 290 */           e.setCancelled(true);
/* 291 */           p.chat("/mdr");
/* 292 */           p.closeInventory();
/*     */         }
/*     */         
/* 295 */         if (e.getCurrentItem().isSimilar(voltar)) {
/* 296 */           e.setCancelled(true);
/* 297 */           p.closeInventory();
/* 298 */           p.chat("/warps");
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/* 307 */     if (!(sender instanceof Player)) {
/* 308 */       sender.sendMessage("§7§l[§c§lErro§7§l] §7Apenas jogadores podem executar esse comando.");
/* 309 */       return true;
/*     */     }
/* 311 */     if (args.length == 0) {
/* 312 */       Player p = (Player)sender;
/* 313 */       Inventory warps = Bukkit.createInventory(p, 9, "§6§l§nWarps");
/*     */       
/* 315 */       vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
/* 316 */       vidrometa = vidro.getItemMeta();
/* 317 */       vidrometa.setDisplayName(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§"));
/* 318 */       vidro.setItemMeta(vidrometa);
/*     */       
/* 320 */       Eventos = new ItemStack(Material.WOOD_DOOR, 1);
/* 321 */       Eventosmeta = Eventos.getItemMeta();
/* 322 */       Eventosmeta.setDisplayName("§7§lEventos");
/* 323 */       Eventos.setItemMeta(Eventosmeta);
/*     */       
/* 325 */       Minigames = new ItemStack(Material.STORAGE_MINECART, 1);
/* 326 */       Minigamesmeta = Minigames.getItemMeta();
/* 327 */       Minigamesmeta.setDisplayName("§7§lMini-games");
/* 328 */       Minigames.setItemMeta(Minigamesmeta);
/*     */       
/* 330 */       fps = new ItemStack(Material.GLASS, 1);
/* 331 */       fpsmeta = fps.getItemMeta();
/* 332 */       fpsmeta.setDisplayName("§7§lWarp: §6§lFPS");
/* 333 */       fps.setItemMeta(fpsmeta);
/*     */       
/* 335 */       challenge = new ItemStack(Material.STATIONARY_LAVA, 1);
/* 336 */       challengemeta = challenge.getItemMeta();
/* 337 */       challengemeta.setDisplayName("§7§lWarp: §6§lLava Challenge");
/* 338 */       challenge.setItemMeta(challengemeta);
/*     */       
/* 340 */       k1v1 = new ItemStack(Material.BLAZE_ROD, 1);
/* 341 */       k1v1meta = k1v1.getItemMeta();
/* 342 */       k1v1meta.setDisplayName("§7§lWarp: §6§l1v1");
/* 343 */       k1v1.setItemMeta(k1v1meta);
/*     */       
/* 345 */       for (int i = 0; i != 9; i++) {
/* 346 */         warps.setItem(i, vidro);
/*     */       }
/* 348 */       warps.setItem(1, fps);
/* 349 */       warps.setItem(3, Eventos);
/* 350 */       warps.setItem(4, k1v1);
/* 351 */       warps.setItem(5, Minigames);
/* 352 */       warps.setItem(7, challenge);
/* 353 */       p.openInventory(warps);
/*     */     }
/* 355 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\gui\Warps.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */