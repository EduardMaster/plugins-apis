package Net.Hunger.Cheat;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.EnumWrappers.EntityUseAction;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class WrapperPlayClientUseEntity
  extends AbstractPacket
{
  public static final PacketType TYPE = PacketType.Play.Client.USE_ENTITY;
  
  public WrapperPlayClientUseEntity()
  {
    super(new PacketContainer(TYPE), TYPE);
    this.handle.getModifier().writeDefaults();
  }
  
  public WrapperPlayClientUseEntity(PacketContainer packet)
  {
    super(packet, TYPE);
  }
  
  public int getTargetID()
  {
    return ((Integer)this.handle.getIntegers().read(0)).intValue();
  }
  
  public Entity getTarget(World world)
  {
    return (Entity)this.handle.getEntityModifier(world).read(0);
  }
  
  public Entity getTarget(PacketEvent event)
  {
    return getTarget(event.getPlayer().getWorld());
  }
  
  public void setTargetID(int value)
  {
    this.handle.getIntegers().write(0, Integer.valueOf(value));
  }
  
  public EnumWrappers.EntityUseAction getMouse()
  {
    return (EnumWrappers.EntityUseAction)this.handle.getEntityUseActions().read(0);
  }
  
  public void setMouse(EnumWrappers.EntityUseAction value)
  {
    this.handle.getEntityUseActions().write(0, value);
  }
}