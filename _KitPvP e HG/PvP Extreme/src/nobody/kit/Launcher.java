/*    */ package nobody.kit;
/*    */ 
/*    */ import nobody.eventos.KitAPI;

import org.bukkit.craftbukkit.Main;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerFishEvent;
/*    */ 
/*    */ public class Launcher implements Listener
/*    */ {
/*    */   public static Main plugin;
/* 14 */   public long cooldownLenght = 0L;
/*    */   
/*    */   @EventHandler
/*    */   public void Pescar(PlayerFishEvent e) {
/* 18 */     Player p = e.getPlayer();
/* 19 */     if (((e.getCaught() instanceof Player)) && (KitAPI.getkit(p) == "Launcher")) {
/* 20 */       Player t = (Player)e.getCaught();
/* 21 */       if (hasCooldown()) {
/* 22 */         p.sendMessage("§7[§6§l!§7] §cFaltam " + cooldownTimeRemaining() + " para o cooldown acabar!");
/* 23 */         return;
/*    */       }
/* 25 */       t.setVelocity(t.getVelocity().setY(4.0D));
/* 26 */       addCooldown(p, 30);
/*    */     }
/*    */   }
/*    */   
/*    */   public void addCooldown(Player player, int seconds) {
/* 31 */     this.cooldownLenght = (System.currentTimeMillis() + seconds * 1000);
/*    */   }
/*    */   
/*    */   public String cooldownTimeRemaining() {
/* 35 */     long faltam = (this.cooldownLenght - System.currentTimeMillis()) / 1000L;
/* 36 */     if (faltam < 60L) {
/* 37 */       return faltam + " segundos restantes";
/*    */     }
/* 39 */     return faltam + " minutos restantes";
/*    */   }
/*    */   
/*    */   public boolean hasCooldown() {
/* 43 */     return this.cooldownLenght > System.currentTimeMillis();
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Launcher.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */