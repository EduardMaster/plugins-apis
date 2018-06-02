/*     */ package neero.demon.eventos;
/*     */ 
/*     */ import neero.demon.Main;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.block.Sign;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.block.SignChangeEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ public class Placa
/*     */   implements Listener
/*     */ {
/*     */   private Main plugin;
/*     */   
/*     */   public Placa(Main instance)
/*     */   {
/*  25 */     this.plugin = instance;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onSignChange(SignChangeEvent e)
/*     */   {
/*  31 */     if (e.getLine(0).equalsIgnoreCase("sopa"))
/*     */     {
/*  33 */       e.setLine(0, "§0§l=-=()=-=");
/*  34 */       e.setLine(1, "§e§l§oExtreme");
/*  35 */       e.setLine(2, "§4§l§oSopas!");
/*  36 */       e.setLine(3, "§0§l=-=()=-=");
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void inv(PlayerInteractEvent e)
/*     */   {
/*  43 */     Player p = e.getPlayer();
/*     */     
/*  45 */     ItemStack sopas = new ItemStack(Material.MUSHROOM_SOUP);
/*     */     
/*  47 */     Inventory inve = Bukkit.getServer().createInventory(p, 36, "§e§oSopas");
/*     */     
/*  49 */     inve.setItem(0, sopas);
/*  50 */     inve.setItem(1, sopas);
/*  51 */     inve.setItem(2, sopas);
/*  52 */     inve.setItem(3, sopas);
/*  53 */     inve.setItem(4, sopas);
/*  54 */     inve.setItem(5, sopas);
/*  55 */     inve.setItem(6, sopas);
/*  56 */     inve.setItem(7, sopas);
/*  57 */     inve.setItem(8, sopas);
/*  58 */     inve.setItem(9, sopas);
/*  59 */     inve.setItem(10, sopas);
/*  60 */     inve.setItem(11, sopas);
/*  61 */     inve.setItem(12, sopas);
/*  62 */     inve.setItem(13, sopas);
/*  63 */     inve.setItem(14, sopas);
/*  64 */     inve.setItem(15, sopas);
/*  65 */     inve.setItem(16, sopas);
/*  66 */     inve.setItem(17, sopas);
/*  67 */     inve.setItem(18, sopas);
/*  68 */     inve.setItem(19, sopas);
/*  69 */     inve.setItem(20, sopas);
/*  70 */     inve.setItem(21, sopas);
/*  71 */     inve.setItem(22, sopas);
/*  72 */     inve.setItem(23, sopas);
/*  73 */     inve.setItem(24, sopas);
/*  74 */     inve.setItem(25, sopas);
/*  75 */     inve.setItem(26, sopas);
/*  76 */     inve.setItem(27, sopas);
/*  77 */     inve.setItem(28, sopas);
/*  78 */     inve.setItem(29, sopas);
/*  79 */     inve.setItem(30, sopas);
/*  80 */     inve.setItem(31, sopas);
/*  81 */     inve.setItem(32, sopas);
/*  82 */     inve.setItem(33, sopas);
/*  83 */     inve.setItem(34, sopas);
/*  84 */     inve.setItem(35, sopas);
/*  85 */     if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getClickedBlock() != null) && (
/*  86 */       (e.getClickedBlock().getType() == Material.WALL_SIGN) || (e.getClickedBlock().getType() == Material.SIGN_POST)))
/*     */     {
/*  88 */       Sign s = (Sign)e.getClickedBlock().getState();
/*  89 */       String[] lines = s.getLines();
/*  90 */       if ((lines.length > 0) && (lines[0].equals("§0§l=-=()=-=")) && 
/*  91 */         (lines.length > 1) && (lines[1].equals("§e§l§oExtreme")) && 
/*  92 */         (lines.length > 2) && (lines[2].equals("§4§l§oSopas!")) && 
/*  93 */         (lines.length > 3) && (lines[3].equals("§0§l=-=()=-="))) {
/*  94 */         p.openInventory(inve);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerColor(SignChangeEvent e)
/*     */   {
/* 102 */     if (e.getLine(0).contains("&")) {
/* 103 */       e.setLine(0, e.getLine(0).replace("&", "§"));
/*     */     }
/* 105 */     if (e.getLine(1).contains("&")) {
/* 106 */       e.setLine(1, e.getLine(1).replace("&", "§"));
/*     */     }
/* 108 */     if (e.getLine(2).contains("&")) {
/* 109 */       e.setLine(2, e.getLine(2).replace("&", "§"));
/*     */     }
/* 111 */     if (e.getLine(3).contains("&")) {
/* 112 */       e.setLine(3, e.getLine(3).replace("&", "§"));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\events\Placa.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */