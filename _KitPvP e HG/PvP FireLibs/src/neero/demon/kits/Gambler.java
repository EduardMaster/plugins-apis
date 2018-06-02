/*     */ package neero.demon.kits;
/*     */ 
/*     */ /*     */ import java.util.ArrayList;
/*     */ import java.util.Random;

import neero.demon.Main;
import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
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
/*     */ 
/*     */ public class Gambler
/*     */   implements Listener, CommandExecutor
/*     */ {
/*     */   public Main plugin;
/*     */   
/*     */   public Gambler(Main plugin)
/*     */   {
/*  35 */     this.plugin = plugin;
/*     */   }
/*     */   
/*  38 */   public static ArrayList<Player> gambler = new ArrayList();
/*  39 */   public static ArrayList<Player> cooldown = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  43 */     Player p = e.getEntity();
/*     */     
/*  45 */     gambler.remove(p);
/*  46 */     cooldown.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  50 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  52 */     gambler.remove(p);
/*  53 */     cooldown.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  58 */     Player jogador = (Player)sender;
/*  59 */     if (label.equalsIgnoreCase("gambler")) {
/*  60 */       if (jogador.hasPermission("kit.gambler"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
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
/*     */   public void giveKit(Player p)
/*     */   {
/*  81 */     p.getInventory().clear();
/*  82 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cGambler!");
KitAPI.setKit(p, "Gambler");
Scoreboard.iscoriboard(p);
/*  83 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  84 */     p.getInventory().addItem(new ItemStack[] { sword });
/*  85 */     p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_BUTTON) });
KitAPI.darsopa(p);
/*  90 */     gambler.add(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerInteracts(PlayerInteractEvent e)
/*     */   {
/*  96 */     final Player p = e.getPlayer();
/*  97 */     if (p.getItemInHand().getType() != Material.STONE_BUTTON) {
/*  98 */       return;
/*     */     }
/* 100 */     if (!gambler.contains(e.getPlayer())) {
/* 101 */       return;
/*     */     }
/* 103 */     if (cooldown.contains(p))
/*     */     {
/* 105 */       p.sendMessage(ChatColor.RED + "Nao pode sortear ainda!");
/* 106 */       return;
/*     */     }
/* 108 */     if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
/*     */     {
/* 110 */       cooldown.add(p);
/* 111 */       Random r = new Random();
/* 112 */       int rand = r.nextInt(100000);
/* 113 */       if (rand == 100000)
/*     */       {
/* 115 */         p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
/* 116 */         p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
/* 117 */         p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
/* 118 */         p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
/* 119 */         p.getInventory().setItem(0, new ItemStack(Material.IRON_SWORD));
/* 120 */         p.sendMessage(ChatColor.GOLD + "§4§lKIT §7Voce ganhou FULL COURO!!!");
/*     */       }
/* 122 */       else if (rand == 99999)
/*     */       {
/* 124 */         p.damage(1.0E7D);
/* 125 */         p.sendMessage(ChatColor.RED + "§4§lKIT §7Voce ganhou A MORTE!!!");
/*     */       }
/* 127 */       else if (rand > 89999)
/*     */       {
/* 129 */         p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600, 0));
/* 130 */         p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce ganhou FORÇA!!!");
/*     */       }
/* 132 */       else if (rand > 79999)
/*     */       {
/* 134 */         p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 600, 0));
/* 135 */         p.sendMessage(ChatColor.RED + "§4§lKIT §7Voce ganhou FRAQUEZA!!!");
/*     */       }
/* 137 */       else if (rand > 69999)
/*     */       {
/* 139 */         p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 0));
/* 140 */         p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce ganhou VELOCIDADE!!!");
/*     */       }
/* 142 */       else if (rand > 59999)
/*     */       {
/* 144 */         p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 600, 0));
/* 145 */         p.sendMessage(ChatColor.RED + "§4§lKIT §7Voce ganhou LENTIDAO!!!");
/*     */       }
/* 147 */       else if (rand > 49999)
/*     */       {
/* 149 */         p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 600, 0));
/* 150 */         p.sendMessage(ChatColor.GREEN + "Voce ganhou REGENERACAO!!!");
/*     */       }
/* 152 */       else if (rand > 39999)
/*     */       {
/* 154 */         p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 600, 0));
/* 155 */         p.sendMessage(ChatColor.RED + "Voce ganhou POSION!!!");
/*     */       }
/* 157 */       else if (rand > 29999)
/*     */       {
/* 159 */         p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 600, 0));
/* 160 */         p.sendMessage(ChatColor.GREEN + "Voce ganhou BOOST DE VIDA!!!");
/*     */       }
/* 162 */       else if (rand > 19999)
/*     */       {
/* 164 */         p.damage(8.5D);
/* 165 */         p.sendMessage(ChatColor.RED + "Voce ganhou DANO INSTANTANEO!!!");
/*     */       }
/* 167 */       else if (rand > 9999)
/*     */       {
/* 169 */         p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 600, 0));
/* 170 */         p.sendMessage(ChatColor.RED + "Voce ganhou CONFUSAO!!!");
/*     */       }
/*     */       else
/*     */       {
/* 174 */         p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600, 0));
/* 175 */         p.sendMessage(ChatColor.RED + "Voce ganhou RESISTENCIA!!!");
/*     */       }
/* 177 */       Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 181 */           Gambler.cooldown.remove(p);
/* 182 */           p.sendMessage(ChatColor.GREEN + "Pode sortear novamente!");
/*     */         }
/* 184 */       }, 600L);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Gambler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */