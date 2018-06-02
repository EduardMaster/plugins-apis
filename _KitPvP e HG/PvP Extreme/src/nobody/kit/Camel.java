/*    */ package nobody.kit;
/*    */ 
/*    */ import nobody.eventos.KitAPI;

/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.block.BlockFace;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class Camel implements org.bukkit.event.Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Andar(PlayerMoveEvent e)
/*    */   {
/* 18 */     Player p = e.getPlayer();
/*    */     
/* 20 */     if (((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SAND) || (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SANDSTONE)) && 
/* 21 */       (KitAPI.getkit(p) == "Camel")) {
/* 22 */       p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 0));
/* 23 */       p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 0));
/* 24 */       return;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Camel.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */