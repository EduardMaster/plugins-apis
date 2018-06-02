/*     */ package neero.demon.comandos;
/*     */ 
/*     */ import neero.demon.eventos.Menus;
import neero.demon.utils.ItemManager;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ public class Warps implements CommandExecutor, org.bukkit.event.Listener
/*     */ {
/*  19 */   private static ItemManager im = new ItemManager();
/*     */   
/*     */   @EventHandler
/*     */   public void dontClick2(InventoryClickEvent e)
/*     */   {
/*  24 */     Player p = (Player)e.getWhoClicked();
/*  25 */     if (p.getOpenInventory().getTitle().equalsIgnoreCase("§b§lYoutuber §6ExtremePvP")) {
/*  26 */       e.setCancelled(true);
/*  27 */       p.updateInventory();
/*     */     }
/*     */   }
/*     */   
/*     */   public void guiYT(Player p)
/*     */   {
/*  33 */     ItemStack vidro = im.createItem(Material.getMaterial(102), "vidro", "-", new String[0], 1, (short)0);
/*  34 */     ItemStack pro = im.createItem(Material.getMaterial(35), "vidro", "§6§lPro", new String[] { "§aTer 700 Inscritos.", "§aFeedBack +100 Likes.", "§o§5Acesso a todos os kits." }, 1, (short)4);
/*  35 */     ItemStack youtuber = im.createItem(Material.getMaterial(35), "vidro", "§b§lYoutuber", new String[] { "§aTer 1000 Inscritos.", "§aFeedBack +150 Likes", "§aAcesso ao comando /fake.", "§o§5Acesso a todos os kits." }, 1, (short)3);
/*  36 */     ItemStack youtuberplus = im.createItem(Material.getMaterial(35), "vidro", "§3§l§oYoutuber+", new String[] { "§aTer 3000 Inscritos", "§aNao necessita a gravaçao , somente twittar.", "§aAcesso ao comando /fake.", "§aPode dar sugestoes para a aba Dica de Kits", "§o§5Acesso a todos os kits." }, 1, (short)9);
/*     */     
/*     */ 
/*  39 */     Inventory inv = Bukkit.createInventory(p, 9, "§b§lYoutuber §6ExtremePvP");
/*     */     
/*  41 */     inv.setItem(0, pro);
/*  42 */     inv.setItem(4, youtuber);
/*  43 */     inv.setItem(8, youtuberplus);
/*  44 */     for (int i = 0; i < inv.getSize(); i++) {
/*  45 */       if (inv.getItem(i) == null) {
/*  46 */         inv.setItem(i, vidro);
/*     */       }
/*     */     }
/*  49 */     p.openInventory(inv);
/*     */   }
/*     */   
/*     */   public void guiStats(Player p)
/*     */   {
/*  54 */     ItemStack vidro = im.createItem(Material.getMaterial(102), "vidro", "-", new String[0], 1, (short)0);

/*  55 */     ItemStack info = im.createItem(Material.getMaterial(399), "vidro", "§c§lInformaçoes do Servidor", new String[] { "§aJogadores Online: " + Bukkit.getServer().getOnlinePlayers().length }, 1, (short)0);
/*  55 */     ItemStack rank = im.createItem(Material.getMaterial(351), "vidro", "§aRanks", new String[0], 1, (short)10);
			  ItemStack stat = im.createItem(Material.SKULL_ITEM, "vidro", "§aStatus", new String[0], 1, (short)10);
/*     */     
/*  57 */     Inventory inv = Bukkit.createInventory(p, 27, "§bServidor §6ExtremePvP");
/*     */     
/*  59 */     inv.setItem(11, rank);
/*  60 */     inv.setItem(13, info);
/*  61 */     inv.setItem(15, stat);
/*  62 */     for (int i = 0; i < inv.getSize(); i++) {
/*  63 */       if (inv.getItem(i) == null) {
/*  64 */         inv.setItem(i, vidro);
/*     */       }
/*     */     }
/*  67 */     p.openInventory(inv);
/*     */   }
/*     */   
/*     */   public void guiWarps(Player p)
/*     */   {
/*  72 */     ItemStack vidro = new ItemStack(Material.THIN_GLASS);
/*  73 */     Inventory inv = Bukkit.createInventory(p, 27, "§bWarps §6ExtremePvP");
/*  74 */     ItemStack fps = im.createItem(Material.getMaterial(20), "fps", "§2FPS", new String[0], 1, (short)0);
/*  75 */     ItemStack challenge = im.createItem(Material.getMaterial(327), "challenge", "§2Challenge", new String[0], 1, (short)0);
/*  76 */     ItemStack rdm = im.createItem(Material.getMaterial(354), "rdm", "§2RDM", new String[0], 1, (short)0);
/*  77 */     ItemStack fulliron = im.createItem(Material.getMaterial(369), "1v1", "§21v1", new String[0], 1, (short)0);
/*  78 */     ItemStack mdr = im.createItem(Material.getMaterial(35), "mdr", "§2MDR", new String[0], 1, (short)0);
/*     */     
/*  80 */     inv.setItem(10, fps);
/*  81 */     inv.setItem(11, challenge);
/*  82 */     inv.setItem(12, rdm);
/*  83 */     inv.setItem(13, fulliron);
/*  84 */     inv.setItem(14, mdr);
/*     */     
/*     */ 
/*     */ 
/*  88 */     for (int i = 0; i < inv.getSize(); i++) {
/*  89 */       if (inv.getItem(i) == null) {
/*  90 */         inv.setItem(i, vidro);
/*     */       }
/*     */     }
/*  93 */     p.openInventory(inv);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void dontClick(InventoryClickEvent event) {
/*  98 */     Player p = (Player)event.getWhoClicked();
/*  99 */     if ((p.getOpenInventory().getTitle().equalsIgnoreCase("§bWarps §6ExtremePvP")) || (p.getOpenInventory().getTitle().equalsIgnoreCase("§bServidor §6ExtremePvP"))) {
/* 100 */       event.setCancelled(true);
/* 101 */       p.updateInventory();
/*     */       
/* 103 */       if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§2FPS"))
/*     */       {
/* 105 */         p.chat("/fps");
/* 106 */         p.closeInventory();
/*     */       }
/*     */       
/* 109 */       if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§2Challenge"))
/*     */       {
/* 111 */         p.chat("/challenge");
/* 112 */         p.closeInventory();
/*     */       }
/*     */       
/* 115 */       if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§2RDM"))
/*     */       {
/* 117 */         p.chat("/rdm");
/* 118 */         p.closeInventory();
/*     */       }
/*     */       
/* 121 */       if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§21v1"))
/*     */       {
/* 123 */         p.chat("/1v1");
/* 124 */         p.closeInventory();
/*     */       }
/*     */       if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§aRanks"))
/*     */       {
	
/* 123 */         Menus.guiKits(p);
/*     */       }

/*     */       if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§aStatus"))
/*     */       {
	
/* 123 */         Menus.guiStatus(p);
/*     */       }
/*     */       
/* 127 */       if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§2MDR"))
/*     */       {
/* 129 */         p.chat("/mdr");
/* 130 */         p.closeInventory();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
/*     */   {
/* 138 */     if (commandLabel.equalsIgnoreCase("warps")) {
/* 139 */       Player p = (Player)sender;
/*     */       
/* 141 */       guiWarps(p);
/* 142 */     } else if (commandLabel.equalsIgnoreCase("serverinfo")) {
/* 143 */       Player p = (Player)sender;
/*     */       
/* 145 */       guiStats(p);
/* 146 */     } else if (commandLabel.equalsIgnoreCase("youtuber")) {
/* 147 */       Player p = (Player)sender;
/* 148 */       guiYT(p);
/*     */     }
/*     */     
/* 151 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\commands\Warps.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */