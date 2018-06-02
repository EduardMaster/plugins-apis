/*     */ package neero.demon.kits;
/*     */ 
/*     */ /*     */ import java.util.ArrayList;

import neero.demon.Main;
import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ public class Anchor
/*     */   implements Listener, CommandExecutor
/*     */ {
/*     */   public Main plugin;
/*     */   
/*     */   public Anchor(Main plugin)
/*     */   {
/*  31 */     this.plugin = plugin;
/*     */   }
/*     */   
/*     */ 
/*  35 */   public static ArrayList<Player> anchor = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  39 */     Player p = e.getEntity();
/*     */     
/*  41 */     anchor.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  45 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  47 */     anchor.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  52 */     Player jogador = (Player)sender;
/*  53 */     if (label.equalsIgnoreCase("anchor")) {
/*  54 */       if (jogador.hasPermission("kit.anchor"))
/*     */       {
/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  58 */           jogador.sendMessage("§c§l§oVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  62 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  67 */         jogador.sendMessage(ChatColor.RED + "Voce nao possue este kit !");
/*     */       }
/*     */     }
/*  70 */     return false;
/*     */   }
/*     */   
/*     */   public static void giveKit(Player p)
/*     */   {
/*  75 */     p.getInventory().clear();
/*  76 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cAnchor!");
KitAPI.setKit(p, "Anchor");
Scoreboard.iscoriboard(p);
/*  77 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  78 */     p.getInventory().addItem(new ItemStack[] { sword });
KitAPI.darsopa(p);
/*  83 */     anchor.add(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onAnchorDamage(EntityDamageByEntityEvent e)
/*     */   {
/*  89 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
/*     */     {
/*  91 */       final Player p = (Player)e.getEntity();
/*  92 */       Player d = (Player)e.getDamager();
/*  93 */       if ((anchor.contains(p)) || (anchor.contains(d))) {
/*  94 */         Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/*  98 */             double x = 0.0D;
/*  99 */             double y = 0.0D;
/* 100 */             double z = 0.0D;
/* 101 */             Vector v = new Vector(x, y, z);
/* 102 */             p.setVelocity(v);
/*     */           }
/* 104 */         }, 1L);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Anchor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */