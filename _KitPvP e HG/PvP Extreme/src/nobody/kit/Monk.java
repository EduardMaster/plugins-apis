/*    */ package nobody.kit;
/*    */ import java.util.Random;

import nobody.eventos.KitAPI;
import nobody.main.Main;

/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class Monk implements org.bukkit.event.Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void Interagir(PlayerInteractEntityEvent e)
/*    */   {
/* 20 */     if ((e.getRightClicked() instanceof Player)) {
/* 21 */       final Player p = e.getPlayer();
/* 22 */       if ((KitAPI.getkit(p) == "Monk") && (p.getItemInHand().getType() == Material.BLAZE_ROD)) {
/* 23 */         Player t = (Player)e.getRightClicked();
/* 24 */         if (!KitAPI.KitDelay.containsKey(p.getName())) {
/* 25 */           int i = new Random().nextInt(36);
/* 26 */           ItemStack i1 = t.getInventory().getItem(i);
/* 27 */           ItemStack i2 = t.getItemInHand();
/* 28 */           t.setItemInHand(i1);
/* 29 */           t.getInventory().setItem(i, i2);
/* 30 */           p.sendMessage("§7[§6§l!§7] §aVocê misturou o inventario de §b" + t.getDisplayName());
/* 31 */           t.sendMessage("§7[§6§l!§7] §cSeu inventario foi misturado por §b" + p.getDisplayName());
/* 32 */           KitAPI.KitDelay.put(p.getName(), Integer.valueOf(10));
/* 33 */           org.bukkit.Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
/*    */           {
/*    */             public void run()
/*    */             {
/* 37 */               if ((KitAPI.KitDelay.containsKey(p.getName())) && (KitAPI.getkit(p) == "Monk") && (((Integer)KitAPI.KitDelay.get(p.getName())).intValue() <= 0)) {
/* 38 */                 KitAPI.KitDelay.remove(p.getName());
/* 39 */                 p.sendMessage("§7[§6§l!§7] §aSeu monk está pronto");
/*    */               }
/*    */               
/*    */             }
/* 43 */           }, 199L);
/*    */         } else {
/* 45 */           p.sendMessage("§7[§6§l!§7] §cMonk em cooldown aguarde §f" + KitAPI.KitDelay.get(p.getName()) + " §csegundos para usar");
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Monk.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */