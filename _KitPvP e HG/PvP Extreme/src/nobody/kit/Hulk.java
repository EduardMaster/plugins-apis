/*    */ package nobody.kit;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.concurrent.TimeUnit;

import nobody.eventos.KitAPI;
import nobody.main.Main;

/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class Hulk
/*    */   implements Listener
/*    */ {
/*    */   public static Main plugin;
/* 21 */   @SuppressWarnings({ "unchecked", "rawtypes" })
public static HashMap<String, Long> cooldown = new HashMap();
/*    */   
/*    */   @EventHandler
/*    */   public void pegar(PlayerInteractEntityEvent e) {
/* 25 */     Player p = e.getPlayer();
/* 26 */     if ((e.getRightClicked() instanceof Player)) {
/* 27 */       Player r = (Player)e.getRightClicked();
/* 28 */       if (KitAPI.getkit(p) == "Hulk") {
/* 29 */         if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis())) {
/* 30 */           if (p.getItemInHand().getType() == Material.SADDLE) {
/* 31 */             e.setCancelled(true);
/* 32 */             p.updateInventory();
/* 33 */             p.setPassenger(r);
/* 34 */             cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(15L)));
/* 35 */             p.sendMessage("§7[§6§l!§7] §aVoce pegou o player: §c" + r.getName());
/* 36 */             r.sendMessage("§7[§6§l!§7] §cVoce foi pego pelo Hulk: §c" + p.getName());
/*    */           }
/*    */         }
/*    */         else
/* 40 */           p.sendMessage("§7[§6§l!§7] §cFaltam " + TimeUnit.MILLISECONDS.toSeconds(((Long)cooldown.get(p.getName())).longValue() - System.currentTimeMillis()) + "§csegundos para poder usar novamente.");
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public static void playerInteract(PlayerInteractEvent e) {
/* 47 */     if (!e.getAction().equals(Action.LEFT_CLICK_AIR)) {
/* 48 */       return;
/*    */     }
/* 50 */     Player player = e.getPlayer();
/* 51 */     if ((player.getPassenger() == null) || (!(player.getPassenger() instanceof Player))) {
/* 52 */       return;
/*    */     }
/* 54 */     Player pass = (Player)player.getPassenger();
/* 55 */     player.eject();
/* 56 */     pass.damage(0.0D, player);
/* 57 */     pass.setVelocity(new Vector(pass.getVelocity().getX(), 1.0D, pass.getVelocity().getZ()));
/* 58 */     pass.sendMessage("§7[§6§l!§7] §cVocê foi jogado por §c" + player.getName());
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Hulk.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */