/*     */ package nobody.kit;
/*     */ 
/*     */ import net.minecraft.server.v1_7_R4.EntityFishingHook;
/*     */ import net.minecraft.server.v1_7_R4.EntityHuman;
/*     */ import net.minecraft.server.v1_7_R4.EntitySnowball;
/*     */ import net.minecraft.server.v1_7_R4.PacketPlayOutEntityDestroy;
import nobody.main.Main;

/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftSnowball;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.entity.Snowball;
/*     */ 
/*     */ public class Cordinha extends EntityFishingHook implements org.bukkit.event.Listener
/*     */ {
/*     */   private Snowball sb;
/*     */   private EntitySnowball controller;
/*     */   public int a;
/*     */   public EntityHuman owner;
/*     */   public Entity hooked;
/*     */   public boolean lastControllerDead;
/*     */   public boolean isHooked;
/*     */   
/*     */   public void Grappler(Main plugin) {}
/*     */   
/*     */   public Cordinha(org.bukkit.World world, EntityHuman entityhuman)
/*     */   {
/*  34 */     super(((CraftWorld)world).getHandle(), entityhuman);
/*  35 */     this.owner = entityhuman;
/*     */   }
/*     */   
/*     */   protected void c() {}
/*     */   
/*     */   public void h()
/*     */   {
/*  42 */     this.lastControllerDead = this.controller.dead;
/*  43 */     for (Entity entity : this.controller.world.getWorld().getEntities()) {
/*  44 */       if ((!(entity instanceof org.bukkit.entity.Firework)) && 
/*  45 */         (entity.getEntityId() != getBukkitEntity().getEntityId()) && 
/*  46 */         (entity.getEntityId() != this.owner.getBukkitEntity()
/*  47 */         .getEntityId())) {
/*  48 */         if (entity.getEntityId() != this.controller
/*  49 */           .getBukkitEntity().getEntityId()) {
/*  50 */           if (entity.getLocation().distance(this.controller.getBukkitEntity().getLocation()) >= 2.0D)
/*     */           {
/*  52 */             if ((entity instanceof Player)) {
/*  53 */               ((Player)entity).getEyeLocation().distance(this.controller.getBukkitEntity().getLocation());
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/*  58 */             this.controller.die();
/*  59 */             this.hooked = entity;
/*  60 */             this.isHooked = true;
/*  61 */             this.locX = entity.getLocation().getX();
/*  62 */             this.locY = entity.getLocation().getY();
/*  63 */             this.locZ = entity.getLocation().getZ();
/*  64 */             this.motX = 0.0D;
/*  65 */             this.motY = 0.04D;
/*  66 */             this.motZ = 0.0D;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     try
/*     */     {
/*  73 */       this.locX = this.hooked.getLocation().getX();
/*  74 */       this.locY = this.hooked.getLocation().getY();
/*  75 */       this.locZ = this.hooked.getLocation().getZ();
/*  76 */       this.motX = 0.0D;
/*  77 */       this.motY = 0.04D;
/*  78 */       this.motZ = 0.0D;
/*  79 */       this.isHooked = true;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  83 */       if (this.controller.dead) {
/*  84 */         this.isHooked = true;
/*     */       }
/*  86 */       this.locX = this.controller.locX;
/*  87 */       this.locY = this.controller.locY;
/*  88 */       this.locZ = this.controller.locZ;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void die() {}
/*     */   
/*     */   @SuppressWarnings("deprecation")
public void spawn(Location location)
/*     */   {
/*  97 */     this.sb = ((Snowball)this.owner.getBukkitEntity().launchProjectile(
/*  98 */       Snowball.class));
/*  99 */     this.controller = ((CraftSnowball)this.sb).getHandle();
/*     */     
/* 101 */     PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(
/* 102 */       new int[] { this.controller.getId() });
/*     */     Player[] arrayOfPlayer;
/* 104 */     int j = (arrayOfPlayer = org.bukkit.Bukkit.getOnlinePlayers()).length;
/* 105 */     for (int i = 0; i < j; i++)
/*     */     {
/* 107 */       Player p = arrayOfPlayer[i];
/*     */       
/* 109 */       ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
/* 110 */       p.getWorld().playSound(p.getLocation(), org.bukkit.Sound.STEP_GRAVEL, 1.0F, 
/* 111 */         1.0F);
/*     */     }
/* 113 */     ((CraftWorld)location.getWorld()).getHandle().addEntity(this);
/*     */   }
/*     */   
/*     */   public void remove()
/*     */   {
/* 118 */     super.die();
/*     */   }
/*     */   
/*     */   public boolean isHooked()
/*     */   {
/* 123 */     return this.isHooked;
/*     */   }
/*     */   
/*     */   public void setHookedEntity(Entity nodamage)
/*     */   {
/* 128 */     this.hooked = nodamage;
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Kits\Cordinha.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */