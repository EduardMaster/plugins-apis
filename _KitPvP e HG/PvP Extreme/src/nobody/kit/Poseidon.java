/*    */ package nobody.kit;
/*    */ 
/*    */ import nobody.eventos.KitAPI;

/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class Poseidon implements Listener
/*    */ {
/*    */   @org.bukkit.event.EventHandler
/*    */   public void onPlayerMove(PlayerMoveEvent e)
/*    */   {
/* 17 */     Player p = e.getPlayer();
/* 18 */     if ((KitAPI.getkit(p) == "Poseidon") && ((p.getLocation().getBlock().getType() == Material.WATER) || (p.getLocation().getBlock().getType() == Material.STATIONARY_WATER))) {
/* 19 */       p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 65, 0));
/* 20 */       p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 65, 0));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Poseidon.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */