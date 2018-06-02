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
/*     */ import org.bukkit.World;
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
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ public class Pikachu implements Listener, CommandExecutor
/*     */ {
/*     */   public Main plugin;
/*     */   
/*     */   public Pikachu(Main plugin)
/*     */   {
/*  36 */     this.plugin = plugin;
/*     */   }
/*     */   
/*  39 */   public static ArrayList<Player> pikachu = new ArrayList();
/*  40 */   public static ArrayList<Player> cooldown = new ArrayList();
/*  41 */   public static ArrayList<Player> nofall = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  45 */     Player p = e.getEntity();
/*     */     
/*  47 */     pikachu.remove(p);
/*  48 */     cooldown.remove(p);
/*  49 */     nofall.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  53 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  55 */     pikachu.remove(p);
/*  56 */     cooldown.remove(p);
/*  57 */     nofall.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  62 */     Player jogador = (Player)sender;
/*  63 */     if (label.equalsIgnoreCase("pikachu")) {
/*  64 */       if (jogador.hasPermission("kit.pikachu"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  68 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  72 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  77 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*     */       }
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public static void giveKit(Player p)
/*     */   {
/*  85 */     p.getInventory().clear();
/*  86 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cPikachu!");
KitAPI.setKit(p, "Pikachu");
Scoreboard.iscoriboard(p);
/*  87 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  88 */     p.getInventory().addItem(new ItemStack[] { sword });
/*  89 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.EYE_OF_ENDER) });
KitAPI.darsopa(p);
/*  94 */     pikachu.add(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPikachu(PlayerInteractEvent e)
/*     */   {
/* 100 */     final Player p = e.getPlayer();
/* 101 */     if (!pikachu.contains(p)) {
/* 102 */       return;
/*     */     }
/* 104 */     if (p.getItemInHand().getType() != Material.EYE_OF_ENDER) {
/* 105 */       return;
/*     */     }
/* 107 */     e.setCancelled(true);
/* 108 */     if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
/*     */     {
/* 110 */       if (cooldown.contains(p))
/*     */       {
/* 112 */         p.sendMessage(ChatColor.RED + "§4§lKIT §7Acalme-se!");
/* 113 */         return;
/*     */       }
/* 115 */       p.setVelocity(new Vector(0.0D, 3.0D, 0.0D));
/* 116 */       cooldown.add(p);
/* 117 */       nofall.add(p);
/* 118 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */ 
/*     */         public void run()
/*     */         {
/* 123 */           if (p.getTargetBlock(null, 50).getType() == Material.GLASS)
/*     */           {
/* 125 */             p.sendMessage(ChatColor.RED + "§4§lKIT §7Voce nao pode fazer bugs.");
/* 126 */             return;
/*     */           }
/* 128 */           World w = p.getTargetBlock(null, 50).getLocation().getWorld();
/* 129 */           double x = p.getTargetBlock(null, 50).getLocation().getX();
/* 130 */           double y = p.getTargetBlock(null, 50).getLocation().getY();
/* 131 */           double z = p.getTargetBlock(null, 50).getLocation().getZ();
/* 132 */           Location loc = new Location(w, x, y + 1.0D, z);
/* 133 */           p.teleport(loc);
/* 134 */           p.getWorld().strikeLightningEffect(loc);
/*     */         }
/* 136 */       }, 30L);
/* 137 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 141 */           Pikachu.nofall.remove(p);
/* 142 */           p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Agora pode tomar dano de queda");
/*     */         }
/* 144 */       }, 100L);
/* 145 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 149 */           Pikachu.cooldown.remove(p);
/* 150 */           p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce pode usar o Pikachu novamente!");
/*     */         }
/* 152 */       }, 600L);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void nofall(EntityDamageEvent e)
/*     */   {
/* 159 */     if ((e.getEntity() instanceof Player))
/*     */     {
/* 161 */       Player p = (Player)e.getEntity();
/* 162 */       if (!nofall.contains(p)) {
/* 163 */         return;
/*     */       }
/* 165 */       if (e.getCause() != EntityDamageEvent.DamageCause.FALL) {
/* 166 */         return;
/*     */       }
/* 168 */       e.setCancelled(true);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Pikachu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */