/*    */ package br.nikao.kits;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import br.nikao.outros.KitAPI;
/*    */ import java.text.DecimalFormat;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.event.player.PlayerToggleSneakEvent;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class Ninja implements Listener
/*    */ {
/* 20 */   public HashMap<Player, Player> cooldown = new HashMap();
/* 21 */   public HashMap<Player, Long> cooldown2 = new HashMap();
/* 22 */   static List<String> cooldown3 = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void Kits(EntityDamageByEntityEvent e) {
/* 26 */     if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof Player))) {
/* 27 */       final Player p = (Player)e.getDamager();
/* 28 */       Player k = (Player)e.getEntity();
/* 29 */       if (KitAPI.getkit(p) == "Ninja") {
/* 30 */         this.cooldown.put(p, k);
/* 31 */         org.bukkit.Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
/*    */           public void run() {
/* 33 */             Ninja.cooldown3.remove(p);
/*    */           }
/* 35 */         }, 200L);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void a(PlayerToggleSneakEvent e) {
/* 42 */     Player p = e.getPlayer();
/* 43 */     if ((e.isSneaking()) && (KitAPI.getkit(p) == "Ninja") && (this.cooldown.containsKey(p))) {
/* 44 */       Player localPlayer2 = (Player)this.cooldown.get(p);
/* 45 */       if ((localPlayer2 != null) && (!localPlayer2.isDead()))
/*    */       {
/* 47 */         String str = null;
/* 48 */         if (this.cooldown2.get(p) != null)
/*    */         {
/* 50 */           long l = ((Long)this.cooldown2.get(p)).longValue() - System.currentTimeMillis();
/* 51 */           DecimalFormat localDecimalFormat = new DecimalFormat("##");
/* 52 */           int i = (int)l / 1000;
/* 53 */           str = localDecimalFormat.format(i);
/*    */         }
/* 55 */         if ((this.cooldown2.get(p) == null) || (((Long)this.cooldown2.get(p)).longValue() < System.currentTimeMillis()))
/*    */         {
/* 57 */           if (p.getLocation().distance(localPlayer2.getLocation()) < 100.0D)
/*    */           {
/* 59 */             p.teleport(localPlayer2.getLocation());
/* 60 */             p.sendMessage(ChatColor.GREEN + "Teleportado");
/* 61 */             this.cooldown2.put(p, Long.valueOf(System.currentTimeMillis() + 10000L));
/*    */           }
/*    */           else
/*    */           {
/* 65 */             p.sendMessage(ChatColor.RED + "O Ultimo jogador hitado esta muito longe!");
/*    */           }
/*    */         }
/*    */         else {
/* 69 */           p.sendMessage(ChatColor.RED + "Ninja em cooldown de " + str + " segundos!");
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Ninja.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */