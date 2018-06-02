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
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ 
/*     */ public class Pesadelo
/*     */   implements Listener, CommandExecutor
/*     */ {
/*     */   public Main plugin;
/*     */   
/*     */   public Pesadelo(Main plugin)
/*     */   {
/*  35 */     this.plugin = plugin;
/*     */   }
/*     */   
/*  38 */   public static ArrayList<Player> nightmare = new ArrayList();
/*  39 */   public static ArrayList<Player> cooldown = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  43 */     Player p = e.getEntity();
/*     */     
/*  45 */     nightmare.remove(p);
/*  46 */     cooldown.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  50 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  52 */     nightmare.remove(p);
/*  53 */     cooldown.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  58 */     Player jogador = (Player)sender;
/*  59 */     if (label.equalsIgnoreCase("pesadelo")) {
/*  60 */       if (jogador.hasPermission("kit.pesadelo"))
/*     */       {
/* /*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  64 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  68 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  73 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*     */       }
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public static void giveKit(Player p)
/*     */   {
/*  81 */     p.getInventory().clear();
/*  82 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cPesadelo!");
KitAPI.setKit(p, "Pesadelo");
Scoreboard.iscoriboard(p);
/*  83 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  84 */     p.getInventory().addItem(new ItemStack[] { sword });
/*  85 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.DRAGON_EGG) });
KitAPI.darsopa(p);
/*  89 */     nightmare.add(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onTimeFreeze(PlayerInteractEvent e)
/*     */   {
/*  95 */     final Player p = e.getPlayer();
/*  96 */     if (!nightmare.contains(p)) {
/*  97 */       return;
/*     */     }
/*  99 */     if (p.getItemInHand().getType() != Material.DRAGON_EGG) {
/* 100 */       return;
/*     */     }
/* 102 */     if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
/*     */     {
/* 104 */       if (cooldown.contains(p))
/*     */       {
/* 106 */         p.sendMessage(ChatColor.RED + "§4§lKIT §7Voce nao pode causar pesadelos ainda , Freddy!");
/* 107 */         return;
/*     */       }
/* 109 */       cooldown.add(p);
/* 110 */       p.sendMessage(ChatColor.BLACK + "§4§lKIT §7Freddy , voce causou um pesadelo!");
/* 111 */       for (Entity target : p.getNearbyEntities(15.0D, 15.0D, 15.0D)) {
/* 112 */         if ((target instanceof Player))
/*     */         {
/* 114 */           Player pl = (Player)target;
/* 115 */           pl.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0));
/* 116 */           pl.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 0));
/* 117 */           pl.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 0));
/* 118 */           pl.sendMessage(ChatColor.DARK_RED + "Voce esta tendo um pesadelo!");
/*     */         }
/*     */       }
/* 121 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 125 */           Pesadelo.cooldown.remove(p);
/* 126 */           p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Vai em frente Freddy , cause a desgraça!");
/*     */         }
/* 128 */       }, 1200L);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Pesadelo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */