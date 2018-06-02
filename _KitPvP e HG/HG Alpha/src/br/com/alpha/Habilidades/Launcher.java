/*  1:   */ package br.com.alpha.Habilidades;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;

/*  5:   */ import org.bukkit.Effect;
/*  6:   */ import org.bukkit.Location;
/*  7:   */ import org.bukkit.Material;
/*  8:   */ import org.bukkit.Sound;
/* 11:   */ import org.bukkit.entity.Player;
/* 12:   */ import org.bukkit.event.EventHandler;
/* 13:   */ import org.bukkit.event.Listener;
/* 14:   */ import org.bukkit.event.entity.EntityDamageEvent;
/* 16:   */ import org.bukkit.event.player.PlayerMoveEvent;
/* 17:   */ import org.bukkit.util.Vector;
/* 18:   */ 
/* 19:   */ public class Launcher
/* 20:   */   implements Listener
/* 21:   */ {

/* 28:   */   
/* 29:26 */   @SuppressWarnings({ "unchecked", "rawtypes" })
protected ArrayList<String> dano = new ArrayList();
/* 30:   */   
/* 31:   */   @SuppressWarnings("deprecation")
@EventHandler
/* 32:   */   public void onPlayerMove(PlayerMoveEvent event)
/* 33:   */   {
/* 34:32 */     Player player = event.getPlayer();
/* 35:33 */     Location standBlock = player.getWorld().getBlockAt(player.getLocation().add(0.0D, -0.01D, 0.0D)).getLocation();
/* 36:34 */     if (standBlock.getBlock().getType() == Material.SPONGE)
/* 37:   */     {
/* 38:36 */       int xblock = 0;
/* 39:37 */       double xvel = 0.0D;
/* 40:38 */       int yblock = -1;
/* 41:39 */       double yvel = 0.0D;
/* 42:40 */       int zblock = 0;
/* 43:41 */       double zvel = 0.0D;
/* 44:42 */       while (standBlock.getBlock().getLocation()
/* 45:43 */         .add(xblock - 1, -1.0D, 0.0D).getBlock().getType() == Material.SPONGE)
/* 46:   */       {
/* 47:45 */         xblock--;
/* 48:46 */         xvel += 1.0D;
/* 49:   */       }
/* 50:48 */       while (standBlock.getBlock().getLocation().add(0.0D, yblock, 0.0D).getBlock().getType() == Material.SPONGE)
/* 51:   */       {
/* 52:50 */         yblock--;
/* 53:51 */         yvel += 0.7D;
/* 54:   */       }
/* 55:53 */       while (standBlock.getBlock().getLocation()
/* 56:54 */         .add(0.0D, -1.0D, zblock - 1).getBlock().getType() == Material.SPONGE)
/* 57:   */       {
/* 58:56 */         zblock--;
/* 59:57 */         zvel += 1.0D;
/* 60:   */       }
/* 61:59 */       xblock = 0;
/* 62:60 */       zblock = 0;
/* 63:61 */       while (standBlock.getBlock().getLocation()
/* 64:62 */         .add(xblock + 1, -1.0D, 0.0D).getBlock().getType() == Material.SPONGE)
/* 65:   */       {
/* 66:64 */         xblock++;
/* 67:65 */         xvel -= 1.0D;
/* 68:   */       }
/* 69:67 */       while (standBlock.getBlock().getLocation()
/* 70:68 */         .add(0.0D, -1.0D, zblock + 1).getBlock().getType() == Material.SPONGE)
/* 71:   */       {
/* 72:70 */         zblock++;
/* 73:71 */         zvel -= 1.0D;
/* 74:   */       }
/* 75:73 */       if ((xvel != 0.0D) || (yvel != 0.0D) || (zvel != 0.0D))
/* 76:   */       {
/* 77:75 */         player.setVelocity(new Vector(xvel, yvel, zvel));
/* 78:76 */         player.playSound(player.getLocation(), Sound.ENDERDRAGON_HIT, 5.0F, -5.0F);
/* 79:77 */         player.playEffect(player.getLocation(), Effect.SMOKE, 10);
/* 80:78 */         if (!this.dano.contains(player.getName())) {
/* 81:79 */           this.dano.add(player.getName());
/* 82:   */         }
/* 83:   */       }
/* 84:   */     }
/* 85:   */   }
/* 86:   */   
/* 87:   */   @EventHandler
/* 88:   */   public void onEntityDamage(EntityDamageEvent event)
/* 89:   */   {
/* 90:88 */     if ((event.getEntity() instanceof Player))
/* 91:   */     {
/* 92:90 */       Player player = (Player)event.getEntity();
/* 93:91 */       if ((this.dano.contains(player.getName())) && (event.getCause().equals(EntityDamageEvent.DamageCause.FALL)))
/* 94:   */       {
/* 95:93 */         event.setCancelled(true);
/* 96:94 */         this.dano.remove(player.getName());
/* 97:   */       }
/* 98:   */     }
/* 99:   */   }
/* :0:   */ }
