/*     */ package br.nikao.comandos;
/*     */ 
/*     */ import br.nikao.Main;
/*     */ import br.nikao.outros.KitAPI;
/*     */ import java.net.InetAddress;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.GameMode;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Damageable;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class Admin implements org.bukkit.command.CommandExecutor, Listener
/*     */ {
/*  27 */   public static ArrayList<String> admin = new ArrayList();
/*  28 */   public static HashMap<String, ItemStack[]> saveinv = new HashMap();
/*  29 */   public static HashMap<String, ItemStack[]> savearmor = new HashMap();
/*     */   
/*     */ 
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  34 */     if (!(sender instanceof Player)) {
/*  35 */       sender.sendMessage("§f[§cErro§f] §cApenas jogadores podem usar isso");
/*  36 */       return true;
/*     */     }
/*  38 */     if (!sender.hasPermission("ng.admin")) {
/*  39 */       sender.sendMessage("§cSem Permissão.");
/*  40 */       return true;
/*     */     }
/*  42 */     Player p = (Player)sender;
/*  43 */     if (args.length == 0) { ItemMeta redstonemeta;
/*  44 */       ItemStack info; Object infometa; if (!admin.contains(p.getName())) {
/*  45 */         p.sendMessage("§7§lO seu modo admin está §aAtivado");
/*  46 */         Player[] arrayOfPlayer; int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player s = arrayOfPlayer[i];
/*  47 */           s.hidePlayer(p);
/*     */         }
/*  49 */         p.setGameMode(GameMode.CREATIVE);
/*  50 */         p.setAllowFlight(true);
/*  51 */         admin.add(p.getName());
/*  52 */         saveinv.put(p.getName(), p.getInventory().getContents());
/*  53 */         savearmor.put(p.getName(), p.getInventory().getArmorContents());
/*  54 */         p.getInventory().clear();
/*     */         
/*  56 */         ItemStack redstone = new ItemStack(Material.REDSTONE_TORCH_ON);
/*  57 */         redstonemeta = redstone.getItemMeta();
/*  58 */         redstonemeta.setDisplayName("§7§lSair do modo admin §8§l(§6§lClique§8§l)");
/*  59 */         redstone.setItemMeta(redstonemeta);
/*     */         
/*  61 */         info = new ItemStack(Material.NETHER_STAR);
/*  62 */         infometa = info.getItemMeta();
/*  63 */         ((ItemMeta)infometa).setDisplayName("§7§lInformaçoes do Player");
/*  64 */         info.setItemMeta((ItemMeta)infometa);
/*     */         
/*  66 */         ItemStack repulsao = new ItemStack(Material.STICK);
/*  67 */         ItemMeta repulsaometa = repulsao.getItemMeta();
/*  68 */         repulsaometa.addEnchant(org.bukkit.enchantments.Enchantment.KNOCKBACK, 5, true);
/*  69 */         repulsaometa.setDisplayName("§7§lTestar Knock-Back");
/*  70 */         repulsao.setItemMeta(repulsaometa);
/*     */         
/*  72 */         ItemStack autosoup = new ItemStack(Material.BOWL);
/*  73 */         ItemMeta autosoupmeta = autosoup.getItemMeta();
/*  74 */         autosoupmeta.setDisplayName("§7§lTestar Auto-Soup");
/*  75 */         autosoup.setItemMeta(autosoupmeta);
/*     */         
/*  77 */         ItemStack tr = new ItemStack(Material.MAGMA_CREAM);
/*  78 */         ItemMeta trmeta = tr.getItemMeta();
/*  79 */         trmeta.setDisplayName("§7§lTestar FF");
/*  80 */         tr.setItemMeta(trmeta);
/*     */         
/*  82 */         ItemStack arena = new ItemStack(Material.MOB_SPAWNER);
/*  83 */         ItemMeta arenameta = arena.getItemMeta();
/*  84 */         arenameta.setDisplayName("§7§lArena");
/*  85 */         arena.setItemMeta(arenameta);
/*     */         
/*  87 */         p.getInventory().setItem(0, redstone);
/*  88 */         p.getInventory().setItem(1, info);
/*  89 */         p.getInventory().setItem(7, repulsao);
/*  90 */         p.getInventory().setItem(8, autosoup);
/*  91 */         p.getInventory().setItem(3, tr);
/*  92 */         p.getInventory().setItem(5, arena);
/*  93 */         p.updateInventory();
/*     */       } else {
/*  95 */         p.sendMessage("§7§lO seu modo admin está §cDesativado");
/*  96 */         p.getInventory().clear();
/*  97 */         admin.remove(p.getName());
/*  98 */         ItemMeta localItemMeta2 = (infometa = Bukkit.getOnlinePlayers()).length; for (ItemMeta localItemMeta1 = 0; localItemMeta1 < localItemMeta2; localItemMeta1++) { Player s = infometa[localItemMeta1];
/*  99 */           s.showPlayer(p);
/* 100 */           p.setGameMode(GameMode.ADVENTURE);
/*     */         }
/* 102 */         p.getInventory().setContents((ItemStack[])saveinv.get(p.getName()));
/* 103 */         p.getInventory().setArmorContents((ItemStack[])savearmor.get(p.getName()));
/* 104 */         p.updateInventory();
/*     */       }
/*     */     }
/* 107 */     return false;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void InteragirRedstone(PlayerInteractEvent e) {
/* 112 */     if ((e.getMaterial() == Material.REDSTONE_TORCH_ON) && (admin.contains(e.getPlayer().getName()))) {
/* 113 */       e.getPlayer().chat("/admin");
/* 114 */       e.getPlayer().updateInventory();
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void Interagirinfo(PlayerInteractEntityEvent e) {
/* 120 */     if (((e.getRightClicked() instanceof Player)) && (e.getPlayer().getItemInHand().getType() == Material.NETHER_STAR) && (admin.contains(e.getPlayer().getName()))) {
/* 121 */       Player p = e.getPlayer();
/* 122 */       Player t = (Player)e.getRightClicked();
/* 123 */       Damageable hp = t;
/* 124 */       p.sendMessage("§7Informações de §e§l" + t.getName());
/* 125 */       p.sendMessage("§6Vida: §e" + (int)hp.getHealth());
/* 126 */       p.sendMessage("§6Sopa: §e" + getMaterial(t, Material.MUSHROOM_SOUP));
/* 127 */       p.sendMessage("§6IP: §e" + t.getAddress().getAddress().toString());
/* 128 */       p.sendMessage("§6Fome: §e" + t.getFoodLevel());
/* 129 */       p.sendMessage("§6Kit: §e" + KitAPI.getkit(t));
/* 130 */       p.sendMessage("§6Tag: §e" + Main.getInstance().getConfig().getString(new StringBuilder("Status.").append(t.getName()).append(".Tag").toString()));
/* 131 */       p.sendMessage("§6Rank: §e" + Main.getInstance().getConfig().getString(new StringBuilder("Status.").append(t.getName()).append(".Rank").toString()));
/* 132 */       if (KitAPI.getkit(t) == "Nenhum") {
/* 133 */         p.sendMessage("§6Invencivel: §aON");
/* 134 */       } else if (KitAPI.getkit(t) != "Nenhum") {
/* 135 */         p.sendMessage("§6Invencivel: §cOFF");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static int getMaterial(Player p, Material m)
/*     */   {
/* 142 */     int value = 0;
/* 143 */     ItemStack[] arrayOfItemStack; int j = (arrayOfItemStack = p.getInventory().getContents()).length; for (int i = 0; i < j; i++) { ItemStack item = arrayOfItemStack[i];
/* 144 */       if ((item != null) && (item.getType() == m) && (item.getAmount() > 0)) {
/* 145 */         value += item.getAmount();
/*     */       }
/*     */     }
/* 148 */     return value;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void autosoup(PlayerInteractEntityEvent e)
/*     */   {
/* 154 */     if (((e.getRightClicked() instanceof Player)) && (e.getPlayer().getItemInHand().getType() == Material.BOWL) && (admin.contains(e.getPlayer().getName()))) {
/* 155 */       final Player p = e.getPlayer();
/* 156 */       final Player t = (Player)e.getRightClicked();
/* 157 */       p.openInventory(t.getInventory());
/* 158 */       t.setHealth(2);
/* 159 */       saveinv.put(t.getName(), t.getInventory().getContents());
/* 160 */       savearmor.put(t.getName(), t.getInventory().getArmorContents());
/* 161 */       t.getInventory().clear();
/* 162 */       Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 166 */           t.getInventory().setItem(16, new ItemStack(Material.MUSHROOM_SOUP));
/* 167 */           t.setHealth(2);
/*     */         }
/* 169 */       }, 25L);
/*     */       
/* 171 */       Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 175 */           t.getInventory().setItem(17, new ItemStack(Material.MUSHROOM_SOUP));
/* 176 */           t.setHealth(2);
/*     */         }
/* 178 */       }, 35L);
/*     */       
/* 180 */       Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 184 */           t.getInventory().setItem(18, new ItemStack(Material.MUSHROOM_SOUP));
/* 185 */           t.setHealth(2);
/*     */         }
/* 187 */       }, 45L);
/*     */       
/* 189 */       Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 193 */           t.getInventory().setItem(19, new ItemStack(Material.MUSHROOM_SOUP));
/* 194 */           t.setHealth(2);
/*     */         }
/* 196 */       }, 55L);
/*     */       
/* 198 */       Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 202 */           t.getInventory().setItem(20, new ItemStack(Material.MUSHROOM_SOUP));
/* 203 */           t.setHealth(2);
/*     */         }
/* 205 */       }, 65L);
/*     */       
/* 207 */       Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 211 */           t.getInventory().setItem(21, new ItemStack(Material.MUSHROOM_SOUP));
/* 212 */           t.setHealth(2);
/*     */         }
/* 214 */       }, 75L);
/*     */       
/* 216 */       Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 220 */           t.getInventory().setItem(23, new ItemStack(Material.MUSHROOM_SOUP));
/* 221 */           t.setHealth(2);
/*     */         }
/* 223 */       }, 85L);
/*     */       
/* 225 */       Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 229 */           t.getInventory().setItem(25, new ItemStack(Material.MUSHROOM_SOUP));
/* 230 */           t.getInventory().setContents((ItemStack[])Admin.saveinv.get(t.getName()));
/* 231 */           t.getInventory().setArmorContents((ItemStack[])Admin.savearmor.get(t.getName()));
/* 232 */           p.updateInventory();
/* 233 */           t.updateInventory();
/* 234 */           p.closeInventory();
/*     */         }
/* 236 */       }, 100L);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void tr(PlayerInteractEvent e)
/*     */   {
/* 243 */     final Player p = e.getPlayer();
/* 244 */     if ((e.getMaterial() == Material.MAGMA_CREAM) && (admin.contains(p.getName())) && (p.hasPermission("ng.admin"))) { Player[] arrayOfPlayer;
/* 245 */       int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player s = arrayOfPlayer[i];
/* 246 */         s.showPlayer(p);
/* 247 */         p.setGameMode(GameMode.SURVIVAL);
/*     */       }
/* 249 */       Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*     */       {
/*     */         public void run() {
/*     */           Player[] arrayOfPlayer;
/* 253 */           int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player s = arrayOfPlayer[i];
/* 254 */             if (p.hasPermission("ng.admin")) {
/* 255 */               s.hidePlayer(p);
/* 256 */               p.setGameMode(GameMode.CREATIVE);
/*     */             }
/*     */           }
/*     */         }
/* 260 */       }, 10L);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void abririnv(PlayerInteractEntityEvent e) {
/* 266 */     Player p = e.getPlayer();
/* 267 */     if (((e.getRightClicked() instanceof Player)) && (e.getPlayer().getItemInHand().getType() == Material.AIR) && (admin.contains(p.getName())) && 
/* 268 */       (p.hasPermission("ng.admin"))) {
/* 269 */       Player t = (Player)e.getRightClicked();
/* 270 */       p.openInventory(t.getInventory());
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void arena(PlayerInteractEntityEvent e) {
/* 276 */     if (((e.getRightClicked() instanceof Player)) && (e.getPlayer().getItemInHand().getType() == Material.MOB_SPAWNER) && (admin.contains(e.getPlayer().getName()))) {
/* 277 */       Player t = (Player)e.getRightClicked();
/* 278 */       e.getPlayer().chat("/arena " + t.getName());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\Admin.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */