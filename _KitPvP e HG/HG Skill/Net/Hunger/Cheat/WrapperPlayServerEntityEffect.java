package Net.Hunger.Cheat;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class WrapperPlayServerEntityEffect
  extends AbstractPacket
{
  public static final PacketType TYPE = PacketType.Play.Server.ENTITY_EFFECT;
  
  public WrapperPlayServerEntityEffect()
  {
    super(new PacketContainer(TYPE), TYPE);
    this.handle.getModifier().writeDefaults();
  }
  
  public WrapperPlayServerEntityEffect(PacketContainer packet)
  {
    super(packet, TYPE);
  }
  
  public int getEntityId()
  {
    return ((Integer)this.handle.getIntegers().read(0)).intValue();
  }
  
  public void setEntityId(int value)
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
  
  public byte getEffectId()
  {
    return ((Byte)this.handle.getBytes().read(0)).byteValue();
  }
  
  public void setEffectId(byte value)
  {
    this.handle.getBytes().write(0, Byte.valueOf(value));
  }
  
  public PotionEffectType getEffect()
  {
    return PotionEffectType.getById(getEffectId());
  }
  
  public void setEffect(PotionEffectType value)
  {
    setEffectId((byte)value.getId());
  }
  
  public byte getAmplifier()
  {
    return ((Byte)this.handle.getBytes().read(1)).byteValue();
  }
  
  public void setAmplifier(byte value)
  {
    this.handle.getBytes().write(1, Byte.valueOf(value));
  }
  
  public short getDuration()
  {
    return ((Short)this.handle.getShorts().read(0)).shortValue();
  }
  
  public void setDuration(short value)
  {
    this.handle.getShorts().write(0, Short.valueOf(value));
  }
}