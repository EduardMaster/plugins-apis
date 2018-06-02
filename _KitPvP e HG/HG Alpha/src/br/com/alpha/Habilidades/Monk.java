/*  1:   */ package br.com.alpha.Habilidades;
/*  2:   */ 
/*  3:   */ import java.util.HashMap;
/*  4:   */ import java.util.Random;

/*  7:   */ import org.bukkit.ChatColor;
/*  8:   */ import org.bukkit.Material;
/* 10:   */ import org.bukkit.entity.EntityType;
/* 11:   */ import org.bukkit.entity.Player;
/* 12:   */ import org.bukkit.event.EventHandler;
/* 13:   */ import org.bukkit.event.Listener;
/* 14:   */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/* 15:   */ import org.bukkit.inventory.ItemStack;
/* 16:   */ import org.bukkit.inventory.PlayerInventory;

import br.com.alpha.ENUMs.KitsEnum;
/* 17:   */ 
/* 18:   */ public class Monk
/* 19:   */   implements Listener
/* 20:   */ {
/* 21:20 */   public String monkCooldownMessagem = "§7Voce ainda está em cooldown.";
/* 22:21 */   public String Acertouomonk = "§7Voce desarmou seu oponente!";
/* 23:22 */   public boolean randominv = true;
/* 24:23 */   @SuppressWarnings({ "unchecked", "rawtypes" })
private transient HashMap<ItemStack, Long> monkL = new HashMap();
/* 25:24 */   public int cooldown = 15;
/* 26:25 */   public int mcooldown = 15;
/* 27:   */   
@SuppressWarnings("deprecation")
/* 28:   */   @EventHandler
/* 29:   */   public void onRightClick1(PlayerInteractEntityEvent event)
/* 30:   */   {
/* 31:31 */     ItemStack item = event.getPlayer().getItemInHand();
/* 32:32 */     Player Player = event.getPlayer();
/* 33:33 */     if ((KitsEnum.getKit(Player)==KitsEnum.MONK) && 
/* 34:34 */       (Player.getItemInHand().getType() == Material.BLAZE_ROD) && 
/* 35:35 */       (event.getRightClicked().getType() == EntityType.PLAYER))
/* 36:   */     {
/* 37:37 */       long lastUsed = 0L;
/* 38:38 */       if (this.monkL.containsKey(item)) {
/* 39:39 */         lastUsed = ((Long)this.monkL.get(item)).longValue();
/* 40:   */       }
/* 41:41 */       if (lastUsed + 1000 * this.mcooldown > System.currentTimeMillis())
/* 42:   */       {
/* 43:43 */         event.getPlayer().sendMessage(
/* 44:44 */           String.format(this.monkCooldownMessagem, new Object[] {
/* 45:45 */           Long.valueOf(-((System.currentTimeMillis() - (lastUsed + 1000 * this.cooldown)) / 1000L)) }));
/* 46:   */       }
/* 47:   */       else
/* 48:   */       {
/* 49:49 */         PlayerInventory inv = ((Player)event.getRightClicked()).getInventory();
/* 50:50 */         int slot = new Random().nextInt(this.randominv ? 36 : 9);
/* 51:51 */         ItemStack replaced = inv.getItemInHand();
/* 52:52 */         if (replaced == null) {
/* 53:53 */           replaced = new ItemStack(0);
/* 54:   */         }
/* 55:55 */         ItemStack replacer = inv.getItem(slot);
/* 56:56 */         if (replacer == null) {
/* 57:57 */           replacer = new ItemStack(0);
/* 58:   */         }
/* 59:59 */         inv.setItemInHand(replacer);
/* 60:60 */         inv.setItem(slot, replaced);
/* 61:61 */         this.monkL.put(item, Long.valueOf(System.currentTimeMillis()));
/* 62:62 */         event.getPlayer().sendMessage(ChatColor.GREEN + this.Acertouomonk);
/* 63:   */       }
/* 64:   */     }
/* 65:   */   }
/* 66:   */ }