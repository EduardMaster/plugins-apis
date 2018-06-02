/*     */ package nobody.kit;
/*     */ 
/*     */ import java.util.Map;

/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.entity.PlayerLeashEntityEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerItemHeldEvent;
/*     */ import org.bukkit.event.player.PlayerMoveEvent;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ public class Grappler implements org.bukkit.event.Listener
/*     */ {
/*  21 */   @SuppressWarnings({ "unchecked", "rawtypes" })
Map<Player, Cordinha> hooks = new java.util.HashMap();
/*     */   
/*     */   @EventHandler
/*     */   public void onSlot(PlayerItemHeldEvent e)
/*     */   {
/*  26 */     if (this.hooks.containsKey(e.getPlayer()))
/*     */     {
/*  28 */       ((Cordinha)this.hooks.get(e.getPlayer())).remove();
/*  29 */       this.hooks.remove(e.getPlayer());
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void grapplerDamageNoLeash(EntityDamageEvent event)
/*     */   {
/*  36 */     if (!(event.getEntity() instanceof Player)) {
/*  37 */       return;
/*     */     }
/*  39 */     Player player = (Player)event.getEntity();
/*  40 */     if (event.getCause() != org.bukkit.event.entity.EntityDamageEvent.DamageCause.FALL) {
/*  41 */       return;
/*     */     }
/*  43 */     if ((this.hooks.containsKey(player)) && 
/*  44 */       (((Cordinha)this.hooks.get(player)).isHooked()) && 
/*  45 */       (event.getDamage() > 3.0D)) {
/*  46 */       event.setDamage(3.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onMove(PlayerMoveEvent e) {
/*  52 */     if ((this.hooks.containsKey(e.getPlayer())) && 
/*  53 */       (!e.getPlayer().getItemInHand().getType().equals(Material.LEASH))) {
/*  54 */       ((Cordinha)this.hooks.get(e.getPlayer())).remove();
/*  55 */       this.hooks.remove(e.getPlayer());
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onLeash(PlayerLeashEntityEvent e)
/*     */   {
/*  62 */     Player p = e.getPlayer();
/*  63 */     if (e.getPlayer().getItemInHand().getType().equals(Material.LEASH))
/*     */     {
/*  65 */       e.setCancelled(true);
/*  66 */       e.getPlayer().updateInventory();
/*  67 */       e.setCancelled(true);
/*  68 */       if (!this.hooks.containsKey(p)) {
/*  69 */         return;
/*     */       }
/*  71 */       if (!((Cordinha)this.hooks.get(p)).isHooked()) {
/*  72 */         return;
/*     */       }
/*  74 */       double d = ((Cordinha)this.hooks.get(p)).getBukkitEntity()
/*  75 */         .getLocation().distance(p.getLocation());
/*  76 */       double t = d;
/*  77 */       double v_x = (1.0D + 0.07D * t) * (
/*  78 */         ((Cordinha)this.hooks.get(p)).getBukkitEntity()
/*  79 */         .getLocation().getX() - p.getLocation().getX()) / t;
/*  80 */       double v_y = (1.0D + 0.03D * t) * (
/*  81 */         ((Cordinha)this.hooks.get(p)).getBukkitEntity()
/*  82 */         .getLocation().getY() - p.getLocation().getY()) / t;
/*  83 */       double v_z = (1.0D + 0.07D * t) * (
/*  84 */         ((Cordinha)this.hooks.get(p)).getBukkitEntity()
/*  85 */         .getLocation().getZ() - p.getLocation().getZ()) / t;
/*     */       
/*  87 */       Vector v = p.getVelocity();
/*  88 */       v.setX(v_x);
/*  89 */       v.setY(v_y);
/*  90 */       v.setZ(v_z);
/*  91 */       p.setVelocity(v);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onClick(PlayerInteractEvent e)
/*     */   {
/*  98 */     Player p = e.getPlayer();
/*  99 */     if (e.getPlayer().getItemInHand().getType().equals(Material.LEASH))
/*     */     {
/* 101 */       e.setCancelled(true);
/* 102 */       if ((e.getAction() == Action.LEFT_CLICK_AIR) || 
/* 103 */         (e.getAction() == Action.LEFT_CLICK_BLOCK))
/*     */       {
/* 105 */         if (this.hooks.containsKey(p)) {
/* 106 */           ((Cordinha)this.hooks.get(p)).remove();
/*     */         }
/* 108 */         Cordinha nmsHook = new Cordinha(p.getWorld(), 
/* 109 */           ((CraftPlayer)p).getHandle());
/* 110 */         nmsHook.spawn(p.getEyeLocation().add(
/* 111 */           p.getLocation().getDirection().getX(), 
/* 112 */           p.getLocation().getDirection().getY(), 
/* 113 */           p.getLocation().getDirection().getZ()));
/* 114 */         nmsHook.move(p.getLocation().getDirection().getX() * 5.0D, p
/* 115 */           .getLocation().getDirection().getY() * 5.0D, p
/* 116 */           .getLocation().getDirection().getZ() * 5.0D);
/* 117 */         this.hooks.put(p, nmsHook);
/*     */       }
/*     */       else
/*     */       {
/* 121 */         if (!this.hooks.containsKey(p)) {
/* 122 */           return;
/*     */         }
/* 124 */         if (!((Cordinha)this.hooks.get(p)).isHooked()) {
/* 125 */           return;
/*     */         }
/* 127 */         double d = ((Cordinha)this.hooks.get(p))
/* 128 */           .getBukkitEntity().getLocation()
/* 129 */           .distance(p.getLocation());
/* 130 */         double t = d;
/* 131 */         double v_x = (1.0D + 0.2D * t) * (
/* 132 */           ((Cordinha)this.hooks.get(p))
/* 133 */           .getBukkitEntity().getLocation().getX() - p
/* 134 */           .getLocation().getX()) / t;
/* 135 */         double v_y = (1.0D + 0.03D * t) * (
/* 136 */           ((Cordinha)this.hooks.get(p))
/* 137 */           .getBukkitEntity().getLocation().getY() - p
/* 138 */           .getLocation().getY()) / t;
/* 139 */         double v_z = (1.0D + 0.2D * t) * (
/* 140 */           ((Cordinha)this.hooks.get(p))
/* 141 */           .getBukkitEntity().getLocation().getZ() - p
/* 142 */           .getLocation().getZ()) / t;
/*     */         
/* 144 */         Vector v = p.getVelocity();
/* 145 */         v.setX(v_x);
/* 146 */         v.setY(v_y);
/* 147 */         v.setZ(v_z);
/* 148 */         p.setVelocity(v);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Grappler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */