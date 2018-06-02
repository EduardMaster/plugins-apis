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
/*     */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ public class Hulk
/*     */   implements Listener, CommandExecutor
/*     */ {
/*     */   public Main plugin;
/*     */   
/*     */   public Hulk(Main plugin)
/*     */   {
/*  36 */     this.plugin = plugin;
/*     */   }
/*     */   
/*  39 */   public static ArrayList<Player> hulk = new ArrayList();
/*  40 */   public static ArrayList<Player> cooldown = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  44 */     Player p = e.getEntity();
/*     */     
/*  46 */     hulk.remove(p);
/*  47 */     cooldown.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  51 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  53 */     hulk.remove(p);
/*  54 */     cooldown.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  59 */     Player jogador = (Player)sender;
/*  60 */     if (label.equalsIgnoreCase("hulk")) {
/*  61 */       if (jogador.hasPermission("kit.hulk"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  65 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  69 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  74 */         jogador.sendMessage(ChatColor.RED + "Voce nao possue este kit !");
/*     */       }
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public static void giveKit(Player p)
/*     */   {
/*  82 */     p.getInventory().clear();
/*  83 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cHulk!");
KitAPI.setKit(p, "Hulk");
Scoreboard.iscoriboard(p);
/*  84 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  85 */     p.getInventory().addItem(new ItemStack[] { sword });
KitAPI.darsopa(p);
/*  90 */     hulk.add(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerDamage(EntityDamageByEntityEvent e)
/*     */   {
/*  96 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
/*     */     {
/*  98 */       Player p = (Player)e.getEntity();
/*  99 */       Player d = (Player)e.getDamager();
/* 100 */       if ((hulk.contains(d)) && (p == d.getPassenger()))
/*     */       {
/* 102 */         e.setCancelled(true);
/* 103 */         d.damage(1.0D, p);
/* 104 */         d.sendMessage(ChatColor.RED + "§4§lKIT §7Bata no seu passageiro com o botao esquerdo!");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onThrow(PlayerInteractEvent e)
/*     */   {
/* 112 */     Player p = e.getPlayer();
/* 113 */     if (!hulk.contains(p)) {
/* 114 */       return;
/*     */     }
/* 116 */     if (p.getPassenger() == null) {
/* 117 */       return;
/*     */     }
/* 119 */     if (p.getItemInHand().getType() != Material.AIR) {
/* 120 */       return;
/*     */     }
/* 122 */     if ((e.getAction() != Action.LEFT_CLICK_AIR) && (e.getAction() != Action.LEFT_CLICK_BLOCK)) {
/* 123 */       return;
/*     */     }
/* 125 */     Entity hulked = p.getPassenger();
/* 126 */     hulked.getVehicle().eject();
/* 127 */     Location loc = p.getLocation();
/* 128 */     loc.setY(loc.getY() + 2.0D);
/* 129 */     hulked.teleport(loc);
/* 130 */     hulked.setVelocity(p.getEyeLocation().getDirection().multiply(2.0D));
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void PickUpPlayer(PlayerInteractEntityEvent e)
/*     */   {
/* 136 */     if (!hulk.contains(e.getPlayer())) {
/* 137 */       return;
/*     */     }
/* 139 */     if ((e.getRightClicked() instanceof Player))
/*     */     {
/* 141 */       final Player p = e.getPlayer();
/* 142 */       Player r = (Player)e.getRightClicked();
/* 143 */       if (p.getItemInHand().getType() != Material.AIR) {
/* 144 */         return;
/*     */       }
/* 146 */       if (p.getPassenger() != null) {
/* 147 */         return;
/*     */       }
/* 149 */       if (r.getPassenger() != null) {
/* 150 */         return;
/*     */       }
/* 152 */       if (hulk.contains(r))
/*     */       {
/* 154 */         p.sendMessage(ChatColor.RED + "§4§lKIT §7Ja tem alguem , espere ele sair!");
/* 155 */         return;
/*     */       }
/* 157 */       if (cooldown.contains(p))
/*     */       {
/* 159 */         p.sendMessage(ChatColor.RED + "§4§lKIT §7Calma hulkzao!");
/* 160 */         return;
/*     */       }
/* 162 */       cooldown.add(p);
/* 163 */       p.setPassenger(r);
/* 164 */       r.sendMessage(ChatColor.RED + "§4§lKIT §7Um hulk te prendeu , aperte shift para fugir!");
/* 165 */       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 169 */           Hulk.cooldown.remove(p);
/*     */         }
/* 171 */       }, 60L);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Hulk.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */