/*    */ package br.nikao.kits;
/*    */ 
/*    */ import br.nikao.Main;
/*    */ import br.nikao.outros.KitAPI;
/*    */ import java.util.HashMap;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.entity.Snowball;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.metadata.FixedMetadataValue;
/*    */ import org.bukkit.util.BlockIterator;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class Ryu implements Listener
/*    */ {
/* 25 */   public static HashMap<String, Long> cooldown = new HashMap();
/*    */   
/*    */   @EventHandler
/*    */   public void hadouken(PlayerInteractEvent e)
/*    */   {
/* 30 */     Player p = e.getPlayer();
/* 31 */     if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
/* 32 */       (KitAPI.getkit(p) == "Ryu") && (p.getItemInHand().getType() == Material.BEACON)) {
/* 33 */       if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis())) {
/* 34 */         p.sendMessage("§b§lHadouken");
/* 35 */         e.setCancelled(true);
/* 36 */         p.updateInventory();
/*    */         
/* 38 */         Location location = p.getEyeLocation();
/* 39 */         BlockIterator blocksToAdd = new BlockIterator(location, 0.0D, 40);
/* 40 */         while (blocksToAdd.hasNext()) {
/* 41 */           Location blockToAdd = blocksToAdd.next().getLocation();
/* 42 */           p.getWorld().playEffect(blockToAdd, org.bukkit.Effect.STEP_SOUND, Material.BEACON, 20);
/* 43 */           p.playSound(blockToAdd, Sound.IRONGOLEM_THROW, 3.0F, 3.0F);
/*    */         }
/* 45 */         Snowball h = (Snowball)p.launchProjectile(Snowball.class);
/* 46 */         Vector velo1 = p.getLocation().getDirection().normalize().multiply(10);
/* 47 */         h.setVelocity(velo1);
/* 48 */         h.setMetadata("hadouken", new FixedMetadataValue(Main.instance, Boolean.valueOf(true)));
/* 49 */         cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20L)));
/* 50 */         return;
/*    */       }
/* 52 */       p.sendMessage("§cAguarde o cooldown de " + TimeUnit.MILLISECONDS.toSeconds(((Long)cooldown.get(p.getName())).longValue() - System.currentTimeMillis()) + "§c segundos para usar novamente.");
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void dano(EntityDamageByEntityEvent e)
/*    */   {
/* 59 */     if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Snowball)))
/*    */     {
/* 61 */       Snowball s = (Snowball)e.getDamager();
/* 62 */       if (s.hasMetadata("hadouken")) {
/* 63 */         e.setDamage(e.getDamage() + 9.0D);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Ryu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */