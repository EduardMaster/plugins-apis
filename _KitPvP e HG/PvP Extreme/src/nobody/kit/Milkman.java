/*    */ package nobody.kit;
/*    */ 
/*    */ import java.util.HashMap;

import nobody.eventos.KitAPI;
import nobody.main.Main;

/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerItemConsumeEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ 
/*    */ public class Milkman
/*    */   implements Listener
/*    */ {
/*    */   public static Main plugin;
/* 20 */   @SuppressWarnings({ "unchecked", "rawtypes" })
private transient HashMap<ItemStack, Integer> cooldown = new HashMap();
/* 21 */   public int maxUses = 5;
/* 22 */   public String milkbucketName = "Milkman's Bucket";
/* 23 */   public String[] potionEffects = { "REGENERATION 900 0", "FIRE_RESISTANCE 900 0", "SPEED 900 0" };
/*    */   
/*    */   @EventHandler
/*    */   public void onConsume(PlayerItemConsumeEvent event) {
/* 27 */     ItemStack item = event.getItem();
/* 28 */     Player p = event.getPlayer();
/* 29 */     if (KitAPI.getkit(p) == "Milkman") {
/*    */       String[] arrayOfString1;
/* 31 */       int j = (arrayOfString1 = this.potionEffects).length;
/* 32 */       for (int i = 0; i < j; i++) {
/* 33 */         String string = arrayOfString1[i];
/*    */         
/* 35 */         String[] effect = string.split(" ");
/* 36 */         PotionEffect potionEffect = new PotionEffect(PotionEffectType.getByName(effect[0].toUpperCase()), 
/* 37 */           Integer.parseInt(effect[1]), Integer.parseInt(effect[2]));
/* 38 */         p.addPotionEffect(potionEffect, true);
/*    */       }
/* 40 */       if (!this.cooldown.containsKey(item)) {
/* 41 */         this.cooldown.put(item, Integer.valueOf(0));
/*    */       }
/* 43 */       this.cooldown.put(item, Integer.valueOf(((Integer)this.cooldown.get(item)).intValue() + 1));
/* 44 */       if (((Integer)this.cooldown.get(item)).intValue() == this.maxUses) {
/* 45 */         this.cooldown.remove(item);
/* 46 */         event.setCancelled(true);
/* 47 */         p.setItemInHand(new ItemStack(Material.MILK_BUCKET, item.getAmount(), item.getDurability()));
/*    */       }
/*    */       else
/*    */       {
/* 51 */         event.setCancelled(true);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Milkman.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */