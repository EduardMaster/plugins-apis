/*     */ package neero.demon.kits;
/*     */ 
/*     */ import java.util.ArrayList;

import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;

/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Turtle
/*     */   implements Listener, CommandExecutor
/*     */ {
/*  26 */   public static ArrayList<Player> turtle = new ArrayList();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  30 */     Player p = e.getEntity();
/*     */     
/*  32 */     turtle.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  36 */   public void ent(PlayerJoinEvent e) { Player p = e.getPlayer();
/*     */     
/*  38 */     turtle.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  43 */     Player jogador = (Player)sender;
/*  44 */     if (label.equalsIgnoreCase("turtle")) {
/*  45 */       if (jogador.hasPermission("kit.turtle"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit(jogador) == ("Nenhum")))
/*     */         {
/*  49 */           jogador.sendMessage("§4§lKIT §7Voce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  53 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  58 */         jogador.sendMessage(ChatColor.RED + "§4§lKIT §cVoce nao possue este kit !");
/*     */       }
/*     */     }
/*  61 */     return false;
/*     */   }
/*     */   
/*     */   public void giveKit(Player p)
/*     */   {
/*  66 */     p.getInventory().clear();
/*  67 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu §cTurtle!");
KitAPI.setKit(p, "Turtle");
Scoreboard.iscoriboard(p);
/*  68 */     ItemStack sword = new ItemStack(Material.STONE_SWORD);
/*  69 */     p.getInventory().addItem(new ItemStack[] { sword });
KitAPI.darsopa(p);
/*  74 */     turtle.add(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onTurtleDamage(EntityDamageEvent e)
/*     */   {
/*  80 */     Entity p = e.getEntity();
/*  81 */     if (!turtle.contains(p)) {
/*  82 */       return;
/*     */     }
/*  84 */     if (!(p instanceof Player)) {
/*  85 */       return;
/*     */     }
/*  87 */     if (!((Player)p).isSneaking()) {
/*  88 */       return;
/*     */     }
/*  90 */     e.setDamage(1.0D);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onTurtleHit(EntityDamageByEntityEvent e)
/*     */   {
/*  96 */     if (!(e.getDamager() instanceof Player)) {
/*  97 */       return;
/*     */     }
/*  99 */     if (!(e.getEntity() instanceof Player)) {
/* 100 */       return;
/*     */     }
/* 102 */     if (!turtle.contains(e.getDamager())) {
/* 103 */       return;
/*     */     }
/* 105 */     Player p = (Player)e.getDamager();
/* 106 */     if (!p.isSneaking()) {
/* 107 */       return;
/*     */     }
/* 109 */     e.setCancelled(true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\Turtle.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */