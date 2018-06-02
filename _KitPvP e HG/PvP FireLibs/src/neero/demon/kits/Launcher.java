/*     */ package neero.demon.kits;
/*     */ 
/*     */ /*     */ import java.util.ArrayList;

import neero.demon.Main;
import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.block.BlockState;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.BlockPlaceEvent;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class Launcher implements Listener, CommandExecutor
/*     */ {
/*     */   public Main plugin;
/*     */   
/*     */   public Launcher(Main plugin)
/*     */   {
/*  32 */     this.plugin = plugin;
/*     */   }
/*     */   
/*     */ 
/*  36 */   public static ArrayList<Player> launcher = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  40 */     Player p = e.getEntity();
/*     */     
/*  42 */     launcher.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  46 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  48 */     launcher.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  53 */     Player jogador = (Player)sender;
/*  54 */     if (label.equalsIgnoreCase("launcher")) {
/*  55 */       if (jogador.hasPermission("kit.launcher"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  59 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  63 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  68 */         jogador.sendMessage(ChatColor.RED + "Voce nao possue este kit !");
/*     */       }
/*     */     }
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public static void giveKit(Player p)
/*     */   {
/*  76 */     p.getInventory().clear();
/*  77 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cLauncher!");
Scoreboard.iscoriboard(p);
KitAPI.setKit(p, "Launcher");
/*  78 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  79 */     p.getInventory().addItem(new ItemStack[] { sword });
/*  80 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.GOLD_BLOCK, 20) });
KitAPI.darsopa(p);
/*  85 */     launcher.add(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onGOLD_BLOCKPlace(BlockPlaceEvent e)
/*     */   {
/*  91 */     Player p = e.getPlayer();
/*  92 */     if (!launcher.contains(p)) {
/*  93 */       return;
/*     */     }
/*  95 */     if (p.getItemInHand().getType() != Material.GOLD_BLOCK) {
/*  96 */       return;
/*     */     }
/*  98 */     int GOLD_BLOCKsleft = p.getItemInHand().getAmount();
/*  99 */     e.setCancelled(true);
/* 100 */     Location placed = e.getBlock().getLocation();
/* 101 */     org.bukkit.World w = placed.getWorld();
/* 102 */     double x = placed.getX();
/* 103 */     double y = placed.getY();
/* 104 */     double z = placed.getZ();
/* 105 */     final Location GOLD_BLOCK = new Location(w, x, y, z);
/* 106 */     final Material block = e.getBlockReplacedState().getType();
/* 107 */     Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 111 */         GOLD_BLOCK.getBlock().setType(Material.GOLD_BLOCK);
/*     */       }
/* 113 */     }, 1L);
/* 114 */     if (p.getItemInHand().getAmount() == 1) {
/* 115 */       p.setItemInHand(new ItemStack(Material.AIR));
/*     */     }
/* 117 */     p.getItemInHand().setAmount(GOLD_BLOCKsleft - 1);
/* 118 */     Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 122 */         GOLD_BLOCK.getBlock().setType(block);
/*     */       }
/* 124 */     }, 140L);
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Launcher.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */