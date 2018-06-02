/*    */ package br.nikao.kits;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import br.nikao.outros.AntiMoveAPI;
/*    */ import br.nikao.outros.KitAPI;
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class Timelord
/*    */   implements Listener
/*    */ {
/* 20 */   public static ArrayList<String> cooldown = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void Clicar(PlayerInteractEvent e) {
/* 24 */     final Player p = e.getPlayer();
/* 25 */     if ((KitAPI.getkit(p) == "Timelord") && (e.getMaterial() == Material.WATCH)) {
/* 26 */       if (cooldown.contains(p.getName())) {
/* 27 */         p.sendMessage("§cAguarde o cooldown");
/* 28 */         return;
/*    */       }
/* 30 */       cooldown.add(p.getName());
/* 31 */       p.sendMessage("§aVocê congelou todos os Jogadores perto de você");
/* 32 */       p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
/* 33 */       p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
/* 34 */       for (Entity ent : p.getNearbyEntities(5.0D, 3.0D, 5.0D)) {
/* 35 */         if ((ent instanceof Player)) {
/* 36 */           final Player t = (Player)ent;
/* 37 */           AntiMoveAPI.AntiMove1.add(t.getName());
/* 38 */           t.sendMessage("§cVocê foi congelado por um timelord");
/* 39 */           t.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
/* 40 */           p.sendMessage("§aVocê congelou §c" + t.getDisplayName());
/* 41 */           Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*    */           {
/*    */             public void run()
/*    */             {
/* 45 */               if (AntiMoveAPI.AntiMove1.contains(t.getName())) {
/* 46 */                 AntiMoveAPI.AntiMove1.remove(t.getName());
/* 47 */                 t.sendMessage("§aVocê foi descongelado");
/*    */               }
/*    */               
/*    */             }
/* 51 */           }, 140L);
/*    */         }
/*    */       }
/* 54 */       Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*    */       {
/*    */         public void run()
/*    */         {
/* 58 */           if (KitAPI.getkit(p) == "Timelord") {
/* 59 */             p.sendMessage("§aSeu timelord está pronto !");
/* 60 */             Timelord.cooldown.remove(p.getName());
/*    */           }
/*    */         }
/* 63 */       }, 600L);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Timelord.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */