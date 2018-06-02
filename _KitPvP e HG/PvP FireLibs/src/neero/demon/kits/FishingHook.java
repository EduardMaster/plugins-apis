/*    */ package neero.demon.kits;
/*    */ 
/*    */ import net.minecraft.server.v1_7_R4.EntityFishingHook;
/*    */ import net.minecraft.server.v1_7_R4.EntityHuman;
/*    */ import net.minecraft.server.v1_7_R4.Item;
/*    */ import net.minecraft.server.v1_7_R4.ItemStack;
/*    */ import net.minecraft.server.v1_7_R4.World;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftEntity;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class FishingHook extends EntityFishingHook
/*    */ {
/*    */   private Item item;
/*    */   
/*    */   public FishingHook(Player player, Item item2)
/*    */   {
/* 21 */     super(((CraftWorld)player.getWorld()).getHandle(), ((CraftPlayer)player).getHandle());
/* 22 */     item2 = this.item = item2;
/*    */   }
/*    */   
/*    */   public void h()
/*    */   {
/* 27 */     if (this.item != null)
/*    */     {
/* 29 */       ItemStack hand = this.owner.be();
/* 30 */       boolean shouldRemove = false;
/* 31 */       if ((this.owner.dead) || (!this.owner.isAlive())) {
/* 32 */         shouldRemove = true;
/*    */       }
/* 34 */       if (hand == null) {
/* 35 */         shouldRemove = true;
/* 36 */       } else if (hand.getItem() != this.item) {
/* 37 */         shouldRemove = true;
/*    */       }
/* 39 */       if (e(this.owner) > 1024.0D) {
/* 40 */         shouldRemove = true;
/*    */       }
/* 42 */       if (shouldRemove)
/*    */       {
/* 44 */         super.die();
/* 45 */         this.owner.hookedFish = null;
/*    */       }
/*    */     }
/* 48 */     super.h();
/*    */   }
/*    */   
/*    */   public void spawn(Player player, Location loc)
/*    */   {
/* 53 */     World nmsWorld = ((CraftWorld)loc.getWorld()).getHandle();
/* 54 */     nmsWorld.addEntity(this);
/* 55 */     setPosition(loc.getX() + 5.0D, loc.getY(), loc.getZ() + 5.0D);
/* 56 */     Vector v = getBukkitEntity().getMomentum();
/* 57 */     v.multiply(2);
/* 58 */     getBukkitEntity().setVelocity(v);
/* 59 */     getBukkitEntity().getLocation().setY(getBukkitEntity().getLocation().getY() - 10.0D);
/* 60 */     Test.rod.put(player, this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\FishingHook.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */