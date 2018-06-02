/*     */ package br.nikao.kits;
/*     */ 
/*     */ import br.nikao.Main;
/*     */ import br.nikao.outros.KitAPI;
/*     */ import org.bukkit.Effect;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.block.BlockState;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ 
/*     */ public class Endermage implements org.bukkit.event.Listener
/*     */ {
/*     */   public static Main plugin;
/*     */   
/*     */   public Endermage(Main main)
/*     */   {
/*  24 */     plugin = main;
/*     */   }
/*     */   
/*     */ 
/*  28 */   String teleport = "§cCuidado, você foi puxado";
/*     */   
/*     */   public void TeleportP(Location portal, Player p1, Player p2)
/*     */   {
/*  32 */     p1.teleport(portal.clone().add(0.0D, 1.0D, 0.0D));
/*  33 */     p2.teleport(portal.clone().add(0.0D, 1.0D, 0.0D));
/*  34 */     p1.setNoDamageTicks(100);
/*  35 */     p2.setNoDamageTicks(100);
/*  36 */     p1.sendMessage(this.teleport);
/*  37 */     p2.sendMessage(this.teleport);
/*  38 */     p2.getWorld().playEffect(p2.getLocation(), Effect.ENDER_SIGNAL, 9);
/*  39 */     p1.getWorld().playEffect(portal, Effect.ENDER_SIGNAL, 9);
/*  40 */     p2.playSound(p2.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.2F);
/*  41 */     p1.playSound(portal, Sound.ENDERMAN_TELEPORT, 1.0F, 1.2F);
/*     */   }
/*     */   
/*     */   private boolean isEnderable(Location portal, Location player)
/*     */   {
/*  46 */     return (Math.abs(portal.getX() - player.getX()) < 3.0D) && (Math.abs(portal.getZ() - player.getZ()) < 3.0D) && (
/*  47 */       Math.abs(portal.getY() - player.getY()) >= 3.5D);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void EndermageInteract(PlayerInteractEvent e)
/*     */   {
/*  53 */     final Player mage = e.getPlayer();
/*  54 */     if ((e.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK) && 
/*  55 */       (mage.getItemInHand().getType() == Material.PORTAL) && 
/*  56 */       (KitAPI.getkit(mage) == "Endermage")) {
/*  57 */       e.setCancelled(true);
/*  58 */       mage.updateInventory();
/*  59 */       mage.setItemInHand(new ItemStack(Material.AIR));
/*  60 */       mage.updateInventory();
/*  61 */       final Block b = e.getClickedBlock();
/*     */       
/*  63 */       final Location bLoc = b.getLocation();
/*  64 */       final BlockState bs = b.getState();
/*     */       
/*  66 */       b.setType(Material.ENDER_PORTAL_FRAME);
/*     */       Player[] arrayOfPlayer;
/*  68 */       int j = (arrayOfPlayer = org.bukkit.Bukkit.getOnlinePlayers()).length;
/*  69 */       for (int i = 0; i < j; i++) {
/*  70 */         Player nearby = arrayOfPlayer[i];
/*     */         
/*  72 */         final Player target = nearby.getPlayer();
/*  73 */         new org.bukkit.scheduler.BukkitRunnable() {
/*  74 */           int time = 5;
/*     */           
/*     */           public void run() {
/*  77 */             this.time -= 1;
/*  78 */             if ((!target.getInventory().contains(Material.PORTAL)) && 
/*  79 */               (Endermage.this.isEnderable(bLoc, target.getLocation())) && 
/*  80 */               (target != mage) && 
/*  81 */               (!target.isDead())) {
/*  82 */               b.setType(bs.getType());
/*  83 */               b.setData(bs.getBlock().getData());
/*  84 */               cancel();
/*  85 */               Endermage.this.TeleportP(bLoc, mage, target);
/*  86 */               if ((!mage.getInventory().contains(new ItemStack(Material.PORTAL))) && 
/*  87 */                 (KitAPI.getkit(mage) == "Endermage")) {
/*  88 */                 mage.getInventory().addItem(new ItemStack[] { new ItemStack(Material.PORTAL) });
/*  89 */                 mage.updateInventory();
/*     */               }
/*     */             }
/*  92 */             else if (this.time == 0) {
/*  93 */               cancel();
/*  94 */               b.setType(bs.getType());
/*  95 */               b.setData(bs.getBlock().getData());
/*  96 */               if ((!mage.getInventory().contains(new ItemStack(Material.PORTAL))) && 
/*  97 */                 (KitAPI.getkit(mage) == "Endermage")) {
/*  98 */                 mage.getInventory().addItem(new ItemStack[] { new ItemStack(Material.PORTAL) });
/*  99 */                 mage.updateInventory();
/*     */               }
/*     */               
/*     */             }
/*     */           }
/* 104 */         }.runTaskTimer(plugin, 0L, 20L);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\kits\Endermage.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */