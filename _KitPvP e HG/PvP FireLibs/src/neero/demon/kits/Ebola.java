/*     */ package neero.demon.kits;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;

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
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Ebola
/*     */   implements Listener, CommandExecutor
/*     */ {
/*  28 */   public static ArrayList<Player> infected = new ArrayList();
/*  29 */   public static ArrayList<Player> infection = new ArrayList();
/*  30 */   public static HashMap<Player, Player> infector = new HashMap();
/*     */   
/*     */   @EventHandler
/*     */   public void death(PlayerDeathEvent e) {
/*  34 */     Player p = e.getEntity();
/*     */     
/*  36 */     if (infection.contains(p.getName())) {
/*  37 */       Bukkit.broadcastMessage("test");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e)
/*     */   {
/*  45 */     Player p = e.getEntity();
/*     */     
/*  47 */     infected.remove(p);
/*  48 */     infection.remove(p);
/*  49 */     infector.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  53 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  55 */     infection.remove(p);
/*  56 */     infected.remove(p);
/*  57 */     infector.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  62 */     Player jogador = (Player)sender;
/*  63 */     if (label.equalsIgnoreCase("ebola")) {
/*  64 */       if (jogador.hasPermission("kit.ebola"))
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
/*  86 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cEbola!");
KitAPI.setKit(p, "Ebola");
Scoreboard.iscoriboard(p);
/*  87 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  88 */     p.getInventory().addItem(new ItemStack[] { sword });
KitAPI.darsopa(p);
/*  93 */     infected.add(p);
/*  94 */     infection.add(p);
/*  95 */     p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 199980, 0));
/*  96 */     p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 199980, 0));
/*  97 */     p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 199980, 0));
/*  98 */     infector.put(p, null);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onInfect(EntityDamageByEntityEvent e)
/*     */   {
/* 104 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
/*     */     {
/* 106 */       Player p = (Player)e.getEntity();
/* 107 */       Player d = (Player)e.getDamager();
/* 108 */       if (!infection.contains(d)) {
/* 109 */         return;
/*     */       }
/* 111 */       if (infector.get(d) == p) {
/* 112 */         return;
/*     */       }
/* 114 */       infector.put(p, d);
/* 115 */       infection.remove(d);
/* 116 */       d.removePotionEffect(PotionEffectType.POISON);
/* 117 */       d.removePotionEffect(PotionEffectType.SLOW);
/* 118 */       d.removePotionEffect(PotionEffectType.CONFUSION);
/* 119 */       p.removePotionEffect(PotionEffectType.POISON);
/* 120 */       p.removePotionEffect(PotionEffectType.SLOW);
/* 121 */       p.removePotionEffect(PotionEffectType.CONFUSION);
/* 122 */       d.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce transmitiu a doença...");
/* 123 */       p.sendMessage(ChatColor.DARK_GREEN + "§4§lKIT §7Voce foi enfectado por ebola , hite alguem para escapar dela e transmiti-la!");
/* 124 */       p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 199980, 0));
/* 125 */       p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 199980, 0));
/* 126 */       p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 199980, 0));
/* 127 */       infection.add(p);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Ebola.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */