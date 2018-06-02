/*     */ package br.nikao.gui;
/*     */ 
/*     */ import br.nikao.Main;
/*     */ import br.nikao.comandos.Score;
/*     */ import br.nikao.outros.Scoreboards;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.entity.EntityType;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ public class ComprarCaixa implements org.bukkit.event.Listener, org.bukkit.command.CommandExecutor
/*     */ {
/*     */   public static ItemStack vidro2;
/*     */   public static ItemMeta vidro2meta;
/*     */   public static ItemStack Ferro;
/*     */   public static ItemMeta Ferrometa;
/*     */   public static ItemStack Ouro;
/*     */   public static ItemMeta Ourometa;
/*     */   public static ItemStack Esmeralda;
/*     */   public static ItemMeta Esmeraldameta;
/*     */   
/*     */   public static java.util.List<String> Lore(String string)
/*     */   {
/*  33 */     String[] split = string.split(" ");
/*  34 */     string = "";
/*  35 */     org.bukkit.ChatColor color = org.bukkit.ChatColor.GOLD;
/*     */     
/*  37 */     ArrayList<String> newString = new ArrayList();
/*  38 */     for (int i = 0; i < split.length; i++) {
/*  39 */       if ((string.length() > 20) || (string.endsWith("."))) {
/*  40 */         newString.add(color + string);
/*  41 */         if (string.endsWith(".")) {
/*  42 */           newString.add("");
/*     */         }
/*  44 */         string = "";
/*     */       }
/*  46 */       string = string + (string.length() == 0 ? "" : " ") + split[i];
/*     */     }
/*  48 */     newString.add(string);
/*  49 */     return newString;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @org.bukkit.event.EventHandler
/*     */   public void Caixa(InventoryClickEvent e)
/*     */     throws java.sql.SQLException
/*     */   {
/*  63 */     if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
/*  64 */       Player p = (Player)e.getWhoClicked();
/*  65 */       Inventory inv = e.getInventory();
/*  66 */       int value = ((Integer)Main.XP.get(p.getName())).intValue();
/*  67 */       if (inv.getTitle().equalsIgnoreCase("§7§l§nLoja de Caixas"))
/*     */       {
/*  69 */         if (e.getCurrentItem().isSimilar(vidro2)) {
/*  70 */           e.setCancelled(true);
/*     */         }
/*     */         
/*  73 */         if (e.getCurrentItem().isSimilar(Ferro)) {
/*  74 */           p.closeInventory();
/*  75 */           if (p.hasPermission("caixa.ferro")) {
/*  76 */             if (value >= 10000) {
/*  77 */               Main.XP.put(p.getName(), Integer.valueOf(value - 10000));
/*  78 */               p.sendMessage("§7§lVocê comprou a caixa de §f§lFerro§a§l§7§l, Boa Sorte");
/*  79 */               p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 2.0F, 2.0F);
/*  80 */               p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
/*  81 */               p.closeInventory();
/*  82 */               if (Score.score.contains(p.getName())) {
/*  83 */                 return;
/*     */               }
/*  85 */               Scoreboards.Scores(p);
/*     */               
/*  87 */               Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add caixa.ferro");
/*  88 */             } else if (value < 10000) {
/*  89 */               p.sendMessage("§cVocê não tem 10000 XP para comprar essa Caixa");
/*  90 */               p.closeInventory();
/*     */             }
/*     */           }
/*     */           else {
/*  94 */             p.sendMessage("§cVocê ja possui está caixa");
/*  95 */             p.closeInventory();
/*  96 */             return;
/*     */           }
/*  98 */           e.setCancelled(true);
/*     */         }
/*     */         
/* 101 */         if (e.getCurrentItem().isSimilar(Ouro)) {
/* 102 */           p.closeInventory();
/* 103 */           if (p.hasPermission("caixa.ouro")) {
/* 104 */             if (value >= 20000) {
/* 105 */               Main.XP.put(p.getName(), Integer.valueOf(value - 20000));
/* 106 */               p.sendMessage("§7§lVocê comprou a caixa de §e§lOuro§a§l§7§l, Boa Sorte");
/* 107 */               p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 2.0F, 2.0F);
/* 108 */               p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
/* 109 */               p.closeInventory();
/* 110 */               if (Score.score.contains(p.getName())) {
/* 111 */                 return;
/*     */               }
/* 113 */               Scoreboards.Scores(p);
/*     */               
/* 115 */               Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add caixa.ouro");
/* 116 */             } else if (value < 20000) {
/* 117 */               p.sendMessage("§cVocê não tem 20000 XP para comprar essa Caixa");
/* 118 */               p.closeInventory();
/*     */             }
/*     */           }
/*     */           else {
/* 122 */             p.sendMessage("§cVocê ja possui está caixa");
/* 123 */             p.closeInventory();
/* 124 */             return;
/*     */           }
/* 126 */           e.setCancelled(true);
/*     */         }
/*     */         
/*     */ 
/* 130 */         if (e.getCurrentItem().isSimilar(Esmeralda)) {
/* 131 */           p.closeInventory();
/* 132 */           if (p.hasPermission("caixa.esmeralda")) {
/* 133 */             if (value >= 30000) {
/* 134 */               Main.XP.put(p.getName(), Integer.valueOf(value - 30000));
/* 135 */               p.sendMessage("§7§lVocê comprou a caixa de §a§lEsmeralda§a§l§7§l, Boa Sorte");
/* 136 */               p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 2.0F, 2.0F);
/* 137 */               p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
/* 138 */               p.closeInventory();
/* 139 */               if (Score.score.contains(p.getName())) {
/* 140 */                 return;
/*     */               }
/* 142 */               Scoreboards.Scores(p);
/*     */               
/* 144 */               Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add caixa.esmeralda");
/* 145 */             } else if (value < 30000) {
/* 146 */               p.sendMessage("§cVocê não tem 30000 XP para comprar essa Caixa");
/* 147 */               p.closeInventory();
/*     */             }
/*     */           }
/*     */           else {
/* 151 */             p.sendMessage("§cVocê ja possui está caixa");
/* 152 */             p.closeInventory();
/* 153 */             return;
/*     */           }
/* 155 */           e.setCancelled(true);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
/* 162 */     if (!(sender instanceof Player)) {
/* 163 */       sender.sendMessage("§7[§cErro§7] §cApenas jogadores podem executar esse comando");
/* 164 */       return true;
/*     */     }
/* 166 */     Player p = (Player)sender;
/* 167 */     if (br.nikao.outros.KitAPI.getkit(p) != "Nenhum") {
/* 168 */       p.sendMessage("§cNão foi possivel abrir a loja de caixas pois você está com um Kit.");
/* 169 */       return true;
/*     */     }
/* 171 */     Inventory loja = Bukkit.createInventory(p, 9, "§7§l§nLoja de Caixas");
/*     */     
/* 173 */     vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)11);
/* 174 */     vidro2meta = vidro2.getItemMeta();
/* 175 */     vidro2meta.setDisplayName(Main.getInstance().getConfig().getString("NomeDoServidor").replace("&", "§"));
/* 176 */     vidro2.setItemMeta(vidro2meta);
/*     */     
/* 178 */     Ferro = new ItemStack(Material.IRON_BLOCK, 1);
/* 179 */     Ferrometa = Ferro.getItemMeta();
/* 180 */     Ferrometa.setDisplayName("§6§lCaixa: §f§lFerro");
/* 181 */     Ferrometa.setLore(Lore("§7§lXP: §f10.000"));
/* 182 */     Ferro.setItemMeta(Ferrometa);
/*     */     
/* 184 */     Ouro = new ItemStack(Material.GOLD_BLOCK, 1);
/* 185 */     Ourometa = Ouro.getItemMeta();
/* 186 */     Ourometa.setDisplayName("§6§lCaixa: §e§lOuro");
/* 187 */     Ourometa.setLore(Lore("§7§lXP: §f20.000"));
/* 188 */     Ouro.setItemMeta(Ourometa);
/*     */     
/* 190 */     Esmeralda = new ItemStack(Material.EMERALD_BLOCK, 1);
/* 191 */     Esmeraldameta = Esmeralda.getItemMeta();
/* 192 */     Esmeraldameta.setDisplayName("§6§lCaixa: §a§lEsmeralda");
/* 193 */     Esmeraldameta.setLore(Lore("§7§lXP: §f30.000"));
/* 194 */     Esmeralda.setItemMeta(Esmeraldameta);
/*     */     
/* 196 */     for (int i = 0; i != 9; i++) {
/* 197 */       loja.setItem(i, vidro2);
/*     */     }
/* 199 */     loja.setItem(0, Ferro);
/* 200 */     loja.setItem(4, Ouro);
/* 201 */     loja.setItem(8, Esmeralda);
/* 202 */     p.openInventory(loja);
/* 203 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\gui\ComprarCaixa.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */