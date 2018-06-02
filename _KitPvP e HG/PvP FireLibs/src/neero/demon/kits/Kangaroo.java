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
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerMoveEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ public class Kangaroo implements Listener, CommandExecutor
/*     */ {
/*     */   public Main plugin;
/*     */   
/*     */   public Kangaroo(Main plugin)
/*     */   {
/*  36 */     this.plugin = plugin;
/*     */   }
/*     */   
/*  39 */   public static ArrayList<Player> kangaroo = new ArrayList();
/*  40 */   public static ArrayList<Player> cantkanga = new ArrayList();
/*  41 */   public static HashMap<Player, Integer> kanga = new HashMap();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  45 */     Player p = e.getEntity();
/*     */     
/*  47 */     kangaroo.remove(p);
/*  48 */     cantkanga.remove(p);
/*  49 */     kanga.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  54 */     Player jogador = (Player)sender;
/*  55 */     if (label.equalsIgnoreCase("kangaroo")) {
/*  56 */       if (jogador.hasPermission("kit.kangaroo"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  60 */           jogador.sendMessage("§c§l§oVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  64 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  69 */         jogador.sendMessage(ChatColor.RED + "Voce nao possue este kit !");
/*     */       }
/*     */     }
/*  72 */     return false;
/*     */   }
/*     */   
/*     */   public void giveKit(Player p)
/*     */   {
/*  77 */     p.getInventory().clear();
/*  78 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cKangaroo!");
KitAPI.setKit(p, "Kangaroo");
Scoreboard.iscoriboard(p);
/*  79 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  80 */     p.getInventory().addItem(new ItemStack[] { sword });
/*  81 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.FIREWORK) });
KitAPI.darsopa(p);
/*  86 */     kangaroo.add(p);
/*  87 */     kanga.put(p, Integer.valueOf(2));
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onAttemp(final EntityDamageByEntityEvent e)
/*     */   {
/*  93 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
/*     */     {
/*  95 */       if (!kangaroo.contains(e.getEntity())) {
/*  96 */         return;
/*     */       }
/*  98 */       cantkanga.add((Player)e.getEntity());
/*  99 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 103 */           Kangaroo.cantkanga.remove(e.getEntity());
/*     */         }
/* 105 */       }, 30L);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onKangaroo(PlayerInteractEvent e)
/*     */   {
/* 112 */     Player p = e.getPlayer();
/* 113 */     if (!kangaroo.contains(p)) {
/* 114 */       return;
/*     */     }
/* 116 */     if (p.getItemInHand().getType() != Material.FIREWORK) {
/* 117 */       return;
/*     */     }
/* 119 */     if ((e.getAction() == Action.LEFT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.LEFT_CLICK_AIR) || 
/* 120 */       (e.getAction() == Action.RIGHT_CLICK_AIR))
/*     */     {
/* 122 */       e.setCancelled(true);
/* 123 */       if (cantkanga.contains(p)) {
/* 124 */         return;
/*     */       }
/* 126 */       if (((Integer)kanga.get(p)).intValue() == 0) {
/* 127 */         return;
/*     */       }
/* 129 */       kanga.put(p, Integer.valueOf(((Integer)kanga.get(p)).intValue() - 1));
/* 130 */       if (p.isSneaking())
/*     */       {
/* 132 */         Vector vector = p.getEyeLocation().getDirection();
/* 133 */         vector.multiply(1.0F);
/* 134 */         vector.setY(0.7D);
/* 135 */         p.setVelocity(vector);
/*     */       }
/*     */       else
/*     */       {
/* 139 */         Vector vector = p.getEyeLocation().getDirection();
/* 140 */         vector.multiply(0.6F);
/* 141 */         vector.setY(1);
/* 142 */         p.setVelocity(vector);
/*     */       }
/* 144 */       p.setFallDistance(-5.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onFall(EntityDamageEvent e)
/*     */   {
/* 151 */     if ((e.getEntity() instanceof Player))
/*     */     {
/* 153 */       Player p = (Player)e.getEntity();
/* 154 */       if ((kangaroo.contains(p)) && (e.getCause() == EntityDamageEvent.DamageCause.FALL) && (e.getDamage() > 7.0D))
/*     */       {
/* 156 */         e.setCancelled(true);
/* 157 */         p.damage(7.0D);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @EventHandler
/*     */   public void onKangaMove(PlayerMoveEvent e)
/*     */   {
/* 166 */     Player p = e.getPlayer();
/* 167 */     if (!kangaroo.contains(p)) {
/* 168 */       return;
/*     */     }
/* 170 */     if (p.isOnGround()) {
/* 171 */       kanga.put(p, Integer.valueOf(2));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Kangaroo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */