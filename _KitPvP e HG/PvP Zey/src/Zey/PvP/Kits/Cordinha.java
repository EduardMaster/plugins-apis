package Zey.PvP.Kits;

import org.bukkit.event.*;

import Zey.PvP.Main.*;

import org.bukkit.craftbukkit.v1_7_R4.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;
import net.minecraft.server.v1_7_R4.*;

public class Cordinha extends EntityFishingHook implements Listener
{
    private Snowball sb;
    private EntitySnowball controller;
    public int a;
    public EntityHuman owner;
    public org.bukkit.entity.Entity hooked;
    public boolean lastControllerDead;
    public boolean isHooked;
    
    public void Grappler(final Main plugin) {
    }
    
    public Cordinha(final World world, final EntityHuman entityhuman) {
        super((net.minecraft.server.v1_7_R4.World)((CraftWorld)world).getHandle(), entityhuman);
        this.owner = entityhuman;
    }
    
    protected void c() {
    }
    
    public void h() {
        if (!this.lastControllerDead) {
        }
        this.lastControllerDead = this.controller.dead;
        for (final org.bukkit.entity.Entity entity : this.controller.world.getWorld().getEntities()) {
            if (!(entity instanceof Firework) && entity.getEntityId() != this.getBukkitEntity().getEntityId() && entity.getEntityId() != this.owner.getBukkitEntity().getEntityId() && entity.getEntityId() != this.controller.getBukkitEntity().getEntityId()) {
                if (entity.getLocation().distance(this.controller.getBukkitEntity().getLocation()) >= 2.0) {
                    if (!(entity instanceof Player)) {
                        continue;
                    }
                    ((Player)entity).getEyeLocation().distance(this.controller.getBukkitEntity().getLocation());
                }
                else {
                    this.controller.die();
                    this.hooked = entity;
                    this.isHooked = true;
                    this.locX = entity.getLocation().getX();
                    this.locY = entity.getLocation().getY();
                    this.locZ = entity.getLocation().getZ();
                    this.motX = 0.0;
                    this.motY = 0.04;
                    this.motZ = 0.0;
                }
            }
        }
        try {
            this.locX = this.hooked.getLocation().getX();
            this.locY = this.hooked.getLocation().getY();
            this.locZ = this.hooked.getLocation().getZ();
            this.motX = 0.0;
            this.motY = 0.04;
            this.motZ = 0.0;
            this.isHooked = true;
        }
        catch (Exception e) {
            if (this.controller.dead) {
                this.isHooked = true;
            }
            this.locX = this.controller.locX;
            this.locY = this.controller.locY;
            this.locZ = this.controller.locZ;
        }
    }
    
    public void die() {
    }
    
	@SuppressWarnings("deprecation")
	public void spawn(final Location location) {
        this.sb = (Snowball)this.owner.getBukkitEntity().launchProjectile((Class<? extends Projectile>)Snowball.class);
        this.controller = ((CraftSnowball)this.sb).getHandle();
        final PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(new int[] { this.controller.getId() });
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player p = onlinePlayers[i];
            ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)packet);
        }
        ((CraftWorld)location.getWorld()).getHandle().addEntity((net.minecraft.server.v1_7_R4.Entity)this);
    }
    
    public void remove() {
        super.die();
    }
    
    public boolean isHooked() {
        return this.isHooked;
    }
    
    public void setHookedEntity(final org.bukkit.entity.Entity nodamage) {
        this.hooked = nodamage;
    }
}
