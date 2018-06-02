/*    */ package br.nikao.kits;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import br.nikao.outros.KitAPI;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Random;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class Monk implements Listener
/*    */ {
/* 19 */   public static ArrayList<String> cooldown = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void Interagir(PlayerInteractEntityEvent e) {
/* 23 */     if ((e.getRightClicked() instanceof Player)) {
/* 24 */       final Player p = e.getPlayer();
/* 25 */       if ((KitAPI.getkit(p) == "Monk") && (p.getItemInHand().getType() == Material.BLAZE_ROD)) {
/* 26 */         if (cooldown.contains(p.getName())) {
/* 27 */           p.sendMessage("§cAguarde o cooldown acabar");
/* 28 */           return;
/*    */         }
/* 30 */         Player t = (Player)e.getRightClicked();
/* 31 */         int i = new Random().nextInt(36);
/* 32 */         ItemStack i1 = t.getInventory().getItem(i);
/* 33 */         ItemStack i2 = t.getItemInHand();
/* 34 */         t.setItemInHand(i1);
/* 35 */         t.getInventory().setItem(i, i2);
/* 36 */         p.sendMessage("§aVocê misturou o inventario de §b" + t.getDisplayName());
/* 37 */         t.sendMessage("§cSeu inventario foi misturado por §b" + p.getDisplayName());
/* 38 */         cooldown.add(p.getName());
/* 39 */         Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
/*    */         {
/*    */           public void run()
/*    */           {
/* 43 */             if ((KitAPI.getkit(p) == "Monk") && (Monk.cooldown.contains(p.getName()))) {
/* 44 */               Monk.cooldown.remove(p.getName());
/* 45 */               p.sendMessage("§aSeu monk está pronto");
/*    */             }
/*    */             
/*    */           }
/* 49 */         }, 200L);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Monk.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */