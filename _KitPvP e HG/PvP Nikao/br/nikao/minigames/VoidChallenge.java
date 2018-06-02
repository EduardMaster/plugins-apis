/*    */ package br.nikao.minigames;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class VoidChallenge implements Listener
/*    */ {
/* 17 */   public static ArrayList<String> voidchallenge = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void CairVoid(EntityDamageEvent e) {
/* 21 */     if ((e.getEntity() instanceof Player)) {
/* 22 */       final Player p = (Player)e.getEntity();
/* 23 */       if ((e.getCause() == EntityDamageEvent.DamageCause.VOID) && 
/* 24 */         (voidchallenge.contains(p.getName()))) {
/* 25 */         Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*    */         {
/*    */           public void run()
/*    */           {
/* 29 */             int xp = p.getLevel();
/* 30 */             p.setLevel(xp + 1);
/*    */           }
/*    */           
/* 33 */         }, 20L);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   @EventHandler
/*    */   public void MorrerVoid(PlayerDeathEvent e)
/*    */   {
/* 42 */     Player p = e.getEntity();
/* 43 */     int record = Main.getInstance().getConfig().getInt("Status." + p.getName() + ".VC", Integer.valueOf(0).intValue());
/* 44 */     if (voidchallenge.contains(p.getName())) {
/* 45 */       p.sendMessage("§7§lVocê conseguiu ficar §f" + p.getLevel() + " segundos §7§lno VoidChallenge");
/* 46 */       if (p.getLevel() > record) {
/* 47 */         Main.getInstance().getConfig().set("Status." + p.getName() + ".VC", Integer.valueOf(p.getLevel()));
/* 48 */         Main.getInstance().saveConfig();
/*    */       }
/* 50 */       p.setExp(0.0F);
/* 51 */       p.getInventory().clear();
/* 52 */       voidchallenge.remove(p.getName());
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\minigames\VoidChallenge.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */