/*     */ package neero.demon.kits;
/*     */ 
/*     */ import java.util.ArrayList;

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
/*     */ import org.bukkit.entity.TNTPrimed;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ 
/*     */ public class Tank implements Listener, CommandExecutor
/*     */ {
/*  29 */   public static ArrayList<Player> tank = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  33 */     Player p = e.getEntity();
/*     */     
/*  35 */     tank.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  39 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  41 */     tank.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  46 */     Player jogador = (Player)sender;
/*  47 */     if (label.equalsIgnoreCase("tank")) {
/*  48 */       if (jogador.hasPermission("kit.tank"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  52 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  56 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  61 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*     */       }
/*     */     }
/*  64 */     return false;
/*     */   }
/*     */   
/*     */   public static void giveKit(Player p)
/*     */   {
/*  69 */     p.getInventory().clear();
/*  70 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu Tank!");
KitAPI.setKit(p, "Tank");
Scoreboard.iscoriboard(p);
/*  71 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  72 */     p.getInventory().addItem(new ItemStack[] { sword });
KitAPI.darsopa(p);
/*  77 */     tank.add(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerDeath(PlayerDeathEvent e)
/*     */   {
/*  83 */     Player p = e.getEntity();
/*  84 */     if ((p.getKiller() instanceof Player))
/*     */     {
/*  86 */       Player k = p.getKiller();
/*  87 */       if (!tank.contains(k)) {
/*  88 */         return;
/*     */       }
/*  90 */       Location loc = p.getLocation();
/*  91 */       Entity ent = Bukkit.getServer().getWorld(loc.getWorld().getName()).spawnEntity(loc, EntityType.PRIMED_TNT);
/*  92 */       ((TNTPrimed)ent).setFuseTicks(1);
/*  93 */       for (Entity entity : k.getNearbyEntities(10.0D, 10.0D, 10.0D)) {
/*  94 */         if ((entity instanceof Player)) {
/*  95 */           ((Player)entity).damage(0.0D, k);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void idknow(EntityDamageEvent e)
/*     */   {
/* 104 */     if ((e.getEntity() instanceof Player))
/*     */     {
/* 106 */       Player p = (Player)e.getEntity();
/* 107 */       if (e.getCause() != EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
/* 108 */         return;
/*     */       }
/* 110 */       if (tank.contains(p)) {
/* 111 */         e.setCancelled(true);
/*     */       } else {
/* 113 */         e.setDamage(e.getDamage() * 2.0D);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Tank.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */