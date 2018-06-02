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
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class Thor implements Listener, CommandExecutor
/*     */ {
/*     */   public Main plugin;
/*     */   
/*     */   public Thor(Main plugin)
/*     */   {
/*  34 */     this.plugin = plugin;
/*     */   }
/*     */   
/*  37 */   public static ArrayList<Player> thor = new ArrayList();
/*  38 */   public static ArrayList<Player> cooldown = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  42 */     Player p = e.getEntity();
/*     */     
/*  44 */     thor.remove(p);
/*  45 */     cooldown.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  49 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  51 */     thor.remove(p);
/*  52 */     cooldown.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  57 */     Player jogador = (Player)sender;
/*  58 */     if (label.equalsIgnoreCase("thor")) {
/*  59 */       if (jogador.hasPermission("kit.thor"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  63 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  67 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  72 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*     */       }
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public void giveKit(Player p)
/*     */   {
/*  80 */     p.getInventory().clear();
/*  81 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cThor!");
Scoreboard.iscoriboard(p);
KitAPI.setKit(p, "Thor");
/*  82 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  83 */     p.getInventory().addItem(new ItemStack[] { sword });
/*  84 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.GOLD_AXE) });
KitAPI.darsopa(p);
/*  89 */     thor.add(p);
/*     */   }
/*     */   
/*     */ 
/*     */   @EventHandler
/*     */   public void onPlayerInteracts(PlayerInteractEvent e)
/*     */   {
/*  96 */     final Player p = e.getPlayer();
/*  97 */     if (!thor.contains(e.getPlayer())) {
/*  98 */       return;
/*     */     }
/* 100 */     if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_AIR))
/*     */     {
/* 102 */       if (p.getItemInHand().getType() != Material.GOLD_AXE) {
/* 103 */         return;
/*     */       }
/* 105 */       if (cooldown.contains(p))
/*     */       {
/* 107 */         p.sendMessage(ChatColor.RED + "§4§lKIT §7O thor esta em cooldown!");
/* 108 */         return;
/*     */       }
/* 110 */       cooldown.add(p);
/* 111 */       Location thored = p.getTargetBlock(null, 15).getLocation();
/* 112 */       p.getWorld().strikeLightning(thored);
/* 113 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 117 */           p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Pode usar o thor novamente!");
/* 118 */           Thor.cooldown.remove(p);
/*     */         }
/* 120 */       }, 200L);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onThor(EntityDamageEvent e)
/*     */   {
/* 127 */     if ((e.getEntity() instanceof Player))
/*     */     {
/* 129 */       Player p = (Player)e.getEntity();
/* 130 */       if (e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING)
/*     */       {
/* 132 */         if (thor.contains(p))
/*     */         {
/* 134 */           e.setCancelled(true);
/* 135 */           return;
/*     */         }
/* 137 */         p.setFireTicks(100);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Thor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */