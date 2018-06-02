/*     */ package neero.demon.kits;
/*     */ 
/*     */ /*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;

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
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ public class Achilles
/*     */   implements Listener, CommandExecutor
/*     */ {
/*     */   public Main plugin;
/*     */   
/*     */   public Achilles(Main plugin)
/*     */   {
/*  33 */     this.plugin = plugin;
/*     */   }
/*     */   
/*  36 */   public static ArrayList<Player> achilles = new ArrayList<Player>();
/*  37 */   public static HashMap<Player, Player> hit = new HashMap<Player, Player>();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  41 */     Player p = e.getEntity();
/*     */     
/*  43 */     achilles.remove(p);
/*  44 */     hit.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void ent(PlayerJoinEvent e) {
/*  49 */     Player p = e.getPlayer();
/*     */     
/*  51 */     achilles.remove(p);
/*  52 */     hit.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  57 */     Player jogador = (Player)sender;
/*  58 */     if (label.equalsIgnoreCase("achilles")) {
/*  59 */       if (jogador.hasPermission("kit.achilles"))
/*     */       {
/*  61 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  63 */           jogador.sendMessage("§4§lKIT §7Voce escolheu §cVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  67 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  72 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT Voce nao possue este kit !");
/*     */       }
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public static void giveKit(Player p)
/*     */   {
/*  80 */     p.getInventory().clear();
/*  81 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cAchilles!");
Scoreboard.iscoriboard(p);
			KitAPI.setKit(p, "Achilles");
/*  82 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  83 */     p.getInventory().addItem(new ItemStack[] { sword });
				KitAPI.darsopa(p);
/*  88 */     achilles.add(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void damage(EntityDamageEvent e)
/*     */   {
/*  94 */     if ((e.getEntity() instanceof Player))
/*     */     {
/*  96 */       if (!achilles.contains(e.getEntity())) {
/*  97 */         return;
/*     */       }
/*  99 */       if (e.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
/* 100 */         e.setDamage(e.getDamage() / 2.0D);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onachillesDamage(EntityDamageByEntityEvent e)
/*     */   {
/* 108 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
/*     */     {
/* 110 */       final Player p = (Player)e.getEntity();
/* 111 */       final Player d = (Player)e.getDamager();
/* 112 */       if (achilles.contains(p)) {
/* 113 */         if (d.isSneaking())
/*     */         {
/* 115 */           e.setDamage(e.getDamage() * 1.0D);
/*     */         }
/*     */         else
/*     */         {
/* 119 */           e.setDamage(e.getDamage() / 2.0D);
/* 120 */           if ((hit.get(d) == null) || (hit.get(d) != p))
/*     */           {
/* 122 */             hit.put(d, p);
/* 123 */             d.sendMessage(ChatColor.RED + "§4§lKIT §7Ele é um achilles , agaiche para dar mais dano nele.");
/* 124 */             Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
/*     */             {
/*     */               public void run()
/*     */               {
/* 128 */                 if (Achilles.hit.get(d) == p) {
/* 129 */                   Achilles.hit.remove(d);
/*     */                 }
/*     */               }
/* 132 */             }, 200L);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Achilles.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */