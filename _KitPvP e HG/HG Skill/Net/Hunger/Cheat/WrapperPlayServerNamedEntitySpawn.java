package Net.Hunger.Cheat;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.injector.PacketConstructor;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.google.common.base.Preconditions;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class WrapperPlayServerNamedEntitySpawn
  extends AbstractPacket
{
  public static final PacketType TYPE = PacketType.Play.Server.NAMED_ENTITY_SPAWN;
  private static PacketConstructor entityConstructor;
  
  public WrapperPlayServerNamedEntitySpawn()
  {
    super(new PacketContainer(TYPE), TYPE);
    this.handle.getModifier().writeDefaults();
  }
  
  public WrapperPlayServerNamedEntitySpawn(PacketContainer packet)
  {
    super(packet, TYPE);
  }
  
  public WrapperPlayServerNamedEntitySpawn(Player player)
  {
    super(fromPlayer(player), TYPE);
  }
  
  private static PacketContainer fromPlayer(Player player)
  {
    if (entityConstructor == null) {
      entityConstructor = ProtocolLibrary.getProtocolManager().createPacketConstructor(TYPE, new Object[] { player });
    }
    return entityConstructor.createPacket(new Object[] { player });
  }
  
  public int getEntityID()
  {
    return ((Integer)this.handle.getIntegers().read(0)).intValue();
  }
  
  public void setEntityID(int value)
  {
    this.handle.getIntegers().write(0, Integer.valueOf(value));
  }
  
  public Entity getEntity(World world)
  {
    return (Entity)this.handle.getEntityModifier(world).read(0);
  }
  
  public Entity getEntity(PacketEvent event)
  {
    return getEntity(event.getPlayer().getWorld());
  }
  
  public String getPlayerName()
  {
    WrappedGameProfile profile = getProfile();
    return profile != null ? profile.getName() : null;
  }
  
  public void setPlayerName(String value)
  {
    if ((value != null) && (value.length() > 16)) {
      throw new IllegalArgumentException("Maximum player name lenght is 16 characters.");
    }
    setProfile(new WrappedGameProfile(getPlayerUUID(), value));
  }
  
  public String getPlayerUUID()
  {
    WrappedGameProfile profile = getProfile();
    return profile != null ? profile.getId() : null;
  }
  
  public void setPlayerUUID(String uuid)
  {
    setProfile(new WrappedGameProfile(uuid, getPlayerName()));
  }
  
  public WrappedGameProfile getProfile()
  {
    return (WrappedGameProfile)this.handle.getGameProfiles().read(0);
  }
  
  public void setProfile(WrappedGameProfile value)
  {
    this.handle.getGameProfiles().write(0, value);
  }
  
  public Vector getPosition()
  {
    return new Vector(getX(), getY(), getZ());
  }
  
  public void setPosition(Vector position)
  {
    setX(position.getX());
    setY(position.getY());
    setZ(position.getZ());
  }
  
  public double getX()
  {
    return ((Integer)this.handle.getIntegers().read(1)).intValue() / 32.0D;
  }
  
  public void setX(double value)
  {
    this.handle.getIntegers().write(1, Integer.valueOf((int)Math.floor(value * 32.0D)));
  }
  
  public double getY()
  {
    return ((Integer)this.handle.getIntegers().read(2)).intValue() / 32.0D;
  }
  
  public void setY(double value)
  {
    this.handle.getIntegers().write(2, Integer.valueOf((int)Math.floor(value * 32.0D)));
  }
  
  public double getZ()
  {
    return ((Integer)this.handle.getIntegers().read(3)).intValue() / 32.0D;
  }
  
  public void setZ(double value)
  {
    this.handle.getIntegers().write(3, Integer.valueOf((int)Math.floor(value * 32.0D)));
  }
  
  public float getYaw()
  {
    return ((Byte)this.handle.getBytes().read(0)).byteValue() * 360.0F / 256.0F;
  }
  
  public void setYaw(float value)
  {
    this.handle.getBytes().write(0, Byte.valueOf((byte)(int)(value * 256.0F / 360.0F)));
  }
  
  public float getPitch()
  {
    return ((Byte)this.handle.getBytes().read(1)).byteValue() * 360.0F / 256.0F;
  }
  
  public void setPitch(float value)
  {
    this.handle.getBytes().write(1, Byte.valueOf((byte)(int)(value * 256.0F / 360.0F)));
  }
  
  public short getCurrentItem()
  {
    return ((Integer)this.handle.getIntegers().read(4)).shortValue();
  }
  
  public void setCurrentItem(short value)
  {
    this.handle.getIntegers().write(4, Integer.valueOf(value));
  }
  
  public WrappedDataWatcher getMetadata()
  {
    return (WrappedDataWatcher)this.handle.getDataWatcherModifier().read(0);
  }
  
  public void setMetadata(WrappedDataWatcher value)
  {
    this.handle.getDataWatcherModifier().write(0, value);
  }
  
  public PacketContainer getHandle()
  {
    Preconditions.checkNotNull(getPlayerName(), "Must specify a player name.");
    Preconditions.checkNotNull(getPlayerUUID(), "Must specify a player UUID.");
    return super.getHandle();
  }
}