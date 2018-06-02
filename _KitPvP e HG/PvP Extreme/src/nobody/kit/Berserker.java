/*    */ package nobody.kit;
/*    */ 
/*    */ import nobody.eventos.KitAPI;

import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class Berserker
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void forca(PlayerDeathEvent e)
/*    */   {
/* 18 */     if ((e.getEntity().getKiller() instanceof Player))
/*    */     {
/* 20 */       Player p = e.getEntity().getKiller();
/* 21 */       if (KitAPI.getkit(p) == "Berserker") {
/* 22 */         p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 400, 0));
/* 23 */         p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 0));
/* 24 */         p.sendMessage("§7[§6§l!§7] §aVocê ganhou força e velocidade por matar um player");
/* 25 */         p.playSound(p.getLocation(), Sound.AMBIENCE_THUNDER, 1.0F, 1.0F);
/* 26 */         return;
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Berserker.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */