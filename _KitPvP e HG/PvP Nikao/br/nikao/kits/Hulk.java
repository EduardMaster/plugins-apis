/*    */ package br.nikao.kits;
/*    */ 
/*    */ import br.nikao.outros.KitAPI;
/*    */ import java.util.HashMap;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class Hulk
/*    */   implements Listener
/*    */ {
/* 19 */   public static HashMap<String, Long> cooldown = new HashMap();
/*    */   
/*    */   @EventHandler
/*    */   public void pegar(PlayerInteractEntityEvent e) {
/* 23 */     Player p = e.getPlayer();
/* 24 */     if ((e.getRightClicked() instanceof Player)) {
/* 25 */       Player r = (Player)e.getRightClicked();
/* 26 */       if ((KitAPI.getkit(p) == "Hulk") && (p.getItemInHand().getType() == Material.SADDLE))
/* 27 */         if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis())) {
/* 28 */           e.setCancelled(true);
/* 29 */           p.updateInventory();
/* 30 */           p.setPassenger(r);
/* 31 */           cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(15L)));
/* 32 */           p.sendMessage("§6§lUau parece que você pegou um otario");
/* 33 */           r.sendMessage("§c§lCuidado você foi pego por um hulk");
/*    */         } else {
/* 35 */           p.sendMessage("§cFaltam " + TimeUnit.MILLISECONDS.toSeconds(((Long)cooldown.get(p.getName())).longValue() - System.currentTimeMillis()) + " §csegundos para poder usar novamente.");
/*    */         }
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/* 41 */   public static void playerInteract(PlayerInteractEvent e) { if (!e.getAction().equals(Action.LEFT_CLICK_AIR)) {
/* 42 */       return;
/*    */     }
/* 44 */     Player player = e.getPlayer();
/* 45 */     if ((player.getPassenger() == null) || (!(player.getPassenger() instanceof Player))) {
/* 46 */       return;
/*    */     }
/* 48 */     Player pass = (Player)player.getPassenger();
/* 49 */     player.eject();
/* 50 */     pass.damage(0.0D, player);
/* 51 */     pass.setVelocity(new Vector(pass.getVelocity().getX(), 1.0D, pass.getVelocity().getZ() + 2.0D));
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Hulk.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */