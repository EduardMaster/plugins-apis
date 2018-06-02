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
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.EntityType;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.event.player.PlayerMoveEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class Escapist implements Listener, CommandExecutor
/*     */ {
/*     */   public Main plugin;
/*     */   
/*     */   public Escapist(Main plugin)
/*     */   {
/*  38 */     this.plugin = plugin;
/*     */   }
/*     */   
/*  41 */   public static ArrayList<Player> escapist = new ArrayList();
/*  42 */   public static ArrayList<Player> nofall = new ArrayList();
/*  43 */   public static HashMap<Player, Entity> firework = new HashMap();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  47 */     Player p = e.getEntity();
/*     */     
/*  49 */     escapist.remove(p);
/*  50 */     nofall.remove(p);
/*  51 */     firework.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  55 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  57 */     escapist.remove(p);
/*  58 */     nofall.remove(p);
/*  59 */     firework.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  64 */     Player jogador = (Player)sender;
/*  65 */     if (label.equalsIgnoreCase("escapist")) {
/*  66 */       if (jogador.hasPermission("kit.escapist"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  70 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  74 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  79 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*     */       }
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public static void giveKit(Player p)
/*     */   {
/*  87 */     p.getInventory().clear();
/*  88 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cEscapist!");
KitAPI.setKit(p, "Escapist");
Scoreboard.iscoriboard(p);
/*  89 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  90 */     p.getInventory().addItem(new ItemStack[] { sword });
/*  91 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.FIREWORK, 5) });
KitAPI.darsopa(p);
/*  96 */     escapist.add(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onTimeFreeze(PlayerInteractEvent e)
/*     */   {
/* 102 */     final Player p = e.getPlayer();
/* 103 */     if (!escapist.contains(p)) {
/* 104 */       return;
/*     */     }
/* 106 */     if (p.getItemInHand().getType() != Material.FIREWORK) {
/* 107 */       return;
/*     */     }
/* 109 */     e.setCancelled(true);
/* 110 */     if (e.getAction() == Action.RIGHT_CLICK_BLOCK)
/*     */     {
/* 112 */       int ammount = p.getItemInHand().getAmount();
/* 113 */       Location loc = p.getLocation();
/* 114 */       if (p.getItemInHand().getAmount() == 1) {
/* 115 */         p.setItemInHand(new ItemStack(Material.AIR));
/*     */       }
/* 117 */       nofall.remove(p);
/* 118 */       nofall.add(p);
/* 119 */       p.getItemInHand().setAmount(ammount - 1);
/* 120 */       Entity ent = Bukkit.getServer().getWorld(loc.getWorld().getName()).spawnEntity(loc, EntityType.FIREWORK);
/* 121 */       p.setFallDistance(-1000.0F);
/* 122 */       firework.put(p, ent);
/* 123 */       ((Entity)firework.get(p)).setPassenger(p);
/* 124 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 128 */           Location locs = ((Entity)Escapist.firework.get(p)).getLocation();
/* 129 */           Entity ents = Bukkit.getServer().getWorld(locs.getWorld().getName()).spawnEntity(locs, EntityType.FIREWORK);
/* 130 */           Escapist.firework.put(p, ents);
/* 131 */           ((Entity)Escapist.firework.get(p)).setPassenger(p);
/*     */         }
/* 133 */       }, 20L);
/* 134 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 138 */           ((Entity)Escapist.firework.get(p)).setPassenger(p);
/*     */         }
/*     */         
/* 141 */       }, 30L);
/* 142 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 146 */           Location locs = ((Entity)Escapist.firework.get(p)).getLocation();
/* 147 */           Entity ents = Bukkit.getServer().getWorld(locs.getWorld().getName()).spawnEntity(locs, EntityType.FIREWORK);
/* 148 */           Escapist.firework.put(p, ents);
/* 149 */           ((Entity)Escapist.firework.get(p)).setPassenger(p);
/*     */         }
/* 151 */       }, 40L);
/* 152 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 156 */           ((Entity)Escapist.firework.get(p)).setPassenger(p);
/*     */         }
/* 158 */       }, 50L);
/* 159 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 163 */           Location locs = ((Entity)Escapist.firework.get(p)).getLocation();
/* 164 */           Entity ents = Bukkit.getServer().getWorld(locs.getWorld().getName()).spawnEntity(locs, EntityType.FIREWORK);
/* 165 */           Escapist.firework.put(p, ents);
/* 166 */           ((Entity)Escapist.firework.get(p)).setPassenger(p);
/*     */         }
/* 168 */       }, 60L);
/* 169 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 173 */           ((Entity)Escapist.firework.get(p)).setPassenger(p);
/*     */         }
/* 175 */       }, 70L);
/* 176 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 180 */           Location locs = ((Entity)Escapist.firework.get(p)).getLocation();
/* 181 */           Entity ents = Bukkit.getServer().getWorld(locs.getWorld().getName()).spawnEntity(locs, EntityType.FIREWORK);
/* 182 */           Escapist.firework.put(p, ents);
/* 183 */           ((Entity)Escapist.firework.get(p)).setPassenger(p);
/*     */         }
/* 185 */       }, 80L);
/* 186 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 190 */           ((Entity)Escapist.firework.get(p)).setPassenger(p);
/*     */         }
/* 192 */       }, 90L);
/* 193 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 197 */           p.setFallDistance(0.0F);
/* 198 */           Escapist.nofall.remove(p);
/* 199 */           Escapist.nofall.add(p);
/* 200 */           Location locs = ((Entity)Escapist.firework.get(p)).getLocation();
/* 201 */           Entity ents = Bukkit.getServer().getWorld(locs.getWorld().getName()).spawnEntity(locs, EntityType.FIREWORK);
/* 202 */           Escapist.firework.put(p, ents);
/* 203 */           ((Entity)Escapist.firework.get(p)).setPassenger(p);
/*     */         }
/* 205 */       }, 100L);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @EventHandler
/*     */   public void onPlayerMove(PlayerMoveEvent e)
/*     */   {
/* 213 */     Player p = e.getPlayer();
/* 214 */     if (!nofall.contains(p)) {
/* 215 */       return;
/*     */     }
/* 217 */     if (!p.isOnGround()) {
/* 218 */       return;
/*     */     }
/* 220 */     nofall.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onFall(EntityDamageEvent e)
/*     */   {
/* 226 */     if ((e.getCause() == EntityDamageEvent.DamageCause.FALL) && (nofall.contains(e.getEntity())))
/*     */     {
/* 228 */       nofall.remove(e.getEntity());
/* 229 */       e.setCancelled(true);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Escapist.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */