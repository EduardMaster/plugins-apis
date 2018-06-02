package br.com.alpha.Habilidades;

/*  5:   */ import org.bukkit.Bukkit;
/*  6:   */ import org.bukkit.Location;
/*  7:   */ import org.bukkit.Material;
/*  9:   */ import org.bukkit.World;
/* 10:   */ import org.bukkit.block.Block;
/* 11:   */ import org.bukkit.entity.Player;
/* 12:   */ import org.bukkit.event.EventHandler;
/* 13:   */ import org.bukkit.event.EventPriority;
/* 14:   */ import org.bukkit.event.Listener;
/* 15:   */ import org.bukkit.event.block.BlockBreakEvent;

import br.com.alpha.ENUMs.KitsEnum;
/* 17:   */ 
/* 18:   */ public class Lumberjack
/* 19:   */   implements Listener
/* 20:   */ {
@SuppressWarnings("deprecation")
/* 21:   */   @EventHandler(priority=EventPriority.NORMAL)
/* 22:   */   public void onBlockBreak1(BlockBreakEvent event)
/* 23:   */   {
/* 24:22 */     Player p = event.getPlayer();
/* 25:23 */     Block b = event.getBlock();
/* 26:24 */     if ((KitsEnum.getKit(p) == KitsEnum.LUMBERJACK) && (b.getType() == Material.LOG) && (p.getItemInHand().getType() == Material.WOOD_AXE))
/* 27:   */     {
/* 28:26 */       World w = (World)Bukkit.getServer().getWorlds().get(0);
/* 29:27 */       Double y = Double.valueOf(b.getLocation().getY() + 1.0D);
/* 30:28 */       Location l = new Location(w, b.getLocation().getX(), y.doubleValue(), b.getLocation().getZ());
/* 31:29 */       while (l.getBlock().getType() == Material.LOG)
/* 32:   */       {
/* 33:31 */         l.getBlock().breakNaturally();
/* 34:32 */         y = Double.valueOf(y.doubleValue() + 1.0D);
/* 35:33 */         l.setY(y.doubleValue());
/* 36:   */       }
/* 37:35 */       while (l.getBlock().getType() == Material.getMaterial(162))
/* 38:   */       {
/* 39:37 */         l.getBlock().breakNaturally();
/* 40:38 */         y = Double.valueOf(y.doubleValue() + 1.0D);
/* 41:39 */         l.setY(y.doubleValue());
/* 42:   */       }
/* 43:   */     }
/* 44:   */   }
/* 45:   */ }


/* Location:           C:\Users\User\AppData\Local\Temp\Rar$DRa0.034\Server\plugins\HungerGames.jar
 * Qualified Name:     me.igor.KitHabilidade.Lumberjack
 * JD-Core Version:    0.7.0.1
 */