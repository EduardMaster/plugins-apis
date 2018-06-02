/*    */ package br.nikao.kits;
/*    */ 
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.block.BlockFace;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class Frosty implements org.bukkit.event.Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Andar(PlayerMoveEvent e)
/*    */   {
/* 18 */     Player p = e.getPlayer();
/*    */     
/* 20 */     if (((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SNOW_BLOCK) || (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.ICE)) && 
/* 21 */       (br.nikao.outros.KitAPI.getkit(p) == "Frosty")) {
/* 22 */       p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 0));
/* 23 */       p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 0));
/* 24 */       return;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Frosty.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */