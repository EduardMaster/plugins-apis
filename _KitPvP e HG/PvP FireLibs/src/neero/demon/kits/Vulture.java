/*     */ package neero.demon.kits;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;

import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;

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
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Vulture
/*     */   implements Listener, CommandExecutor
/*     */ {
/*  25 */   public static ArrayList<Player> vulture = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  29 */     Player p = e.getEntity();
/*     */     
/*  31 */     vulture.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  35 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  37 */     vulture.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  42 */     Player jogador = (Player)sender;
/*  43 */     if (label.equalsIgnoreCase("vulture")) {
/*  44 */       if (jogador.hasPermission("kit.vulture"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  48 */           jogador.sendMessage("§4§lKIT §cVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  52 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  57 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*     */       }
/*     */     }
/*  60 */     return false;
/*     */   }
/*     */   
/*     */   public static void giveKit(Player p)
/*     */   {
/*  65 */     p.getInventory().clear();
/*  66 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cVulture!");
Scoreboard.iscoriboard(p);
KitAPI.setKit(p, "Vulture");
/*  67 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  68 */     p.getInventory().addItem(new ItemStack[] { sword });
KitAPI.darsopa(p);
/*  73 */     vulture.add(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onEntityDamage(EntityDamageByEntityEvent e)
/*     */   {
/*  79 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
/*     */     {
/*  81 */       Player p = (Player)e.getEntity();
/*  82 */       Player d = (Player)e.getDamager();
/*  83 */       if (!vulture.contains(d)) {
/*  84 */         return;
/*     */       }
/*  86 */       Random r = new Random();
/*  87 */       int rand = r.nextInt(100);
/*  88 */       if (rand <= 15)
/*     */       {
/*  90 */         boolean lostsoup = false;
/*  91 */         ItemStack[] item = p.getInventory().getContents();
/*  92 */         for (int slot = 0; slot < 36; slot++)
/*     */         {
/*  94 */           ItemStack soup = item[slot];
/*  95 */           if ((!lostsoup) && (soup != null) && (soup.isSimilar(new ItemStack(Material.MUSHROOM_SOUP))))
/*     */           {
/*  97 */             lostsoup = true;
/*  98 */             p.getInventory().setItem(slot, new ItemStack(Material.AIR));
/*     */           }
/*     */         }
/* 101 */         d.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
/* 102 */         p.sendMessage(ChatColor.RED + "§4§lKIT §7Ei , este cara roubou minha sopa!");
/* 103 */         d.sendMessage(ChatColor.GREEN + "§4§lKIT §7Peguei uma sopa , eZ.");
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Vulture.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */