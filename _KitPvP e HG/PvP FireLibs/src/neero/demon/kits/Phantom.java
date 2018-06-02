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
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ 
/*     */ public class Phantom
/*     */   implements Listener, CommandExecutor
/*     */ {
/*     */   public Main plugin;
/*     */   
/*     */   public Phantom(Main plugin)
/*     */   {
/*  32 */     this.plugin = plugin;
/*     */   }
/*     */   
/*  35 */   public static ArrayList<Player> phantom = new ArrayList();
/*  36 */   public static ArrayList<Player> cooldown = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  40 */     Player p = e.getEntity();
/*     */     
/*  42 */     phantom.remove(p);
/*  43 */     cooldown.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  47 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  49 */     phantom.remove(p);
/*  50 */     cooldown.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  55 */     Player jogador = (Player)sender;
/*  56 */     if (label.equalsIgnoreCase("phantom")) {
/*  57 */       if (jogador.hasPermission("kit.phantom"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  61 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  65 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  70 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*     */       }
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public void giveKit(Player p)
/*     */   {
/*  78 */     p.getInventory().clear();
/*  79 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cPhantom!");
KitAPI.setKit(p, "Phantom");
Scoreboard.iscoriboard(p);
/*  80 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  81 */     p.getInventory().addItem(new ItemStack[] { sword });
/*  82 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.FEATHER) });
KitAPI.darsopa(p);
/*  87 */     phantom.add(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerInteract(final PlayerInteractEvent e)
/*     */   {
/*  93 */     if (e.getPlayer().getItemInHand().getType() != Material.FEATHER) {
/*  94 */       return;
/*     */     }
/*  96 */     if (!phantom.contains(e.getPlayer())) {
/*  97 */       return;
/*     */     }
/*  99 */     if (cooldown.contains(e.getPlayer()))
/*     */     {
/* 101 */       e.getPlayer().sendMessage(ChatColor.RED + "§4§lKIT §7You can't fly yet!");
/* 102 */       return;
/*     */     }
/* 104 */     if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
/*     */     {
/* 106 */       cooldown.add(e.getPlayer());
/* 107 */       e.getPlayer().setAllowFlight(true);
/* 108 */       e.getPlayer().sendMessage(ChatColor.GREEN + "§4§lKIT §7Pode voar por 5 segundos!");
/* 109 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 113 */           e.getPlayer().sendMessage(ChatColor.RED + "§4§lKIT §74 segundos restantes!");
/*     */         }
/* 115 */       }, 20L);
/* 116 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 120 */           e.getPlayer().sendMessage(ChatColor.RED + "§4§lKIT §73 segundos restantes!");
/*     */         }
/* 122 */       }, 40L);
/* 123 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 127 */           e.getPlayer().sendMessage(ChatColor.RED + "§4§lKIT §72 segundos restantes!");
/*     */         }
/* 129 */       }, 60L);
/* 130 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 134 */           e.getPlayer().sendMessage(ChatColor.RED + "§4§lKIT §71 segundos restantes!");
/*     */         }
/* 136 */       }, 80L);
/* 137 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 141 */           e.getPlayer().setAllowFlight(false);
/* 142 */           e.getPlayer().sendMessage(ChatColor.RED + "§4§lKIT §7Voo terminou!");
/* 143 */           e.getPlayer().setFallDistance(0.0F);
/*     */         }
/* 145 */       }, 100L);
/* 146 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 150 */           e.getPlayer().sendMessage(ChatColor.GREEN + "§4§lKIT §7Pode voar novamente!");
/* 151 */           Phantom.cooldown.remove(e.getPlayer());
/*     */         }
/* 153 */       }, 600L);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Phantom.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */