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
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.event.player.PlayerMoveEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ 
/*     */ public class Timelord
/*     */   implements Listener, CommandExecutor
/*     */ {
/*     */   public Main plugin;
/*     */   
/*     */   public Timelord(Main plugin)
/*     */   {
/*  36 */     this.plugin = plugin;
/*     */   }
/*     */   
/*  39 */   public static ArrayList<Player> timelord = new ArrayList();
/*  40 */   public static ArrayList<Player> cantmove = new ArrayList();
/*  41 */   public static ArrayList<Player> cooldown = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  45 */     Player p = e.getEntity();
/*     */     
/*  47 */     timelord.remove(p);
/*  48 */     cantmove.remove(p);
/*  49 */     cooldown.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  53 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  55 */     timelord.remove(p);
/*  56 */     cooldown.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  61 */     Player jogador = (Player)sender;
/*  62 */     if (label.equalsIgnoreCase("timelord")) {
/*  63 */       if (jogador.hasPermission("kit.timelord"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  67 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  71 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  76 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*     */       }
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public static void giveKit(Player p)
/*     */   {
/*  85 */     p.getInventory().clear();
/*  86 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cTimelord!");
KitAPI.setKit(p, "Timelord");
Scoreboard.iscoriboard(p);
/*  87 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  88 */     p.getInventory().addItem(new ItemStack[] { sword });
/*  89 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.getMaterial(347)) });
KitAPI.darsopa(p);
/*  94 */     timelord.add(p);
/*     */   }
/*     */   
/*     */ 
/*     */   @EventHandler
/*     */   public void onTimeFreeze(PlayerInteractEvent e)
/*     */   {
/* 101 */     final Player p = e.getPlayer();
/* 102 */     if (!timelord.contains(p)) {
/* 103 */       return;
/*     */     }
/* 105 */     if (p.getItemInHand().getType() != Material.getMaterial(347)) {
/* 106 */       return;
/*     */     }
/* 108 */     if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
/*     */     {
/* 110 */       if (cooldown.contains(p))
/*     */       {
/* 112 */         p.sendMessage(ChatColor.RED + "§4§lKIT §7Nao pode parar o tempo ainda , aguarde!");
/* 113 */         return;
/*     */       }
/* 115 */       cooldown.add(p);
/* 116 */       for (final Entity target : p.getNearbyEntities(7.0D, 3.0D, 7.0D)) {
/* 117 */         if ((target instanceof Player))
/*     */         {
/* 119 */           target.setVelocity(new Vector(0.0D, -1.0D, 0.0D));
/* 120 */           float f = 0.0F;
/* 121 */           p.setFallDistance(f);
/* 122 */           cantmove.add((Player)target);
/* 123 */           ((Player)target).sendMessage(ChatColor.RED + "§4§lKIT §7Sua visao foi pega por um timelord!");
/* 124 */           Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 128 */               if (Timelord.cantmove.contains(target))
/*     */               {
/* 130 */                 Timelord.cantmove.remove(target);
/* 131 */                 ((Player)target).sendMessage(ChatColor.GREEN + "§4§lKIT §7Sua visao foi descongelada.");
/*     */               }
/*     */             }
/* 134 */           }, 200L);
/*     */         }
/*     */       }
/* 137 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 141 */           Timelord.cooldown.remove(p);
/* 142 */           p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce pode parar o tempo denovo!");
/*     */         }
/* 144 */       }, 900L);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onEntityDamage(EntityDamageByEntityEvent e)
/*     */   {
/* 151 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)) && (cantmove.contains(e.getEntity()))) {
/* 152 */       cantmove.remove(e.getEntity());
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onMove(PlayerMoveEvent e)
/*     */   {
/* 159 */     Player p = e.getPlayer();
/* 160 */     if (cantmove.contains(p)) {
/* 161 */       e.setTo(e.getFrom());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Timelord.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */