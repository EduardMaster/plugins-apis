/*    */ package nobody.kit;
/*    */ 
/*    */ import java.util.HashMap;

import nobody.eventos.KitAPI;
import nobody.main.Main;

/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.event.player.PlayerToggleSneakEvent;
/*    */ 
/*    */ public class Ninja implements Listener
/*    */ {
/* 17 */   public static HashMap<String, Player> NinjaPlayer = new HashMap<String, Player>();
/* 18 */   public static HashMap<String, Integer> NinjaTime = new HashMap<String, Integer>();
/*    */   
/*    */   @EventHandler
/*    */   public void Bater(EntityDamageByEntityEvent e) {
/* 22 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
/* 23 */       final Player p = (Player)e.getDamager();
/* 24 */       Player t = (Player)e.getEntity();
/* 25 */       if (KitAPI.getkit(p) == "Ninja") {
/* 26 */         NinjaPlayer.put(p.getName(), t);
/* 27 */         NinjaTime.put(p.getName(), Integer.valueOf(10));
/* 28 */         Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*    */         {
/*    */           public void run()
/*    */           {
/* 32 */             if (((Integer)Ninja.NinjaTime.get(p.getName())).intValue() <= 0) {
/* 33 */               if ((KitAPI.getkit(p) == "Ninja") && (!KitAPI.KitDelay.containsKey(p.getName()))) {
/* 34 */                 p.sendMessage("§cVocÃª perdeu seu Player §6" + ((Player)Ninja.NinjaPlayer.get(p.getName())).getDisplayName() + " §cno Ninja");
/*    */               }
/* 36 */               Ninja.NinjaPlayer.remove(p.getName());
/*    */             }
/*    */             
/*    */           }
/* 40 */         }, 200L);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void Agaxar(PlayerToggleSneakEvent e) {
/* 47 */     final Player p = e.getPlayer();
/* 48 */     if ((!p.isSneaking()) && 
/* 49 */       (KitAPI.getkit(p) == "Ninja")) {
/* 50 */       if (!KitAPI.KitDelay.containsKey(p.getName())) {
/* 51 */         if (NinjaPlayer.containsKey(p.getName())) {
/* 52 */           Player t = (Player)NinjaPlayer.get(p.getName());
/* 53 */           if (p.getLocation().distance(t.getLocation()) <= 35.0D) {
/* 54 */             p.teleport(t);
/* 55 */             p.sendMessage("§aTeleportado, Mate-o");
/* 56 */             KitAPI.KitDelay.put(p.getName(), Integer.valueOf(10));
/* 57 */             Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*    */             {
/*    */               public void run()
/*    */               {
/* 61 */                 if ((KitAPI.KitDelay.containsKey(p.getName())) && (((Integer)KitAPI.KitDelay.get(p.getName())).intValue() <= 0) && (KitAPI.getkit(p) == "Ninja")) {
/* 62 */                   p.sendMessage("§7[§6§l!§7] §aSeu Ninja está pronto");
/* 63 */                   KitAPI.KitDelay.remove(p.getName());
/*    */                 }
/*    */               }
/* 66 */             }, 200L);
/*    */           } else {
/* 68 */             p.sendMessage("§7[§6§l!§7] §cEsse jogador está muito longe");
/*    */           }
/*    */         }
/*    */         else {
/* 72 */           p.sendMessage("§7[§6§l!§7] §cJogador não encontrado");
/*    */         }
/*    */       }
/*    */       else {
/* 76 */         p.sendMessage("§7[§6§l!§7] §cSeu ninja está carregando!");
/* 77 */         return;
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Ninja.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */