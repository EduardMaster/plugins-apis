/*     */ package neero.demon.kits;
/*     */ 
/*     */ /*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;

import neero.demon.Main;
import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.block.BlockFace;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.event.player.PlayerMoveEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class Skyrunner
/*     */   implements Listener, CommandExecutor
/*     */ {
/*     */   public Main plugin;
/*     */   
/*     */   public Skyrunner(Main plugin)
/*     */   {
/*  34 */     this.plugin = plugin;
/*     */   }
/*     */   
/*  37 */   public static ArrayList<Player> skyrunner = new ArrayList();
/*  38 */   public static HashMap<Player, Integer> runtime = new HashMap();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  42 */     Player p = e.getEntity();
/*     */     
/*  44 */     skyrunner.remove(p);
/*  45 */     runtime.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  49 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  51 */     skyrunner.remove(p);
/*  52 */     runtime.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  57 */     Player jogador = (Player)sender;
/*  58 */     if (label.equalsIgnoreCase("skyrunner")) {
/*  59 */       if (jogador.hasPermission("kit.skyrunner"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  63 */           jogador.sendMessage("§4§lKIT §7Voce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  67 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  72 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §7Voce nao possue este kit !");
/*     */       }
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public static void giveKit(Player p)
/*     */   {
/*  80 */     p.getInventory().clear();
/*  81 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  82 */     p.getInventory().addItem(new ItemStack[] { sword });
/*  83 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.VINE) });
/*  84 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §cVoce escolheu Skyrunner!");
KitAPI.setKit(p, "Skyrunner");
Scoreboard.iscoriboard(p);
KitAPI.darsopa(p);
/*  89 */     skyrunner.add(p);
/*  90 */     runtime.put(p, Integer.valueOf(20));
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerMove(PlayerMoveEvent e)
/*     */   {
/*  96 */     final Player p = e.getPlayer();
/*  97 */     if (!skyrunner.contains(p)) {
/*  98 */       return;
/*     */     }
/* 100 */     if (p.getItemInHand().getType() != Material.VINE) {
/* 101 */       return;
/*     */     }
/* 103 */     if (((Integer)runtime.get(p)).intValue() < 1) {
/* 104 */       return;
/*     */     }
/* 106 */     final Block block = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
/* 107 */     if ((block.isEmpty()) || (block.getType() == Material.AIR))
/*     */     {
/* 109 */       block.setType(Material.LEAVES);
/* 110 */       runtime.put(p, Integer.valueOf(((Integer)runtime.get(p)).intValue() - 1));
/* 111 */       p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Ainda lhe restam " + runtime.get(p) + " blocos.");
/* 112 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 116 */           block.setType(Material.AIR);
/*     */         }
/* 118 */       }, 60L);
/* 119 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 123 */           if (!Skyrunner.skyrunner.contains(p)) {
/* 124 */             return;
/*     */           }
/* 126 */           if (((Integer)Skyrunner.runtime.get(p)).intValue() > 19) {
/* 127 */             return;
/*     */           }
/* 129 */           Skyrunner.runtime.put(p, Integer.valueOf(((Integer)Skyrunner.runtime.get(p)).intValue() + 1));
/*     */         }
/* 131 */       }, 300L);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Skyrunner.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */