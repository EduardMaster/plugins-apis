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
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ 
/*     */ public class Assassin
/*     */   implements Listener, CommandExecutor
/*     */ {
/*     */   public Main plugin;
/*     */   
/*     */   public Assassin(Main plugin)
/*     */   {
/*  34 */     this.plugin = plugin;
/*     */   }
/*     */   
/*  37 */   public static ArrayList<Player> assassin = new ArrayList();
/*  38 */   public static ArrayList<Player> cooldown = new ArrayList();
/*  39 */   public static ArrayList<Player> vulnrable = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  43 */     Player p = e.getEntity();
/*     */     
/*  45 */     assassin.remove(p);
/*  46 */     cooldown.remove(p);
/*  47 */     vulnrable.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  51 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  53 */     assassin.remove(p);
/*  54 */     cooldown.remove(p);
/*  55 */     vulnrable.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  60 */     Player jogador = (Player)sender;
/*  61 */     if (label.equalsIgnoreCase("assassin")) {
/*  62 */       if (jogador.hasPermission("kit.assassin"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  66 */           jogador.sendMessage("§c§l§oVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  70 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  75 */         jogador.sendMessage(ChatColor.RED + "Voce nao possue este kit !");
/*     */       }
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public void giveKit(Player p)
/*     */   {
/*  83 */     p.getInventory().clear();
/*  84 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cAssassin!");
Scoreboard.iscoriboard(p);
KitAPI.setKit(p, "Assassin");
/*  85 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  86 */     p.getInventory().addItem(new ItemStack[] { sword });
/*  87 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.REDSTONE) });
KitAPI.darsopa(p);
/*  92 */     assassin.add(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerInteracts(final PlayerInteractEvent e)
/*     */   {
/*  98 */     if (e.getAction() != Action.RIGHT_CLICK_AIR) {
/*  99 */       return;
/*     */     }
/* 101 */     if (e.getPlayer().getItemInHand().getType() != Material.REDSTONE) {
/* 102 */       return;
/*     */     }
/* 104 */     if (!assassin.contains(e.getPlayer())) {
/* 105 */       return;
/*     */     }
/* 107 */     if (cooldown.contains(e.getPlayer()))
/*     */     {
/* 109 */       e.getPlayer().sendMessage(ChatColor.RED + "§4§lKIT §7Voce nao pode assassinar agora!");
/* 110 */       return;
/*     */     }
/* 112 */     e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 35, 2));
/* 113 */     e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 35, 2));
/* 114 */     cooldown.add(e.getPlayer());
/* 115 */     e.getPlayer().sendMessage(ChatColor.DARK_RED + "§4§lKIT §7Hora do assassinato!");
/* 116 */     Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 120 */         e.getPlayer().sendMessage(ChatColor.RED + "§4§lKIT §7Voce nao esta dando muito dano , corra!");
/* 121 */         e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, -8));
/*     */       }
/* 123 */     }, 30L);
/* 124 */     Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 128 */         e.getPlayer().sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce ficou vulneravel, cuidado!");
/*     */       }
/* 130 */     }, 100L);
/* 131 */     Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 135 */         e.getPlayer().sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce pode assassinar sem ser pego novamente, Vai em frente!");
/* 136 */         Assassin.cooldown.remove(e.getPlayer());
/*     */       }
/* 138 */     }, 900L);
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Assassin.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */