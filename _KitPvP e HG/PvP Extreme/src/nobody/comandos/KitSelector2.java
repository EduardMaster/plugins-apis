/*     */ package nobody.comandos;
/*     */ 
/*     */ import nobody.eventos.KitAPI;
import nobody.main.Main;

import org.bukkit.Material;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ public class KitSelector2 implements org.bukkit.event.Listener, org.bukkit.command.CommandExecutor
/*     */ {
/*     */   public static ItemStack vidro;
/*     */   public static ItemMeta vidrometa;
/*     */   public static ItemStack vidro1;
/*     */   public static ItemMeta verm1meta;
/*     */   public static ItemStack verm1;
/*     */   public static ItemMeta vidro1meta;
/*     */   public static ItemStack escada;
/*     */   public static ItemMeta escadameta;
/*     */   public static ItemStack barbarian;
/*     */   public static ItemMeta barbarianmeta;
/*     */   public static ItemStack backpacker;
/*     */   public static ItemMeta backpackermeta;
/*     */   public static ItemStack phantom;
/*     */   public static ItemMeta phantommeta;
/*     */   public static ItemStack avatar;

/*     */   public static ItemStack sonic;
/*     */   public static ItemMeta sonicmeta;
/*     */   public static ItemStack critical;
/*     */   public static ItemMeta criticalmeta;
/*     */   public static ItemStack thor;
/*     */   public static ItemStack deshfire;
/*     */   public static ItemMeta deshfiremeta;
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
/*     */   
/*     */   public static java.util.List<String> Lore(String string)
/*     */   {
/*  30 */     String[] split = string.split(" ");
/*  31 */     string = "";
/*  32 */     org.bukkit.ChatColor color = org.bukkit.ChatColor.GOLD;
/*     */     
/*  34 */     @SuppressWarnings({ "unchecked", "rawtypes" })
java.util.ArrayList<String> newString = new java.util.ArrayList();
/*  35 */     for (int i = 0; i < split.length; i++)
/*     */     {
/*  37 */       if ((string.length() > 20) || (string.endsWith(".")))
/*     */       {
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
/*     */   public static ItemMeta avatarmeta;
/*     */   
/*     */   public static ItemStack rain;
/*     */   
/*     */   public static ItemMeta rainmeta;
/*     */   
/*     */   public static ItemStack monk;
/*     */   
/*     */   public static ItemMeta monkmeta;
/*     */   
/*     */   public static ItemStack kits;
/*     */   
/*     */   public static ItemMeta kitsmeta;
/*     */   
/*     */   public static ItemStack vinha1;
/*     */   
/*     */   public static ItemMeta vinha1meta;
/*     */   
/*     */   public static ItemStack grade;
/*     */   
/*     */   public static ItemMeta grademeta;
/*     */   
/*     */   public static ItemStack fogo;
/*     */   
/*     */   public static ItemMeta fogometa;
/*     */   @org.bukkit.event.EventHandler
/*     */   public void Clicar(PlayerInteractEvent e)
/*     */   {
/*  80 */     Player p = e.getPlayer();
/*  81 */     if ((e.getMaterial() == Material.CARPET) && (e.getItem().getType() == Material.CARPET) && (KitAPI.getkit(p) == "Nenhum")) {
/*  82 */       p.chat("/kits2");
/*     */     }
/*     */   }
/*     */   
/*     */   @org.bukkit.event.EventHandler
/*     */   public void PvP(InventoryClickEvent e) {
/*  88 */     if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
/*  89 */       Player p = (Player)e.getWhoClicked();
/*  90 */       Inventory inv = e.getInventory();
/*  91 */       if (inv.getTitle().equalsIgnoreCase("§e§nMais Kits")) {
/*  92 */         if (e.getCurrentItem().isSimilar(vidro)) {
/*  93 */           e.setCancelled(true);
/*     */         }
/*  95 */         if (e.getCurrentItem().isSimilar(barbarian)) {
/*  96 */           e.setCancelled(true);
/*  97 */           p.closeInventory();
/*  98 */           p.chat("/kit barbarian");
/*     */         }
/* 100 */         if (e.getCurrentItem().isSimilar(kits)) {
/* 101 */           e.setCancelled(true);
/* 102 */           p.closeInventory();
/* 103 */           p.playSound(p.getLocation(), org.bukkit.Sound.ANVIL_USE, 2.0F, 2.0F);
/* 104 */           p.chat("/kits");
/*     */         }
/* 106 */         if (e.getCurrentItem().isSimilar(backpacker)) {
/* 107 */           e.setCancelled(true);
/* 108 */           p.closeInventory();
/* 109 */           p.chat("/kit backpacker");
/*     */         }
/* 111 */         if (e.getCurrentItem().isSimilar(phantom)) {
/* 112 */           e.setCancelled(true);
/* 113 */           p.closeInventory();
/* 114 */           p.chat("/kit phantom");
/*     */         }
/* 116 */         if (e.getCurrentItem().isSimilar(avatar)) {
/* 117 */           e.setCancelled(true);
/* 118 */           p.closeInventory();
/* 119 */           p.chat("/kit avatar");
/*     */         }
/* 121 */         if (e.getCurrentItem().isSimilar(rain)) {
/* 122 */           e.setCancelled(true);
/* 123 */           p.closeInventory();
/* 124 */           p.chat("/kit rain");
/*     */         }
/* 126 */         if (e.getCurrentItem().isSimilar(monk)) {
/* 127 */           e.setCancelled(true);
/* 128 */           p.closeInventory();
/* 129 */           p.chat("/kit monk");
/*     */         }
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
/* 427 */         if (e.getCurrentItem().isSimilar(quickdropper)) {
/* 428 */           e.setCancelled(true);
/* 429 */           p.closeInventory();
/* 430 */           p.playSound(p.getLocation(), org.bukkit.Sound.ANVIL_USE, 2.0F, 2.0F);
/* 431 */           p.chat("/kit quickdropper");
/*     */         }
/* 421 */         if (e.getCurrentItem().isSimilar(deshfire)) {
/* 422 */           e.setCancelled(true);
/* 423 */           p.closeInventory();
/* 425 */           p.chat("/kit deshfire");
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args)
/*     */   {
/* 137 */     if (!(sender instanceof Player)) {
/* 138 */       sender.sendMessage("§7[§cErro§7] §cApenas jogadores podem usar isso");
/* 139 */       return true;
/*     */     }
/* 141 */     Player p = (Player)sender;
/* 142 */     Inventory kit = org.bukkit.Bukkit.createInventory(p, 54, "§e§nMais Kits");
/*     */     
/*     */     
/*     */     
/* 154 */     vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)3);
/* 155 */     vidrometa = vidro.getItemMeta();
/* 156 */     vidrometa.setDisplayName("§eExtreme§7Kits");
/* 157 */     vidro.setItemMeta(vidrometa);
/*     */     
/* 159 */     vidro1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
/* 160 */     vidro1meta = vidro1.getItemMeta();
/* 161 */     vidro1meta.setDisplayName("§7-");
/* 162 */     vidro1.setItemMeta(vidro1meta);

/* 159 */     verm1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
/* 160 */     verm1meta = verm1.getItemMeta();
/* 161 */     verm1meta.setDisplayName("§7-");
/* 162 */     verm1.setItemMeta(verm1meta);
/*     */     
/* 164 */     fogo = new ItemStack(Material.FIRE, 1);
/* 165 */     fogometa = fogo.getItemMeta();
/* 166 */     fogometa.setDisplayName("§a§lGUI de Kits");
/* 167 */     fogo.setItemMeta(fogometa);
/*     */     
/* 169 */     escada = new ItemStack(Material.LADDER, 1);
/* 170 */     escadameta = escada.getItemMeta();
/* 171 */     escadameta.setDisplayName("§7-");
/* 172 */     escada.setItemMeta(escadameta);
/*     */     
/* 174 */     barbarian = new ItemStack(Material.WOOD_SWORD, 1);
/* 175 */     barbarianmeta = barbarian.getItemMeta();
/* 176 */     barbarianmeta.setDisplayName("§eBarbarian");
/* 177 */     barbarianmeta.setLore(Lore("§7Esse §7kit §7voce §7evolui §7a §7espada §7matando §7jogadores"));
/* 178 */     barbarian.setItemMeta(barbarianmeta);
/*     */     
/* 180 */     kits = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)5);
/* 181 */     kitsmeta = kits.getItemMeta();
/* 182 */     kitsmeta.setDisplayName("§cRetroceder");
/* 183 */     kits.setItemMeta(kitsmeta);
/*     */     
/* 185 */     backpacker = new ItemStack(Material.CHEST, 1);
/* 186 */     backpackermeta = backpacker.getItemMeta();
/* 187 */     backpackermeta.setDisplayName("§eBackpacker");
/* 188 */     backpackermeta.setLore(Lore("§7Tenha §7sempre §7um §7inventario §7cheio §7de §7sopas"));
/* 189 */     backpacker.setItemMeta(backpackermeta);
/*     */     
/* 191 */     phantom = new ItemStack(Material.FEATHER, 1);
/* 192 */     phantommeta = phantom.getItemMeta();
/* 193 */     phantommeta.setDisplayName("§ePhantom");
/* 194 */     phantommeta.setLore(Lore("§7Veja §7como §7ser §7uma §7galinha §7depenada"));
/* 195 */     phantom.setItemMeta(phantommeta);
/*     */     
/* 197 */     avatar = new ItemStack(Material.WOOL, 1);
/* 198 */     avatarmeta = avatar.getItemMeta();
/* 199 */     avatarmeta.setDisplayName("§eAvatar");
/* 200 */     avatarmeta.setLore(Lore("§7Veja §7como §7ser §7o §7avatar §7e §7jogue §7poderes §bAgua §cFogo §7§lAR e §6Terra"));
/* 201 */     avatar.setItemMeta(avatarmeta);
/*     */     
/* 203 */     rain = new ItemStack(Material.ARROW, 1);
/* 204 */     rainmeta = rain.getItemMeta();
/* 205 */     rainmeta.setDisplayName("§eRain");
/* 206 */     rainmeta.setLore(Lore("§7Nao §7deixe §7seu §7inimigo §7fugir §7lançe §7uma §7chuvarada §7de §7flechas §7e §7o §7mate"));
/* 207 */     rain.setItemMeta(rainmeta);
/*     */     
/* 209 */     monk = new ItemStack(Material.BLAZE_ROD, 1);
/* 210 */     monkmeta = monk.getItemMeta();
/* 211 */     monkmeta.setDisplayName("§eMonk");
/* 212 */     monkmeta.setLore(Lore("§7Confunda §7o §7inventario §7de §7seu §7inimigo"));
/* 213 */     monk.setItemMeta(monkmeta);

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

/* 692 */     deshfire = new ItemStack(Material.REDSTONE_BLOCK);
/* 693 */     deshfiremeta = deshfire.getItemMeta();
/* 694 */     deshfiremeta.setDisplayName("§eDeshfire");
/* 695 */     deshfiremeta.setLore(Lore("§7Taque §7fogo §7em §7seu §7inimigo §7clicando §7com §7o §7botão §7direito §7em §7cima §7do §7bloco §7de §7Redstone "));
/* 696 */     deshfire.setItemMeta(deshfiremeta);
/*     */     
/*     */ 
/* 216 */     for (int i = 0; i != 54; i++) {
/* 217 */       kit.setItem(i, vidro);
/*     */     }
/* 219 */     kit.setItem(0, kits);
/* 220 */     kit.setItem(1, vidro1);
/* 221 */     kit.setItem(2, vidro1);
/* 222 */     kit.setItem(3, vidro1);
/* 223 */     kit.setItem(4, fogo);
/* 224 */     kit.setItem(5, vidro1);
/* 225 */     kit.setItem(6, vidro1);
/* 226 */     kit.setItem(7, vidro1);
/* 227 */     kit.setItem(8, verm1);
/*     */     
/* 229 */     if (p.hasPermission("kit.barbarian")) {
/* 230 */       kit.removeItem(new ItemStack[] { vidro });
/* 231 */       kit.addItem(new ItemStack[] { barbarian });
/*     */     }
/*     */     
/* 234 */     if (p.hasPermission("kit.backpacker")) {
/* 235 */       kit.removeItem(new ItemStack[] { vidro });
/* 236 */       kit.addItem(new ItemStack[] { backpacker });
/*     */     }
/*     */     
/* 239 */     if (p.hasPermission("kit.phantom")) {
/* 240 */       kit.removeItem(new ItemStack[] { vidro });
/* 241 */       kit.addItem(new ItemStack[] { phantom });
/*     */     }
/*     */     
/* 244 */     if ((Main.getInstance().loja.getString(p.getName().toLowerCase() + ".Avatar").equals("true")) || (p.hasPermission("kit.avatar"))) {
/* 245 */       kit.removeItem(new ItemStack[] { vidro });
/* 246 */       kit.addItem(new ItemStack[] { avatar });
/*     */     }
/*     */     
/* 249 */     if ((Main.getInstance().loja.getString(p.getName().toLowerCase() + ".Rain").equals("true")) || (p.hasPermission("kit.rain"))) {
/* 250 */       kit.removeItem(new ItemStack[] { vidro });
/* 251 */       kit.addItem(new ItemStack[] { rain });
/*     */     }
/*     */     
/* 254 */     if (p.hasPermission("kit.monk")) {
/* 255 */       kit.removeItem(new ItemStack[] { vidro });
/* 256 */       kit.addItem(new ItemStack[] { monk });
/*     */     }
/* 912 */     if (p.hasPermission("kit.sonic")) {
/* 913 */       kit.removeItem(new ItemStack[] { vidro });
/* 914 */       kit.addItem(new ItemStack[] { sonic });
/*     */     }
/* 916 */     if (p.hasPermission("kit.critical")) {
/* 917 */       kit.removeItem(new ItemStack[] { vidro });
/* 918 */       kit.addItem(new ItemStack[] { critical });
/*     */     }
/* 920 */     if (p.hasPermission("kit.thor")) {
/* 921 */       kit.removeItem(new ItemStack[] { vidro });
/* 922 */       kit.addItem(new ItemStack[] { thor });
/*     */     }
/* 924 */     if (p.hasPermission("kit.boxer")) {
/* 925 */       kit.removeItem(new ItemStack[] { vidro });
/* 926 */       kit.addItem(new ItemStack[] { boxer });
/*     */     }
/* 928 */     if (p.hasPermission("kit.ebola")) {
/* 929 */       kit.removeItem(new ItemStack[] { vidro });
/* 930 */       kit.addItem(new ItemStack[] { ebola });
/*     */     }
/* 932 */     if ((Main.getInstance().loja.getString(p.getName().toLowerCase() + ".ForceField").equals("true")) || (p.hasPermission("kit.forcefield"))) {
/* 933 */       kit.removeItem(new ItemStack[] { vidro });
/* 934 */       kit.addItem(new ItemStack[] { ff });
/*     */     }
/* 936 */     if (p.hasPermission("kit.timelord")) {
/* 937 */       kit.removeItem(new ItemStack[] { vidro });
/* 938 */       kit.addItem(new ItemStack[] { timelord });
/*     */     }
/* 940 */     if (p.hasPermission("kit.quickdropper")) {
/* 941 */       kit.removeItem(new ItemStack[] { vidro });
/* 942 */       kit.addItem(new ItemStack[] { quickdropper });
/*     */     }
				if (p.hasPermission("kit.deshfire")) {
/* 909 */       kit.removeItem(new ItemStack[] { vidro });
/* 910 */       kit.addItem(new ItemStack[] { deshfire });
/*     */     }
/*     */     
/* 259 */     p.openInventory(kit);
/* 260 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Gui\KitSelector2.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */